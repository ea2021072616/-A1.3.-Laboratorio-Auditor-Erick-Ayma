package androidx.appcompat.widget;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.widget.TextView;
/* loaded from: classes.dex */
public abstract class j1 {
    public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i5, int i6, TextView textView, TextPaint textPaint, n1 n1Var) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i5);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
        if (i6 == -1) {
            i6 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i6);
        try {
            n1Var.a(obtain, textView);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }
}
