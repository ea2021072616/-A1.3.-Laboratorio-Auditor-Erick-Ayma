package k2;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f3560a;

    /* renamed from: b  reason: collision with root package name */
    public final d.e f3561b;

    /* renamed from: c  reason: collision with root package name */
    public final j2.a f3562c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3563d;

    public a(d.e eVar, String str) {
        l2.l lVar = l2.l.f3868b;
        this.f3561b = eVar;
        this.f3562c = lVar;
        this.f3563d = str;
        this.f3560a = Arrays.hashCode(new Object[]{eVar, lVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return b4.j.p(this.f3561b, aVar.f3561b) && b4.j.p(this.f3562c, aVar.f3562c) && b4.j.p(this.f3563d, aVar.f3563d);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3560a;
    }
}
