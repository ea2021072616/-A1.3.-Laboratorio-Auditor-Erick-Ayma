package h0;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public abstract class t1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3210a;

    /* renamed from: b  reason: collision with root package name */
    public float f3211b;

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f3212c;

    /* renamed from: d  reason: collision with root package name */
    public final long f3213d;

    public t1(int i5, Interpolator interpolator, long j5) {
        this.f3210a = i5;
        this.f3212c = interpolator;
        this.f3213d = j5;
    }

    public long a() {
        return this.f3213d;
    }

    public float b() {
        Interpolator interpolator = this.f3212c;
        return interpolator != null ? interpolator.getInterpolation(this.f3211b) : this.f3211b;
    }

    public int c() {
        return this.f3210a;
    }

    public void d(float f5) {
        this.f3211b = f5;
    }
}
