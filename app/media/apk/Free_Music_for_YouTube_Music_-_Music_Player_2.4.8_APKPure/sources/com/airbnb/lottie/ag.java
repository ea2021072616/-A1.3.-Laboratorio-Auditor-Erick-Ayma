package com.airbnb.lottie;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientColor.java */
/* loaded from: classes.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f384a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f385b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(float[] fArr, int[] iArr) {
        this.f384a = fArr;
        this.f385b = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float[] a() {
        return this.f384a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] b() {
        return this.f385b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f385b.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ag agVar, ag agVar2, float f) {
        if (agVar.f385b.length != agVar2.f385b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + agVar.f385b.length + " vs " + agVar2.f385b.length + ")");
        }
        for (int i = 0; i < agVar.f385b.length; i++) {
            this.f384a[i] = bd.a(agVar.f384a[i], agVar2.f384a[i], f);
            this.f385b[i] = af.a(f, agVar.f385b[i], agVar2.f385b[i]);
        }
    }
}
