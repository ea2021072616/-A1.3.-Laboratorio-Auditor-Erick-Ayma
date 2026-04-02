package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;
/* loaded from: classes.dex */
public abstract class NativeAd {

    /* loaded from: classes.dex */
    public static abstract class AdChoicesInfo {
        public abstract List<Image> getImages();

        public abstract CharSequence getText();
    }

    /* loaded from: classes.dex */
    public static abstract class Image {
        public abstract Drawable getDrawable();

        public abstract double getScale();

        public abstract Uri getUri();
    }

    @KeepForSdk
    public abstract void performClick(Bundle bundle);

    @KeepForSdk
    public abstract boolean recordImpression(Bundle bundle);

    @KeepForSdk
    public abstract void reportTouchEvent(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzbf();
}
