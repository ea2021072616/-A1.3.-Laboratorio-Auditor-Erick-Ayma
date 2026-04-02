package p3;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
/* loaded from: classes.dex */
public final class p extends r {

    /* renamed from: h  reason: collision with root package name */
    public static final RectF f4345h = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public float f4346b;

    /* renamed from: c  reason: collision with root package name */
    public float f4347c;

    /* renamed from: d  reason: collision with root package name */
    public float f4348d;

    /* renamed from: e  reason: collision with root package name */
    public float f4349e;

    /* renamed from: f  reason: collision with root package name */
    public float f4350f;

    /* renamed from: g  reason: collision with root package name */
    public float f4351g;

    public p(float f5, float f6, float f7, float f8) {
        this.f4346b = f5;
        this.f4347c = f6;
        this.f4348d = f7;
        this.f4349e = f8;
    }

    @Override // p3.r
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f4354a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        RectF rectF = f4345h;
        rectF.set(this.f4346b, this.f4347c, this.f4348d, this.f4349e);
        path.arcTo(rectF, this.f4350f, this.f4351g, false);
        path.transform(matrix);
    }
}
