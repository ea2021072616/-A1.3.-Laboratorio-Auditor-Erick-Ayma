package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class PlayListModel {
    private String cover;
    private String date;
    private String desc;
    private Long id;
    private String name;
    private String tag;

    public PlayListModel(Long l, String str, String str2, String str3, String str4, String str5) {
        this.id = l;
        this.name = str;
        this.date = str2;
        this.desc = str3;
        this.cover = str4;
        this.tag = str5;
    }

    public PlayListModel() {
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public String toString() {
        return "PlayListModel{id=" + this.id + ", name='" + this.name + "', date='" + this.date + "', desc='" + this.desc + "', cover='" + this.cover + "'}";
    }
}
