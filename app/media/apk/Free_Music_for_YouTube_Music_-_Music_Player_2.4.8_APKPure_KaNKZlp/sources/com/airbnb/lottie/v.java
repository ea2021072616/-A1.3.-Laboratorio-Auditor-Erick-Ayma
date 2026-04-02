package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompositionLayer.java */
/* loaded from: classes.dex */
public class v extends o {
    private final List<o> e;
    private final RectF f;
    private final Rect g;
    private final RectF h;
    @Nullable
    private Boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ax axVar, av avVar, List<av> list, aw awVar) {
        super(axVar, avVar);
        o oVar;
        this.e = new ArrayList();
        this.f = new RectF();
        this.g = new Rect();
        this.h = new RectF();
        LongSparseArray longSparseArray = new LongSparseArray(awVar.d().size());
        int size = list.size() - 1;
        o oVar2 = null;
        while (size >= 0) {
            o a2 = o.a(list.get(size), axVar, awVar);
            if (a2 == null) {
                oVar = oVar2;
            } else {
                longSparseArray.put(a2.b().c(), a2);
                if (oVar2 != null) {
                    oVar2.a(a2);
                    oVar = null;
                } else {
                    this.e.add(0, a2);
                    switch (r0.j()) {
                        case Add:
                        case Invert:
                            oVar = a2;
                            continue;
                        default:
                            oVar = oVar2;
                            continue;
                    }
                }
            }
            size--;
            oVar2 = oVar;
        }
        for (int i = 0; i < longSparseArray.size(); i++) {
            o oVar3 = (o) longSparseArray.get(longSparseArray.keyAt(i));
            o oVar4 = (o) longSparseArray.get(oVar3.b().k());
            if (oVar4 != null) {
                oVar3.b(oVar4);
            }
        }
    }

    @Override // com.airbnb.lottie.o
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.getClipBounds(this.g);
        this.h.set(0.0f, 0.0f, this.f542c.f(), this.f542c.g());
        matrix.mapRect(this.h);
        for (int size = this.e.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.h.isEmpty()) {
                z = canvas.clipRect(this.h);
            }
            if (z) {
                this.e.get(size).a(canvas, matrix, i);
            }
        }
        if (!this.g.isEmpty()) {
            canvas.clipRect(this.g, Region.Op.REPLACE);
        }
    }

    @Override // com.airbnb.lottie.o, com.airbnb.lottie.aa
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.f.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.e.size() - 1; size >= 0; size--) {
            this.e.get(size).a(this.f, this.f540a);
            if (rectF.isEmpty()) {
                rectF.set(this.f);
            } else {
                rectF.set(Math.min(rectF.left, this.f.left), Math.min(rectF.top, this.f.top), Math.max(rectF.right, this.f.right), Math.max(rectF.bottom, this.f.bottom));
            }
        }
    }

    @Override // com.airbnb.lottie.o
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.a(f);
        float a2 = f - this.f542c.a();
        for (int size = this.e.size() - 1; size >= 0; size--) {
            this.e.get(size).a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        if (this.i == null) {
            if (c()) {
                this.i = true;
                return true;
            }
            for (int size = this.e.size() - 1; size >= 0; size--) {
                if (this.e.get(size).c()) {
                    this.i = true;
                    return true;
                }
            }
            this.i = false;
        }
        return this.i.booleanValue();
    }

    @Override // com.airbnb.lottie.o, com.airbnb.lottie.aa
    public void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                o oVar = this.e.get(i2);
                String d = oVar.b().d();
                if (str == null) {
                    oVar.a((String) null, (String) null, colorFilter);
                } else if (d.equals(str)) {
                    oVar.a(str, str2, colorFilter);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
