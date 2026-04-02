package s3;

import android.view.View;
/* loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4864a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f4865b;

    public /* synthetic */ b(o oVar, int i5) {
        this.f4864a = i5;
        this.f4865b = oVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z4) {
        int i5 = this.f4864a;
        o oVar = this.f4865b;
        switch (i5) {
            case 0:
                d dVar = (d) oVar;
                dVar.t(dVar.u());
                return;
            default:
                k kVar = (k) oVar;
                kVar.f4888l = z4;
                kVar.q();
                if (z4) {
                    return;
                }
                kVar.t(false);
                kVar.f4889m = false;
                return;
        }
    }
}
