package e1;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.appcompat.widget.b3;
/* loaded from: classes.dex */
public abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final j0 f2590a;

    /* renamed from: b  reason: collision with root package name */
    public static final b3 f2591b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f2590a = new k0();
        } else {
            f2590a = new j0();
        }
        f2591b = new b3(Float.class, "translationAlpha", 6);
        new b3(Rect.class, "clipBounds", 7);
    }

    public static void a(View view, int i5, int i6, int i7, int i8) {
        f2590a.m0(view, i5, i6, i7, i8);
    }

    public static void b(View view, int i5) {
        f2590a.T(view, i5);
    }
}
