package i0;

import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes.dex */
public abstract class f {
    public static Object a(int i5, float f5, float f6, float f7) {
        return new AccessibilityNodeInfo.RangeInfo(i5, f5, f6, f7);
    }

    public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getStateDescription();
    }

    public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setStateDescription(charSequence);
    }
}
