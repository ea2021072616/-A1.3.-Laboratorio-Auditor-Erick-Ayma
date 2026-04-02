package com.fotoable.youtube.music.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class PlayBean {
    @SerializedName("counter")
    private MyHttpResponse<CounterBean> counter;
    private String description;
    private int imgHeight;
    private String imgUrl;
    private int imgWidth;
    private int musicCount;
    private int playlistViewCount;
    private String playlistid;
    private String title;
    private long updateTime;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getPlaylistid() {
        return this.playlistid;
    }

    public void setPlaylistid(String str) {
        this.playlistid = str;
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

    public int getMusicCount() {
        return this.musicCount;
    }

    public void setMusicCount(int i) {
        this.musicCount = i;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public void setCounter(MyHttpResponse<CounterBean> myHttpResponse) {
        this.counter = myHttpResponse;
    }

    public MyHttpResponse<CounterBean> getCounter() {
        return this.counter;
    }

    public int getPlaylistViewCount() {
        return this.playlistViewCount;
    }

    public void setPlaylistViewCount(int i) {
        this.playlistViewCount = i;
    }

    public String toString() {
        return "PlayBean{playlistid='" + this.playlistid + "', title='" + this.title + "', imgUrl='" + this.imgUrl + "', imgWidth=" + this.imgWidth + ", imgHeight=" + this.imgHeight + ", musicCount=" + this.musicCount + ", updateTime=" + this.updateTime + ", counter=" + this.counter.toString() + '}';
    }
}
