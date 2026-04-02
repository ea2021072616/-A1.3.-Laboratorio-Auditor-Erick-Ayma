package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
/* loaded from: classes.dex */
public final class zzm implements zzj {
    private /* synthetic */ zzd zzftf;

    public zzm(zzd zzdVar) {
        this.zzftf = zzdVar;
    }

    @Override // com.google.android.gms.common.internal.zzj
    public final void zzf(@NonNull ConnectionResult connectionResult) {
        zzg zzgVar;
        zzg zzgVar2;
        if (connectionResult.isSuccess()) {
            this.zzftf.zza((zzam) null, this.zzftf.zzajl());
            return;
        }
        zzgVar = this.zzftf.zzfsx;
        if (zzgVar != null) {
            zzgVar2 = this.zzftf.zzfsx;
            zzgVar2.onConnectionFailed(connectionResult);
        }
    }
}
