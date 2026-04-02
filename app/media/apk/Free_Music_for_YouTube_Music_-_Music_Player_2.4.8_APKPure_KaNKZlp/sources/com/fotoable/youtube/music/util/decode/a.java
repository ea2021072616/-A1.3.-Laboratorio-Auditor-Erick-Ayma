package com.fotoable.youtube.music.util.decode;

import android.util.Log;
import com.flurry.android.Constants;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: AESCrypt.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f4864b = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4863a = false;

    public static byte[] a(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr));
        byte[] doFinal = cipher.doFinal(bArr2);
        a("decryptedBytes", doFinal);
        return doFinal;
    }

    private static void a(String str, byte[] bArr) {
        if (f4863a) {
            Log.d("AESCrypt", str + "[" + bArr.length + "] [" + a(bArr) + "]");
        }
    }

    private static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & Constants.UNKNOWN;
            cArr2[i * 2] = cArr[i2 >>> 4];
            cArr2[(i * 2) + 1] = cArr[i2 & 15];
        }
        return new String(cArr2);
    }
}
