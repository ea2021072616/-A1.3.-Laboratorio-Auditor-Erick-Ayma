package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
/* loaded from: classes.dex */
public final class i1 extends Transition.EpicenterCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f922a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Rect f923b;

    public /* synthetic */ i1(Rect rect, int i5) {
        this.f922a = i5;
        this.f923b = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public final Rect onGetEpicenter(Transition transition) {
        int i5 = this.f922a;
        Rect rect = this.f923b;
        switch (i5) {
            case 0:
                return rect;
            default:
                if (rect == null || rect.isEmpty()) {
                    return null;
                }
                return rect;
        }
    }
}
