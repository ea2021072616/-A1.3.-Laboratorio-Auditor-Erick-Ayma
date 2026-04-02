package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.net.Uri;
/* loaded from: classes.dex */
final class zzaie implements DialogInterface.OnClickListener {
    private /* synthetic */ zzaid zzdco;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaie(zzaid zzaidVar) {
        this.zzdco = zzaidVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzbv.zzea();
        zzahf.zza(this.zzdco.zzaok, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
