package com.google.android.gms.internal;

import android.content.Context;
/* loaded from: classes2.dex */
final class zzlm implements Runnable {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzll zzbeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlm(zzll zzllVar, Context context) {
        this.zzbeo = zzllVar;
        this.zzaok = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbeo.getRewardedVideoAdInstance(this.zzaok);
    }
}
