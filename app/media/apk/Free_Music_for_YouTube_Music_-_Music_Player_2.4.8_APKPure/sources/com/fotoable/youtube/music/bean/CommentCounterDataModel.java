package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class CommentCounterDataModel implements Parcelable {
    public static final Parcelable.Creator<CommentCounterDataModel> CREATOR = new Parcelable.Creator<CommentCounterDataModel>() { // from class: com.fotoable.youtube.music.bean.CommentCounterDataModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentCounterDataModel createFromParcel(Parcel parcel) {
            return new CommentCounterDataModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentCounterDataModel[] newArray(int i) {
            return new CommentCounterDataModel[i];
        }
    };
    private long commentsCount;
    private long comments_like_count;

    public CommentCounterDataModel() {
    }

    protected CommentCounterDataModel(Parcel parcel) {
        this.comments_like_count = parcel.readLong();
        this.commentsCount = parcel.readLong();
    }

    public long getComments_like_count() {
        return this.comments_like_count;
    }

    public void setComments_like_count(long j) {
        this.comments_like_count = j;
    }

    public long getCommentsCount() {
        return this.commentsCount;
    }

    public void setCommentsCount(long j) {
        this.commentsCount = j;
    }

    public String toString() {
        return "CommentCounterDataModel{comments_like_count=" + this.comments_like_count + ", commentsCount=" + this.commentsCount + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.comments_like_count);
        parcel.writeLong(this.commentsCount);
    }
}
