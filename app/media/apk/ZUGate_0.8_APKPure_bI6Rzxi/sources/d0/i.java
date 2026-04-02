package d0;

import android.os.LocaleList;
/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    public final LocaleList f2505a;

    public i(Object obj) {
        this.f2505a = (LocaleList) obj;
    }

    @Override // d0.h
    public final Object a() {
        return this.f2505a;
    }

    public final boolean equals(Object obj) {
        return this.f2505a.equals(((h) obj).a());
    }

    public final int hashCode() {
        return this.f2505a.hashCode();
    }

    public final String toString() {
        return this.f2505a.toString();
    }
}
