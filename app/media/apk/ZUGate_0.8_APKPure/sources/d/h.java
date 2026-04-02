package d;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController$RecycleListView;
/* loaded from: classes.dex */
public final class h implements AdapterView.OnItemClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AlertController$RecycleListView f2330g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ l f2331h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ i f2332i;

    public h(i iVar, AlertController$RecycleListView alertController$RecycleListView, l lVar) {
        this.f2332i = iVar;
        this.f2330g = alertController$RecycleListView;
        this.f2331h = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        i iVar = this.f2332i;
        boolean[] zArr = iVar.f2358u;
        AlertController$RecycleListView alertController$RecycleListView = this.f2330g;
        if (zArr != null) {
            zArr[i5] = alertController$RecycleListView.isItemChecked(i5);
        }
        iVar.f2362y.onClick(this.f2331h.f2373b, i5, alertController$RecycleListView.isItemChecked(i5));
    }
}
