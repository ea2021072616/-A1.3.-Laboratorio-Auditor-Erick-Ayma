package h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class l extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final o f3019a;

    /* renamed from: b  reason: collision with root package name */
    public int f3020b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3021c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3022d;

    /* renamed from: e  reason: collision with root package name */
    public final LayoutInflater f3023e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3024f;

    public l(o oVar, LayoutInflater layoutInflater, boolean z4, int i5) {
        this.f3022d = z4;
        this.f3023e = layoutInflater;
        this.f3019a = oVar;
        this.f3024f = i5;
        a();
    }

    public final void a() {
        o oVar = this.f3019a;
        q qVar = oVar.B;
        if (qVar != null) {
            oVar.i();
            ArrayList arrayList = oVar.f3033p;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (((q) arrayList.get(i5)) == qVar) {
                    this.f3020b = i5;
                    return;
                }
            }
        }
        this.f3020b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b */
    public final q getItem(int i5) {
        ArrayList l5;
        boolean z4 = this.f3022d;
        o oVar = this.f3019a;
        if (z4) {
            oVar.i();
            l5 = oVar.f3033p;
        } else {
            l5 = oVar.l();
        }
        int i6 = this.f3020b;
        if (i6 >= 0 && i5 >= i6) {
            i5++;
        }
        return (q) l5.get(i5);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList l5;
        boolean z4 = this.f3022d;
        o oVar = this.f3019a;
        if (z4) {
            oVar.i();
            l5 = oVar.f3033p;
        } else {
            l5 = oVar.l();
        }
        return this.f3020b < 0 ? l5.size() : l5.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i5) {
        return i5;
    }

    @Override // android.widget.Adapter
    public final View getView(int i5, View view, ViewGroup viewGroup) {
        boolean z4 = false;
        if (view == null) {
            view = this.f3023e.inflate(this.f3024f, viewGroup, false);
        }
        int i6 = getItem(i5).f3048h;
        int i7 = i5 - 1;
        int i8 = i7 >= 0 ? getItem(i7).f3048h : i6;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f3019a.m() && i6 != i8) {
            z4 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z4);
        b0 b0Var = (b0) view;
        if (this.f3021c) {
            listMenuItemView.setForceShowIcon(true);
        }
        b0Var.c(getItem(i5));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
