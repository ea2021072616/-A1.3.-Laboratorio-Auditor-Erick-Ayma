package q0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.b0;
import com.google.android.material.chip.Chip;
import h0.z0;
import i0.j;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class a extends b0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ f3.d f4427h;

    public a(f3.d dVar) {
        this.f4427h = dVar;
    }

    @Override // androidx.recyclerview.widget.b0
    public final j b(int i5) {
        return new j(AccessibilityNodeInfo.obtain(this.f4427h.n(i5).f3375a));
    }

    @Override // androidx.recyclerview.widget.b0
    public final j c(int i5) {
        f3.d dVar = this.f4427h;
        int i6 = i5 == 2 ? dVar.f2832k : dVar.f2833l;
        if (i6 == Integer.MIN_VALUE) {
            return null;
        }
        return b(i6);
    }

    @Override // androidx.recyclerview.widget.b0
    public final boolean d(int i5, int i6, Bundle bundle) {
        int i7;
        f3.d dVar = this.f4427h;
        View view = dVar.f2830i;
        if (i5 == -1) {
            WeakHashMap weakHashMap = z0.f3233a;
            return view.performAccessibilityAction(i6, bundle);
        }
        boolean z4 = true;
        if (i6 != 1) {
            if (i6 != 2) {
                boolean z5 = false;
                if (i6 == 64) {
                    AccessibilityManager accessibilityManager = dVar.f2829h;
                    if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled() && (i7 = dVar.f2832k) != i5) {
                        if (i7 != Integer.MIN_VALUE) {
                            dVar.f2832k = Integer.MIN_VALUE;
                            dVar.f2830i.invalidate();
                            dVar.q(i7, 65536);
                        }
                        dVar.f2832k = i5;
                        view.invalidate();
                        dVar.q(i5, 32768);
                    }
                    z4 = false;
                } else if (i6 != 128) {
                    if (i6 == 16) {
                        Chip chip = dVar.f2835n;
                        if (i5 == 0) {
                            return chip.performClick();
                        }
                        if (i5 == 1) {
                            chip.playSoundEffect(0);
                            View.OnClickListener onClickListener = chip.f2082n;
                            if (onClickListener != null) {
                                onClickListener.onClick(chip);
                                z5 = true;
                            }
                            if (chip.f2092y) {
                                chip.f2091x.q(1, 1);
                            }
                        }
                    }
                    return z5;
                } else {
                    if (dVar.f2832k == i5) {
                        dVar.f2832k = Integer.MIN_VALUE;
                        view.invalidate();
                        dVar.q(i5, 65536);
                    }
                    z4 = false;
                }
                return z4;
            }
            return dVar.j(i5);
        }
        return dVar.p(i5);
    }
}
