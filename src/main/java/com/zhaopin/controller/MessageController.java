package com.zhaopin.controller;

import com.alibaba.fastjson.JSON;
import com.zhaopin.core.common.*;
import com.zhaopin.core.utils.CommonUtil;
import com.zhaopin.dto.NeteaseMessageDto;
import com.zhaopin.dto.PlatFormReceiveMessageDto;
import com.zhaopin.dto.ReceiveBodyDto;
import com.zhaopin.entity.Discussion;
import com.zhaopin.enums.NeteaseConvTypeEnum;
import com.zhaopin.enums.NeteaseEventTypeEnum;
import com.zhaopin.enums.NeteaseMsgTypeEnum;
import com.zhaopin.service.IMessageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * 云信消息抄送接口
 * 接收云信抄送的消息发送给平台
 * 仅限文本/图片/自定义消息
 *
 * Created by SYJ on 2017/4/13.
 */
@RestController
@RequestMapping("/ihr/imcc")
public class MessageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    @Autowired
    private IMessageService messageService;
    /**
     * 发送消息
     * @param request
     * @return
     */
    @PostMapping("/sendMsg")
    public ServerResponse sendMsg (HttpServletRequest request) {
        ServerResponse result;
        try {
            // 获取请求体
            byte[] body = readBody(request);
            if (body == null) {
                result = ServerResponse.createByErrorMessage("请求body不能为空");
                LOGGER.error("云信消息抄送接口-MessageController-sendMsg-请求body为空, 返回结果[result={}]", JSON.toJSONString(result));
                return result;
            }
            String requestBody = new String(body, Constants.ENCODE_CHARSET);
            LOGGER.info("云信消息抄送接口-MessageController-sendMsg-请求body[body={}]", requestBody);

            // TODO 校验md5和checkSum
            if (!checkMsg(request, requestBody)) {
                result = ServerResponse.createByErrorMessage("校验md5,checkSum失败");
                LOGGER.error("云信消息抄送接口-MessageController-sendMsg-校验md5,checkSum失败, 返回结果[result={}]", JSON.toJSONString(result));
                return result;
            }

            NeteaseMessageDto neteaseMessageDto = JSON.parseObject(requestBody, NeteaseMessageDto.class);
            if (neteaseMessageDto == null) {
                result = ServerResponse.createByErrorMessage("requestBody转NeteaseMessageDto失败");
                LOGGER.error("云信消息抄送接口-MessageController-sendMsg-requestBody转NeteaseMessageDto失败, 返回结果[result={}]", JSON.toJSONString(result));
                return result;
            }

            //校验EventType
            if (!NeteaseEventTypeEnum.CONVERSATION.getValue().equals(Integer.valueOf(neteaseMessageDto.getEventType()))) {
                result = ServerResponse.createBySuccessMessage("忽略非会话类型[eventType!=1]的消息");
                LOGGER.info("云信消息抄送接口-MessageController-sendMsg-忽略消息类型(忽略eventType!=1即非会话类型的消息), [eventType={}], 返回结果[result={}]", neteaseMessageDto.getEventType(), JSON.toJSONString(result));
                return result;
            }

            /**
             * 校验ConvType
             * 共4种类型:PERSON,TEAM,CUSTOM_PERSON,CUSTOM_TEAM
             * 只发送PERSON、TEAM这两种类型的消息
             */
            String convType = neteaseMessageDto.getConvType();
            if (!NeteaseConvTypeEnum.PERSON.name().equals(convType) && !NeteaseConvTypeEnum.TEAM.name().equals(convType)) {
                result = ServerResponse.createBySuccessMessage("忽略convType不是PERSON、TEAM的消息");
                LOGGER.info("云信消息抄送接口-MessageController-sendMsg-忽略消息类型(忽略convType不是PERSON、TEAM的消息), [convType={}], 返回结果[result={}]", convType, JSON.toJSONString(result));
                return result;
            }

            /**
             * 校验MsgType
             * 只发送文本TEXT,自定义消息CUSTOM,图片PICTURE这3种类型的消息
             */
            String msgType = neteaseMessageDto.getMsgType();
            if (!NeteaseMsgTypeEnum.TEXT.name().equals(msgType) && !NeteaseMsgTypeEnum.CUSTOM.name().equals(msgType) && !NeteaseMsgTypeEnum.PICTURE.name().equals(msgType)) {
                result = ServerResponse.createBySuccessMessage("忽略msgType不是TEXT,PICTUR和ECUSTOM的消息");
                LOGGER.info("云信消息抄送接口-MessageController-sendMsg-忽略消息类型(忽略msgType不是TEXT,PICTUR和ECUSTOM的消息), [msgType={}], 返回结果[result={}]", msgType, JSON.toJSONString(result));
                return result;
            }

            long fromId = 0;//发送者id
            long toId = 0;//接受者id
            try {
                fromId = Long.parseLong(neteaseMessageDto.getFromAccount());
                toId = Long.parseLong(neteaseMessageDto.getTo());
            } catch (NumberFormatException ex) {
                LOGGER.error("云信消息抄送接口-MessageController-sendMsg-消息发送者[fromAccount]和消息接收者[to]无法转换成long类型, 消息发送者[fromAccount={}], 消息接收者[to={}], 异常信息[{}]", neteaseMessageDto.getFromAccount(), neteaseMessageDto.getTo(), CommonUtil.getExceptionAllinformation(ex));
            }

            if (fromId <= 0 || toId <= 0) {
                result = ServerResponse.createByErrorMessage("fromAccount或者to必须是long类型且大于0");
                LOGGER.info("云信消息抄送接口-MessageController-sendMsg-fromAccount或者to必须是long类型且大于0, 消息发送者[fromAccount={}], 消息接收者[to={}], 返回结果[result={}]", neteaseMessageDto.getFromAccount(), neteaseMessageDto.getTo(), JSON.toJSONString(result));
                return result;
            }

            //获取讨论组信息(先查redis缓存,再查DB)
            Discussion discussion = messageService.getDiscussion(fromId, toId);
            if (discussion == null) {
                //创建讨论组
                discussion = messageService.createDiscussion(neteaseMessageDto);
                if (discussion == null || (discussion != null && discussion.getDiscussionid() <= 0)) {
                    result = ServerResponse.createByErrorMessage("创建讨论组失败");
                    LOGGER.info("云信消息抄送接口-MessageController-sendMsg-创建讨论组失败, 参数[neteaseMessageDto={}], 讨论组信息[discussion={}]返回结果[result={}]", JSON.toJSONString(neteaseMessageDto), JSON.toJSONString(discussion), JSON.toJSONString(result));
                    return result;
                }

                /**
                 * 保存讨论组信息到DB(并写入redis缓存)
                 */
                messageService.saveDiscussion(discussion);
            }

            //发送消息
            PlatFormReceiveMessageDto platFormReceiveMessageDto = messageService.sendMsg(neteaseMessageDto, discussion.getDiscussionid());
            if (platFormReceiveMessageDto == null) {
                result = ServerResponse.createByErrorMessage("消息发送失败,发送消息接口返回null");
                LOGGER.info("云信消息抄送接口-MessageController-sendMsg-消息发送失败,发送消息接口返回null, 参数[neteaseMessageDto={}], 讨论组信息[discussion={}]返回结果[result={}]", JSON.toJSONString(neteaseMessageDto), JSON.toJSONString(discussion), JSON.toJSONString(result));
                return result;
            }
            //从body部分获取状态码code
            ReceiveBodyDto receiveBodyDto = JSON.parseObject(platFormReceiveMessageDto.getBody(), ReceiveBodyDto.class);
            //只有body中的code=200才表示消息发送成功
            if (receiveBodyDto != null && receiveBodyDto.getCode() == 200) {
                result = ServerResponse.createBySuccessMessage("消息发送成功");
                LOGGER.info("云信消息抄送接口-MessageController-sendMsg-消息发送成功, MessageService返回[receiveMessageDto={}], 返回[result={}]", JSON.toJSONString(platFormReceiveMessageDto), JSON.toJSONString(result));
                return result;
            } else {
                result = ServerResponse.createByErrorMessage("消息发送失败");
                LOGGER.error("云信消息抄送接口-MessageController-sendMsg-消息发送失败, MessageService返回[receiveMessageDto={}], 返回[result={}]", JSON.toJSONString(platFormReceiveMessageDto), JSON.toJSONString(result));
                return result;
            }
        } catch (Exception ex) {
            result = ServerResponse.createByErrorMessage("消息发送抛出异常");
            LOGGER.error("云信消息抄送接口-MessageController-sendMsg-消息发送抛出异常,返回结果[result={}], 异常信息[{}]", JSON.toJSONString(result), CommonUtil.getExceptionAllinformation(ex));
            return result;
        }
    }

    /**
     * 获取MD5,CheckSum以及CurTime
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/getCheckInfo")
    public String getCheckInfo(HttpServletRequest request) throws IOException {
        String curTime = String.valueOf(new Date().getTime());
        // 获取请求体
        byte[] body = readBody(request);
        if (body == null) {
            return new JsonResult().JsonFail("body不能为null");
        }
        String requestBody = new String(body, "utf-8");
        LOGGER.info("云信消息抄送接口-MessageController-getCheckInfo-获取校验信息, 请求body[body={}]", requestBody);
        //消息的MD5值
        String MD5 = CheckSumBuilder.getMD5(requestBody);
        //计算校验和
        String checkSum = CheckSumBuilder.getCheckSum(Constants.APPSECRET, MD5, curTime);
        LOGGER.info("云信消息抄送接口-MessageController-getCheckInfo-获取校验信息, 返回结果[{}]", new JsonResult().JsonSuccess(new CheckModel(MD5, checkSum, curTime)));
        return new JsonResult().JsonSuccess(new CheckModel(MD5, checkSum, curTime));
    }

    /**
     * 从request解析消息体
     * @param request
     * @return
     * @throws IOException
     */
    private byte[] readBody(HttpServletRequest request) throws IOException {
        if (request.getContentLength() > 0) {
            byte[] body = new byte[request.getContentLength()];
            IOUtils.readFully(request.getInputStream(), body);
            return body;
        }
        return null;
    }

    /**
     * 校验MD5,CheckSum
     * @param request
     * @param requestBody
     * @return
     */
    private Boolean checkMsg(HttpServletRequest request, String requestBody) {
        if (request == null) {
            return false;
        }
        String ContentType = request.getContentType();
        String AppKey = request.getHeader(Constants.NETEASE_REQUEST_HEADER_APPKEY);
        String CurTime = request.getHeader(Constants.NETEASE_REQUEST_HEADER_CURTIME);
        String MD5 = request.getHeader(Constants.NETEASE_REQUEST_HEADER_MD5);
        String CheckSum = request.getHeader(Constants.NETEASE_REQUEST_HEADER_CHECKSUM);
        LOGGER.info("云信消息抄送接口-MessageController-sendMsg-Request Headers[ContentType = {}, AppKey = {}, CurTime = {}, MD5 = {}, CheckSum = {}]", ContentType, AppKey, CurTime, MD5, CheckSum);
        if (StringUtils.isEmpty(MD5) || StringUtils.isEmpty(CheckSum)) {
            return false;
        }
        // 计算md5
        String verifyMD5 = CheckSumBuilder.getMD5(requestBody);
        // 计算checkSum
        String verifyChecksum = CheckSumBuilder.getCheckSum(Constants.APPSECRET, verifyMD5, CurTime);
        LOGGER.info("云信消息抄送接口-MessageController-sendMsg-校验MD5和CheckSum[verifyMD5 = {}, verifyChecksum = {}, APPSECRET = {}, CurTime = {}]", verifyMD5, verifyChecksum, Constants.APPSECRET, CurTime);

        // 比较md5,checkSum是否一致
        return MD5.equals(verifyMD5) && CheckSum.equals(verifyChecksum) ? true : false;
    }
}
