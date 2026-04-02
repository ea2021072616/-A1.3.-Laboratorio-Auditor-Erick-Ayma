package androidx.emoji2.text;

import android.text.TextUtils;
/* loaded from: classes.dex */
public final class u implements t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f787a;

    /* renamed from: b  reason: collision with root package name */
    public String f788b;

    @Override // androidx.emoji2.text.t
    public final Object a() {
        return this;
    }

    @Override // androidx.emoji2.text.t
    public final boolean b(CharSequence charSequence, int i5, int i6, d0 d0Var) {
        if (TextUtils.equals(charSequence.subSequence(i5, i6), this.f788b)) {
            d0Var.f752c = (d0Var.f752c & 3) | 4;
            return false;
        }
        return true;
    }

    public final String toString() {
        switch (this.f787a) {
            case 5:
                return "<" + this.f788b + '>';
            default:
                return super.toString();
        }
    }

    public /* synthetic */ u(String str, int i5) {
        this.f787a = i5;
        this.f788b = str;
    }
}
