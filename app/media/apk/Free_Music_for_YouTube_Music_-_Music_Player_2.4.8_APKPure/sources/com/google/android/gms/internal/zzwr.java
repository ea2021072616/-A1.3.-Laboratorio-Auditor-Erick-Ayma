package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzwr implements DialogInterface.OnClickListener {
    private /* synthetic */ zzwq zzcdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwr(zzwq zzwqVar) {
        this.zzcdq = zzwqVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        Intent createIntent = this.zzcdq.createIntent();
        com.google.android.gms.ads.internal.zzbv.zzea();
        context = this.zzcdq.mContext;
        zzahf.zzb(context, createIntent);
    }
}
