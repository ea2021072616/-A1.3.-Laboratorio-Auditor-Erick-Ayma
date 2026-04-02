package b2;

import android.content.Context;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class d implements z1.b {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f1629g;

    /* renamed from: h  reason: collision with root package name */
    public final z3.a f1630h;

    public /* synthetic */ d(z3.a aVar, int i5) {
        this.f1629g = i5;
        this.f1630h = aVar;
    }

    @Override // z3.a
    public final Object get() {
        int i5 = this.f1629g;
        z3.a aVar = this.f1630h;
        switch (i5) {
            case 0:
                f2.a aVar2 = (f2.a) aVar.get();
                HashMap hashMap = new HashMap();
                u1.c cVar = u1.c.DEFAULT;
                d.e eVar = new d.e(10);
                Set emptySet = Collections.emptySet();
                if (emptySet != null) {
                    eVar.f2323j = emptySet;
                    eVar.f2321h = 30000L;
                    eVar.f2322i = 86400000L;
                    hashMap.put(cVar, eVar.a());
                    u1.c cVar2 = u1.c.HIGHEST;
                    d.e eVar2 = new d.e(10);
                    Set emptySet2 = Collections.emptySet();
                    if (emptySet2 != null) {
                        eVar2.f2323j = emptySet2;
                        eVar2.f2321h = 1000L;
                        eVar2.f2322i = 86400000L;
                        hashMap.put(cVar2, eVar2.a());
                        u1.c cVar3 = u1.c.VERY_LOW;
                        d.e eVar3 = new d.e(10);
                        Set emptySet3 = Collections.emptySet();
                        if (emptySet3 != null) {
                            eVar3.f2323j = emptySet3;
                            eVar3.f2321h = 86400000L;
                            eVar3.f2322i = 86400000L;
                            Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(c2.e.DEVICE_IDLE)));
                            if (unmodifiableSet != null) {
                                eVar3.f2323j = unmodifiableSet;
                                hashMap.put(cVar3, eVar3.a());
                                if (aVar2 != null) {
                                    if (hashMap.keySet().size() >= u1.c.values().length) {
                                        new HashMap();
                                        return new c2.b(aVar2, hashMap);
                                    }
                                    throw new IllegalStateException("Not all priorities have been configured");
                                }
                                throw new NullPointerException("missing required property: clock");
                            }
                            throw new NullPointerException("Null flags");
                        }
                        throw new NullPointerException("Null flags");
                    }
                    throw new NullPointerException("Null flags");
                }
                throw new NullPointerException("Null flags");
            default:
                String packageName = ((Context) aVar.get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        }
    }
}
