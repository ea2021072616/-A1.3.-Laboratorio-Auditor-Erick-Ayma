package com.facebook.ads;

import android.support.v7.widget.helper.ItemTouchHelper;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AdSize implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final int f1028a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1029b;
    @Deprecated
    public static final AdSize BANNER_320_50 = new AdSize(320, 50);
    public static final AdSize INTERSTITIAL = new AdSize(0, 0);
    public static final AdSize BANNER_HEIGHT_50 = new AdSize(-1, 50);
    public static final AdSize BANNER_HEIGHT_90 = new AdSize(-1, 90);
    public static final AdSize RECTANGLE_HEIGHT_250 = new AdSize(-1, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);

    public AdSize(int i, int i2) {
        this.f1028a = i;
        this.f1029b = i2;
    }

    public static AdSize fromWidthAndHeight(int i, int i2) {
        if (INTERSTITIAL.f1029b == i2 && INTERSTITIAL.f1028a == i) {
            return INTERSTITIAL;
        }
        if (BANNER_320_50.f1029b == i2 && BANNER_320_50.f1028a == i) {
            return BANNER_320_50;
        }
        if (BANNER_HEIGHT_50.f1029b == i2 && BANNER_HEIGHT_50.f1028a == i) {
            return BANNER_HEIGHT_50;
        }
        if (BANNER_HEIGHT_90.f1029b == i2 && BANNER_HEIGHT_90.f1028a == i) {
            return BANNER_HEIGHT_90;
        }
        if (RECTANGLE_HEIGHT_250.f1029b == i2 && RECTANGLE_HEIGHT_250.f1028a == i) {
            return RECTANGLE_HEIGHT_250;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.f1028a == adSize.f1028a && this.f1029b == adSize.f1029b;
    }

    public int getHeight() {
        return this.f1029b;
    }

    public int getWidth() {
        return this.f1028a;
    }

    public int hashCode() {
        return (this.f1028a * 31) + this.f1029b;
    }
}
