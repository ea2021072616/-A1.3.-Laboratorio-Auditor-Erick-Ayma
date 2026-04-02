package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class LocalRecentlyModel implements Parcelable {
    public static final Parcelable.Creator<LocalRecentlyModel> CREATOR = new Parcelable.Creator<LocalRecentlyModel>() { // from class: com.fotoable.youtube.music.bean.LocalRecentlyModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalRecentlyModel createFromParcel(Parcel parcel) {
            return new LocalRecentlyModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalRecentlyModel[] newArray(int i) {
            return new LocalRecentlyModel[i];
        }
    };
    private Long id;
    private Long modifyTime;
    private Integer playedCount;
    private Long songId;

    public LocalRecentlyModel() {
    }

    protected LocalRecentlyModel(Parcel parcel) {
    }

    public LocalRecentlyModel(Long l, Long l2, Long l3, Integer num) {
        this.id = l;
        this.songId = l2;
        this.modifyTime = l3;
        this.playedCount = num;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public Long getSongId() {
        return this.songId;
    }

    public void setSongId(Long l) {
        this.songId = l;
    }

    public Long getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Long l) {
        this.modifyTime = l;
    }

    public Integer getPlayedCount() {
        return this.playedCount;
    }

    public void setPlayedCount(Integer num) {
        this.playedCount = num;
    }

    public String toString() {
        return "LocalRecentlyModel{id=" + this.id + ", songId=" + this.songId + ", modifyTime=" + this.modifyTime + ", playedCount=" + this.playedCount + '}';
    }
}
