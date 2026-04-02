package z0;

import android.content.Context;
import com.google.android.gms.internal.play_billing.i0;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5792b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f5793c;

    public /* synthetic */ f(Context context, int i5) {
        this.f5792b = i5;
        this.f5793c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f5792b;
        Context context = this.f5793c;
        switch (i5) {
            case 0:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new f(context, 1));
                return;
            default:
                i0.U(context, new i.a(5), i0.f1893j, false);
                return;
        }
    }
}
