package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahy implements DialogInterface.OnClickListener {
    private /* synthetic */ zzahw zzdcf;
    private /* synthetic */ String zzdcg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahy(zzahw zzahwVar, String str) {
        this.zzdcf = zzahwVar;
        this.zzdcg = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        com.google.android.gms.ads.internal.zzbv.zzea();
        context = this.zzdcf.mContext;
        zzahf.zzb(context, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.zzdcg), "Share via"));
    }
}
