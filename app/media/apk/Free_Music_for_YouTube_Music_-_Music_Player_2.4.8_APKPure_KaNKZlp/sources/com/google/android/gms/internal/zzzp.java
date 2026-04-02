package com.google.android.gms.internal;

import java.lang.Thread;
/* loaded from: classes2.dex */
final class zzzp implements Thread.UncaughtExceptionHandler {
    private /* synthetic */ Thread.UncaughtExceptionHandler zzcng;
    private /* synthetic */ zzzo zzcnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzp(zzzo zzzoVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzcnh = zzzoVar;
        this.zzcng = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzcnh.zza(thread, th);
        } catch (Throwable th2) {
            try {
                zzafx.e("AdMob exception reporter failed reporting the exception.");
                if (this.zzcng != null) {
                    this.zzcng.uncaughtException(thread, th);
                }
            } finally {
                if (this.zzcng != null) {
                    this.zzcng.uncaughtException(thread, th);
                }
            }
        }
    }
}
