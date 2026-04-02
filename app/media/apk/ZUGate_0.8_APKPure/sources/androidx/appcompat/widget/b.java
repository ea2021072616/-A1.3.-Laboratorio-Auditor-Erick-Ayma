package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public final class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final ActionBarContainer f285a;

    public b(ActionBarContainer actionBarContainer) {
        this.f285a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f285a;
        if (actionBarContainer.f163m) {
            Drawable drawable = actionBarContainer.f162l;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f160j;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.f161k;
        if (drawable3 == null || !actionBarContainer.f164n) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f285a;
        if (actionBarContainer.f163m) {
            if (actionBarContainer.f162l != null) {
                actionBarContainer.f160j.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable = actionBarContainer.f160j;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
