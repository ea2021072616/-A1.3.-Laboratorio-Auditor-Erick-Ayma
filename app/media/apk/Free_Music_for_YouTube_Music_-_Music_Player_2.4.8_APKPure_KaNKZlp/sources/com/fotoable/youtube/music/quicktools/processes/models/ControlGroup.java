package com.fotoable.youtube.music.quicktools.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ControlGroup implements Parcelable {
    public static final Parcelable.Creator<ControlGroup> CREATOR = new Parcelable.Creator<ControlGroup>() { // from class: com.fotoable.youtube.music.quicktools.processes.models.ControlGroup.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControlGroup createFromParcel(Parcel parcel) {
            return new ControlGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControlGroup[] newArray(int i) {
            return new ControlGroup[i];
        }
    };
    public final String group;
    public final int id;
    public final String subsystems;

    /* JADX INFO: Access modifiers changed from: protected */
    public ControlGroup(String str) throws NumberFormatException, IndexOutOfBoundsException {
        String[] split = str.split(":");
        this.id = Integer.parseInt(split[0]);
        this.subsystems = split[1];
        this.group = split[2];
    }

    protected ControlGroup(Parcel parcel) {
        this.id = parcel.readInt();
        this.subsystems = parcel.readString();
        this.group = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.subsystems);
        parcel.writeString(this.group);
    }
}
