package b.a.a.a.a.b;

import android.os.SystemClock;
import android.util.Log;
/* compiled from: TimingMetric.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private final String f136a;

    /* renamed from: b  reason: collision with root package name */
    private final String f137b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f138c;
    private long d;
    private long e;

    public t(String str, String str2) {
        this.f136a = str;
        this.f137b = str2;
        this.f138c = !Log.isLoggable(str2, 2);
    }

    public synchronized void a() {
        if (!this.f138c) {
            this.d = SystemClock.elapsedRealtime();
            this.e = 0L;
        }
    }

    public synchronized void b() {
        if (!this.f138c && this.e == 0) {
            this.e = SystemClock.elapsedRealtime() - this.d;
            c();
        }
    }

    private void c() {
        Log.v(this.f137b, this.f136a + ": " + this.e + "ms");
    }
}
