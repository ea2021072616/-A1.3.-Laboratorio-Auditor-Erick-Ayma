package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
/* loaded from: classes.dex */
public final class zzo extends zze {
    private /* synthetic */ zzd zzftf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzo(zzd zzdVar, int i, @Nullable Bundle bundle) {
        super(zzdVar, i, null);
        this.zzftf = zzdVar;
    }

    @Override // com.google.android.gms.common.internal.zze
    protected final boolean zzajn() {
        this.zzftf.zzfsr.zzf(ConnectionResult.zzfez);
        return true;
    }

    @Override // com.google.android.gms.common.internal.zze
    protected final void zzj(ConnectionResult connectionResult) {
        this.zzftf.zzfsr.zzf(connectionResult);
        this.zzftf.onConnectionFailed(connectionResult);
    }
}
