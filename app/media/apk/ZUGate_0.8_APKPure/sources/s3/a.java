package s3;

import android.animation.ValueAnimator;
import com.google.android.material.internal.CheckableImageButton;
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4860a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f4861b;

    public /* synthetic */ a(o oVar, int i5) {
        this.f4860a = i5;
        this.f4861b = oVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i5 = this.f4860a;
        o oVar = this.f4861b;
        switch (i5) {
            case 0:
                d dVar = (d) oVar;
                dVar.getClass();
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CheckableImageButton checkableImageButton = dVar.f4918d;
                checkableImageButton.setScaleX(floatValue);
                checkableImageButton.setScaleY(floatValue);
                return;
            case 1:
                d dVar2 = (d) oVar;
                dVar2.getClass();
                dVar2.f4918d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
            default:
                k kVar = (k) oVar;
                kVar.getClass();
                kVar.f4918d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
        }
    }
}
