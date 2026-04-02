package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class PostImageBean implements Parcelable {
    public static final Parcelable.Creator<PostImageBean> CREATOR = new Parcelable.Creator<PostImageBean>() { // from class: com.fotoable.youtube.music.bean.PostImageBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PostImageBean createFromParcel(Parcel parcel) {
            return new PostImageBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PostImageBean[] newArray(int i) {
            return new PostImageBean[i];
        }
    };
    private String imgUrl;
    private String thumbUrl;

    public PostImageBean() {
    }

    protected PostImageBean(Parcel parcel) {
        this.thumbUrl = parcel.readString();
        this.imgUrl = parcel.readString();
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public String toString() {
        return "PostImageBean{thumbUrl='" + this.thumbUrl + "', imgUrl='" + this.imgUrl + "'}";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.imgUrl);
    }
}
