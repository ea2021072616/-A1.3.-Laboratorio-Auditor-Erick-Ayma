package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class FeaturedDetailBean implements Parcelable {
    public static final Parcelable.Creator<FeaturedDetailBean> CREATOR = new Parcelable.Creator<FeaturedDetailBean>() { // from class: com.fotoable.youtube.music.bean.FeaturedDetailBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeaturedDetailBean createFromParcel(Parcel parcel) {
            return new FeaturedDetailBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeaturedDetailBean[] newArray(int i) {
            return new FeaturedDetailBean[i];
        }
    };
    private String artists;
    private String description;
    private String duration;
    private int imgHeight;
    private String imgUrl;
    private int imgWidth;
    private int isFav;
    private String playlistid;
    private String title;
    private long updateTime;
    private String videoid;

    public int getIsFav() {
        return this.isFav;
    }

    public void setIsFav(int i) {
        this.isFav = i;
    }

    public String getPlaylistid() {
        return this.playlistid;
    }

    public void setPlaylistid(String str) {
        this.playlistid = str;
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

    public String getArtists() {
        return this.artists;
    }

    public void setArtists(String str) {
        this.artists = str;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public FeaturedDetailBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.playlistid);
        parcel.writeString(this.videoid);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.imgUrl);
        parcel.writeInt(this.imgWidth);
        parcel.writeInt(this.imgHeight);
        parcel.writeString(this.duration);
        parcel.writeString(this.artists);
        parcel.writeLong(this.updateTime);
        parcel.writeInt(this.isFav);
    }

    protected FeaturedDetailBean(Parcel parcel) {
        this.playlistid = parcel.readString();
        this.videoid = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.imgUrl = parcel.readString();
        this.imgWidth = parcel.readInt();
        this.imgHeight = parcel.readInt();
        this.duration = parcel.readString();
        this.artists = parcel.readString();
        this.updateTime = parcel.readLong();
        this.isFav = parcel.readInt();
    }
}
