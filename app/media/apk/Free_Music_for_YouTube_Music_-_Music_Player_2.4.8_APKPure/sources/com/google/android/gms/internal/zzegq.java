package com.google.android.gms.internal;

import java.util.Arrays;
/* loaded from: classes2.dex */
final class zzegq {
    final int tag;
    final byte[] zzjao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzegq(int i, byte[] bArr) {
        this.tag = i;
        this.zzjao = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzegq) {
            zzegq zzegqVar = (zzegq) obj;
            return this.tag == zzegqVar.tag && Arrays.equals(this.zzjao, zzegqVar.zzjao);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzjao);
    }
}
