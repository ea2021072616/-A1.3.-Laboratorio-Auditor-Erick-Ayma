package i;

import androidx.viewpager.widget.l;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3350b;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f3350b) {
            case l.SCROLL_STATE_SETTLING /* 2 */:
                runnable.run();
                return;
            case 3:
                runnable.run();
                return;
            case 4:
                runnable.run();
                return;
            default:
                runnable.run();
                return;
        }
    }
}
