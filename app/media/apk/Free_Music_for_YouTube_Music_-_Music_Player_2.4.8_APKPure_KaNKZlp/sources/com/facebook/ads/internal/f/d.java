package com.facebook.ads.internal.f;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    private e f1329c;
    @Nullable
    private String d;

    /* renamed from: b  reason: collision with root package name */
    private int f1328b = 0;

    /* renamed from: a  reason: collision with root package name */
    private List<a> f1327a = new ArrayList();

    public d(e eVar, @Nullable String str) {
        this.f1329c = eVar;
        this.d = str;
    }

    public e a() {
        return this.f1329c;
    }

    public void a(a aVar) {
        this.f1327a.add(aVar);
    }

    @Nullable
    public String b() {
        return this.d;
    }

    public int c() {
        return this.f1327a.size();
    }

    public a d() {
        if (this.f1328b < this.f1327a.size()) {
            this.f1328b++;
            return this.f1327a.get(this.f1328b - 1);
        }
        return null;
    }
}
