package k3;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
/* loaded from: classes.dex */
public final class d implements OnBackAnimationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f3647a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f3648b;

    public d(e eVar, b bVar) {
        this.f3648b = eVar;
        this.f3647a = bVar;
    }

    public final void onBackCancelled() {
        if (this.f3648b.f3646a != null) {
            this.f3647a.d();
        }
    }

    public final void onBackInvoked() {
        this.f3647a.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        if (this.f3648b.f3646a != null) {
            this.f3647a.c(new androidx.activity.b(backEvent));
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        if (this.f3648b.f3646a != null) {
            this.f3647a.b(new androidx.activity.b(backEvent));
        }
    }
}
