package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class RadioHomeActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RadioHomeActivity f3745a;

    /* renamed from: b  reason: collision with root package name */
    private View f3746b;

    @UiThread
    public RadioHomeActivity_ViewBinding(final RadioHomeActivity radioHomeActivity, View view) {
        this.f3745a = radioHomeActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "field 'backView' and method 'onViewClicked'");
        radioHomeActivity.backView = (ImageView) Utils.castView(findRequiredView, R.id.back_view, "field 'backView'", ImageView.class);
        this.f3746b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.RadioHomeActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radioHomeActivity.onViewClicked();
            }
        });
        radioHomeActivity.radioTabLayout = (SlidingTabLayout) Utils.findRequiredViewAsType(view, R.id.radio_tab_layout, "field 'radioTabLayout'", SlidingTabLayout.class);
        radioHomeActivity.radioViewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.radio_view_pager, "field 'radioViewPager'", ViewPager.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RadioHomeActivity radioHomeActivity = this.f3745a;
        if (radioHomeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3745a = null;
        radioHomeActivity.backView = null;
        radioHomeActivity.radioTabLayout = null;
        radioHomeActivity.radioViewPager = null;
        this.f3746b.setOnClickListener(null);
        this.f3746b = null;
    }
}
