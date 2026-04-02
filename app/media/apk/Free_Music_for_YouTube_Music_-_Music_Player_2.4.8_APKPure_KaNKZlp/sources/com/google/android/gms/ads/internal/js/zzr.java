package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzrn;
import java.util.Map;
/* loaded from: classes.dex */
final class zzr implements zzrn {
    private /* synthetic */ zza zzbzb;
    private /* synthetic */ zzm zzbzc;
    private /* synthetic */ zzaiy zzbzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(zzm zzmVar, zza zzaVar, zzaiy zzaiyVar) {
        this.zzbzc = zzmVar;
        this.zzbzb = zzaVar;
        this.zzbzf = zzaiyVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        Object obj;
        int i;
        obj = this.zzbzc.zzbza.mLock;
        synchronized (obj) {
            zzafx.zzcr("JS Engine is requesting an update");
            i = this.zzbzc.zzbza.zzbyx;
            if (i == 0) {
                zzafx.zzcr("Starting reload.");
                this.zzbzc.zzbza.zzbyx = 2;
                this.zzbzc.zzbza.zza(this.zzbzc.zzbyy);
            }
            this.zzbzb.zzb("/requestReload", (zzrn) this.zzbzf.get());
        }
    }
}
