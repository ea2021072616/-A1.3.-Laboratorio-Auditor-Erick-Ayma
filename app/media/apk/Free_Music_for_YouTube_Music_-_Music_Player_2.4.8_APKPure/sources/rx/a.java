package rx;
/* compiled from: BackpressureOverflow.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d f5215a = c.f5232a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f5216b = f5215a;

    /* renamed from: c  reason: collision with root package name */
    public static final d f5217c = b.f5222a;
    public static final d d = C0104a.f5218a;

    /* compiled from: BackpressureOverflow.java */
    /* loaded from: classes2.dex */
    public interface d {
        boolean a() throws rx.b.c;
    }

    /* compiled from: BackpressureOverflow.java */
    /* loaded from: classes2.dex */
    static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        static final b f5222a = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean a() {
            return true;
        }
    }

    /* compiled from: BackpressureOverflow.java */
    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0104a implements d {

        /* renamed from: a  reason: collision with root package name */
        static final C0104a f5218a = new C0104a();

        private C0104a() {
        }

        @Override // rx.a.d
        public boolean a() {
            return false;
        }
    }

    /* compiled from: BackpressureOverflow.java */
    /* loaded from: classes2.dex */
    static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        static final c f5232a = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean a() throws rx.b.c {
            throw new rx.b.c("Overflowed buffer");
        }
    }
}
