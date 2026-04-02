package d4;

import b4.j;
import c4.f;
import e4.e;
import i4.p;
/* loaded from: classes.dex */
public final class c extends e4.c {

    /* renamed from: e  reason: collision with root package name */
    public int f2554e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ p f2555f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f2556g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c4.b bVar, f fVar, p pVar, Object obj) {
        super(bVar, fVar);
        this.f2555f = pVar;
        this.f2556g = obj;
        e.d(bVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // e4.a
    public final Object g(Object obj) {
        int i5 = this.f2554e;
        if (i5 != 0) {
            if (i5 == 1) {
                this.f2554e = 2;
                e.Y(obj);
                return obj;
            }
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
        this.f2554e = 1;
        e.Y(obj);
        p pVar = this.f2555f;
        e.d(pVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        j.a(pVar);
        return pVar.d(this.f2556g, this);
    }
}
