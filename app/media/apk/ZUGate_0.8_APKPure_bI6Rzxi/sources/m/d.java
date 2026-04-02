package m;

import com.google.android.gms.internal.play_billing.i0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* loaded from: classes.dex */
public final class d extends i0 {

    /* renamed from: l  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3911l;

    /* renamed from: m  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3912m;

    /* renamed from: n  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3913n;
    public final AtomicReferenceFieldUpdater o;

    /* renamed from: p  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3914p;

    public d(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(0);
        this.f3911l = atomicReferenceFieldUpdater;
        this.f3912m = atomicReferenceFieldUpdater2;
        this.f3913n = atomicReferenceFieldUpdater3;
        this.o = atomicReferenceFieldUpdater4;
        this.f3914p = atomicReferenceFieldUpdater5;
    }

    @Override // com.google.android.gms.internal.play_billing.i0
    public final void K(f fVar, f fVar2) {
        this.f3912m.lazySet(fVar, fVar2);
    }

    @Override // com.google.android.gms.internal.play_billing.i0
    public final void L(f fVar, Thread thread) {
        this.f3911l.lazySet(fVar, thread);
    }

    @Override // com.google.android.gms.internal.play_billing.i0
    public final boolean d(g gVar, c cVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        c cVar2 = c.f3909b;
        do {
            atomicReferenceFieldUpdater = this.o;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, cVar, cVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == cVar);
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.i0
    public final boolean e(g gVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f3914p;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == obj);
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.i0
    public final boolean f(g gVar, f fVar, f fVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f3913n;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, fVar, fVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == fVar);
        return false;
    }
}
