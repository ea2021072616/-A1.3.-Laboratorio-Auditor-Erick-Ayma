package j4;

import androidx.activity.z;
/* loaded from: classes.dex */
public abstract class f extends a implements e, n4.c {

    /* renamed from: h  reason: collision with root package name */
    public final int f3519h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3520i;

    public f(z zVar) {
        super(zVar, z.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", false);
        this.f3519h = 0;
        this.f3520i = 0;
    }

    @Override // j4.e
    public final int b() {
        return this.f3519h;
    }

    public final n4.a d() {
        i.f3523a.getClass();
        return this;
    }

    /* renamed from: e */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f3513e.equals(fVar.f3513e) && this.f3514f.equals(fVar.f3514f) && this.f3520i == fVar.f3520i && this.f3519h == fVar.f3519h && e4.e.a(this.f3511c, fVar.f3511c) && e4.e.a(c(), fVar.c());
        } else if (obj instanceof n4.c) {
            n4.a aVar = this.f3510b;
            if (aVar == null) {
                d();
                this.f3510b = this;
                aVar = this;
            }
            return obj.equals(aVar);
        } else {
            return false;
        }
    }

    /* renamed from: f */
    public final int hashCode() {
        return this.f3514f.hashCode() + ((this.f3513e.hashCode() + (c() == null ? 0 : c().hashCode() * 31)) * 31);
    }

    /* renamed from: g */
    public final String toString() {
        n4.a aVar = this.f3510b;
        if (aVar == null) {
            d();
            this.f3510b = this;
            aVar = this;
        }
        if (aVar != this) {
            return aVar.toString();
        }
        String str = this.f3513e;
        if ("<init>".equals(str)) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + str + " (Kotlin reflection is not available)";
    }
}
