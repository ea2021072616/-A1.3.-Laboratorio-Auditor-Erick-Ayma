package com.facebook.ads.internal;

import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes.dex */
public enum e {
    UNKNOWN(0),
    WEBVIEW_BANNER_LEGACY(4),
    WEBVIEW_BANNER_50(5),
    WEBVIEW_BANNER_90(6),
    WEBVIEW_BANNER_250(7),
    WEBVIEW_INTERSTITIAL_UNKNOWN(100),
    WEBVIEW_INTERSTITIAL_HORIZONTAL(101),
    WEBVIEW_INTERSTITIAL_VERTICAL(102),
    WEBVIEW_INTERSTITIAL_TABLET(103),
    NATIVE_UNKNOWN(200),
    REWARDED_VIDEO(400),
    NATIVE_250(201),
    INSTREAM_VIDEO(IjkMediaCodecInfo.RANK_SECURE);
    
    private final int n;

    e(int i) {
        this.n = i;
    }

    public int a() {
        return this.n;
    }
}
