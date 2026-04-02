package androidx.activity;

import android.content.Context;
import androidx.fragment.app.d0;
/* loaded from: classes.dex */
public final /* synthetic */ class g implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f54a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f55b;

    public /* synthetic */ g(ComponentActivity componentActivity, int i5) {
        this.f54a = i5;
        this.f55b = componentActivity;
    }

    @Override // a.b
    public final void a(Context context) {
        int i5 = this.f54a;
        ComponentActivity componentActivity = this.f55b;
        switch (i5) {
            case 0:
                ComponentActivity.c(componentActivity);
                return;
            default:
                d0.d((d0) componentActivity);
                return;
        }
    }
}
