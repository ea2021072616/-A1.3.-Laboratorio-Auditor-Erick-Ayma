package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.z2;
import h.c0;
import h.n;
import h.o;
import h.q;
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements n, c0, AdapterView.OnItemClickListener {

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f139h = {16842964, 16843049};

    /* renamed from: g  reason: collision with root package name */
    public o f140g;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        z2 z2Var = new z2(context, context.obtainStyledAttributes(attributeSet, f139h, 16842868, 0));
        if (z2Var.l(0)) {
            setBackgroundDrawable(z2Var.e(0));
        }
        if (z2Var.l(1)) {
            setDivider(z2Var.e(1));
        }
        z2Var.n();
    }

    @Override // h.c0
    public final void a(o oVar) {
        this.f140g = oVar;
    }

    @Override // h.n
    public final boolean b(q qVar) {
        return this.f140g.q(qVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        b((q) getAdapter().getItem(i5));
    }
}
