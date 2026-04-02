package com.google.android.gms.internal;

import android.content.Context;
@zzzt
/* loaded from: classes.dex */
public final class zzss {
    private final Context mContext;
    private final com.google.android.gms.ads.internal.zzv zzamv;
    private final zzva zzana;
    private final zzajk zzapc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzss(Context context, zzva zzvaVar, zzajk zzajkVar, com.google.android.gms.ads.internal.zzv zzvVar) {
        this.mContext = context;
        this.zzana = zzvaVar;
        this.zzapc = zzajkVar;
        this.zzamv = zzvVar;
    }

    public final Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    public final com.google.android.gms.ads.internal.zzam zzaw(String str) {
        return new com.google.android.gms.ads.internal.zzam(this.mContext, new zzjb(), str, this.zzana, this.zzapc, this.zzamv);
    }

    public final com.google.android.gms.ads.internal.zzam zzax(String str) {
        return new com.google.android.gms.ads.internal.zzam(this.mContext.getApplicationContext(), new zzjb(), str, this.zzana, this.zzapc, this.zzamv);
    }

    public final zzss zzkh() {
        return new zzss(this.mContext.getApplicationContext(), this.zzana, this.zzapc, this.zzamv);
    }
}
