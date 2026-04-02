package com.google.android.gms.ads.internal;

import android.view.View;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzrn;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
final class zzav implements zzrn {
    private /* synthetic */ CountDownLatch zzamw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(CountDownLatch countDownLatch) {
        this.zzamw = countDownLatch;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        this.zzamw.countDown();
        if (zzakkVar == null) {
            throw null;
        }
        ((View) zzakkVar).setVisibility(0);
    }
}
