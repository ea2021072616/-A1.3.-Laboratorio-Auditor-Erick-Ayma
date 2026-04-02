package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class RadioBean {
    private String audioType;
    private String audioUrl;
    private String countryCode;
    private int id;
    private String imgUrl;
    private Long originalId;
    private String title;

    public RadioBean(Long l, int i, String str, String str2, String str3, String str4, String str5) {
        this.originalId = l;
        this.id = i;
        this.countryCode = str;
        this.title = str2;
        this.audioType = str3;
        this.audioUrl = str4;
        this.imgUrl = str5;
    }

    public RadioBean() {
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getAudioType() {
        return this.audioType;
    }

    public void setAudioType(String str) {
        this.audioType = str;
    }

    public String getAudioUrl() {
        return this.audioUrl;
    }

    public void setAudioUrl(String str) {
        this.audioUrl = str;
    }

    public Long getOriginalId() {
        return this.originalId;
    }

    public void setOriginalId(Long l) {
        this.originalId = l;
    }
}
