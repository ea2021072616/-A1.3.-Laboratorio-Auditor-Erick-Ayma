package y0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i1;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
/* loaded from: classes.dex */
public final class b0 extends h0.b {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f5594d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f5595e;

    public /* synthetic */ b0(int i5, Object obj) {
        this.f5594d = i5;
        this.f5595e = obj;
    }

    @Override // h0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f5594d) {
            case 3:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.f5595e).isChecked());
                return;
            default:
                super.c(view, accessibilityEvent);
                return;
        }
    }

    @Override // h0.b
    public final void d(View view, i0.j jVar) {
        RecyclerView recyclerView;
        int i5;
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        int i6 = this.f5594d;
        int i7 = -1;
        View.AccessibilityDelegate accessibilityDelegate = this.f3105a;
        Object obj = this.f5595e;
        switch (i6) {
            case 0:
                c0 c0Var = (c0) obj;
                c0Var.f5598g.d(view, jVar);
                RecyclerView recyclerView2 = c0Var.f5597f;
                recyclerView2.getClass();
                i1 L = RecyclerView.L(view);
                if (L != null && (recyclerView = L.f1392r) != null) {
                    i7 = recyclerView.I(L);
                }
                androidx.recyclerview.widget.i0 adapter = recyclerView2.getAdapter();
                if (adapter instanceof v) {
                    ((v) adapter).i(i7);
                    return;
                }
                return;
            case 1:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                if (!((y4.a) obj).f5712p) {
                    accessibilityNodeInfo.setDismissable(false);
                    return;
                }
                jVar.a(1048576);
                accessibilityNodeInfo.setDismissable(true);
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                int i8 = MaterialButtonToggleGroup.f2066q;
                materialButtonToggleGroup.getClass();
                if (view instanceof MaterialButton) {
                    int i9 = 0;
                    for (int i10 = 0; i10 < materialButtonToggleGroup.getChildCount(); i10++) {
                        if (materialButtonToggleGroup.getChildAt(i10) == view) {
                            i5 = i9;
                            accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, i5, 1, false, ((MaterialButton) view).isChecked()));
                            return;
                        }
                        if ((materialButtonToggleGroup.getChildAt(i10) instanceof MaterialButton) && materialButtonToggleGroup.d(i10)) {
                            i9++;
                        }
                    }
                }
                i5 = -1;
                accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, i5, 1, false, ((MaterialButton) view).isChecked()));
                return;
            case 3:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo.setCheckable(checkableImageButton.f2169k);
                accessibilityNodeInfo.setChecked(checkableImageButton.isChecked());
                return;
            case 4:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCheckable(((NavigationMenuItemView) obj).D);
                return;
            default:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                jVar.a(1048576);
                accessibilityNodeInfo.setDismissable(true);
                return;
        }
    }

    @Override // h0.b
    public final boolean g(View view, int i5, Bundle bundle) {
        int i6 = this.f5594d;
        Object obj = this.f5595e;
        switch (i6) {
            case 0:
                return ((c0) obj).f5598g.g(view, i5, bundle);
            case 1:
                if (i5 == 1048576) {
                    y4.a aVar = (y4.a) obj;
                    if (aVar.f5712p) {
                        aVar.cancel();
                        return true;
                    }
                }
                return super.g(view, i5, bundle);
            case 5:
                if (i5 == 1048576) {
                    ((r3.o) ((r3.l) obj)).a(3);
                    return true;
                }
                return super.g(view, i5, bundle);
            default:
                return super.g(view, i5, bundle);
        }
    }
}
