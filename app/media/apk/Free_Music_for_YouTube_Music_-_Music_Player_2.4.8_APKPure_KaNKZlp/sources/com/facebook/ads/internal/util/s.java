package com.facebook.ads.internal.util;

import android.content.Context;
import android.support.annotation.Nullable;
import com.facebook.ads.AudienceNetworkActivity;
import com.flurry.android.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class s {
    @Nullable
    public static final String a(Context context, String str) {
        try {
            return b(context.getPackageManager().getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public static final String a(File file) {
        int read;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            do {
                read = fileInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                }
            } while (read != -1);
            fileInputStream.close();
            return a(messageDigest.digest());
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public static String a(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes(AudienceNetworkActivity.WEBVIEW_ENCODING)));
        } catch (Exception e) {
            return null;
        }
    }

    private static final String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(Integer.toString((b2 & Constants.UNKNOWN) + 256, 16).substring(1));
        }
        return sb.toString();
    }

    @Nullable
    public static final String b(String str) {
        return a(new File(str));
    }
}
