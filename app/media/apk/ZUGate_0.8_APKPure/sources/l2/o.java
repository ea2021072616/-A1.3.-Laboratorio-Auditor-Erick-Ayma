package l2;

import android.content.Intent;
/* loaded from: classes.dex */
public final class o extends p {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Intent f3875g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ k2.f f3876h;

    public o(Intent intent, k2.f fVar) {
        this.f3875g = intent;
        this.f3876h = fVar;
    }

    @Override // l2.p
    public final void a() {
        Intent intent = this.f3875g;
        if (intent != null) {
            this.f3876h.startActivityForResult(intent, 2);
        }
    }
}
