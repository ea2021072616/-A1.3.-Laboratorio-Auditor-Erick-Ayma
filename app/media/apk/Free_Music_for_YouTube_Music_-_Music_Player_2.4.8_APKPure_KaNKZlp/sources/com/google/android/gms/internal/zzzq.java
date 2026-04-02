package com.google.android.gms.internal;

import java.lang.Thread;
/* loaded from: classes2.dex */
final class zzzq implements Thread.UncaughtExceptionHandler {
    private /* synthetic */ zzzo zzcnh;
    private /* synthetic */ Thread.UncaughtExceptionHandler zzcni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzq(zzzo zzzoVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzcnh = zzzoVar;
        this.zzcni = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzcnh.zza(thread, th);
        } catch (Throwable th2) {
            try {
                zzafx.e("AdMob exception reporter failed reporting the exception.");
                if (this.zzcni != null) {
                    this.zzcni.uncaughtException(thread, th);
                }
            } finally {
                if (this.zzcni != null) {
                    this.zzcni.uncaughtException(thread, th);
                }
            }
        }
    }
}
