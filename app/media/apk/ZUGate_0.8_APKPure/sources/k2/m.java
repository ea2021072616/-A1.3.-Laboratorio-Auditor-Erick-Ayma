package k2;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r0;
/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3593b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f3594c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f3595d;

    public /* synthetic */ m(int i5, int i6, Object obj) {
        this.f3593b = i6;
        this.f3595d = obj;
        this.f3594c = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f3593b;
        int i6 = this.f3594c;
        Object obj = this.f3595d;
        switch (i5) {
            case 0:
                ((o) obj).i(i6);
                return;
            default:
                RecyclerView recyclerView = ((com.google.android.material.datepicker.l) obj).f2131n;
                if (recyclerView.D) {
                    return;
                }
                r0 r0Var = recyclerView.f1245t;
                if (r0Var == null) {
                    Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                    return;
                } else {
                    r0Var.z0(recyclerView, i6);
                    return;
                }
        }
    }
}
