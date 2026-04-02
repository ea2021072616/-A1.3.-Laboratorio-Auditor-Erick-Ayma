package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
@zzzt
/* loaded from: classes.dex */
public final class zzhk {
    private final int zzazo;
    private final zzhj zzazq = new zzho();
    private final int zzazn = 6;
    private final int zzazp = 0;

    public zzhk(int i) {
        this.zzazo = i;
    }

    private final String zzy(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzhm zzhmVar = new zzhm();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzazo, new zzhl(this));
        for (String str2 : split) {
            String[] zzc = zzhn.zzc(str2, false);
            if (zzc.length != 0) {
                zzhq.zza(zzc, this.zzazo, this.zzazn, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzhmVar.write(this.zzazq.zzx(((zzhr) it.next()).zzazu));
            } catch (IOException e) {
                zzafx.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzhmVar.toString();
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            String str = arrayList2.get(i);
            i++;
            stringBuffer.append(str.toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        return zzy(stringBuffer.toString());
    }
}
