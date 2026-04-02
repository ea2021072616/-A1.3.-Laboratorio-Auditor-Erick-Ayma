package com.fotoable.youtube.music.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class RecommendSongBean {
    @SerializedName("counter")
    private MyHttpResponse<CounterBean> counter;
    @SerializedName("imgUrl")
    private String imgUrl;
    @SerializedName("imgHeight")
    private int imgUrlHeight;
    @SerializedName("imgWidth")
    private int imgUrlWidth;
    @SerializedName("musicCount")
    private int musicCount;
    @SerializedName("playlistid")
    private String songsId;
    @SerializedName("title")
    private String title;
    @SerializedName("updateTime")
    private long updateTime;

    public String getSongsId() {
        return this.songsId;
    }

    public void setSongsId(String str) {
        this.songsId = str;
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

    public int getImgUrlWidth() {
        return this.imgUrlWidth;
    }

    public void setImgUrlWidth(int i) {
        this.imgUrlWidth = i;
    }

    public int getImgUrlHeight() {
        return this.imgUrlHeight;
    }

    public void setImgUrlHeight(int i) {
        this.imgUrlHeight = i;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public int getMusicCount() {
        return this.musicCount;
    }

    public void setMusicCount(int i) {
        this.musicCount = i;
    }

    public void setCounter(MyHttpResponse<CounterBean> myHttpResponse) {
        this.counter = myHttpResponse;
    }

    public MyHttpResponse<CounterBean> getCounter() {
        return this.counter;
    }

    public String toString() {
        return "RecommendSongBean{songsId='" + this.songsId + "', title='" + this.title + "', imgUrl='" + this.imgUrl + "', imgUrlWidth=" + this.imgUrlWidth + ", imgUrlHeight=" + this.imgUrlHeight + ", updateTime=" + this.updateTime + ", musicCount=" + this.musicCount + ", counter=" + this.counter.toString() + '}';
    }
}
