package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class PostUserInfoDataBean implements Parcelable {
    public static final Parcelable.Creator<PostUserInfoDataBean> CREATOR = new Parcelable.Creator<PostUserInfoDataBean>() { // from class: com.fotoable.youtube.music.bean.PostUserInfoDataBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PostUserInfoDataBean createFromParcel(Parcel parcel) {
            return new PostUserInfoDataBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PostUserInfoDataBean[] newArray(int i) {
            return new PostUserInfoDataBean[i];
        }
    };
    private String avatar;
    private int isVip;
    private String name;
    private String uid;

    public PostUserInfoDataBean() {
    }

    protected PostUserInfoDataBean(Parcel parcel) {
        this.uid = parcel.readString();
        this.name = parcel.readString();
        this.avatar = parcel.readString();
        this.isVip = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeInt(this.isVip);
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public int getIsVip() {
        return this.isVip;
    }

    public boolean isVip() {
        return this.isVip == 1;
    }

    public void setIsVip(int i) {
        this.isVip = i;
    }

    public String toString() {
        return "PostUserInfoDataBean{uid='" + this.uid + "', name='" + this.name + "', avatar='" + this.avatar + "', isVip=" + this.isVip + '}';
    }
}
