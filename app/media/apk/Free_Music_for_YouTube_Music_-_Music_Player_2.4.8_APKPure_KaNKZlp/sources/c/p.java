package c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentPool.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    static o f314a;

    /* renamed from: b  reason: collision with root package name */
    static long f315b;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a() {
        synchronized (p.class) {
            if (f314a != null) {
                o oVar = f314a;
                f314a = oVar.f;
                oVar.f = null;
                f315b -= 8192;
                return oVar;
            }
            return new o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(o oVar) {
        if (oVar.f != null || oVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (!oVar.d) {
            synchronized (p.class) {
                if (f315b + 8192 <= 65536) {
                    f315b += 8192;
                    oVar.f = f314a;
                    oVar.f313c = 0;
                    oVar.f312b = 0;
                    f314a = oVar;
                }
            }
        }
    }
}
