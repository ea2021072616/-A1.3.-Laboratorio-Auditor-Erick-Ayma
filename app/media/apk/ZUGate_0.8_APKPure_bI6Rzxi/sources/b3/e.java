package b3;

import android.view.View;
/* loaded from: classes.dex */
public final class e extends c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y4.a f1642a;

    public e(y4.a aVar) {
        this.f1642a = aVar;
    }

    @Override // b3.c
    public final void b(View view) {
    }

    @Override // b3.c
    public final void c(View view, int i5) {
        if (i5 == 5) {
            this.f1642a.cancel();
        }
    }
}
