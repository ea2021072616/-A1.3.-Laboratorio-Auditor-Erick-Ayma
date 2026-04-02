package com.fotoable.youtube.music.util;

import android.graphics.Typeface;
import com.fotoable.youtube.music.MusicApplication;
import java.util.HashMap;
import java.util.Map;
/* compiled from: FontUtils.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Typeface> f4865a = new HashMap();

    private static Typeface a(String str) {
        Typeface typeface;
        try {
            synchronized (f4865a) {
                if (!f4865a.containsKey(str)) {
                    f4865a.put(str, Typeface.createFromAsset(MusicApplication.c().getAssets(), str));
                }
                typeface = f4865a.get(str);
            }
            return typeface;
        } catch (Exception e) {
            return null;
        }
    }

    public static Typeface a() {
        return a("fonts/Lato-Regular.ttf");
    }

    public static Typeface b() {
        return a("fonts/Lato-Light.ttf");
    }

    public static Typeface c() {
        return a("fonts/Lato-Bold.ttf");
    }

    public static Typeface d() {
        return a("fonts/Lato-Black.ttf");
    }

    public static Typeface e() {
        return a("fonts/Roboto-Light.ttf");
    }

    public static Typeface f() {
        return a("fonts/Roboto-Regular.ttf");
    }

    public static Typeface g() {
        return a("fonts/blanchcaps.ttf");
    }

    public static Typeface h() {
        return a("fonts/Roboto-Bold.ttf");
    }
}
