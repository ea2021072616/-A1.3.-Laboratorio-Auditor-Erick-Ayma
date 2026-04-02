package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
@KeepName
/* loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzp();
    private IBinder zzftk;

    public BinderWrapper() {
        this.zzftk = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.zzftk = null;
        this.zzftk = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.zzftk = null;
        this.zzftk = parcel.readStrongBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ BinderWrapper(Parcel parcel, zzp zzpVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzftk);
    }
}
