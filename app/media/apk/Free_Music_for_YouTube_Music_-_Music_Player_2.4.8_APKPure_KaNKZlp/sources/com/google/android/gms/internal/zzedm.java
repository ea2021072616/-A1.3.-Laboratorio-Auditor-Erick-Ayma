package com.google.android.gms.internal;

import java.util.Arrays;
/* loaded from: classes2.dex */
final class zzedm implements zzedo {
    private zzedm() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzedm(zzedl zzedlVar) {
        this();
    }

    @Override // com.google.android.gms.internal.zzedo
    public final byte[] zzd(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i + i2);
    }
}
