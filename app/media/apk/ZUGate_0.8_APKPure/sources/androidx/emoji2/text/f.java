package androidx.emoji2.text;

import android.text.TextPaint;
/* loaded from: classes.dex */
public final class f implements j {

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal f758b = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f759a;

    public f() {
        TextPaint textPaint = new TextPaint();
        this.f759a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
