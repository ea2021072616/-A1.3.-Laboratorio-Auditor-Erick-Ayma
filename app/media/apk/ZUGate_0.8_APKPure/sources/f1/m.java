package f1;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
/* loaded from: classes.dex */
public final class m extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable.ConstantState f2808a;

    public m(Drawable.ConstantState constantState) {
        this.f2808a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.f2808a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f2808a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        n nVar = new n();
        nVar.f2754g = (VectorDrawable) this.f2808a.newDrawable();
        return nVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        n nVar = new n();
        nVar.f2754g = (VectorDrawable) this.f2808a.newDrawable(resources);
        return nVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        n nVar = new n();
        nVar.f2754g = (VectorDrawable) this.f2808a.newDrawable(resources, theme);
        return nVar;
    }
}
