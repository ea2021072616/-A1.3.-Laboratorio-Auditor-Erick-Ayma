package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class k3 implements h.a0 {

    /* renamed from: g  reason: collision with root package name */
    public h.o f399g;

    /* renamed from: h  reason: collision with root package name */
    public h.q f400h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Toolbar f401i;

    public k3(Toolbar toolbar) {
        this.f401i = toolbar;
    }

    @Override // h.a0
    public final void b(h.o oVar, boolean z4) {
    }

    @Override // h.a0
    public final void d(Context context, h.o oVar) {
        h.q qVar;
        h.o oVar2 = this.f399g;
        if (oVar2 != null && (qVar = this.f400h) != null) {
            oVar2.d(qVar);
        }
        this.f399g = oVar;
    }

    @Override // h.a0
    public final boolean e() {
        return false;
    }

    @Override // h.a0
    public final boolean g(h.q qVar) {
        Toolbar toolbar = this.f401i;
        toolbar.c();
        ViewParent parent = toolbar.f256n.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f256n);
            }
            toolbar.addView(toolbar.f256n);
        }
        View actionView = qVar.getActionView();
        toolbar.o = actionView;
        this.f400h = qVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.o);
            }
            l3 l3Var = new l3();
            l3Var.f2278a = (toolbar.f261t & 112) | 8388611;
            l3Var.f410b = 2;
            toolbar.o.setLayoutParams(l3Var);
            toolbar.addView(toolbar.o);
        }
        int childCount = toolbar.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            View childAt = toolbar.getChildAt(childCount);
            if (((l3) childAt.getLayoutParams()).f410b != 2 && childAt != toolbar.f249g) {
                toolbar.removeViewAt(childCount);
                toolbar.K.add(childAt);
            }
        }
        toolbar.requestLayout();
        qVar.I = true;
        qVar.f3059t.p(false);
        View view = toolbar.o;
        if (view instanceof g.c) {
            ((h.s) ((g.c) view)).f3069g.onActionViewExpanded();
        }
        toolbar.s();
        return true;
    }

    @Override // h.a0
    public final void h() {
        if (this.f400h != null) {
            h.o oVar = this.f399g;
            boolean z4 = false;
            if (oVar != null) {
                int size = oVar.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    } else if (this.f399g.getItem(i5) == this.f400h) {
                        z4 = true;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            if (z4) {
                return;
            }
            i(this.f400h);
        }
    }

    @Override // h.a0
    public final boolean i(h.q qVar) {
        Toolbar toolbar = this.f401i;
        View view = toolbar.o;
        if (view instanceof g.c) {
            ((h.s) ((g.c) view)).f3069g.onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.o);
        toolbar.removeView(toolbar.f256n);
        toolbar.o = null;
        ArrayList arrayList = toolbar.K;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                arrayList.clear();
                this.f400h = null;
                toolbar.requestLayout();
                qVar.I = false;
                qVar.f3059t.p(false);
                toolbar.s();
                return true;
            }
            toolbar.addView((View) arrayList.get(size));
        }
    }

    @Override // h.a0
    public final boolean k(h.g0 g0Var) {
        return false;
    }
}
