package h;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public final class s extends FrameLayout implements g.c {

    /* renamed from: g  reason: collision with root package name */
    public final CollapsibleActionView f3069g;

    public s(View view) {
        super(view.getContext());
        this.f3069g = (CollapsibleActionView) view;
        addView(view);
    }
}
