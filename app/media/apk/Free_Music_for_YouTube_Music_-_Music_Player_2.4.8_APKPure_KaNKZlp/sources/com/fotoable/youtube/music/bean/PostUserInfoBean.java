package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class PostUserInfoBean implements Parcelable {
    public static final Parcelable.Creator<PostUserInfoBean> CREATOR = new Parcelable.Creator<PostUserInfoBean>() { // from class: com.fotoable.youtube.music.bean.PostUserInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PostUserInfoBean createFromParcel(Parcel parcel) {
            return new PostUserInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PostUserInfoBean[] newArray(int i) {
            return new PostUserInfoBean[i];
        }
    };
    private PostUserInfoDataBean data;

    public PostUserInfoBean() {
    }

    protected PostUserInfoBean(Parcel parcel) {
        this.data = (PostUserInfoDataBean) parcel.readParcelable(getClass().getClassLoader());
    }

    public PostUserInfoDataBean getData() {
        return this.data;
    }

    public void setData(PostUserInfoDataBean postUserInfoDataBean) {
        this.data = postUserInfoDataBean;
    }

    public String toString() {
        return "PostUserInfoBean{data=" + this.data + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.data, i);
    }
}
