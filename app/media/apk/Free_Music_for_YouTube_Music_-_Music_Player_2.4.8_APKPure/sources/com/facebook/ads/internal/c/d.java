package com.facebook.ads.internal.c;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.ads.internal.i.b.f;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1270a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static d f1271b;

    /* renamed from: c  reason: collision with root package name */
    private final Future<f> f1272c;

    private d(final Context context) {
        this.f1272c = Executors.newSingleThreadExecutor().submit(new Callable<f>() { // from class: com.facebook.ads.internal.c.d.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public f call() {
                return new f(context);
            }
        });
    }

    public static d a(Context context) {
        if (f1271b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f1271b == null) {
                    f1271b = new d(applicationContext);
                }
            }
        }
        return f1271b;
    }

    @Nullable
    private f a() {
        try {
            return this.f1272c.get(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            Log.e(f1270a, "Timed out waiting for cache server.", e);
            return null;
        }
    }

    public void a(String str) {
        f a2 = a();
        if (a2 != null) {
            a2.a(str);
        }
    }

    @Nullable
    public String b(String str) {
        f a2 = a();
        if (a2 == null) {
            return null;
        }
        return a2.b(str);
    }
}
