package androidx.activity;

import androidx.fragment.app.o0;
import java.util.ListIterator;
/* loaded from: classes.dex */
public final class r extends j4.g implements i4.l {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f75c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ z f76d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(z zVar, int i5) {
        super(1);
        this.f75c = i5;
        this.f76d = zVar;
    }

    @Override // i4.l
    public final /* bridge */ /* synthetic */ Object c(Object obj) {
        a4.e eVar = a4.e.f34a;
        switch (this.f75c) {
            case 0:
                d((b) obj);
                return eVar;
            default:
                d((b) obj);
                return eVar;
        }
    }

    public final void d(b bVar) {
        Object obj;
        int i5 = this.f75c;
        z zVar = this.f76d;
        switch (i5) {
            case 0:
                e4.e.f(bVar, "backEvent");
                b4.c cVar = zVar.f121b;
                cVar.getClass();
                ListIterator listIterator = cVar.listIterator(cVar.f1657d);
                while (true) {
                    if (listIterator.hasPrevious()) {
                        Object previous = listIterator.previous();
                        obj = ((o0) previous).f961a ? previous : null;
                    }
                }
                zVar.f122c = (o0) obj;
                return;
            default:
                e4.e.f(bVar, "backEvent");
                b4.c cVar2 = zVar.f121b;
                cVar2.getClass();
                ListIterator listIterator2 = cVar2.listIterator(cVar2.f1657d);
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        Object previous2 = listIterator2.previous();
                        obj = ((o0) previous2).f961a ? previous2 : null;
                    }
                }
                o0 o0Var = (o0) obj;
                return;
        }
    }
}
