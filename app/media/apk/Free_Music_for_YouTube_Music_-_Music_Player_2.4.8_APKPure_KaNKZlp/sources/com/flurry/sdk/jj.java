package com.flurry.sdk;

import android.text.TextUtils;
import java.util.Arrays;
/* loaded from: classes.dex */
public class jj {

    /* renamed from: a  reason: collision with root package name */
    public static String f1977a = jj.class.getName();

    public static String a(String str) {
        String str2 = "a=" + jy.a().d;
        if (!TextUtils.isEmpty(str)) {
            return String.format("%s&%s", str2, "cid=" + b(str));
        }
        return str2;
    }

    private static String b(String str) {
        byte[] bArr;
        if (str == null || str.trim().length() <= 0) {
            bArr = null;
        } else {
            try {
                bArr = ly.e(str);
                if (bArr != null && bArr.length == 20) {
                    try {
                        km.a(5, f1977a, "syndication hashedId is:" + new String(bArr));
                    } catch (Exception e) {
                        km.a(6, f1977a, "Exception in getHashedSyndicationIdString()");
                        return ly.a(bArr);
                    }
                } else {
                    km.a(6, f1977a, "sha1 is not 20 bytes long: " + Arrays.toString(bArr));
                    bArr = null;
                }
            } catch (Exception e2) {
                bArr = null;
            }
        }
        return ly.a(bArr);
    }
}
