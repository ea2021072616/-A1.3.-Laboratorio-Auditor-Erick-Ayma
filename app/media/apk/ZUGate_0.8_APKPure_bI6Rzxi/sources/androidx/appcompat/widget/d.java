package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import android.view.View;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f303a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f304b;

    public /* synthetic */ d(int i5, Object obj) {
        this.f303a = i5;
        this.f304b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f303a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f304b;
                actionBarOverlayLayout.C = null;
                actionBarOverlayLayout.f192p = false;
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i5 = this.f303a;
        Object obj = this.f304b;
        switch (i5) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                actionBarOverlayLayout.C = null;
                actionBarOverlayLayout.f192p = false;
                return;
            case 1:
                ((e1.r) obj).n();
                animator.removeListener(this);
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                f1.d dVar = (f1.d) obj;
                ArrayList arrayList = new ArrayList(dVar.f2752k);
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ColorStateList colorStateList = ((e3.a) arrayList.get(i6)).f2685b.f2696u;
                    if (colorStateList != null) {
                        a0.a.h(dVar, colorStateList);
                    }
                }
                return;
            case 3:
                ((HideBottomViewOnScrollBehavior) obj).f2011h = null;
                return;
            case 4:
            default:
                ((ExpandableTransformationBehavior) obj).getClass();
                return;
            case 5:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) obj;
                bottomSheetBehavior.I(5);
                WeakReference weakReference = bottomSheetBehavior.U;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((View) bottomSheetBehavior.U.get()).requestLayout();
                return;
            case 6:
                b0.n(obj);
                throw null;
            case 7:
                k3.g gVar = (k3.g) obj;
                gVar.f3641b.setTranslationY(0.0f);
                gVar.b(0.0f);
                return;
            case 8:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                sideSheetBehavior.x(5);
                WeakReference weakReference2 = sideSheetBehavior.f2186p;
                if (weakReference2 == null || weakReference2.get() == null) {
                    return;
                }
                ((View) sideSheetBehavior.f2186p.get()).requestLayout();
                return;
            case 9:
                s3.k kVar = (s3.k) obj;
                kVar.q();
                kVar.f4893r.start();
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i5 = this.f303a;
        Object obj = this.f304b;
        switch (i5) {
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                f1.d dVar = (f1.d) obj;
                ArrayList arrayList = new ArrayList(dVar.f2752k);
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    e3.c cVar = ((e3.a) arrayList.get(i6)).f2685b;
                    ColorStateList colorStateList = cVar.f2696u;
                    if (colorStateList != null) {
                        a0.a.g(dVar, colorStateList.getColorForState(cVar.f2700y, colorStateList.getDefaultColor()));
                    }
                }
                return;
            case 6:
                b0.n(obj);
                throw null;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
