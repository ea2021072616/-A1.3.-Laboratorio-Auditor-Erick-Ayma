package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class LocalPlayListMusicModel implements Parcelable {
    public static final Parcelable.Creator<LocalPlayListMusicModel> CREATOR = new Parcelable.Creator<LocalPlayListMusicModel>() { // from class: com.fotoable.youtube.music.bean.LocalPlayListMusicModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalPlayListMusicModel createFromParcel(Parcel parcel) {
            return new LocalPlayListMusicModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalPlayListMusicModel[] newArray(int i) {
            return new LocalPlayListMusicModel[i];
        }
    };
    private Long createTime;
    private Long id;
    private Long playListId;
    private Long songId;

    protected LocalPlayListMusicModel(Parcel parcel) {
    }

    public LocalPlayListMusicModel(Long l, Long l2, Long l3, Long l4) {
        this.id = l;
        this.songId = l2;
        this.playListId = l3;
        this.createTime = l4;
    }

    public LocalPlayListMusicModel() {
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

    public Long getPlayListId() {
        return this.playListId;
    }

    public void setPlayListId(Long l) {
        this.playListId = l;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }
}
