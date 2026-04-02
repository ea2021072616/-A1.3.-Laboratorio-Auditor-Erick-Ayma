package com.fotoable.youtube.music.quicktools.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
/* loaded from: classes.dex */
public final class Statm extends ProcFile {
    public static final Parcelable.Creator<Statm> CREATOR = new Parcelable.Creator<Statm>() { // from class: com.fotoable.youtube.music.quicktools.processes.models.Statm.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Statm createFromParcel(Parcel parcel) {
            return new Statm(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Statm[] newArray(int i) {
            return new Statm[i];
        }
    };
    public final String[] fields;

    public static Statm get(int i) throws IOException {
        return new Statm(String.format("/proc/%d/statm", Integer.valueOf(i)));
    }

    private Statm(String str) throws IOException {
        super(str);
        this.fields = this.content.split("\\s+");
    }

    private Statm(Parcel parcel) {
        super(parcel);
        this.fields = parcel.createStringArray();
    }

    public long getSize() {
        return Long.parseLong(this.fields[0]) * 1024;
    }

    public long getResidentSetSize() {
        return Long.parseLong(this.fields[1]) * 1024;
    }

    @Override // com.fotoable.youtube.music.quicktools.processes.models.ProcFile, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.fotoable.youtube.music.quicktools.processes.models.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeStringArray(this.fields);
    }
}
