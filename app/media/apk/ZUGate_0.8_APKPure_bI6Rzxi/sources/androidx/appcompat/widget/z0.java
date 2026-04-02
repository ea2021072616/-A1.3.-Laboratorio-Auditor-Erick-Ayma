package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class z0 extends y.n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f600a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f601b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WeakReference f602c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e1 f603d;

    public z0(e1 e1Var, int i5, int i6, WeakReference weakReference) {
        this.f603d = e1Var;
        this.f600a = i5;
        this.f601b = i6;
        this.f602c = weakReference;
    }

    @Override // y.n
    public final void onFontRetrievalFailed(int i5) {
    }

    @Override // y.n
    public final void onFontRetrieved(Typeface typeface) {
        int i5;
        if (Build.VERSION.SDK_INT >= 28 && (i5 = this.f600a) != -1) {
            typeface = d1.a(typeface, i5, (this.f601b & 2) != 0);
        }
        e1 e1Var = this.f603d;
        if (e1Var.f333m) {
            e1Var.f332l = typeface;
            TextView textView = (TextView) this.f602c.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new a1(textView, typeface, e1Var.f330j));
                } else {
                    textView.setTypeface(typeface, e1Var.f330j);
                }
            }
        }
    }
}
