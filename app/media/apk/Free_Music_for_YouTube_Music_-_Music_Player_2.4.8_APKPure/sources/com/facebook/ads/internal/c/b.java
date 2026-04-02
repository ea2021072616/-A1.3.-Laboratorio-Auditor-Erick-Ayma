package com.facebook.ads.internal.c;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1256a = b.class.getSimpleName();
    private final c d;
    private final d e;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1257b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f1258c = Executors.newFixedThreadPool(10);
    private final List<Callable<Boolean>> f = new ArrayList();

    /* loaded from: classes.dex */
    private class a implements Callable<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        private final String f1264b;

        public a(String str) {
            this.f1264b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            b.this.d.a(this.f1264b);
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class CallableC0036b implements Callable<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        private final String f1266b;

        public CallableC0036b(String str) {
            this.f1266b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            b.this.e.a(this.f1266b);
            return true;
        }
    }

    public b(Context context) {
        this.d = c.a(context);
        this.e = d.a(context);
    }

    public void a(final com.facebook.ads.internal.c.a aVar) {
        final ArrayList arrayList = new ArrayList(this.f);
        this.f1258c.submit(new Runnable() { // from class: com.facebook.ads.internal.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<Future> arrayList2 = new ArrayList(arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(b.this.f1258c.submit((Callable) it.next()));
                }
                try {
                    for (Future future : arrayList2) {
                        future.get();
                    }
                } catch (InterruptedException | ExecutionException e) {
                    Log.e(b.f1256a, "Exception while executing cache downloads.", e);
                }
                b.this.f1257b.post(new Runnable() { // from class: com.facebook.ads.internal.c.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a();
                    }
                });
            }
        });
        this.f.clear();
    }

    public void a(String str) {
        this.f.add(new a(str));
    }

    public void b(String str) {
        this.f.add(new CallableC0036b(str));
    }

    public String c(String str) {
        return this.e.b(str);
    }
}
