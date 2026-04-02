package f1;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class e extends Drawable {

    /* renamed from: g  reason: collision with root package name */
    public Drawable f2754g;

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            a0.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void clearColorFilter() {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getCurrent() : super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getMinimumHeight() : super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getMinimumWidth() : super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getState() : super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getTransparentRegion() : super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i5) {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.setLevel(i5) : super.onLevelChange(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int i5) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.setChangingConfigurations(i5);
        } else {
            super.setChangingConfigurations(i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(int i5, PorterDuff.Mode mode) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.setColorFilter(i5, mode);
        } else {
            super.setColorFilter(i5, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z4) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.setFilterBitmap(z4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f5, float f6) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            a0.a.e(drawable, f5, f6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i5, int i6, int i7, int i8) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            a0.a.f(drawable, i5, i6, i7, i8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.setState(iArr) : super.setState(iArr);
    }
}
