package com.andexert.expandablelayout.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
/* loaded from: classes.dex */
public class ExpandableLayoutListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    private Integer f588a;

    public ExpandableLayoutListView(Context context) {
        super(context);
        this.f588a = -1;
        setOnScrollListener(new a());
    }

    public ExpandableLayoutListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f588a = -1;
        setOnScrollListener(new a());
    }

    public ExpandableLayoutListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f588a = -1;
        setOnScrollListener(new a());
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        this.f588a = Integer.valueOf(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= getChildCount()) {
                break;
            }
            if (i3 != i - getFirstVisiblePosition()) {
                ((ExpandableLayoutItem) getChildAt(i3).findViewWithTag(ExpandableLayoutItem.class.getName())).e();
            }
            i2 = i3 + 1;
        }
        ExpandableLayoutItem expandableLayoutItem = (ExpandableLayoutItem) getChildAt(i - getFirstVisiblePosition()).findViewWithTag(ExpandableLayoutItem.class.getName());
        if (expandableLayoutItem.c().booleanValue()) {
            expandableLayoutItem.e();
        } else {
            expandableLayoutItem.d();
        }
        return super.performItemClick(view, i, j);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        if (!(onScrollListener instanceof a)) {
            throw new IllegalArgumentException("OnScrollListner must be an OnExpandableLayoutScrollListener");
        }
        super.setOnScrollListener(onScrollListener);
    }

    /* loaded from: classes.dex */
    public class a implements AbsListView.OnScrollListener {

        /* renamed from: b  reason: collision with root package name */
        private int f590b = 0;

        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            this.f590b = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f590b != 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < ExpandableLayoutListView.this.getChildCount()) {
                        ExpandableLayoutItem expandableLayoutItem = (ExpandableLayoutItem) ExpandableLayoutListView.this.getChildAt(i5).findViewWithTag(ExpandableLayoutItem.class.getName());
                        if (expandableLayoutItem.c().booleanValue() && i5 != ExpandableLayoutListView.this.f588a.intValue() - ExpandableLayoutListView.this.getFirstVisiblePosition()) {
                            expandableLayoutItem.a();
                        } else if (!expandableLayoutItem.getCloseByUser().booleanValue() && !expandableLayoutItem.c().booleanValue() && i5 == ExpandableLayoutListView.this.f588a.intValue() - ExpandableLayoutListView.this.getFirstVisiblePosition()) {
                            expandableLayoutItem.b();
                        }
                        i4 = i5 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
