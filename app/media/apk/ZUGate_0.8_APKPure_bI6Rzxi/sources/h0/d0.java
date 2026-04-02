package h0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
public final class d0 extends b0 {

    /* renamed from: l  reason: collision with root package name */
    public final View f3110l;

    /* renamed from: m  reason: collision with root package name */
    public final WindowInsetsController f3111m;

    public d0(View view) {
        super(view);
        this.f3110l = view;
    }

    @Override // h0.b0, p3.e
    public final void x() {
        int ime;
        View view = this.f3110l;
        if (view != null && Build.VERSION.SDK_INT < 33) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
        }
        WindowInsetsController windowInsetsController = this.f3111m;
        if (windowInsetsController == null) {
            windowInsetsController = view != null ? view.getWindowInsetsController() : null;
        }
        if (windowInsetsController == null) {
            super.x();
            return;
        }
        ime = WindowInsets.Type.ime();
        windowInsetsController.show(ime);
    }

    public d0(WindowInsetsController windowInsetsController) {
        super(null);
        this.f3111m = windowInsetsController;
    }
}
