package b.a.a.a.a.d;

import android.content.Context;
/* compiled from: TimeBasedFileRollOverRunnable.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f182a;

    /* renamed from: b  reason: collision with root package name */
    private final e f183b;

    public i(Context context, e eVar) {
        this.f182a = context;
        this.f183b = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.a.a.a.a.b.i.a(this.f182a, "Performing time based file roll over.");
            if (!this.f183b.rollFileOver()) {
                this.f183b.cancelTimeBasedFileRollOver();
            }
        } catch (Exception e) {
            b.a.a.a.a.b.i.a(this.f182a, "Failed to roll over file", e);
        }
    }
}
