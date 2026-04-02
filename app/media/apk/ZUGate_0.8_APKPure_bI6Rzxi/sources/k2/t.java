package k2;

import android.os.SystemClock;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class t implements v2.b {

    /* renamed from: g  reason: collision with root package name */
    public final d f3614g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3615h;

    /* renamed from: i  reason: collision with root package name */
    public final a f3616i;

    /* renamed from: j  reason: collision with root package name */
    public final long f3617j;

    /* renamed from: k  reason: collision with root package name */
    public final long f3618k;

    public t(d dVar, int i5, a aVar, long j5, long j6) {
        this.f3614g = dVar;
        this.f3615h = i5;
        this.f3616i = aVar;
        this.f3617j = j5;
        this.f3618k = j6;
    }

    @Override // v2.b
    public final void d(v2.g gVar) {
        Exception exc;
        int i5;
        int i6;
        int i7;
        long j5;
        long j6;
        int i8;
        d dVar = this.f3614g;
        if (dVar.a()) {
            l2.i.d().getClass();
            o oVar = (o) dVar.f3586j.get(this.f3616i);
            if (oVar != null) {
                l2.f fVar = oVar.f3598b;
                if (fVar instanceof l2.f) {
                    long j7 = this.f3617j;
                    boolean z4 = true;
                    boolean z5 = j7 > 0;
                    int i9 = fVar.f3821p;
                    synchronized (gVar.f5210a) {
                        if (!gVar.f5212c || gVar.f5214e != null) {
                            z4 = false;
                        }
                    }
                    if (z4) {
                        i6 = 0;
                        i7 = 0;
                    } else {
                        synchronized (gVar.f5210a) {
                            exc = gVar.f5214e;
                        }
                        if (exc instanceof j2.c) {
                            Status status = ((j2.c) exc).f3439b;
                            i5 = status.f1825b;
                            i2.a aVar = status.f1828e;
                            if (aVar != null) {
                                i7 = aVar.f3381c;
                                i6 = i5;
                            }
                        } else {
                            i5 = 101;
                        }
                        i6 = i5;
                        i7 = -1;
                    }
                    if (z5) {
                        long currentTimeMillis = System.currentTimeMillis();
                        i8 = (int) (SystemClock.elapsedRealtime() - this.f3618k);
                        j5 = j7;
                        j6 = currentTimeMillis;
                    } else {
                        j5 = 0;
                        j6 = 0;
                        i8 = -1;
                    }
                    u uVar = new u(new l2.h(this.f3615h, i6, i7, j5, j6, null, null, i9, i8), 0, 5000, 100);
                    r2.d dVar2 = dVar.f3589m;
                    dVar2.sendMessage(dVar2.obtainMessage(18, uVar));
                }
            }
        }
    }
}
