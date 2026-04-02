package com.fotoable.youtube.music.b.a;

import com.google.gson.Gson;
/* compiled from: DataDiskCache.java */
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2237a = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static a f2238c;

    /* renamed from: b  reason: collision with root package name */
    private Gson f2239b = new Gson();

    public static a a() {
        if (f2238c == null) {
            synchronized (a.class) {
                if (f2238c == null) {
                    f2238c = new a();
                }
            }
        }
        return f2238c;
    }

    private a() {
    }
}
