package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class zzaij {
    private final List<String> zzdcx = new ArrayList();
    private final List<Double> zzdcy = new ArrayList();
    private final List<Double> zzdcz = new ArrayList();

    public final zzaij zza(String str, double d, double d2) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.zzdcx.size()) {
                break;
            }
            double doubleValue = this.zzdcz.get(i).doubleValue();
            double doubleValue2 = this.zzdcy.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i2 = i + 1;
        }
        this.zzdcx.add(i, str);
        this.zzdcz.add(i, Double.valueOf(d));
        this.zzdcy.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzaig zzri() {
        return new zzaig(this);
    }
}
