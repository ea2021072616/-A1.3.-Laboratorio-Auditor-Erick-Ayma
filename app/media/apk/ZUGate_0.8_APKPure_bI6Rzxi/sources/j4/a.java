package j4;

import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class a implements n4.a, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public transient n4.a f3510b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f3511c;

    /* renamed from: d  reason: collision with root package name */
    public final Class f3512d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3513e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3514f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3515g;

    public a(Object obj, Class cls, String str, String str2, boolean z4) {
        this.f3511c = obj;
        this.f3512d = cls;
        this.f3513e = str;
        this.f3514f = str2;
        this.f3515g = z4;
    }

    public final b c() {
        b cVar;
        Class cls = this.f3512d;
        if (cls == null) {
            return null;
        }
        if (this.f3515g) {
            i.f3523a.getClass();
            cVar = new h(cls);
        } else {
            i.f3523a.getClass();
            cVar = new c(cls);
        }
        return cVar;
    }
}
