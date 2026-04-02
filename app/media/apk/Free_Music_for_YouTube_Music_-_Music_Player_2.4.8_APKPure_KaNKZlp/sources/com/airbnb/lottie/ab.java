package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.bz;
import com.airbnb.lottie.n;
import java.util.List;
/* compiled from: EllipseContent.java */
/* loaded from: classes.dex */
class ab implements bg, n.a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f376a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f377b;

    /* renamed from: c  reason: collision with root package name */
    private final ax f378c;
    private final n<?, PointF> d;
    private final n<?, PointF> e;
    @Nullable
    private cg f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ax axVar, o oVar, s sVar) {
        this.f377b = sVar.a();
        this.f378c = axVar;
        this.d = sVar.c().b();
        this.e = sVar.b().b();
        oVar.a(this.d);
        oVar.a(this.e);
        this.d.a(this);
        this.e.a(this);
    }

    @Override // com.airbnb.lottie.n.a
    public void a() {
        b();
    }

    private void b() {
        this.g = false;
        this.f378c.invalidateSelf();
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

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.f377b;
    }

    @Override // com.airbnb.lottie.bg
    public Path d() {
        if (this.g) {
            return this.f376a;
        }
        this.f376a.reset();
        PointF b2 = this.d.b();
        float f = b2.x / 2.0f;
        float f2 = b2.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.f376a.reset();
        this.f376a.moveTo(0.0f, -f2);
        this.f376a.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
        this.f376a.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
        this.f376a.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
        this.f376a.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        PointF b3 = this.e.b();
        this.f376a.offset(b3.x, b3.y);
        this.f376a.close();
        ch.a(this.f376a, this.f);
        this.g = true;
        return this.f376a;
    }
}
