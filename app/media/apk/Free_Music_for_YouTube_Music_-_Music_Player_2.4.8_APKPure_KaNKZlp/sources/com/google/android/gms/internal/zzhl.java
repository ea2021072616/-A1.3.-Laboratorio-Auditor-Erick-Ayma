package com.google.android.gms.internal;

import java.util.Comparator;
/* loaded from: classes2.dex */
final class zzhl implements Comparator<zzhr> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhl(zzhk zzhkVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzhr zzhrVar, zzhr zzhrVar2) {
        zzhr zzhrVar3 = zzhrVar;
        zzhr zzhrVar4 = zzhrVar2;
        int i = zzhrVar3.zzazv - zzhrVar4.zzazv;
        return i != 0 ? i : (int) (zzhrVar3.value - zzhrVar4.value);
    }
}
