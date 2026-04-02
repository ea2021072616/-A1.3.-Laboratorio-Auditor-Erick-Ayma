package s0;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.m;
/* loaded from: classes.dex */
public final class f implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f4814a;

    /* renamed from: b  reason: collision with root package name */
    public e f4815b;

    public f(TextView textView) {
        this.f4814a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i5, int i6, Spanned spanned, int i7, int i8) {
        TextView textView = this.f4814a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int b5 = m.a().b();
        if (b5 != 0) {
            boolean z4 = true;
            if (b5 == 1) {
                if (i8 == 0 && i7 == 0 && spanned.length() == 0 && charSequence == textView.getText()) {
                    z4 = false;
                }
                if (!z4 || charSequence == null) {
                    return charSequence;
                }
                if (i5 != 0 || i6 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i5, i6);
                }
                return m.a().f(0, charSequence.length(), charSequence);
            } else if (b5 != 3) {
                return charSequence;
            }
        }
        m a5 = m.a();
        if (this.f4815b == null) {
            this.f4815b = new e(textView, this);
        }
        a5.g(this.f4815b);
        return charSequence;
    }
}
