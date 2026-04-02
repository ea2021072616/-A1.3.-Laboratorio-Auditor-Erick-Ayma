package h;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.widget.b2;
import androidx.appcompat.widget.q2;
import androidx.appcompat.widget.t2;
import com.github.appintro.R;
import d.u0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class i extends w implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public int A;
    public boolean C;
    public z D;
    public ViewTreeObserver E;
    public PopupWindow.OnDismissListener F;
    public boolean G;

    /* renamed from: h  reason: collision with root package name */
    public final Context f2993h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2994i;

    /* renamed from: j  reason: collision with root package name */
    public final int f2995j;

    /* renamed from: k  reason: collision with root package name */
    public final int f2996k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f2997l;

    /* renamed from: m  reason: collision with root package name */
    public final Handler f2998m;

    /* renamed from: u  reason: collision with root package name */
    public View f3005u;

    /* renamed from: v  reason: collision with root package name */
    public View f3006v;

    /* renamed from: w  reason: collision with root package name */
    public int f3007w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f3008x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f3009y;

    /* renamed from: z  reason: collision with root package name */
    public int f3010z;

    /* renamed from: n  reason: collision with root package name */
    public final ArrayList f2999n = new ArrayList();
    public final ArrayList o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public final e f3000p = new e(0, this);

    /* renamed from: q  reason: collision with root package name */
    public final f f3001q = new f(0, this);

    /* renamed from: r  reason: collision with root package name */
    public final u0 f3002r = new u0(2, this);

    /* renamed from: s  reason: collision with root package name */
    public int f3003s = 0;

    /* renamed from: t  reason: collision with root package name */
    public int f3004t = 0;
    public boolean B = false;

    public i(Context context, View view, int i5, int i6, boolean z4) {
        this.f2993h = context;
        this.f3005u = view;
        this.f2995j = i5;
        this.f2996k = i6;
        this.f2997l = z4;
        this.f3007w = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f2994i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f2998m = new Handler();
    }

    @Override // h.e0
    public final boolean a() {
        ArrayList arrayList = this.o;
        return arrayList.size() > 0 && ((h) arrayList.get(0)).f2990a.a();
    }

    @Override // h.a0
    public final void b(o oVar, boolean z4) {
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i5 = -1;
                break;
            } else if (oVar == ((h) arrayList.get(i5)).f2991b) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 < 0) {
            return;
        }
        int i6 = i5 + 1;
        if (i6 < arrayList.size()) {
            ((h) arrayList.get(i6)).f2991b.c(false);
        }
        h hVar = (h) arrayList.remove(i5);
        hVar.f2991b.r(this);
        boolean z5 = this.G;
        t2 t2Var = hVar.f2990a;
        if (z5) {
            q2.b(t2Var.F, null);
            t2Var.F.setAnimationStyle(0);
        }
        t2Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f3007w = ((h) arrayList.get(size2 - 1)).f2992c;
        } else {
            this.f3007w = this.f3005u.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z4) {
                ((h) arrayList.get(0)).f2991b.c(false);
                return;
            }
            return;
        }
        dismiss();
        z zVar = this.D;
        if (zVar != null) {
            zVar.b(oVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.E;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.E.removeGlobalOnLayoutListener(this.f3000p);
            }
            this.E = null;
        }
        this.f3006v.removeOnAttachStateChangeListener(this.f3001q);
        this.F.onDismiss();
    }

    @Override // h.a0
    public final void c(z zVar) {
        this.D = zVar;
    }

    @Override // h.e0
    public final void dismiss() {
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        if (size <= 0) {
            return;
        }
        h[] hVarArr = (h[]) arrayList.toArray(new h[size]);
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            h hVar = hVarArr[size];
            if (hVar.f2990a.a()) {
                hVar.f2990a.dismiss();
            }
        }
    }

    @Override // h.a0
    public final boolean e() {
        return false;
    }

    @Override // h.e0
    public final void f() {
        if (a()) {
            return;
        }
        ArrayList arrayList = this.f2999n;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            v((o) it.next());
        }
        arrayList.clear();
        View view = this.f3005u;
        this.f3006v = view;
        if (view != null) {
            boolean z4 = this.E == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.E = viewTreeObserver;
            if (z4) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f3000p);
            }
            this.f3006v.addOnAttachStateChangeListener(this.f3001q);
        }
    }

    @Override // h.a0
    public final void h() {
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((h) it.next()).f2990a.f452i.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((l) adapter).notifyDataSetChanged();
        }
    }

    @Override // h.e0
    public final b2 j() {
        ArrayList arrayList = this.o;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((h) arrayList.get(arrayList.size() - 1)).f2990a.f452i;
    }

    @Override // h.a0
    public final boolean k(g0 g0Var) {
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (g0Var == hVar.f2991b) {
                hVar.f2990a.f452i.requestFocus();
                return true;
            }
        }
        if (g0Var.hasVisibleItems()) {
            l(g0Var);
            z zVar = this.D;
            if (zVar != null) {
                zVar.h(g0Var);
            }
            return true;
        }
        return false;
    }

    @Override // h.w
    public final void l(o oVar) {
        oVar.b(this, this.f2993h);
        if (a()) {
            v(oVar);
        } else {
            this.f2999n.add(oVar);
        }
    }

    @Override // h.w
    public final void n(View view) {
        if (this.f3005u != view) {
            this.f3005u = view;
            this.f3004t = Gravity.getAbsoluteGravity(this.f3003s, view.getLayoutDirection());
        }
    }

    @Override // h.w
    public final void o(boolean z4) {
        this.B = z4;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        h hVar;
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                hVar = null;
                break;
            }
            hVar = (h) arrayList.get(i5);
            if (!hVar.f2990a.a()) {
                break;
            }
            i5++;
        }
        if (hVar != null) {
            hVar.f2991b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i5, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i5 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // h.w
    public final void p(int i5) {
        if (this.f3003s != i5) {
            this.f3003s = i5;
            this.f3004t = Gravity.getAbsoluteGravity(i5, this.f3005u.getLayoutDirection());
        }
    }

    @Override // h.w
    public final void q(int i5) {
        this.f3008x = true;
        this.f3010z = i5;
    }

    @Override // h.w
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.F = onDismissListener;
    }

    @Override // h.w
    public final void s(boolean z4) {
        this.C = z4;
    }

    @Override // h.w
    public final void t(int i5) {
        this.f3009y = true;
        this.A = i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(h.o r19) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.i.v(h.o):void");
    }
}
