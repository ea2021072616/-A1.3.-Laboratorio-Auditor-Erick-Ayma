package h0;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class e1 extends j4.g implements i4.l {

    /* renamed from: d  reason: collision with root package name */
    public static final e1 f3122d = new e1(0);

    /* renamed from: e  reason: collision with root package name */
    public static final e1 f3123e = new e1(1);

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f3124c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(int i5) {
        super(1);
        this.f3124c = i5;
    }

    @Override // i4.l
    public final Object c(Object obj) {
        switch (this.f3124c) {
            case 0:
                View view = (View) obj;
                ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                if (viewGroup != null) {
                    return new f1(viewGroup);
                }
                return null;
            case 1:
                e4.e.f((w0.b) obj, "$this$initializer");
                return new androidx.lifecycle.o0();
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                c4.d dVar = (c4.d) obj;
                if (dVar instanceof q4.a) {
                    return (q4.a) dVar;
                }
                return null;
            case 3:
                c4.d dVar2 = (c4.d) obj;
                if (dVar2 instanceof q4.c) {
                    return (q4.c) dVar2;
                }
                return null;
            default:
                Throwable th = (Throwable) obj;
                return null;
        }
    }
}
