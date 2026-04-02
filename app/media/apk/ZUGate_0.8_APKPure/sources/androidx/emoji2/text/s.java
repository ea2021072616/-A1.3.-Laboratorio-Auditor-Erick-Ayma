package androidx.emoji2.text;

import android.text.Spannable;
import android.text.SpannableString;
/* loaded from: classes.dex */
public final class s implements t {

    /* renamed from: a  reason: collision with root package name */
    public g0 f785a;

    /* renamed from: b  reason: collision with root package name */
    public final p3.e f786b;

    public s(g0 g0Var, p3.e eVar) {
        this.f785a = g0Var;
        this.f786b = eVar;
    }

    @Override // androidx.emoji2.text.t
    public final Object a() {
        return this.f785a;
    }

    @Override // androidx.emoji2.text.t
    public final boolean b(CharSequence charSequence, int i5, int i6, d0 d0Var) {
        if ((d0Var.f752c & 4) > 0) {
            return true;
        }
        if (this.f785a == null) {
            this.f785a = new g0(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        this.f786b.getClass();
        this.f785a.setSpan(new e0(d0Var), i5, i6, 33);
        return true;
    }
}
