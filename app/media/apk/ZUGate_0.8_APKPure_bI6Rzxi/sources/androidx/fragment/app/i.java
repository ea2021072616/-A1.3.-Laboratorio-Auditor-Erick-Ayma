package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o1 f915b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f916c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Rect f917d;

    public i(o1 o1Var, View view, Rect rect) {
        this.f915b = o1Var;
        this.f916c = view;
        this.f917d = rect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f915b.getClass();
        o1.g(this.f917d, this.f916c);
    }
}
