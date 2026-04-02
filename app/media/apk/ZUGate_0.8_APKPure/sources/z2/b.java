package z2;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import h0.z0;
import java.util.WeakHashMap;
import q0.d;
import r3.h;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final View f5811b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5812c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f5813d;

    public b(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z4) {
        this.f5813d = swipeDismissBehavior;
        this.f5811b = view;
        this.f5812c = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar;
        SwipeDismissBehavior swipeDismissBehavior = this.f5813d;
        d dVar = swipeDismissBehavior.f2012a;
        View view = this.f5811b;
        if (dVar != null && dVar.g()) {
            WeakHashMap weakHashMap = z0.f3233a;
            view.postOnAnimation(this);
        } else if (!this.f5812c || (hVar = swipeDismissBehavior.f2013b) == null) {
        } else {
            hVar.b(view);
        }
    }
}
