package com.google.android.gms.ads.formats;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzalm;
    private final int zzaln;
    private final boolean zzalo;
    private final int zzalp;
    private final VideoOptions zzalq;

    /* loaded from: classes.dex */
    public @interface AdChoicesPlacement {
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean zzalm = false;
        private int zzaln = -1;
        private boolean zzalo = false;
        private int zzalp = 1;
        private VideoOptions zzalq;

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public final Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.zzalp = i;
            return this;
        }

        public final Builder setImageOrientation(int i) {
            this.zzaln = i;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.zzalo = z;
            return this;
        }

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzalm = z;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzalq = videoOptions;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.zzalm = builder.zzalm;
        this.zzaln = builder.zzaln;
        this.zzalo = builder.zzalo;
        this.zzalp = builder.zzalp;
        this.zzalq = builder.zzalq;
    }

    public final int getAdChoicesPlacement() {
        return this.zzalp;
    }

    public final int getImageOrientation() {
        return this.zzaln;
    }

    @Nullable
    public final VideoOptions getVideoOptions() {
        return this.zzalq;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.zzalo;
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.zzalm;
    }
}
