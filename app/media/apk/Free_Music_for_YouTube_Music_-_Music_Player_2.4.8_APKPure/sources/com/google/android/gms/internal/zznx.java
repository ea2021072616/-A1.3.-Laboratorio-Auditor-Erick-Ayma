package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zznx implements Runnable {
    private /* synthetic */ zznw zzbsc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznx(zznw zznwVar) {
        this.zzbsc = zznwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzoe zzoeVar;
        zzoe zzoeVar2;
        zzoe zzoeVar3;
        zzoeVar = this.zzbsc.zzbsb;
        if (zzoeVar != null) {
            zzoeVar2 = this.zzbsc.zzbsb;
            zzoeVar2.zzjx();
            zzoeVar3 = this.zzbsc.zzbsb;
            zzoeVar3.zzjv();
        }
        zznw.zza(this.zzbsc, null);
    }
}
