package androidx.recyclerview.widget;

import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1289a;

    public a1(RecyclerView recyclerView) {
        this.f1289a = recyclerView;
    }

    public final void a() {
        boolean z4 = RecyclerView.K0;
        RecyclerView recyclerView = this.f1289a;
        if (z4 && recyclerView.f1257z && recyclerView.f1255y) {
            WeakHashMap weakHashMap = h0.z0.f3233a;
            recyclerView.postOnAnimation(recyclerView.o);
            return;
        }
        recyclerView.G = true;
        recyclerView.requestLayout();
    }
}
