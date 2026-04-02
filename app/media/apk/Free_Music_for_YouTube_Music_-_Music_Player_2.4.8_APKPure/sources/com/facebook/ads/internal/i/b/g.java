package com.facebook.ads.internal.i.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    private final String f1429b;

    /* renamed from: c  reason: collision with root package name */
    private volatile e f1430c;
    private final b e;
    private final c f;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f1428a = new AtomicInteger(0);
    private final List<b> d = new CopyOnWriteArrayList();

    /* loaded from: classes.dex */
    private static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        private final String f1431a;

        /* renamed from: b  reason: collision with root package name */
        private final List<b> f1432b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f1431a = str;
            this.f1432b = list;
        }

        @Override // com.facebook.ads.internal.i.b.b
        public void a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (b bVar : this.f1432b) {
                bVar.a((File) message.obj, this.f1431a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f1429b = (String) j.a(str);
        this.f = (c) j.a(cVar);
        this.e = new a(str, this.d);
    }

    private synchronized void c() {
        this.f1430c = this.f1430c == null ? e() : this.f1430c;
    }

    private synchronized void d() {
        if (this.f1428a.decrementAndGet() <= 0) {
            this.f1430c.a();
            this.f1430c = null;
        }
    }

    private e e() {
        e eVar = new e(new h(this.f1429b), new com.facebook.ads.internal.i.b.a.b(this.f.a(this.f1429b), this.f.f1408c));
        eVar.a(this.e);
        return eVar;
    }

    public void a() {
        this.d.clear();
        if (this.f1430c != null) {
            this.f1430c.a((b) null);
            this.f1430c.a();
            this.f1430c = null;
        }
        this.f1428a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f1428a.incrementAndGet();
            this.f1430c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f1428a.get();
    }
}
