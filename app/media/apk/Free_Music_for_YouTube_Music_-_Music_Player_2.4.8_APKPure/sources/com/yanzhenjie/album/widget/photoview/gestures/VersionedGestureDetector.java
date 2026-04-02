package com.yanzhenjie.album.widget.photoview.gestures;

import android.content.Context;
import android.os.Build;
/* loaded from: classes2.dex */
public final class VersionedGestureDetector {
    public static GestureDetector newInstance(Context context, OnGestureListener onGestureListener) {
        GestureDetector froyoGestureDetector;
        int i = Build.VERSION.SDK_INT;
        if (i < 5) {
            froyoGestureDetector = new CupcakeGestureDetector(context);
        } else if (i < 8) {
            froyoGestureDetector = new EclairGestureDetector(context);
        } else {
            froyoGestureDetector = new FroyoGestureDetector(context);
        }
        froyoGestureDetector.setOnGestureListener(onGestureListener);
        return froyoGestureDetector;
    }
}
