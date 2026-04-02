package com.github.appintro.internal.viewpager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.h;
import com.github.appintro.AppIntroPageTransformerType;
import com.github.appintro.R;
import e4.e;
/* loaded from: classes.dex */
public final class ViewPagerTransformer implements h {
    private double descriptionPF;
    private double imagePF;
    private double titlePF;
    private final AppIntroPageTransformerType transformType;

    public ViewPagerTransformer(AppIntroPageTransformerType appIntroPageTransformerType) {
        e.f(appIntroPageTransformerType, "transformType");
        this.transformType = appIntroPageTransformerType;
    }

    private final void applyParallax(View view, float f5) {
        View findViewById = view.findViewById(R.id.title);
        e.e(findViewById, "page.findViewById<TextView>(R.id.title)");
        ((TextView) findViewById).setTranslationX(computeParallax(view, f5, this.titlePF));
        View findViewById2 = view.findViewById(R.id.image);
        e.e(findViewById2, "page.findViewById<ImageView>(R.id.image)");
        ((ImageView) findViewById2).setTranslationX(computeParallax(view, f5, this.imagePF));
        View findViewById3 = view.findViewById(R.id.description);
        e.e(findViewById3, "page.findViewById<TextView>(R.id.description)");
        ((TextView) findViewById3).setTranslationX(computeParallax(view, f5, this.descriptionPF));
    }

    private final float computeParallax(View view, float f5, double d5) {
        return (float) ((view.getWidth() / d5) * (-f5));
    }

    private final void transformDepth(float f5, View view) {
        if (f5 > 0) {
            float f6 = 1;
            if (f5 < f6) {
                view.setAlpha(f6 - f5);
                ViewPagerTransformerKt.setScaleXY(view, ((f6 - Math.abs(f5)) * 0.25f) + 0.75f);
                view.setTranslationX(view.getWidth() * (-f5));
                return;
            }
        }
        ViewPagerTransformerKt.transformDefaults(view);
    }

    private final void transformFade(float f5, View view) {
        if (f5 <= -1.0f || f5 >= 1.0f) {
            view.setTranslationX(view.getWidth());
            view.setAlpha(0.0f);
            view.setClickable(false);
        } else if (f5 != 0.0f) {
            view.setTranslationX(view.getWidth() * (-f5));
            view.setAlpha(1.0f - Math.abs(f5));
        } else {
            view.setTranslationX(0.0f);
            view.setAlpha(1.0f);
            view.setClickable(true);
        }
    }

    private final void transformParallax(float f5, View view) {
        if (f5 <= -1 || f5 >= 1) {
            return;
        }
        try {
            applyParallax(view, f5);
        } catch (IllegalStateException e5) {
            e5.printStackTrace();
        }
    }

    private final void transformSlideOver(float f5, View view) {
        if (f5 >= 0 || f5 <= -1) {
            ViewPagerTransformerKt.transformDefaults(view);
            return;
        }
        float f6 = 1;
        ViewPagerTransformerKt.setScaleXY(view, (Math.abs(Math.abs(f5) - f6) * 0.14999998f) + 0.85f);
        view.setAlpha(Math.max(0.35f, f6 - Math.abs(f5)));
        float f7 = -view.getWidth();
        float f8 = f5 * f7;
        if (f8 > f7) {
            view.setTranslationX(f8);
        } else {
            view.setTranslationX(0.0f);
        }
    }

    private final void transformZoom(float f5, View view) {
        float scaleXY;
        float scaleXY2;
        float scaleXY3;
        if (f5 >= -1) {
            float f6 = 1;
            if (f5 <= f6) {
                ViewPagerTransformerKt.setScaleXY(view, Math.max(0.85f, f6 - Math.abs(f5)));
                scaleXY = ViewPagerTransformerKt.getScaleXY(view);
                view.setAlpha((((scaleXY - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
                scaleXY2 = ViewPagerTransformerKt.getScaleXY(view);
                float f7 = 2;
                float height = ((f6 - scaleXY2) * view.getHeight()) / f7;
                scaleXY3 = ViewPagerTransformerKt.getScaleXY(view);
                float width = ((f6 - scaleXY3) * view.getWidth()) / f7;
                if (f5 < 0) {
                    view.setTranslationX(width - (height / f7));
                    return;
                }
                view.setTranslationX((height / f7) + (-width));
                return;
            }
        }
        ViewPagerTransformerKt.transformDefaults(view);
    }

    @Override // androidx.viewpager.widget.h
    public void transformPage(View view, float f5) {
        e.f(view, "page");
        AppIntroPageTransformerType appIntroPageTransformerType = this.transformType;
        if (e.a(appIntroPageTransformerType, AppIntroPageTransformerType.Flow.INSTANCE)) {
            view.setRotationY(f5 * (-30.0f));
        } else if (e.a(appIntroPageTransformerType, AppIntroPageTransformerType.SlideOver.INSTANCE)) {
            transformSlideOver(f5, view);
        } else if (e.a(appIntroPageTransformerType, AppIntroPageTransformerType.Depth.INSTANCE)) {
            transformDepth(f5, view);
        } else if (e.a(appIntroPageTransformerType, AppIntroPageTransformerType.Zoom.INSTANCE)) {
            transformZoom(f5, view);
        } else if (e.a(appIntroPageTransformerType, AppIntroPageTransformerType.Fade.INSTANCE)) {
            transformFade(f5, view);
        } else if (appIntroPageTransformerType instanceof AppIntroPageTransformerType.Parallax) {
            this.titlePF = ((AppIntroPageTransformerType.Parallax) this.transformType).getTitleParallaxFactor();
            this.imagePF = ((AppIntroPageTransformerType.Parallax) this.transformType).getImageParallaxFactor();
            this.descriptionPF = ((AppIntroPageTransformerType.Parallax) this.transformType).getDescriptionParallaxFactor();
            transformParallax(f5, view);
        }
    }
}
