package androidx.activity;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
public final class n implements m, ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: c  reason: collision with root package name */
    public Runnable f66c;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f68e;

    /* renamed from: b  reason: collision with root package name */
    public final long f65b = SystemClock.uptimeMillis() + 10000;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67d = false;

    public n(ComponentActivity componentActivity) {
        this.f68e = componentActivity;
    }

    @Override // androidx.activity.m
    public final void a(View view) {
        if (this.f67d) {
            return;
        }
        this.f67d = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f66c = runnable;
        View decorView = this.f68e.getWindow().getDecorView();
        if (!this.f67d) {
            decorView.postOnAnimation(new d(1, this));
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z4;
        Runnable runnable = this.f66c;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.f65b) {
                this.f67d = false;
                this.f68e.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.f66c = null;
        q qVar = this.f68e.mFullyDrawnReporter;
        synchronized (qVar.f72a) {
            z4 = qVar.f73b;
        }
        if (z4) {
            this.f67d = false;
            this.f68e.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f68e.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
