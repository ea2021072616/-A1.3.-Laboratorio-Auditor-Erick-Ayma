package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.k;
import java.io.IOException;
/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f759a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f760b;

    /* renamed from: c  reason: collision with root package name */
    private T f761c;

    protected abstract T a(AssetManager assetManager, String str) throws IOException;

    protected abstract void a(T t) throws IOException;

    public a(AssetManager assetManager, String str) {
        this.f760b = assetManager;
        this.f759a = str;
    }

    @Override // com.bumptech.glide.load.a.c
    public T a(k kVar) throws Exception {
        this.f761c = a(this.f760b, this.f759a);
        return this.f761c;
    }

    @Override // com.bumptech.glide.load.a.c
    public void a() {
        if (this.f761c != null) {
            try {
                a((a<T>) this.f761c);
            } catch (IOException e) {
                if (Log.isLoggable("AssetUriFetcher", 2)) {
                    Log.v("AssetUriFetcher", "Failed to close data", e);
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.a.c
    public String b() {
        return this.f759a;
    }

    @Override // com.bumptech.glide.load.a.c
    public void c() {
    }
}
