package k3;

import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final c f3649a;

    /* renamed from: b  reason: collision with root package name */
    public final b f3650b;

    /* renamed from: c  reason: collision with root package name */
    public final View f3651c;

    public f(BottomSheetBehavior bottomSheetBehavior, FrameLayout frameLayout) {
        int i5 = Build.VERSION.SDK_INT;
        this.f3649a = i5 >= 34 ? new e() : i5 >= 33 ? new c() : null;
        this.f3650b = bottomSheetBehavior;
        this.f3651c = frameLayout;
    }
}
