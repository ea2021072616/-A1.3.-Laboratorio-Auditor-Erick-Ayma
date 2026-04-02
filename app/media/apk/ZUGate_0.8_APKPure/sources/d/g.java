package d;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
public final class g implements AdapterView.OnItemClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2327g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f2328h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f2329i;

    public /* synthetic */ g(Object obj, int i5, Object obj2) {
        this.f2327g = i5;
        this.f2329i = obj;
        this.f2328h = obj2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        int i6 = this.f2327g;
        Object obj = this.f2329i;
        switch (i6) {
            case 0:
                i iVar = (i) obj;
                DialogInterface.OnClickListener onClickListener = iVar.f2355r;
                l lVar = (l) this.f2328h;
                onClickListener.onClick(lVar.f2373b, i5);
                if (iVar.f2360w) {
                    return;
                }
                lVar.f2373b.dismiss();
                return;
            default:
                androidx.appcompat.widget.u0 u0Var = (androidx.appcompat.widget.u0) obj;
                u0Var.M.setSelection(i5);
                androidx.appcompat.widget.x0 x0Var = u0Var.M;
                if (x0Var.getOnItemClickListener() != null) {
                    x0Var.performItemClick(view, i5, u0Var.J.getItemId(i5));
                }
                u0Var.dismiss();
                return;
        }
    }
}
