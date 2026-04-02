package com.fotoable.youtube.music.quicktools.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class ProcFile extends File implements Parcelable {
    public static final Parcelable.Creator<ProcFile> CREATOR = new Parcelable.Creator<ProcFile>() { // from class: com.fotoable.youtube.music.quicktools.processes.models.ProcFile.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ProcFile createFromParcel(Parcel parcel) {
            return new ProcFile(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ProcFile[] newArray(int i) {
            return new ProcFile[i];
        }
    };
    public final String content;

    protected static String readFile(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        sb.append(bufferedReader.readLine());
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            sb.append('\n').append(readLine);
        }
        bufferedReader.close();
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ProcFile(String str) throws IOException {
        super(str);
        this.content = readFile(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ProcFile(Parcel parcel) {
        super(parcel.readString());
        this.content = parcel.readString();
    }

    @Override // java.io.File
    public long length() {
        return this.content.length();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getAbsolutePath());
        parcel.writeString(this.content);
    }
}
