package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzaka;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzae implements zzaka {
    private /* synthetic */ zzy zzbzp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(zzac zzacVar, zzy zzyVar) {
        this.zzbzp = zzyVar;
    }

    @Override // com.google.android.gms.internal.zzaka
    public final void run() {
        zzafx.v("Rejecting reference for JS Engine.");
        this.zzbzp.reject();
    }
}
