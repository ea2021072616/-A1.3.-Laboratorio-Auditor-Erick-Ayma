package com.google.android.gms.ads.internal.overlay;

import android.os.Looper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzan implements Runnable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan(zzam zzamVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
