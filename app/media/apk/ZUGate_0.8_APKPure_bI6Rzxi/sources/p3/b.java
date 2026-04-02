package p3;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final c f4268a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4269b;

    public b(float f5, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f4268a;
            f5 += ((b) cVar).f4269b;
        }
        this.f4268a = cVar;
        this.f4269b = f5;
    }

    @Override // p3.c
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f4268a.a(rectF) + this.f4269b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f4268a.equals(bVar.f4268a) && this.f4269b == bVar.f4269b;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4268a, Float.valueOf(this.f4269b)});
    }
}
