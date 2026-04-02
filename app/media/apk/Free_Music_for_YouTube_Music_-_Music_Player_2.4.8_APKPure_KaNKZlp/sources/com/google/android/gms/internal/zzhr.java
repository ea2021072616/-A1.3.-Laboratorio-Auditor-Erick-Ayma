package com.google.android.gms.internal;

import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public final class zzhr {
    final long value;
    final String zzazu;
    final int zzazv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhr(long j, String str, int i) {
        this.value = j;
        this.zzazu = str;
        this.zzazv = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof zzhr)) {
            return false;
        }
        return ((zzhr) obj).value == this.value && ((zzhr) obj).zzazv == this.zzazv;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
