package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class c0 extends SpannableStringBuilder {

    /* renamed from: b  reason: collision with root package name */
    public final Class f747b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f748c;

    public c0(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f748c = new ArrayList();
        if (cls != null) {
            this.f747b = cls;
            return;
        }
        throw new NullPointerException("watcherClass cannot be null");
    }

    public final void a() {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f748c;
            if (i5 >= arrayList.size()) {
                return;
            }
            ((b0) arrayList.get(i5)).f746h.incrementAndGet();
            i5++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f748c;
            if (i5 >= arrayList.size()) {
                return;
            }
            ((b0) arrayList.get(i5)).onTextChanged(this, 0, length(), length());
            i5++;
        }
    }

    public final b0 c(Object obj) {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f748c;
            if (i5 >= arrayList.size()) {
                return null;
            }
            b0 b0Var = (b0) arrayList.get(i5);
            if (b0Var.f745g == obj) {
                return b0Var;
            }
            i5++;
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            return this.f747b == obj.getClass();
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i5, int i6) {
        super.delete(i5, i6);
        return this;
    }

    public final void e() {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f748c;
            if (i5 >= arrayList.size()) {
                return;
            }
            ((b0) arrayList.get(i5)).f746h.decrementAndGet();
            i5++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        b0 c5;
        if (d(obj) && (c5 = c(obj)) != null) {
            obj = c5;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        b0 c5;
        if (d(obj) && (c5 = c(obj)) != null) {
            obj = c5;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        b0 c5;
        if (d(obj) && (c5 = c(obj)) != null) {
            obj = c5;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i5, int i6, Class cls) {
        if (this.f747b == cls) {
            b0[] b0VarArr = (b0[]) super.getSpans(i5, i6, b0.class);
            Object[] objArr = (Object[]) Array.newInstance(cls, b0VarArr.length);
            for (int i7 = 0; i7 < b0VarArr.length; i7++) {
                objArr[i7] = b0VarArr[i7].f745g;
            }
            return objArr;
        }
        return super.getSpans(i5, i6, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i5, CharSequence charSequence) {
        super.insert(i5, charSequence);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0009, code lost:
        if ((r1.f747b == r4) != false) goto L10;
     */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int nextSpanTransition(int r2, int r3, java.lang.Class r4) {
        /*
            r1 = this;
            if (r4 == 0) goto Lb
            java.lang.Class r0 = r1.f747b
            if (r0 != r4) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            if (r0 == 0) goto Ld
        Lb:
            java.lang.Class<androidx.emoji2.text.b0> r4 = androidx.emoji2.text.b0.class
        Ld:
            int r2 = super.nextSpanTransition(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.c0.nextSpanTransition(int, int, java.lang.Class):int");
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        b0 b0Var;
        if (d(obj)) {
            b0Var = c(obj);
            if (b0Var != null) {
                obj = b0Var;
            }
        } else {
            b0Var = null;
        }
        super.removeSpan(obj);
        if (b0Var != null) {
            this.f748c.remove(b0Var);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i5, int i6, CharSequence charSequence) {
        replace(i5, i6, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i5, int i6, int i7) {
        if (d(obj)) {
            b0 b0Var = new b0(obj);
            this.f748c.add(b0Var);
            obj = b0Var;
        }
        super.setSpan(obj, i5, i6, i7);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i5, int i6) {
        return new c0(this.f747b, this, i5, i6);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i5, int i6) {
        super.delete(i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i5, CharSequence charSequence) {
        super.insert(i5, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i5, int i6, CharSequence charSequence, int i7, int i8) {
        replace(i5, i6, charSequence, i7, i8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i5, CharSequence charSequence, int i6, int i7) {
        super.insert(i5, charSequence, i6, i7);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence) {
        a();
        super.replace(i5, i6, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c5) {
        super.append(c5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i5, CharSequence charSequence, int i6, int i7) {
        super.insert(i5, charSequence, i6, i7);
        return this;
    }

    public c0(Class cls, CharSequence charSequence, int i5, int i6) {
        super(charSequence, i5, i6);
        this.f748c = new ArrayList();
        if (cls != null) {
            this.f747b = cls;
            return;
        }
        throw new NullPointerException("watcherClass cannot be null");
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c5) {
        super.append(c5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c5) {
        super.append(c5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence, int i7, int i8) {
        a();
        super.replace(i5, i6, charSequence, i7, i8);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i5, int i6) {
        super.append(charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i5, int i6) {
        super.append(charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i5, int i6) {
        super.append(charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i5) {
        super.append(charSequence, obj, i5);
        return this;
    }
}
