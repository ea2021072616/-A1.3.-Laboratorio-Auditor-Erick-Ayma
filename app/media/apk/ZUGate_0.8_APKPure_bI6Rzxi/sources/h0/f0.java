package h0;

import android.view.VelocityTracker;
/* loaded from: classes.dex */
public abstract class f0 {
    public static float a(VelocityTracker velocityTracker, int i5) {
        return velocityTracker.getAxisVelocity(i5);
    }

    public static float b(VelocityTracker velocityTracker, int i5, int i6) {
        return velocityTracker.getAxisVelocity(i5, i6);
    }

    public static boolean c(VelocityTracker velocityTracker, int i5) {
        return velocityTracker.isAxisSupported(i5);
    }
}
