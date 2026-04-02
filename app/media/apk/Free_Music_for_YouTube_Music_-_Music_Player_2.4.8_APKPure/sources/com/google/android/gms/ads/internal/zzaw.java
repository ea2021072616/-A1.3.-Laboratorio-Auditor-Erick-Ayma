package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzrn;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
final class zzaw implements zzrn {
    private /* synthetic */ CountDownLatch zzamw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaw(CountDownLatch countDownLatch) {
        this.zzamw = countDownLatch;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        zzafx.zzcs("Adapter returned an ad, but assets substitution failed");
        this.zzamw.countDown();
        zzakkVar.destroy();
    }
}
