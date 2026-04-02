package p3;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public final float f4267a;

    public a(float f5) {
        this.f4267a = f5;
    }

    @Override // p3.c
    public final float a(RectF rectF) {
        return this.f4267a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f4267a == ((a) obj).f4267a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4267a)});
    }
}
