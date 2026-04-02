package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class ChartsActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ChartsActivity f3192a;

    /* renamed from: b  reason: collision with root package name */
    private View f3193b;

    @UiThread
    public ChartsActivity_ViewBinding(final ChartsActivity chartsActivity, View view) {
        this.f3192a = chartsActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "method 'onViewClicked'");
        this.f3193b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.ChartsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                chartsActivity.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f3192a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3192a = null;
        this.f3193b.setOnClickListener(null);
        this.f3193b = null;
    }
}
