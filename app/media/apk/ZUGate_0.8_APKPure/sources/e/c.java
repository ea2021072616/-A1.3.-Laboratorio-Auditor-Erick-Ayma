package e;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class c extends Drawable implements Drawable.Callback {

    /* renamed from: g  reason: collision with root package name */
    public Drawable f2559g;

    public c(Drawable drawable) {
        Drawable drawable2 = this.f2559g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2559g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2559g.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return this.f2559g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f2559g.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2559g.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2559g.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f2559g.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f2559g.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f2559g.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        return this.f2559g.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        return this.f2559g.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        return this.f2559g.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.f2559g.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f2559g.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.f2559g.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f2559g.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i5) {
        return this.f2559g.setLevel(i5);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        scheduleSelf(runnable, j5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        this.f2559g.setAlpha(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z4) {
        this.f2559g.setAutoMirrored(z4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int i5) {
        this.f2559g.setChangingConfigurations(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f2559g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z4) {
        this.f2559g.setDither(z4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z4) {
        this.f2559g.setFilterBitmap(z4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f5, float f6) {
        a0.a.e(this.f2559g, f5, f6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i5, int i6, int i7, int i8) {
        a0.a.f(this.f2559g, i5, i6, i7, i8);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f2559g.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i5) {
        a0.a.g(this.f2559g, i5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        a0.a.h(this.f2559g, colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        a0.a.i(this.f2559g, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z4, boolean z5) {
        return super.setVisible(z4, z5) || this.f2559g.setVisible(z4, z5);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
