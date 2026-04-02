package e0;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.m;
import androidx.fragment.app.s1;
import androidx.fragment.app.w0;
import androidx.viewpager.widget.l;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import d.u0;
import java.util.List;
import java.util.concurrent.Callable;
import k2.b0;
import k2.c0;
import y.n;
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2560b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f2561c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f2562d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f2563e;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i5) {
        this.f2560b = i5;
        this.f2563e = obj;
        this.f2561c = obj2;
        this.f2562d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f2560b;
        Object obj = null;
        Object obj2 = this.f2563e;
        Object obj3 = this.f2562d;
        Object obj4 = this.f2561c;
        switch (i5) {
            case 0:
                Typeface typeface = (Typeface) obj3;
                n nVar = (n) ((u0) obj4).f2463h;
                if (nVar != null) {
                    nVar.onFontRetrieved(typeface);
                    return;
                }
                return;
            case 1:
                ((g0.a) obj4).a(obj3);
                return;
            case l.SCROLL_STATE_SETTLING /* 2 */:
                try {
                    obj = ((Callable) obj4).call();
                } catch (Exception unused) {
                }
                ((Handler) obj2).post(new a(this, (g0.a) obj3, obj, 1));
                return;
            case 3:
                List list = (List) obj4;
                s1 s1Var = (s1) obj3;
                if (list.contains(s1Var)) {
                    list.remove(s1Var);
                    ((androidx.fragment.app.n) obj2).getClass();
                    androidx.fragment.app.n.j(s1Var);
                    return;
                }
                return;
            case 4:
                ((m) obj4).a();
                if (w0.I(2)) {
                    Log.v("FragmentManager", "Transition for operation " + ((s1) obj3) + "has completed");
                    return;
                }
                return;
            case 5:
                b0 b0Var = (b0) obj2;
                b0Var.getClass();
                b0Var.getClass();
                b0Var.getClass();
                b0Var.getClass();
                b0Var.getClass();
                return;
            case 6:
                c0 c0Var = (c0) obj2;
                if (c0Var.f3572h > 0) {
                    LifecycleCallback lifecycleCallback = (LifecycleCallback) obj4;
                    Bundle bundle = c0Var.f3573i;
                    lifecycleCallback.c(bundle != null ? bundle.getBundle((String) obj3) : null);
                }
                if (c0Var.f3572h >= 2) {
                    ((LifecycleCallback) obj4).f();
                }
                if (c0Var.f3572h >= 3) {
                    ((LifecycleCallback) obj4).d();
                }
                if (c0Var.f3572h >= 4) {
                    ((LifecycleCallback) obj4).g();
                }
                if (c0Var.f3572h >= 5) {
                    ((LifecycleCallback) obj4).getClass();
                    return;
                }
                return;
            case 7:
                if (((View) obj3) != null) {
                    ((y2.b) obj2).getClass();
                    return;
                }
                return;
            default:
                ((x4.b) obj4).a((x4.a) obj3);
                return;
        }
    }
}
