package s3;

import android.graphics.Canvas;
/* loaded from: classes.dex */
public final class g extends h {
    @Override // p3.g
    public final void f(Canvas canvas) {
        if (this.D.f4878v.isEmpty()) {
            super.f(canvas);
            return;
        }
        canvas.save();
        canvas.clipOutRect(this.D.f4878v);
        super.f(canvas);
        canvas.restore();
    }
}
