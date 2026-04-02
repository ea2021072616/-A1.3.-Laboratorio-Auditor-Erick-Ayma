package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
/* loaded from: classes.dex */
public final class v implements OnBackAnimationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i4.l f112a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i4.l f113b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i4.a f114c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ i4.a f115d;

    public v(i4.l lVar, i4.l lVar2, i4.a aVar, i4.a aVar2) {
        this.f112a = lVar;
        this.f113b = lVar2;
        this.f114c = aVar;
        this.f115d = aVar2;
    }

    public final void onBackCancelled() {
        this.f115d.a();
    }

    public final void onBackInvoked() {
        this.f114c.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        e4.e.f(backEvent, "backEvent");
        this.f113b.c(new b(backEvent));
    }

    public final void onBackStarted(BackEvent backEvent) {
        e4.e.f(backEvent, "backEvent");
        this.f112a.c(new b(backEvent));
    }
}
