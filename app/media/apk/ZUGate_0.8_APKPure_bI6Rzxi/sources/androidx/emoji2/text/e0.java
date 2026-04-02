package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ReplacementSpan;
/* loaded from: classes.dex */
public final class e0 extends ReplacementSpan {

    /* renamed from: b  reason: collision with root package name */
    public final d0 f754b;

    /* renamed from: e  reason: collision with root package name */
    public TextPaint f757e;

    /* renamed from: a  reason: collision with root package name */
    public final Paint.FontMetricsInt f753a = new Paint.FontMetricsInt();

    /* renamed from: c  reason: collision with root package name */
    public short f755c = -1;

    /* renamed from: d  reason: collision with root package name */
    public float f756d = 1.0f;

    public e0(d0 d0Var) {
        if (d0Var == null) {
            throw new NullPointerException("rasterizer cannot be null");
        }
        this.f754b = d0Var;
    }

    @Override // android.text.style.ReplacementSpan
    /* renamed from: a */
    public final int getSize(Paint paint, CharSequence charSequence, int i5, int i6, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f753a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        d0 d0Var = this.f754b;
        r0.a c5 = d0Var.c();
        int a5 = c5.a(14);
        this.f756d = abs / (a5 != 0 ? c5.f4467b.getShort(a5 + c5.f4466a) : (short) 0);
        r0.a c6 = d0Var.c();
        int a6 = c6.a(14);
        if (a6 != 0) {
            c6.f4467b.getShort(a6 + c6.f4466a);
        }
        r0.a c7 = d0Var.c();
        int a7 = c7.a(12);
        short s5 = (short) ((a7 != 0 ? c7.f4467b.getShort(a7 + c7.f4466a) : (short) 0) * this.f756d);
        this.f755c = s5;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s5;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i5, int i6, float f5, int i7, int i8, int i9, Paint paint) {
        TextPaint textPaint = paint;
        TextPaint textPaint2 = null;
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i5, i6, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                    TextPaint textPaint3 = this.f757e;
                    if (textPaint3 == null) {
                        textPaint3 = new TextPaint();
                        this.f757e = textPaint3;
                    }
                    textPaint2 = textPaint3;
                    textPaint2.set(textPaint);
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        characterStyle.updateDrawState(textPaint2);
                    }
                }
            }
            if (textPaint instanceof TextPaint) {
                textPaint2 = (TextPaint) textPaint;
            }
        } else if (textPaint instanceof TextPaint) {
            textPaint2 = (TextPaint) textPaint;
        }
        if (textPaint2 != null && textPaint2.bgColor != 0) {
            int color = textPaint2.getColor();
            Paint.Style style = textPaint2.getStyle();
            textPaint2.setColor(textPaint2.bgColor);
            textPaint2.setStyle(Paint.Style.FILL);
            canvas.drawRect(f5, i7, f5 + this.f755c, i9, textPaint2);
            textPaint2.setStyle(style);
            textPaint2.setColor(color);
        }
        m.a().getClass();
        float f6 = i8;
        if (textPaint2 != null) {
            textPaint = textPaint2;
        }
        d0 d0Var = this.f754b;
        g.f fVar = d0Var.f751b;
        Typeface typeface = textPaint.getTypeface();
        textPaint.setTypeface((Typeface) fVar.f2880d);
        canvas.drawText((char[]) fVar.f2878b, d0Var.f750a * 2, 2, f5, f6, textPaint);
        textPaint.setTypeface(typeface);
    }
}
