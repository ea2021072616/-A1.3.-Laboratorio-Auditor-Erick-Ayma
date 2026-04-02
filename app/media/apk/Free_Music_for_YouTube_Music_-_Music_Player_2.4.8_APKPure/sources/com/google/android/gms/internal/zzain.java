package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzain extends zzar {
    private /* synthetic */ byte[] zzdde;
    private /* synthetic */ Map zzddf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzain(zzaik zzaikVar, int i, String str, zzv zzvVar, zzu zzuVar, byte[] bArr, Map map) {
        super(i, str, zzvVar, zzuVar);
        this.zzdde = bArr;
        this.zzddf = map;
    }

    @Override // com.google.android.gms.internal.zzp
    public final Map<String, String> getHeaders() throws zza {
        return this.zzddf == null ? super.getHeaders() : this.zzddf;
    }

    @Override // com.google.android.gms.internal.zzp
    public final byte[] zzg() throws zza {
        return this.zzdde == null ? super.zzg() : this.zzdde;
    }
}
