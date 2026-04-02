package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.SimpleViewPagerIndicator;
/* loaded from: classes.dex */
public class ChartsFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ChartsFragment f4497a;

    @UiThread
    public ChartsFragment_ViewBinding(ChartsFragment chartsFragment, View view) {
        this.f4497a = chartsFragment;
        chartsFragment.simpleViewPagerIndicator = (SimpleViewPagerIndicator) Utils.findRequiredViewAsType(view, R.id.tab_layout, "field 'simpleViewPagerIndicator'", SimpleViewPagerIndicator.class);
        chartsFragment.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
        chartsFragment.shadow_view = Utils.findRequiredView(view, R.id.shadow_view, "field 'shadow_view'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChartsFragment chartsFragment = this.f4497a;
        if (chartsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4497a = null;
        chartsFragment.simpleViewPagerIndicator = null;
        chartsFragment.viewpager = null;
        chartsFragment.shadow_view = null;
    }
}
