package androidx.activity;

import androidx.fragment.app.o0;
import androidx.lifecycle.w0;
import java.util.ListIterator;
/* loaded from: classes.dex */
public final class s extends j4.g implements i4.a {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f107c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f108d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(int i5, Object obj) {
        super(0);
        this.f107c = i5;
        this.f108d = obj;
    }

    @Override // i4.a
    public final Object a() {
        a4.e eVar = a4.e.f34a;
        switch (this.f107c) {
            case 0:
                d();
                return eVar;
            case 1:
                d();
                return eVar;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                d();
                return eVar;
            default:
                return b4.j.w((w0) this.f108d);
        }
    }

    public final void d() {
        Object obj;
        int i5 = this.f107c;
        Object obj2 = this.f108d;
        switch (i5) {
            case 0:
                ((z) obj2).b();
                return;
            case 1:
                z zVar = (z) obj2;
                b4.c cVar = zVar.f121b;
                cVar.getClass();
                ListIterator listIterator = cVar.listIterator(cVar.f1657d);
                while (true) {
                    if (listIterator.hasPrevious()) {
                        obj = listIterator.previous();
                        if (((o0) obj).f961a) {
                        }
                    } else {
                        obj = null;
                    }
                }
                o0 o0Var = (o0) obj;
                zVar.f122c = null;
                return;
            default:
                ((z) obj2).b();
                return;
        }
    }
}
