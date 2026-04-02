package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.internal.zzzt;
@zzzt
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzat implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager mAudioManager;
    private boolean zzchp;
    private final zzau zzcke;
    private boolean zzckf;
    private boolean zzckg;
    private float zzckh = 1.0f;

    public zzat(Context context, zzau zzauVar) {
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.zzcke = zzauVar;
    }

    private final void zznq() {
        boolean z = this.zzchp && !this.zzckg && this.zzckh > 0.0f;
        if (z && !this.zzckf) {
            if (this.mAudioManager != null && !this.zzckf) {
                this.zzckf = this.mAudioManager.requestAudioFocus(this, 3, 2) == 1;
            }
            this.zzcke.zzmk();
        } else if (z || !this.zzckf) {
        } else {
            if (this.mAudioManager != null && this.zzckf) {
                this.zzckf = this.mAudioManager.abandonAudioFocus(this) == 0;
            }
            this.zzcke.zzmk();
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        this.zzckf = i > 0;
        this.zzcke.zzmk();
    }

    public final void setMuted(boolean z) {
        this.zzckg = z;
        zznq();
    }

    public final void zzb(float f) {
        this.zzckh = f;
        zznq();
    }

    public final void zznm() {
        this.zzchp = true;
        zznq();
    }

    public final void zznn() {
        this.zzchp = false;
        zznq();
    }

    public final float zznp() {
        float f = this.zzckg ? 0.0f : this.zzckh;
        if (this.zzckf) {
            return f;
        }
        return 0.0f;
    }
}
