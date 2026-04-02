package r3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.ViewPropertyAnimator;
import com.google.android.material.snackbar.SnackbarContentLayout;
/* loaded from: classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4491a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f4492b;

    public /* synthetic */ a(l lVar, int i5, int i6) {
        this.f4491a = i6;
        this.f4492b = lVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i5 = this.f4491a;
        l lVar = this.f4492b;
        switch (i5) {
            case 0:
                lVar.b();
                return;
            default:
                lVar.b();
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f4491a) {
            case 1:
                l lVar = this.f4492b;
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) lVar.f4529j;
                snackbarContentLayout.f2195g.setAlpha(1.0f);
                ViewPropertyAnimator alpha = snackbarContentLayout.f2195g.animate().alpha(0.0f);
                long j5 = lVar.f4521b;
                ViewPropertyAnimator duration = alpha.setDuration(j5);
                TimeInterpolator timeInterpolator = snackbarContentLayout.f2197i;
                long j6 = 0;
                duration.setInterpolator(timeInterpolator).setStartDelay(j6).start();
                if (snackbarContentLayout.f2196h.getVisibility() == 0) {
                    snackbarContentLayout.f2196h.setAlpha(1.0f);
                    snackbarContentLayout.f2196h.animate().alpha(0.0f).setDuration(j5).setInterpolator(timeInterpolator).setStartDelay(j6).start();
                    return;
                }
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
