package com.google.android.gms.internal;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahx implements DialogInterface.OnClickListener {
    private /* synthetic */ int zzdcc;
    private /* synthetic */ int zzdcd;
    private /* synthetic */ int zzdce;
    private /* synthetic */ zzahw zzdcf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahx(zzahw zzahwVar, int i, int i2, int i3) {
        this.zzdcf = zzahwVar;
        this.zzdcc = i;
        this.zzdcd = i2;
        this.zzdce = i3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == this.zzdcc) {
            this.zzdcf.zzrd();
            return;
        }
        if (i == this.zzdcd) {
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbow)).booleanValue()) {
                this.zzdcf.zzre();
                return;
            }
        }
        if (i == this.zzdce) {
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbox)).booleanValue()) {
                this.zzdcf.zzrf();
            }
        }
    }
}
