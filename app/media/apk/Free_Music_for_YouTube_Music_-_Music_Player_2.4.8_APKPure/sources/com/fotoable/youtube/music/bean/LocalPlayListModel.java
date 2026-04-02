package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class LocalPlayListModel implements Parcelable {
    public static final Parcelable.Creator<LocalPlayListModel> CREATOR = new Parcelable.Creator<LocalPlayListModel>() { // from class: com.fotoable.youtube.music.bean.LocalPlayListModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalPlayListModel createFromParcel(Parcel parcel) {
            return new LocalPlayListModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalPlayListModel[] newArray(int i) {
            return new LocalPlayListModel[i];
        }
    };
    private String cover;
    private Long createTime;
    private Long id;
    private Long modifyTime;
    private int musicCount;
    private String name;

    protected LocalPlayListModel(Parcel parcel) {
        this.id = Long.valueOf(parcel.readLong());
        this.createTime = Long.valueOf(parcel.readLong());
        this.modifyTime = Long.valueOf(parcel.readLong());
        this.name = parcel.readString();
        this.cover = parcel.readString();
        this.musicCount = parcel.readInt();
    }

    public LocalPlayListModel(Long l, String str, Long l2, Long l3) {
        this.id = l;
        this.name = str;
        this.createTime = l2;
        this.modifyTime = l3;
    }

    public LocalPlayListModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id.longValue());
        parcel.writeLong(this.createTime.longValue());
        parcel.writeLong(this.modifyTime.longValue());
        parcel.writeString(this.name);
        parcel.writeString(this.cover);
        parcel.writeInt(this.musicCount);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public Long getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Long l) {
        this.modifyTime = l;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public int getMusicCount() {
        return this.musicCount;
    }

    public void setMusicCount(int i) {
        this.musicCount = i;
    }

    public String toString() {
        return "LocalPlayListModel{id=" + this.id + ", name='" + this.name + "', createTime=" + this.createTime + ", modifyTime=" + this.modifyTime + ", cover='" + this.cover + "', musicCount=" + this.musicCount + '}';
    }
}
