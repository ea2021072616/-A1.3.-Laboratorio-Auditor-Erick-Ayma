package e0;

import android.os.Process;
/* loaded from: classes.dex */
public final class h extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public final int f2582b;

    public h(Runnable runnable, String str, int i5) {
        super(runnable, str);
        this.f2582b = i5;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f2582b);
        super.run();
    }
}
