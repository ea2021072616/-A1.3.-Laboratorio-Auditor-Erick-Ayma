package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzec implements Runnable {
    private /* synthetic */ zzeb zzajz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzec(zzeb zzebVar) {
        this.zzajz = zzebVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzajz.zzav();
    }
}
