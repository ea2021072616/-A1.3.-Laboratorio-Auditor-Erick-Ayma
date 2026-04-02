package com.google.android.gms.internal;
@zzzt
/* loaded from: classes.dex */
public abstract class zzaae implements zzaac, zzahv<Void> {
    private final Object mLock = new Object();
    private final zzajz<zzaak> zzcnp;
    private final zzaac zzcnq;

    public zzaae(zzajz<zzaak> zzajzVar, zzaac zzaacVar) {
        this.zzcnp = zzajzVar;
        this.zzcnq = zzaacVar;
    }

    @Override // com.google.android.gms.internal.zzahv
    public final void cancel() {
        zzod();
    }

    @Override // com.google.android.gms.internal.zzaac
    public final void zza(zzaao zzaaoVar) {
        synchronized (this.mLock) {
            this.zzcnq.zza(zzaaoVar);
            zzod();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(zzaas zzaasVar, zzaak zzaakVar) {
        try {
            zzaasVar.zza(zzaakVar, new zzaan(this));
            return true;
        } catch (Throwable th) {
            zzafx.zzc("Could not fetch ad response from ad request service due to an Exception.", th);
            com.google.android.gms.ads.internal.zzbv.zzee().zza(th, "AdRequestClientTask.getAdResponseFromService");
            this.zzcnq.zza(new zzaao(0));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzahv
    public final /* synthetic */ Void zzns() {
        zzaas zzoe = zzoe();
        if (zzoe == null) {
            this.zzcnq.zza(new zzaao(0));
            zzod();
        } else {
            this.zzcnp.zza(new zzaaf(this, zzoe), new zzaag(this));
        }
        return null;
    }

    public abstract void zzod();

    public abstract zzaas zzoe();
}
