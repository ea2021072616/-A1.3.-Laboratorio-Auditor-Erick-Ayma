package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public enum r2 implements n0 {
    f1946c("BROADCAST_ACTION_UNSPECIFIED"),
    f1947d("PURCHASES_UPDATED_ACTION"),
    f1948e("LOCAL_PURCHASES_UPDATED_ACTION"),
    f1949f("ALTERNATIVE_BILLING_ACTION");
    

    /* renamed from: b  reason: collision with root package name */
    public final int f1951b;

    r2(String str) {
        this.f1951b = r2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f1951b);
    }
}
