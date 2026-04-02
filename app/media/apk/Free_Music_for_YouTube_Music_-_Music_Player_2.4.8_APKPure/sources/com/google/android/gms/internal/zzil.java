package com.google.android.gms.internal;

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzil {
    private HashMap<String, Long> zzbar;
    private final zzio zzbas;
    private zzir zzbat;
    private boolean zzbau;
    private final boolean zzbav;
    private final int zzbaw;
    private int zzbax;
    private zzim zzbay;

    private zzil() {
        this.zzbau = false;
        this.zzbax = 0;
        this.zzbav = false;
        this.zzbas = new zzio();
        this.zzbat = new zzir();
        this.zzbaw = 0;
        zzhj();
    }

    public zzil(zzio zzioVar, boolean z) {
        this.zzbau = false;
        this.zzbax = 0;
        this.zzbas = zzioVar;
        this.zzbar = new HashMap<>();
        this.zzbav = z;
        this.zzbaw = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbpj)).intValue();
        this.zzbat = new zzir();
        zzhj();
        com.google.android.gms.ads.internal.zzbv.zzer().zzrj();
    }

    public static zzil zzhf() {
        return new zzil();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzhh() {
        this.zzbas.zzd(zzego.zzc(this.zzbat)).zzb(zzhk()).zzbe();
    }

    private final synchronized void zzhi() {
        Handler handler = com.google.android.gms.ads.internal.zzbv.zzer().getHandler();
        zzim zzimVar = new zzim(this, this.zzbax + 1);
        handler.postDelayed(zzimVar, this.zzbaw);
        this.zzbax++;
        if (this.zzbay != null) {
            handler.removeCallbacks(this.zzbay);
        }
        this.zzbay = zzimVar;
    }

    private final synchronized void zzhj() {
    }

    private static int[] zzhk() {
        int i = 0;
        List<String> zzim = zzmu.zzim();
        ArrayList arrayList = new ArrayList();
        for (String str : zzim) {
            String[] split = str.split(",");
            for (String str2 : split) {
                try {
                    arrayList.add(Integer.valueOf(str2));
                } catch (NumberFormatException e) {
                    zzafx.v("Experiment ID is not a number");
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            iArr[i2] = ((Integer) obj).intValue();
            i2++;
        }
        return iArr;
    }

    public final synchronized void zza(zzin zzinVar) {
        if (this.zzbav) {
            zzinVar.zza(this.zzbat);
        }
        if (this.zzbau && this.zzbav) {
            zzhi();
        }
    }

    public final void zzhg() {
        if (this.zzbav) {
            this.zzbau = true;
            zzhi();
        }
    }
}
