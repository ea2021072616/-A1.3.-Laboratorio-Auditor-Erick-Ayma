package b2;

import android.content.Context;
import c2.m;
import c2.n;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class e implements z1.b {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f1631g;

    /* renamed from: h  reason: collision with root package name */
    public final z3.a f1632h;

    /* renamed from: i  reason: collision with root package name */
    public final z3.a f1633i;

    /* renamed from: j  reason: collision with root package name */
    public final z3.a f1634j;

    /* renamed from: k  reason: collision with root package name */
    public final z3.a f1635k;

    public /* synthetic */ e(z3.a aVar, z3.a aVar2, z1.b bVar, z3.a aVar3, int i5) {
        this.f1631g = i5;
        this.f1632h = aVar;
        this.f1633i = aVar2;
        this.f1634j = bVar;
        this.f1635k = aVar3;
    }

    @Override // z3.a
    public final Object get() {
        int i5 = this.f1631g;
        z3.a aVar = this.f1635k;
        z3.a aVar2 = this.f1634j;
        z3.a aVar3 = this.f1633i;
        z3.a aVar4 = this.f1632h;
        switch (i5) {
            case 0:
                f2.a aVar5 = (f2.a) aVar.get();
                return new c2.d((Context) aVar4.get(), (d2.d) aVar3.get(), (c2.b) aVar2.get());
            default:
                return new m((Executor) aVar4.get(), (d2.d) aVar3.get(), (n) aVar2.get(), (e2.c) aVar.get());
        }
    }
}
