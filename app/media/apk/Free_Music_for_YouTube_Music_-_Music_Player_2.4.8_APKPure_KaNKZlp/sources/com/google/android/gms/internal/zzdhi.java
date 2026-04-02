package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdgq;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
/* loaded from: classes2.dex */
public final class zzdhi implements zzdgg {
    private static final byte[] zzlcb = new byte[0];
    private final ECPublicKey zzlcm;
    private final zzdhv zzlcn;
    private final String zzlco;
    private final byte[] zzlcp;
    private final zzdhu zzlcq;
    private final zzdhg zzlcr;

    public zzdhi(ECPublicKey eCPublicKey, byte[] bArr, String str, zzdgq.zzb zzbVar, zzdfu zzdfuVar) throws GeneralSecurityException {
        zzdhs.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzlcm = eCPublicKey;
        this.zzlcn = new zzdhv(eCPublicKey);
        this.zzlcp = bArr;
        this.zzlco = str;
        this.zzlcq = zzdgx.zza(zzdfuVar);
        this.zzlcr = new zzdhg(zzbVar);
    }

    @Override // com.google.android.gms.internal.zzdgg
    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzdhw zza = this.zzlcn.zza(this.zzlco, this.zzlcp, bArr2, this.zzlcr.zzbnd(), this.zzlcq);
        byte[] zzd = this.zzlcr.zzag(zza.zzbni()).zzd(bArr, zzlcb);
        byte[] zzbnh = zza.zzbnh();
        return ByteBuffer.allocate(zzbnh.length + zzd.length).put(zzbnh).put(zzd).array();
    }
}
