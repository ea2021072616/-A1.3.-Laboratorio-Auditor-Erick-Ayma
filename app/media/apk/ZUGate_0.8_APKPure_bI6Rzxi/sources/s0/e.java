package s0;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.m;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class e extends androidx.emoji2.text.k {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f4812a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference f4813b;

    public e(TextView textView, f fVar) {
        this.f4812a = new WeakReference(textView);
        this.f4813b = new WeakReference(fVar);
    }

    @Override // androidx.emoji2.text.k
    public final void b() {
        boolean z4;
        int length;
        InputFilter[] filters;
        TextView textView = (TextView) this.f4812a.get();
        InputFilter inputFilter = (InputFilter) this.f4813b.get();
        if (inputFilter != null && textView != null && (filters = textView.getFilters()) != null) {
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    z4 = true;
                    break;
                }
            }
        }
        z4 = false;
        if (z4 && textView.isAttachedToWindow()) {
            CharSequence text = textView.getText();
            m a5 = m.a();
            if (text == null) {
                length = 0;
            } else {
                a5.getClass();
                length = text.length();
            }
            CharSequence f5 = a5.f(0, length, text);
            if (text == f5) {
                return;
            }
            int selectionStart = Selection.getSelectionStart(f5);
            int selectionEnd = Selection.getSelectionEnd(f5);
            textView.setText(f5);
            if (f5 instanceof Spannable) {
                Spannable spannable = (Spannable) f5;
                if (selectionStart >= 0 && selectionEnd >= 0) {
                    Selection.setSelection(spannable, selectionStart, selectionEnd);
                } else if (selectionStart >= 0) {
                    Selection.setSelection(spannable, selectionStart);
                } else if (selectionEnd >= 0) {
                    Selection.setSelection(spannable, selectionEnd);
                }
            }
        }
    }
}
