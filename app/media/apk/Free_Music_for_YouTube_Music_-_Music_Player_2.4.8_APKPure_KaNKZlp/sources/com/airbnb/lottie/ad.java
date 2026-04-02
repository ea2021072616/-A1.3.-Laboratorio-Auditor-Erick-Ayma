package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.n;
import java.util.ArrayList;
import java.util.List;
/* compiled from: FillContent.java */
/* loaded from: classes.dex */
class ad implements aa, n.a {

    /* renamed from: c  reason: collision with root package name */
    private final String f383c;
    private final au<Integer> e;
    private final au<Integer> f;
    private final ax g;

    /* renamed from: a  reason: collision with root package name */
    private final Path f381a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Paint f382b = new Paint(1);
    private final List<bg> d = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ax axVar, o oVar, bt btVar) {
        this.f383c = btVar.a();
        this.g = axVar;
        if (btVar.b() == null || btVar.c() == null) {
            this.e = null;
            this.f = null;
            return;
        }
        this.f381a.setFillType(btVar.d());
        this.e = btVar.b().b();
        this.e.a(this);
        oVar.a(this.e);
        this.f = btVar.c().b();
        this.f.a(this);
        oVar.a(this.f);
    }

    @Override // com.airbnb.lottie.n.a
    public void a() {
        this.g.invalidateSelf();
    }

    @Override // com.airbnb.lottie.x
    public void a(List<x> list, List<x> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                x xVar = list2.get(i2);
                if (xVar instanceof bg) {
                    this.d.add((bg) xVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.f383c;
    }

    @Override // com.airbnb.lottie.aa
    public void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.f382b.setColorFilter(colorFilter);
    }

    @Override // com.airbnb.lottie.aa
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f382b.setColor(((Integer) this.e.b()).intValue());
        Paint paint = this.f382b;
        paint.setAlpha((int) (((((Integer) this.f.b()).intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.f381a.reset();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.d.size()) {
                this.f381a.addPath(this.d.get(i3).d(), matrix);
                i2 = i3 + 1;
            } else {
                canvas.drawPath(this.f381a, this.f382b);
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.aa
    public void a(RectF rectF, Matrix matrix) {
        this.f381a.reset();
        for (int i = 0; i < this.d.size(); i++) {
            this.f381a.addPath(this.d.get(i).d(), matrix);
        }
        this.f381a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
