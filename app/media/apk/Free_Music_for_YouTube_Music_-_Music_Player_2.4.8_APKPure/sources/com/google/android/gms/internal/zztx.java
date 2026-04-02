package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbp;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzt
/* loaded from: classes.dex */
public final class zztx {
    private final String zzapb;
    private final LinkedList<zzty> zzbxk;
    private zzix zzbxl;
    private final int zzbxm;
    private boolean zzbxn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztx(zzix zzixVar, String str, int i) {
        zzbp.zzu(zzixVar);
        zzbp.zzu(str);
        this.zzbxk = new LinkedList<>();
        this.zzbxl = zzixVar;
        this.zzapb = str;
        this.zzbxm = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getAdUnitId() {
        return this.zzapb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getNetworkType() {
        return this.zzbxm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int size() {
        return this.zzbxk.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzss zzssVar, zzix zzixVar) {
        this.zzbxk.add(new zzty(this, zzssVar, zzixVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb(zzss zzssVar) {
        zzty zztyVar = new zzty(this, zzssVar);
        this.zzbxk.add(zztyVar);
        return zztyVar.load();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzix zzkk() {
        return this.zzbxl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzkl() {
        int i = 0;
        Iterator<zzty> it = this.zzbxk.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().zzbxs ? i2 + 1 : i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzkm() {
        int i = 0;
        Iterator<zzty> it = this.zzbxk.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().load() ? i2 + 1 : i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzkn() {
        this.zzbxn = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzko() {
        return this.zzbxn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzty zzm(@Nullable zzix zzixVar) {
        if (zzixVar != null) {
            this.zzbxl = zzixVar;
        }
        return this.zzbxk.remove();
    }
}
