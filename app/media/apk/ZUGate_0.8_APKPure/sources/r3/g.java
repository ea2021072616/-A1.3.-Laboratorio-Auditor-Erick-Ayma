package r3;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.WindowMetrics;
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4499b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f4500c;

    public /* synthetic */ g(l lVar, int i5) {
        this.f4499b = i5;
        this.f4500c = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Rect rect;
        WindowMetrics currentWindowMetrics;
        int i5 = this.f4499b;
        l lVar = this.f4500c;
        switch (i5) {
            case 0:
                if (lVar.f4528i == null || (context = lVar.f4527h) == null) {
                    return;
                }
                int i6 = e4.e.f2711f;
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                if (Build.VERSION.SDK_INT >= 30) {
                    currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                    rect = currentWindowMetrics.getBounds();
                } else {
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    Point point = new Point();
                    defaultDisplay.getRealSize(point);
                    rect = new Rect();
                    rect.right = point.x;
                    rect.bottom = point.y;
                }
                int height = rect.height();
                int[] iArr = new int[2];
                k kVar = lVar.f4528i;
                kVar.getLocationInWindow(iArr);
                int height2 = (height - (kVar.getHeight() + iArr[1])) + ((int) kVar.getTranslationY());
                int i7 = lVar.f4534p;
                if (height2 >= i7) {
                    lVar.f4535q = i7;
                    return;
                }
                ViewGroup.LayoutParams layoutParams = kVar.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    Log.w(l.f4519z, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                    return;
                }
                int i8 = lVar.f4534p;
                lVar.f4535q = i8;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = (i8 - height2) + marginLayoutParams.bottomMargin;
                kVar.requestLayout();
                return;
            case 1:
                lVar.b();
                return;
            default:
                k kVar2 = lVar.f4528i;
                if (kVar2 == null) {
                    return;
                }
                ViewParent parent = kVar2.getParent();
                k kVar3 = lVar.f4528i;
                if (parent != null) {
                    kVar3.setVisibility(0);
                }
                if (kVar3.getAnimationMode() == 1) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setInterpolator(lVar.f4523d);
                    ofFloat.addUpdateListener(new b(lVar, 0));
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
                    ofFloat2.setInterpolator(lVar.f4525f);
                    ofFloat2.addUpdateListener(new b(lVar, 1));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ofFloat, ofFloat2);
                    animatorSet.setDuration(lVar.f4520a);
                    animatorSet.addListener(new c(lVar, 1));
                    animatorSet.start();
                    return;
                }
                int height3 = kVar3.getHeight();
                ViewGroup.LayoutParams layoutParams2 = kVar3.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    height3 += ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                }
                kVar3.setTranslationY(height3);
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setIntValues(height3, 0);
                valueAnimator.setInterpolator(lVar.f4524e);
                valueAnimator.setDuration(lVar.f4522c);
                valueAnimator.addListener(new c(lVar, 0));
                valueAnimator.addUpdateListener(new d(lVar, height3));
                valueAnimator.start();
                return;
        }
    }
}
