package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.zzafv;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzzt;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzt
/* loaded from: classes.dex */
public final class zzao extends zzafv {
    final /* synthetic */ zzam zzapu;
    private final int zzapv;

    public zzao(zzam zzamVar, int i) {
        this.zzapu = zzamVar;
        this.zzapv = i;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        boolean z;
        float f;
        boolean z2;
        boolean z3 = this.zzapu.zzams.zzapy;
        boolean zzcz = this.zzapu.zzcz();
        z = this.zzapu.zzapo;
        f = this.zzapu.zzapp;
        int i = this.zzapu.zzams.zzapy ? this.zzapv : -1;
        z2 = this.zzapu.zzapq;
        zzaq zzaqVar = new zzaq(z3, zzcz, z, f, i, z2);
        int requestedOrientation = this.zzapu.zzams.zzato.zzcgz.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.zzapu.zzams.zzato.orientation;
        }
        zzahf.zzdbo.post(new zzap(this, new AdOverlayInfoParcel(this.zzapu, this.zzapu, this.zzapu, this.zzapu.zzams.zzato.zzcgz, requestedOrientation, this.zzapu.zzams.zzatj, this.zzapu.zzams.zzato.zzcpt, zzaqVar)));
    }
}
