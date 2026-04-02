package h;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
public abstract class w implements e0, a0, AdapterView.OnItemClickListener {

    /* renamed from: g  reason: collision with root package name */
    public Rect f3076g;

    public static int m(l lVar, Context context, int i5) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = lVar.getCount();
        int i6 = 0;
        int i7 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i8 = 0; i8 < count; i8++) {
            int itemViewType = lVar.getItemViewType(i8);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = lVar.getView(i8, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i5) {
                return i5;
            }
            if (measuredWidth > i6) {
                i6 = measuredWidth;
            }
        }
        return i6;
    }

    public static boolean u(o oVar) {
        int size = oVar.size();
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = oVar.getItem(i5);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // h.a0
    public final void d(Context context, o oVar) {
    }

    @Override // h.a0
    public final boolean g(q qVar) {
        return false;
    }

    @Override // h.a0
    public final boolean i(q qVar) {
        return false;
    }

    public abstract void l(o oVar);

    public abstract void n(View view);

    public abstract void o(boolean z4);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (l) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (l) listAdapter).f3019a.q((MenuItem) listAdapter.getItem(i5), this, (this instanceof i) ^ true ? 0 : 4);
    }

    public abstract void p(int i5);

    public abstract void q(int i5);

    public abstract void r(PopupWindow.OnDismissListener onDismissListener);

    public abstract void s(boolean z4);

    public abstract void t(int i5);
}
