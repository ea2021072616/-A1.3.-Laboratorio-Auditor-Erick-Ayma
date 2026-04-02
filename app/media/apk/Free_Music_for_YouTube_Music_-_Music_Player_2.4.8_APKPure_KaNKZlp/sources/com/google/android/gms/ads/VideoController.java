package com.google.android.gms.ads;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzaji;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object mLock = new Object();
    @Nullable
    private zzky zzalc;
    @Nullable
    private VideoLifecycleCallbacks zzald;

    /* loaded from: classes.dex */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public final float getAspectRatio() {
        float f = 0.0f;
        synchronized (this.mLock) {
            if (this.zzalc != null) {
                try {
                    f = this.zzalc.getAspectRatio();
                } catch (RemoteException e) {
                    zzaji.zzb("Unable to call getAspectRatio on video controller.", e);
                }
            }
        }
        return f;
    }

    @KeepForSdk
    public final int getPlaybackState() {
        int i = 0;
        synchronized (this.mLock) {
            if (this.zzalc != null) {
                try {
                    i = this.zzalc.getPlaybackState();
                } catch (RemoteException e) {
                    zzaji.zzb("Unable to call getPlaybackState on video controller.", e);
                }
            }
        }
        return i;
    }

    @Nullable
    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.mLock) {
            videoLifecycleCallbacks = this.zzald;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzalc != null;
        }
        return z;
    }

    @KeepForSdk
    public final boolean isCustomControlsEnabled() {
        boolean z = false;
        synchronized (this.mLock) {
            if (this.zzalc != null) {
                try {
                    z = this.zzalc.isCustomControlsEnabled();
                } catch (RemoteException e) {
                    zzaji.zzb("Unable to call isUsingCustomPlayerControls.", e);
                }
            }
        }
        return z;
    }

    @KeepForSdk
    public final boolean isMuted() {
        boolean z = true;
        synchronized (this.mLock) {
            if (this.zzalc != null) {
                try {
                    z = this.zzalc.isMuted();
                } catch (RemoteException e) {
                    zzaji.zzb("Unable to call isMuted on video controller.", e);
                }
            }
        }
        return z;
    }

    @KeepForSdk
    public final void mute(boolean z) {
        synchronized (this.mLock) {
            if (this.zzalc == null) {
                return;
            }
            try {
                this.zzalc.mute(z);
            } catch (RemoteException e) {
                zzaji.zzb("Unable to call mute on video controller.", e);
            }
        }
    }

    @KeepForSdk
    public final void pause() {
        synchronized (this.mLock) {
            if (this.zzalc == null) {
                return;
            }
            try {
                this.zzalc.pause();
            } catch (RemoteException e) {
                zzaji.zzb("Unable to call pause on video controller.", e);
            }
        }
    }

    @KeepForSdk
    public final void play() {
        synchronized (this.mLock) {
            if (this.zzalc == null) {
                return;
            }
            try {
                this.zzalc.play();
            } catch (RemoteException e) {
                zzaji.zzb("Unable to call play on video controller.", e);
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzbp.zzb(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.mLock) {
            this.zzald = videoLifecycleCallbacks;
            if (this.zzalc == null) {
                return;
            }
            try {
                this.zzalc.zza(new zzmc(videoLifecycleCallbacks));
            } catch (RemoteException e) {
                zzaji.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public final void zza(zzky zzkyVar) {
        synchronized (this.mLock) {
            this.zzalc = zzkyVar;
            if (this.zzald != null) {
                setVideoLifecycleCallbacks(this.zzald);
            }
        }
    }

    public final zzky zzbc() {
        zzky zzkyVar;
        synchronized (this.mLock) {
            zzkyVar = this.zzalc;
        }
        return zzkyVar;
    }
}
