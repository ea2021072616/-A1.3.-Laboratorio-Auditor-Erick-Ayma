package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@zzzt
/* loaded from: classes.dex */
public final class zzfl implements zzft {
    private final Context mApplicationContext;
    private final zzajk zzapc;
    private final com.google.android.gms.ads.internal.js.zzl zzavc;
    private final Object mLock = new Object();
    private final WeakHashMap<zzafi, zzfm> zzava = new WeakHashMap<>();
    private final ArrayList<zzfm> zzavb = new ArrayList<>();

    public zzfl(Context context, zzajk zzajkVar, com.google.android.gms.ads.internal.js.zzl zzlVar) {
        this.mApplicationContext = context.getApplicationContext();
        this.zzapc = zzajkVar;
        this.zzavc = zzlVar;
    }

    private final boolean zzf(zzafi zzafiVar) {
        boolean z;
        synchronized (this.mLock) {
            zzfm zzfmVar = this.zzava.get(zzafiVar);
            z = zzfmVar != null && zzfmVar.zzft();
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzft
    public final void zza(zzfm zzfmVar) {
        synchronized (this.mLock) {
            if (!zzfmVar.zzft()) {
                this.zzavb.remove(zzfmVar);
                Iterator<Map.Entry<zzafi, zzfm>> it = this.zzava.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == zzfmVar) {
                        it.remove();
                    }
                }
            }
        }
    }

    public final void zza(zzjb zzjbVar, zzafi zzafiVar) {
        zzakk zzakkVar = zzafiVar.zzcgz;
        if (zzakkVar == null) {
            throw null;
        }
        zza(zzjbVar, zzafiVar, (View) zzakkVar);
    }

    public final void zza(zzjb zzjbVar, zzafi zzafiVar, View view) {
        zza(zzjbVar, zzafiVar, new zzfs(view, zzafiVar), (com.google.android.gms.ads.internal.js.zzai) null);
    }

    public final void zza(zzjb zzjbVar, zzafi zzafiVar, View view, com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        zza(zzjbVar, zzafiVar, new zzfs(view, zzafiVar), zzaiVar);
    }

    public final void zza(zzjb zzjbVar, zzafi zzafiVar, zzgw zzgwVar, @Nullable com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        zzfm zzfmVar;
        synchronized (this.mLock) {
            if (zzf(zzafiVar)) {
                zzfmVar = this.zzava.get(zzafiVar);
            } else {
                zzfmVar = new zzfm(this.mApplicationContext, zzjbVar, zzafiVar, this.zzapc, zzgwVar);
                zzfmVar.zza(this);
                this.zzava.put(zzafiVar, zzfmVar);
                this.zzavb.add(zzfmVar);
            }
            if (zzaiVar != null) {
                zzfmVar.zza(new zzfu(zzfmVar, zzaiVar));
            } else {
                zzfmVar.zza(new zzfy(zzfmVar, this.zzavc, this.mApplicationContext));
            }
        }
    }

    public final void zzg(zzafi zzafiVar) {
        synchronized (this.mLock) {
            zzfm zzfmVar = this.zzava.get(zzafiVar);
            if (zzfmVar != null) {
                zzfmVar.zzfr();
            }
        }
    }

    public final void zzh(zzafi zzafiVar) {
        synchronized (this.mLock) {
            zzfm zzfmVar = this.zzava.get(zzafiVar);
            if (zzfmVar != null) {
                zzfmVar.stop();
            }
        }
    }

    public final void zzi(zzafi zzafiVar) {
        synchronized (this.mLock) {
            zzfm zzfmVar = this.zzava.get(zzafiVar);
            if (zzfmVar != null) {
                zzfmVar.pause();
            }
        }
    }

    public final void zzj(zzafi zzafiVar) {
        synchronized (this.mLock) {
            zzfm zzfmVar = this.zzava.get(zzafiVar);
            if (zzfmVar != null) {
                zzfmVar.resume();
            }
        }
    }
}
