package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zzedn extends zzedr {
    private final int zzmxv;
    private final int zzmxw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedn(byte[] bArr, int i, int i2) {
        super(bArr);
        zzg(i, i + i2, bArr.length);
        this.zzmxv = i;
        this.zzmxw = i2;
    }

    @Override // com.google.android.gms.internal.zzedr, com.google.android.gms.internal.zzedk
    public final int size() {
        return this.zzmxw;
    }

    @Override // com.google.android.gms.internal.zzedr, com.google.android.gms.internal.zzedk
    protected final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzjao, zzcbo(), bArr, 0, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzedr
    public final int zzcbo() {
        return this.zzmxv;
    }

    @Override // com.google.android.gms.internal.zzedr, com.google.android.gms.internal.zzedk
    public final byte zzgi(int i) {
        int size = size();
        if (((size - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(i).toString());
            }
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(i).append(", ").append(size).toString());
        }
        return this.zzjao[this.zzmxv + i];
    }
}
