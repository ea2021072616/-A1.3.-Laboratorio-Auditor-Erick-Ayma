package com.fotoable.youtube.music.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class YoutubeComment {
    @SerializedName("bigid")
    private String bidId;
    private String body;
    private String cid;
    public CommentCounter counter;
    public long createdAt;
    public boolean isLike;
    public int isReplyComment;
    @SerializedName("rebody")
    public String reBody;
    @SerializedName("reuserinfo")
    public CommentUserInfo reUserInfo;
    @SerializedName("userinfo")
    private CommentUserInfo userInfo;

    public boolean isLike() {
        return this.isLike;
    }

    public void setLike(boolean z) {
        this.isLike = z;
    }

    public String getCid() {
        return this.cid;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public String getBidId() {
        return this.bidId;
    }

    public void setBidId(String str) {
        this.bidId = str;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public String getReBody() {
        return this.reBody;
    }

    public void setReBody(String str) {
        this.reBody = str;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public int getIsReplyComment() {
        return this.isReplyComment;
    }

    public void setIsReplyComment(int i) {
        this.isReplyComment = i;
    }

    public CommentUserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(CommentUserInfo commentUserInfo) {
        this.userInfo = commentUserInfo;
    }

    public CommentUserInfo getReUserInfo() {
        return this.reUserInfo;
    }

    public void setReUserInfo(CommentUserInfo commentUserInfo) {
        this.reUserInfo = commentUserInfo;
    }

    public CommentCounter getCounter() {
        return this.counter;
    }

    public void setCounter(CommentCounter commentCounter) {
        this.counter = commentCounter;
    }

    public String toString() {
        return "YoutubeComment{cid='" + this.cid + "', bidId='" + this.bidId + "', body='" + this.body + "', reBody='" + this.reBody + "', createdAt=" + this.createdAt + ", isReplyComment=" + this.isReplyComment + ", userInfo=" + this.userInfo + ", reUserInfo=" + this.reUserInfo + ", counter=" + this.counter + ", isLike=" + this.isLike + '}';
    }
}
