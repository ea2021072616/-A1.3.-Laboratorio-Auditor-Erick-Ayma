package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class y0 extends a1 {

    /* renamed from: c  reason: collision with root package name */
    public static final Class f1992c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    @Override // com.google.android.gms.internal.play_billing.a1
    public final void a(long j5, Object obj) {
        Object unmodifiableList;
        List list = (List) f2.j(j5, obj);
        if (list instanceof x0) {
            unmodifiableList = ((x0) list).a();
        } else {
            if (f1992c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof p1) && (list instanceof r0)) {
                t tVar = (t) ((r0) list);
                boolean z4 = tVar.f1959b;
                if (z4 && z4) {
                    tVar.f1959b = false;
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        f2.r(j5, obj, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.a1
    public final void b(long j5, Object obj, Object obj2) {
        w0 w0Var;
        List list = (List) f2.j(j5, obj2);
        int size = list.size();
        List list2 = (List) f2.j(j5, obj);
        if (list2.isEmpty()) {
            list2 = list2 instanceof x0 ? new w0(size) : ((list2 instanceof p1) && (list2 instanceof r0)) ? ((r0) list2).b(size) : new ArrayList(size);
            f2.r(j5, obj, list2);
        } else {
            if (f1992c.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size);
                arrayList.addAll(list2);
                f2.r(j5, obj, arrayList);
                w0Var = arrayList;
            } else if (list2 instanceof a2) {
                w0 w0Var2 = new w0(list2.size() + size);
                w0Var2.addAll(w0Var2.size(), (a2) list2);
                f2.r(j5, obj, w0Var2);
                w0Var = w0Var2;
            } else if ((list2 instanceof p1) && (list2 instanceof r0)) {
                r0 r0Var = (r0) list2;
                if (!((t) r0Var).f1959b) {
                    list2 = r0Var.b(list2.size() + size);
                    f2.r(j5, obj, list2);
                }
            }
            list2 = w0Var;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        f2.r(j5, obj, list);
    }
}
