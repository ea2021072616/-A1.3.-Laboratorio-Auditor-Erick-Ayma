package com.google.android.gms.internal;

import android.content.Context;
/* loaded from: classes.dex */
final class zzaab implements zzaad {
    private /* synthetic */ Context zzaok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaab(Context context) {
        this.zzaok = context;
    }

    @Override // com.google.android.gms.internal.zzaad
    public final boolean zza(zzajk zzajkVar) {
        zzjo.zzhu();
        boolean zzba = zzaje.zzba(this.zzaok);
        boolean z = ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbpk)).booleanValue() && zzajkVar.zzden;
        if (zzaaa.zzd(this.zzaok, zzajkVar.zzden) && zzba && !z) {
            if (!com.google.android.gms.common.util.zzi.zzcl(this.zzaok)) {
                return false;
            }
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhm)).booleanValue()) {
                return false;
            }
        }
        return true;
    }
}
