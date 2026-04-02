package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.load.c.a.a;
import com.bumptech.glide.load.c.a.c;
import com.bumptech.glide.load.c.a.d;
import com.bumptech.glide.load.c.a.e;
import com.bumptech.glide.load.c.b.a;
import com.bumptech.glide.load.c.b.b;
import com.bumptech.glide.load.c.b.c;
import com.bumptech.glide.load.c.b.e;
import com.bumptech.glide.load.c.b.f;
import com.bumptech.glide.load.c.b.g;
import com.bumptech.glide.load.c.b.h;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.o;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
/* compiled from: Glide.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static volatile i f716a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.c.c f717b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.b.c f718c;
    private final com.bumptech.glide.load.b.a.c d;
    private final com.bumptech.glide.load.b.b.h e;
    private final com.bumptech.glide.load.a f;
    private final com.bumptech.glide.load.resource.bitmap.e j;
    private final com.bumptech.glide.load.resource.d.f k;
    private final com.bumptech.glide.load.resource.bitmap.i l;
    private final com.bumptech.glide.load.resource.d.f m;
    private final com.bumptech.glide.load.b.d.a o;
    private final com.bumptech.glide.g.b.f g = new com.bumptech.glide.g.b.f();
    private final com.bumptech.glide.load.resource.e.d h = new com.bumptech.glide.load.resource.e.d();
    private final Handler n = new Handler(Looper.getMainLooper());
    private final com.bumptech.glide.f.c i = new com.bumptech.glide.f.c();

    public static File a(Context context) {
        return a(context, "image_manager_disk_cache");
    }

    public static File a(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        } else if (Log.isLoggable("Glide", 6)) {
            Log.e("Glide", "default disk cache dir is null");
            return null;
        } else {
            return null;
        }
    }

    public static i b(Context context) {
        if (f716a == null) {
            synchronized (i.class) {
                if (f716a == null) {
                    Context applicationContext = context.getApplicationContext();
                    List<com.bumptech.glide.e.a> a2 = new com.bumptech.glide.e.b(applicationContext).a();
                    j jVar = new j(applicationContext);
                    for (com.bumptech.glide.e.a aVar : a2) {
                        aVar.a(applicationContext, jVar);
                    }
                    f716a = jVar.a();
                    for (com.bumptech.glide.e.a aVar2 : a2) {
                        aVar2.a(applicationContext, f716a);
                    }
                }
            }
        }
        return f716a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(com.bumptech.glide.load.b.c cVar, com.bumptech.glide.load.b.b.h hVar, com.bumptech.glide.load.b.a.c cVar2, Context context, com.bumptech.glide.load.a aVar) {
        this.f718c = cVar;
        this.d = cVar2;
        this.e = hVar;
        this.f = aVar;
        this.f717b = new com.bumptech.glide.load.c.c(context);
        this.o = new com.bumptech.glide.load.b.d.a(hVar, cVar2, aVar);
        o oVar = new o(cVar2, aVar);
        this.i.a(InputStream.class, Bitmap.class, oVar);
        com.bumptech.glide.load.resource.bitmap.g gVar = new com.bumptech.glide.load.resource.bitmap.g(cVar2, aVar);
        this.i.a(ParcelFileDescriptor.class, Bitmap.class, gVar);
        m mVar = new m(oVar, gVar);
        this.i.a(com.bumptech.glide.load.c.g.class, Bitmap.class, mVar);
        com.bumptech.glide.load.resource.c.c cVar3 = new com.bumptech.glide.load.resource.c.c(context, cVar2);
        this.i.a(InputStream.class, com.bumptech.glide.load.resource.c.b.class, cVar3);
        this.i.a(com.bumptech.glide.load.c.g.class, com.bumptech.glide.load.resource.d.a.class, new com.bumptech.glide.load.resource.d.g(mVar, cVar3, cVar2));
        this.i.a(InputStream.class, File.class, new com.bumptech.glide.load.resource.b.d());
        a(File.class, ParcelFileDescriptor.class, new a.C0029a());
        a(File.class, InputStream.class, new c.a());
        a(Integer.TYPE, ParcelFileDescriptor.class, new c.a());
        a(Integer.TYPE, InputStream.class, new e.a());
        a(Integer.class, ParcelFileDescriptor.class, new c.a());
        a(Integer.class, InputStream.class, new e.a());
        a(String.class, ParcelFileDescriptor.class, new d.a());
        a(String.class, InputStream.class, new f.a());
        a(Uri.class, ParcelFileDescriptor.class, new e.a());
        a(Uri.class, InputStream.class, new g.a());
        a(URL.class, InputStream.class, new h.a());
        a(com.bumptech.glide.load.c.d.class, InputStream.class, new a.C0030a());
        a(byte[].class, InputStream.class, new b.a());
        this.h.a(Bitmap.class, com.bumptech.glide.load.resource.bitmap.j.class, new com.bumptech.glide.load.resource.e.b(context.getResources(), cVar2));
        this.h.a(com.bumptech.glide.load.resource.d.a.class, com.bumptech.glide.load.resource.a.b.class, new com.bumptech.glide.load.resource.e.a(new com.bumptech.glide.load.resource.e.b(context.getResources(), cVar2)));
        this.j = new com.bumptech.glide.load.resource.bitmap.e(cVar2);
        this.k = new com.bumptech.glide.load.resource.d.f(cVar2, this.j);
        this.l = new com.bumptech.glide.load.resource.bitmap.i(cVar2);
        this.m = new com.bumptech.glide.load.resource.d.f(cVar2, this.l);
    }

    public com.bumptech.glide.load.b.a.c a() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z, R> com.bumptech.glide.load.resource.e.c<Z, R> a(Class<Z> cls, Class<R> cls2) {
        return this.h.a(cls, cls2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T, Z> com.bumptech.glide.f.b<T, Z> b(Class<T> cls, Class<Z> cls2) {
        return this.i.a(cls, cls2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <R> com.bumptech.glide.g.b.j<R> a(ImageView imageView, Class<R> cls) {
        return this.g.a(imageView, cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.b.c b() {
        return this.f718c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.resource.bitmap.e c() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.resource.bitmap.i d() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.resource.d.f e() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.resource.d.f f() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.a g() {
        return this.f;
    }

    private com.bumptech.glide.load.c.c j() {
        return this.f717b;
    }

    public void h() {
        com.bumptech.glide.i.h.a();
        this.e.a();
        this.d.a();
    }

    public void a(int i) {
        com.bumptech.glide.i.h.a();
        this.e.a(i);
        this.d.a(i);
    }

    public void i() {
        com.bumptech.glide.i.h.b();
        b().a();
    }

    public static void a(com.bumptech.glide.g.b.j<?> jVar) {
        com.bumptech.glide.i.h.a();
        com.bumptech.glide.g.b request = jVar.getRequest();
        if (request != null) {
            request.d();
            jVar.setRequest(null);
        }
    }

    public <T, Y> void a(Class<T> cls, Class<Y> cls2, com.bumptech.glide.load.c.m<T, Y> mVar) {
        com.bumptech.glide.load.c.m<T, Y> a2 = this.f717b.a(cls, cls2, mVar);
        if (a2 != null) {
            a2.a();
        }
    }

    public static <T, Y> com.bumptech.glide.load.c.l<T, Y> a(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls == null) {
            if (Log.isLoggable("Glide", 3)) {
                Log.d("Glide", "Unable to load null model, setting placeholder only");
            }
            return null;
        }
        return b(context).j().a(cls, cls2);
    }

    public static <T> com.bumptech.glide.load.c.l<T, InputStream> a(Class<T> cls, Context context) {
        return a(cls, InputStream.class, context);
    }

    public static <T> com.bumptech.glide.load.c.l<T, ParcelFileDescriptor> b(Class<T> cls, Context context) {
        return a(cls, ParcelFileDescriptor.class, context);
    }

    public static l c(Context context) {
        return com.bumptech.glide.d.k.a().a(context);
    }

    public static l a(FragmentActivity fragmentActivity) {
        return com.bumptech.glide.d.k.a().a(fragmentActivity);
    }
}
