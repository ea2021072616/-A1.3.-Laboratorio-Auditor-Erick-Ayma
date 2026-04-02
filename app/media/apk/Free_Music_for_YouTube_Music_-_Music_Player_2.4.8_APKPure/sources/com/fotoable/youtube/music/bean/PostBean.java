package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PostBean implements Parcelable {
    public static final Parcelable.Creator<PostBean> CREATOR = new Parcelable.Creator<PostBean>() { // from class: com.fotoable.youtube.music.bean.PostBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PostBean createFromParcel(Parcel parcel) {
            return new PostBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PostBean[] newArray(int i) {
            return new PostBean[i];
        }
    };
    @SerializedName("bigid")
    private String bigId;
    private String body;
    @SerializedName("categoryid")
    private int categoryId;
    private CommentCounter counter;
    private long createdAt;
    private List<PostImageBean> imgUrl;
    public boolean isLike;
    @SerializedName("userinfo")
    private PostUserInfoBean userInfo;
    private String videoArtists;
    private String videoDuration;
    @SerializedName("videoid")
    private String videoId;
    private String videoImgUrl;
    private String videoTitle;

    public PostBean() {
    }

    protected PostBean(Parcel parcel) {
        this.categoryId = parcel.readInt();
        this.bigId = parcel.readString();
        this.body = parcel.readString();
        this.imgUrl = new ArrayList();
        parcel.readList(this.imgUrl, getClass().getClassLoader());
        this.videoId = parcel.readString();
        this.videoTitle = parcel.readString();
        this.videoArtists = parcel.readString();
        this.videoImgUrl = parcel.readString();
        this.videoDuration = parcel.readString();
        this.createdAt = parcel.readLong();
        this.userInfo = (PostUserInfoBean) parcel.readParcelable(getClass().getClassLoader());
        this.counter = (CommentCounter) parcel.readParcelable(getClass().getClassLoader());
        this.isLike = parcel.readByte() != 0;
    }

    public String getVideoArtists() {
        return this.videoArtists;
    }

    public void setVideoArtists(String str) {
        this.videoArtists = str;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public String getBigId() {
        return this.bigId;
    }

    public void setBigId(String str) {
        this.bigId = str;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public List<PostImageBean> getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(List<PostImageBean> list) {
        this.imgUrl = list;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public String getVideoTitle() {
        return this.videoTitle;
    }

    public void setVideoTitle(String str) {
        this.videoTitle = str;
    }

    public String getVideoImgUrl() {
        return this.videoImgUrl;
    }

    public void setVideoImgUrl(String str) {
        this.videoImgUrl = str;
    }

    public String getVideoDuration() {
        return this.videoDuration;
    }

    public void setVideoDuration(String str) {
        this.videoDuration = str;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public PostUserInfoBean getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(PostUserInfoBean postUserInfoBean) {
        this.userInfo = postUserInfoBean;
    }

    public CommentCounter getCounter() {
        return this.counter;
    }

    public void setCounter(CommentCounter commentCounter) {
        this.counter = commentCounter;
    }

    public boolean isLike() {
        return this.isLike;
    }

    public void setLike(boolean z) {
        this.isLike = z;
    }

    public String toString() {
        return "PostBean{categoryId=" + this.categoryId + ", bigId='" + this.bigId + "', body='" + this.body + "', imgUrl=" + this.imgUrl + ", videoId='" + this.videoId + "', videoTitle='" + this.videoTitle + "', videoArtists='" + this.videoArtists + "', videoImgUrl='" + this.videoImgUrl + "', videoDuration='" + this.videoDuration + "', createdAt=" + this.createdAt + ", userInfo=" + this.userInfo + ", counter=" + this.counter + ", isLike=" + this.isLike + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.categoryId);
        parcel.writeString(this.bigId);
        parcel.writeString(this.body);
        parcel.writeList(this.imgUrl);
        parcel.writeString(this.videoId);
        parcel.writeString(this.videoTitle);
        parcel.writeString(this.videoArtists);
        parcel.writeString(this.videoImgUrl);
        parcel.writeString(this.videoDuration);
        parcel.writeLong(this.createdAt);
        parcel.writeParcelable(this.userInfo, i);
        parcel.writeParcelable(this.counter, i);
        parcel.writeByte((byte) (this.isLike ? 1 : 0));
    }
}
