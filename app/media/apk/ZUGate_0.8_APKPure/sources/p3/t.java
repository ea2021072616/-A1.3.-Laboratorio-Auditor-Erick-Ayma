package p3;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public float f4357a;

    /* renamed from: b  reason: collision with root package name */
    public float f4358b;

    /* renamed from: c  reason: collision with root package name */
    public float f4359c;

    /* renamed from: d  reason: collision with root package name */
    public float f4360d;

    /* renamed from: e  reason: collision with root package name */
    public float f4361e;

    /* renamed from: f  reason: collision with root package name */
    public float f4362f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f4363g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f4364h = new ArrayList();

    public t() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f5) {
        float f6 = this.f4361e;
        if (f6 == f5) {
            return;
        }
        float f7 = ((f5 - f6) + 360.0f) % 360.0f;
        if (f7 > 180.0f) {
            return;
        }
        float f8 = this.f4359c;
        float f9 = this.f4360d;
        p pVar = new p(f8, f9, f8, f9);
        pVar.f4350f = this.f4361e;
        pVar.f4351g = f7;
        this.f4364h.add(new n(pVar));
        this.f4361e = f5;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f4363g;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((r) arrayList.get(i5)).a(matrix, path);
        }
    }

    public final void c(float f5, float f6) {
        q qVar = new q();
        qVar.f4352b = f5;
        qVar.f4353c = f6;
        this.f4363g.add(qVar);
        o oVar = new o(qVar, this.f4359c, this.f4360d);
        a(oVar.b() + 270.0f);
        this.f4364h.add(oVar);
        this.f4361e = oVar.b() + 270.0f;
        this.f4359c = f5;
        this.f4360d = f6;
    }

    public final void d(float f5, float f6, float f7) {
        this.f4357a = 0.0f;
        this.f4358b = f5;
        this.f4359c = 0.0f;
        this.f4360d = f5;
        this.f4361e = f6;
        this.f4362f = (f6 + f7) % 360.0f;
        this.f4363g.clear();
        this.f4364h.clear();
    }
}
