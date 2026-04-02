package com.airbnb.lottie;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: classes.dex */
public class cf {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f511a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final n<?, PointF> f512b;

    /* renamed from: c  reason: collision with root package name */
    private final n<?, PointF> f513c;
    private final n<?, bq> d;
    private final n<?, Float> e;
    private final n<?, Integer> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(j jVar) {
        this.f512b = jVar.a().b();
        this.f513c = jVar.b().b();
        this.d = jVar.c().b();
        this.e = jVar.d().b();
        this.f = jVar.e().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(o oVar) {
        oVar.a(this.f512b);
        oVar.a(this.f513c);
        oVar.a(this.d);
        oVar.a(this.e);
        oVar.a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n.a aVar) {
        this.f512b.a(aVar);
        this.f513c.a(aVar);
        this.d.a(aVar);
        this.e.a(aVar);
        this.f.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n<?, Integer> a() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix b() {
        this.f511a.reset();
        PointF b2 = this.f513c.b();
        if (b2.x != 0.0f || b2.y != 0.0f) {
            this.f511a.preTranslate(b2.x, b2.y);
        }
        float floatValue = this.e.b().floatValue();
        if (floatValue != 0.0f) {
            this.f511a.preRotate(floatValue);
        }
        bq b3 = this.d.b();
        if (b3.a() != 1.0f || b3.b() != 1.0f) {
            this.f511a.preScale(b3.a(), b3.b());
        }
        PointF b4 = this.f512b.b();
        if (b4.x != 0.0f || b4.y != 0.0f) {
            this.f511a.preTranslate(-b4.x, -b4.y);
        }
        return this.f511a;
    }
}
