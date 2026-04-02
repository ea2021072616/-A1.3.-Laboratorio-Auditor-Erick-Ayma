package androidx.lifecycle;
/* loaded from: classes.dex */
public enum n {
    DESTROYED,
    INITIALIZED,
    CREATED,
    STARTED,
    RESUMED;

    public final boolean a(n nVar) {
        return compareTo(nVar) >= 0;
    }
}
