package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzgg implements zzrn {
    private /* synthetic */ zzfy zzawm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgg(zzfy zzfyVar) {
        this.zzawm = zzfyVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        zzfm zzfmVar;
        zzfmVar = this.zzawm.zzawd;
        if (zzfmVar.zzc(map)) {
            zzqx.zzbva.zza(zzakkVar, map);
        }
    }
}
