package com.google.android.gms.internal;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaia implements Runnable {
    private /* synthetic */ zzahw zzdcf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaia(zzahw zzahwVar) {
        this.zzdcf = zzahwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        String str;
        String str2;
        zzaic zzej = com.google.android.gms.ads.internal.zzbv.zzej();
        context = this.zzdcf.mContext;
        str = this.zzdcf.zzapb;
        str2 = this.zzdcf.zzaux;
        zzej.zzf(context, str, str2);
    }
}
