package com.fotoable.youtube.music.util;

import java.util.concurrent.TimeUnit;
/* compiled from: RetryWithDelay.java */
/* loaded from: classes.dex */
public class p implements rx.c.e<rx.f<? extends Throwable>, rx.f<?>> {
    private static final String d = p.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final int f4896a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4897b;

    /* renamed from: c  reason: collision with root package name */
    public int f4898c;

    public p(int i, int i2) {
        this.f4896a = i;
        this.f4897b = i2;
    }

    @Override // rx.c.e
    public rx.f<?> a(rx.f<? extends Throwable> fVar) {
        return fVar.b(new rx.c.e<Throwable, rx.f<?>>() { // from class: com.fotoable.youtube.music.util.p.1
            @Override // rx.c.e
            public rx.f<?> a(Throwable th) {
                p pVar = p.this;
                int i = pVar.f4898c + 1;
                pVar.f4898c = i;
                if (i <= p.this.f4896a) {
                    if (th != null) {
                    }
                    return rx.f.b(p.this.f4897b, TimeUnit.MILLISECONDS);
                }
                return rx.f.a(th);
            }
        });
    }
}
