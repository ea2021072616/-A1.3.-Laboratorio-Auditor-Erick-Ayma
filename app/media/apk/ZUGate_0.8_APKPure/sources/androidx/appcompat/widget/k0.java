package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
public class k0 {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f396c = {16843067, 16843068};

    /* renamed from: a  reason: collision with root package name */
    public final ProgressBar f397a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f398b;

    public k0(ProgressBar progressBar) {
        this.f397a = progressBar;
    }

    public void a(AttributeSet attributeSet, int i5) {
        ProgressBar progressBar = this.f397a;
        z2 m5 = z2.m(progressBar.getContext(), attributeSet, f396c, i5);
        Drawable f5 = m5.f(0);
        if (f5 != null) {
            if (f5 instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) f5;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i6 = 0; i6 < numberOfFrames; i6++) {
                    Drawable b5 = b(animationDrawable.getFrame(i6), true);
                    b5.setLevel(10000);
                    animationDrawable2.addFrame(b5, animationDrawable.getDuration(i6));
                }
                animationDrawable2.setLevel(10000);
                f5 = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(f5);
        }
        Drawable f6 = m5.f(1);
        if (f6 != null) {
            progressBar.setProgressDrawable(b(f6, false));
        }
        m5.n();
    }

    public final Drawable b(Drawable drawable, boolean z4) {
        if (drawable instanceof a0.g) {
            ((a0.h) ((a0.g) drawable)).getClass();
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i5 = 0; i5 < numberOfLayers; i5++) {
                int id = layerDrawable.getId(i5);
                drawableArr[i5] = b(layerDrawable.getDrawable(i5), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i6 = 0; i6 < numberOfLayers; i6++) {
                layerDrawable2.setId(i6, layerDrawable.getId(i6));
                layerDrawable2.setLayerGravity(i6, layerDrawable.getLayerGravity(i6));
                layerDrawable2.setLayerWidth(i6, layerDrawable.getLayerWidth(i6));
                layerDrawable2.setLayerHeight(i6, layerDrawable.getLayerHeight(i6));
                layerDrawable2.setLayerInsetLeft(i6, layerDrawable.getLayerInsetLeft(i6));
                layerDrawable2.setLayerInsetRight(i6, layerDrawable.getLayerInsetRight(i6));
                layerDrawable2.setLayerInsetTop(i6, layerDrawable.getLayerInsetTop(i6));
                layerDrawable2.setLayerInsetBottom(i6, layerDrawable.getLayerInsetBottom(i6));
                layerDrawable2.setLayerInsetStart(i6, layerDrawable.getLayerInsetStart(i6));
                layerDrawable2.setLayerInsetEnd(i6, layerDrawable.getLayerInsetEnd(i6));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f398b == null) {
                this.f398b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z4 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }
}
