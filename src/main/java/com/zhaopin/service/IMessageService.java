package com.zhaopin.service;

import com.zhaopin.dto.NeteaseMessageDto;
import com.zhaopin.dto.PlatFormReceiveMessageDto;
import com.zhaopin.entity.Discussion;

/**
 * Created by SYJ on 2017/5/18.
 */
public interface IMessageService {
    /**
     * 发送消息
     * @param neteaseMessageDto 云信消息Dto
     * @return
     */
    PlatFormReceiveMessageDto sendMsg(NeteaseMessageDto neteaseMessageDto, long discussionId);

    /**
     * 查询讨论组信息
     * @param fromid
     * @param toid
     * @return
     */
    Discussion getDiscussion(long fromid, long toid);

    /**
     * 创建讨论组
     * @param neteaseMessageDto
     * @return
     */
    Discussion createDiscussion(NeteaseMessageDto neteaseMessageDto);

    /**
     * 保存讨论组信息
     * @param discussion
     * @return
     */
    int saveDiscussion(Discussion discussion);
}
