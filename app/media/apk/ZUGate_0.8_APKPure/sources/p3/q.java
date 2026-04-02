package p3;

import android.graphics.Matrix;
import android.graphics.Path;
/* loaded from: classes.dex */
public final class q extends r {

    /* renamed from: b  reason: collision with root package name */
    public float f4352b;

    /* renamed from: c  reason: collision with root package name */
    public float f4353c;

    @Override // p3.r
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f4354a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f4352b, this.f4353c);
        path.transform(matrix);
    }
}
