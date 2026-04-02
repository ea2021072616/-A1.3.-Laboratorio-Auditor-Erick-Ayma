package e1;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class i implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f2608a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2609b;

    public i(View view, ArrayList arrayList) {
        this.f2608a = view;
        this.f2609b = arrayList;
    }

    @Override // e1.p
    public final void a(r rVar) {
        rVar.z(this);
        rVar.a(this);
    }

    @Override // e1.p
    public final void c() {
    }

    @Override // e1.p
    public final void d(r rVar) {
    }

    @Override // e1.p
    public final void e() {
    }

    @Override // e1.p
    public final void f(r rVar) {
        rVar.z(this);
        this.f2608a.setVisibility(8);
        ArrayList arrayList = this.f2609b;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((View) arrayList.get(i5)).setVisibility(0);
        }
    }
}
