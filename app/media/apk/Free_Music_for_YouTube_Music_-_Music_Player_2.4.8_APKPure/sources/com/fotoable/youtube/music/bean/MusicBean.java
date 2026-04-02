package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class MusicBean implements Parcelable {
    public static final Parcelable.Creator<MusicBean> CREATOR = new Parcelable.Creator<MusicBean>() { // from class: com.fotoable.youtube.music.bean.MusicBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicBean createFromParcel(Parcel parcel) {
            return new MusicBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicBean[] newArray(int i) {
            return new MusicBean[i];
        }
    };
    @SerializedName("counter")
    private MyHttpResponse<CounterBean> counter;
    private String duration;
    private int imgHeight;
    private String imgUrl;
    private int imgWidth;
    private int isFav;
    private String title;
    private String videoid;

    protected MusicBean(Parcel parcel) {
        this.videoid = parcel.readString();
        this.title = parcel.readString();
        this.imgUrl = parcel.readString();
        this.imgWidth = parcel.readInt();
        this.imgHeight = parcel.readInt();
        this.duration = parcel.readString();
        this.isFav = parcel.readInt();
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

    public int getIsFav() {
        return this.isFav;
    }

    public void setIsFav(int i) {
        this.isFav = i;
    }

    public void setCounter(MyHttpResponse<CounterBean> myHttpResponse) {
        this.counter = myHttpResponse;
    }

    public MyHttpResponse<CounterBean> getCounter() {
        return this.counter;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.videoid);
        parcel.writeString(this.title);
        parcel.writeString(this.imgUrl);
        parcel.writeInt(this.imgWidth);
        parcel.writeInt(this.imgHeight);
        parcel.writeString(this.duration);
        parcel.writeInt(this.isFav);
    }
}
