package com.google.android.gms.internal;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
@zzzt
/* loaded from: classes.dex */
public final class zzht {
    private final int zzazo;
    private final zzhj zzazq;
    private String zzazy;
    private String zzazz;
    private final boolean zzbaa = false;
    private final int zzbab;
    private final int zzbac;

    public zzht(int i, int i2, int i3) {
        this.zzazo = i;
        if (i2 > 64 || i2 < 0) {
            this.zzbab = 64;
        } else {
            this.zzbab = i2;
        }
        if (i3 <= 0) {
            this.zzbac = 1;
        } else {
            this.zzbac = i3;
        }
        this.zzazq = new zzhs(this.zzbab);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zza(java.lang.String r12, java.util.HashSet<java.lang.String> r13) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzht.zza(java.lang.String, java.util.HashSet):boolean");
    }

    public final String zza(ArrayList<String> arrayList, ArrayList<zzhi> arrayList2) {
        Collections.sort(arrayList2, new zzhu(this));
        HashSet<String> hashSet = new HashSet<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList2.size() || !zza(Normalizer.normalize(arrayList.get(arrayList2.get(i2).zzgw()), Normalizer.Form.NFKC).toLowerCase(Locale.US), hashSet)) {
                break;
            }
            i = i2 + 1;
        }
        zzhm zzhmVar = new zzhm();
        this.zzazy = "";
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                zzhmVar.write(this.zzazq.zzx(it.next()));
            } catch (IOException e) {
                zzafx.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzhmVar.toString();
    }
}
