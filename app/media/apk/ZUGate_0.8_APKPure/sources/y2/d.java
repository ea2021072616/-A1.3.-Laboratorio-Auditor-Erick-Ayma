package y2;

import android.view.View;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final View f5687a;

    /* renamed from: b  reason: collision with root package name */
    public int f5688b;

    /* renamed from: c  reason: collision with root package name */
    public int f5689c;

    /* renamed from: d  reason: collision with root package name */
    public int f5690d;

    public d(View view) {
        this.f5687a = view;
    }

    public final void a() {
        int i5 = this.f5690d;
        View view = this.f5687a;
        int top = i5 - (view.getTop() - this.f5688b);
        WeakHashMap weakHashMap = z0.f3233a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f5689c));
    }
}
