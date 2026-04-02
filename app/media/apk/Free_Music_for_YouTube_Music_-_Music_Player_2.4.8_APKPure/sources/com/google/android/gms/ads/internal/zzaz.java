package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzahf;
/* loaded from: classes.dex */
final class zzaz implements Runnable {
    final /* synthetic */ Runnable zzaqs;
    final /* synthetic */ zzay zzaqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaz(zzay zzayVar, Runnable runnable) {
        this.zzaqt = zzayVar;
        this.zzaqs = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbv.zzea();
        zzahf.runOnUiThread(new zzba(this));
    }
}
