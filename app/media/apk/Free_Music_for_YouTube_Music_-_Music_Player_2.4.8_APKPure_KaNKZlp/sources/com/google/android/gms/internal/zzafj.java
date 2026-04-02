package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzafj {
    public final int errorCode;
    @Nullable
    public final zzjb zzatn;
    public final zzaak zzcrj;
    @Nullable
    public final JSONObject zzcyc;
    public final zzul zzcye;
    public final long zzcyi;
    public final long zzcyj;
    public final zzil zzcyo;
    public final zzaao zzcyp;

    public zzafj(zzaak zzaakVar, zzaao zzaaoVar, zzul zzulVar, zzjb zzjbVar, int i, long j, long j2, JSONObject jSONObject, zzil zzilVar) {
        this.zzcrj = zzaakVar;
        this.zzcyp = zzaaoVar;
        this.zzcye = zzulVar;
        this.zzatn = zzjbVar;
        this.errorCode = i;
        this.zzcyi = j;
        this.zzcyj = j2;
        this.zzcyc = jSONObject;
        this.zzcyo = zzilVar;
    }

    public zzafj(zzaak zzaakVar, zzaao zzaaoVar, zzul zzulVar, zzjb zzjbVar, int i, long j, long j2, JSONObject jSONObject, zzio zzioVar) {
        this.zzcrj = zzaakVar;
        this.zzcyp = zzaaoVar;
        this.zzcye = zzulVar;
        this.zzatn = zzjbVar;
        this.errorCode = i;
        this.zzcyi = j;
        this.zzcyj = j2;
        this.zzcyc = jSONObject;
        this.zzcyo = new zzil(zzioVar, ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbph)).booleanValue());
    }
}
