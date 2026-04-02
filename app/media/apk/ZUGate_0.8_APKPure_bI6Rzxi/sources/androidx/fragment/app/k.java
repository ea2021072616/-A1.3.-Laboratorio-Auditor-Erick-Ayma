package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class k extends l {

    /* renamed from: c  reason: collision with root package name */
    public final boolean f932c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f933d;

    /* renamed from: e  reason: collision with root package name */
    public e0 f934e;

    public k(s1 s1Var, d0.c cVar, boolean z4) {
        super(s1Var, cVar);
        this.f933d = false;
        this.f932c = z4;
    }

    public final e0 c(Context context) {
        Animation loadAnimation;
        e0 e0Var;
        if (this.f933d) {
            return this.f934e;
        }
        s1 s1Var = this.f943a;
        Fragment fragment = s1Var.f1001c;
        boolean z4 = false;
        boolean z5 = s1Var.f999a == 2;
        int nextTransition = fragment.getNextTransition();
        int popEnterAnim = this.f932c ? z5 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z5 ? fragment.getEnterAnim() : fragment.getExitAnim();
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        e0 e0Var2 = null;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z5, popEnterAnim);
            if (onCreateAnimation != null) {
                e0Var2 = new e0(onCreateAnimation);
            } else {
                Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z5, popEnterAnim);
                if (onCreateAnimator != null) {
                    e0Var2 = new e0(onCreateAnimator);
                } else {
                    if (popEnterAnim == 0 && nextTransition != 0) {
                        popEnterAnim = nextTransition != 4097 ? nextTransition != 8194 ? nextTransition != 8197 ? nextTransition != 4099 ? nextTransition != 4100 ? -1 : z5 ? e4.e.b0(context, 16842936) : e4.e.b0(context, 16842937) : z5 ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit : z5 ? e4.e.b0(context, 16842938) : e4.e.b0(context, 16842939) : z5 ? R.animator.fragment_close_enter : R.animator.fragment_close_exit : z5 ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                    }
                    if (popEnterAnim != 0) {
                        boolean equals = "anim".equals(context.getResources().getResourceTypeName(popEnterAnim));
                        if (equals) {
                            try {
                                loadAnimation = AnimationUtils.loadAnimation(context, popEnterAnim);
                            } catch (Resources.NotFoundException e5) {
                                throw e5;
                            } catch (RuntimeException unused) {
                            }
                            if (loadAnimation != null) {
                                e0Var = new e0(loadAnimation);
                                e0Var2 = e0Var;
                            } else {
                                z4 = true;
                            }
                        }
                        if (!z4) {
                            try {
                                Animator loadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                                if (loadAnimator != null) {
                                    e0Var = new e0(loadAnimator);
                                    e0Var2 = e0Var;
                                }
                            } catch (RuntimeException e6) {
                                if (equals) {
                                    throw e6;
                                }
                                Animation loadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                                if (loadAnimation2 != null) {
                                    e0Var2 = new e0(loadAnimation2);
                                }
                            }
                        }
                    }
                }
            }
        }
        this.f934e = e0Var2;
        this.f933d = true;
        return e0Var2;
    }
}
