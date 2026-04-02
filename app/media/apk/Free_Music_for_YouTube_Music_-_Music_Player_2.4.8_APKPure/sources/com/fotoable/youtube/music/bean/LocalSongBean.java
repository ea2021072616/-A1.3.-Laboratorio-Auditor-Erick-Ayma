package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.foto.indexlib.IndexBar.bean.BaseIndexBean;
/* loaded from: classes.dex */
public class LocalSongBean extends BaseIndexBean implements Parcelable {
    public static final Parcelable.Creator<LocalSongBean> CREATOR = new Parcelable.Creator<LocalSongBean>() { // from class: com.fotoable.youtube.music.bean.LocalSongBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalSongBean createFromParcel(Parcel parcel) {
            return new LocalSongBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalSongBean[] newArray(int i) {
            return new LocalSongBean[i];
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
    public Boolean islocal;
    public String lrc;
    public int size;
    public Long songId;
    public String songName;
    public String sort;

    public LocalSongBean() {
        this.songId = -1L;
        this.albumId = -1;
    }

    public Long getSongId() {
        return this.songId;
    }

    public void setSongId(Long l) {
        this.songId = l;
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

    public Boolean getIslocal() {
        return this.islocal;
    }

    public void setIslocal(Boolean bool) {
        this.islocal = bool;
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

    public LocalSongBean(Long l, int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, int i3) {
        this.songId = -1L;
        this.albumId = -1;
        this.songId = l;
        this.albumId = i;
        this.artistId = j;
        this.duration = i2;
        this.songName = str;
        this.albumName = str2;
        this.artistName = str3;
        this.albumData = str4;
        this.data = str5;
        this.folder = str6;
        this.lrc = str7;
        this.islocal = bool;
        this.sort = str8;
        this.size = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.songId);
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
        parcel.writeValue(this.islocal);
        parcel.writeString(this.sort);
        parcel.writeInt(this.size);
    }

    protected LocalSongBean(Parcel parcel) {
        this.songId = -1L;
        this.albumId = -1;
        this.songId = (Long) parcel.readValue(Long.class.getClassLoader());
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
        this.islocal = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.sort = parcel.readString();
        this.size = parcel.readInt();
    }
}
