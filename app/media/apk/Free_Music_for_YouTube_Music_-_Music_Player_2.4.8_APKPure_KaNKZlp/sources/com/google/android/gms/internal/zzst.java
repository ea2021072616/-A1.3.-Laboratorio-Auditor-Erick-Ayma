package com.google.android.gms.internal;

import android.os.Handler;
import java.util.LinkedList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
final class zzst {
    private final List<zztr> zzaom = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzts zztsVar) {
        Handler handler = zzahf.zzdbo;
        for (zztr zztrVar : this.zzaom) {
            handler.post(new zztq(this, zztrVar, zztsVar));
        }
        this.zzaom.clear();
    }
}
