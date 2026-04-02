package com.fotoable.youtube.music.bean;

import java.util.List;
/* loaded from: classes.dex */
public class GlobalRankBean {
    private int chartsid;
    private String desc;
    private String imgUrl;
    private long lastUpdateTime;
    private String title;
    private String updateDesc;
    private List<VideosBean> videos;

    public int getChartsid() {
        return this.chartsid;
    }

    public void setChartsid(int i) {
        this.chartsid = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(long j) {
        this.lastUpdateTime = j;
    }

    public String getUpdateDesc() {
        return this.updateDesc;
    }

    public void setUpdateDesc(String str) {
        this.updateDesc = str;
    }

    public List<VideosBean> getVideos() {
        return this.videos;
    }

    public void setVideos(List<VideosBean> list) {
        this.videos = list;
    }

    /* loaded from: classes.dex */
    public static class VideosBean {
        private String artists;
        private String desc;
        private String duration;
        private int imgHeight;
        private String imgUrl;
        private int imgWidth;
        private String title;
        private String videoid;

        public String getVideoid() {
            return this.videoid;
        }

        public void setVideoid(String str) {
            this.videoid = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDesc() {
            return this.desc;
        }

        public void setDesc(String str) {
            this.desc = str;
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

        public String getDuration() {
            return this.duration;
        }

        public void setDuration(String str) {
            this.duration = str;
        }

        public String getArtists() {
            return this.artists;
        }

        public void setArtists(String str) {
            this.artists = str;
        }
    }
}
