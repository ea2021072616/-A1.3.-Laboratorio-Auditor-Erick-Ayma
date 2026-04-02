package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;
/* loaded from: classes2.dex */
public final class zzdii implements zzdgl {
    private Mac zzldt;
    private final int zzldu;
    private final String zzldv;
    private final Key zzldw;

    public zzdii(String str, Key key, int i) throws GeneralSecurityException {
        this.zzldv = str;
        this.zzldu = i;
        this.zzldw = key;
        this.zzldt = zzdhy.zzldk.zzny(str);
        this.zzldt.init(key);
    }

    @Override // com.google.android.gms.internal.zzdgl
    public final byte[] zzad(byte[] bArr) throws GeneralSecurityException {
        Mac zzny;
        try {
            zzny = (Mac) this.zzldt.clone();
        } catch (CloneNotSupportedException e) {
            zzny = zzdhy.zzldk.zzny(this.zzldv);
            zzny.init(this.zzldw);
        }
        zzny.update(bArr);
        byte[] bArr2 = new byte[this.zzldu];
        System.arraycopy(zzny.doFinal(), 0, bArr2, 0, this.zzldu);
        return bArr2;
    }
}
