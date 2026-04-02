package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class RecentlyWatchBean {
    private String artists;
    private String desc;
    private String duration;
    private int imgHeight;
    private String imgUrl;
    private int imgWidth;
    private int isFav;
    private String title;
    private String videoid;

    public RecentlyWatchBean(String str, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6) {
        this.videoid = str;
        this.title = str2;
        this.desc = str3;
        this.imgUrl = str4;
        this.imgWidth = i;
        this.imgHeight = i2;
        this.duration = str5;
        this.isFav = i3;
        this.artists = str6;
    }

    public RecentlyWatchBean() {
    }

    public void setArtists(String str) {
        this.artists = str;
    }

    public String getArtists() {
        return this.artists;
    }

    public String getVideoid() {
        return this.videoid;
    }

    public void setVideoid(String str) {
        this.videoid = str;
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

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public int getIsFav() {
        return this.isFav;
    }

    public void setIsFav(int i) {
        this.isFav = i;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getDesc() {
        return this.desc;
    }
}
