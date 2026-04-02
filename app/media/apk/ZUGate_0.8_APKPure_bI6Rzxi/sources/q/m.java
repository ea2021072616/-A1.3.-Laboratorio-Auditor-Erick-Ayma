package q;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.internal.play_billing.i0;
import java.lang.ref.WeakReference;
import s.s;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public int f4403a;

    /* renamed from: b  reason: collision with root package name */
    public int f4404b;

    /* renamed from: c  reason: collision with root package name */
    public int f4405c;

    /* renamed from: d  reason: collision with root package name */
    public int f4406d;

    /* renamed from: e  reason: collision with root package name */
    public int f4407e;

    /* renamed from: f  reason: collision with root package name */
    public int f4408f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f4409g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f4410h;

    public m(n nVar, p.e eVar, n.d dVar, int i5) {
        this.f4410h = nVar;
        this.f4409g = new WeakReference(eVar);
        p.d dVar2 = eVar.I;
        dVar.getClass();
        this.f4403a = n.d.n(dVar2);
        this.f4404b = n.d.n(eVar.J);
        this.f4405c = n.d.n(eVar.K);
        this.f4406d = n.d.n(eVar.L);
        this.f4407e = n.d.n(eVar.M);
        this.f4408f = i5;
    }

    public static boolean a(int i5, int i6, int i7) {
        if (i5 == i6) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i5);
        View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i7 == size;
        }
        return false;
    }

    public final void b(p.e eVar, b bVar) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int max;
        int i5;
        int i6;
        int i7;
        boolean z4;
        int baseline;
        int i8;
        if (eVar == null) {
            return;
        }
        if (eVar.f4171g0 == 8) {
            bVar.f4369e = 0;
            bVar.f4370f = 0;
            bVar.f4371g = 0;
        } else if (eVar.T == null) {
        } else {
            int i9 = bVar.f4365a;
            int i10 = bVar.f4366b;
            int i11 = bVar.f4367c;
            int i12 = bVar.f4368d;
            int i13 = this.f4403a + this.f4404b;
            int i14 = this.f4405c;
            View view = (View) eVar.f4169f0;
            int b5 = n.h.b(i9);
            p.d dVar = eVar.K;
            p.d dVar2 = eVar.I;
            if (b5 == 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            } else if (b5 == 1) {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4407e, i14, -2);
            } else if (b5 == 2) {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4407e, i14, -2);
                boolean z5 = eVar.f4190r == 1;
                int i15 = bVar.f4374j;
                if (i15 == 1 || i15 == 2) {
                    if (bVar.f4374j == 2 || !z5 || (z5 && (view.getMeasuredHeight() == eVar.l())) || eVar.B()) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(eVar.r(), 1073741824);
                    }
                }
            } else if (b5 != 3) {
                makeMeasureSpec = 0;
            } else {
                int i16 = this.f4407e;
                int i17 = dVar2 != null ? dVar2.f4155g + 0 : 0;
                if (dVar != null) {
                    i17 += dVar.f4155g;
                }
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(i16, i14 + i17, -1);
            }
            int b6 = n.h.b(i10);
            if (b6 == 0) {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else if (b6 == 1) {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4408f, i13, -2);
            } else if (b6 == 2) {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4408f, i13, -2);
                boolean z6 = eVar.f4191s == 1;
                int i18 = bVar.f4374j;
                if (i18 == 1 || i18 == 2) {
                    if (bVar.f4374j == 2 || !z6 || (z6 && (view.getMeasuredWidth() == eVar.r())) || eVar.C()) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.l(), 1073741824);
                    }
                }
            } else if (b6 != 3) {
                makeMeasureSpec2 = 0;
            } else {
                int i19 = this.f4408f;
                int i20 = dVar2 != null ? eVar.J.f4155g + 0 : 0;
                if (dVar != null) {
                    i20 += eVar.L.f4155g;
                }
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i19, i13 + i20, -1);
            }
            p.f fVar = (p.f) eVar.T;
            Object obj = this.f4410h;
            if (fVar != null && i0.v(((ConstraintLayout) obj).o, 256) && view.getMeasuredWidth() == eVar.r() && view.getMeasuredWidth() < fVar.r() && view.getMeasuredHeight() == eVar.l() && view.getMeasuredHeight() < fVar.l() && view.getBaseline() == eVar.f4159a0 && !eVar.A()) {
                if (a(eVar.G, makeMeasureSpec, eVar.r()) && a(eVar.H, makeMeasureSpec2, eVar.l())) {
                    bVar.f4369e = eVar.r();
                    bVar.f4370f = eVar.l();
                    bVar.f4371g = eVar.f4159a0;
                    return;
                }
            }
            boolean z7 = i9 == 3;
            boolean z8 = i10 == 3;
            boolean z9 = i10 == 4 || i10 == 1;
            boolean z10 = i9 == 4 || i9 == 1;
            boolean z11 = z7 && eVar.W > 0.0f;
            boolean z12 = z8 && eVar.W > 0.0f;
            if (view == null) {
                return;
            }
            s.e eVar2 = (s.e) view.getLayoutParams();
            int i21 = bVar.f4374j;
            if (i21 != 1 && i21 != 2 && z7 && eVar.f4190r == 0 && z8 && eVar.f4191s == 0) {
                z4 = false;
                i8 = -1;
                baseline = 0;
                max = 0;
                i6 = 0;
            } else {
                if ((view instanceof s) && (eVar instanceof p.h)) {
                    ((s) view).j((p.h) eVar, makeMeasureSpec, makeMeasureSpec2);
                } else {
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                }
                eVar.G = makeMeasureSpec;
                eVar.H = makeMeasureSpec2;
                eVar.f4170g = false;
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                int baseline2 = view.getBaseline();
                int i22 = eVar.f4193u;
                max = i22 > 0 ? Math.max(i22, measuredWidth) : measuredWidth;
                int i23 = eVar.f4194v;
                if (i23 > 0) {
                    max = Math.min(i23, max);
                }
                int i24 = eVar.f4196x;
                if (i24 > 0) {
                    i6 = Math.max(i24, measuredHeight);
                    i5 = makeMeasureSpec2;
                } else {
                    i5 = makeMeasureSpec2;
                    i6 = measuredHeight;
                }
                int i25 = eVar.f4197y;
                if (i25 > 0) {
                    i6 = Math.min(i25, i6);
                }
                if (!i0.v(((ConstraintLayout) obj).o, 1)) {
                    if (z11 && z9) {
                        max = (int) ((i6 * eVar.W) + 0.5f);
                    } else if (z12 && z10) {
                        i6 = (int) ((max / eVar.W) + 0.5f);
                    }
                }
                if (measuredWidth == max && measuredHeight == i6) {
                    baseline = baseline2;
                    z4 = false;
                } else {
                    if (measuredWidth != max) {
                        i7 = 1073741824;
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
                    } else {
                        i7 = 1073741824;
                    }
                    int makeMeasureSpec3 = measuredHeight != i6 ? View.MeasureSpec.makeMeasureSpec(i6, i7) : i5;
                    view.measure(makeMeasureSpec, makeMeasureSpec3);
                    eVar.G = makeMeasureSpec;
                    eVar.H = makeMeasureSpec3;
                    z4 = false;
                    eVar.f4170g = false;
                    int measuredWidth2 = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    i6 = measuredHeight2;
                    max = measuredWidth2;
                }
                i8 = -1;
            }
            boolean z13 = baseline != i8 ? true : z4;
            bVar.f4373i = (max == bVar.f4367c && i6 == bVar.f4368d) ? z4 : true;
            boolean z14 = eVar2.f4657c0 ? true : z13;
            if (z14 && baseline != -1 && eVar.f4159a0 != baseline) {
                bVar.f4373i = true;
            }
            bVar.f4369e = max;
            bVar.f4370f = i6;
            bVar.f4372h = z14;
            bVar.f4371g = baseline;
        }
    }

    public m(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.f4410h = constraintLayout;
        this.f4409g = constraintLayout2;
    }
}
