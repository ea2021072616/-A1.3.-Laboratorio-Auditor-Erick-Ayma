package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
/* loaded from: classes2.dex */
final class zzdhl implements zzdgg {
    private /* synthetic */ zzdgn zzlcs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdhl(zzdgn zzdgnVar) {
        this.zzlcs = zzdgnVar;
    }

    @Override // com.google.android.gms.internal.zzdgg
    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzdik.zzc(this.zzlcs.zzbmb().zzbmd(), ((zzdgg) this.zzlcs.zzbmb().zzbmc()).zzd(bArr, bArr2));
    }
}
