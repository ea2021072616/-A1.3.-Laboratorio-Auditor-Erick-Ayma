package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class HomeFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private HomeFragment f4589a;

    @UiThread
    public HomeFragment_ViewBinding(HomeFragment homeFragment, View view) {
        this.f4589a = homeFragment;
        homeFragment.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'viewPager'", ViewPager.class);
        homeFragment.tab_layout = (SlidingTabLayout) Utils.findRequiredViewAsType(view, R.id.tab_layout, "field 'tab_layout'", SlidingTabLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HomeFragment homeFragment = this.f4589a;
        if (homeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4589a = null;
        homeFragment.viewPager = null;
        homeFragment.tab_layout = null;
    }
}
