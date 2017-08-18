package com.zhaopin.entity;

public class Discussion {
    private Integer id;

    private long fromid;

    private long toid;

    private long discussionid;

    public Discussion() {
    }

    public Discussion(long fromid, long toid, long discussionid) {
        this.fromid = fromid;
        this.toid = toid;
        this.discussionid = discussionid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getFromid() {
        return fromid;
    }

    public void setFromid(long fromid) {
        this.fromid = fromid;
    }

    public long getToid() {
        return toid;
    }

    public void setToid(long toid) {
        this.toid = toid;
    }

    public long getDiscussionid() {
        return discussionid;
    }

    public void setDiscussionid(long discussionid) {
        this.discussionid = discussionid;
    }

    @Override
    public String toString() {
        return "Discussion{" +
                "id=" + id +
                ", fromid=" + fromid +
                ", toid=" + toid +
                ", discussionid=" + discussionid +
                '}';
    }
}