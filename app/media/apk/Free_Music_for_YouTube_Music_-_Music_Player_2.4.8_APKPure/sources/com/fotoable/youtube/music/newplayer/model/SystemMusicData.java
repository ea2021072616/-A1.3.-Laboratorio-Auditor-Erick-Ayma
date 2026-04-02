package com.fotoable.youtube.music.newplayer.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class SystemMusicData implements Parcelable {
    public static final Parcelable.Creator<SystemMusicData> CREATOR = new Parcelable.Creator<SystemMusicData>() { // from class: com.fotoable.youtube.music.newplayer.model.SystemMusicData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SystemMusicData createFromParcel(Parcel parcel) {
            return new SystemMusicData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SystemMusicData[] newArray(int i) {
            return new SystemMusicData[i];
        }
    };
    private String album;
    private Bitmap albumArt;
    private String albumArtist;
    private String artist;
    private long duration;
    private String genre;
    private int numTracks;
    private String title;
    private int trackNumber;

    public SystemMusicData() {
    }

    protected SystemMusicData(Parcel parcel) {
        this.artist = parcel.readString();
        this.albumArtist = parcel.readString();
        this.album = parcel.readString();
        this.title = parcel.readString();
        this.duration = parcel.readLong();
        this.trackNumber = parcel.readInt();
        this.numTracks = parcel.readInt();
        this.genre = parcel.readString();
        this.albumArt = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.artist);
        parcel.writeString(this.albumArtist);
        parcel.writeString(this.album);
        parcel.writeString(this.title);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.trackNumber);
        parcel.writeInt(this.numTracks);
        parcel.writeString(this.genre);
        parcel.writeParcelable(this.albumArt, i);
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public String getAlbumArtist() {
        return this.albumArtist;
    }

    public void setAlbumArtist(String str) {
        this.albumArtist = str;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public int getTrackNumber() {
        return this.trackNumber;
    }

    public void setTrackNumber(int i) {
        this.trackNumber = i;
    }

    public int getNumTracks() {
        return this.numTracks;
    }

    public void setNumTracks(int i) {
        this.numTracks = i;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public Bitmap getAlbumArt() {
        return this.albumArt;
    }

    public void setAlbumArt(Bitmap bitmap) {
        this.albumArt = bitmap;
    }

    public String toString() {
        return "SystemMusicData{artist='" + this.artist + "', albumArtist='" + this.albumArtist + "', album='" + this.album + "', title='" + this.title + "', duration=" + this.duration + ", trackNumber=" + this.trackNumber + ", numTracks=" + this.numTracks + ", genre='" + this.genre + "', albumArt=" + this.albumArt + '}';
    }
}
