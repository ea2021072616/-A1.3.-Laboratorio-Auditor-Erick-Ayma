package com.airbnb.lottie;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.bz;
import com.airbnb.lottie.n;
import java.util.List;
/* compiled from: ShapeContent.java */
/* loaded from: classes.dex */
class br implements bg, n.a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f471a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f472b;

    /* renamed from: c  reason: collision with root package name */
    private final ax f473c;
    private final n<?, Path> d;
    private boolean e;
    @Nullable
    private cg f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(ax axVar, o oVar, bx bxVar) {
        this.f472b = bxVar.a();
        this.f473c = axVar;
        this.d = bxVar.b().b();
        oVar.a(this.d);
        this.d.a(this);
    }

    @Override // com.airbnb.lottie.n.a
    public void a() {
        b();
    }

    private void b() {
        this.e = false;
        this.f473c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.x
    public void a(List<x> list, List<x> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                x xVar = list.get(i2);
                if ((xVar instanceof cg) && ((cg) xVar).b() == bz.b.Simultaneously) {
                    this.f = (cg) xVar;
                    this.f.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.bg
    public Path d() {
        if (this.e) {
            return this.f471a;
        }
        this.f471a.reset();
        this.f471a.set(this.d.b());
        this.f471a.setFillType(Path.FillType.EVEN_ODD);
        ch.a(this.f471a, this.f);
        this.e = true;
        return this.f471a;
    }

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.f472b;
    }
}
