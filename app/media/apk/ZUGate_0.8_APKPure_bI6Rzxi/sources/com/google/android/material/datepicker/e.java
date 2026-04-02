package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import l2.c0;
/* loaded from: classes.dex */
public final class e implements b {
    public static final Parcelable.Creator<e> CREATOR = new c0(11);

    /* renamed from: b  reason: collision with root package name */
    public final long f2111b;

    public e(long j5) {
        this.f2111b = j5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f2111b == ((e) obj).f2111b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f2111b)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeLong(this.f2111b);
    }
}
