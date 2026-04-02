package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class DurationBean {
    private String duration;
    private String videoId;

    public DurationBean(String str, String str2) {
        this.videoId = str;
        this.duration = str2;
    }

    public DurationBean() {
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }
}
