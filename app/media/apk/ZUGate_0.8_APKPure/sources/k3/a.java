package k3;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import com.github.appintro.R;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final TimeInterpolator f3640a;

    /* renamed from: b  reason: collision with root package name */
    public final View f3641b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3642c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3643d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3644e;

    /* renamed from: f  reason: collision with root package name */
    public androidx.activity.b f3645f;

    public a(View view) {
        this.f3641b = view;
        Context context = view.getContext();
        this.f3640a = p2.a.R(context, R.attr.motionEasingStandardDecelerateInterpolator, j0.a.b(0.0f, 0.0f, 0.0f, 1.0f));
        this.f3642c = p2.a.Q(context, R.attr.motionDurationMedium2, 300);
        this.f3643d = p2.a.Q(context, R.attr.motionDurationShort3, 150);
        this.f3644e = p2.a.Q(context, R.attr.motionDurationShort2, 100);
    }
}
