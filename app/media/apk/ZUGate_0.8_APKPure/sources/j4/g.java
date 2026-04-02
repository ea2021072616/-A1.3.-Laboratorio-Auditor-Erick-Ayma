package j4;

import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class g implements e, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final int f3521b;

    public g(int i5) {
        this.f3521b = i5;
    }

    @Override // j4.e
    public final int b() {
        return this.f3521b;
    }

    public final String toString() {
        i.f3523a.getClass();
        String a5 = j.a(this);
        e4.e.e(a5, "renderLambdaToString(this)");
        return a5;
    }
}
