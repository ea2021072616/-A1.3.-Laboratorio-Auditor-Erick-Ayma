package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public final class z1 extends e.c {

    /* renamed from: h  reason: collision with root package name */
    public boolean f604h;

    public z1(Drawable drawable) {
        super(drawable);
        this.f604h = true;
    }

    @Override // e.c, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f604h) {
            super.draw(canvas);
        }
    }

    @Override // e.c, android.graphics.drawable.Drawable
    public final void setHotspot(float f5, float f6) {
        if (this.f604h) {
            super.setHotspot(f5, f6);
        }
    }

    @Override // e.c, android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i5, int i6, int i7, int i8) {
        if (this.f604h) {
            super.setHotspotBounds(i5, i6, i7, i8);
        }
    }

    @Override // e.c, android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        if (this.f604h) {
            return super.setState(iArr);
        }
        return false;
    }

    @Override // e.c, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        if (this.f604h) {
            return super.setVisible(z4, z5);
        }
        return false;
    }
}
