package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.k;
import java.io.FileNotFoundException;
import java.io.IOException;
/* compiled from: LocalUriFetcher.java */
/* loaded from: classes.dex */
public abstract class g<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f767a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f768b;

    /* renamed from: c  reason: collision with root package name */
    private T f769c;

    protected abstract void a(T t) throws IOException;

    protected abstract T b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public g(Context context, Uri uri) {
        this.f768b = context.getApplicationContext();
        this.f767a = uri;
    }

    @Override // com.bumptech.glide.load.a.c
    public final T a(k kVar) throws Exception {
        this.f769c = b(this.f767a, this.f768b.getContentResolver());
        return this.f769c;
    }

    @Override // com.bumptech.glide.load.a.c
    public void a() {
        if (this.f769c != null) {
            try {
                a((g<T>) this.f769c);
            } catch (IOException e) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e);
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.a.c
    public void c() {
    }

    @Override // com.bumptech.glide.load.a.c
    public String b() {
        return this.f767a.toString();
    }
}
