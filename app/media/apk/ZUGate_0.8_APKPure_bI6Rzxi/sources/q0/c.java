package q0;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public final class c implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4432a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f5) {
        switch (this.f4432a) {
            case 0:
            case 1:
            default:
                float f6 = f5 - 1.0f;
                return (f6 * f6 * f6 * f6 * f6) + 1.0f;
        }
    }
}
