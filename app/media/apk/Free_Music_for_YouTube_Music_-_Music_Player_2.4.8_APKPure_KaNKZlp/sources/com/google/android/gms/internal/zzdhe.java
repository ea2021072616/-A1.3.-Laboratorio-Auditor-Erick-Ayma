package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdgq;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
/* loaded from: classes2.dex */
final class zzdhe implements zzdfl {
    private static final byte[] zzlcb = new byte[0];
    private final zzdgq.zzb zzlcc;
    private final zzdfl zzlcd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdhe(zzdgq.zzb zzbVar, zzdfl zzdflVar) {
        this.zzlcc = zzbVar;
        this.zzlcd = zzdflVar;
    }

    @Override // com.google.android.gms.internal.zzdfl
    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] byteArray = zzdgp.zzlam.zzb(this.zzlcc).toByteArray();
        byte[] zzd = this.zzlcd.zzd(byteArray, zzlcb);
        byte[] zzd2 = ((zzdfl) zzdgp.zzlam.zzf(this.zzlcc.zzbme(), byteArray)).zzd(bArr, bArr2);
        return ByteBuffer.allocate(zzd.length + 4 + zzd2.length).putInt(zzd.length).put(zzd).put(zzd2).array();
    }
}
