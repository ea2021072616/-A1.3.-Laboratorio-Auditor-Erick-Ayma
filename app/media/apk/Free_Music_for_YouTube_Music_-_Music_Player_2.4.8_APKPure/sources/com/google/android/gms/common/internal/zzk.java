package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes.dex */
public final class zzk extends zzaw {
    private zzd zzfth;
    private final int zzfti;

    public zzk(@NonNull zzd zzdVar, int i) {
        this.zzfth = zzdVar;
        this.zzfti = i;
    }

    @Override // com.google.android.gms.common.internal.zzav
    @BinderThread
    public final void zza(int i, @Nullable Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.zzav
    @BinderThread
    public final void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        zzbp.zzb(this.zzfth, "onPostInitComplete can be called only once per call to getRemoteService");
        this.zzfth.zza(i, iBinder, bundle, this.zzfti);
        this.zzfth = null;
    }
}
