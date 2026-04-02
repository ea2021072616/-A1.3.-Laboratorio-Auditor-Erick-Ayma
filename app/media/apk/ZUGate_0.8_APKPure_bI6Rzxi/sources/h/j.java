package h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.github.appintro.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class j extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public int f3011a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f3012b;

    public j(k kVar) {
        this.f3012b = kVar;
        a();
    }

    public final void a() {
        o oVar = this.f3012b.f3015i;
        q qVar = oVar.B;
        if (qVar != null) {
            oVar.i();
            ArrayList arrayList = oVar.f3033p;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (((q) arrayList.get(i5)) == qVar) {
                    this.f3011a = i5;
                    return;
                }
            }
        }
        this.f3011a = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b */
    public final q getItem(int i5) {
        k kVar = this.f3012b;
        o oVar = kVar.f3015i;
        oVar.i();
        ArrayList arrayList = oVar.f3033p;
        kVar.getClass();
        int i6 = i5 + 0;
        int i7 = this.f3011a;
        if (i7 >= 0 && i6 >= i7) {
            i6++;
        }
        return (q) arrayList.get(i6);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        k kVar = this.f3012b;
        o oVar = kVar.f3015i;
        oVar.i();
        int size = oVar.f3033p.size();
        kVar.getClass();
        int i5 = size + 0;
        return this.f3011a < 0 ? i5 : i5 - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i5) {
        return i5;
    }

    @Override // android.widget.Adapter
    public final View getView(int i5, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f3012b.f3014h.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((b0) view).c(getItem(i5));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
