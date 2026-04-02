package p3;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final float f4313a;

    public h(float f5) {
        this.f4313a = f5;
    }

    @Override // p3.c
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f4313a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.f4313a == ((h) obj).f4313a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4313a)});
    }
}
