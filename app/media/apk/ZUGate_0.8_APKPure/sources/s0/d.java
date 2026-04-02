package s0;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import androidx.emoji2.text.m;
/* loaded from: classes.dex */
public final class d extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f4810a;

    /* renamed from: b  reason: collision with root package name */
    public final p3.e f4811b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        p3.e eVar = new p3.e(17);
        this.f4810a = editText;
        this.f4811b = eVar;
        if (m.f769k != null) {
            m a5 = m.a();
            if (!(a5.b() == 1) || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            a5.f774e.E(editorInfo);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i5, int i6) {
        Editable editableText = this.f4810a.getEditableText();
        this.f4811b.getClass();
        return p3.e.l(this, editableText, i5, i6, false) || super.deleteSurroundingText(i5, i6);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i5, int i6) {
        Editable editableText = this.f4810a.getEditableText();
        this.f4811b.getClass();
        return p3.e.l(this, editableText, i5, i6, true) || super.deleteSurroundingTextInCodePoints(i5, i6);
    }
}
