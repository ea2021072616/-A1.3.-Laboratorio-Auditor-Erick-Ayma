package q3;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;
/* loaded from: classes.dex */
public final class a extends p2.a {

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f4455u;

    /* renamed from: v  reason: collision with root package name */
    public final SideSheetBehavior f4456v;

    public /* synthetic */ a(SideSheetBehavior sideSheetBehavior, int i5) {
        this.f4455u = i5;
        this.f4456v = sideSheetBehavior;
    }

    public final int c0(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f4455u) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    public final float d0(int i5) {
        switch (this.f4455u) {
            case 0:
                float g02 = g0();
                return (i5 - g02) / (f0() - g02);
            default:
                float g03 = g0();
                return (g03 - i5) / (g03 - f0());
        }
    }

    public final int e0(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f4455u) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    public final int f0() {
        int i5 = this.f4455u;
        SideSheetBehavior sideSheetBehavior = this.f4456v;
        switch (i5) {
            case 0:
                return Math.max(0, sideSheetBehavior.f2185n + sideSheetBehavior.o);
            default:
                return Math.max(0, (g0() - sideSheetBehavior.f2183l) - sideSheetBehavior.o);
        }
    }

    public final int g0() {
        int i5 = this.f4455u;
        SideSheetBehavior sideSheetBehavior = this.f4456v;
        switch (i5) {
            case 0:
                return (-sideSheetBehavior.f2183l) - sideSheetBehavior.o;
            default:
                return sideSheetBehavior.f2184m;
        }
    }

    public final int h0(View view) {
        int i5 = this.f4455u;
        SideSheetBehavior sideSheetBehavior = this.f4456v;
        switch (i5) {
            case 0:
                return view.getRight() + sideSheetBehavior.o;
            default:
                return view.getLeft() - sideSheetBehavior.o;
        }
    }

    public final int i0(CoordinatorLayout coordinatorLayout) {
        switch (this.f4455u) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    public final boolean j0(float f5) {
        switch (this.f4455u) {
            case 0:
                return f5 > 0.0f;
            default:
                return f5 < 0.0f;
        }
    }

    public final boolean k0(View view) {
        switch (this.f4455u) {
            case 0:
                return view.getRight() < (f0() - g0()) / 2;
            default:
                return view.getLeft() > (f0() + g0()) / 2;
        }
    }

    public final boolean l0(float f5, float f6) {
        int i5 = this.f4455u;
        SideSheetBehavior sideSheetBehavior = this.f4456v;
        switch (i5) {
            case 0:
                if (Math.abs(f5) > Math.abs(f6)) {
                    float abs = Math.abs(f5);
                    sideSheetBehavior.getClass();
                    if (abs > 500) {
                        return true;
                    }
                }
                return false;
            default:
                if (Math.abs(f5) > Math.abs(f6)) {
                    float abs2 = Math.abs(f5);
                    sideSheetBehavior.getClass();
                    if (abs2 > 500) {
                        return true;
                    }
                }
                return false;
        }
    }

    public final boolean m0(View view, float f5) {
        int i5 = this.f4455u;
        SideSheetBehavior sideSheetBehavior = this.f4456v;
        switch (i5) {
            case 0:
                return Math.abs((f5 * sideSheetBehavior.f2182k) + ((float) view.getLeft())) > 0.5f;
            default:
                return Math.abs((f5 * sideSheetBehavior.f2182k) + ((float) view.getRight())) > 0.5f;
        }
    }
}
