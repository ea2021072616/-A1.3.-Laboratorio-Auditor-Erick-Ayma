package j;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class g implements Iterable {

    /* renamed from: b  reason: collision with root package name */
    public c f3429b;

    /* renamed from: c  reason: collision with root package name */
    public c f3430c;

    /* renamed from: d  reason: collision with root package name */
    public final WeakHashMap f3431d = new WeakHashMap();

    /* renamed from: e  reason: collision with root package name */
    public int f3432e = 0;

    public c e(Object obj) {
        c cVar = this.f3429b;
        while (cVar != null && !cVar.f3420b.equals(obj)) {
            cVar = cVar.f3422d;
        }
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r3.hasNext() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (((j.e) r7).hasNext() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof j.g
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            j.g r7 = (j.g) r7
            int r1 = r6.f3432e
            int r3 = r7.f3432e
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            j.e r3 = (j.e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            j.e r4 = (j.e) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            j.e r7 = (j.e) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            goto L54
        L53:
            r0 = r2
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j.g.equals(java.lang.Object):boolean");
    }

    public Object f(Object obj) {
        c e5 = e(obj);
        if (e5 == null) {
            return null;
        }
        this.f3432e--;
        WeakHashMap weakHashMap = this.f3431d;
        if (!weakHashMap.isEmpty()) {
            for (f fVar : weakHashMap.keySet()) {
                fVar.a(e5);
            }
        }
        c cVar = e5.f3423e;
        if (cVar != null) {
            cVar.f3422d = e5.f3422d;
        } else {
            this.f3429b = e5.f3422d;
        }
        c cVar2 = e5.f3422d;
        if (cVar2 != null) {
            cVar2.f3423e = cVar;
        } else {
            this.f3430c = cVar;
        }
        e5.f3422d = null;
        e5.f3423e = null;
        return e5.f3421c;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i5 = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return i5;
            }
            i5 += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        b bVar = new b(this.f3429b, this.f3430c, 0);
        this.f3431d.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) eVar.next()).toString());
            if (eVar.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
