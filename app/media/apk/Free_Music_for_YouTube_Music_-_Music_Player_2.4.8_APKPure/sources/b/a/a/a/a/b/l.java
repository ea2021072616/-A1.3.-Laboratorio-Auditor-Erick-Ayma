package b.a.a.a.a.b;
/* compiled from: DeliveryMechanism.java */
/* loaded from: classes.dex */
public enum l {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    private final int e;

    l(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.e);
    }

    public static l a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
