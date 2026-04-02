package com.google.android.gms.internal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
/* loaded from: classes2.dex */
public final class zzdgx {
    public static zzdhu zza(zzdfu zzdfuVar) throws GeneralSecurityException {
        switch (zzdfuVar) {
            case COMPRESSED:
                return zzdhu.COMPRESSED;
            case UNCOMPRESSED:
                return zzdhu.UNCOMPRESSED;
            default:
                String valueOf = String.valueOf(zzdfuVar);
                throw new GeneralSecurityException(new StringBuilder(String.valueOf(valueOf).length() + 25).append("Unsupported point format:").append(valueOf).toString());
        }
    }

    public static String zza(zzdfy zzdfyVar) throws NoSuchAlgorithmException {
        switch (zzdfyVar) {
            case SHA1:
                return "HmacSha1";
            case SHA256:
                return "HmacSha256";
            case SHA512:
                return "HmacSha512";
            default:
                String valueOf = String.valueOf(zzdfyVar);
                throw new NoSuchAlgorithmException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("hash unsupported for HMAC: ").append(valueOf).toString());
        }
    }

    public static ECPublicKey zza(zzdfw zzdfwVar, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ECParameterSpec zza = zza(zzdfwVar);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, bArr), new BigInteger(1, bArr2));
        zzdhs.zza(eCPoint, zza.getCurve());
        return (ECPublicKey) KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, zza));
    }

    public static ECParameterSpec zza(zzdfw zzdfwVar) throws NoSuchAlgorithmException {
        switch (zzdfwVar) {
            case NIST_P256:
                return zzdhs.zzbne();
            case NIST_P384:
                return zzdhs.zzbnf();
            case NIST_P521:
                return zzdhs.zzbng();
            default:
                String valueOf = String.valueOf(zzdfwVar);
                throw new NoSuchAlgorithmException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("curve not implemented:").append(valueOf).toString());
        }
    }
}
