package n0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
/* loaded from: classes.dex */
public final class h extends h0.b {
    @Override // h0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
        accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
        accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
        accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
        accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
    }

    @Override // h0.b
    public final void d(View view, i0.j jVar) {
        int scrollRange;
        View.AccessibilityDelegate accessibilityDelegate = this.f3105a;
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        jVar.h(ScrollView.class.getName());
        if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
            return;
        }
        accessibilityNodeInfo.setScrollable(true);
        if (nestedScrollView.getScrollY() > 0) {
            jVar.b(i0.e.f3364g);
            jVar.b(i0.e.f3368k);
        }
        if (nestedScrollView.getScrollY() < scrollRange) {
            jVar.b(i0.e.f3363f);
            jVar.b(i0.e.f3369l);
        }
    }

    @Override // h0.b
    public final boolean g(View view, int i5, Bundle bundle) {
        if (super.g(view, i5, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (nestedScrollView.isEnabled()) {
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i5 != 4096) {
                if (i5 == 8192 || i5 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max != nestedScrollView.getScrollY()) {
                        nestedScrollView.u(0 - nestedScrollView.getScrollX(), max - nestedScrollView.getScrollY(), true);
                        return true;
                    }
                    return false;
                } else if (i5 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min != nestedScrollView.getScrollY()) {
                nestedScrollView.u(0 - nestedScrollView.getScrollX(), min - nestedScrollView.getScrollY(), true);
                return true;
            }
            return false;
        }
        return false;
    }
}
