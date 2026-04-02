package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class zzdhx implements zzdfl {
    private final zzdih zzldf;
    private final zzdgl zzldg;
    private final int zzldh;

    public zzdhx(zzdih zzdihVar, zzdgl zzdglVar, int i) {
        this.zzldf = zzdihVar;
        this.zzldg = zzdglVar;
        this.zzldh = i;
    }

    @Override // com.google.android.gms.internal.zzdfl
    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzah = this.zzldf.zzah(bArr);
        return zzdik.zzc(zzah, this.zzldg.zzad(zzdik.zzc(bArr2, zzah, Arrays.copyOf(ByteBuffer.allocate(8).putLong(8 * bArr2.length).array(), 8))));
    }
}
