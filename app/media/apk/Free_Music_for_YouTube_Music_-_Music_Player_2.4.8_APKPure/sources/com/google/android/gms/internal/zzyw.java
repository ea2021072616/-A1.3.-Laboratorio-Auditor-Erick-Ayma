package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzyw implements zzrn {
    private /* synthetic */ zzys zzcly;
    private /* synthetic */ zzoa zzcmc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyw(zzys zzysVar, zzoa zzoaVar) {
        this.zzcly = zzysVar;
        this.zzcmc = zzoaVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        this.zzcly.zzc(this.zzcmc, map.get("asset"));
    }
}
