package androidx.lifecycle;
/* loaded from: classes.dex */
public final class k {
    public static m a(n nVar) {
        e4.e.f(nVar, "state");
        int ordinal = nVar.ordinal();
        if (ordinal != 2) {
            if (ordinal != 3) {
                if (ordinal != 4) {
                    return null;
                }
                return m.ON_PAUSE;
            }
            return m.ON_STOP;
        }
        return m.ON_DESTROY;
    }

    public static m b(n nVar) {
        e4.e.f(nVar, "state");
        int ordinal = nVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    return null;
                }
                return m.ON_RESUME;
            }
            return m.ON_START;
        }
        return m.ON_CREATE;
    }

    public static m c(n nVar) {
        e4.e.f(nVar, "state");
        int ordinal = nVar.ordinal();
        if (ordinal != 2) {
            if (ordinal != 3) {
                if (ordinal != 4) {
                    return null;
                }
                return m.ON_RESUME;
            }
            return m.ON_START;
        }
        return m.ON_CREATE;
    }
}
