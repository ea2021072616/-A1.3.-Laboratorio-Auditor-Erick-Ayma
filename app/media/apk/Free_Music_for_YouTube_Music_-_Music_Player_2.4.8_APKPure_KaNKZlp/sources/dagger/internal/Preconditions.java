package dagger.internal;
/* loaded from: classes2.dex */
public final class Preconditions {
    public static <T> T checkNotNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    private Preconditions() {
    }
}
