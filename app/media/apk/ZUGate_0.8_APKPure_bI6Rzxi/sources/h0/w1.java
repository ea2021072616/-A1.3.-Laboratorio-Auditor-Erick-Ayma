package h0;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class w1 extends z1 {

    /* renamed from: e  reason: collision with root package name */
    public static Field f3222e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f3223f = false;

    /* renamed from: g  reason: collision with root package name */
    public static Constructor f3224g = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f3225h = false;

    /* renamed from: c  reason: collision with root package name */
    public WindowInsets f3226c;

    /* renamed from: d  reason: collision with root package name */
    public z.c f3227d;

    public w1() {
        this.f3226c = i();
    }

    private static WindowInsets i() {
        if (!f3223f) {
            try {
                f3222e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e5);
            }
            f3223f = true;
        }
        Field field = f3222e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e6) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e6);
            }
        }
        if (!f3225h) {
            try {
                f3224g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e7) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e7);
            }
            f3225h = true;
        }
        Constructor constructor = f3224g;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e8) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e8);
            }
        }
        return null;
    }

    @Override // h0.z1
    public h2 b() {
        a();
        h2 i5 = h2.i(null, this.f3226c);
        z.c[] cVarArr = this.f3240b;
        f2 f2Var = i5.f3144a;
        f2Var.o(cVarArr);
        f2Var.q(this.f3227d);
        return i5;
    }

    @Override // h0.z1
    public void e(z.c cVar) {
        this.f3227d = cVar;
    }

    @Override // h0.z1
    public void g(z.c cVar) {
        WindowInsets windowInsets = this.f3226c;
        if (windowInsets != null) {
            this.f3226c = windowInsets.replaceSystemWindowInsets(cVar.f5749a, cVar.f5750b, cVar.f5751c, cVar.f5752d);
        }
    }

    public w1(h2 h2Var) {
        super(h2Var);
        this.f3226c = h2Var.h();
    }
}
