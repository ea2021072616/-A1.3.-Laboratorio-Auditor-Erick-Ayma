package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdgq;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes2.dex */
public final class zzdgp {
    public static final zzdgp zzlam = new zzdgp();
    private final ConcurrentMap<String, zzdgh> zzlan = new ConcurrentHashMap();

    protected zzdgp() {
    }

    private final <P, K extends zzeey, F extends zzeey> P zza(String str, zzedk zzedkVar) throws GeneralSecurityException {
        return zznu(str).zzq(zzedkVar);
    }

    private final <P, K extends zzeey, F extends zzeey> zzdgh<P, K, F> zznu(String str) throws GeneralSecurityException {
        zzdgh<P, K, F> zzdghVar = this.zzlan.get(str);
        if (zzdghVar == null) {
            String valueOf = String.valueOf(str);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported key type: ".concat(valueOf) : new String("unsupported key type: "));
        }
        return zzdghVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <P, K extends zzeey, F extends zzeey> zzdgn<P> zza(zzdgi zzdgiVar, zzdgh<P, K, F> zzdghVar) throws GeneralSecurityException {
        boolean z;
        zzdgq.zzc zzbls = zzdgiVar.zzbls();
        if (zzbls.zzbmo() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        int zzbmm = zzbls.zzbmm();
        boolean z2 = false;
        for (zzdgq.zzc.zzb zzbVar : zzbls.zzbmn()) {
            if (!zzbVar.zzbmq()) {
                throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzbVar.zzbmt())));
            }
            if (zzbVar.zzbmu() == zzdgv.UNKNOWN_PREFIX) {
                throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzbVar.zzbmt())));
            }
            if (zzbVar.zzbms() == zzdgt.UNKNOWN_STATUS) {
                throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzbVar.zzbmt())));
            }
            if (zzbVar.zzbmt() <= 0) {
                throw new GeneralSecurityException(String.format("key has a non-positive key id: %d", Integer.valueOf(zzbVar.zzbmt())));
            }
            if (zzbVar.zzbms() != zzdgt.ENABLED || zzbVar.zzbmt() != zzbmm) {
                z = z2;
            } else if (z2) {
                throw new GeneralSecurityException("keyset contains multiple primary keys");
            } else {
                z = true;
            }
            z2 = z;
        }
        if (z2) {
            zzdgn<P> zzdgnVar = (zzdgn<P>) new zzdgn();
            for (zzdgq.zzc.zzb zzbVar2 : zzdgiVar.zzbls().zzbmn()) {
                if (zzbVar2.zzbms() == zzdgt.ENABLED) {
                    zzdgo zza = zzdgnVar.zza(zza(zzbVar2.zzbmr().zzbme(), zzbVar2.zzbmr().zzbmf()), zzbVar2);
                    if (zzbVar2.zzbmt() == zzdgiVar.zzbls().zzbmm()) {
                        zzdgnVar.zza(zza);
                    }
                }
            }
            return zzdgnVar;
        }
        throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
    }

    public final <P, K extends zzeey, F extends zzeey> zzdgq.zza zza(zzdgq.zzb zzbVar) throws GeneralSecurityException {
        return zznu(zzbVar.zzbme()).zzs(zzbVar.zzbmf());
    }

    public final <P, K extends zzeey, F extends zzeey> K zza(String str, F f) throws GeneralSecurityException {
        return zznu(str).zzb(f);
    }

    public final <P> P zza(zzdgq.zza zzaVar) throws GeneralSecurityException {
        return (P) zza(zzaVar.zzbme(), zzaVar.zzbmf());
    }

    public final <P, K extends zzeey, F extends zzeey> boolean zza(String str, zzdgh<P, K, F> zzdghVar) throws GeneralSecurityException {
        return this.zzlan.putIfAbsent(str, zzdghVar) == null;
    }

    public final <P, K extends zzeey, F extends zzeey> K zzb(zzdgq.zzb zzbVar) throws GeneralSecurityException {
        return zznu(zzbVar.zzbme()).zzr(zzbVar.zzbmf());
    }

    public final <P, K extends zzeey, F extends zzeey> P zzb(String str, K k) throws GeneralSecurityException {
        return zznu(str).zza(k);
    }

    public final <P> P zzf(String str, byte[] bArr) throws GeneralSecurityException {
        return (P) zza(str, zzedk.zzaq(bArr));
    }
}
