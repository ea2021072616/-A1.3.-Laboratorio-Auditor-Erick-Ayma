package j4;

import i4.k;
import i4.l;
import i4.m;
import i4.n;
import i4.o;
import i4.p;
import i4.q;
import i4.r;
import i4.s;
import i4.t;
import i4.u;
import i4.v;
import i4.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class c implements n4.b, b {

    /* renamed from: b  reason: collision with root package name */
    public static final Map f3516b;

    /* renamed from: c  reason: collision with root package name */
    public static final LinkedHashMap f3517c;

    /* renamed from: a  reason: collision with root package name */
    public final Class f3518a;

    static {
        int i5 = 0;
        List asList = Arrays.asList(i4.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, i4.b.class, i4.c.class, i4.d.class, i4.e.class, i4.f.class, i4.g.class, i4.h.class, i4.i.class, i4.j.class, k.class, m.class, n.class, o.class);
        e4.e.e(asList, "asList(this)");
        ArrayList arrayList = new ArrayList(asList.size());
        for (Object obj : asList) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new a4.a((Class) obj, Integer.valueOf(i5)));
            i5 = i6;
        }
        f3516b = b4.i.c0(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        e4.e.e(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            e4.e.e(str, "kotlinName");
            sb.append(p4.d.K0(str));
            sb.append("CompanionObject");
            hashMap3.put(sb.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : f3516b.entrySet()) {
            int intValue = ((Number) entry.getValue()).intValue();
            String name = ((Class) entry.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(p2.a.H(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), p4.d.K0((String) entry2.getValue()));
        }
        f3517c = linkedHashMap;
    }

    public c(Class cls) {
        e4.e.f(cls, "jClass");
        this.f3518a = cls;
    }

    @Override // j4.b
    public final Class a() {
        return this.f3518a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && e4.e.a(e4.e.q(this), e4.e.q((n4.b) obj));
    }

    public final int hashCode() {
        return e4.e.q(this).hashCode();
    }

    public final String toString() {
        return this.f3518a.toString() + " (Kotlin reflection is not available)";
    }
}
