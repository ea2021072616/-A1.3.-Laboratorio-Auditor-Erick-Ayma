package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdhz;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
/* loaded from: classes2.dex */
public class zzdhy<T_WRAPPER extends zzdhz<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzdhy.class.getName());
    private static final List<Provider> zzldi;
    public static final zzdhy<zzdia, Cipher> zzldj;
    public static final zzdhy<zzdie, Mac> zzldk;
    private static zzdhy<zzdig, Signature> zzldl;
    private static zzdhy<zzdif, MessageDigest> zzldm;
    public static final zzdhy<zzdib, KeyAgreement> zzldn;
    public static final zzdhy<zzdid, KeyPairGenerator> zzldo;
    private static zzdhy<zzdic, KeyFactory> zzldp;
    private T_WRAPPER zzldq;
    private List<Provider> zzldr = zzldi;
    private boolean zzlds = true;

    static {
        if (zzdik.zzaig()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.cloud.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            zzldi = arrayList;
        } else {
            zzldi = new ArrayList();
        }
        zzldj = new zzdhy<>(new zzdia());
        zzldk = new zzdhy<>(new zzdie());
        zzldl = new zzdhy<>(new zzdig());
        zzldm = new zzdhy<>(new zzdif());
        zzldn = new zzdhy<>(new zzdib());
        zzldo = new zzdhy<>(new zzdid());
        zzldp = new zzdhy<>(new zzdic());
    }

    private zzdhy(T_WRAPPER t_wrapper) {
        this.zzldq = t_wrapper;
    }

    private final boolean zza(String str, Provider provider) {
        try {
            this.zzldq.zzb(str, provider);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final T_ENGINE zzny(String str) throws GeneralSecurityException {
        for (Provider provider : this.zzldr) {
            if (zza(str, provider)) {
                return (T_ENGINE) this.zzldq.zzb(str, provider);
            }
        }
        if (this.zzlds) {
            return (T_ENGINE) this.zzldq.zzb(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }
}
