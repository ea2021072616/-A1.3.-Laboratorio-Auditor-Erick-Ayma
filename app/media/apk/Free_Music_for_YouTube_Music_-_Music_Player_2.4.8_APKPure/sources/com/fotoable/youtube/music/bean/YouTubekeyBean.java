package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class YouTubekeyBean {
    private int isOpen;
    private boolean isShowChoice;
    private boolean isShowFeatured;
    private boolean isShowPlaylist;
    private String server;
    private String shareUrl;

    public boolean isShowPlaylist() {
        return this.isShowPlaylist;
    }

    public void setShowPlaylist(boolean z) {
        this.isShowPlaylist = z;
    }

    public boolean isShowFeatured() {
        return this.isShowFeatured;
    }

    public void setShowFeatured(boolean z) {
        this.isShowFeatured = z;
    }

    public boolean isShowChoice() {
        return this.isShowChoice;
    }

    public void setShowChoice(boolean z) {
        this.isShowChoice = z;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public int getIsOpen() {
        return this.isOpen;
    }

    public void setIsOpen(int i) {
        this.isOpen = i;
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String str) {
        this.server = str;
    }

    public String toString() {
        return "YouTubekeyBean{server='" + this.server + "', isOpen=" + this.isOpen + ", shareUrl='" + this.shareUrl + "'}";
    }
}
