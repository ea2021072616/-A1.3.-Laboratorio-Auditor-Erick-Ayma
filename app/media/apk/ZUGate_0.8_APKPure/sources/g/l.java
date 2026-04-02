package g;

import android.view.View;
import android.view.animation.Interpolator;
import h0.k1;
import h0.l1;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f2922c;

    /* renamed from: d  reason: collision with root package name */
    public l1 f2923d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2924e;

    /* renamed from: b  reason: collision with root package name */
    public long f2921b = -1;

    /* renamed from: f  reason: collision with root package name */
    public final k f2925f = new k(this);

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2920a = new ArrayList();

    public final void a() {
        if (this.f2924e) {
            Iterator it = this.f2920a.iterator();
            while (it.hasNext()) {
                ((k1) it.next()).b();
            }
            this.f2924e = false;
        }
    }

    public final void b() {
        View view;
        if (this.f2924e) {
            return;
        }
        Iterator it = this.f2920a.iterator();
        while (it.hasNext()) {
            k1 k1Var = (k1) it.next();
            long j5 = this.f2921b;
            if (j5 >= 0) {
                k1Var.c(j5);
            }
            Interpolator interpolator = this.f2922c;
            if (interpolator != null && (view = (View) k1Var.f3165a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f2923d != null) {
                k1Var.d(this.f2925f);
            }
            View view2 = (View) k1Var.f3165a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f2924e = true;
    }
}
