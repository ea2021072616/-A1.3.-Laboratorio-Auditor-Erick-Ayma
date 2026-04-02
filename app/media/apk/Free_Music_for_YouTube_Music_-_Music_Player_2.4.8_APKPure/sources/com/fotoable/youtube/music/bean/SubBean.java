package com.fotoable.youtube.music.bean;

import com.facebook.appevents.AppEventsConstants;
/* loaded from: classes.dex */
public class SubBean {
    private String artists;
    private String desc;
    private long id;
    private int imgHeight;
    private String imgUrl;
    private int imgWidth;
    private int musicCount;
    private String playlistid;
    private String title;
    private String type;
    private long updateTime;

    public SubBean(long j, String str, String str2, String str3, String str4, int i, int i2, int i3, long j2, String str5, String str6) {
        this.type = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.id = j;
        this.playlistid = str;
        this.title = str2;
        this.imgUrl = str3;
        this.desc = str4;
        this.imgWidth = i;
        this.imgHeight = i2;
        this.musicCount = i3;
        this.updateTime = j2;
        this.artists = str5;
        this.type = str6;
    }

    public SubBean() {
        this.type = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setArtists(String str) {
        this.artists = str;
    }

    public String getArtists() {
        return this.artists;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getPlaylistid() {
        return this.playlistid;
    }

    public void setPlaylistid(String str) {
        this.playlistid = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public int getImgWidth() {
        return this.imgWidth;
    }

    public void setImgWidth(int i) {
        this.imgWidth = i;
    }

    public int getImgHeight() {
        return this.imgHeight;
    }

    public void setImgHeight(int i) {
        this.imgHeight = i;
    }

    public int getMusicCount() {
        return this.musicCount;
    }

    public void setMusicCount(int i) {
        this.musicCount = i;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public void setId(long j) {
        this.id = j;
    }

    public long getId() {
        return this.id;
    }
}
