package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzaig {
    private final String[] zzdcp;
    private final double[] zzdcq;
    private final double[] zzdcr;
    private final int[] zzdcs;
    private int zzdct;

    private zzaig(zzaij zzaijVar) {
        List list;
        List list2;
        List list3;
        List list4;
        list = zzaijVar.zzdcy;
        int size = list.size();
        list2 = zzaijVar.zzdcx;
        this.zzdcp = (String[]) list2.toArray(new String[size]);
        list3 = zzaijVar.zzdcy;
        this.zzdcq = zzp(list3);
        list4 = zzaijVar.zzdcz;
        this.zzdcr = zzp(list4);
        this.zzdcs = new int[size];
        this.zzdct = 0;
    }

    private static double[] zzp(List<Double> list) {
        double[] dArr = new double[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return dArr;
            }
            dArr[i2] = list.get(i2).doubleValue();
            i = i2 + 1;
        }
    }

    public final List<zzaii> getBuckets() {
        ArrayList arrayList = new ArrayList(this.zzdcp.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzdcp.length) {
                return arrayList;
            }
            arrayList.add(new zzaii(this.zzdcp[i2], this.zzdcr[i2], this.zzdcq[i2], this.zzdcs[i2] / this.zzdct, this.zzdcs[i2]));
            i = i2 + 1;
        }
    }

    public final void zza(double d) {
        this.zzdct++;
        for (int i = 0; i < this.zzdcr.length; i++) {
            if (this.zzdcr[i] <= d && d < this.zzdcq[i]) {
                int[] iArr = this.zzdcs;
                iArr[i] = iArr[i] + 1;
            }
            if (d < this.zzdcr[i]) {
                return;
            }
        }
    }
}
