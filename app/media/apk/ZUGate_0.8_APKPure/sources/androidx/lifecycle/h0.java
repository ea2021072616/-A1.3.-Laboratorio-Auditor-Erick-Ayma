package androidx.lifecycle;

import android.os.Handler;
/* loaded from: classes.dex */
public final class h0 implements t {
    public static final h0 o = new h0();

    /* renamed from: g  reason: collision with root package name */
    public int f1105g;

    /* renamed from: h  reason: collision with root package name */
    public int f1106h;

    /* renamed from: k  reason: collision with root package name */
    public Handler f1109k;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1107i = true;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1108j = true;

    /* renamed from: l  reason: collision with root package name */
    public final v f1110l = new v(this);

    /* renamed from: m  reason: collision with root package name */
    public final androidx.activity.d f1111m = new androidx.activity.d(6, this);

    /* renamed from: n  reason: collision with root package name */
    public final g0 f1112n = new g0(this);

    public final void a() {
        int i5 = this.f1106h + 1;
        this.f1106h = i5;
        if (i5 == 1) {
            if (this.f1107i) {
                this.f1110l.e(m.ON_RESUME);
                this.f1107i = false;
                return;
            }
            Handler handler = this.f1109k;
            e4.e.c(handler);
            handler.removeCallbacks(this.f1111m);
        }
    }

    @Override // androidx.lifecycle.t
    public final o getLifecycle() {
        return this.f1110l;
    }
}
