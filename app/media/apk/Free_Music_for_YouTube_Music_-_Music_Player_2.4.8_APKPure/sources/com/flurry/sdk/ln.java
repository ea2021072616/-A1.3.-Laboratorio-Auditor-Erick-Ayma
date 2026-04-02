package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
final class ln {

    /* renamed from: a  reason: collision with root package name */
    private Timer f2167a;

    /* renamed from: b  reason: collision with root package name */
    private a f2168b;

    public final synchronized void a(long j) {
        if (this.f2167a != null) {
            a();
        }
        this.f2167a = new Timer("FlurrySessionTimer");
        this.f2168b = new a();
        this.f2167a.schedule(this.f2168b, j);
    }

    public final synchronized void a() {
        if (this.f2167a != null) {
            this.f2167a.cancel();
            this.f2167a = null;
        }
        this.f2168b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            ln.this.a();
            ki.a().a(new lo());
        }
    }
}
