package com.fotoable.youtube.music.newplayer.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class RadioModel implements Parcelable {
    public static final Parcelable.Creator<RadioModel> CREATOR = new Parcelable.Creator<RadioModel>() { // from class: com.fotoable.youtube.music.newplayer.model.RadioModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RadioModel createFromParcel(Parcel parcel) {
            return new RadioModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RadioModel[] newArray(int i) {
            return new RadioModel[i];
        }
    };
    private String audioType;
    private String audioUrl;
    private String countryCode;
    private int id;
    private String imgUrl;
    private String title;

    public RadioModel() {
    }

    protected RadioModel(Parcel parcel) {
        this.id = parcel.readInt();
        this.countryCode = parcel.readString();
        this.title = parcel.readString();
        this.audioType = parcel.readString();
        this.audioUrl = parcel.readString();
        this.imgUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.title);
        parcel.writeString(this.audioType);
        parcel.writeString(this.audioUrl);
        parcel.writeString(this.imgUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getAudioType() {
        return this.audioType;
    }

    public void setAudioType(String str) {
        this.audioType = str;
    }

    public String getAudioUrl() {
        return this.audioUrl;
    }

    public void setAudioUrl(String str) {
        this.audioUrl = str;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public String toString() {
        return "RadioModel{id=" + this.id + ", countryCode='" + this.countryCode + "', title='" + this.title + "', audioType='" + this.audioType + "', audioUrl='" + this.audioUrl + "', imgUrl='" + this.imgUrl + "'}";
    }
}
