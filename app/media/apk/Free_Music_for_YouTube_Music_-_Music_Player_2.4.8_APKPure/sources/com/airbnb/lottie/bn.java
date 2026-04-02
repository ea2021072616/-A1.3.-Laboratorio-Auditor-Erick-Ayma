package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.bz;
import com.airbnb.lottie.n;
import java.util.List;
/* compiled from: RectangleContent.java */
/* loaded from: classes.dex */
class bn implements bg, n.a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f462a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f463b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final String f464c;
    private final ax d;
    private final n<?, PointF> e;
    private final n<?, PointF> f;
    private final n<?, Float> g;
    @Nullable
    private cg h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(ax axVar, o oVar, bo boVar) {
        this.f464c = boVar.a();
        this.d = axVar;
        this.e = boVar.d().b();
        this.f = boVar.c().b();
        this.g = boVar.b().b();
        oVar.a(this.e);
        oVar.a(this.f);
        oVar.a(this.g);
        this.e.a(this);
        this.f.a(this);
        this.g.a(this);
    }

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.f464c;
    }

    @Override // com.airbnb.lottie.n.a
    public void a() {
        b();
    }

    private void b() {
        this.i = false;
        this.d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.x
    public void a(List<x> list, List<x> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                x xVar = list.get(i2);
                if ((xVar instanceof cg) && ((cg) xVar).b() == bz.b.Simultaneously) {
                    this.h = (cg) xVar;
                    this.h.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.bg
    public Path d() {
        if (this.i) {
            return this.f462a;
        }
        this.f462a.reset();
        PointF b2 = this.f.b();
        float f = b2.x / 2.0f;
        float f2 = b2.y / 2.0f;
        float floatValue = this.g == null ? 0.0f : this.g.b().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF b3 = this.e.b();
        this.f462a.moveTo(b3.x + f, (b3.y - f2) + min);
        this.f462a.lineTo(b3.x + f, (b3.y + f2) - min);
        if (min > 0.0f) {
            this.f463b.set((b3.x + f) - (2.0f * min), (b3.y + f2) - (2.0f * min), b3.x + f, b3.y + f2);
            this.f462a.arcTo(this.f463b, 0.0f, 90.0f, false);
        }
        this.f462a.lineTo((b3.x - f) + min, b3.y + f2);
        if (min > 0.0f) {
            this.f463b.set(b3.x - f, (b3.y + f2) - (2.0f * min), (b3.x - f) + (2.0f * min), b3.y + f2);
            this.f462a.arcTo(this.f463b, 90.0f, 90.0f, false);
        }
        this.f462a.lineTo(b3.x - f, (b3.y - f2) + min);
        if (min > 0.0f) {
            this.f463b.set(b3.x - f, b3.y - f2, (b3.x - f) + (2.0f * min), (b3.y - f2) + (2.0f * min));
            this.f462a.arcTo(this.f463b, 180.0f, 90.0f, false);
        }
        this.f462a.lineTo((b3.x + f) - min, b3.y - f2);
        if (min > 0.0f) {
            this.f463b.set((b3.x + f) - (2.0f * min), b3.y - f2, f + b3.x, (b3.y - f2) + (min * 2.0f));
            this.f462a.arcTo(this.f463b, 270.0f, 90.0f, false);
        }
        this.f462a.close();
        ch.a(this.f462a, this.h);
        this.i = true;
        return this.f462a;
    }
}
