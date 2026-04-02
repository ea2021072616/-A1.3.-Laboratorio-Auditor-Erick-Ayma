package d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ru.zdevs.zugate.MainActivity;
/* loaded from: classes.dex */
public final class j0 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2368a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2369b;

    public /* synthetic */ j0(int i5, Object obj) {
        this.f2368a = i5;
        this.f2369b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i5 = this.f2368a;
        Object obj = this.f2369b;
        switch (i5) {
            case 0:
                i0 i0Var = (i0) ((k0) obj);
                int i6 = i0Var.f2363c;
                n0 n0Var = i0Var.f2364d;
                switch (i6) {
                    case 0:
                        n0Var.p(true, true);
                        return;
                    default:
                        n0Var.p(true, true);
                        return;
                }
            default:
                int i7 = MainActivity.f4551q;
                ((MainActivity) obj).j();
                return;
        }
    }
}
