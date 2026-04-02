package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbf;
@zzzt
/* loaded from: classes.dex */
public final class zzacw extends zzadc {
    private final String zzcua;
    private final int zzcvp;

    public zzacw(String str, int i) {
        this.zzcua = str;
        this.zzcvp = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzacw)) {
            return false;
        }
        zzacw zzacwVar = (zzacw) obj;
        return zzbf.equal(this.zzcua, zzacwVar.zzcua) && zzbf.equal(Integer.valueOf(this.zzcvp), Integer.valueOf(zzacwVar.zzcvp));
    }

    @Override // com.google.android.gms.internal.zzadb
    public final int getAmount() {
        return this.zzcvp;
    }

    @Override // com.google.android.gms.internal.zzadb
    public final String getType() {
        return this.zzcua;
    }
}
