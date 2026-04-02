package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzix;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbm implements Runnable {
    private /* synthetic */ WeakReference zzarm;
    private /* synthetic */ zzbl zzarn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbm(zzbl zzblVar, WeakReference weakReference) {
        this.zzarn = zzblVar;
        this.zzarm = weakReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzix zzixVar;
        zzbl.zza(this.zzarn, false);
        zza zzaVar = (zza) this.zzarm.get();
        if (zzaVar != null) {
            zzixVar = this.zzarn.zzari;
            if (zzaVar.zzc(zzixVar)) {
                zzaVar.zzb(zzixVar);
                return;
            }
            zzafx.zzcr("Ad is not visible. Not refreshing ad.");
            zzaVar.zzamr.zzg(zzixVar);
        }
    }
}
