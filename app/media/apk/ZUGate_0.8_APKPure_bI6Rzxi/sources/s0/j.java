package s0;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.widget.c3;
import androidx.emoji2.text.m;
/* loaded from: classes.dex */
public final class j implements TextWatcher {

    /* renamed from: g  reason: collision with root package name */
    public final EditText f4822g;

    /* renamed from: i  reason: collision with root package name */
    public c3 f4824i;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f4823h = false;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4825j = true;

    public j(EditText editText) {
        this.f4822g = editText;
    }

    public static void a(EditText editText, int i5) {
        int length;
        if (i5 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            m a5 = m.a();
            if (editableText == null) {
                length = 0;
            } else {
                a5.getClass();
                length = editableText.length();
            }
            a5.f(0, length, editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        if ((androidx.emoji2.text.m.f769k != null) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onTextChanged(java.lang.CharSequence r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            android.widget.EditText r0 = r4.f4822g
            boolean r1 = r0.isInEditMode()
            if (r1 != 0) goto L54
            boolean r1 = r4.f4825j
            r2 = 1
            if (r1 == 0) goto L1b
            boolean r1 = r4.f4823h
            r3 = 0
            if (r1 != 0) goto L1c
            androidx.emoji2.text.m r1 = androidx.emoji2.text.m.f769k
            if (r1 == 0) goto L18
            r1 = r2
            goto L19
        L18:
            r1 = r3
        L19:
            if (r1 != 0) goto L1c
        L1b:
            r3 = r2
        L1c:
            if (r3 == 0) goto L1f
            goto L54
        L1f:
            if (r7 > r8) goto L54
            boolean r7 = r5 instanceof android.text.Spannable
            if (r7 == 0) goto L54
            androidx.emoji2.text.m r7 = androidx.emoji2.text.m.a()
            int r7 = r7.b()
            if (r7 == 0) goto L40
            if (r7 == r2) goto L35
            r5 = 3
            if (r7 == r5) goto L40
            goto L54
        L35:
            android.text.Spannable r5 = (android.text.Spannable) r5
            androidx.emoji2.text.m r7 = androidx.emoji2.text.m.a()
            int r8 = r8 + r6
            r7.f(r6, r8, r5)
            goto L54
        L40:
            androidx.emoji2.text.m r5 = androidx.emoji2.text.m.a()
            androidx.appcompat.widget.c3 r6 = r4.f4824i
            if (r6 != 0) goto L4f
            androidx.appcompat.widget.c3 r6 = new androidx.appcompat.widget.c3
            r6.<init>(r0)
            r4.f4824i = r6
        L4f:
            androidx.appcompat.widget.c3 r6 = r4.f4824i
            r5.g(r6)
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.j.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }
}
