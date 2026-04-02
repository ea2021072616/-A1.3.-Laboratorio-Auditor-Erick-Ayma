package com.fotoable.youtube.music.newplayer.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class LocalMusicModel implements Parcelable {
    public static final Parcelable.Creator<LocalMusicModel> CREATOR = new Parcelable.Creator<LocalMusicModel>() { // from class: com.fotoable.youtube.music.newplayer.model.LocalMusicModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalMusicModel createFromParcel(Parcel parcel) {
            return new LocalMusicModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalMusicModel[] newArray(int i) {
            return new LocalMusicModel[i];
        }
    };
    public String albumData;
    public int albumId;
    public String albumName;
    public long artistId;
    public String artistName;
    public String data;
    public int duration;
    public String folder;
    public boolean islocal;
    public String lrc;
    public int size;
    public long songId;
    public String songName;
    public String sort;

    public LocalMusicModel() {
        this.songId = -1L;
        this.albumId = -1;
    }

    protected LocalMusicModel(Parcel parcel) {
        this.songId = -1L;
        this.albumId = -1;
        this.songId = parcel.readLong();
        this.albumId = parcel.readInt();
        this.artistId = parcel.readLong();
        this.duration = parcel.readInt();
        this.songName = parcel.readString();
        this.albumName = parcel.readString();
        this.artistName = parcel.readString();
        this.albumData = parcel.readString();
        this.data = parcel.readString();
        this.folder = parcel.readString();
        this.lrc = parcel.readString();
        this.islocal = parcel.readByte() != 0;
        this.sort = parcel.readString();
        this.size = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.songId);
        parcel.writeInt(this.albumId);
        parcel.writeLong(this.artistId);
        parcel.writeInt(this.duration);
        parcel.writeString(this.songName);
        parcel.writeString(this.albumName);
        parcel.writeString(this.artistName);
        parcel.writeString(this.albumData);
        parcel.writeString(this.data);
        parcel.writeString(this.folder);
        parcel.writeString(this.lrc);
        parcel.writeByte((byte) (this.islocal ? 1 : 0));
        parcel.writeString(this.sort);
        parcel.writeInt(this.size);
    }

    public long getSongId() {
        return this.songId;
    }

    public void setSongId(long j) {
        this.songId = j;
    }

    public int getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(int i) {
        this.albumId = i;
    }

    public long getArtistId() {
        return this.artistId;
    }

    public void setArtistId(long j) {
        this.artistId = j;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public String getSongName() {
        return this.songName;
    }

    public void setSongName(String str) {
        this.songName = str;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public void setArtistName(String str) {
        this.artistName = str;
    }

    public String getAlbumData() {
        return this.albumData;
    }

    public void setAlbumData(String str) {
        this.albumData = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getFolder() {
        return this.folder;
    }

    public void setFolder(String str) {
        this.folder = str;
    }

    public String getLrc() {
        return this.lrc;
    }

    public void setLrc(String str) {
        this.lrc = str;
    }

    public boolean islocal() {
        return this.islocal;
    }

    public void setIslocal(boolean z) {
        this.islocal = z;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String str) {
        this.sort = str;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public String toString() {
        return "LocalMusicModel{songId=" + this.songId + ", albumId=" + this.albumId + ", artistId=" + this.artistId + ", duration=" + this.duration + ", songName='" + this.songName + "', albumName='" + this.albumName + "', artistName='" + this.artistName + "', albumData='" + this.albumData + "', data='" + this.data + "', folder='" + this.folder + "', lrc='" + this.lrc + "', islocal=" + this.islocal + ", sort='" + this.sort + "', size=" + this.size + '}';
    }
}
