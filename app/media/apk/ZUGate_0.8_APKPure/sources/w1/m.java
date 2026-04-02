package w1;

import java.util.List;
/* loaded from: classes.dex */
public final class m extends t {

    /* renamed from: a  reason: collision with root package name */
    public final long f5368a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5369b;

    /* renamed from: c  reason: collision with root package name */
    public final r f5370c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f5371d;

    /* renamed from: e  reason: collision with root package name */
    public final String f5372e;

    /* renamed from: f  reason: collision with root package name */
    public final List f5373f;

    /* renamed from: g  reason: collision with root package name */
    public final x f5374g;

    public m(long j5, long j6, r rVar, Integer num, String str, List list, x xVar) {
        this.f5368a = j5;
        this.f5369b = j6;
        this.f5370c = rVar;
        this.f5371d = num;
        this.f5372e = str;
        this.f5373f = list;
        this.f5374g = xVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            m mVar = (m) ((t) obj);
            if (this.f5368a == mVar.f5368a) {
                if (this.f5369b == mVar.f5369b) {
                    r rVar = mVar.f5370c;
                    r rVar2 = this.f5370c;
                    if (rVar2 != null ? rVar2.equals(rVar) : rVar == null) {
                        Integer num = mVar.f5371d;
                        Integer num2 = this.f5371d;
                        if (num2 != null ? num2.equals(num) : num == null) {
                            String str = mVar.f5372e;
                            String str2 = this.f5372e;
                            if (str2 != null ? str2.equals(str) : str == null) {
                                List list = mVar.f5373f;
                                List list2 = this.f5373f;
                                if (list2 != null ? list2.equals(list) : list == null) {
                                    x xVar = mVar.f5374g;
                                    x xVar2 = this.f5374g;
                                    if (xVar2 == null) {
                                        if (xVar == null) {
                                            return true;
                                        }
                                    } else if (xVar2.equals(xVar)) {
                                        return true;
                                    }
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
        long j5 = this.f5368a;
        long j6 = this.f5369b;
        int i5 = (((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003;
        r rVar = this.f5370c;
        int hashCode = (i5 ^ (rVar == null ? 0 : rVar.hashCode())) * 1000003;
        Integer num = this.f5371d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f5372e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f5373f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        x xVar = this.f5374g;
        return hashCode4 ^ (xVar != null ? xVar.hashCode() : 0);
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f5368a + ", requestUptimeMs=" + this.f5369b + ", clientInfo=" + this.f5370c + ", logSource=" + this.f5371d + ", logSourceName=" + this.f5372e + ", logEvents=" + this.f5373f + ", qosTier=" + this.f5374g + "}";
    }
}
