package com.google.android.gms.common.api.internal;

import android.os.Bundle;
/* loaded from: classes.dex */
final class zzdc implements Runnable {
    private /* synthetic */ String zzao;
    private /* synthetic */ LifecycleCallback zzfom;
    private /* synthetic */ zzdb zzfpa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdc(zzdb zzdbVar, LifecycleCallback lifecycleCallback, String str) {
        this.zzfpa = zzdbVar;
        this.zzfom = lifecycleCallback;
        this.zzao = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        i = this.zzfpa.zzbyx;
        if (i > 0) {
            LifecycleCallback lifecycleCallback = this.zzfom;
            bundle = this.zzfpa.zzfol;
            if (bundle != null) {
                bundle3 = this.zzfpa.zzfol;
                bundle2 = bundle3.getBundle(this.zzao);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i2 = this.zzfpa.zzbyx;
        if (i2 >= 2) {
            this.zzfom.onStart();
        }
        i3 = this.zzfpa.zzbyx;
        if (i3 >= 3) {
            this.zzfom.onResume();
        }
        i4 = this.zzfpa.zzbyx;
        if (i4 >= 4) {
            this.zzfom.onStop();
        }
        i5 = this.zzfpa.zzbyx;
        if (i5 >= 5) {
            this.zzfom.onDestroy();
        }
    }
}
