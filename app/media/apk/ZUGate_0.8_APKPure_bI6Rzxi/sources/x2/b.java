package x2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import l.j;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final j f5488a = new j();

    /* renamed from: b  reason: collision with root package name */
    public final j f5489b = new j();

    public static b a(Context context, int i5) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i5);
            if (loadAnimator instanceof AnimatorSet) {
                return b(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(loadAnimator);
                return b(arrayList);
            }
            return null;
        } catch (Exception e5) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i5), e5);
            return null;
        }
    }

    public static b b(ArrayList arrayList) {
        b bVar = new b();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            Animator animator = (Animator) arrayList.get(i5);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            bVar.f5489b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = a.f5485b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = a.f5486c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = a.f5487d;
            }
            c cVar = new c(startDelay, duration, interpolator);
            cVar.f5493d = objectAnimator.getRepeatCount();
            cVar.f5494e = objectAnimator.getRepeatMode();
            bVar.f5488a.put(propertyName, cVar);
        }
        return bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f5488a.equals(((b) obj).f5488a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5488a.hashCode();
    }

    public final String toString() {
        return "\n" + b.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f5488a + "}\n";
    }
}
