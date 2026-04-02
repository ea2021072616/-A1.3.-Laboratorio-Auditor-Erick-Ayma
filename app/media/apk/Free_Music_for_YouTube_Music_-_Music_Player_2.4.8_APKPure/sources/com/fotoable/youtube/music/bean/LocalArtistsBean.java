package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.foto.indexlib.IndexBar.bean.BaseIndexBean;
/* loaded from: classes.dex */
public class LocalArtistsBean extends BaseIndexBean implements Parcelable {
    public static final Parcelable.Creator<LocalArtistsBean> CREATOR = new Parcelable.Creator<LocalArtistsBean>() { // from class: com.fotoable.youtube.music.bean.LocalArtistsBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalArtistsBean createFromParcel(Parcel parcel) {
            return new LocalArtistsBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalArtistsBean[] newArray(int i) {
            return new LocalArtistsBean[i];
        }
    };
    public long artist_id;
    public String artist_name;
    public String artist_sort;
    public String artists_art;
    public int number_of_tracks;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.artists_art);
        parcel.writeString(this.artist_name);
        parcel.writeInt(this.number_of_tracks);
        parcel.writeLong(this.artist_id);
        parcel.writeString(this.artist_sort);
    }

    public String getArtists_art() {
        return this.artists_art;
    }

    public void setArtists_art(String str) {
        this.artists_art = str;
    }

    public String getArtist_name() {
        return this.artist_name;
    }

    public void setArtist_name(String str) {
        this.artist_name = str;
    }

    public int getNumber_of_tracks() {
        return this.number_of_tracks;
    }

    public void setNumber_of_tracks(int i) {
        this.number_of_tracks = i;
    }

    public long getArtist_id() {
        return this.artist_id;
    }

    public void setArtist_id(long j) {
        this.artist_id = j;
    }

    public String getArtist_sort() {
        return this.artist_sort;
    }

    public void setArtist_sort(String str) {
        this.artist_sort = str;
    }

    public LocalArtistsBean() {
    }

    protected LocalArtistsBean(Parcel parcel) {
        this.artists_art = parcel.readString();
        this.artist_name = parcel.readString();
        this.number_of_tracks = parcel.readInt();
        this.artist_id = parcel.readLong();
        this.artist_sort = parcel.readString();
    }
}
