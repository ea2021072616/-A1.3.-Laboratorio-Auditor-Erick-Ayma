package y1;

import androidx.appcompat.widget.b0;
import n.h;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f5659a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5660b;

    public a(int i5, long j5) {
        if (i5 == 0) {
            throw new NullPointerException("Null status");
        }
        this.f5659a = i5;
        this.f5660b = j5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return h.a(this.f5659a, aVar.f5659a) && this.f5660b == aVar.f5660b;
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f5660b;
        return ((h.b(this.f5659a) ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        return "BackendResponse{status=" + b0.r(this.f5659a) + ", nextRequestWaitMillis=" + this.f5660b + "}";
    }
}
