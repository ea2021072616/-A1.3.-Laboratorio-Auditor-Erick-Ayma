package com.google.android.gms.internal;

import android.content.Context;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzfy implements zzgh {
    private final Context mContext;
    private final zzfm zzawd;
    private com.google.android.gms.ads.internal.js.zzy zzawj;
    private boolean zzawk;
    private final zzrn zzawf = new zzgd(this);
    private final zzrn zzawg = new zzge(this);
    private final zzrn zzawh = new zzgf(this);
    private final zzrn zzawl = new zzgg(this);

    public zzfy(zzfm zzfmVar, com.google.android.gms.ads.internal.js.zzl zzlVar, Context context) {
        this.zzawd = zzfmVar;
        this.mContext = context;
        this.zzawj = zzlVar.zzb((zzcv) null);
        this.zzawj.zza(new zzfz(this), new zzga(this));
        String valueOf = String.valueOf(this.zzawd.zzavg.zzfn());
        zzafx.zzcb(valueOf.length() != 0 ? "Core JS tracking ad unit: ".concat(valueOf) : new String("Core JS tracking ad unit: "));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zza(zzfy zzfyVar, boolean z) {
        zzfyVar.zzawk = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        zzaiVar.zza("/updateActiveView", this.zzawf);
        zzaiVar.zza("/untrackActiveViewUnit", this.zzawg);
        zzaiVar.zza("/visibilityChanged", this.zzawh);
        if (com.google.android.gms.ads.internal.zzbv.zzez().zzr(this.mContext)) {
            zzaiVar.zza("/logScionEvent", this.zzawl);
        }
    }

    @Override // com.google.android.gms.internal.zzgh
    public final void zzb(JSONObject jSONObject, boolean z) {
        this.zzawj.zza(new zzgb(this, jSONObject), new zzakb());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        zzaiVar.zzb("/visibilityChanged", this.zzawh);
        zzaiVar.zzb("/untrackActiveViewUnit", this.zzawg);
        zzaiVar.zzb("/updateActiveView", this.zzawf);
        if (com.google.android.gms.ads.internal.zzbv.zzez().zzr(this.mContext)) {
            zzaiVar.zzb("/logScionEvent", this.zzawl);
        }
    }

    @Override // com.google.android.gms.internal.zzgh
    public final boolean zzfz() {
        return this.zzawk;
    }

    @Override // com.google.android.gms.internal.zzgh
    public final void zzga() {
        this.zzawj.zza(new zzgc(this), new zzakb());
        this.zzawj.release();
    }
}
