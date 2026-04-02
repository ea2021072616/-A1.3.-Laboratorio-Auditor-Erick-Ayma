package com.google.android.gms.internal;

import com.google.android.gms.dynamic.IObjectWrapper;
@zzzt
/* loaded from: classes.dex */
public final class zzaea extends zzaeh {
    private volatile zzaeb zzcvz;
    private volatile zzady zzcwl;
    private volatile zzadz zzcwm;

    public zzaea(zzadz zzadzVar) {
        this.zzcwm = zzadzVar;
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zza(IObjectWrapper iObjectWrapper, zzaek zzaekVar) {
        if (this.zzcwm != null) {
            this.zzcwm.zzc(zzaekVar);
        }
    }

    public final void zza(zzady zzadyVar) {
        this.zzcwl = zzadyVar;
    }

    public final void zza(zzaeb zzaebVar) {
        this.zzcvz = zzaebVar;
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzc(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzcwl != null) {
            this.zzcwl.zzz(i);
        }
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzcvz != null) {
            this.zzcvz.zza(com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper).getClass().getName(), i);
        }
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzq(IObjectWrapper iObjectWrapper) {
        if (this.zzcwl != null) {
            this.zzcwl.zzow();
        }
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzr(IObjectWrapper iObjectWrapper) {
        if (this.zzcvz != null) {
            this.zzcvz.zzbv(com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper).getClass().getName());
        }
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzs(IObjectWrapper iObjectWrapper) {
        if (this.zzcwm != null) {
            this.zzcwm.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzt(IObjectWrapper iObjectWrapper) {
        if (this.zzcwm != null) {
            this.zzcwm.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzu(IObjectWrapper iObjectWrapper) {
        if (this.zzcwm != null) {
            this.zzcwm.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzv(IObjectWrapper iObjectWrapper) {
        if (this.zzcwm != null) {
            this.zzcwm.zzot();
        }
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzw(IObjectWrapper iObjectWrapper) {
        if (this.zzcwm != null) {
            this.zzcwm.onRewardedVideoAdLeftApplication();
        }
    }
}
