package h0;

import android.view.WindowInsetsAnimation;
/* loaded from: classes.dex */
public final class s1 extends t1 {

    /* renamed from: e  reason: collision with root package name */
    public final WindowInsetsAnimation f3204e;

    public s1(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.f3204e = windowInsetsAnimation;
    }

    @Override // h0.t1
    public final long a() {
        long durationMillis;
        durationMillis = this.f3204e.getDurationMillis();
        return durationMillis;
    }

    @Override // h0.t1
    public final float b() {
        float interpolatedFraction;
        interpolatedFraction = this.f3204e.getInterpolatedFraction();
        return interpolatedFraction;
    }

    @Override // h0.t1
    public final int c() {
        int typeMask;
        typeMask = this.f3204e.getTypeMask();
        return typeMask;
    }

    @Override // h0.t1
    public final void d(float f5) {
        this.f3204e.setFraction(f5);
    }
}
