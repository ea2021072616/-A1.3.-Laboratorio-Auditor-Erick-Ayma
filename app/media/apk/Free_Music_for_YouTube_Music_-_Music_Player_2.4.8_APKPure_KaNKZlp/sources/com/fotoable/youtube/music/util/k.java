package com.fotoable.youtube.music.util;
/* compiled from: NumberUtil.java */
/* loaded from: classes.dex */
public class k {
    public static String a(int i) {
        if (i < 10000) {
            return i + "";
        }
        return (i / 10000.0d) + "W";
    }
}
