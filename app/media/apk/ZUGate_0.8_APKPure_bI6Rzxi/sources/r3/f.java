package r3;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.snackbar.BaseTransientBottomBar$Behavior;
import h0.z0;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class f implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        int i5 = message.what;
        if (i5 == 0) {
            l lVar = (l) message.obj;
            k kVar = lVar.f4528i;
            if (kVar.getParent() == null) {
                ViewGroup.LayoutParams layoutParams = kVar.getLayoutParams();
                if (layoutParams instanceof u.d) {
                    u.d dVar = (u.d) layoutParams;
                    BaseTransientBottomBar$Behavior baseTransientBottomBar$Behavior = new BaseTransientBottomBar$Behavior();
                    n2.b bVar = baseTransientBottomBar$Behavior.f2194j;
                    bVar.getClass();
                    bVar.f4085g = lVar.f4538t;
                    baseTransientBottomBar$Behavior.f2013b = new h(lVar);
                    u.a aVar = dVar.f5096a;
                    if (aVar != baseTransientBottomBar$Behavior) {
                        if (aVar != null) {
                            aVar.i();
                        }
                        dVar.f5096a = baseTransientBottomBar$Behavior;
                        dVar.f5097b = true;
                    }
                    dVar.f5102g = 80;
                }
                kVar.f4513q = true;
                lVar.f4526g.addView(kVar);
                kVar.f4513q = false;
                lVar.e();
                kVar.setVisibility(4);
            }
            WeakHashMap weakHashMap = z0.f3233a;
            if (kVar.isLaidOut()) {
                lVar.d();
            } else {
                lVar.f4536r = true;
            }
            return true;
        } else if (i5 != 1) {
            return false;
        } else {
            l lVar2 = (l) message.obj;
            int i6 = message.arg1;
            AccessibilityManager accessibilityManager = lVar2.f4537s;
            if (accessibilityManager == null || ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) != null && enabledAccessibilityServiceList.isEmpty())) {
                k kVar2 = lVar2.f4528i;
                if (kVar2.getVisibility() == 0) {
                    if (kVar2.getAnimationMode() == 1) {
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                        ofFloat.setInterpolator(lVar2.f4523d);
                        ofFloat.addUpdateListener(new b(lVar2, 0));
                        ofFloat.setDuration(lVar2.f4521b);
                        ofFloat.addListener(new a(lVar2, i6, 0));
                        ofFloat.start();
                    } else {
                        ValueAnimator valueAnimator = new ValueAnimator();
                        int height = kVar2.getHeight();
                        ViewGroup.LayoutParams layoutParams2 = kVar2.getLayoutParams();
                        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                            height += ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        }
                        valueAnimator.setIntValues(0, height);
                        valueAnimator.setInterpolator(lVar2.f4524e);
                        valueAnimator.setDuration(lVar2.f4522c);
                        valueAnimator.addListener(new a(lVar2, i6, 1));
                        valueAnimator.addUpdateListener(new e(lVar2));
                        valueAnimator.start();
                    }
                    return true;
                }
            }
            lVar2.b();
            return true;
        }
    }
}
