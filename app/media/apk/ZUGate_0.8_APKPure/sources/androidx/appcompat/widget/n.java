package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.github.appintro.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class n implements h.a0 {
    public k A;
    public j B;

    /* renamed from: g  reason: collision with root package name */
    public final Context f414g;

    /* renamed from: h  reason: collision with root package name */
    public Context f415h;

    /* renamed from: i  reason: collision with root package name */
    public h.o f416i;

    /* renamed from: j  reason: collision with root package name */
    public final LayoutInflater f417j;

    /* renamed from: k  reason: collision with root package name */
    public h.z f418k;

    /* renamed from: n  reason: collision with root package name */
    public h.c0 f421n;
    public m o;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f422p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f423q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f424r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f425s;

    /* renamed from: t  reason: collision with root package name */
    public int f426t;

    /* renamed from: u  reason: collision with root package name */
    public int f427u;

    /* renamed from: v  reason: collision with root package name */
    public int f428v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f429w;

    /* renamed from: y  reason: collision with root package name */
    public i f431y;

    /* renamed from: z  reason: collision with root package name */
    public i f432z;

    /* renamed from: l  reason: collision with root package name */
    public final int f419l = R.layout.abc_action_menu_layout;

    /* renamed from: m  reason: collision with root package name */
    public final int f420m = R.layout.abc_action_menu_item_layout;

    /* renamed from: x  reason: collision with root package name */
    public final SparseBooleanArray f430x = new SparseBooleanArray();
    public final d.u0 C = new d.u0(4, this);

    public n(Context context) {
        this.f414g = context;
        this.f417j = LayoutInflater.from(context);
    }

    public final View a(h.q qVar, View view, ViewGroup viewGroup) {
        View actionView = qVar.getActionView();
        if (actionView == null || qVar.e()) {
            h.b0 b0Var = view instanceof h.b0 ? (h.b0) view : (h.b0) this.f417j.inflate(this.f420m, viewGroup, false);
            b0Var.c(qVar);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) b0Var;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.f421n);
            if (this.B == null) {
                this.B = new j(this);
            }
            actionMenuItemView.setPopupCallback(this.B);
            actionView = (View) b0Var;
        }
        actionView.setVisibility(qVar.I ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.j(layoutParams));
        }
        return actionView;
    }

    @Override // h.a0
    public final void b(h.o oVar, boolean z4) {
        f();
        i iVar = this.f432z;
        if (iVar != null && iVar.b()) {
            iVar.f3087j.dismiss();
        }
        h.z zVar = this.f418k;
        if (zVar != null) {
            zVar.b(oVar, z4);
        }
    }

    @Override // h.a0
    public final void c(h.z zVar) {
        this.f418k = zVar;
    }

    @Override // h.a0
    public final void d(Context context, h.o oVar) {
        this.f415h = context;
        LayoutInflater.from(context);
        this.f416i = oVar;
        Resources resources = context.getResources();
        if (!this.f425s) {
            this.f424r = true;
        }
        int i5 = 2;
        this.f426t = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i6 = configuration.screenWidthDp;
        int i7 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i6 > 600 || ((i6 > 960 && i7 > 720) || (i6 > 720 && i7 > 960))) {
            i5 = 5;
        } else if (i6 >= 500 || ((i6 > 640 && i7 > 480) || (i6 > 480 && i7 > 640))) {
            i5 = 4;
        } else if (i6 >= 360) {
            i5 = 3;
        }
        this.f428v = i5;
        int i8 = this.f426t;
        if (this.f424r) {
            if (this.o == null) {
                m mVar = new m(this, this.f414g);
                this.o = mVar;
                if (this.f423q) {
                    mVar.setImageDrawable(this.f422p);
                    this.f422p = null;
                    this.f423q = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.o.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i8 -= this.o.getMeasuredWidth();
        } else {
            this.o = null;
        }
        this.f427u = i8;
        float f5 = resources.getDisplayMetrics().density;
    }

    @Override // h.a0
    public final boolean e() {
        int i5;
        ArrayList arrayList;
        int i6;
        boolean z4;
        h.o oVar = this.f416i;
        if (oVar != null) {
            arrayList = oVar.l();
            i5 = arrayList.size();
        } else {
            i5 = 0;
            arrayList = null;
        }
        int i7 = this.f428v;
        int i8 = this.f427u;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f421n;
        int i9 = 0;
        boolean z5 = false;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i6 = 2;
            z4 = true;
            if (i9 >= i5) {
                break;
            }
            h.q qVar = (h.q) arrayList.get(i9);
            int i12 = qVar.E;
            if ((i12 & 2) == 2) {
                i10++;
            } else if ((i12 & 1) == 1) {
                i11++;
            } else {
                z5 = true;
            }
            if (this.f429w && qVar.I) {
                i7 = 0;
            }
            i9++;
        }
        if (this.f424r && (z5 || i11 + i10 > i7)) {
            i7--;
        }
        int i13 = i7 - i10;
        SparseBooleanArray sparseBooleanArray = this.f430x;
        sparseBooleanArray.clear();
        int i14 = 0;
        int i15 = 0;
        while (i14 < i5) {
            h.q qVar2 = (h.q) arrayList.get(i14);
            int i16 = qVar2.E;
            boolean z6 = (i16 & 2) == i6 ? z4 : false;
            int i17 = qVar2.f3048h;
            if (z6) {
                View a5 = a(qVar2, null, viewGroup);
                a5.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = a5.getMeasuredWidth();
                i8 -= measuredWidth;
                if (i15 == 0) {
                    i15 = measuredWidth;
                }
                if (i17 != 0) {
                    sparseBooleanArray.put(i17, z4);
                }
                qVar2.g(z4);
            } else if ((i16 & 1) == z4 ? z4 : false) {
                boolean z7 = sparseBooleanArray.get(i17);
                boolean z8 = ((i13 > 0 || z7) && i8 > 0) ? z4 : false;
                if (z8) {
                    View a6 = a(qVar2, null, viewGroup);
                    a6.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = a6.getMeasuredWidth();
                    i8 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    z8 &= i8 + i15 > 0;
                }
                if (z8 && i17 != 0) {
                    sparseBooleanArray.put(i17, true);
                } else if (z7) {
                    sparseBooleanArray.put(i17, false);
                    for (int i18 = 0; i18 < i14; i18++) {
                        h.q qVar3 = (h.q) arrayList.get(i18);
                        if (qVar3.f3048h == i17) {
                            if (qVar3.f()) {
                                i13++;
                            }
                            qVar3.g(false);
                        }
                    }
                }
                if (z8) {
                    i13--;
                }
                qVar2.g(z8);
            } else {
                qVar2.g(false);
                i14++;
                i6 = 2;
                z4 = true;
            }
            i14++;
            i6 = 2;
            z4 = true;
        }
        return z4;
    }

    public final boolean f() {
        h.c0 c0Var;
        k kVar = this.A;
        if (kVar != null && (c0Var = this.f421n) != null) {
            ((View) c0Var).removeCallbacks(kVar);
            this.A = null;
            return true;
        }
        i iVar = this.f431y;
        if (iVar != null) {
            if (iVar.b()) {
                iVar.f3087j.dismiss();
            }
            return true;
        }
        return false;
    }

    @Override // h.a0
    public final /* bridge */ /* synthetic */ boolean g(h.q qVar) {
        return false;
    }

    @Override // h.a0
    public final void h() {
        int i5;
        boolean z4;
        ViewGroup viewGroup = (ViewGroup) this.f421n;
        ArrayList arrayList = null;
        boolean z5 = false;
        if (viewGroup != null) {
            h.o oVar = this.f416i;
            if (oVar != null) {
                oVar.i();
                ArrayList l5 = this.f416i.l();
                int size = l5.size();
                i5 = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    h.q qVar = (h.q) l5.get(i6);
                    if (qVar.f()) {
                        View childAt = viewGroup.getChildAt(i5);
                        h.q itemData = childAt instanceof h.b0 ? ((h.b0) childAt).getItemData() : null;
                        View a5 = a(qVar, childAt, viewGroup);
                        if (qVar != itemData) {
                            a5.setPressed(false);
                            a5.jumpDrawablesToCurrentState();
                        }
                        if (a5 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a5.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a5);
                            }
                            ((ViewGroup) this.f421n).addView(a5, i5);
                        }
                        i5++;
                    }
                }
            } else {
                i5 = 0;
            }
            while (i5 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i5) == this.o) {
                    z4 = false;
                } else {
                    viewGroup.removeViewAt(i5);
                    z4 = true;
                }
                if (!z4) {
                    i5++;
                }
            }
        }
        ((View) this.f421n).requestLayout();
        h.o oVar2 = this.f416i;
        if (oVar2 != null) {
            oVar2.i();
            ArrayList arrayList2 = oVar2.o;
            int size2 = arrayList2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                h.r rVar = ((h.q) arrayList2.get(i7)).G;
            }
        }
        h.o oVar3 = this.f416i;
        if (oVar3 != null) {
            oVar3.i();
            arrayList = oVar3.f3033p;
        }
        if (this.f424r && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z5 = !((h.q) arrayList.get(0)).I;
            } else if (size3 > 0) {
                z5 = true;
            }
        }
        if (z5) {
            if (this.o == null) {
                this.o = new m(this, this.f414g);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.o.getParent();
            if (viewGroup3 != this.f421n) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.o);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f421n;
                m mVar = this.o;
                actionMenuView.getClass();
                p pVar = new p();
                ((LinearLayout.LayoutParams) pVar).gravity = 16;
                pVar.f471a = true;
                actionMenuView.addView(mVar, pVar);
            }
        } else {
            m mVar2 = this.o;
            if (mVar2 != null) {
                ViewParent parent = mVar2.getParent();
                h.c0 c0Var = this.f421n;
                if (parent == c0Var) {
                    ((ViewGroup) c0Var).removeView(this.o);
                }
            }
        }
        ((ActionMenuView) this.f421n).setOverflowReserved(this.f424r);
    }

    @Override // h.a0
    public final /* bridge */ /* synthetic */ boolean i(h.q qVar) {
        return false;
    }

    public final boolean j() {
        i iVar = this.f431y;
        return iVar != null && iVar.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    @Override // h.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(h.g0 r9) {
        /*
            r8 = this;
            boolean r0 = r9.hasVisibleItems()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            r0 = r9
        L9:
            h.o r2 = r0.F
            h.o r3 = r8.f416i
            if (r2 == r3) goto L13
            r0 = r2
            h.g0 r0 = (h.g0) r0
            goto L9
        L13:
            h.c0 r2 = r8.f421n
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            if (r2 != 0) goto L1a
            goto L38
        L1a:
            int r3 = r2.getChildCount()
            r4 = r1
        L1f:
            if (r4 >= r3) goto L38
            android.view.View r5 = r2.getChildAt(r4)
            boolean r6 = r5 instanceof h.b0
            if (r6 == 0) goto L35
            r6 = r5
            h.b0 r6 = (h.b0) r6
            h.q r6 = r6.getItemData()
            h.q r7 = r0.G
            if (r6 != r7) goto L35
            goto L39
        L35:
            int r4 = r4 + 1
            goto L1f
        L38:
            r5 = 0
        L39:
            if (r5 != 0) goto L3c
            return r1
        L3c:
            h.q r0 = r9.G
            r0.getClass()
            int r0 = r9.size()
            r2 = r1
        L46:
            r3 = 1
            if (r2 >= r0) goto L5e
            android.view.MenuItem r4 = r9.getItem(r2)
            boolean r6 = r4.isVisible()
            if (r6 == 0) goto L5b
            android.graphics.drawable.Drawable r4 = r4.getIcon()
            if (r4 == 0) goto L5b
            r0 = r3
            goto L5f
        L5b:
            int r2 = r2 + 1
            goto L46
        L5e:
            r0 = r1
        L5f:
            androidx.appcompat.widget.i r2 = new androidx.appcompat.widget.i
            android.content.Context r4 = r8.f415h
            r2.<init>(r8, r4, r9, r5)
            r8.f432z = r2
            r2.f3085h = r0
            h.w r2 = r2.f3087j
            if (r2 == 0) goto L71
            r2.o(r0)
        L71:
            androidx.appcompat.widget.i r0 = r8.f432z
            boolean r2 = r0.b()
            if (r2 == 0) goto L7b
        L79:
            r1 = r3
            goto L84
        L7b:
            android.view.View r2 = r0.f3083f
            if (r2 != 0) goto L80
            goto L84
        L80:
            r0.d(r1, r1, r1, r1)
            goto L79
        L84:
            if (r1 == 0) goto L8e
            h.z r0 = r8.f418k
            if (r0 == 0) goto L8d
            r0.h(r9)
        L8d:
            return r3
        L8e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "MenuPopupHelper cannot be used without an anchor"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.n.k(h.g0):boolean");
    }

    public final boolean l() {
        h.o oVar;
        if (this.f424r && !j() && (oVar = this.f416i) != null && this.f421n != null && this.A == null) {
            oVar.i();
            if (!oVar.f3033p.isEmpty()) {
                k kVar = new k(this, 0, new i(this, this.f415h, this.f416i, this.o));
                this.A = kVar;
                ((View) this.f421n).post(kVar);
                return true;
            }
        }
        return false;
    }
}
