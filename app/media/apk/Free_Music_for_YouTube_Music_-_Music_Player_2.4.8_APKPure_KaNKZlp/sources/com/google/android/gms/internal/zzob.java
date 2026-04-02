package com.google.android.gms.internal;

import android.view.MotionEvent;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
/* loaded from: classes2.dex */
final class zzob implements zzoc {
    private /* synthetic */ zzoa zzbsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzob(zzoa zzoaVar) {
        this.zzbsj = zzoaVar;
    }

    @Override // com.google.android.gms.internal.zzoc
    public final void zzc(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.zzoc
    public final void zzjq() {
        this.zzbsj.performClick(NativeCustomTemplateAd.ASSET_NAME_VIDEO);
    }
}
