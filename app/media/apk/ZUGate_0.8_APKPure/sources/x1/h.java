package x1;

import androidx.appcompat.widget.x;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f5455a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f5456b;

    /* renamed from: c  reason: collision with root package name */
    public final l f5457c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5458d;

    /* renamed from: e  reason: collision with root package name */
    public final long f5459e;

    /* renamed from: f  reason: collision with root package name */
    public final Map f5460f;

    public h(String str, Integer num, l lVar, long j5, long j6, Map map) {
        this.f5455a = str;
        this.f5456b = num;
        this.f5457c = lVar;
        this.f5458d = j5;
        this.f5459e = j6;
        this.f5460f = map;
    }

    public final String a(String str) {
        String str2 = (String) this.f5460f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f5460f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final x c() {
        x xVar = new x(2);
        xVar.j(this.f5455a);
        xVar.f571b = this.f5456b;
        xVar.h(this.f5457c);
        xVar.f573d = Long.valueOf(this.f5458d);
        xVar.f574e = Long.valueOf(this.f5459e);
        xVar.f575f = new HashMap(this.f5460f);
        return xVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f5455a.equals(hVar.f5455a)) {
                Integer num = hVar.f5456b;
                Integer num2 = this.f5456b;
                if (num2 != null ? num2.equals(num) : num == null) {
                    if (this.f5457c.equals(hVar.f5457c) && this.f5458d == hVar.f5458d && this.f5459e == hVar.f5459e && this.f5460f.equals(hVar.f5460f)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f5455a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f5456b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j5 = this.f5458d;
        long j6 = this.f5459e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.f5457c.hashCode()) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f5460f.hashCode();
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f5455a + ", code=" + this.f5456b + ", encodedPayload=" + this.f5457c + ", eventMillis=" + this.f5458d + ", uptimeMillis=" + this.f5459e + ", autoMetadata=" + this.f5460f + "}";
    }
}
