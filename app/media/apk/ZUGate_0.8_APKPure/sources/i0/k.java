package i0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.recyclerview.widget.b0;
import java.util.List;
/* loaded from: classes.dex */
public abstract class k extends AccessibilityNodeProvider {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f3378a;

    public k(b0 b0Var) {
        this.f3378a = b0Var;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i5) {
        j b5 = this.f3378a.b(i5);
        if (b5 == null) {
            return null;
        }
        return b5.f3375a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i5) {
        this.f3378a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i5) {
        j c5 = this.f3378a.c(i5);
        if (c5 == null) {
            return null;
        }
        return c5.f3375a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i5, int i6, Bundle bundle) {
        return this.f3378a.d(i5, i6, bundle);
    }
}
