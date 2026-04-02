package com.fotoable.youtube.music.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class HotKeyBean {
    @SerializedName("keyword")
    private String keyword;

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }
}
