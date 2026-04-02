package com.google.android.gms.ads.internal.js;

import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzs implements Runnable {
    final /* synthetic */ zza zzbzb;
    private /* synthetic */ zzm zzbzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(zzm zzmVar, zza zzaVar) {
        this.zzbzc = zzmVar;
        this.zzbzb = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzbzc.zzbza.mLock;
        synchronized (obj) {
            if (this.zzbzc.zzbyz.getStatus() == -1 || this.zzbzc.zzbyz.getStatus() == 1) {
                return;
            }
            this.zzbzc.zzbyz.reject();
            zzbv.zzea();
            zzahf.runOnUiThread(new zzt(this));
            zzafx.v("Could not receive loaded message in a timely manner. Rejecting.");
        }
    }
}
