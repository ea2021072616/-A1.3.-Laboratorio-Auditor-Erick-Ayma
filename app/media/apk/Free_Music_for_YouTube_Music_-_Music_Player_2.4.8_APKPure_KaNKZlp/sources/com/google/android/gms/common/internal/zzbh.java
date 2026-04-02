package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class zzbh {
    private final Object zzddt;
    private final List<String> zzfvk;

    private zzbh(Object obj) {
        this.zzddt = zzbp.zzu(obj);
        this.zzfvk = new ArrayList();
    }

    public final String toString() {
        StringBuilder append = new StringBuilder(100).append(this.zzddt.getClass().getSimpleName()).append('{');
        int size = this.zzfvk.size();
        for (int i = 0; i < size; i++) {
            append.append(this.zzfvk.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }

    public final zzbh zzg(String str, Object obj) {
        List<String> list = this.zzfvk;
        String str2 = (String) zzbp.zzu(str);
        String valueOf = String.valueOf(obj);
        list.add(new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
        return this;
    }
}
