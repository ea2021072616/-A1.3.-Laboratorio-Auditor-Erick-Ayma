package d4;

import b4.j;
import e4.e;
import e4.f;
import i4.p;
/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: c  reason: collision with root package name */
    public int f2551c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ p f2552d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f2553e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Object obj, c4.b bVar, p pVar) {
        super(bVar);
        this.f2552d = pVar;
        this.f2553e = obj;
        e.d(bVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // e4.a
    public final Object g(Object obj) {
        int i5 = this.f2551c;
        if (i5 != 0) {
            if (i5 == 1) {
                this.f2551c = 2;
                e.Y(obj);
                return obj;
            }
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
        this.f2551c = 1;
        e.Y(obj);
        p pVar = this.f2552d;
        e.d(pVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        j.a(pVar);
        return pVar.d(this.f2553e, this);
    }
}
