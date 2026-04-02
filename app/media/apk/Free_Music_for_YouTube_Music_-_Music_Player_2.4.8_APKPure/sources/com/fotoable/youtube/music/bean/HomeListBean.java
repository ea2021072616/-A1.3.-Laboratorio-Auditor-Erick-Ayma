package com.fotoable.youtube.music.bean;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HomeListBean {
    @SerializedName("categoryLists")
    private ArrayList<CategoryBean> categoryBeens;
    @SerializedName("hotMusics")
    private ArrayList<HotMusicBean> hotMusicBeens;
    @SerializedName("recommendSongs")
    private ArrayList<RecommendSongBean> recommendSongBeens;

    public ArrayList<CategoryBean> getCategoryBeens() {
        return this.categoryBeens;
    }

    public void setCategoryBeens(ArrayList<CategoryBean> arrayList) {
        this.categoryBeens = arrayList;
    }

    public ArrayList<HotMusicBean> getHotMusicBeens() {
        return this.hotMusicBeens;
    }

    public void setHotMusicBeens(ArrayList<HotMusicBean> arrayList) {
        this.hotMusicBeens = arrayList;
    }

    public ArrayList<RecommendSongBean> getRecommendSongBeens() {
        return this.recommendSongBeens;
    }

    public void setRecommendSongBeens(ArrayList<RecommendSongBean> arrayList) {
        this.recommendSongBeens = arrayList;
    }
}
