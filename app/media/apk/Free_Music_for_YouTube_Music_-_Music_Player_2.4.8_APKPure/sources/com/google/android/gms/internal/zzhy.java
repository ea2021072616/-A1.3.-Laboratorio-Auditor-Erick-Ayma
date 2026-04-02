package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzhy implements zzhc {
    private /* synthetic */ zzhw zzbai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhy(zzhw zzhwVar) {
        this.zzbai = zzhwVar;
    }

    @Override // com.google.android.gms.internal.zzhc
    public final void zzg(boolean z) {
        if (z) {
            this.zzbai.connect();
        } else {
            this.zzbai.disconnect();
        }
    }
}
