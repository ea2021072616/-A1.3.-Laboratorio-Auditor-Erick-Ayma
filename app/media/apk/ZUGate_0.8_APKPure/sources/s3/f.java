package s3;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public final class f extends p3.f {

    /* renamed from: v  reason: collision with root package name */
    public final RectF f4878v;

    public f(p3.j jVar, RectF rectF) {
        super(jVar);
        this.f4878v = rectF;
    }

    @Override // p3.f, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        g gVar = new g(this);
        gVar.invalidateSelf();
        return gVar;
    }

    public f(f fVar) {
        super(fVar);
        this.f4878v = fVar.f4878v;
    }
}
