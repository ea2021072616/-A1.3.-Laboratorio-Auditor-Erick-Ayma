package x2;

import android.animation.TimeInterpolator;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f5490a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5491b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeInterpolator f5492c;

    /* renamed from: d  reason: collision with root package name */
    public int f5493d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f5494e = 1;

    public c(long j5, long j6, TimeInterpolator timeInterpolator) {
        this.f5490a = 0L;
        this.f5491b = 300L;
        this.f5492c = null;
        this.f5490a = j5;
        this.f5491b = j6;
        this.f5492c = timeInterpolator;
    }

    public final TimeInterpolator a() {
        TimeInterpolator timeInterpolator = this.f5492c;
        return timeInterpolator != null ? timeInterpolator : a.f5485b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f5490a == cVar.f5490a && this.f5491b == cVar.f5491b && this.f5493d == cVar.f5493d && this.f5494e == cVar.f5494e) {
                return a().getClass().equals(cVar.a().getClass());
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f5490a;
        long j6 = this.f5491b;
        return ((((a().getClass().hashCode() + (((((int) (j5 ^ (j5 >>> 32))) * 31) + ((int) ((j6 >>> 32) ^ j6))) * 31)) * 31) + this.f5493d) * 31) + this.f5494e;
    }

    public final String toString() {
        return "\n" + c.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.f5490a + " duration: " + this.f5491b + " interpolator: " + a().getClass() + " repeatCount: " + this.f5493d + " repeatMode: " + this.f5494e + "}\n";
    }
}
