package com.fotoable.youtube.music.util.decode;

import com.flurry.android.Constants;
import com.google.android.exoplayer2.C;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: HmacSha256.java */
/* loaded from: classes.dex */
public class c {
    public static String a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(C.UTF8_NAME), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            byte[] doFinal = mac.doFinal(str.getBytes("ASCII"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : doFinal) {
                String hexString = Integer.toHexString(b2 & Constants.UNKNOWN);
                if (hexString.length() == 1) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
