package com.fotoable.youtube.music.util;

import android.content.Context;
import com.fotoable.youtube.music.MusicApplication;
/* compiled from: DensityUtil.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Context f4862a = MusicApplication.c().getApplicationContext();

    public static int a(float f) {
        return (int) ((f4862a.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
