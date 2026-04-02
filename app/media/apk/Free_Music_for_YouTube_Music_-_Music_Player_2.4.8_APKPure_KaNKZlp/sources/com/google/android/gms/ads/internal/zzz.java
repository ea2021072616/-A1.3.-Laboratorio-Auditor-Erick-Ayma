package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzakt;
/* loaded from: classes.dex */
final class zzz implements zzakt {
    private /* synthetic */ zzafi zzany;
    private /* synthetic */ Runnable zzanz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(zzx zzxVar, zzafi zzafiVar, Runnable runnable) {
        this.zzany = zzafiVar;
        this.zzanz = runnable;
    }

    @Override // com.google.android.gms.internal.zzakt
    public final void zzcr() {
        if (this.zzany.zzcyd) {
            return;
        }
        zzbv.zzea();
        zzahf.zzb(this.zzanz);
    }
}
