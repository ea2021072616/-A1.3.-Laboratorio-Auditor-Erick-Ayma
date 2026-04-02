package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class ClassifiedRankVideoBean {
    private String artists;
    private int chartsid;
    private String desc;
    private String duration;
    private int imgHeight;
    private String imgUrl;
    private int imgWidth;
    private int isFav;
    private int number;
    private String title;
    private int type;
    private String videoid;

    public int getChartsid() {
        return this.chartsid;
    }

    public void setChartsid(int i) {
        this.chartsid = i;
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

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
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

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int i) {
        this.number = i;
    }

    public String getArtists() {
        return this.artists;
    }

    public void setArtists(String str) {
        this.artists = str;
    }

    public void setIsFav(int i) {
        this.isFav = i;
    }

    public int getIsFav() {
        return this.isFav;
    }
}
