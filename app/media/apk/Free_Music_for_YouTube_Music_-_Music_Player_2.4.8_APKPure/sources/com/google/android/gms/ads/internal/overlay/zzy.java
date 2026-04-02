package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;
import com.google.android.gms.internal.zzzt;
@zzzt
@TargetApi(14)
/* loaded from: classes.dex */
public abstract class zzy extends TextureView implements zzau {
    protected final zzak zzchi;
    protected final zzat zzchj;

    public zzy(Context context) {
        super(context);
        this.zzchi = new zzak();
        this.zzchj = new zzat(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzx zzxVar);

    public abstract String zzmg();

    public abstract void zzmk();
}
