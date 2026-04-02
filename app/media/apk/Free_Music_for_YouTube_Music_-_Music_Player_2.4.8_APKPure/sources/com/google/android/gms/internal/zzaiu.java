package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.zzbp;
@zzzt
/* loaded from: classes.dex */
public final class zzaiu {
    private HandlerThread zzddm = null;
    private Handler mHandler = null;
    private int zzddn = 0;
    private final Object mLock = new Object();

    public final Handler getHandler() {
        return this.mHandler;
    }

    public final Looper zzrj() {
        Looper looper;
        synchronized (this.mLock) {
            if (this.zzddn != 0) {
                zzbp.zzb(this.zzddm, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzddm == null) {
                zzafx.v("Starting the looper thread.");
                this.zzddm = new HandlerThread("LooperProvider");
                this.zzddm.start();
                this.mHandler = new Handler(this.zzddm.getLooper());
                zzafx.v("Looper thread started.");
            } else {
                zzafx.v("Resuming the looper thread");
                this.mLock.notifyAll();
            }
            this.zzddn++;
            looper = this.zzddm.getLooper();
        }
        return looper;
    }
}
