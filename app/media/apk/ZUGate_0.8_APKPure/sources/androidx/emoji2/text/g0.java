package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;
/* loaded from: classes.dex */
public final class g0 implements Spannable {

    /* renamed from: b  reason: collision with root package name */
    public boolean f761b = false;

    /* renamed from: c  reason: collision with root package name */
    public Spannable f762c;

    public g0(Spannable spannable) {
        this.f762c = spannable;
    }

    public final void a() {
        Spannable spannable = this.f762c;
        if (!this.f761b) {
            if ((Build.VERSION.SDK_INT < 28 ? new p3.e(14) : new f0()).q(spannable)) {
                this.f762c = new SpannableString(spannable);
            }
        }
        this.f761b = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i5) {
        return this.f762c.charAt(i5);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f762c.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f762c.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f762c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f762c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f762c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i5, int i6, Class cls) {
        return this.f762c.getSpans(i5, i6, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f762c.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i5, int i6, Class cls) {
        return this.f762c.nextSpanTransition(i5, i6, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f762c.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i5, int i6, int i7) {
        a();
        this.f762c.setSpan(obj, i5, i6, i7);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i5, int i6) {
        return this.f762c.subSequence(i5, i6);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f762c.toString();
    }

    public g0(CharSequence charSequence) {
        this.f762c = new SpannableString(charSequence);
    }
}
