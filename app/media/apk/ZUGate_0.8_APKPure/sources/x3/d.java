package x3;

import java.util.Date;
import java.util.HashMap;
import v3.f;
import v3.g;
/* loaded from: classes.dex */
public final class d implements w3.a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f5498e = new a(0);

    /* renamed from: f  reason: collision with root package name */
    public static final b f5499f = new f() { // from class: x3.b
        @Override // v3.a
        public final void a(Object obj, Object obj2) {
            switch (r1) {
                case 0:
                    ((g) obj2).a((String) obj);
                    return;
                default:
                    ((g) obj2).b(((Boolean) obj).booleanValue());
                    return;
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final b f5500g = new f() { // from class: x3.b
        @Override // v3.a
        public final void a(Object obj, Object obj2) {
            switch (r1) {
                case 0:
                    ((g) obj2).a((String) obj);
                    return;
                default:
                    ((g) obj2).b(((Boolean) obj).booleanValue());
                    return;
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public static final c f5501h = new c();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f5502a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f5503b;

    /* renamed from: c  reason: collision with root package name */
    public final a f5504c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5505d;

    public d() {
        HashMap hashMap = new HashMap();
        this.f5502a = hashMap;
        HashMap hashMap2 = new HashMap();
        this.f5503b = hashMap2;
        this.f5504c = f5498e;
        this.f5505d = false;
        hashMap2.put(String.class, f5499f);
        hashMap.remove(String.class);
        hashMap2.put(Boolean.class, f5500g);
        hashMap.remove(Boolean.class);
        hashMap2.put(Date.class, f5501h);
        hashMap.remove(Date.class);
    }

    public final w3.a a(Class cls, v3.d dVar) {
        this.f5502a.put(cls, dVar);
        this.f5503b.remove(cls);
        return this;
    }
}
