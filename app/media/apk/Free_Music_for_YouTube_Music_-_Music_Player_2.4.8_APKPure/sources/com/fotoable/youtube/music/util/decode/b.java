package com.fotoable.youtube.music.util.decode;

import android.util.Base64;
import com.fotoable.youtube.music.bean.EncryptObj;
import com.google.gson.Gson;
import java.util.Random;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: AESHelper.java */
/* loaded from: classes.dex */
public class b {
    public static String a(String str) throws Exception {
        EncryptObj encryptObj = (EncryptObj) new Gson().fromJson(new String(Base64.decode(str, 2)), (Class<Object>) EncryptObj.class);
        if (!a(encryptObj).booleanValue()) {
            throw new Exception("isvalid mac");
        }
        return new String(a.a(a(), b(new String(encryptObj.getIv())), b(new String(encryptObj.getValue()))));
    }

    private static SecretKeySpec a() {
        return new SecretKeySpec(SkyVpnKeyStore.getSkyVpnKey().getBytes(), "AES");
    }

    private static byte[] b(String str) {
        return Base64.decode(str, 2);
    }

    private static byte[] a(int i) {
        byte[] bArr = new byte[i];
        new Random().nextBytes(bArr);
        return bArr;
    }

    private static String a(String str, String str2) {
        return c.a(str.concat(str2), SkyVpnKeyStore.getSkyVpnKey());
    }

    private static Boolean a(EncryptObj encryptObj) {
        String str = new String(a(16));
        return Boolean.valueOf(c.a(a(new String(encryptObj.getIv()), new String(encryptObj.getValue())), str).equals(c.a(encryptObj.getMac(), str)));
    }
}
