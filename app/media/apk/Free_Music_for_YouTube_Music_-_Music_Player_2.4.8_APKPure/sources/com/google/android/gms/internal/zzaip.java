package com.google.android.gms.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
final class zzaip<T> extends zzp<InputStream> {
    private final zzv<T> zzcd;
    private final zzaio<T> zzddg;

    public zzaip(String str, zzaio<T> zzaioVar, zzv<T> zzvVar) {
        super(0, str, new zzaiq(zzvVar, zzaioVar));
        this.zzddg = zzaioVar;
        this.zzcd = zzvVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzp
    public final zzt<InputStream> zza(zzn zznVar) {
        return zzt.zza(new ByteArrayInputStream(zznVar.data), zzam.zzb(zznVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzp
    public final /* synthetic */ void zza(InputStream inputStream) {
        zzajr zza = zzagz.zza(zzagz.zzdbh, new zzair(this, inputStream));
        zza.zza(new zzais(this, zza), zzaju.zzdfa);
    }
}
