package androidx.recyclerview.widget;

import android.util.Log;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: d  reason: collision with root package name */
    public int f1305d = -1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1307f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f1308g = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f1302a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f1303b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1304c = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public Interpolator f1306e = null;

    public final void a(RecyclerView recyclerView) {
        int i5 = this.f1305d;
        if (i5 >= 0) {
            this.f1305d = -1;
            recyclerView.P(i5);
            this.f1307f = false;
        } else if (!this.f1307f) {
            this.f1308g = 0;
        } else {
            Interpolator interpolator = this.f1306e;
            if (interpolator != null && this.f1304c < 1) {
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            }
            int i6 = this.f1304c;
            if (i6 < 1) {
                throw new IllegalStateException("Scroll duration must be a positive number");
            }
            recyclerView.f1227j0.c(this.f1302a, this.f1303b, i6, interpolator);
            int i7 = this.f1308g + 1;
            this.f1308g = i7;
            if (i7 > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.f1307f = false;
        }
    }
}
