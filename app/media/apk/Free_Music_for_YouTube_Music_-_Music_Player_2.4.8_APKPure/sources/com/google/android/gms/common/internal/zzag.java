package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class zzag {
    private final String zzdmw;
    private final String zzfup;
    private final ComponentName zzfuq;
    private final int zzfur;

    public zzag(ComponentName componentName, int i) {
        this.zzdmw = null;
        this.zzfup = null;
        this.zzfuq = (ComponentName) zzbp.zzu(componentName);
        this.zzfur = TsExtractor.TS_STREAM_TYPE_AC3;
    }

    public zzag(String str, String str2, int i) {
        this.zzdmw = zzbp.zzgf(str);
        this.zzfup = zzbp.zzgf(str2);
        this.zzfuq = null;
        this.zzfur = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzag) {
            zzag zzagVar = (zzag) obj;
            return zzbf.equal(this.zzdmw, zzagVar.zzdmw) && zzbf.equal(this.zzfup, zzagVar.zzfup) && zzbf.equal(this.zzfuq, zzagVar.zzfuq) && this.zzfur == zzagVar.zzfur;
        }
        return false;
    }

    public final ComponentName getComponentName() {
        return this.zzfuq;
    }

    public final String getPackage() {
        return this.zzfup;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzdmw, this.zzfup, this.zzfuq, Integer.valueOf(this.zzfur)});
    }

    public final String toString() {
        return this.zzdmw == null ? this.zzfuq.flattenToString() : this.zzdmw;
    }

    public final int zzakg() {
        return this.zzfur;
    }

    public final Intent zzakh() {
        return this.zzdmw != null ? new Intent(this.zzdmw).setPackage(this.zzfup) : new Intent().setComponent(this.zzfuq);
    }
}
