package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzacp implements zzaka {
    private /* synthetic */ com.google.android.gms.ads.internal.js.zzy zzcvi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacp(zzacm zzacmVar, com.google.android.gms.ads.internal.js.zzy zzyVar) {
        this.zzcvi = zzyVar;
    }

    @Override // com.google.android.gms.internal.zzaka
    public final void run() {
        this.zzcvi.release();
    }
}
