package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import l2.c0;
/* loaded from: classes.dex */
public final class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new c0(13);

    /* renamed from: b  reason: collision with root package name */
    public final int f2270b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2271c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2272d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2273e;

    public g(Parcel parcel) {
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        this.f2271c = readInt;
        this.f2272d = readInt2;
        this.f2273e = readInt3;
        this.f2270b = readInt4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f2271c == gVar.f2271c && this.f2272d == gVar.f2272d && this.f2270b == gVar.f2270b && this.f2273e == gVar.f2273e;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2270b), Integer.valueOf(this.f2271c), Integer.valueOf(this.f2272d), Integer.valueOf(this.f2273e)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f2271c);
        parcel.writeInt(this.f2272d);
        parcel.writeInt(this.f2273e);
        parcel.writeInt(this.f2270b);
    }
}
