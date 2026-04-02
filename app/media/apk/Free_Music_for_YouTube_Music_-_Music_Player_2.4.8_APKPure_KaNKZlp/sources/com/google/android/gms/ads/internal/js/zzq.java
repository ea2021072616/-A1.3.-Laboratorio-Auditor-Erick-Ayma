package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzaif;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzrn;
import java.util.Map;
/* loaded from: classes.dex */
final class zzq implements zzrn {
    private /* synthetic */ zza zzbzb;
    private /* synthetic */ zzm zzbzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(zzm zzmVar, zza zzaVar) {
        this.zzbzc = zzmVar;
        this.zzbzb = zzaVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        Object obj;
        zzaif zzaifVar;
        obj = this.zzbzc.zzbza.mLock;
        synchronized (obj) {
            if (this.zzbzc.zzbyz.getStatus() == -1 || this.zzbzc.zzbyz.getStatus() == 1) {
                return;
            }
            this.zzbzc.zzbza.zzbyx = 0;
            zzaifVar = this.zzbzc.zzbza.zzbyu;
            zzaifVar.zzc(this.zzbzb);
            this.zzbzc.zzbyz.zzf(this.zzbzb);
            this.zzbzc.zzbza.zzbyw = this.zzbzc.zzbyz;
            zzafx.v("Successfully loaded JS Engine.");
        }
    }
}
