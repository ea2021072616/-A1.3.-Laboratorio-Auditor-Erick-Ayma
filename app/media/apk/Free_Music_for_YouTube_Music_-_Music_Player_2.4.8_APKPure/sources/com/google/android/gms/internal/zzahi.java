package com.google.android.gms.internal;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahi implements zzajh {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ String zzdbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahi(zzahf zzahfVar, Context context, String str) {
        this.zzaok = context;
        this.zzdbw = str;
    }

    @Override // com.google.android.gms.internal.zzajh
    public final void zzcm(String str) {
        com.google.android.gms.ads.internal.zzbv.zzea();
        zzahf.zzd(this.zzaok, this.zzdbw, str);
    }
}
