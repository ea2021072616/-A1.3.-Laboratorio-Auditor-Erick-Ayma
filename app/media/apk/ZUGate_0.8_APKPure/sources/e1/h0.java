package e1;

import android.view.View;
/* loaded from: classes.dex */
public abstract class h0 extends f0 {

    /* renamed from: r  reason: collision with root package name */
    public static boolean f2607r = true;

    public void m0(View view, int i5, int i6, int i7, int i8) {
        if (f2607r) {
            try {
                g0.a(view, i5, i6, i7, i8);
            } catch (NoSuchMethodError unused) {
                f2607r = false;
            }
        }
    }
}
