package com.fotoable.youtube.music.quicktools.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: MD5Util.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    protected static MessageDigest f3123a;

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f3124b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static {
        f3123a = null;
        try {
            f3123a = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(b.class.getName() + "初始化失败，MessageDigest不支撑MD5Util。");
        }
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (Exception e) {
            return "";
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(f3124b[(bArr[i] & 240) >>> 4]);
            sb.append(f3124b[bArr[i] & 15]);
        }
        return sb.toString();
    }
}
