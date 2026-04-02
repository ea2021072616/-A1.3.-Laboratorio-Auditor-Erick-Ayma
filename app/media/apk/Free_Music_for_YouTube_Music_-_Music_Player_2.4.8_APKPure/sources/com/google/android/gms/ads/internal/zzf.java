package com.google.android.gms.ads.internal;

import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzf implements Callable<String> {
    private /* synthetic */ zzd zzanc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(zzd zzdVar) {
        this.zzanc = zzdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.zzanc.zzams.zzati.zzac().zza(this.zzanc.zzams.zzaie);
    }
}
