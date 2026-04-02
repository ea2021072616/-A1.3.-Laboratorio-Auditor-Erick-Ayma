package d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
/* loaded from: classes.dex */
public final class f extends ArrayAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AlertController$RecycleListView f2324a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f2325b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(i iVar, Context context, int i5, CharSequence[] charSequenceArr, AlertController$RecycleListView alertController$RecycleListView) {
        super(context, i5, 16908308, charSequenceArr);
        this.f2325b = iVar;
        this.f2324a = alertController$RecycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i5, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i5, view, viewGroup);
        boolean[] zArr = this.f2325b.f2358u;
        if (zArr != null && zArr[i5]) {
            this.f2324a.setItemChecked(i5, true);
        }
        return view2;
    }
}
