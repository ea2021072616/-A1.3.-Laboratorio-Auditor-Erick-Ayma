package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import n2.b;
import r3.i;
import r3.k;
import r3.q;
import r3.r;
/* loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* renamed from: j  reason: collision with root package name */
    public final b f2194j = new b((SwipeDismissBehavior) this);

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, u.a
    public final boolean j(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        b bVar = this.f2194j;
        bVar.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                r b5 = r.b();
                i iVar = (i) bVar.f4085g;
                synchronized (b5.f4547a) {
                    if (b5.c(iVar)) {
                        q qVar = b5.f4549c;
                        if (qVar.f4545c) {
                            qVar.f4545c = false;
                            b5.d(qVar);
                        }
                    }
                }
            }
        } else if (coordinatorLayout.o(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            r b6 = r.b();
            i iVar2 = (i) bVar.f4085g;
            synchronized (b6.f4547a) {
                if (b6.c(iVar2)) {
                    q qVar2 = b6.f4549c;
                    if (!qVar2.f4545c) {
                        qVar2.f4545c = true;
                        b6.f4548b.removeCallbacksAndMessages(qVar2);
                    }
                }
            }
        }
        return super.j(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean v(View view) {
        this.f2194j.getClass();
        return view instanceof k;
    }
}
