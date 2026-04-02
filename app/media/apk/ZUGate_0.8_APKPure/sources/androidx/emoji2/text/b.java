package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextPaint;
/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ PrecomputedText.Params.Builder h(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* bridge */ /* synthetic */ boolean s(Spannable spannable) {
        return spannable instanceof PrecomputedText;
    }
}
