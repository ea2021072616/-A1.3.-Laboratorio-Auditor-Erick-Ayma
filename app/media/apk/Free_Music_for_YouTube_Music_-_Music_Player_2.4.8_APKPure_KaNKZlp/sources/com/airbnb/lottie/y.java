package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.Log;
import com.airbnb.lottie.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentGroup.java */
/* loaded from: classes.dex */
public class y implements aa, bg, n.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f557a = y.class.getSimpleName();
    private final String e;
    private final ax g;
    @Nullable
    private List<bg> h;
    @Nullable
    private cf i;

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f558b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private final Path f559c = new Path();
    private final RectF d = new RectF();
    private final List<x> f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ax axVar, o oVar, bu buVar) {
        this.e = buVar.a();
        this.g = axVar;
        List<Object> b2 = buVar.b();
        if (!b2.isEmpty()) {
            Object obj = b2.get(b2.size() - 1);
            if (obj instanceof j) {
                this.i = ((j) obj).f();
                this.i.a(oVar);
                this.i.a(this);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= b2.size()) {
                    break;
                }
                Object obj2 = b2.get(i2);
                if (obj2 instanceof bt) {
                    this.f.add(new ad(axVar, oVar, (bt) obj2));
                } else if (obj2 instanceof ai) {
                    this.f.add(new aj(axVar, oVar, (ai) obj2));
                } else if (obj2 instanceof by) {
                    this.f.add(new ce(axVar, oVar, (by) obj2));
                } else if (obj2 instanceof ak) {
                    this.f.add(new al(axVar, oVar, (ak) obj2));
                } else if (obj2 instanceof bu) {
                    this.f.add(new y(axVar, oVar, (bu) obj2));
                } else if (obj2 instanceof bo) {
                    this.f.add(new bn(axVar, oVar, (bo) obj2));
                } else if (obj2 instanceof s) {
                    this.f.add(new ab(axVar, oVar, (s) obj2));
                } else if (obj2 instanceof bx) {
                    this.f.add(new br(axVar, oVar, (bx) obj2));
                } else if (obj2 instanceof bm) {
                    this.f.add(new bl(axVar, oVar, (bm) obj2));
                } else if (obj2 instanceof bz) {
                    this.f.add(new cg(oVar, (bz) obj2));
                } else if (obj2 instanceof bb) {
                    if (axVar.a()) {
                        this.f.add(new bc((bb) obj2));
                    } else {
                        Log.w(f557a, "Animation contains merge paths but they are disabled.");
                    }
                }
                i = i2 + 1;
            }
            ArrayList arrayList = new ArrayList();
            bc bcVar = null;
            for (int size = this.f.size() - 1; size >= 0; size--) {
                x xVar = this.f.get(size);
                bcVar = xVar instanceof bc ? (bc) xVar : bcVar;
                if (bcVar != null && xVar != bcVar) {
                    bcVar.a(xVar);
                    arrayList.add(xVar);
                }
            }
            Iterator<x> it = this.f.iterator();
            while (it.hasNext()) {
                if (arrayList.contains(it.next())) {
                    it.remove();
                }
            }
        }
    }

    @Override // com.airbnb.lottie.n.a
    public void a() {
        this.g.invalidateSelf();
    }

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.e;
    }

    @Override // com.airbnb.lottie.aa
    public void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f.size()) {
                x xVar = this.f.get(i2);
                if (xVar instanceof aa) {
                    aa aaVar = (aa) xVar;
                    if (str2 == null || str2.equals(xVar.e())) {
                        aaVar.a(str, (String) null, colorFilter);
                    } else {
                        aaVar.a(str, str2, colorFilter);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.x
    public void a(List<x> list, List<x> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f.size());
        arrayList.addAll(list);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            x xVar = this.f.get(size);
            xVar.a(arrayList, this.f.subList(0, size));
            arrayList.add(xVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<bg> b() {
        if (this.h == null) {
            this.h = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.size()) {
                    break;
                }
                x xVar = this.f.get(i2);
                if (xVar instanceof bg) {
                    this.h.add((bg) xVar);
                }
                i = i2 + 1;
            }
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix c() {
        if (this.i != null) {
            return this.i.b();
        }
        this.f558b.reset();
        return this.f558b;
    }

    @Override // com.airbnb.lottie.bg
    public Path d() {
        this.f558b.reset();
        if (this.i != null) {
            this.f558b.set(this.i.b());
        }
        this.f559c.reset();
        for (int size = this.f.size() - 1; size >= 0; size--) {
            x xVar = this.f.get(size);
            if (xVar instanceof bg) {
                this.f559c.addPath(((bg) xVar).d(), this.f558b);
            }
        }
        return this.f559c;
    }

    @Override // com.airbnb.lottie.aa
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f558b.set(matrix);
        if (this.i != null) {
            this.f558b.preConcat(this.i.b());
            i = (int) ((((this.i.a().b().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            x xVar = this.f.get(size);
            if (xVar instanceof aa) {
                ((aa) xVar).a(canvas, this.f558b, i);
            }
        }
    }

    @Override // com.airbnb.lottie.aa
    public void a(RectF rectF, Matrix matrix) {
        this.f558b.set(matrix);
        if (this.i != null) {
            this.f558b.preConcat(this.i.b());
        }
        this.d.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            x xVar = this.f.get(size);
            if (xVar instanceof aa) {
                ((aa) xVar).a(this.d, this.f558b);
                if (rectF.isEmpty()) {
                    rectF.set(this.d);
                } else {
                    rectF.set(Math.min(rectF.left, this.d.left), Math.min(rectF.top, this.d.top), Math.max(rectF.right, this.d.right), Math.max(rectF.bottom, this.d.bottom));
                }
            }
        }
    }
}
