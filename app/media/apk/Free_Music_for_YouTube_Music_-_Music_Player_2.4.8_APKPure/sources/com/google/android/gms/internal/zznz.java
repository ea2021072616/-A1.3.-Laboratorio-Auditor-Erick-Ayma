package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zznz implements Runnable {
    private /* synthetic */ zzny zzbsf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznz(zzny zznyVar) {
        this.zzbsf = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzoe zzoeVar;
        zzoe zzoeVar2;
        zzoe zzoeVar3;
        zzoeVar = this.zzbsf.zzbsb;
        if (zzoeVar != null) {
            zzoeVar2 = this.zzbsf.zzbsb;
            zzoeVar2.zzjx();
            zzoeVar3 = this.zzbsf.zzbsb;
            zzoeVar3.zzjv();
        }
        zzny.zza(this.zzbsf, null);
    }
}
