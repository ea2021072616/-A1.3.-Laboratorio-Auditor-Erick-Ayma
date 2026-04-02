package com.google.android.gms.common;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
abstract class zzi extends zzg {
    private static final WeakReference<byte[]> zzffl = new WeakReference<>(null);
    private WeakReference<byte[]> zzffk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(byte[] bArr) {
        super(bArr);
        this.zzffk = zzffl;
    }

    @Override // com.google.android.gms.common.zzg
    final byte[] getBytes() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.zzffk.get();
            if (bArr == null) {
                bArr = zzafa();
                this.zzffk = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] zzafa();
}
