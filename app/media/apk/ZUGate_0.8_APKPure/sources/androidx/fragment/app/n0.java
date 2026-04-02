package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public final class n0 implements androidx.activity.result.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f953a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ w0 f954b;

    public /* synthetic */ n0(w0 w0Var, int i5) {
        this.f953a = i5;
        this.f954b = w0Var;
    }

    @Override // androidx.activity.result.c
    public final void a(Object obj) {
        switch (this.f953a) {
            case 0:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    iArr[i5] = ((Boolean) arrayList.get(i5)).booleanValue() ? 0 : -1;
                }
                w0 w0Var = this.f954b;
                t0 t0Var = (t0) w0Var.C.pollFirst();
                if (t0Var == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                    return;
                }
                e1 e1Var = w0Var.f1027c;
                String str = t0Var.f1008b;
                Fragment c5 = e1Var.c(str);
                if (c5 != null) {
                    c5.onRequestPermissionsResult(t0Var.f1009c, strArr, iArr);
                    return;
                }
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                return;
            case 1:
            default:
                b((androidx.activity.result.b) obj);
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                b((androidx.activity.result.b) obj);
                return;
        }
    }

    public final void b(androidx.activity.result.b bVar) {
        int i5 = this.f953a;
        w0 w0Var = this.f954b;
        switch (i5) {
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                t0 t0Var = (t0) w0Var.C.pollFirst();
                if (t0Var == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                    return;
                }
                e1 e1Var = w0Var.f1027c;
                String str = t0Var.f1008b;
                Fragment c5 = e1Var.c(str);
                if (c5 != null) {
                    c5.onActivityResult(t0Var.f1009c, bVar.f82b, bVar.f83c);
                    return;
                }
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                return;
            default:
                t0 t0Var2 = (t0) w0Var.C.pollFirst();
                if (t0Var2 == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                    return;
                }
                e1 e1Var2 = w0Var.f1027c;
                String str2 = t0Var2.f1008b;
                Fragment c6 = e1Var2.c(str2);
                if (c6 != null) {
                    c6.onActivityResult(t0Var2.f1009c, bVar.f82b, bVar.f83c);
                    return;
                }
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str2);
                return;
        }
    }
}
