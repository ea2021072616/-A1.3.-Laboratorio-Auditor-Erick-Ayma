package com.facebook.ads.internal.adapters;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final b f1152a;

    /* renamed from: b  reason: collision with root package name */
    protected final com.facebook.ads.internal.j.a f1153b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1154c;
    private boolean d;

    public a(Context context, b bVar, com.facebook.ads.internal.j.a aVar) {
        this.f1154c = context;
        this.f1152a = bVar;
        this.f1153b = aVar;
    }

    public final void a() {
        if (this.d) {
            return;
        }
        if (this.f1152a != null) {
            this.f1152a.d();
        }
        HashMap hashMap = new HashMap();
        if (this.f1153b != null) {
            this.f1153b.a(hashMap);
        }
        a(hashMap);
        this.d = true;
        com.facebook.ads.internal.util.g.a(this.f1154c, "Impression logged");
        if (this.f1152a != null) {
            this.f1152a.e();
        }
    }

    protected abstract void a(Map<String, String> map);
}
