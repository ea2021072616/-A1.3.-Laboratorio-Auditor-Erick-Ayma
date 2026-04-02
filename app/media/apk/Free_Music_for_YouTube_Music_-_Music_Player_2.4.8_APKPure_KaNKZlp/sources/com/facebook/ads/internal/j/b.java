package com.facebook.ads.internal.j;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private c f1446a;

    /* renamed from: b  reason: collision with root package name */
    private float f1447b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f1448c;

    public b(c cVar) {
        this(cVar, 0.0f);
    }

    public b(c cVar, float f) {
        this(cVar, f, null);
    }

    public b(c cVar, float f, Map<String, String> map) {
        this.f1446a = cVar;
        this.f1447b = f;
        if (map != null) {
            this.f1448c = map;
        } else {
            this.f1448c = new HashMap();
        }
    }

    public boolean a() {
        return this.f1446a == c.IS_VIEWABLE;
    }

    public int b() {
        return this.f1446a.a();
    }

    public float c() {
        return this.f1447b;
    }

    public Map<String, String> d() {
        return this.f1448c;
    }
}
