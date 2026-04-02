package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.github.appintro.R;
import h0.z0;
/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: g  reason: collision with root package name */
    public final boolean f2094g;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        w.d(null);
        if (n.m(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.f2094g = n.n(getContext(), R.attr.nestedScrollable);
        z0.n(this, new h(3, this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: a */
    public final q getAdapter2() {
        return (q) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter2().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        q adapter2 = getAdapter2();
        adapter2.getClass();
        int max = Math.max(adapter2.a(), getFirstVisiblePosition());
        int min = Math.min((adapter2.a() + adapter2.f2152a.f2147f) - 1, getLastVisiblePosition());
        adapter2.getItem(max);
        adapter2.getItem(min);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z4, int i5, Rect rect) {
        if (!z4) {
            super.onFocusChanged(false, i5, rect);
        } else if (i5 == 33) {
            q adapter2 = getAdapter2();
            setSelection((adapter2.a() + adapter2.f2152a.f2147f) - 1);
        } else if (i5 == 130) {
            setSelection(getAdapter2().a());
        } else {
            super.onFocusChanged(true, i5, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i5, KeyEvent keyEvent) {
        if (super.onKeyDown(i5, keyEvent)) {
            if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter2().a()) {
                return true;
            }
            if (19 == i5) {
                setSelection(getAdapter2().a());
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i5, int i6) {
        if (!this.f2094g) {
            super.onMeasure(i5, i6);
            return;
        }
        super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i5) {
        if (i5 < getAdapter2().a()) {
            super.setSelection(getAdapter2().a());
        } else {
            super.setSelection(i5);
        }
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof q) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), q.class.getCanonicalName()));
    }
}
