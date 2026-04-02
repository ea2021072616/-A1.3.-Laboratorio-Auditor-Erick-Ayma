package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class HomeListNewBean {
    private String artists;
    private CounterEntity counter;
    private String description;
    private String duration;
    private int imgHeight;
    private String imgUrl;
    private int imgWidth;
    private int isFav;
    private String pageToken;
    private String title;
    private String videoid;

    public void setArtists(String str) {
        this.artists = str;
    }

    public String getArtists() {
        return this.artists;
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public void setPageToken(String str) {
        this.pageToken = str;
    }

    public int getIsFav() {
        return this.isFav;
    }

    public void setIsFav(int i) {
        this.isFav = i;
    }

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
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

    public CounterEntity getCounter() {
        return this.counter;
    }

    public void setCounter(CounterEntity counterEntity) {
        this.counter = counterEntity;
    }

    /* loaded from: classes.dex */
    public static class CounterEntity {
        private DataEntity data;

        public DataEntity getData() {
            return this.data;
        }

        public void setData(DataEntity dataEntity) {
            this.data = dataEntity;
        }

        /* loaded from: classes.dex */
        public static class DataEntity {
            private String music_play_count;

            public String getMusic_play_count() {
                return this.music_play_count;
            }

            public void setMusic_play_count(String str) {
                this.music_play_count = str;
            }
        }
    }

    public String toString() {
        return "HomeListNewBean{videoid='" + this.videoid + "', title='" + this.title + "', description='" + this.description + "', imgUrl='" + this.imgUrl + "', imgWidth=" + this.imgWidth + ", imgHeight=" + this.imgHeight + ", duration='" + this.duration + "', counter=" + this.counter + ", isFav=" + this.isFav + '}';
    }
}
