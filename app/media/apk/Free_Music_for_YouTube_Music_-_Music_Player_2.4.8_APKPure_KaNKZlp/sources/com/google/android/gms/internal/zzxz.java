package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zzxz implements Runnable {
    private /* synthetic */ zzxy zzckp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxz(zzxy zzxyVar) {
        this.zzckp = zzxyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzckp.onStop();
    }
}
