package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ArtistsCoverModel implements Parcelable {
    public static final Parcelable.Creator<ArtistsCoverModel> CREATOR = new Parcelable.Creator<ArtistsCoverModel>() { // from class: com.fotoable.youtube.music.bean.ArtistsCoverModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ArtistsCoverModel createFromParcel(Parcel parcel) {
            return new ArtistsCoverModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ArtistsCoverModel[] newArray(int i) {
            return new ArtistsCoverModel[i];
        }
    };
    private String artistsName;
    private String coverImg;
    private Long id;
    private Long modifyTime;

    public ArtistsCoverModel() {
    }

    protected ArtistsCoverModel(Parcel parcel) {
        this.artistsName = parcel.readString();
        this.coverImg = parcel.readString();
    }

    public ArtistsCoverModel(Long l, String str, String str2, Long l2) {
        this.id = l;
        this.artistsName = str;
        this.coverImg = str2;
        this.modifyTime = l2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.artistsName);
        parcel.writeString(this.coverImg);
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

    public String getArtistsName() {
        return this.artistsName;
    }

    public void setArtistsName(String str) {
        this.artistsName = str;
    }

    public String getCoverImg() {
        return this.coverImg;
    }

    public void setCoverImg(String str) {
        this.coverImg = str;
    }

    public Long getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Long l) {
        this.modifyTime = l;
    }

    public String toString() {
        return "ArtistsCoverModel{id=" + this.id + ", artistsName='" + this.artistsName + "', coverImg='" + this.coverImg + "', modifyTime=" + this.modifyTime + '}';
    }
}
