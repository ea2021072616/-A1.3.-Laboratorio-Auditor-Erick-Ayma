package androidx.appcompat.widget;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class b3 extends Property {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f297a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b3(Class cls, String str, int i5) {
        super(cls, str);
        this.f297a = i5;
    }

    public final Float a(View view) {
        switch (this.f297a) {
            case 6:
                return Float.valueOf(e1.c0.f2590a.w(view));
            case 7:
            default:
                WeakHashMap weakHashMap = h0.z0.f3233a;
                return Float.valueOf(view.getPaddingEnd());
            case 8:
                return Float.valueOf(view.getLayoutParams().width);
            case 9:
                return Float.valueOf(view.getLayoutParams().height);
            case 10:
                WeakHashMap weakHashMap2 = h0.z0.f3233a;
                return Float.valueOf(view.getPaddingStart());
        }
    }

    public final void b(View view, PointF pointF) {
        switch (this.f297a) {
            case 3:
                e1.c0.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
                return;
            case 4:
                e1.c0.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
                return;
            default:
                int round = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                e1.c0.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
                return;
        }
    }

    public final void c(View view, Float f5) {
        switch (this.f297a) {
            case 6:
                e1.c0.f2590a.S(view, f5.floatValue());
                return;
            case 7:
            default:
                WeakHashMap weakHashMap = h0.z0.f3233a;
                view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), f5.intValue(), view.getPaddingBottom());
                return;
            case 8:
                view.getLayoutParams().width = f5.intValue();
                view.requestLayout();
                return;
            case 9:
                view.getLayoutParams().height = f5.intValue();
                view.requestLayout();
                return;
            case 10:
                int intValue = f5.intValue();
                int paddingTop = view.getPaddingTop();
                WeakHashMap weakHashMap2 = h0.z0.f3233a;
                view.setPaddingRelative(intValue, paddingTop, view.getPaddingEnd(), view.getPaddingBottom());
                return;
        }
    }

    public final void d(e1.d dVar, PointF pointF) {
        switch (this.f297a) {
            case 1:
                dVar.getClass();
                dVar.f2592a = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                dVar.f2593b = round;
                int i5 = dVar.f2597f + 1;
                dVar.f2597f = i5;
                if (i5 == dVar.f2598g) {
                    e1.c0.a(dVar.f2596e, dVar.f2592a, round, dVar.f2594c, dVar.f2595d);
                    dVar.f2597f = 0;
                    dVar.f2598g = 0;
                    return;
                }
                return;
            default:
                dVar.getClass();
                dVar.f2594c = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                dVar.f2595d = round2;
                int i6 = dVar.f2598g + 1;
                dVar.f2598g = i6;
                if (dVar.f2597f == i6) {
                    e1.c0.a(dVar.f2596e, dVar.f2592a, dVar.f2593b, dVar.f2594c, round2);
                    dVar.f2597f = 0;
                    dVar.f2598g = 0;
                    return;
                }
                return;
        }
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f297a) {
            case 0:
                return Float.valueOf(((SwitchCompat) obj).F);
            case 1:
                e1.d dVar = (e1.d) obj;
                return null;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                e1.d dVar2 = (e1.d) obj;
                return null;
            case 3:
                View view = (View) obj;
                return null;
            case 4:
                View view2 = (View) obj;
                return null;
            case 5:
                View view3 = (View) obj;
                return null;
            case 6:
                return a((View) obj);
            case 7:
                return ((View) obj).getClipBounds();
            case 8:
                return a((View) obj);
            case 9:
                return a((View) obj);
            case 10:
                return a((View) obj);
            default:
                return a((View) obj);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f297a) {
            case 0:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                return;
            case 1:
                d((e1.d) obj, (PointF) obj2);
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                d((e1.d) obj, (PointF) obj2);
                return;
            case 3:
                b((View) obj, (PointF) obj2);
                return;
            case 4:
                b((View) obj, (PointF) obj2);
                return;
            case 5:
                b((View) obj, (PointF) obj2);
                return;
            case 6:
                c((View) obj, (Float) obj2);
                return;
            case 7:
                ((View) obj).setClipBounds((Rect) obj2);
                return;
            case 8:
                c((View) obj, (Float) obj2);
                return;
            case 9:
                c((View) obj, (Float) obj2);
                return;
            case 10:
                c((View) obj, (Float) obj2);
                return;
            default:
                c((View) obj, (Float) obj2);
                return;
        }
    }
}
