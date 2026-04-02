package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzhx implements Runnable {
    private /* synthetic */ zzhw zzbai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhx(zzhw zzhwVar) {
        this.zzbai = zzhwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbai.disconnect();
    }
}
