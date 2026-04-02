package androidx.lifecycle;
/* loaded from: classes.dex */
public interface t0 {
    default r0 a(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    default r0 c(Class cls, w0.e eVar) {
        return a(cls);
    }
}
