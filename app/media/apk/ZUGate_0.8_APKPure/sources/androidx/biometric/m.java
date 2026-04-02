package androidx.biometric;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public final class m implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f625b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f626c;

    public m(ExecutorService executorService) {
        this.f625b = 3;
        this.f626c = executorService;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        int i5 = this.f625b;
        Object obj = this.f626c;
        switch (i5) {
            case 0:
                ((Handler) obj).post(runnable);
                return;
            case 1:
                ((Handler) obj).post(runnable);
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                ((Handler) obj).post(runnable);
                return;
            default:
                ((Executor) obj).execute(new androidx.activity.j(16, runnable));
                return;
        }
    }

    public m(int i5) {
        this.f625b = i5;
        if (i5 == 1) {
            this.f626c = new Handler(Looper.getMainLooper());
        } else if (i5 != 2) {
            this.f626c = new Handler(Looper.getMainLooper());
        } else {
            this.f626c = new r2.d(Looper.getMainLooper(), 2);
        }
    }
}
