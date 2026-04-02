package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzakc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzad implements zzakc<zza> {
    private /* synthetic */ zzy zzbzp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzac zzacVar, zzy zzyVar) {
        this.zzbzp = zzyVar;
    }

    @Override // com.google.android.gms.internal.zzakc
    public final /* synthetic */ void zzc(zza zzaVar) {
        zzafx.v("Getting a new session for JS Engine.");
        this.zzbzp.zzf(zzaVar.zzla());
    }
}
