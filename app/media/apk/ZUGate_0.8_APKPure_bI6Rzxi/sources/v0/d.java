package v0;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public abstract class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f5184a;

    /* renamed from: b  reason: collision with root package name */
    public final float f5185b;

    public d(float[] fArr) {
        this.f5184a = fArr;
        this.f5185b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f5) {
        if (f5 >= 1.0f) {
            return 1.0f;
        }
        if (f5 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f5184a;
        int min = Math.min((int) ((fArr.length - 1) * f5), fArr.length - 2);
        float f6 = this.f5185b;
        float f7 = fArr[min];
        return ((fArr[min + 1] - f7) * ((f5 - (min * f6)) / f6)) + f7;
    }
}
