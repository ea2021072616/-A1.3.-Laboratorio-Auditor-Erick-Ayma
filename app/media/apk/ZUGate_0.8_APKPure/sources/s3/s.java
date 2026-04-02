package s3;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.o2;
/* loaded from: classes.dex */
public final class s implements AdapterView.OnItemClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ u f4950g;

    public s(u uVar) {
        this.f4950g = uVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        Object item;
        u uVar = this.f4950g;
        if (i5 < 0) {
            o2 o2Var = uVar.f4954k;
            item = !o2Var.a() ? null : o2Var.f452i.getSelectedItem();
        } else {
            item = uVar.getAdapter().getItem(i5);
        }
        u.a(uVar, item);
        AdapterView.OnItemClickListener onItemClickListener = uVar.getOnItemClickListener();
        o2 o2Var2 = uVar.f4954k;
        if (onItemClickListener != null) {
            if (view == null || i5 < 0) {
                view = o2Var2.a() ? o2Var2.f452i.getSelectedView() : null;
                i5 = !o2Var2.a() ? -1 : o2Var2.f452i.getSelectedItemPosition();
                j5 = !o2Var2.a() ? Long.MIN_VALUE : o2Var2.f452i.getSelectedItemId();
            }
            onItemClickListener.onItemClick(o2Var2.f452i, view, i5, j5);
        }
        o2Var2.dismiss();
    }
}
