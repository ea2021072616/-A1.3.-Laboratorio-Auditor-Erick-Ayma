package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class YoutubeCommentLocalLikeModel {
    private String cid;
    private Long id;
    private Long modifyTime;
    private String uid;

    public YoutubeCommentLocalLikeModel() {
    }

    public YoutubeCommentLocalLikeModel(Long l, String str, String str2, Long l2) {
        this.id = l;
        this.cid = str;
        this.uid = str2;
        this.modifyTime = l2;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getCid() {
        return this.cid;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public Long getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Long l) {
        this.modifyTime = l;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "YoutubeCommentLocalLikeModel{id=" + this.id + ", cid='" + this.cid + "', uid='" + this.uid + "', modifyTime=" + this.modifyTime + '}';
    }
}
