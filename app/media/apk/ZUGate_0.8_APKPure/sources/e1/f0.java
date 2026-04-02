package e1;

import android.graphics.Matrix;
import android.view.View;
/* loaded from: classes.dex */
public abstract class f0 extends e4.e {

    /* renamed from: p  reason: collision with root package name */
    public static boolean f2601p = true;

    /* renamed from: q  reason: collision with root package name */
    public static boolean f2602q = true;

    public void k0(View view, Matrix matrix) {
        if (f2601p) {
            try {
                e0.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f2601p = false;
            }
        }
    }

    public void l0(View view, Matrix matrix) {
        if (f2602q) {
            try {
                e0.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f2602q = false;
            }
        }
    }
}
