package com.google.android.gms.internal;

import java.util.Comparator;
/* loaded from: classes2.dex */
public final class zzhu implements Comparator<zzhi> {
    public zzhu(zzht zzhtVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzhi zzhiVar, zzhi zzhiVar2) {
        zzhi zzhiVar3 = zzhiVar;
        zzhi zzhiVar4 = zzhiVar2;
        if (zzhiVar3.zzgt() < zzhiVar4.zzgt()) {
            return -1;
        }
        if (zzhiVar3.zzgt() > zzhiVar4.zzgt()) {
            return 1;
        }
        if (zzhiVar3.zzgs() >= zzhiVar4.zzgs()) {
            if (zzhiVar3.zzgs() > zzhiVar4.zzgs()) {
                return 1;
            }
            float zzgv = (zzhiVar3.zzgv() - zzhiVar3.zzgt()) * (zzhiVar3.zzgu() - zzhiVar3.zzgs());
            float zzgv2 = (zzhiVar4.zzgv() - zzhiVar4.zzgt()) * (zzhiVar4.zzgu() - zzhiVar4.zzgs());
            if (zzgv <= zzgv2) {
                return zzgv < zzgv2 ? 1 : 0;
            }
            return -1;
        }
        return -1;
    }
}
