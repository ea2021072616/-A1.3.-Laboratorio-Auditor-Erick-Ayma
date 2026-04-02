package com.google.android.gms.ads;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class VideoOptions {
    private final boolean zzale;
    private final boolean zzalf;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean zzale = true;
        private boolean zzalf = false;

        public final VideoOptions build() {
            return new VideoOptions(this);
        }

        @KeepForSdk
        public final Builder setCustomControlsRequested(boolean z) {
            this.zzalf = z;
            return this;
        }

        public final Builder setStartMuted(boolean z) {
            this.zzale = z;
            return this;
        }
    }

    private VideoOptions(Builder builder) {
        this.zzale = builder.zzale;
        this.zzalf = builder.zzalf;
    }

    public VideoOptions(zzmd zzmdVar) {
        this.zzale = zzmdVar.zzbfh;
        this.zzalf = zzmdVar.zzbfi;
    }

    @KeepForSdk
    public final boolean getCustomControlsRequested() {
        return this.zzalf;
    }

    public final boolean getStartMuted() {
        return this.zzale;
    }
}
