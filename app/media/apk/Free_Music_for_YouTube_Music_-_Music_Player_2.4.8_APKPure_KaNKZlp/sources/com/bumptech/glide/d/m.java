package com.bumptech.glide.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
/* compiled from: RequestTracker.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final Set<com.bumptech.glide.g.b> f658a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<com.bumptech.glide.g.b> f659b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f660c;

    public void a(com.bumptech.glide.g.b bVar) {
        this.f658a.add(bVar);
        if (!this.f660c) {
            bVar.b();
        } else {
            this.f659b.add(bVar);
        }
    }

    public void b(com.bumptech.glide.g.b bVar) {
        this.f658a.remove(bVar);
        this.f659b.remove(bVar);
    }

    public void a() {
        this.f660c = true;
        for (com.bumptech.glide.g.b bVar : com.bumptech.glide.i.h.a(this.f658a)) {
            if (bVar.f()) {
                bVar.e();
                this.f659b.add(bVar);
            }
        }
    }

    public void b() {
        this.f660c = false;
        for (com.bumptech.glide.g.b bVar : com.bumptech.glide.i.h.a(this.f658a)) {
            if (!bVar.g() && !bVar.i() && !bVar.f()) {
                bVar.b();
            }
        }
        this.f659b.clear();
    }

    public void c() {
        for (com.bumptech.glide.g.b bVar : com.bumptech.glide.i.h.a(this.f658a)) {
            bVar.d();
        }
        this.f659b.clear();
    }

    public void d() {
        for (com.bumptech.glide.g.b bVar : com.bumptech.glide.i.h.a(this.f658a)) {
            if (!bVar.g() && !bVar.i()) {
                bVar.e();
                if (!this.f660c) {
                    bVar.b();
                } else {
                    this.f659b.add(bVar);
                }
            }
        }
    }
}
