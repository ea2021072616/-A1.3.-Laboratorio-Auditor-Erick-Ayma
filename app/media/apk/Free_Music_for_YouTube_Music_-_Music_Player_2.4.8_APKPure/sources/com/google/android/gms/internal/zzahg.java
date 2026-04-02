package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahg implements zzns {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ List zzdbt;
    private /* synthetic */ zznr zzdbu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahg(zzahf zzahfVar, List list, zznr zznrVar, Context context) {
        this.zzdbt = list;
        this.zzdbu = zznrVar;
        this.zzaok = context;
    }

    @Override // com.google.android.gms.internal.zzns
    public final void zzjb() {
        for (String str : this.zzdbt) {
            String valueOf = String.valueOf(str);
            zzafx.zzcr(valueOf.length() != 0 ? "Pinging url: ".concat(valueOf) : new String("Pinging url: "));
            this.zzdbu.mayLaunchUrl(Uri.parse(str), null, null);
        }
        this.zzdbu.zzc((Activity) this.zzaok);
    }
}
