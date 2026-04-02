package j3;

import android.text.TextPaint;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: c  reason: collision with root package name */
    public float f3504c;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference f3506e;

    /* renamed from: f  reason: collision with root package name */
    public m3.d f3507f;

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f3502a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    public final f3.b f3503b = new f3.b(1, this);

    /* renamed from: d  reason: collision with root package name */
    public boolean f3505d = true;

    public i(h hVar) {
        this.f3506e = new WeakReference(null);
        this.f3506e = new WeakReference(hVar);
    }

    public final float a(String str) {
        if (this.f3505d) {
            TextPaint textPaint = this.f3502a;
            this.f3504c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
            if (str != null) {
                Math.abs(textPaint.getFontMetrics().ascent);
            }
            this.f3505d = false;
            return this.f3504c;
        }
        return this.f3504c;
    }
}
