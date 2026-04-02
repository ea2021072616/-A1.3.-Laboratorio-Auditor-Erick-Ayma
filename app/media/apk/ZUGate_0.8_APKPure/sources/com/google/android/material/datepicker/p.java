package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import l2.c0;
/* loaded from: classes.dex */
public final class p implements Comparable, Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new c0(12);

    /* renamed from: b  reason: collision with root package name */
    public final Calendar f2143b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2144c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2145d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2146e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2147f;

    /* renamed from: g  reason: collision with root package name */
    public final long f2148g;

    /* renamed from: h  reason: collision with root package name */
    public String f2149h;

    public p(Calendar calendar) {
        calendar.set(5, 1);
        Calendar b5 = w.b(calendar);
        this.f2143b = b5;
        this.f2144c = b5.get(2);
        this.f2145d = b5.get(1);
        this.f2146e = b5.getMaximum(7);
        this.f2147f = b5.getActualMaximum(5);
        this.f2148g = b5.getTimeInMillis();
    }

    public static p a(int i5, int i6) {
        Calendar d5 = w.d(null);
        d5.set(1, i5);
        d5.set(2, i6);
        return new p(d5);
    }

    public static p b(long j5) {
        Calendar d5 = w.d(null);
        d5.setTimeInMillis(j5);
        return new p(d5);
    }

    public final String c() {
        if (this.f2149h == null) {
            this.f2149h = w.a("yMMMM", Locale.getDefault()).format(new Date(this.f2143b.getTimeInMillis()));
        }
        return this.f2149h;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f2143b.compareTo(((p) obj).f2143b);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return this.f2144c == pVar.f2144c && this.f2145d == pVar.f2145d;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2144c), Integer.valueOf(this.f2145d)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f2145d);
        parcel.writeInt(this.f2144c);
    }
}
