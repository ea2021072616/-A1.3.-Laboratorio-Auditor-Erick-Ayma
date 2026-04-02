package f1;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public final class c extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable.ConstantState f2748a;

    public c(Drawable.ConstantState constantState) {
        this.f2748a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.f2748a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f2748a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        d dVar = new d(null);
        Drawable newDrawable = this.f2748a.newDrawable();
        dVar.f2754g = newDrawable;
        newDrawable.setCallback(dVar.f2753l);
        return dVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        d dVar = new d(null);
        Drawable newDrawable = this.f2748a.newDrawable(resources);
        dVar.f2754g = newDrawable;
        newDrawable.setCallback(dVar.f2753l);
        return dVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        d dVar = new d(null);
        Drawable newDrawable = this.f2748a.newDrawable(resources, theme);
        dVar.f2754g = newDrawable;
        newDrawable.setCallback(dVar.f2753l);
        return dVar;
    }
}
