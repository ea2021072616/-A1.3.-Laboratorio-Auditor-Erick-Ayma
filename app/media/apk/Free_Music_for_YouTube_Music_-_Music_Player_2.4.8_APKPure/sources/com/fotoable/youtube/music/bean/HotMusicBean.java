package com.fotoable.youtube.music.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class HotMusicBean {
    @SerializedName("counter")
    private MyHttpResponse<CounterBean> counter;
    @SerializedName("duration")
    private String duration;
    @SerializedName("imgUrl")
    private String imgUrl;
    @SerializedName("imgHeight")
    private int imgUrlHeight;
    @SerializedName("imgWidth")
    private int imgUrlWidth;
    @SerializedName("isFav")
    private int isFav;
    @SerializedName("playlistUrl")
    private String playlistUrl;
    @SerializedName("playlistid")
    private String playlistid;
    @SerializedName("title")
    private String title;
    @SerializedName("videoid")
    private String videoId;

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public String getPlaylistid() {
        return this.playlistid;
    }

    public void setPlaylistid(String str) {
        this.playlistid = str;
    }

    public String getPlaylistUrl() {
        return this.playlistUrl;
    }

    public void setPlaylistUrl(String str) {
        this.playlistUrl = str;
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

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public MyHttpResponse<CounterBean> getCounter() {
        return this.counter;
    }

    public void setCounter(MyHttpResponse<CounterBean> myHttpResponse) {
        this.counter = myHttpResponse;
    }

    public int getIsFav() {
        return this.isFav;
    }

    public void setIsFav(int i) {
        this.isFav = i;
    }

    public String toString() {
        return "HotMusicBean{videoId='" + this.videoId + "', playlistid='" + this.playlistid + "', playlistUrl='" + this.playlistUrl + "', title='" + this.title + "', imgUrl='" + this.imgUrl + "', imgUrlWidth=" + this.imgUrlWidth + ", imgUrlHeight=" + this.imgUrlHeight + ", duration='" + this.duration + "', isFav=" + this.isFav + ", counter=" + this.counter + '}';
    }
}
