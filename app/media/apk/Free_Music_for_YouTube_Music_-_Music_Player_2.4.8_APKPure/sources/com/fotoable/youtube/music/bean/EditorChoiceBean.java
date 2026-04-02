package com.fotoable.youtube.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class EditorChoiceBean implements Parcelable {
    public static final Parcelable.Creator<EditorChoiceBean> CREATOR = new Parcelable.Creator<EditorChoiceBean>() { // from class: com.fotoable.youtube.music.bean.EditorChoiceBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EditorChoiceBean createFromParcel(Parcel parcel) {
            return new EditorChoiceBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EditorChoiceBean[] newArray(int i) {
            return new EditorChoiceBean[i];
        }
    };
    private int choiceid;
    private String imgUrl;
    private String title;

    public int getChoiceid() {
        return this.choiceid;
    }

    public void setChoiceid(int i) {
        this.choiceid = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.choiceid);
        parcel.writeString(this.title);
        parcel.writeString(this.imgUrl);
    }

    public EditorChoiceBean() {
    }

    protected EditorChoiceBean(Parcel parcel) {
        this.choiceid = parcel.readInt();
        this.title = parcel.readString();
        this.imgUrl = parcel.readString();
    }
}
