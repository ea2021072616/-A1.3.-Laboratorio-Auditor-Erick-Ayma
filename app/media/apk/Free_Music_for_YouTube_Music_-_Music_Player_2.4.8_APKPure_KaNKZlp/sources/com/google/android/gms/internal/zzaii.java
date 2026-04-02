package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbf;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class zzaii {
    public final int count;
    public final String name;
    private double zzdcu;
    private double zzdcv;
    public final double zzdcw;

    public zzaii(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.zzdcv = d;
        this.zzdcu = d2;
        this.zzdcw = d3;
        this.count = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaii) {
            zzaii zzaiiVar = (zzaii) obj;
            return zzbf.equal(this.name, zzaiiVar.name) && this.zzdcu == zzaiiVar.zzdcu && this.zzdcv == zzaiiVar.zzdcv && this.count == zzaiiVar.count && Double.compare(this.zzdcw, zzaiiVar.zzdcw) == 0;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, Double.valueOf(this.zzdcu), Double.valueOf(this.zzdcv), Double.valueOf(this.zzdcw), Integer.valueOf(this.count)});
    }

    public final String toString() {
        return zzbf.zzt(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzdcv)).zzg("maxBound", Double.valueOf(this.zzdcu)).zzg("percent", Double.valueOf(this.zzdcw)).zzg("count", Integer.valueOf(this.count)).toString();
    }
}
