package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class j0 implements i1 {

    /* renamed from: a  reason: collision with root package name */
    public static final j0 f1899a = new j0();

    @Override // com.google.android.gms.internal.play_billing.i1
    public final h1 a(Class cls) {
        if (l0.class.isAssignableFrom(cls)) {
            try {
                return (h1) l0.e(cls.asSubclass(l0.class)).l(3);
            } catch (Exception e5) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e5);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.play_billing.i1
    public final boolean b(Class cls) {
        return l0.class.isAssignableFrom(cls);
    }
}
