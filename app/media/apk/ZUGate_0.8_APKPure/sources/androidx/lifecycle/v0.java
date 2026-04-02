package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f1157a = new LinkedHashMap();

    public final void a() {
        for (r0 r0Var : this.f1157a.values()) {
            r0Var.f1145c = true;
            HashMap hashMap = r0Var.f1143a;
            if (hashMap != null) {
                synchronized (hashMap) {
                    for (Object obj : r0Var.f1143a.values()) {
                        r0.a(obj);
                    }
                }
            }
            LinkedHashSet linkedHashSet = r0Var.f1144b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    for (Closeable closeable : r0Var.f1144b) {
                        r0.a(closeable);
                    }
                }
            }
            r0Var.b();
        }
        this.f1157a.clear();
    }
}
