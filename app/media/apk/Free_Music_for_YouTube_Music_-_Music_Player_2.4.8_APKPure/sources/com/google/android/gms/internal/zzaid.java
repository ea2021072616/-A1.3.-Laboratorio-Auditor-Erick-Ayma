package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
/* loaded from: classes.dex */
final class zzaid implements Runnable {
    final /* synthetic */ Context zzaok;
    private /* synthetic */ String zzdcl;
    private /* synthetic */ boolean zzdcm;
    private /* synthetic */ boolean zzdcn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaid(zzaic zzaicVar, Context context, String str, boolean z, boolean z2) {
        this.zzaok = context;
        this.zzdcl = str;
        this.zzdcm = z;
        this.zzdcn = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.zzaok);
        builder.setMessage(this.zzdcl);
        if (this.zzdcm) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        if (this.zzdcn) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new zzaie(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
