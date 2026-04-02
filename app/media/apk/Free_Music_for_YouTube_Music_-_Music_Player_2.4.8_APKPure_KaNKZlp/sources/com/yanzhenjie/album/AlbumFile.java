package com.yanzhenjie.album;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class AlbumFile implements Parcelable, Comparable<AlbumFile> {
    public static final Parcelable.Creator<AlbumFile> CREATOR = new Parcelable.Creator<AlbumFile>() { // from class: com.yanzhenjie.album.AlbumFile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumFile createFromParcel(Parcel parcel) {
            return new AlbumFile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumFile[] newArray(int i) {
            return new AlbumFile[i];
        }
    };
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_INVALID = 0;
    public static final int TYPE_VIDEO = 2;
    private boolean isChecked;
    private boolean isEnable;
    private long mAddDate;
    private int mBucketId;
    private String mBucketName;
    private long mDuration;
    private int mHeight;
    private float mLatitude;
    private float mLongitude;
    private int mMediaType;
    private String mMimeType;
    private long mModifyDate;
    private String mName;
    private String mPath;
    private long mSize;
    private String mThumbPath;
    private String mTitle;
    private int mWidth;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MediaType {
    }

    public AlbumFile() {
        this.isEnable = true;
    }

    @Override // java.lang.Comparable
    public int compareTo(AlbumFile albumFile) {
        long addDate = albumFile.getAddDate() - getAddDate();
        if (addDate > 2147483647L) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        if (addDate < -2147483647L) {
            return -2147483647;
        }
        return (int) addDate;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AlbumFile)) {
            AlbumFile albumFile = (AlbumFile) obj;
            if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(albumFile.getPath())) {
                return this.mPath.equals(albumFile.getPath());
            }
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return (this.mBucketId + this.mPath).hashCode();
    }

    public String getPath() {
        return this.mPath;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public int getBucketId() {
        return this.mBucketId;
    }

    public void setBucketId(int i) {
        this.mBucketId = i;
    }

    public String getBucketName() {
        return this.mBucketName;
    }

    public void setBucketName(String str) {
        this.mBucketName = str;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public void setMimeType(String str) {
        this.mMimeType = str;
    }

    public long getAddDate() {
        return this.mAddDate;
    }

    public void setAddDate(long j) {
        this.mAddDate = j;
    }

    public long getModifyDate() {
        return this.mModifyDate;
    }

    public void setModifyDate(long j) {
        this.mModifyDate = j;
    }

    public float getLatitude() {
        return this.mLatitude;
    }

    public void setLatitude(float f) {
        this.mLatitude = f;
    }

    public float getLongitude() {
        return this.mLongitude;
    }

    public void setLongitude(float f) {
        this.mLongitude = f;
    }

    public long getSize() {
        return this.mSize;
    }

    public void setSize(long j) {
        this.mSize = j;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public String getThumbPath() {
        return this.mThumbPath;
    }

    public void setThumbPath(String str) {
        this.mThumbPath = str;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public void setMediaType(int i) {
        this.mMediaType = i;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    protected AlbumFile(Parcel parcel) {
        this.isEnable = true;
        this.mPath = parcel.readString();
        this.mName = parcel.readString();
        this.mTitle = parcel.readString();
        this.mBucketId = parcel.readInt();
        this.mBucketName = parcel.readString();
        this.mMimeType = parcel.readString();
        this.mAddDate = parcel.readLong();
        this.mModifyDate = parcel.readLong();
        this.mLatitude = parcel.readFloat();
        this.mLongitude = parcel.readFloat();
        this.mSize = parcel.readLong();
        this.mDuration = parcel.readLong();
        this.mThumbPath = parcel.readString();
        this.mWidth = parcel.readInt();
        this.mHeight = parcel.readInt();
        this.mMediaType = parcel.readInt();
        this.isChecked = parcel.readByte() != 0;
        this.isEnable = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPath);
        parcel.writeString(this.mName);
        parcel.writeString(this.mTitle);
        parcel.writeInt(this.mBucketId);
        parcel.writeString(this.mBucketName);
        parcel.writeString(this.mMimeType);
        parcel.writeLong(this.mAddDate);
        parcel.writeLong(this.mModifyDate);
        parcel.writeFloat(this.mLatitude);
        parcel.writeFloat(this.mLongitude);
        parcel.writeLong(this.mSize);
        parcel.writeLong(this.mDuration);
        parcel.writeString(this.mThumbPath);
        parcel.writeInt(this.mWidth);
        parcel.writeInt(this.mHeight);
        parcel.writeInt(this.mMediaType);
        parcel.writeByte((byte) (this.isChecked ? 1 : 0));
        parcel.writeByte((byte) (this.isEnable ? 1 : 0));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
