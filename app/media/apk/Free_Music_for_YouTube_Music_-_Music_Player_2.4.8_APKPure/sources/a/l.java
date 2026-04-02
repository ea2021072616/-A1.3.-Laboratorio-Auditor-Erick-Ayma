package a;

import a.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UnobservedErrorNotifier.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private j<?> f41a;

    public l(j<?> jVar) {
        this.f41a = jVar;
    }

    protected void finalize() throws Throwable {
        j.b a2;
        try {
            j<?> jVar = this.f41a;
            if (jVar != null && (a2 = j.a()) != null) {
                a2.a(jVar, new m(jVar.g()));
            }
        } finally {
            super.finalize();
        }
    }

    public void a() {
        this.f41a = null;
    }
}
