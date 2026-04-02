package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzt
/* loaded from: classes.dex */
public final class zzim implements Runnable {
    private final int zzbaz;
    private /* synthetic */ zzil zzbba;

    public zzim(zzil zzilVar, int i) {
        this.zzbba = zzilVar;
        this.zzbaz = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        synchronized (this.zzbba) {
            i = this.zzbba.zzbax;
            if (i == this.zzbaz) {
                this.zzbba.zzhh();
            }
        }
    }
}
