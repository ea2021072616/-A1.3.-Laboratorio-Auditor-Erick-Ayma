package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.trackselection.TrackSelector;
/* loaded from: classes.dex */
public final class ExoPlayerFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;

    private ExoPlayerFactory() {
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector<?> trackSelector, LoadControl loadControl) {
        return newSimpleInstance(context, trackSelector, loadControl, null);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector<?> trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        return newSimpleInstance(context, trackSelector, loadControl, drmSessionManager, false);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector<?> trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z) {
        return newSimpleInstance(context, trackSelector, loadControl, drmSessionManager, z, DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector<?> trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, long j) {
        return new SimpleExoPlayer(context, trackSelector, loadControl, drmSessionManager, z, j);
    }

    public static ExoPlayer newInstance(Renderer[] rendererArr, TrackSelector<?> trackSelector) {
        return newInstance(rendererArr, trackSelector, new DefaultLoadControl());
    }

    public static ExoPlayer newInstance(Renderer[] rendererArr, TrackSelector<?> trackSelector, LoadControl loadControl) {
        return new ExoPlayerImpl(rendererArr, trackSelector, loadControl);
    }
}
