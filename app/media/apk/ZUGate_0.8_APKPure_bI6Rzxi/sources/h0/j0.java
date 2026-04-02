package h0;

import android.view.View;
/* loaded from: classes.dex */
public final class j0 extends l0 {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f3158e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(int i5, int i6) {
        super(i5, Boolean.class, 0, 28);
        this.f3158e = i6;
    }

    public final Boolean d(View view) {
        switch (this.f3158e) {
            case 0:
                return Boolean.valueOf(s0.d(view));
            default:
                return Boolean.valueOf(s0.c(view));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(int i5, int i6, int i7, int i8) {
        super(i5, CharSequence.class, i6, i7);
        this.f3158e = i8;
    }
}
