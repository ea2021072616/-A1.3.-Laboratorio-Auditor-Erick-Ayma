package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public final class zzdgz {
    private static final Logger logger = Logger.getLogger(zzdgz.class.getName());

    public static void zzbnc() throws GeneralSecurityException {
        zzdgp.zzlam.zza("type.googleapis.com/google.cloud.crypto.tink.AesCtrHmacAeadKey", new zzdha());
        zzdgp.zzlam.zza("type.googleapis.com/google.cloud.crypto.tink.KmsEnvelopeAeadKey", new zzdhf());
        zzdgp.zzlam.zza("type.googleapis.com/google.cloud.crypto.tink.AesGcmKey", new zzdhd());
        zzdgp.zzlam.zza("type.googleapis.com/google.cloud.crypto.tink.AesEaxKey", new zzdhc());
    }
}
