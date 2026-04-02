package y4;

import android.app.Activity;
import android.widget.ArrayAdapter;
import h1.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class h extends ArrayAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f5733a;

    public h(Activity activity, List list) {
        super(activity, 17367055);
        this.f5733a = new ArrayList(list);
    }

    @Override // android.widget.ArrayAdapter
    public final void clear() {
        this.f5733a.clear();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final int getCount() {
        return this.f5733a.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final Object getItem(int i5) {
        return ((k) this.f5733a.get(i5)).f3292e;
    }

    @Override // android.widget.ArrayAdapter
    public final /* bridge */ /* synthetic */ int getPosition(Object obj) {
        String str = (String) obj;
        return -1;
    }
}
