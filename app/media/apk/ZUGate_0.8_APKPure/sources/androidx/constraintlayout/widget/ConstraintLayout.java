package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import n.d;
import p.f;
import p.i;
import q.m;
import s.c;
import s.e;
import s.g;
import s.n;
import s.o;
import s.q;
import s.r;
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: v  reason: collision with root package name */
    public static r f669v;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray f670g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f671h;

    /* renamed from: i  reason: collision with root package name */
    public final f f672i;

    /* renamed from: j  reason: collision with root package name */
    public int f673j;

    /* renamed from: k  reason: collision with root package name */
    public int f674k;

    /* renamed from: l  reason: collision with root package name */
    public int f675l;

    /* renamed from: m  reason: collision with root package name */
    public int f676m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f677n;
    public int o;

    /* renamed from: p  reason: collision with root package name */
    public n f678p;

    /* renamed from: q  reason: collision with root package name */
    public g f679q;

    /* renamed from: r  reason: collision with root package name */
    public int f680r;

    /* renamed from: s  reason: collision with root package name */
    public HashMap f681s;

    /* renamed from: t  reason: collision with root package name */
    public final SparseArray f682t;

    /* renamed from: u  reason: collision with root package name */
    public final m f683u;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f670g = new SparseArray();
        this.f671h = new ArrayList(4);
        this.f672i = new f();
        this.f673j = 0;
        this.f674k = 0;
        this.f675l = Integer.MAX_VALUE;
        this.f676m = Integer.MAX_VALUE;
        this.f677n = true;
        this.o = 257;
        this.f678p = null;
        this.f679q = null;
        this.f680r = -1;
        this.f681s = new HashMap();
        this.f682t = new SparseArray();
        this.f683u = new m(this, this);
        h(attributeSet, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    public static r getSharedValues() {
        if (f669v == null) {
            f669v = new r();
        }
        return f669v;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f671h;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                ((c) arrayList.get(i5)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i7 = (int) ((parseInt / 1080.0f) * width);
                        int i8 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f5 = i7;
                        float f6 = i8;
                        float f7 = i7 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f5, f6, f7, f6, paint);
                        float parseInt4 = i8 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f7, f6, f7, parseInt4, paint);
                        canvas.drawLine(f7, parseInt4, f5, parseInt4, paint);
                        canvas.drawLine(f5, parseInt4, f5, f6, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f5, f6, f7, parseInt4, paint);
                        canvas.drawLine(f5, parseInt4, f7, f6, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f677n = true;
        super.forceLayout();
    }

    public final p.e g(View view) {
        if (view == this) {
            return this.f672i;
        }
        if (view != null) {
            if (view.getLayoutParams() instanceof e) {
                return ((e) view.getLayoutParams()).f4682p0;
            }
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (view.getLayoutParams() instanceof e) {
                return ((e) view.getLayoutParams()).f4682p0;
            }
            return null;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public int getMaxHeight() {
        return this.f676m;
    }

    public int getMaxWidth() {
        return this.f675l;
    }

    public int getMinHeight() {
        return this.f674k;
    }

    public int getMinWidth() {
        return this.f673j;
    }

    public int getOptimizationLevel() {
        return this.f672i.D0;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        f fVar = this.f672i;
        if (fVar.f4176j == null) {
            int id2 = getId();
            if (id2 != -1) {
                fVar.f4176j = getContext().getResources().getResourceEntryName(id2);
            } else {
                fVar.f4176j = "parent";
            }
        }
        if (fVar.f4173h0 == null) {
            fVar.f4173h0 = fVar.f4176j;
            Log.v("ConstraintLayout", " setDebugName " + fVar.f4173h0);
        }
        Iterator it = fVar.f4243q0.iterator();
        while (it.hasNext()) {
            p.e eVar = (p.e) it.next();
            View view = (View) eVar.f4169f0;
            if (view != null) {
                if (eVar.f4176j == null && (id = view.getId()) != -1) {
                    eVar.f4176j = getContext().getResources().getResourceEntryName(id);
                }
                if (eVar.f4173h0 == null) {
                    eVar.f4173h0 = eVar.f4176j;
                    Log.v("ConstraintLayout", " setDebugName " + eVar.f4173h0);
                }
            }
        }
        fVar.o(sb);
        return sb.toString();
    }

    public final void h(AttributeSet attributeSet, int i5) {
        f fVar = this.f672i;
        fVar.f4169f0 = this;
        m mVar = this.f683u;
        fVar.f4202u0 = mVar;
        fVar.f4200s0.f4382f = mVar;
        this.f670g.put(getId(), this);
        this.f678p = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q.f4794b, i5, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == 16) {
                    this.f673j = obtainStyledAttributes.getDimensionPixelOffset(index, this.f673j);
                } else if (index == 17) {
                    this.f674k = obtainStyledAttributes.getDimensionPixelOffset(index, this.f674k);
                } else if (index == 14) {
                    this.f675l = obtainStyledAttributes.getDimensionPixelOffset(index, this.f675l);
                } else if (index == 15) {
                    this.f676m = obtainStyledAttributes.getDimensionPixelOffset(index, this.f676m);
                } else if (index == 113) {
                    this.o = obtainStyledAttributes.getInt(index, this.o);
                } else if (index == 56) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            this.f679q = new g(getContext(), resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f679q = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        n nVar = new n();
                        this.f678p = nVar;
                        nVar.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f678p = null;
                    }
                    this.f680r = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        fVar.D0 = this.o;
        d.f4008p = fVar.W(512);
    }

    public final boolean i() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    public final void j(String str, Integer num) {
        if ((str instanceof String) && (num instanceof Integer)) {
            if (this.f681s == null) {
                this.f681s = new HashMap();
            }
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f681s.put(str, Integer.valueOf(num.intValue()));
        }
    }

    public final void k(p.e eVar, e eVar2, SparseArray sparseArray, int i5, p.c cVar) {
        View view = (View) this.f670g.get(i5);
        p.e eVar3 = (p.e) sparseArray.get(i5);
        if (eVar3 == null || view == null || !(view.getLayoutParams() instanceof e)) {
            return;
        }
        eVar2.f4657c0 = true;
        p.c cVar2 = p.c.BASELINE;
        if (cVar == cVar2) {
            e eVar4 = (e) view.getLayoutParams();
            eVar4.f4657c0 = true;
            eVar4.f4682p0.E = true;
        }
        eVar.j(cVar2).b(eVar3.j(cVar), eVar2.D, eVar2.C, true);
        eVar.E = true;
        eVar.j(p.c.TOP).j();
        eVar.j(p.c.BOTTOM).j();
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x037f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l() {
        /*
            Method dump skipped, instructions count: 1314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.l():boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            e eVar = (e) childAt.getLayoutParams();
            p.e eVar2 = eVar.f4682p0;
            if (childAt.getVisibility() != 8 || eVar.f4659d0 || eVar.f4661e0 || isInEditMode) {
                int s5 = eVar2.s();
                int t5 = eVar2.t();
                childAt.layout(s5, t5, eVar2.r() + s5, eVar2.l() + t5);
            }
        }
        ArrayList arrayList = this.f671h;
        int size = arrayList.size();
        if (size > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                ((c) arrayList.get(i10)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0197  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r26, int r27) {
        /*
            Method dump skipped, instructions count: 1883
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        p.e g5 = g(view);
        if ((view instanceof Guideline) && !(g5 instanceof i)) {
            e eVar = (e) view.getLayoutParams();
            i iVar = new i();
            eVar.f4682p0 = iVar;
            eVar.f4659d0 = true;
            iVar.S(eVar.V);
        }
        if (view instanceof c) {
            c cVar = (c) view;
            cVar.i();
            ((e) view.getLayoutParams()).f4661e0 = true;
            ArrayList arrayList = this.f671h;
            if (!arrayList.contains(cVar)) {
                arrayList.add(cVar);
            }
        }
        this.f670g.put(view.getId(), view);
        this.f677n = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f670g.remove(view.getId());
        p.e g5 = g(view);
        this.f672i.f4243q0.remove(g5);
        g5.D();
        this.f671h.remove(view);
        this.f677n = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f677n = true;
        super.requestLayout();
    }

    public void setConstraintSet(n nVar) {
        this.f678p = nVar;
    }

    @Override // android.view.View
    public void setId(int i5) {
        int id = getId();
        SparseArray sparseArray = this.f670g;
        sparseArray.remove(id);
        super.setId(i5);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i5) {
        if (i5 == this.f676m) {
            return;
        }
        this.f676m = i5;
        requestLayout();
    }

    public void setMaxWidth(int i5) {
        if (i5 == this.f675l) {
            return;
        }
        this.f675l = i5;
        requestLayout();
    }

    public void setMinHeight(int i5) {
        if (i5 == this.f674k) {
            return;
        }
        this.f674k = i5;
        requestLayout();
    }

    public void setMinWidth(int i5) {
        if (i5 == this.f673j) {
            return;
        }
        this.f673j = i5;
        requestLayout();
    }

    public void setOnConstraintsChanged(o oVar) {
        g gVar = this.f679q;
        if (gVar != null) {
            gVar.getClass();
        }
    }

    public void setOptimizationLevel(int i5) {
        this.o = i5;
        f fVar = this.f672i;
        fVar.D0 = i5;
        d.f4008p = fVar.W(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f670g = new SparseArray();
        this.f671h = new ArrayList(4);
        this.f672i = new f();
        this.f673j = 0;
        this.f674k = 0;
        this.f675l = Integer.MAX_VALUE;
        this.f676m = Integer.MAX_VALUE;
        this.f677n = true;
        this.o = 257;
        this.f678p = null;
        this.f679q = null;
        this.f680r = -1;
        this.f681s = new HashMap();
        this.f682t = new SparseArray();
        this.f683u = new m(this, this);
        h(attributeSet, i5);
    }
}
