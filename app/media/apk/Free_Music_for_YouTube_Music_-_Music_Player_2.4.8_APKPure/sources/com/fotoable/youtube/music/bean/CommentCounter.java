package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class CommentCounter implements Parcelable {
    public static final Parcelable.Creator<CommentCounter> CREATOR = new Parcelable.Creator<CommentCounter>() { // from class: com.fotoable.youtube.music.bean.CommentCounter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentCounter createFromParcel(Parcel parcel) {
            return new CommentCounter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentCounter[] newArray(int i) {
            return new CommentCounter[i];
        }
    };
    private CommentCounterDataModel data;

    public CommentCounter() {
    }

    protected CommentCounter(Parcel parcel) {
        this.data = (CommentCounterDataModel) parcel.readParcelable(getClass().getClassLoader());
    }

    public CommentCounterDataModel getData() {
        return this.data;
    }

    public void setData(CommentCounterDataModel commentCounterDataModel) {
        this.data = commentCounterDataModel;
    }

    public String toString() {
        return "CommentCounter{data=" + this.data + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.data, i);
    }
}
