package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.view.a;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes.dex */
public class NativeAdView {

    /* loaded from: classes.dex */
    public enum Type {
        HEIGHT_100(-1, 100),
        HEIGHT_120(-1, 120),
        HEIGHT_300(-1, IjkMediaCodecInfo.RANK_SECURE),
        HEIGHT_400(-1, 400);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f1092a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1093b;

        Type(int i, int i2) {
            this.f1092a = i;
            this.f1093b = i2;
        }

        public int getHeight() {
            return this.f1093b;
        }

        public int getValue() {
            switch (this.f1093b) {
                case 100:
                    return 1;
                case 120:
                    return 2;
                case IjkMediaCodecInfo.RANK_SECURE /* 300 */:
                    return 3;
                case 400:
                    return 4;
                default:
                    return -1;
            }
        }

        public int getWidth() {
            return this.f1092a;
        }
    }

    public static View render(Context context, NativeAd nativeAd, Type type) {
        return render(context, nativeAd, type, null);
    }

    public static View render(Context context, NativeAd nativeAd, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAd.isNativeConfigEnabled()) {
            nativeAdViewAttributes = nativeAd.getAdViewAttributes();
        } else if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        nativeAd.a(type);
        return new a(context, nativeAd, type, nativeAdViewAttributes);
    }
}
