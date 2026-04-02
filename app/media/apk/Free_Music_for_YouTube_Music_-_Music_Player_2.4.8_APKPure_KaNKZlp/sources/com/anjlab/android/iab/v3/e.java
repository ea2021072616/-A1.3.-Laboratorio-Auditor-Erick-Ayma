package com.anjlab.android.iab.v3;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
/* compiled from: Security.java */
/* loaded from: classes.dex */
class e {
    public static boolean a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
            if (str.equals("android.test.purchased") || str.equals("android.test.canceled") || str.equals("android.test.refunded") || str.equals("android.test.item_unavailable")) {
                return true;
            }
            Log.e("IABUtil/Security", "Purchase verification failed: missing data.");
            return false;
        }
        return a(a(str2), str3, str4);
    }

    public static PublicKey a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (IllegalArgumentException e) {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            throw e;
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            Log.e("IABUtil/Security", "Invalid key specification.");
            throw new IllegalArgumentException(e3);
        }
    }

    public static boolean a(PublicKey publicKey, String str, String str2) {
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(str.getBytes());
            if (!signature.verify(Base64.decode(str2, 0))) {
                Log.e("IABUtil/Security", "Signature verification failed.");
                return false;
            }
            return true;
        } catch (IllegalArgumentException e) {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            return false;
        } catch (InvalidKeyException e2) {
            Log.e("IABUtil/Security", "Invalid key specification.");
            return false;
        } catch (NoSuchAlgorithmException e3) {
            Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
            return false;
        } catch (SignatureException e4) {
            Log.e("IABUtil/Security", "Signature exception.");
            return false;
        }
    }
}
