package com.airbnb.lottie;

import com.airbnb.lottie.bz;
import com.airbnb.lottie.n;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public class cg implements n.a, x {

    /* renamed from: a  reason: collision with root package name */
    private String f514a;

    /* renamed from: b  reason: collision with root package name */
    private final List<n.a> f515b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final bz.b f516c;
    private final n<?, Float> d;
    private final n<?, Float> e;
    private final n<?, Float> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(o oVar, bz bzVar) {
        this.f514a = bzVar.a();
        this.f516c = bzVar.b();
        this.d = bzVar.d().b();
        this.e = bzVar.c().b();
        this.f = bzVar.e().b();
        oVar.a(this.d);
        oVar.a(this.e);
        oVar.a(this.f);
        this.d.a(this);
        this.e.a(this);
        this.f.a(this);
    }

    @Override // com.airbnb.lottie.n.a
    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f515b.size()) {
                this.f515b.get(i2).a();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.x
    public void a(List<x> list, List<x> list2) {
    }

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.f514a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n.a aVar) {
        this.f515b.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz.b b() {
        return this.f516c;
    }

    public n<?, Float> c() {
        return this.d;
    }

    public n<?, Float> d() {
        return this.e;
    }

    public n<?, Float> f() {
        return this.f;
    }
}
