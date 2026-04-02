package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public final class zzdhk {
    private static final Logger logger = Logger.getLogger(zzdhk.class.getName());

    static {
        try {
            zzdgz.zzbnc();
            zzdho.zzbnc();
        } catch (GeneralSecurityException e) {
            Logger logger2 = logger;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(e);
            logger2.logp(level, "com.google.cloud.crypto.tink.hybrid.HybridEncryptFactory", "<clinit>", new StringBuilder(String.valueOf(valueOf).length() + 30).append("cannot register key managers: ").append(valueOf).toString());
        }
    }

    public static zzdgg zza(zzdgi zzdgiVar) throws GeneralSecurityException {
        return new zzdhl(zzdgp.zzlam.zza(zzdgiVar, (zzdgh) null));
    }

    public static void zzbnc() throws GeneralSecurityException {
        zzdgp.zzlam.zza("type.googleapis.com/google.cloud.crypto.tink.EciesAeadHkdfPublicKey", new zzdhj());
    }
}
