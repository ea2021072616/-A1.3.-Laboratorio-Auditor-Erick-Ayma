package k2;

import androidx.appcompat.widget.d0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final a f3609a;

    /* renamed from: b  reason: collision with root package name */
    public final i2.c f3610b;

    public /* synthetic */ p(a aVar, i2.c cVar) {
        this.f3609a = aVar;
        this.f3610b = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof p)) {
            p pVar = (p) obj;
            if (b4.j.p(this.f3609a, pVar.f3609a) && b4.j.p(this.f3610b, pVar.f3610b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3609a, this.f3610b});
    }

    public final String toString() {
        d0 d0Var = new d0(this);
        d0Var.f(this.f3609a, "key");
        d0Var.f(this.f3610b, "feature");
        return d0Var.toString();
    }
}
