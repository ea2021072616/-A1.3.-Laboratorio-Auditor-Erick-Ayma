package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
/* loaded from: classes.dex */
public final class s2 extends b2 {

    /* renamed from: s  reason: collision with root package name */
    public final int f524s;

    /* renamed from: t  reason: collision with root package name */
    public final int f525t;

    /* renamed from: u  reason: collision with root package name */
    public p2 f526u;

    /* renamed from: v  reason: collision with root package name */
    public h.q f527v;

    public s2(Context context, boolean z4) {
        super(context, z4);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.f524s = 21;
            this.f525t = 22;
            return;
        }
        this.f524s = 22;
        this.f525t = 21;
    }

    @Override // androidx.appcompat.widget.b2, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        h.l lVar;
        int i5;
        int pointToPosition;
        int i6;
        if (this.f526u != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                i5 = headerViewListAdapter.getHeadersCount();
                lVar = (h.l) headerViewListAdapter.getWrappedAdapter();
            } else {
                lVar = (h.l) adapter;
                i5 = 0;
            }
            h.q item = (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i6 = pointToPosition - i5) < 0 || i6 >= lVar.getCount()) ? null : lVar.getItem(i6);
            h.q qVar = this.f527v;
            if (qVar != item) {
                h.o oVar = lVar.f3019a;
                if (qVar != null) {
                    this.f526u.g(oVar, qVar);
                }
                this.f527v = item;
                if (item != null) {
                    this.f526u.l(oVar, item);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i5, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i5 == this.f524s) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        } else if (listMenuItemView == null || i5 != this.f525t) {
            return super.onKeyDown(i5, keyEvent);
        } else {
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (h.l) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (h.l) adapter).f3019a.c(false);
            return true;
        }
    }

    public void setHoverListener(p2 p2Var) {
        this.f526u = p2Var;
    }

    @Override // androidx.appcompat.widget.b2, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
