package rx.internal.util;
/* compiled from: PlatformDependent.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final int f5595a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f5596b;

    static {
        f5596b = f5595a != 0;
    }

    public static boolean a() {
        return f5596b;
    }

    public static int b() {
        return f5595a;
    }

    private static int c() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }
}
