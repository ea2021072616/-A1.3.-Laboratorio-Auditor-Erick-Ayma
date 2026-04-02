package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final u f111a = new u();

    public final OnBackInvokedCallback a(i4.a aVar) {
        e4.e.f(aVar, "onBackInvoked");
        return new t(0, aVar);
    }

    public final void b(Object obj, int i5, Object obj2) {
        e4.e.f(obj, "dispatcher");
        e4.e.f(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i5, (OnBackInvokedCallback) obj2);
    }

    public final void c(Object obj, Object obj2) {
        e4.e.f(obj, "dispatcher");
        e4.e.f(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
