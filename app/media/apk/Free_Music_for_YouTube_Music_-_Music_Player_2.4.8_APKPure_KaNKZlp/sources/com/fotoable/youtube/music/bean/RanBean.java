package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class RanBean {
    private String description;
    private int imgHeight;
    private String imgUrl;
    private int imgWidth;
    private int music_play_count;
    private String playlistid;
    private int songs_play_count;
    private String title;
    private long updateTime;

    public int getMusic_play_count() {
        return this.music_play_count;
    }

    public void setMusic_play_count(int i) {
        this.music_play_count = i;
    }

    public int getSongs_play_count() {
        return this.songs_play_count;
    }

    public void setSongs_play_count(int i) {
        this.songs_play_count = i;
    }

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

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public String toString() {
        return "RanBean{playlistid='" + this.playlistid + "', title='" + this.title + "', imgUrl='" + this.imgUrl + "', imgWidth=" + this.imgWidth + ", imgHeight=" + this.imgHeight + ", updateTime=" + this.updateTime + '}';
    }
}
