package com.fotoable.youtube.music.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class CategoryBean {
    @SerializedName("categoryid")
    private String categoryid;
    @SerializedName("imgHeight")
    private int imgHeight;
    @SerializedName("imgUrl")
    private String imgUrl;
    @SerializedName("imgWidth")
    private int imgWidth;
    @SerializedName("title")
    private String title;

    public String toString() {
        return "CategoryBean{categoryid=" + this.categoryid + ", title='" + this.title + "', imgUrl='" + this.imgUrl + "', imgWidth=" + this.imgWidth + ", imgHeight=" + this.imgHeight + '}';
    }

    public String getCategoryid() {
        return this.categoryid;
    }

    public void setCategoryid(String str) {
        this.categoryid = str;
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
}
