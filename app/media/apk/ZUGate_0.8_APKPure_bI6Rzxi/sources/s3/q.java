package s3;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
/* loaded from: classes.dex */
public final class q extends View.AccessibilityDelegate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f4924a;

    public q(r rVar) {
        this.f4924a = rVar;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        EditText editText = this.f4924a.f4932h.getEditText();
        if (editText != null) {
            accessibilityNodeInfo.setLabeledBy(editText);
        }
    }
}
