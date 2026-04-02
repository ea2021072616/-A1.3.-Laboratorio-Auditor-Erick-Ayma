package w1;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class l extends s {

    /* renamed from: a  reason: collision with root package name */
    public final long f5361a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f5362b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5363c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f5364d;

    /* renamed from: e  reason: collision with root package name */
    public final String f5365e;

    /* renamed from: f  reason: collision with root package name */
    public final long f5366f;

    /* renamed from: g  reason: collision with root package name */
    public final w f5367g;

    public l(long j5, Integer num, long j6, byte[] bArr, String str, long j7, w wVar) {
        this.f5361a = j5;
        this.f5362b = num;
        this.f5363c = j6;
        this.f5364d = bArr;
        this.f5365e = str;
        this.f5366f = j7;
        this.f5367g = wVar;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            l lVar = (l) sVar;
            if (this.f5361a == lVar.f5361a && ((num = this.f5362b) != null ? num.equals(lVar.f5362b) : lVar.f5362b == null)) {
                if (this.f5363c == lVar.f5363c) {
                    if (Arrays.equals(this.f5364d, sVar instanceof l ? ((l) sVar).f5364d : lVar.f5364d)) {
                        String str = lVar.f5365e;
                        String str2 = this.f5365e;
                        if (str2 != null ? str2.equals(str) : str == null) {
                            if (this.f5366f == lVar.f5366f) {
                                w wVar = lVar.f5367g;
                                w wVar2 = this.f5367g;
                                if (wVar2 == null) {
                                    if (wVar == null) {
                                        return true;
                                    }
                                } else if (wVar2.equals(wVar)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f5361a;
        int i5 = (((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f5362b;
        int hashCode = num == null ? 0 : num.hashCode();
        long j6 = this.f5363c;
        int hashCode2 = (((((i5 ^ hashCode) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f5364d)) * 1000003;
        String str = this.f5365e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j7 = this.f5366f;
        int i6 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        w wVar = this.f5367g;
        return i6 ^ (wVar != null ? wVar.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f5361a + ", eventCode=" + this.f5362b + ", eventUptimeMs=" + this.f5363c + ", sourceExtension=" + Arrays.toString(this.f5364d) + ", sourceExtensionJsonProto3=" + this.f5365e + ", timezoneOffsetSeconds=" + this.f5366f + ", networkConnectionInfo=" + this.f5367g + "}";
    }
}
