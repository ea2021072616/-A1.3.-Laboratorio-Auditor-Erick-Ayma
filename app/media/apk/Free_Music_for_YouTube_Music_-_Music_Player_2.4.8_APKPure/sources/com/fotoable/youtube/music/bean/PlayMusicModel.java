package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class PlayMusicModel implements Parcelable {
    public static final Parcelable.Creator<PlayMusicModel> CREATOR = new Parcelable.Creator<PlayMusicModel>() { // from class: com.fotoable.youtube.music.bean.PlayMusicModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlayMusicModel createFromParcel(Parcel parcel) {
            return new PlayMusicModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlayMusicModel[] newArray(int i) {
            return new PlayMusicModel[i];
        }
    };
    private String artists;
    private String coverImg;
    private String description;
    private String duration;
    private Long id;
    private boolean isFav;
    private Long playlistId;
    private String title;
    private String videoId;

    public PlayMusicModel() {
    }

    public PlayMusicModel(Long l, String str, String str2, String str3, String str4, boolean z, String str5, String str6, Long l2) {
        this.id = l;
        this.videoId = str;
        this.coverImg = str2;
        this.title = str3;
        this.description = str4;
        this.isFav = z;
        this.duration = str5;
        this.artists = str6;
        this.playlistId = l2;
    }

    public Long getPlaylistId() {
        return this.playlistId;
    }

    public void setPlaylistId(Long l) {
        this.playlistId = l;
    }

    public static Parcelable.Creator<PlayMusicModel> getCREATOR() {
        return CREATOR;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setArtists(String str) {
        this.artists = str;
    }

    public String getArtists() {
        return this.artists;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public String getCoverImg() {
        return this.coverImg;
    }

    public void setCoverImg(String str) {
        this.coverImg = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public boolean isFav() {
        return this.isFav;
    }

    public void setFav(boolean z) {
        this.isFav = z;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    protected PlayMusicModel(Parcel parcel) {
        this.videoId = parcel.readString();
        this.coverImg = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.isFav = parcel.readByte() != 0;
        this.duration = parcel.readString();
        this.artists = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.videoId);
        parcel.writeString(this.coverImg);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByte((byte) (this.isFav ? 1 : 0));
        parcel.writeString(this.duration);
        parcel.writeString(this.artists);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getIsFav() {
        return this.isFav;
    }

    public void setIsFav(boolean z) {
        this.isFav = z;
    }

    public String toString() {
        return "PlayMusicModel{id=" + this.id + ", videoId='" + this.videoId + "', coverImg='" + this.coverImg + "', title='" + this.title + "', description='" + this.description + "', isFav=" + this.isFav + ", duration='" + this.duration + "', artists='" + this.artists + "', playlistId=" + this.playlistId + '}';
    }
}
