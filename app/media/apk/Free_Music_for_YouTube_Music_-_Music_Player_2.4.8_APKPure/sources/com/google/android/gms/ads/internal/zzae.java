package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzrn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzae implements Runnable {
    private /* synthetic */ com.google.android.gms.ads.internal.js.zzl zzaof;
    final /* synthetic */ zzrn zzaog;
    final /* synthetic */ String zzaoh;
    final /* synthetic */ String zzaoi;
    final /* synthetic */ boolean zzaoj;
    final /* synthetic */ Context zzaok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(zzac zzacVar, com.google.android.gms.ads.internal.js.zzl zzlVar, zzrn zzrnVar, String str, String str2, boolean z, Context context) {
        this.zzaof = zzlVar;
        this.zzaog = zzrnVar;
        this.zzaoh = str;
        this.zzaoi = str2;
        this.zzaoj = z;
        this.zzaok = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaof.zzb((zzcv) null).zza(new zzaf(this), new zzakb());
    }
}
