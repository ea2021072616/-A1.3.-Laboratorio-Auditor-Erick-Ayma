package j3;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f3490a;

    /* renamed from: b  reason: collision with root package name */
    public final TextPaint f3491b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3492c;

    /* renamed from: d  reason: collision with root package name */
    public int f3493d;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3500k;

    /* renamed from: e  reason: collision with root package name */
    public Layout.Alignment f3494e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f  reason: collision with root package name */
    public int f3495f = Integer.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public float f3496g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f3497h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    public int f3498i = 1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3499j = true;

    /* renamed from: l  reason: collision with root package name */
    public TextUtils.TruncateAt f3501l = null;

    public g(CharSequence charSequence, TextPaint textPaint, int i5) {
        this.f3490a = charSequence;
        this.f3491b = textPaint;
        this.f3492c = i5;
        this.f3493d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f3490a == null) {
            this.f3490a = "";
        }
        int max = Math.max(0, this.f3492c);
        CharSequence charSequence = this.f3490a;
        int i5 = this.f3495f;
        TextPaint textPaint = this.f3491b;
        if (i5 == 1) {
            charSequence = TextUtils.ellipsize(charSequence, textPaint, max, this.f3501l);
        }
        int min = Math.min(charSequence.length(), this.f3493d);
        this.f3493d = min;
        if (this.f3500k && this.f3495f == 1) {
            this.f3494e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, textPaint, max);
        obtain.setAlignment(this.f3494e);
        obtain.setIncludePad(this.f3499j);
        obtain.setTextDirection(this.f3500k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f3501l;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f3495f);
        float f5 = this.f3496g;
        if (f5 != 0.0f || this.f3497h != 1.0f) {
            obtain.setLineSpacing(f5, this.f3497h);
        }
        if (this.f3495f > 1) {
            obtain.setHyphenationFrequency(this.f3498i);
        }
        return obtain.build();
    }
}
