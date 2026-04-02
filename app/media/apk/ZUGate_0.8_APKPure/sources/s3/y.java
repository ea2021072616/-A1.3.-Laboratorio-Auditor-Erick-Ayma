package s3;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.appcompat.widget.i1;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes.dex */
public final class y extends h0.b {

    /* renamed from: d  reason: collision with root package name */
    public final TextInputLayout f4976d;

    public y(TextInputLayout textInputLayout) {
        this.f4976d = textInputLayout;
    }

    @Override // h0.b
    public final void d(View view, i0.j jVar) {
        View.AccessibilityDelegate accessibilityDelegate = this.f3105a;
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.f4976d;
        EditText editText = textInputLayout.getEditText();
        Editable text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean z4 = !TextUtils.isEmpty(text);
        boolean z5 = !TextUtils.isEmpty(hint);
        boolean z6 = !textInputLayout.A0;
        boolean z7 = !TextUtils.isEmpty(error);
        boolean z8 = z7 || !TextUtils.isEmpty(counterOverflowDescription);
        String charSequence = z5 ? hint.toString() : "";
        w wVar = textInputLayout.f2209h;
        i1 i1Var = wVar.f4965h;
        if (i1Var.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(i1Var);
            accessibilityNodeInfo.setTraversalAfter(i1Var);
        } else {
            accessibilityNodeInfo.setTraversalAfter(wVar.f4967j);
        }
        if (z4) {
            accessibilityNodeInfo.setText(text);
        } else if (!TextUtils.isEmpty(charSequence)) {
            accessibilityNodeInfo.setText(charSequence);
            if (z6 && placeholderText != null) {
                accessibilityNodeInfo.setText(charSequence + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            accessibilityNodeInfo.setText(placeholderText);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            accessibilityNodeInfo.setHintText(charSequence);
            accessibilityNodeInfo.setShowingHintText(true ^ z4);
        }
        accessibilityNodeInfo.setMaxTextLength((text == null || text.length() != counterMaxLength) ? -1 : -1);
        if (z8) {
            if (!z7) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        i1 i1Var2 = textInputLayout.f2224p.f4948y;
        if (i1Var2 != null) {
            accessibilityNodeInfo.setLabelFor(i1Var2);
        }
        textInputLayout.f2211i.b().n(jVar);
    }

    @Override // h0.b
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        super.e(view, accessibilityEvent);
        this.f4976d.f2211i.b().o(accessibilityEvent);
    }
}
