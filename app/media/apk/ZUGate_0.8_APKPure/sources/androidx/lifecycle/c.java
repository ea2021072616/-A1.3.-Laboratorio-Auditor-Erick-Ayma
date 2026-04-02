package androidx.lifecycle;

import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f1098a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f1099b;

    public c(int i5, Method method) {
        this.f1098a = i5;
        this.f1099b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f1098a == cVar.f1098a && this.f1099b.getName().equals(cVar.f1099b.getName());
        }
        return false;
    }

    public final int hashCode() {
        return this.f1099b.getName().hashCode() + (this.f1098a * 31);
    }
}
