package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b4.j;
import com.google.android.gms.common.internal.ReflectedParcelable;
import m2.a;
/* loaded from: classes.dex */
public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new androidx.activity.result.a(23);

    /* renamed from: b  reason: collision with root package name */
    public final int f1823b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1824c;

    public Scope(int i5, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("scopeUri must not be null or empty");
        }
        this.f1823b = i5;
        this.f1824c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f1824c.equals(((Scope) obj).f1824c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1824c.hashCode();
    }

    public final String toString() {
        return this.f1824c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = j.o0(parcel, 20293);
        j.h0(parcel, 1, this.f1823b);
        j.j0(parcel, 2, this.f1824c);
        j.t0(parcel, o02);
    }
}
