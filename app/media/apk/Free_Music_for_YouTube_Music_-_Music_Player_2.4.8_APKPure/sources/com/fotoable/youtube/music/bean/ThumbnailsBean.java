package com.fotoable.youtube.music.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class ThumbnailsBean {
    @SerializedName("default")
    private ThumbBean defaultX;
    private ThumbBean high;
    private ThumbBean medium;

    public ThumbBean getDefaultX() {
        return this.defaultX;
    }

    public void setDefaultX(ThumbBean thumbBean) {
        this.defaultX = thumbBean;
    }

    public ThumbBean getMedium() {
        return this.medium;
    }

    public void setMedium(ThumbBean thumbBean) {
        this.medium = thumbBean;
    }

    public ThumbBean getHigh() {
        return this.high;
    }

    public void setHigh(ThumbBean thumbBean) {
        this.high = thumbBean;
    }
}
