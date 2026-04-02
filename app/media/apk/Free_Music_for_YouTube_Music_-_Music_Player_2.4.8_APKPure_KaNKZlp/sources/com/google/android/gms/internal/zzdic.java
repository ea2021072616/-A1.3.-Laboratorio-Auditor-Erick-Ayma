package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
/* loaded from: classes2.dex */
public final class zzdic implements zzdhz<KeyFactory> {
    @Override // com.google.android.gms.internal.zzdhz
    public final /* synthetic */ KeyFactory zzb(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
    }
}
