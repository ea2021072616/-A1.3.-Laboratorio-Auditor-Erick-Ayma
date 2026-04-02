package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.foto.indexlib.IndexBar.bean.BaseIndexBean;
/* loaded from: classes.dex */
public class LocalAlbumBean extends BaseIndexBean implements Parcelable {
    public static final Parcelable.Creator<LocalAlbumBean> CREATOR = new Parcelable.Creator<LocalAlbumBean>() { // from class: com.fotoable.youtube.music.bean.LocalAlbumBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalAlbumBean createFromParcel(Parcel parcel) {
            return new LocalAlbumBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalAlbumBean[] newArray(int i) {
            return new LocalAlbumBean[i];
        }
    };
    public String album_art;
    public String album_artist;
    public int album_id;
    public String album_name;
    public String album_sort;
    public int number_of_songs;

    public String getAlbum_name() {
        return this.album_name;
    }

    public void setAlbum_name(String str) {
        this.album_name = str;
    }

    public int getAlbum_id() {
        return this.album_id;
    }

    public void setAlbum_id(int i) {
        this.album_id = i;
    }

    public int getNumber_of_songs() {
        return this.number_of_songs;
    }

    public void setNumber_of_songs(int i) {
        this.number_of_songs = i;
    }

    public String getAlbum_art() {
        return this.album_art;
    }

    public void setAlbum_art(String str) {
        this.album_art = str;
    }

    public String getAlbum_artist() {
        return this.album_artist;
    }

    public void setAlbum_artist(String str) {
        this.album_artist = str;
    }

    public String getAlbum_sort() {
        return this.album_sort;
    }

    public void setAlbum_sort(String str) {
        this.album_sort = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.album_name);
        parcel.writeInt(this.album_id);
        parcel.writeInt(this.number_of_songs);
        parcel.writeString(this.album_art);
        parcel.writeString(this.album_artist);
        parcel.writeString(this.album_sort);
    }

    public LocalAlbumBean() {
        this.album_id = -1;
        this.number_of_songs = 0;
    }

    protected LocalAlbumBean(Parcel parcel) {
        this.album_id = -1;
        this.number_of_songs = 0;
        this.album_name = parcel.readString();
        this.album_id = parcel.readInt();
        this.number_of_songs = parcel.readInt();
        this.album_art = parcel.readString();
        this.album_artist = parcel.readString();
        this.album_sort = parcel.readString();
    }
}
