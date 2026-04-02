package l;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class b extends j implements Map {

    /* renamed from: i  reason: collision with root package name */
    public a f3665i;

    public b(b bVar) {
        if (bVar != null) {
            int i5 = bVar.f3705d;
            b(this.f3705d + i5);
            if (this.f3705d != 0) {
                for (int i6 = 0; i6 < i5; i6++) {
                    put(bVar.h(i6), bVar.j(i6));
                }
            } else if (i5 > 0) {
                System.arraycopy(bVar.f3703b, 0, this.f3703b, 0, i5);
                System.arraycopy(bVar.f3704c, 0, this.f3704c, 0, i5 << 1);
                this.f3705d = i5;
            }
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.f3665i == null) {
            this.f3665i = new a(0, this);
        }
        a aVar = this.f3665i;
        if (((g) aVar.f2960g) == null) {
            aVar.f2960g = new g(aVar, 0);
        }
        return (g) aVar.f2960g;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f3665i == null) {
            this.f3665i = new a(0, this);
        }
        a aVar = this.f3665i;
        if (((g) aVar.f2961h) == null) {
            aVar.f2961h = new g(aVar, 1);
        }
        return (g) aVar.f2961h;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f3705d);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.f3665i == null) {
            this.f3665i = new a(0, this);
        }
        a aVar = this.f3665i;
        if (aVar.f2962i == null) {
            aVar.f2962i = new i(aVar);
        }
        return aVar.f2962i;
    }
}
