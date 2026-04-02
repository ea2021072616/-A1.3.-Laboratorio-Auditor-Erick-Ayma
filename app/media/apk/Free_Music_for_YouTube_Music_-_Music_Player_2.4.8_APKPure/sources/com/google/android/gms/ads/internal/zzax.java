package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzvp;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzax implements zzrn {
    private /* synthetic */ zzvm zzaqj;
    private /* synthetic */ zzab zzaqk;
    private /* synthetic */ zzvp zzaql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzax(zzvm zzvmVar, zzab zzabVar, zzvp zzvpVar) {
        this.zzaqj = zzvmVar;
        this.zzaqk = zzabVar;
        this.zzaql = zzvpVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        if (zzakkVar == null) {
            throw null;
        }
        View view = (View) zzakkVar;
        if (view == null) {
            return;
        }
        try {
            if (this.zzaqj != null) {
                if (this.zzaqj.getOverrideClickHandling()) {
                    zzas.zzb(zzakkVar);
                } else {
                    this.zzaqj.zzl(com.google.android.gms.dynamic.zzn.zzw(view));
                    this.zzaqk.zzanx.onAdClicked();
                }
            } else if (this.zzaql != null) {
                if (this.zzaql.getOverrideClickHandling()) {
                    zzas.zzb(zzakkVar);
                } else {
                    this.zzaql.zzl(com.google.android.gms.dynamic.zzn.zzw(view));
                    this.zzaqk.zzanx.onAdClicked();
                }
            }
        } catch (RemoteException e) {
            zzafx.zzc("Unable to call handleClick on mapper", e);
        }
    }
}
