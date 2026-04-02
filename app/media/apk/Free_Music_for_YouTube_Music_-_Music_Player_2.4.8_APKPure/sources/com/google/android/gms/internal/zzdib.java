package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.KeyAgreement;
/* loaded from: classes2.dex */
public final class zzdib implements zzdhz<KeyAgreement> {
    @Override // com.google.android.gms.internal.zzdhz
    public final /* synthetic */ KeyAgreement zzb(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
    }
}
