package androidx.activity;

import android.window.BackEvent;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final float f45a;

    /* renamed from: b  reason: collision with root package name */
    public final float f46b;

    /* renamed from: c  reason: collision with root package name */
    public final float f47c;

    /* renamed from: d  reason: collision with root package name */
    public final int f48d;

    public b(BackEvent backEvent) {
        e4.e.f(backEvent, "backEvent");
        a aVar = a.f44a;
        float d5 = aVar.d(backEvent);
        float e5 = aVar.e(backEvent);
        float b5 = aVar.b(backEvent);
        int c5 = aVar.c(backEvent);
        this.f45a = d5;
        this.f46b = e5;
        this.f47c = b5;
        this.f48d = c5;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.f45a + ", touchY=" + this.f46b + ", progress=" + this.f47c + ", swipeEdge=" + this.f48d + '}';
    }
}
