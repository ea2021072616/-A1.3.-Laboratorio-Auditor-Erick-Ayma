package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1417b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f1418c;

    public /* synthetic */ m(int i5, Object obj) {
        this.f1417b = i5;
        this.f1418c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f1417b;
        Object obj = this.f1418c;
        switch (i5) {
            case 0:
                q qVar = (q) obj;
                int i6 = qVar.A;
                ValueAnimator valueAnimator = qVar.f1481z;
                if (i6 == 1) {
                    valueAnimator.cancel();
                } else if (i6 != 2) {
                    return;
                }
                qVar.A = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                return;
            default:
                ((StaggeredGridLayoutManager) obj).D0();
                return;
        }
    }
}
