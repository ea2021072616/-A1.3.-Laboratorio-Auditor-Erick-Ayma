package c2;

import java.util.Set;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f1716a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1717b;

    /* renamed from: c  reason: collision with root package name */
    public final Set f1718c;

    public c(long j5, long j6, Set set) {
        this.f1716a = j5;
        this.f1717b = j6;
        this.f1718c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f1716a == cVar.f1716a && this.f1717b == cVar.f1717b && this.f1718c.equals(cVar.f1718c);
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f1716a;
        long j6 = this.f1717b;
        return ((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003) ^ this.f1718c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f1716a + ", maxAllowedDelay=" + this.f1717b + ", flags=" + this.f1718c + "}";
    }
}
