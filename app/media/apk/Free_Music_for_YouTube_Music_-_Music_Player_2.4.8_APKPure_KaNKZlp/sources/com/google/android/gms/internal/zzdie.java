package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Mac;
/* loaded from: classes2.dex */
public final class zzdie implements zzdhz<Mac> {
    @Override // com.google.android.gms.internal.zzdhz
    public final /* synthetic */ Mac zzb(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
    }
}
