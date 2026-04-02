package f1;

import android.content.res.ColorStateList;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public final class a extends Animatable2.AnimationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e3.a f2743a;

    public a(e3.a aVar) {
        this.f2743a = aVar;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        ColorStateList colorStateList = this.f2743a.f2685b.f2696u;
        if (colorStateList != null) {
            a0.a.h(drawable, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        e3.c cVar = this.f2743a.f2685b;
        ColorStateList colorStateList = cVar.f2696u;
        if (colorStateList != null) {
            a0.a.g(drawable, colorStateList.getColorForState(cVar.f2700y, colorStateList.getDefaultColor()));
        }
    }
}
