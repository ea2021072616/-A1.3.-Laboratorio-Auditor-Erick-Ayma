package j;

import java.util.Map;
/* loaded from: classes.dex */
public final class c implements Map.Entry {

    /* renamed from: b  reason: collision with root package name */
    public final Object f3420b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f3421c;

    /* renamed from: d  reason: collision with root package name */
    public c f3422d;

    /* renamed from: e  reason: collision with root package name */
    public c f3423e;

    public c(Object obj, Object obj2) {
        this.f3420b = obj;
        this.f3421c = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f3420b.equals(cVar.f3420b) && this.f3421c.equals(cVar.f3421c);
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f3420b;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f3421c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f3420b.hashCode() ^ this.f3421c.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f3420b + "=" + this.f3421c;
    }
}
