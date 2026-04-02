package com.fotoable.youtube.music.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class CounterBean {
    @SerializedName("music_play_count")
    private int music_play_count;
    @SerializedName("songs_play_count")
    private int songs_play_count;

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

    public String toString() {
        return "CounterBean{music_play_count=" + this.music_play_count + ", songs_play_count=" + this.songs_play_count + '}';
    }
}
