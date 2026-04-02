package v3;

import androidx.appcompat.widget.d0;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f5215a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f5216b;

    public c(String str, Map map) {
        this.f5215a = str;
        this.f5216b = map;
    }

    public static d0 a(String str) {
        return new d0(26, str);
    }

    public static c b(String str) {
        return new c(str, Collections.emptyMap());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f5215a.equals(cVar.f5215a) && this.f5216b.equals(cVar.f5216b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5216b.hashCode() + (this.f5215a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f5215a + ", properties=" + this.f5216b.values() + "}";
    }
}
