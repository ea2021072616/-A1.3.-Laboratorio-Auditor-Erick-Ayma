package okhttp3.internal.http2;

import c.f;
import okhttp3.internal.Util;
/* loaded from: classes2.dex */
public final class Header {
    final int hpackSize;
    public final f name;
    public final f value;
    public static final f PSEUDO_PREFIX = f.a(":");
    public static final f RESPONSE_STATUS = f.a(":status");
    public static final f TARGET_METHOD = f.a(":method");
    public static final f TARGET_PATH = f.a(":path");
    public static final f TARGET_SCHEME = f.a(":scheme");
    public static final f TARGET_AUTHORITY = f.a(":authority");

    public Header(String str, String str2) {
        this(f.a(str), f.a(str2));
    }

    public Header(f fVar, String str) {
        this(fVar, f.a(str));
    }

    public Header(f fVar, f fVar2) {
        this.name = fVar;
        this.value = fVar2;
        this.hpackSize = fVar.h() + 32 + fVar2.h();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Header) {
            Header header = (Header) obj;
            return this.name.equals(header.name) && this.value.equals(header.value);
        }
        return false;
    }

    public int hashCode() {
        return ((this.name.hashCode() + 527) * 31) + this.value.hashCode();
    }

    public String toString() {
        return Util.format("%s: %s", this.name.a(), this.value.a());
    }
}
