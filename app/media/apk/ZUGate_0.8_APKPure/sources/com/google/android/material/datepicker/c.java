package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import l2.c0;
/* loaded from: classes.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new c0(10);

    /* renamed from: b  reason: collision with root package name */
    public final p f2102b;

    /* renamed from: c  reason: collision with root package name */
    public final p f2103c;

    /* renamed from: d  reason: collision with root package name */
    public final b f2104d;

    /* renamed from: e  reason: collision with root package name */
    public final p f2105e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2106f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2107g;

    /* renamed from: h  reason: collision with root package name */
    public final int f2108h;

    public c(p pVar, p pVar2, b bVar, p pVar3, int i5) {
        Objects.requireNonNull(pVar, "start cannot be null");
        Objects.requireNonNull(pVar2, "end cannot be null");
        Objects.requireNonNull(bVar, "validator cannot be null");
        this.f2102b = pVar;
        this.f2103c = pVar2;
        this.f2105e = pVar3;
        this.f2106f = i5;
        this.f2104d = bVar;
        Calendar calendar = pVar.f2143b;
        if (pVar3 != null && calendar.compareTo(pVar3.f2143b) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (pVar3 != null && pVar3.f2143b.compareTo(pVar2.f2143b) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i5 < 0 || i5 > w.d(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        if (!(calendar instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        int i6 = pVar2.f2145d;
        int i7 = pVar.f2145d;
        this.f2108h = (pVar2.f2144c - pVar.f2144c) + ((i6 - i7) * 12) + 1;
        this.f2107g = (i6 - i7) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f2102b.equals(cVar.f2102b) && this.f2103c.equals(cVar.f2103c) && Objects.equals(this.f2105e, cVar.f2105e) && this.f2106f == cVar.f2106f && this.f2104d.equals(cVar.f2104d);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2102b, this.f2103c, this.f2105e, Integer.valueOf(this.f2106f), this.f2104d});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f2102b, 0);
        parcel.writeParcelable(this.f2103c, 0);
        parcel.writeParcelable(this.f2105e, 0);
        parcel.writeParcelable(this.f2104d, 0);
        parcel.writeInt(this.f2106f);
    }
}
