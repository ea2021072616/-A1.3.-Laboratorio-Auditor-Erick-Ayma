package com.google.android.gms.ads.internal.js;

import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
/* loaded from: classes.dex */
final class zzo implements Runnable {
    final /* synthetic */ zzn zzbzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzn zznVar) {
        this.zzbzd = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzbzd.zzbzc.zzbza.mLock;
        synchronized (obj) {
            if (this.zzbzd.zzbzc.zzbyz.getStatus() == -1 || this.zzbzd.zzbzc.zzbyz.getStatus() == 1) {
                return;
            }
            this.zzbzd.zzbzc.zzbyz.reject();
            zzbv.zzea();
            zzahf.runOnUiThread(new zzp(this));
            zzafx.v("Could not receive loaded message in a timely manner. Rejecting.");
        }
    }
}
