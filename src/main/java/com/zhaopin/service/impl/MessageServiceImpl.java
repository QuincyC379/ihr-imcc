package com.zhaopin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zhaopin.core.common.Constants;
import com.zhaopin.core.common.ResultModel;
import com.zhaopin.core.utils.CommonUtil;
import com.zhaopin.core.utils.HttpClientUtil;
import com.zhaopin.dto.*;
import com.zhaopin.dto.attach.CustomAttachDto;
import com.zhaopin.dto.attach.NeteasePictureDto;
import com.zhaopin.entity.Discussion;
import com.zhaopin.enums.NeteaseFromClientTypeEnum;
import com.zhaopin.enums.NeteaseMsgTypeEnum;
import com.zhaopin.enums.PlatFormDeviceTypeEnum;
import com.zhaopin.enums.PlatFormMsgTypeEnum;
import com.zhaopin.mapper.DiscussionMapper;
import com.zhaopin.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * 消息抄送服务类
 * Created by SYJ on 2017/5/18.
 */
@Service
public class MessageServiceImpl implements IMessageService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    //平台发送消息接口URL
    @Value("${PLATFORM_SEND_MESSAGE_URL}")
    private String PLATFORM_SEND_MESSAGE_URL;

    //平台创建讨论组接口URL
    @Value("${PLATFORM_CREATE_DISCUSSION_URL}")
    private String PLATFORM_CREATE_DISCUSSION_URL;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DiscussionMapper discussionMapper;

    /**
     * 发送消息
     * @param neteaseMessageDto 云信消息Dto
     * @return
     * {
     *   "body": "{\"message\":{\"createTime\":1496299700203,\"messageId\":58921},\"code\":200}",
     *   "header": {
     *   "group": 2,
     *   "signall": 1,
     *   "type": 2,
     *   "unique": "3b8dd090752d48de8f668d2f713fb2ae",
     *   "version": 1
     *   },
     *   "user": {
     *   "deviceId": "B0BFF2EB-E2E1-4063-9E73-92FB926BF388",
     *   "deviceType": 1,
     *   "token": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
     *   "userId": "123456"
     *   }
     * }
     */
    public PlatFormReceiveMessageDto sendMsg(NeteaseMessageDto neteaseMessageDto, long discussionId) {
        //请求json
        String sendMessageDtoToJson = buildSendMsg(neteaseMessageDto, discussionId);
        LOGGER.info("云信消息抄送接口-IMessageDaoImpl-sendMsg-调用平台接口请求URL[Constants.SEND_MESSAGE_URL={}], 请求json内容[sendMessageDtoToJson={}]", this.PLATFORM_SEND_MESSAGE_URL, sendMessageDtoToJson);
        String httpResult = null;
        try {
            //调用平台接口,发送消息
            httpResult = HttpClientUtil.sendPostRequest(this.PLATFORM_SEND_MESSAGE_URL, sendMessageDtoToJson, Constants.ENCODE_CHARSET, MediaType.APPLICATION_JSON);
            LOGGER.info("云信消息抄送接口-IMessageDaoImpl-sendMsg-平台接口返回json内容httpResult[{}]", httpResult);
        } catch (Exception ex) {
            LOGGER.error("云信消息抄送接口-IMessageDaoImpl-sendMsg-抛出异常, 平台接口返回结果httpResult[{}], 异常信息[{}]", httpResult, CommonUtil.getExceptionAllinformation(ex));
        }
        ResultModel<PlatFormReceiveMessageDto> resultModel = JSON.parseObject(httpResult, new TypeReference<ResultModel<PlatFormReceiveMessageDto>>() {
        });
        if (resultModel == null) { return null; }
        return resultModel.getData();
    }

    /**
     * 查询讨论组信息
     * @param fromid
     * @param toid
     * @return
     */
    @Override
    public Discussion getDiscussion(long fromid, long toid) {
        Discussion discussion = null;
        String discussionFromRedis = null;

        try {
            //读redis缓存
//            discussionFromRedis = jedisClient.get(fromid + ":" + toid);

            //使用Spring的RedisTemplate操作redis集群
            discussionFromRedis = (String) redisTemplate.opsForValue().get(fromid + ":" + toid);
            LOGGER.info("云信消息抄送接口-MessageController-sendMsg-从redis读取讨论组信息, key=[{}], value=[{}]", fromid + ":" + toid, discussionFromRedis);
            discussion = JSON.parseObject(discussionFromRedis, Discussion.class);
        } catch (Exception ex) {
            LOGGER.error("云信消息抄送接口-MessageController-sendMsg-从redis读取讨论组信息抛出异常, key=[{}], value=[{}], 异常信息=[{}]", fromid + ":" + toid, discussionFromRedis, CommonUtil.getExceptionAllinformation(ex));
        }
        if (discussion == null) {
            //读DB
            discussion = discussionMapper.selectByFromidAndToid(fromid, toid);
            LOGGER.info("云信消息抄送接口-MessageController-sendMsg-从DB查询讨论组信息, 查询参数[fromId={}][toId={}], 查询结果[discussion={}]", fromid, toid, JSON.toJSONString(discussion));
            if (discussion != null) {
                try {
                    //写redis缓存
//                    jedisClient.set(discussion.getFromid() + ":" + discussion.getToid(), JSON.toJSONString(discussion));

                    //使用Spring的RedisTemplate操作redis集群
                    redisTemplate.opsForValue().set(discussion.getFromid() + ":" + discussion.getToid(), JSON.toJSONString(discussion));
                    LOGGER.info("云信消息抄送接口-MessageController-sendMsg-从DB查询讨论组信息之后缓存到redis, key=[{}], value=[{}]", discussion.getFromid() + ":" + discussion.getToid(), JSON.toJSONString(discussion));
                } catch (Exception ex) {
                    LOGGER.error("云信消息抄送接口-MessageController-sendMsg-从DB查询讨论组信息之后缓存到redis失败, key=[{}], value=[{}], 异常信息=[{}]", discussion.getFromid() + ":" + discussion.getToid(), JSON.toJSONString(discussion), CommonUtil.getExceptionAllinformation(ex));
                }
            }
            return discussion;
        }
        return discussion;
    }

    /**
     * 创建讨论组
     * TODO 存在的问题:A给B发送消息,B给A发送消息,会向DB写入2条讨论组数据
     * @param neteaseMessageDto
     * @return
     */
    @Override
    public Discussion createDiscussion(NeteaseMessageDto neteaseMessageDto) {
        DiscussionResDto discussionResDto = null;
        String requestJson = createDiscussionRequestJson(neteaseMessageDto);
        ResultModel<DiscussionResDto> resultModel = null;
        String httpResult = null;
        try {
            httpResult = HttpClientUtil.sendPostRequest(this.PLATFORM_CREATE_DISCUSSION_URL, requestJson, Constants.ENCODE_CHARSET, MediaType.APPLICATION_JSON);
            LOGGER.info("云信消息抄送接口-IMessageDaoImpl-createDiscussion-调用平台创建讨论组接口,请求地址[url={}], 请求参数[requestJson={}], 平台接口返回json内容[httpResult={}]", this.PLATFORM_CREATE_DISCUSSION_URL, requestJson, httpResult);
            resultModel = JSON.parseObject(httpResult, new TypeReference<ResultModel<DiscussionResDto>>() {
            });
        } catch (Exception ex) {
            LOGGER.error("云信消息抄送接口-IMessageDaoImpl-createDiscussion-调用平台创建讨论组接口抛出异常, 请求地址[url={}], 请求参数[requestJson={}], 平台接口返回结果[httpResult={}], 异常信息[{}]", this.PLATFORM_CREATE_DISCUSSION_URL, requestJson, httpResult, CommonUtil.getExceptionAllinformation(ex));
        }
        if (resultModel != null) {
            discussionResDto = resultModel.getData();
        }

        if (discussionResDto != null) {
            DiscussionResBodyDto discussionResBodyDto = JSON.parseObject(discussionResDto.getBody(), DiscussionResBodyDto.class);
            return new Discussion(Long.parseLong(neteaseMessageDto.getFromAccount()), Long.parseLong(neteaseMessageDto.getTo()), discussionResBodyDto.getDiscussionId());
        }
        return null;
    }

    /**
     * 创建讨论组接口请求json
     * @param neteaseMessageDto
     * @return
     */
    public String createDiscussionRequestJson(NeteaseMessageDto neteaseMessageDto) {
        //header
        String uuid = UUID.randomUUID().toString().replace("-", "");
        HeaderDto headerDto = new HeaderDto(1, 1, 2, 5, uuid);

        //body
        ArrayList<Long> userIdList = new ArrayList<>();
        userIdList.add(Long.parseLong(neteaseMessageDto.getFromAccount()));//消息发送者
        userIdList.add(Long.parseLong(neteaseMessageDto.getTo()));//消息接收者
        DiscussionBodyDto discussionBodyDto = new DiscussionBodyDto(1, 1, "讨论组", userIdList);

        //user
        UserDto userDto = buildUserDto(neteaseMessageDto);

        //请求json
        return JSON.toJSONString(new DiscussionRequestDto(headerDto, discussionBodyDto, userDto));
    }

    /**
     * 保存讨论组信息
     * @param discussion
     * @return
     */
    @Override
    public int saveDiscussion(Discussion discussion) {
        //保存讨论组信息到DB
        int count = discussionMapper.insert(discussion);
        LOGGER.info("云信消息抄送接口-IMessageDaoImpl-saveDiscussion-保存讨论组信息到DB成功,参数[discussion={}]", discussion);
        try {
            //写redis缓存
//            jedisClient.set(discussion.getFromid() + ":" + discussion.getToid(), JSON.toJSONString(discussion));

            //使用Spring的RedisTemplate操作redis集群
            redisTemplate.opsForValue().set(discussion.getFromid() + ":" + discussion.getToid(), JSON.toJSONString(discussion));
            LOGGER.info("云信消息抄送接口-MessageController-sendMsg-保存讨论组信息到DB之后缓存到redis, key=[{}], value=[{}]", discussion.getFromid() + ":" + discussion.getToid(), JSON.toJSONString(discussion));
        } catch (Exception ex) {
            LOGGER.error("云信消息抄送接口-MessageController-sendMsg-保存讨论组信息到DB之后缓存到redis失败, key=[{}], value=[{}], 异常信息=[{}]", discussion.getFromid() + ":" + discussion.getToid(), JSON.toJSONString(discussion), CommonUtil.getExceptionAllinformation(ex));
        }
        return count;
    }

    /**
     * 要发送的消息json
     *  请求json包含3部分:header,body,user
     * @param neteaseMessageDto
     * @return
     */
    private String buildSendMsg(NeteaseMessageDto neteaseMessageDto, long discussionId) {
        HeaderDto headerDto = buildHeaderDto();
        BodyDto bodyDto = buildBodyDto(neteaseMessageDto, discussionId);
        UserDto userDto = buildUserDto(neteaseMessageDto);
        return JSON.toJSONString(new SendMessageDto(headerDto, bodyDto, userDto));
    }

    /**
     * 构建headerDto
     * @return
     */
    private HeaderDto buildHeaderDto() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return new HeaderDto(Constants.PLATFORM_REQUEST_HEADER_VERSION, Constants.PLATFORM_REQUEST_HEADER_TYPE, Constants.PLATFORM_REQUEST_HEADER_GROUP, Constants.PLATFORM_REQUEST_HEADER_SIGNALL, uuid);
    }

    /**
     * 构建请求体
     * @param neteaseMessageDto
     * @return
     */
    private BodyDto buildBodyDto(NeteaseMessageDto neteaseMessageDto, long discussionId) {
        BodyDto bodyDto = new BodyDto();
        bodyDto.setFrom(Long.parseLong(neteaseMessageDto.getFromAccount()));//消息发送者userId

        //设置讨论组id
        bodyDto.setTo(discussionId);//讨论组id

        bodyDto.setConversationType(1);// 1代表讨论组
        bodyDto.setSendTime(new Date(Long.parseLong(neteaseMessageDto.getMsgTimestamp())));//发送时间，客户端生成

        String msgType = neteaseMessageDto.getMsgType();
        if (NeteaseMsgTypeEnum.TEXT.name().equals(msgType)) {
            bodyDto.setMsgType(PlatFormMsgTypeEnum.TEXT.getValue());//文本消息
            bodyDto.setMessage(neteaseMessageDto.getBody());//文本消息内容
        } else if (NeteaseMsgTypeEnum.CUSTOM.name().equals(msgType)) {
            bodyDto.setMsgType(PlatFormMsgTypeEnum.CUSTOM.getValue());//自定义消息
            String attach = neteaseMessageDto.getAttach();//获取扩展字段
            //获取自定义消息
            CustomAttachDto<Object> obj = JSON.parseObject(attach, new TypeReference<CustomAttachDto<Object>>() {
            });
            bodyDto.setMessage(JSON.toJSONString(obj));//自定义消息json内容
        } else if (NeteaseMsgTypeEnum.PICTURE.name().equals(msgType)) {
            bodyDto.setMsgType(PlatFormMsgTypeEnum.TEXT.getValue());//TODO 图片消息设置类型???
            PlatFormFileDto platFormFileDto = buildPlatFormFileDto(neteaseMessageDto);//图片消息
            bodyDto.setMessage(JSON.toJSONString(platFormFileDto));//图片消息json内容
        }
        return bodyDto;
    }

    /**
     * 构建userDto
     * @param neteaseMessageDto
     * @return
     */
    private UserDto buildUserDto(NeteaseMessageDto neteaseMessageDto) {
        String fromAccount = neteaseMessageDto.getFromAccount();//发送者userId
        String fromDeviceId = neteaseMessageDto.getFromDeviceId();
        Integer deviceType = getDeviceType(neteaseMessageDto.getFromClientType());
        return new UserDto(fromAccount, fromDeviceId, deviceType, Constants.PLATFORM_PASSPORT_TOKEN);
    }

    /**
     * 获取设备类型
     * @param fromClientType
     * @return
     */
    private Integer getDeviceType(String fromClientType) {
        if (NeteaseFromClientTypeEnum.IOS.name().equals(fromClientType)) {
            return PlatFormDeviceTypeEnum.IOS.getValue();
        } else {
            // TODO 云信的设备类型和平台的不一致
            return PlatFormDeviceTypeEnum.windows.getValue();
        }
    }

    /**
     * 构建PlatFormFileDto
     * @param neteaseMessageDto
     * @return
     */
    private PlatFormFileDto buildPlatFormFileDto(NeteaseMessageDto neteaseMessageDto) {
        NeteasePictureDto neteasePictureDto = JSON.parseObject(neteaseMessageDto.getAttach(), NeteasePictureDto.class);

        //平台 图片dto
        PlatFormPictureDto platFormPictureDto = new PlatFormPictureDto(neteasePictureDto.getH()
                , neteasePictureDto.getW(), neteasePictureDto.getUrl(), neteasePictureDto.getUrl());

        //图片dto作为文件dto的一个扩展属性(json)
        PlatFormFileDto platFormFileDto = new PlatFormFileDto(JSON.toJSONString(platFormPictureDto)
                , neteasePictureDto.getName(), String.valueOf(neteasePictureDto.getSize())
                , neteasePictureDto.getExt(), neteasePictureDto.getUrl(), neteasePictureDto.getMd5());
        return platFormFileDto;
    }
}
