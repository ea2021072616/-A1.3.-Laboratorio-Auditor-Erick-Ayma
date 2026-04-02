package com.bumptech.glide.d;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes.dex */
class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Set<h> f644a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f645b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f646c;

    @Override // com.bumptech.glide.d.g
    public void a(h hVar) {
        this.f644a.add(hVar);
        if (this.f646c) {
            hVar.onDestroy();
        } else if (this.f645b) {
            hVar.onStart();
        } else {
            hVar.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f645b = true;
        for (h hVar : com.bumptech.glide.i.h.a(this.f644a)) {
            hVar.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f645b = false;
        for (h hVar : com.bumptech.glide.i.h.a(this.f644a)) {
            hVar.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f646c = true;
        for (h hVar : com.bumptech.glide.i.h.a(this.f644a)) {
            hVar.onDestroy();
        }
    }
}
