package androidx.recyclerview.widget;
/* loaded from: classes.dex */
public final class n extends v0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f1430a;

    public n(q qVar) {
        this.f1430a = qVar;
    }

    @Override // androidx.recyclerview.widget.v0
    public final void b(RecyclerView recyclerView, int i5, int i6) {
        int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        q qVar = this.f1430a;
        int computeVerticalScrollRange = qVar.f1474s.computeVerticalScrollRange();
        int i7 = qVar.f1473r;
        int i8 = computeVerticalScrollRange - i7;
        int i9 = qVar.f1457a;
        qVar.f1475t = i8 > 0 && i7 >= i9;
        int computeHorizontalScrollRange = qVar.f1474s.computeHorizontalScrollRange();
        int i10 = qVar.f1472q;
        boolean z4 = computeHorizontalScrollRange - i10 > 0 && i10 >= i9;
        qVar.f1476u = z4;
        boolean z5 = qVar.f1475t;
        if (!z5 && !z4) {
            if (qVar.f1477v != 0) {
                qVar.f(0);
                return;
            }
            return;
        }
        if (z5) {
            float f5 = i7;
            qVar.f1468l = (int) ((((f5 / 2.0f) + computeVerticalScrollOffset) * f5) / computeVerticalScrollRange);
            qVar.f1467k = Math.min(i7, (i7 * i7) / computeVerticalScrollRange);
        }
        if (qVar.f1476u) {
            float f6 = computeHorizontalScrollOffset;
            float f7 = i10;
            qVar.o = (int) ((((f7 / 2.0f) + f6) * f7) / computeHorizontalScrollRange);
            qVar.f1470n = Math.min(i10, (i10 * i10) / computeHorizontalScrollRange);
        }
        int i11 = qVar.f1477v;
        if (i11 == 0 || i11 == 1) {
            qVar.f(1);
        }
    }
}
