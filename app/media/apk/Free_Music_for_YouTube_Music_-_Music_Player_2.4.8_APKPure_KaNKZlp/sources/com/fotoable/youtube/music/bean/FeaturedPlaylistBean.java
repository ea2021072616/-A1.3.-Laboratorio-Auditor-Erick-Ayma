package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class FeaturedPlaylistBean implements Parcelable {
    public static final Parcelable.Creator<FeaturedPlaylistBean> CREATOR = new Parcelable.Creator<FeaturedPlaylistBean>() { // from class: com.fotoable.youtube.music.bean.FeaturedPlaylistBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeaturedPlaylistBean createFromParcel(Parcel parcel) {
            return new FeaturedPlaylistBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeaturedPlaylistBean[] newArray(int i) {
            return new FeaturedPlaylistBean[i];
        }
    };
    private String desc;
    private String description;
    private String imgUrl;
    private int playlistViewCount;
    private String playlistid;
    private String title;
    private long updateTime;

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

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public int getPlaylistViewCount() {
        return this.playlistViewCount;
    }

    public void setPlaylistViewCount(int i) {
        this.playlistViewCount = i;
    }

    public FeaturedPlaylistBean() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.playlistid);
        parcel.writeString(this.title);
        parcel.writeString(this.imgUrl);
        parcel.writeString(this.desc);
        parcel.writeInt(this.playlistViewCount);
        parcel.writeString(this.description);
        parcel.writeLong(this.updateTime);
    }

    protected FeaturedPlaylistBean(Parcel parcel) {
        this.playlistid = parcel.readString();
        this.title = parcel.readString();
        this.imgUrl = parcel.readString();
        this.desc = parcel.readString();
        this.playlistViewCount = parcel.readInt();
        this.description = parcel.readString();
        this.updateTime = parcel.readLong();
    }
}
