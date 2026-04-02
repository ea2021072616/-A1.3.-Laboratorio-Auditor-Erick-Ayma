package com.google.android.gms.internal;

import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzfu implements zzgh {
    private final zzfm zzawd;
    private final com.google.android.gms.ads.internal.js.zzai zzawe;
    private final zzrn zzawf = new zzfv(this);
    private final zzrn zzawg = new zzfw(this);
    private final zzrn zzawh = new zzfx(this);

    public zzfu(zzfm zzfmVar, com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        this.zzawd = zzfmVar;
        this.zzawe = zzaiVar;
        com.google.android.gms.ads.internal.js.zzai zzaiVar2 = this.zzawe;
        zzaiVar2.zza("/updateActiveView", this.zzawf);
        zzaiVar2.zza("/untrackActiveViewUnit", this.zzawg);
        zzaiVar2.zza("/visibilityChanged", this.zzawh);
        String valueOf = String.valueOf(this.zzawd.zzavg.zzfn());
        zzafx.zzcb(valueOf.length() != 0 ? "Custom JS tracking ad unit: ".concat(valueOf) : new String("Custom JS tracking ad unit: "));
    }

    @Override // com.google.android.gms.internal.zzgh
    public final void zzb(JSONObject jSONObject, boolean z) {
        if (z) {
            this.zzawd.zzb(this);
        } else {
            this.zzawe.zza("AFMA_updateActiveView", jSONObject);
        }
    }

    @Override // com.google.android.gms.internal.zzgh
    public final boolean zzfz() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzgh
    public final void zzga() {
        com.google.android.gms.ads.internal.js.zzai zzaiVar = this.zzawe;
        zzaiVar.zzb("/visibilityChanged", this.zzawh);
        zzaiVar.zzb("/untrackActiveViewUnit", this.zzawg);
        zzaiVar.zzb("/updateActiveView", this.zzawf);
    }
}
