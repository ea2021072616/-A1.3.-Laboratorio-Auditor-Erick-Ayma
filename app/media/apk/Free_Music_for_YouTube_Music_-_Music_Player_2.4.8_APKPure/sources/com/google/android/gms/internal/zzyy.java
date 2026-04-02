package com.google.android.gms.internal;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzyy implements zzajm<List<zznv>, zznt> {
    private /* synthetic */ String zzcme;
    private /* synthetic */ Integer zzcmf;
    private /* synthetic */ Integer zzcmg;
    private /* synthetic */ int zzcmh;
    private /* synthetic */ int zzcmi;
    private /* synthetic */ int zzcmj;
    private /* synthetic */ int zzcmk;
    private /* synthetic */ boolean zzcml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyy(zzys zzysVar, String str, Integer num, Integer num2, int i, int i2, int i3, int i4, boolean z) {
        this.zzcme = str;
        this.zzcmf = num;
        this.zzcmg = num2;
        this.zzcmh = i;
        this.zzcmi = i2;
        this.zzcmj = i3;
        this.zzcmk = i4;
        this.zzcml = z;
    }

    @Override // com.google.android.gms.internal.zzajm
    public final /* synthetic */ zznt apply(List<zznv> list) {
        List<zznv> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        return new zznt(this.zzcme, list2, this.zzcmf, this.zzcmg, this.zzcmh > 0 ? Integer.valueOf(this.zzcmh) : null, this.zzcmi + this.zzcmj, this.zzcmk, this.zzcml);
    }
}
