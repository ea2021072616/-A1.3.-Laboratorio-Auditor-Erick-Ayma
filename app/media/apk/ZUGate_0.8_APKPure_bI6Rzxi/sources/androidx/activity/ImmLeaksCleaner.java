package androidx.activity;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.r {

    /* renamed from: a  reason: collision with root package name */
    public static int f39a;

    @Override // androidx.lifecycle.r
    public final void b(androidx.lifecycle.t tVar, androidx.lifecycle.m mVar) {
        if (mVar != androidx.lifecycle.m.ON_DESTROY) {
            return;
        }
        if (f39a == 0) {
            try {
                f39a = 2;
                InputMethodManager.class.getDeclaredField("mServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mNextServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mH").setAccessible(true);
                f39a = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f39a == 1) {
            throw null;
        }
    }
}
