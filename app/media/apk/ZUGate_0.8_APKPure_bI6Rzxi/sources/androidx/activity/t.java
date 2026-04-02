package androidx.activity;

import android.window.OnBackInvokedCallback;
/* loaded from: classes.dex */
public final /* synthetic */ class t implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f109a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f110b;

    public /* synthetic */ t(int i5, Object obj) {
        this.f109a = i5;
        this.f110b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f109a) {
            case 0:
                i4.a aVar = (i4.a) this.f110b;
                e4.e.f(aVar, "$onBackInvoked");
                aVar.a();
                return;
            case 1:
                ((Runnable) this.f110b).run();
                return;
            default:
                ((k3.b) this.f110b).a();
                return;
        }
    }
}
