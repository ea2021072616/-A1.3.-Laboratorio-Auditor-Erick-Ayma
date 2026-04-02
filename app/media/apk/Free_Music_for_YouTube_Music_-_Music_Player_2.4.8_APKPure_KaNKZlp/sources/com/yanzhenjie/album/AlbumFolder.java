package com.yanzhenjie.album;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlbumFolder implements Parcelable {
    public static final Parcelable.Creator<AlbumFolder> CREATOR = new Parcelable.Creator<AlbumFolder>() { // from class: com.yanzhenjie.album.AlbumFolder.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumFolder createFromParcel(Parcel parcel) {
            return new AlbumFolder(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumFolder[] newArray(int i) {
            return new AlbumFolder[i];
        }
    };
    private int id;
    private boolean isChecked;
    private ArrayList<AlbumFile> mAlbumFiles;
    private String name;

    public AlbumFolder() {
        this.mAlbumFiles = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public ArrayList<AlbumFile> getAlbumFiles() {
        return this.mAlbumFiles;
    }

    public void addAlbumFile(AlbumFile albumFile) {
        if (!this.mAlbumFiles.contains(albumFile)) {
            this.mAlbumFiles.add(albumFile);
        }
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    protected AlbumFolder(Parcel parcel) {
        this.mAlbumFiles = new ArrayList<>();
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.mAlbumFiles = parcel.createTypedArrayList(AlbumFile.CREATOR);
        this.isChecked = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeTypedList(this.mAlbumFiles);
        parcel.writeByte((byte) (this.isChecked ? 1 : 0));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
