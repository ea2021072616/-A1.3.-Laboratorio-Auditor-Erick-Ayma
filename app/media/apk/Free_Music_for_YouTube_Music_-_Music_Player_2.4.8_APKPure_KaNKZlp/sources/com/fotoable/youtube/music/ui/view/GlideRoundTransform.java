package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.b.a.c;
import com.bumptech.glide.load.resource.bitmap.d;
/* loaded from: classes.dex */
public class GlideRoundTransform extends d {
    private static float radius = 0.0f;

    public GlideRoundTransform(Context context) {
        this(context, 4);
    }

    public GlideRoundTransform(Context context, int i) {
        super(context);
        radius = Resources.getSystem().getDisplayMetrics().density * i;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.d
    protected Bitmap transform(c cVar, Bitmap bitmap, int i, int i2) {
        return roundCrop(cVar, bitmap);
    }

    private static Bitmap roundCrop(c cVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap a2 = cVar.a(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (a2 == null) {
            a2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(a2);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), radius, radius, paint);
        return a2;
    }

    @Override // com.bumptech.glide.load.g
    public String getId() {
        return getClass().getName() + Math.round(radius);
    }
}
