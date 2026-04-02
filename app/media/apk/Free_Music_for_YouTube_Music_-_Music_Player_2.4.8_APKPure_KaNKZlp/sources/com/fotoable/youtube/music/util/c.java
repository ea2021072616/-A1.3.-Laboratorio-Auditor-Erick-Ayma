package com.fotoable.youtube.music.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: DateUtil.java */
/* loaded from: classes.dex */
public class c {
    public static String a(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }
}
