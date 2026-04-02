package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public abstract class i0 extends g0 {

    /* renamed from: g  reason: collision with root package name */
    public final Activity f918g;

    /* renamed from: h  reason: collision with root package name */
    public final Context f919h;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f920i;

    /* renamed from: j  reason: collision with root package name */
    public final x0 f921j;

    public i0(d.q qVar) {
        Handler handler = new Handler();
        this.f921j = new x0();
        this.f918g = qVar;
        this.f919h = qVar;
        this.f920i = handler;
    }
}
