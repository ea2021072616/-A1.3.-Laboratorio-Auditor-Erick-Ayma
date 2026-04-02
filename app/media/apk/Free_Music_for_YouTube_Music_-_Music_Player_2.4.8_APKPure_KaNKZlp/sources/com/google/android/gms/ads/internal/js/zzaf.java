package com.google.android.gms.ads.internal.js;

import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzakc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaf implements zzakc<zza> {
    final /* synthetic */ zzac zzbzq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(zzac zzacVar) {
        this.zzbzq = zzacVar;
    }

    @Override // com.google.android.gms.internal.zzakc
    public final /* synthetic */ void zzc(zza zzaVar) {
        zzbv.zzea();
        zzahf.runOnUiThread(new zzag(this, zzaVar));
    }
}
