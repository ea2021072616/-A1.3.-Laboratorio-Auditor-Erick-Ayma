package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
/* compiled from: StrokeContent.java */
/* loaded from: classes.dex */
class ce extends p {

    /* renamed from: b  reason: collision with root package name */
    private final String f509b;

    /* renamed from: c  reason: collision with root package name */
    private final au<Integer> f510c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(ax axVar, o oVar, by byVar) {
        super(axVar, oVar, byVar.g().a(), byVar.h().a(), byVar.c(), byVar.d(), byVar.e(), byVar.f());
        this.f509b = byVar.a();
        this.f510c = byVar.b().b();
        this.f510c.a(this);
        oVar.a(this.f510c);
    }

    @Override // com.airbnb.lottie.aa
    public void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.f547a.setColorFilter(colorFilter);
    }

    @Override // com.airbnb.lottie.p, com.airbnb.lottie.aa
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f547a.setColor(((Integer) this.f510c.b()).intValue());
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.f509b;
    }
}
