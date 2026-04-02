package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import com.flurry.sdk.kb;
import com.flurry.sdk.ll;
import com.flurry.sdk.lq;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class lm implements lq.a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f2158b = lm.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static lm f2159c;

    /* renamed from: a  reason: collision with root package name */
    public long f2160a;
    private long g;
    private lk h;
    private final Map<Context, lk> d = new WeakHashMap();
    private final ln e = new ln();
    private final Object f = new Object();
    private kh<lo> i = new kh<lo>() { // from class: com.flurry.sdk.lm.1
        @Override // com.flurry.sdk.kh
        public final /* bridge */ /* synthetic */ void a(lo loVar) {
            lm.this.g();
        }
    };
    private kh<kb> j = new kh<kb>() { // from class: com.flurry.sdk.lm.2
        @Override // com.flurry.sdk.kh
        public final /* synthetic */ void a(kb kbVar) {
            kb kbVar2 = kbVar;
            Activity activity = kbVar2.f2029a.get();
            if (activity == null) {
                km.a(lm.f2158b, "Activity has been destroyed, can't pass ActivityLifecycleEvent to adobject.");
                return;
            }
            switch (AnonymousClass5.f2166a[kbVar2.f2030b.ordinal()]) {
                case 1:
                    km.a(3, lm.f2158b, "Automatic onStartSession for context:" + kbVar2.f2029a);
                    lm.this.e(activity);
                    return;
                case 2:
                    km.a(3, lm.f2158b, "Automatic onEndSession for context:" + kbVar2.f2029a);
                    lm.this.d(activity);
                    return;
                case 3:
                    km.a(3, lm.f2158b, "Automatic onEndSession (destroyed) for context:" + kbVar2.f2029a);
                    lm.this.d(activity);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: com.flurry.sdk.lm$5  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2166a = new int[kb.a.values().length];

        static {
            try {
                f2166a[kb.a.kStarted.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2166a[kb.a.kStopped.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2166a[kb.a.kDestroyed.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private lm() {
        lp a2 = lp.a();
        this.f2160a = 0L;
        this.g = ((Long) a2.a("ContinueSessionMillis")).longValue();
        a2.a("ContinueSessionMillis", (lq.a) this);
        km.a(4, f2158b, "initSettings, ContinueSessionMillis = " + this.g);
        ki.a().a("com.flurry.android.sdk.ActivityLifecycleEvent", this.j);
        ki.a().a("com.flurry.android.sdk.FlurrySessionTimerEvent", this.i);
    }

    public static synchronized lm a() {
        lm lmVar;
        synchronized (lm.class) {
            if (f2159c == null) {
                f2159c = new lm();
            }
            lmVar = f2159c;
        }
        return lmVar;
    }

    public final synchronized void a(Context context) {
        if ((context instanceof Activity) && kc.a().b()) {
            km.a(3, f2158b, "bootstrap for context:" + context);
            e(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(Context context) {
        if (this.d.get(context) != null) {
            if (kc.a().b()) {
                km.a(3, f2158b, "Session already started with context:" + context);
            } else {
                km.e(f2158b, "Session already started with context:" + context);
            }
        } else {
            this.e.a();
            lk b2 = b();
            if (b2 == null) {
                b2 = new lk();
                km.e(f2158b, "Flurry session started for context:" + context);
                ll llVar = new ll();
                llVar.f2152a = new WeakReference<>(context);
                llVar.f2153b = b2;
                llVar.f2154c = ll.a.f2155a;
                llVar.b();
            }
            this.d.put(context, b2);
            synchronized (this.f) {
                this.h = b2;
            }
            km.e(f2158b, "Flurry session resumed for context:" + context);
            ll llVar2 = new ll();
            llVar2.f2152a = new WeakReference<>(context);
            llVar2.f2153b = b2;
            llVar2.f2154c = ll.a.f2157c;
            llVar2.b();
            this.f2160a = 0L;
        }
    }

    public final lk b() {
        lk lkVar;
        synchronized (this.f) {
            lkVar = this.h;
        }
        return lkVar;
    }

    public final synchronized void b(Context context) {
        if (!kc.a().b() || !(context instanceof Activity)) {
            km.a(3, f2158b, "Manual onStartSession for context:" + context);
            e(context);
        }
    }

    public final synchronized void c(Context context) {
        if (!kc.a().b() || !(context instanceof Activity)) {
            km.a(3, f2158b, "Manual onEndSession for context:" + context);
            d(context);
        }
    }

    final synchronized void d(Context context) {
        lk remove = this.d.remove(context);
        if (remove == null) {
            if (kc.a().b()) {
                km.a(3, f2158b, "Session cannot be ended, session not found for context:" + context);
            } else {
                km.e(f2158b, "Session cannot be ended, session not found for context:" + context);
            }
        } else {
            km.e(f2158b, "Flurry session paused for context:" + context);
            ll llVar = new ll();
            llVar.f2152a = new WeakReference<>(context);
            llVar.f2153b = remove;
            jk.a();
            llVar.d = jk.d();
            llVar.f2154c = ll.a.d;
            llVar.b();
            if (f() == 0) {
                this.e.a(this.g);
                this.f2160a = System.currentTimeMillis();
            } else {
                this.f2160a = 0L;
            }
        }
    }

    private synchronized int f() {
        return this.d.size();
    }

    public final synchronized boolean c() {
        boolean z;
        if (b() == null) {
            km.a(2, f2158b, "Session not found. No active session");
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public final synchronized void d() {
        for (Map.Entry<Context, lk> entry : this.d.entrySet()) {
            ll llVar = new ll();
            llVar.f2152a = new WeakReference<>(entry.getKey());
            llVar.f2153b = entry.getValue();
            llVar.f2154c = ll.a.d;
            jk.a();
            llVar.d = jk.d();
            llVar.b();
        }
        this.d.clear();
        jy.a().b(new ma() { // from class: com.flurry.sdk.lm.3
            @Override // com.flurry.sdk.ma
            public final void a() {
                lm.this.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        int f = f();
        if (f > 0) {
            km.a(5, f2158b, "Session cannot be finalized, sessionContextCount:" + f);
        } else {
            final lk b2 = b();
            if (b2 == null) {
                km.a(5, f2158b, "Session cannot be finalized, current session not found");
            } else {
                km.e(f2158b, "Flurry session ended");
                ll llVar = new ll();
                llVar.f2153b = b2;
                llVar.f2154c = ll.a.e;
                jk.a();
                llVar.d = jk.d();
                llVar.b();
                jy.a().b(new ma() { // from class: com.flurry.sdk.lm.4
                    @Override // com.flurry.sdk.ma
                    public final void a() {
                        lm.a(lm.this, b2);
                    }
                });
            }
        }
    }

    @Override // com.flurry.sdk.lq.a
    public final void a(String str, Object obj) {
        if (str.equals("ContinueSessionMillis")) {
            this.g = ((Long) obj).longValue();
            km.a(4, f2158b, "onSettingUpdate, ContinueSessionMillis = " + this.g);
            return;
        }
        km.a(6, f2158b, "onSettingUpdate internal error!");
    }

    static /* synthetic */ void a(lm lmVar, lk lkVar) {
        synchronized (lmVar.f) {
            if (lmVar.h == lkVar) {
                lmVar.h = null;
            }
        }
    }
}
