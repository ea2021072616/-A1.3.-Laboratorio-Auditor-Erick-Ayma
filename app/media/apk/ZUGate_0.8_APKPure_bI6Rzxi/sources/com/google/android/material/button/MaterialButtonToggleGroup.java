package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import b4.j;
import c3.d;
import com.github.appintro.R;
import com.google.android.material.timepicker.h;
import h0.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import n.f;
import n2.b;
import p2.a;
import y0.b0;
/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: q  reason: collision with root package name */
    public static final /* synthetic */ int f2066q = 0;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f2067g;

    /* renamed from: h  reason: collision with root package name */
    public final b f2068h;

    /* renamed from: i  reason: collision with root package name */
    public final LinkedHashSet f2069i;

    /* renamed from: j  reason: collision with root package name */
    public final f f2070j;

    /* renamed from: k  reason: collision with root package name */
    public Integer[] f2071k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2072l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2073m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2074n;
    public final int o;

    /* renamed from: p  reason: collision with root package name */
    public HashSet f2075p;

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(a.b0(context, attributeSet, R.attr.materialButtonToggleGroupStyle, 2131952712), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.f2067g = new ArrayList();
        this.f2068h = new b(this);
        this.f2069i = new LinkedHashSet();
        this.f2070j = new f(1, this);
        this.f2072l = false;
        this.f2075p = new HashSet();
        TypedArray D = j.D(getContext(), attributeSet, w2.a.f5396k, R.attr.materialButtonToggleGroupStyle, 2131952712, new int[0]);
        setSingleSelection(D.getBoolean(3, false));
        this.o = D.getResourceId(1, -1);
        this.f2074n = D.getBoolean(2, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(D.getBoolean(0, true));
        D.recycle();
        WeakHashMap weakHashMap = z0.f3233a;
        setImportantForAccessibility(1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (d(i5)) {
                return i5;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (d(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            if ((getChildAt(i6) instanceof MaterialButton) && d(i6)) {
                i5++;
            }
        }
        return i5;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap weakHashMap = z0.f3233a;
            materialButton.setId(View.generateViewId());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f2068h);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i5 = firstVisibleChildIndex + 1; i5 < getChildCount(); i5++) {
            MaterialButton c5 = c(i5);
            int min = Math.min(c5.getStrokeWidth(), c(i5 - 1).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = c5.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(-min);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -min;
                layoutParams2.setMarginStart(0);
            }
            c5.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c(firstVisibleChildIndex).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            return;
        }
        layoutParams3.setMarginEnd(0);
        layoutParams3.setMarginStart(0);
        layoutParams3.leftMargin = 0;
        layoutParams3.rightMargin = 0;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i5, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        b(materialButton.getId(), materialButton.isChecked());
        p3.j shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f2067g.add(new d(shapeAppearanceModel.f4318e, shapeAppearanceModel.f4321h, shapeAppearanceModel.f4319f, shapeAppearanceModel.f4320g));
        materialButton.setEnabled(isEnabled());
        z0.n(materialButton, new b0(2, this));
    }

    public final void b(int i5, boolean z4) {
        if (i5 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i5);
            return;
        }
        HashSet hashSet = new HashSet(this.f2075p);
        if (z4 && !hashSet.contains(Integer.valueOf(i5))) {
            if (this.f2073m && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i5));
        } else if (z4 || !hashSet.contains(Integer.valueOf(i5))) {
            return;
        } else {
            if (!this.f2074n || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i5));
            }
        }
        e(hashSet);
    }

    public final MaterialButton c(int i5) {
        return (MaterialButton) getChildAt(i5);
    }

    public final boolean d(int i5) {
        return getChildAt(i5).getVisibility() != 8;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f2070j);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            treeMap.put(c(i5), Integer.valueOf(i5));
        }
        this.f2071k = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e(Set set) {
        HashSet hashSet = this.f2075p;
        this.f2075p = new HashSet(set);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            int id = c(i5).getId();
            boolean contains = set.contains(Integer.valueOf(id));
            View findViewById = findViewById(id);
            if (findViewById instanceof MaterialButton) {
                this.f2072l = true;
                ((MaterialButton) findViewById).setChecked(contains);
                this.f2072l = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.f2069i.iterator();
                while (it.hasNext()) {
                    ((h) it.next()).a();
                }
            }
        }
        invalidate();
    }

    public final void f() {
        d dVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i5 = 0; i5 < childCount; i5++) {
            MaterialButton c5 = c(i5);
            if (c5.getVisibility() != 8) {
                p3.j shapeAppearanceModel = c5.getShapeAppearanceModel();
                shapeAppearanceModel.getClass();
                w1.h hVar = new w1.h(shapeAppearanceModel);
                d dVar2 = (d) this.f2067g.get(i5);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z4 = getOrientation() == 0;
                    p3.a aVar = d.f1784e;
                    if (i5 == firstVisibleChildIndex) {
                        dVar = z4 ? a.C(this) ? new d(aVar, aVar, dVar2.f1786b, dVar2.f1787c) : new d(dVar2.f1785a, dVar2.f1788d, aVar, aVar) : new d(dVar2.f1785a, aVar, dVar2.f1786b, aVar);
                    } else if (i5 == lastVisibleChildIndex) {
                        dVar = z4 ? a.C(this) ? new d(dVar2.f1785a, dVar2.f1788d, aVar, aVar) : new d(aVar, aVar, dVar2.f1786b, dVar2.f1787c) : new d(aVar, dVar2.f1788d, aVar, dVar2.f1787c);
                    } else {
                        dVar2 = null;
                    }
                    dVar2 = dVar;
                }
                if (dVar2 == null) {
                    hVar.f5338e = new p3.a(0.0f);
                    hVar.f5339f = new p3.a(0.0f);
                    hVar.f5340g = new p3.a(0.0f);
                    hVar.f5341h = new p3.a(0.0f);
                } else {
                    hVar.f5338e = dVar2.f1785a;
                    hVar.f5341h = dVar2.f1788d;
                    hVar.f5339f = dVar2.f1786b;
                    hVar.f5340g = dVar2.f1787c;
                }
                c5.setShapeAppearanceModel(new p3.j(hVar));
            }
        }
    }

    public int getCheckedButtonId() {
        if (!this.f2073m || this.f2075p.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f2075p.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            int id = c(i5).getId();
            if (this.f2075p.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i5, int i6) {
        Integer[] numArr = this.f2071k;
        if (numArr == null || i6 >= numArr.length) {
            Log.w("MButtonToggleGroup", "Child order wasn't updated");
            return i6;
        }
        return numArr[i6].intValue();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i5 = this.o;
        if (i5 != -1) {
            e(Collections.singleton(Integer.valueOf(i5)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getVisibleButtonCount(), false, this.f2073m ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        f();
        a();
        super.onMeasure(i5, i6);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f2067g.remove(indexOfChild);
        }
        f();
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            c(i5).setEnabled(z4);
        }
    }

    public void setSelectionRequired(boolean z4) {
        this.f2074n = z4;
    }

    public void setSingleSelection(boolean z4) {
        if (this.f2073m != z4) {
            this.f2073m = z4;
            e(new HashSet());
        }
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            c(i5).setA11yClassName((this.f2073m ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    public void setSingleSelection(int i5) {
        setSingleSelection(getResources().getBoolean(i5));
    }
}
