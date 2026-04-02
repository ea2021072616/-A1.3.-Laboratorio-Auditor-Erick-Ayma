package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzakc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaa implements zzakc<zzai> {
    private /* synthetic */ zzy zzbzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(zzy zzyVar) {
        this.zzbzm = zzyVar;
    }

    @Override // com.google.android.gms.internal.zzakc
    public final /* synthetic */ void zzc(zzai zzaiVar) {
        zzac zzacVar;
        zzafx.v("Releasing engine reference.");
        zzacVar = this.zzbzm.zzbzk;
        zzacVar.zzld();
    }
}
