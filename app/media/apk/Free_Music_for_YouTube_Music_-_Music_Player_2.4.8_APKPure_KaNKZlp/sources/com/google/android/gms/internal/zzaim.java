package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaim implements zzu {
    private /* synthetic */ String zzbwj;
    private /* synthetic */ zzait zzddd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaim(zzaik zzaikVar, String str, zzait zzaitVar) {
        this.zzbwj = str;
        this.zzddd = zzaitVar;
    }

    @Override // com.google.android.gms.internal.zzu
    public final void zzd(zzaa zzaaVar) {
        String str = this.zzbwj;
        String zzaaVar2 = zzaaVar.toString();
        zzafx.zzcs(new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(zzaaVar2).length()).append("Failed to load URL: ").append(str).append("\n").append(zzaaVar2).toString());
        this.zzddd.zzb(null);
    }
}
