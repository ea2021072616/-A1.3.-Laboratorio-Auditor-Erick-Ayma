package com.google.android.gms.internal.play_billing;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public abstract class l3 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f1921a = 0;

    static {
        l3.class.getClassLoader();
    }

    public static Parcelable a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }
}
