package com.google.android.gms.internal;

import java.util.PriorityQueue;
@zzzt
/* loaded from: classes.dex */
public final class zzhq {
    private static long zza(long j, int i) {
        if (i == 0) {
            return 1L;
        }
        return i != 1 ? i % 2 == 0 ? zza((j * j) % 1073807359, i / 2) % 1073807359 : ((zza((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    private static String zza(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            zzafx.e("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    private static void zza(int i, long j, String str, int i2, PriorityQueue<zzhr> priorityQueue) {
        zzhr zzhrVar = new zzhr(j, str, i2);
        if ((priorityQueue.size() != i || (priorityQueue.peek().zzazv <= zzhrVar.zzazv && priorityQueue.peek().value <= zzhrVar.value)) && !priorityQueue.contains(zzhrVar)) {
            priorityQueue.add(zzhrVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zzhr> priorityQueue) {
        if (strArr.length < i2) {
            zza(i, zzb(strArr, 0, strArr.length), zza(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long zzb = zzb(strArr, 0, i2);
        zza(i, zzb, zza(strArr, 0, i2), i2, priorityQueue);
        long zza = zza(16785407L, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            long j = zzb + 1073807359;
            zzb = (((((j - ((((zzhn.zzz(strArr[i3 - 1]) + 2147483647L) % 1073807359) * zza) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((zzhn.zzz(strArr[(i3 + i2) - 1]) + 2147483647L) % 1073807359)) % 1073807359;
            zza(i, zzb, zza(strArr, i3, i2), strArr.length, priorityQueue);
        }
    }

    private static long zzb(String[] strArr, int i, int i2) {
        long zzz = (zzhn.zzz(strArr[0]) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            zzz = (((zzz * 16785407) % 1073807359) + ((zzhn.zzz(strArr[i3]) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zzz;
    }
}
