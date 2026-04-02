package com.rodolfonavalon.shaperipplelibrary.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
/* compiled from: Circle.java */
/* loaded from: classes2.dex */
public class b extends a {
    @Override // com.rodolfonavalon.shaperipplelibrary.b.a
    public void a(Context context, Paint paint) {
    }

    @Override // com.rodolfonavalon.shaperipplelibrary.b.a
    public void a(Canvas canvas, int i, int i2, float f, int i3, int i4, Paint paint) {
        paint.setColor(i3);
        canvas.drawCircle(i, i2, f, paint);
    }
}
