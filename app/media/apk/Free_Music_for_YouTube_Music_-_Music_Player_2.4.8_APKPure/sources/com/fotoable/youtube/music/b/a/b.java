package com.fotoable.youtube.music.b.a;
/* compiled from: DataMemoryCache.java */
/* loaded from: classes.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private static b f2240a;

    public static b a() {
        if (f2240a == null) {
            synchronized (b.class) {
                if (f2240a == null) {
                    f2240a = new b();
                }
            }
        }
        return f2240a;
    }

    private b() {
    }
}
