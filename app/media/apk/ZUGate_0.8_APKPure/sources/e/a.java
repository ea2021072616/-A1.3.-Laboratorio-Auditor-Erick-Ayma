package e;

import android.graphics.drawable.Drawable;
import f1.d;
/* loaded from: classes.dex */
public final class a implements Drawable.Callback {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2557g = 1;

    /* renamed from: h  reason: collision with root package name */
    public Object f2558h;

    public a(d dVar) {
        this.f2558h = dVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.f2557g) {
            case 0:
                return;
            default:
                ((d) this.f2558h).invalidateSelf();
                return;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        switch (this.f2557g) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f2558h;
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j5);
                    return;
                }
                return;
            default:
                ((d) this.f2558h).scheduleSelf(runnable, j5);
                return;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.f2557g) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f2558h;
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                    return;
                }
                return;
            default:
                ((d) this.f2558h).unscheduleSelf(runnable);
                return;
        }
    }
}
