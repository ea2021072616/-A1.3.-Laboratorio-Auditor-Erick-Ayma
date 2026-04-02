package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class SnippetBean {
    private String channelId;
    private String channelTitle;
    private String description;
    private String duration;
    private String liveBroadcastContent;
    private String publishedAt;
    private ThumbnailsBean thumbnails;
    private String title;

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public void setPublishedAt(String str) {
        this.publishedAt = str;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String str) {
        this.channelId = str;
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

    public ThumbnailsBean getThumbnails() {
        return this.thumbnails;
    }

    public void setThumbnails(ThumbnailsBean thumbnailsBean) {
        this.thumbnails = thumbnailsBean;
    }

    public String getChannelTitle() {
        return this.channelTitle;
    }

    public void setChannelTitle(String str) {
        this.channelTitle = str;
    }

    public String getLiveBroadcastContent() {
        return this.liveBroadcastContent;
    }

    public void setLiveBroadcastContent(String str) {
        this.liveBroadcastContent = str;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }
}
