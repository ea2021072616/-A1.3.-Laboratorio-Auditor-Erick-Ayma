package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzakc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzu implements zzakc<zza> {
    private /* synthetic */ zzl zzbza;
    private /* synthetic */ zzac zzbzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(zzl zzlVar, zzac zzacVar) {
        this.zzbza = zzlVar;
        this.zzbzh = zzacVar;
    }

    @Override // com.google.android.gms.internal.zzakc
    public final /* synthetic */ void zzc(zza zzaVar) {
        Object obj;
        zzac zzacVar;
        zzac zzacVar2;
        zzac zzacVar3;
        obj = this.zzbza.mLock;
        synchronized (obj) {
            this.zzbza.zzbyx = 0;
            zzacVar = this.zzbza.zzbyw;
            if (zzacVar != null) {
                zzac zzacVar4 = this.zzbzh;
                zzacVar2 = this.zzbza.zzbyw;
                if (zzacVar4 != zzacVar2) {
                    zzafx.v("New JS engine is loaded, marking previous one as destroyable.");
                    zzacVar3 = this.zzbza.zzbyw;
                    zzacVar3.zzle();
                }
            }
            this.zzbza.zzbyw = this.zzbzh;
        }
    }
}
