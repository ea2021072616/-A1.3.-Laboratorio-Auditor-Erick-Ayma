package h0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class n0 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public h2 f3175a = null;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f3176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ x f3177c;

    public n0(View view, x xVar) {
        this.f3176b = view;
        this.f3177c = xVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        h2 i5 = h2.i(view, windowInsets);
        int i6 = Build.VERSION.SDK_INT;
        x xVar = this.f3177c;
        if (i6 < 30) {
            o0.a(windowInsets, this.f3176b);
            if (i5.equals(this.f3175a)) {
                return xVar.a(view, i5).h();
            }
        }
        this.f3175a = i5;
        h2 a5 = xVar.a(view, i5);
        if (i6 >= 30) {
            return a5.h();
        }
        WeakHashMap weakHashMap = z0.f3233a;
        m0.c(view);
        return a5.h();
    }
}
