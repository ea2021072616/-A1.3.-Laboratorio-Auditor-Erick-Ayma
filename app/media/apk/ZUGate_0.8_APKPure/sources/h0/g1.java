package h0;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class g1 extends e4.f implements i4.p, j4.e {

    /* renamed from: c  reason: collision with root package name */
    public final int f3133c;

    /* renamed from: d  reason: collision with root package name */
    public int f3134d;

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ Object f3135e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f3136f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g1(View view, c4.b bVar) {
        super(bVar);
        this.f3136f = view;
        this.f3133c = 2;
    }

    @Override // j4.e
    public final int b() {
        return this.f3133c;
    }

    @Override // i4.p
    public final Object d(Object obj, Object obj2) {
        return ((g1) e((o4.a) obj, (c4.b) obj2)).g(a4.e.f34a);
    }

    @Override // e4.a
    public final c4.b e(Object obj, c4.b bVar) {
        g1 g1Var = new g1(this.f3136f, bVar);
        g1Var.f3135e = obj;
        return g1Var;
    }

    @Override // e4.a
    public final Object g(Object obj) {
        Object obj2;
        Object obj3 = d4.a.COROUTINE_SUSPENDED;
        int i5 = this.f3134d;
        View view = this.f3136f;
        if (i5 == 0) {
            e4.e.Y(obj);
            o4.a aVar = (o4.a) this.f3135e;
            this.f3135e = aVar;
            this.f3134d = 1;
            aVar.f4117c = view;
            aVar.f4116b = 3;
            aVar.f4119e = this;
            return obj3;
        }
        Object obj4 = a4.e.f34a;
        if (i5 == 1) {
            o4.a aVar2 = (o4.a) this.f3135e;
            e4.e.Y(obj);
            if (view instanceof ViewGroup) {
                this.f3135e = null;
                this.f3134d = 2;
                aVar2.getClass();
                e0 e0Var = new e0(new f1((ViewGroup) view));
                if (e0Var.hasNext()) {
                    aVar2.f4118d = e0Var;
                    aVar2.f4116b = 2;
                    aVar2.f4119e = this;
                    obj2 = obj3;
                } else {
                    obj2 = obj4;
                }
                if (obj2 != obj3) {
                    obj2 = obj4;
                }
                if (obj2 == obj3) {
                    return obj3;
                }
            }
        } else if (i5 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            e4.e.Y(obj);
        }
        return obj4;
    }

    @Override // e4.a
    /* renamed from: i */
    public final String toString() {
        if (this.f2702b == null) {
            j4.i.f3523a.getClass();
            String a5 = j4.j.a(this);
            e4.e.e(a5, "renderLambdaToString(this)");
            return a5;
        }
        return super.toString();
    }
}
