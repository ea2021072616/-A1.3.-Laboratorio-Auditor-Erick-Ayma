package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzabv implements zzaka {
    private /* synthetic */ zzabt zzcse;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabv(zzabt zzabtVar) {
        this.zzcse = zzabtVar;
    }

    @Override // com.google.android.gms.internal.zzaka
    public final void run() {
        zzafx.e("JS engine could not be obtained. Cancelling ad request");
        this.zzcse.zzcsa.fail();
    }
}
