package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class GenresBean {
    private int categoryid;
    private String group;
    private String groupImgUrl;
    private String groupid;
    private String keywords;
    private String name;
    private String nameEs;
    private int type;

    public void setGroupImgUrl(String str) {
        this.groupImgUrl = str;
    }

    public String getGroupImgUrl() {
        return this.groupImgUrl;
    }

    public int getCategoryid() {
        return this.categoryid;
    }

    public void setCategoryid(int i) {
        this.categoryid = i;
    }

    public String getGroupid() {
        return this.groupid;
    }

    public void setGroupid(String str) {
        this.groupid = str;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String str) {
        this.group = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String str) {
        this.keywords = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public String getNameEs() {
        return this.nameEs;
    }

    public void setNameEs(String str) {
        this.nameEs = str;
    }

    public String toString() {
        return "GenresBean{type=" + this.type + ", categoryid=" + this.categoryid + ", groupid='" + this.groupid + "', group='" + this.group + "', nameEs='" + this.nameEs + "', name='" + this.name + "', keywords='" + this.keywords + "', groupImgUrl='" + this.groupImgUrl + "'}";
    }
}
