package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzaka;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzv implements zzaka {
    private /* synthetic */ zzl zzbza;
    private /* synthetic */ zzac zzbzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzl zzlVar, zzac zzacVar) {
        this.zzbza = zzlVar;
        this.zzbzh = zzacVar;
    }

    @Override // com.google.android.gms.internal.zzaka
    public final void run() {
        Object obj;
        obj = this.zzbza.mLock;
        synchronized (obj) {
            this.zzbza.zzbyx = 1;
            zzafx.v("Failed loading new engine. Marking new engine destroyable.");
            this.zzbzh.zzle();
        }
    }
}
