package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.util.Log;
import com.airbnb.lottie.av;
import com.airbnb.lottie.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseLayer.java */
/* loaded from: classes.dex */
public abstract class o implements aa, n.a {

    /* renamed from: b  reason: collision with root package name */
    final ax f541b;

    /* renamed from: c  reason: collision with root package name */
    final av f542c;
    final cf d;
    @Nullable
    private ba o;
    @Nullable
    private o p;
    @Nullable
    private o q;
    private List<o> r;
    private final Path e = new Path();
    private final Matrix f = new Matrix();
    private final Paint g = new Paint(1);
    private final Paint h = new Paint(1);
    private final Paint i = new Paint(1);
    private final Paint j = new Paint();
    private final RectF k = new RectF();
    private final RectF l = new RectF();
    private final RectF m = new RectF();
    private final RectF n = new RectF();

    /* renamed from: a  reason: collision with root package name */
    final Matrix f540a = new Matrix();
    private final List<n<?, ?>> s = new ArrayList();
    private boolean t = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static o a(av avVar, ax axVar, aw awVar) {
        switch (avVar.i()) {
            case Shape:
                return new bw(axVar, avVar);
            case PreComp:
                return new v(axVar, avVar, awVar.a(avVar.e()), awVar);
            case Solid:
                return new cb(axVar, avVar);
            case Image:
                return new ap(axVar, avVar, awVar.g());
            case Null:
                return new be(axVar, avVar);
            default:
                Log.w("LOTTIE", "Unknown layer type " + avVar.i());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ax axVar, av avVar) {
        this.f541b = axVar;
        this.f542c = avVar;
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        if (avVar.j() == av.c.Invert) {
            this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.d = avVar.m().f();
        this.d.a((n.a) this);
        this.d.a(this);
        if (avVar.h() != null && !avVar.h().isEmpty()) {
            this.o = new ba(avVar.h());
            for (n<?, Path> nVar : this.o.b()) {
                a(nVar);
                nVar.a(this);
            }
        }
        f();
    }

    @Override // com.airbnb.lottie.n.a
    public void a() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public av b() {
        return this.f542c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nullable o oVar) {
        this.p = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.p != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable o oVar) {
        this.q = oVar;
    }

    private void f() {
        if (!this.f542c.b().isEmpty()) {
            final ae aeVar = new ae(this.f542c.b());
            aeVar.a();
            aeVar.a(new n.a() { // from class: com.airbnb.lottie.o.1
                @Override // com.airbnb.lottie.n.a
                public void a() {
                    o.this.a(((Float) aeVar.b()).floatValue() == 1.0f);
                }
            });
            a(((Float) aeVar.b()).floatValue() == 1.0f);
            a(aeVar);
            return;
        }
        a(true);
    }

    private void g() {
        this.f541b.invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n<?, ?> nVar) {
        if (!(nVar instanceof cd)) {
            this.s.add(nVar);
        }
    }

    @Override // com.airbnb.lottie.aa
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.f540a.set(matrix);
        this.f540a.preConcat(this.d.b());
    }

    @Override // com.airbnb.lottie.aa
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (this.t) {
            h();
            this.f.reset();
            this.f.set(matrix);
            for (int size = this.r.size() - 1; size >= 0; size--) {
                this.f.preConcat(this.r.get(size).d.b());
            }
            int intValue = (int) (((this.d.a().b().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
            if (!c() && !d()) {
                this.f.preConcat(this.d.b());
                b(canvas, this.f, intValue);
                return;
            }
            this.k.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(this.k, this.f);
            c(this.k, this.f);
            this.f.preConcat(this.d.b());
            b(this.k, this.f);
            this.k.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.saveLayer(this.k, this.g, 31);
            a(canvas);
            b(canvas, this.f, intValue);
            if (d()) {
                a(canvas, this.f);
            }
            if (c()) {
                canvas.saveLayer(this.k, this.i, 19);
                a(canvas);
                this.p.a(canvas, matrix, intValue);
                canvas.restore();
            }
            canvas.restore();
        }
    }

    private void a(Canvas canvas) {
        canvas.drawRect(this.k.left - 1.0f, this.k.top - 1.0f, this.k.right + 1.0f, 1.0f + this.k.bottom, this.j);
    }

    private void b(RectF rectF, Matrix matrix) {
        this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (d()) {
            int size = this.o.a().size();
            for (int i = 0; i < size; i++) {
                this.e.set(this.o.b().get(i).b());
                this.e.transform(matrix);
                switch (this.o.a().get(i).a()) {
                    case MaskModeSubtract:
                        return;
                    default:
                        this.e.computeBounds(this.n, false);
                        if (i == 0) {
                            this.l.set(this.n);
                        } else {
                            this.l.set(Math.min(this.l.left, this.n.left), Math.min(this.l.top, this.n.top), Math.max(this.l.right, this.n.right), Math.max(this.l.bottom, this.n.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.l.left), Math.max(rectF.top, this.l.top), Math.min(rectF.right, this.l.right), Math.min(rectF.bottom, this.l.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (c() && this.f542c.j() != av.c.Invert) {
            this.p.a(this.m, matrix);
            rectF.set(Math.max(rectF.left, this.m.left), Math.max(rectF.top, this.m.top), Math.min(rectF.right, this.m.right), Math.min(rectF.bottom, this.m.bottom));
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        canvas.saveLayer(this.k, this.h, 19);
        a(canvas);
        int size = this.o.a().size();
        for (int i = 0; i < size; i++) {
            this.e.set(this.o.b().get(i).b());
            this.e.transform(matrix);
            switch (this.o.a().get(i).a()) {
                case MaskModeSubtract:
                    this.e.setFillType(Path.FillType.INVERSE_WINDING);
                    break;
                default:
                    this.e.setFillType(Path.FillType.WINDING);
                    break;
            }
            canvas.drawPath(this.e, this.g);
        }
        canvas.restore();
    }

    boolean d() {
        return (this.o == null || this.o.b().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z != this.t) {
            this.t = z;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.p != null) {
            this.p.a(f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.s.size()) {
                this.s.get(i2).a(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void h() {
        if (this.r == null) {
            if (this.q == null) {
                this.r = Collections.emptyList();
                return;
            }
            this.r = new ArrayList();
            for (o oVar = this.q; oVar != null; oVar = oVar.q) {
                this.r.add(oVar);
            }
        }
    }

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.f542c.d();
    }

    @Override // com.airbnb.lottie.x
    public void a(List<x> list, List<x> list2) {
    }

    @Override // com.airbnb.lottie.aa
    public void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
