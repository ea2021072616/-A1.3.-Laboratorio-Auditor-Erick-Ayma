package i3;

import android.content.Context;
import com.github.appintro.R;
import e4.e;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f3412f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3413a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3414b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3415c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3416d;

    /* renamed from: e  reason: collision with root package name */
    public final float f3417e;

    public a(Context context) {
        boolean O = e.O(context, R.attr.elevationOverlayEnabled, false);
        int k5 = e.k(context, R.attr.elevationOverlayColor, 0);
        int k6 = e.k(context, R.attr.elevationOverlayAccentColor, 0);
        int k7 = e.k(context, R.attr.colorSurface, 0);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.f3413a = O;
        this.f3414b = k5;
        this.f3415c = k6;
        this.f3416d = k7;
        this.f3417e = f5;
    }
}
