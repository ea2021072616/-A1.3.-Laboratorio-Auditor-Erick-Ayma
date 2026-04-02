package v2;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final g f5205a = new g();

    public final void a(Exception exc) {
        g gVar = this.f5205a;
        gVar.getClass();
        if (exc == null) {
            throw new NullPointerException("Exception must not be null");
        }
        synchronized (gVar.f5210a) {
            if (gVar.f5212c) {
                return;
            }
            gVar.f5212c = true;
            gVar.f5214e = exc;
            gVar.f5211b.a(gVar);
        }
    }
}
