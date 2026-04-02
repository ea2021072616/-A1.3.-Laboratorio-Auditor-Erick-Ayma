package f0;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.Objects;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f2733a;

    /* renamed from: b  reason: collision with root package name */
    public final TextDirectionHeuristic f2734b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2735c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2736d;

    public d(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i5, int i6) {
        PrecomputedText.Params.Builder breakStrategy;
        PrecomputedText.Params.Builder hyphenationFrequency;
        PrecomputedText.Params.Builder textDirection;
        if (Build.VERSION.SDK_INT >= 29) {
            breakStrategy = androidx.emoji2.text.b.h(textPaint).setBreakStrategy(i5);
            hyphenationFrequency = breakStrategy.setHyphenationFrequency(i6);
            textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
            textDirection.build();
        }
        this.f2733a = textPaint;
        this.f2734b = textDirectionHeuristic;
        this.f2735c = i5;
        this.f2736d = i6;
    }

    public final boolean equals(Object obj) {
        boolean z4;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f2735c == dVar.f2735c && this.f2736d == dVar.f2736d) {
            TextPaint textPaint = this.f2733a;
            float textSize = textPaint.getTextSize();
            TextPaint textPaint2 = dVar.f2733a;
            if (textSize == textPaint2.getTextSize() && textPaint.getTextScaleX() == textPaint2.getTextScaleX() && textPaint.getTextSkewX() == textPaint2.getTextSkewX() && textPaint.getLetterSpacing() == textPaint2.getLetterSpacing() && TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) && textPaint.getFlags() == textPaint2.getFlags() && textPaint.getTextLocales().equals(textPaint2.getTextLocales()) && (textPaint.getTypeface() != null ? textPaint.getTypeface().equals(textPaint2.getTypeface()) : textPaint2.getTypeface() == null)) {
                z4 = true;
                return !z4 && this.f2734b == dVar.f2734b;
            }
        }
        z4 = false;
        if (z4) {
            return false;
        }
    }

    public final int hashCode() {
        TextPaint textPaint = this.f2733a;
        return Objects.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.f2734b, Integer.valueOf(this.f2735c), Integer.valueOf(this.f2736d));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f2733a;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        sb.append(", textLocale=" + textPaint.getTextLocales());
        sb.append(", typeface=" + textPaint.getTypeface());
        sb.append(", variationSettings=" + textPaint.getFontVariationSettings());
        sb.append(", textDir=" + this.f2734b);
        sb.append(", breakStrategy=" + this.f2735c);
        sb.append(", hyphenationFrequency=" + this.f2736d);
        sb.append("}");
        return sb.toString();
    }

    public d(PrecomputedText.Params params) {
        TextPaint textPaint;
        TextDirectionHeuristic textDirection;
        int breakStrategy;
        int hyphenationFrequency;
        textPaint = params.getTextPaint();
        this.f2733a = textPaint;
        textDirection = params.getTextDirection();
        this.f2734b = textDirection;
        breakStrategy = params.getBreakStrategy();
        this.f2735c = breakStrategy;
        hyphenationFrequency = params.getHyphenationFrequency();
        this.f2736d = hyphenationFrequency;
    }
}
