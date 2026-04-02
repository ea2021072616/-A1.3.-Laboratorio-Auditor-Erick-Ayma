package y0;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j1;
import androidx.recyclerview.widget.k1;
/* loaded from: classes.dex */
public final class c0 extends k1 {

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f5597f;

    /* renamed from: g  reason: collision with root package name */
    public final j1 f5598g;

    /* renamed from: h  reason: collision with root package name */
    public final b0 f5599h;

    public c0(RecyclerView recyclerView) {
        super(recyclerView);
        this.f5598g = this.f1414e;
        this.f5599h = new b0(0, this);
        this.f5597f = recyclerView;
    }

    @Override // androidx.recyclerview.widget.k1
    public final h0.b j() {
        return this.f5599h;
    }
}
