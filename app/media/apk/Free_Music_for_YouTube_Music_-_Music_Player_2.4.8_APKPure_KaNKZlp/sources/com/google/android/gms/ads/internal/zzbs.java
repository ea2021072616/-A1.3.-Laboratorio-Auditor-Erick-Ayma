package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzev;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbs implements Callable<zzev> {
    private /* synthetic */ zzbp zzaru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbs(zzbp zzbpVar) {
        this.zzaru = zzbpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzev call() throws Exception {
        zzajk zzajkVar;
        Context context;
        zzajkVar = this.zzaru.zzapc;
        String str = zzajkVar.zzcp;
        context = this.zzaru.mContext;
        return new zzev(str, context, false);
    }
}
