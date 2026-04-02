package d2;

import androidx.appcompat.widget.b0;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f2507f;

    /* renamed from: a  reason: collision with root package name */
    public final long f2508a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2509b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2510c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2511d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2512e;

    static {
        Long l5 = 10485760L;
        Integer num = 200;
        Integer num2 = 10000;
        Long l6 = 604800000L;
        Integer num3 = 81920;
        String str = l5 == null ? " maxStorageSizeInBytes" : "";
        if (num == null) {
            str = str.concat(" loadBatchSize");
        }
        if (num2 == null) {
            str = b0.h(str, " criticalSectionEnterTimeoutMs");
        }
        if (l6 == null) {
            str = b0.h(str, " eventCleanUpAge");
        }
        if (num3 == null) {
            str = b0.h(str, " maxBlobByteSizePerRow");
        }
        if (!str.isEmpty()) {
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
        f2507f = new a(l5.longValue(), num.intValue(), num2.intValue(), l6.longValue(), num3.intValue());
    }

    public a(long j5, int i5, int i6, long j6, int i7) {
        this.f2508a = j5;
        this.f2509b = i5;
        this.f2510c = i6;
        this.f2511d = j6;
        this.f2512e = i7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f2508a == aVar.f2508a && this.f2509b == aVar.f2509b && this.f2510c == aVar.f2510c && this.f2511d == aVar.f2511d && this.f2512e == aVar.f2512e;
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f2508a;
        long j6 = this.f2511d;
        return ((((((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ this.f2509b) * 1000003) ^ this.f2510c) * 1000003) ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003) ^ this.f2512e;
    }

    public final String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f2508a + ", loadBatchSize=" + this.f2509b + ", criticalSectionEnterTimeoutMs=" + this.f2510c + ", eventCleanUpAge=" + this.f2511d + ", maxBlobByteSizePerRow=" + this.f2512e + "}";
    }
}
