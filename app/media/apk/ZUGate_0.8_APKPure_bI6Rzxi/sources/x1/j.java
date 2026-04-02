package x1;

import android.content.Context;
import androidx.appcompat.widget.d0;
import androidx.recyclerview.widget.b0;
import com.google.android.gms.internal.play_billing.i0;
import java.io.Closeable;
/* loaded from: classes.dex */
public final class j implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public z3.a f5464b = z1.a.a(b4.j.f1682v);

    /* renamed from: c  reason: collision with root package name */
    public b0 f5465c;

    /* renamed from: d  reason: collision with root package name */
    public z3.a f5466d;

    /* renamed from: e  reason: collision with root package name */
    public y1.e f5467e;

    /* renamed from: f  reason: collision with root package name */
    public z3.a f5468f;

    /* renamed from: g  reason: collision with root package name */
    public z3.a f5469g;

    public j(Context context) {
        if (context == null) {
            throw new NullPointerException("instance cannot be null");
        }
        b0 b0Var = new b0(context);
        this.f5465c = b0Var;
        z0.d dVar = i0.f1886c;
        z0.d dVar2 = e4.e.f2710e;
        this.f5466d = z1.a.a(new d0(b0Var, 14, new y1.e(b0Var, dVar, dVar2, 0)));
        b0 b0Var2 = this.f5465c;
        this.f5467e = new y1.e(b0Var2, b4.j.f1665d, i0.f1884a, 1);
        z3.a a5 = z1.a.a(new p(dVar, dVar2, e4.e.f2706a, this.f5467e, z1.a.a(new b2.d(b0Var2, 1)), 2));
        this.f5468f = a5;
        b2.d dVar3 = new b2.d(dVar, 0);
        b0 b0Var3 = this.f5465c;
        b2.e eVar = new b2.e(b0Var3, a5, dVar3, dVar2, 0);
        z3.a aVar = this.f5464b;
        z3.a aVar2 = this.f5466d;
        this.f5469g = z1.a.a(new p(dVar, dVar2, new p(aVar, aVar2, eVar, a5, a5, 1), new c2.l(b0Var3, aVar2, a5, eVar, aVar, a5, a5), new b2.e(aVar, a5, eVar, a5, 1), 0));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    /* renamed from: j */
    public final void close() {
        ((d2.k) ((d2.d) this.f5468f.get())).close();
    }
}
