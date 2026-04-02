package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.Nullable;
/* compiled from: DrawingContent.java */
/* loaded from: classes.dex */
interface aa extends x {
    void a(Canvas canvas, Matrix matrix, int i);

    void a(RectF rectF, Matrix matrix);

    void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter);
}
