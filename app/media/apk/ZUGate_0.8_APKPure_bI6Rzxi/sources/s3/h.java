package s3;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class h extends p3.g {
    public static final /* synthetic */ int E = 0;
    public f D;

    public h(f fVar) {
        super(fVar);
        this.D = fVar;
    }

    @Override // p3.g, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.D = new f(this.D);
        return this;
    }

    public final void n(float f5, float f6, float f7, float f8) {
        RectF rectF = this.D.f4878v;
        if (f5 == rectF.left && f6 == rectF.top && f7 == rectF.right && f8 == rectF.bottom) {
            return;
        }
        rectF.set(f5, f6, f7, f8);
        invalidateSelf();
    }
}
