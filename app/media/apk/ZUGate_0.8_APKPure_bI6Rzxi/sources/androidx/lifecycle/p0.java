package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public final class p0 extends u0 implements t0 {

    /* renamed from: g  reason: collision with root package name */
    public final Application f1135g;

    /* renamed from: h  reason: collision with root package name */
    public final s0 f1136h;

    /* renamed from: i  reason: collision with root package name */
    public final Bundle f1137i;

    /* renamed from: j  reason: collision with root package name */
    public final o f1138j;

    /* renamed from: k  reason: collision with root package name */
    public final b1.d f1139k;

    public p0(Application application, b1.f fVar, Bundle bundle) {
        s0 s0Var;
        e4.e.f(fVar, "owner");
        this.f1139k = fVar.getSavedStateRegistry();
        this.f1138j = fVar.getLifecycle();
        this.f1137i = bundle;
        this.f1135g = application;
        if (application != null) {
            if (s0.o == null) {
                s0.o = new s0(application);
            }
            s0Var = s0.o;
            e4.e.c(s0Var);
        } else {
            s0Var = new s0(null);
        }
        this.f1136h = s0Var;
    }

    @Override // androidx.lifecycle.t0
    public final r0 a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.lifecycle.r0 b(java.lang.Class r8, java.lang.String r9) {
        /*
            r7 = this;
            androidx.lifecycle.o r0 = r7.f1138j
            if (r0 == 0) goto La8
            java.lang.Class<androidx.lifecycle.a> r1 = androidx.lifecycle.a.class
            boolean r1 = r1.isAssignableFrom(r8)
            if (r1 == 0) goto L17
            android.app.Application r2 = r7.f1135g
            if (r2 == 0) goto L17
            java.util.List r2 = androidx.lifecycle.q0.f1141a
            java.lang.reflect.Constructor r2 = androidx.lifecycle.q0.a(r8, r2)
            goto L1d
        L17:
            java.util.List r2 = androidx.lifecycle.q0.f1142b
            java.lang.reflect.Constructor r2 = androidx.lifecycle.q0.a(r8, r2)
        L1d:
            if (r2 != 0) goto L33
            android.app.Application r9 = r7.f1135g
            if (r9 == 0) goto L2a
            androidx.lifecycle.s0 r9 = r7.f1136h
            androidx.lifecycle.r0 r8 = r9.a(r8)
            goto L32
        L2a:
            l2.i r9 = p3.e.g()
            androidx.lifecycle.r0 r8 = r9.a(r8)
        L32:
            return r8
        L33:
            b1.d r3 = r7.f1139k
            e4.e.c(r3)
            android.os.Bundle r4 = r7.f1137i
            android.os.Bundle r5 = r3.a(r9)
            java.lang.Class[] r6 = androidx.lifecycle.m0.f1118f
            androidx.lifecycle.m0 r4 = p3.e.d(r5, r4)
            androidx.lifecycle.SavedStateHandleController r5 = new androidx.lifecycle.SavedStateHandleController
            r5.<init>(r9, r4)
            r5.c(r0, r3)
            r9 = r0
            androidx.lifecycle.v r9 = (androidx.lifecycle.v) r9
            androidx.lifecycle.n r9 = r9.f1151c
            androidx.lifecycle.n r6 = androidx.lifecycle.n.INITIALIZED
            if (r9 == r6) goto L6c
            androidx.lifecycle.n r6 = androidx.lifecycle.n.STARTED
            int r9 = r9.compareTo(r6)
            if (r9 < 0) goto L5f
            r9 = 1
            goto L60
        L5f:
            r9 = 0
        L60:
            if (r9 == 0) goto L63
            goto L6c
        L63:
            androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1 r9 = new androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
            r9.<init>(r0, r3)
            r0.a(r9)
            goto L6f
        L6c:
            r3.d()
        L6f:
            if (r1 == 0) goto L7e
            android.app.Application r9 = r7.f1135g
            if (r9 == 0) goto L7e
            java.lang.Object[] r9 = new java.lang.Object[]{r9, r4}
            androidx.lifecycle.r0 r8 = androidx.lifecycle.q0.b(r8, r2, r9)
            goto L86
        L7e:
            java.lang.Object[] r9 = new java.lang.Object[]{r4}
            androidx.lifecycle.r0 r8 = androidx.lifecycle.q0.b(r8, r2, r9)
        L86:
            java.lang.String r9 = "androidx.lifecycle.savedstate.vm.tag"
            java.util.HashMap r0 = r8.f1143a
            monitor-enter(r0)
            java.util.HashMap r1 = r8.f1143a     // Catch: java.lang.Throwable -> La5
            java.lang.Object r1 = r1.get(r9)     // Catch: java.lang.Throwable -> La5
            if (r1 != 0) goto L98
            java.util.HashMap r2 = r8.f1143a     // Catch: java.lang.Throwable -> La5
            r2.put(r9, r5)     // Catch: java.lang.Throwable -> La5
        L98:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La5
            if (r1 != 0) goto L9c
            goto L9d
        L9c:
            r5 = r1
        L9d:
            boolean r9 = r8.f1145c
            if (r9 == 0) goto La4
            androidx.lifecycle.r0.a(r5)
        La4:
            return r8
        La5:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La5
            throw r8
        La8:
            java.lang.UnsupportedOperationException r8 = new java.lang.UnsupportedOperationException
            java.lang.String r9 = "SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras)."
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.p0.b(java.lang.Class, java.lang.String):androidx.lifecycle.r0");
    }

    @Override // androidx.lifecycle.t0
    public final r0 c(Class cls, w0.e eVar) {
        l2.i iVar = l2.i.f3856j;
        LinkedHashMap linkedHashMap = eVar.f5293a;
        String str = (String) linkedHashMap.get(iVar);
        if (str != null) {
            if (linkedHashMap.get(b4.j.f1662a) == null || linkedHashMap.get(b4.j.f1663b) == null) {
                if (this.f1138j != null) {
                    return b(cls, str);
                }
                throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
            }
            Application application = (Application) linkedHashMap.get(l2.i.f3855i);
            boolean isAssignableFrom = a.class.isAssignableFrom(cls);
            Constructor a5 = (!isAssignableFrom || application == null) ? q0.a(cls, q0.f1142b) : q0.a(cls, q0.f1141a);
            return a5 == null ? this.f1136h.c(cls, eVar) : (!isAssignableFrom || application == null) ? q0.b(cls, a5, b4.j.l(eVar)) : q0.b(cls, a5, application, b4.j.l(eVar));
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }
}
