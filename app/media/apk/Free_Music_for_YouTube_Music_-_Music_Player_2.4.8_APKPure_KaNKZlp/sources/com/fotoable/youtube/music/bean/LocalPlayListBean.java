package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class LocalPlayListBean implements Parcelable {
    public static final Parcelable.Creator<LocalPlayListBean> CREATOR = new Parcelable.Creator<LocalPlayListBean>() { // from class: com.fotoable.youtube.music.bean.LocalPlayListBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalPlayListBean createFromParcel(Parcel parcel) {
            return new LocalPlayListBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalPlayListBean[] newArray(int i) {
            return new LocalPlayListBean[i];
        }
    };
    private int count;
    private int coverDefId;
    private int coverHintId;
    private String coverUrl;
    private int title;

    public LocalPlayListBean() {
    }

    protected LocalPlayListBean(Parcel parcel) {
        this.coverUrl = parcel.readString();
        this.coverHintId = parcel.readInt();
        this.coverDefId = parcel.readInt();
        this.title = parcel.readInt();
        this.count = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.coverUrl);
        parcel.writeInt(this.coverHintId);
        parcel.writeInt(this.coverDefId);
        parcel.writeInt(this.title);
        parcel.writeInt(this.count);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public int getCoverHintId() {
        return this.coverHintId;
    }

    public void setCoverHintId(int i) {
        this.coverHintId = i;
    }

    public int getCoverDefId() {
        return this.coverDefId;
    }

    public void setCoverDefId(int i) {
        this.coverDefId = i;
    }

    public int getTitle() {
        return this.title;
    }

    public void setTitle(int i) {
        this.title = i;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public String toString() {
        return "LocalPlayListBean{coverUrl='" + this.coverUrl + "', coverHintId=" + this.coverHintId + ", coverDefId=" + this.coverDefId + ", title=" + this.title + ", count=" + this.count + '}';
    }
}
