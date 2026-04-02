package r3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.ViewPropertyAnimator;
import com.google.android.material.snackbar.SnackbarContentLayout;
/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4495a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f4496b;

    public /* synthetic */ c(l lVar, int i5) {
        this.f4495a = i5;
        this.f4496b = lVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i5 = this.f4495a;
        l lVar = this.f4496b;
        switch (i5) {
            case 0:
                lVar.c();
                return;
            default:
                lVar.c();
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f4495a) {
            case 0:
                l lVar = this.f4496b;
                m mVar = lVar.f4529j;
                int i5 = lVar.f4522c;
                int i6 = lVar.f4520a;
                int i7 = i5 - i6;
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) mVar;
                snackbarContentLayout.f2195g.setAlpha(0.0f);
                long j5 = i6;
                ViewPropertyAnimator duration = snackbarContentLayout.f2195g.animate().alpha(1.0f).setDuration(j5);
                TimeInterpolator timeInterpolator = snackbarContentLayout.f2197i;
                long j6 = i7;
                duration.setInterpolator(timeInterpolator).setStartDelay(j6).start();
                if (snackbarContentLayout.f2196h.getVisibility() == 0) {
                    snackbarContentLayout.f2196h.setAlpha(0.0f);
                    snackbarContentLayout.f2196h.animate().alpha(1.0f).setDuration(j5).setInterpolator(timeInterpolator).setStartDelay(j6).start();
                    return;
                }
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
