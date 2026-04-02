package com.flurry.sdk;

import java.lang.Thread;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class me {

    /* renamed from: c  reason: collision with root package name */
    private static me f2193c;

    /* renamed from: b  reason: collision with root package name */
    final Map<Thread.UncaughtExceptionHandler, Void> f2195b = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    final Thread.UncaughtExceptionHandler f2194a = Thread.getDefaultUncaughtExceptionHandler();

    private me() {
        Thread.setDefaultUncaughtExceptionHandler(new a(this, (byte) 0));
    }

    public static synchronized me a() {
        me meVar;
        synchronized (me.class) {
            if (f2193c == null) {
                f2193c = new me();
            }
            meVar = f2193c;
        }
        return meVar;
    }

    final Set<Thread.UncaughtExceptionHandler> b() {
        Set<Thread.UncaughtExceptionHandler> keySet;
        synchronized (this.f2195b) {
            keySet = this.f2195b.keySet();
        }
        return keySet;
    }

    /* loaded from: classes.dex */
    final class a implements Thread.UncaughtExceptionHandler {
        private a() {
        }

        /* synthetic */ a(me meVar, byte b2) {
            this();
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            for (Thread.UncaughtExceptionHandler uncaughtExceptionHandler : me.this.b()) {
                try {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } catch (Throwable th2) {
                }
            }
            me meVar = me.this;
            if (meVar.f2194a != null) {
                try {
                    meVar.f2194a.uncaughtException(thread, th);
                } catch (Throwable th3) {
                }
            }
        }
    }
}
