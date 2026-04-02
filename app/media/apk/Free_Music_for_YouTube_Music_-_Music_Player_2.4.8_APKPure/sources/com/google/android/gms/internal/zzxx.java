package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
final class zzxx implements Runnable {
    private /* synthetic */ zzxw zzcko;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxx(zzxw zzxwVar) {
        this.zzcko = zzxwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.zzcko.zzckn;
        if (atomicBoolean.get()) {
            zzafx.e("Timed out waiting for WebView to finish loading.");
            this.zzcko.cancel();
        }
    }
}
