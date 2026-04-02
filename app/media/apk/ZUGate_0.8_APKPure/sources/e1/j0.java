package e1;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class j0 extends h0 {

    /* renamed from: s  reason: collision with root package name */
    public static boolean f2617s = true;

    @Override // e4.e
    public void T(View view, int i5) {
        if (Build.VERSION.SDK_INT == 28) {
            super.T(view, i5);
        } else if (f2617s) {
            try {
                i0.a(view, i5);
            } catch (NoSuchMethodError unused) {
                f2617s = false;
            }
        }
    }
}
