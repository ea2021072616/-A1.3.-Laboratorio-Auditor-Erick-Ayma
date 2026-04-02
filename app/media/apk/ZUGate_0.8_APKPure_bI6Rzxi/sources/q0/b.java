package q0;

import android.graphics.Rect;
import i0.j;
import java.util.Comparator;
import p3.e;
/* loaded from: classes.dex */
public final class b implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f4428a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public final Rect f4429b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4430c;

    /* renamed from: d  reason: collision with root package name */
    public final e f4431d;

    public b(boolean z4, e eVar) {
        this.f4430c = z4;
        this.f4431d = eVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.f4431d.getClass();
        Rect rect = this.f4428a;
        ((j) obj).f(rect);
        Rect rect2 = this.f4429b;
        ((j) obj2).f(rect2);
        int i5 = rect.top;
        int i6 = rect2.top;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        int i7 = rect.left;
        int i8 = rect2.left;
        boolean z4 = this.f4430c;
        if (i7 < i8) {
            return z4 ? 1 : -1;
        } else if (i7 > i8) {
            return z4 ? -1 : 1;
        } else {
            int i9 = rect.bottom;
            int i10 = rect2.bottom;
            if (i9 < i10) {
                return -1;
            }
            if (i9 > i10) {
                return 1;
            }
            int i11 = rect.right;
            int i12 = rect2.right;
            if (i11 < i12) {
                return z4 ? 1 : -1;
            } else if (i11 > i12) {
                return z4 ? -1 : 1;
            } else {
                return 0;
            }
        }
    }
}
