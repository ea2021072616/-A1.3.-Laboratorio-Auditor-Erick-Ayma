package com.google.android.gms.internal;
@zzzt
/* loaded from: classes.dex */
public final class zzsi extends zzafv {
    final zzakk zzbvz;
    final zzsl zzbwd;
    private final String zzbwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsi(zzakk zzakkVar, zzsl zzslVar, String str) {
        this.zzbvz = zzakkVar;
        this.zzbwd = zzslVar;
        this.zzbwe = str;
        com.google.android.gms.ads.internal.zzbv.zzex().zza(this);
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void onStop() {
        this.zzbwd.abort();
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        try {
            this.zzbwd.zzau(this.zzbwe);
        } finally {
            zzahf.zzdbo.post(new zzsj(this));
        }
    }
}
