package com.google.android.material.datepicker;

import java.util.Calendar;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static final long f2095f;

    /* renamed from: g  reason: collision with root package name */
    public static final long f2096g;

    /* renamed from: a  reason: collision with root package name */
    public final long f2097a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2098b;

    /* renamed from: c  reason: collision with root package name */
    public Long f2099c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2100d;

    /* renamed from: e  reason: collision with root package name */
    public final b f2101e;

    static {
        p a5 = p.a(1900, 0);
        Calendar d5 = w.d(null);
        d5.setTimeInMillis(a5.f2148g);
        f2095f = w.b(d5).getTimeInMillis();
        p a6 = p.a(2100, 11);
        Calendar d6 = w.d(null);
        d6.setTimeInMillis(a6.f2148g);
        f2096g = w.b(d6).getTimeInMillis();
    }

    public a(c cVar) {
        this.f2097a = f2095f;
        this.f2098b = f2096g;
        this.f2101e = new e(Long.MIN_VALUE);
        this.f2097a = cVar.f2102b.f2148g;
        this.f2098b = cVar.f2103c.f2148g;
        this.f2099c = Long.valueOf(cVar.f2105e.f2148g);
        this.f2100d = cVar.f2106f;
        this.f2101e = cVar.f2104d;
    }
}
