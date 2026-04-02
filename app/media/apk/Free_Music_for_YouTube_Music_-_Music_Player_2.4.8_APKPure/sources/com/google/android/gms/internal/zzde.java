package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzde implements Runnable {
    private /* synthetic */ zzdc zzaiv;
    private /* synthetic */ int zzaiw;
    private /* synthetic */ boolean zzaix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzde(zzdc zzdcVar, int i, boolean z) {
        this.zzaiv = zzdcVar;
        this.zzaiw = i;
        this.zzaix = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zza;
        zzax zzb = this.zzaiv.zzb(this.zzaiw, this.zzaix);
        this.zzaiv.zzaim = zzb;
        zza = zzdc.zza(this.zzaiw, zzb);
        if (zza) {
            this.zzaiv.zza(this.zzaiw + 1, this.zzaix);
        }
    }
}
