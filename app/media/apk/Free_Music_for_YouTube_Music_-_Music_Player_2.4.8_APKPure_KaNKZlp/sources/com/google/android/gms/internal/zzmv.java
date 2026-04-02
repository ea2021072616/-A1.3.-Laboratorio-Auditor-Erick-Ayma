package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzmv implements Callable<Void> {
    private /* synthetic */ Context zzaok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmv(Context context) {
        this.zzaok = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        com.google.android.gms.ads.internal.zzbv.zzen().initialize(this.zzaok);
        return null;
    }
}
