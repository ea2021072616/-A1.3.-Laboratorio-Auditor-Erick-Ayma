package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.SimpleViewPagerIndicator;
/* loaded from: classes.dex */
public class DiscoverFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DiscoverFragment f4534a;

    /* renamed from: b  reason: collision with root package name */
    private View f4535b;

    /* renamed from: c  reason: collision with root package name */
    private View f4536c;

    @UiThread
    public DiscoverFragment_ViewBinding(final DiscoverFragment discoverFragment, View view) {
        this.f4534a = discoverFragment;
        discoverFragment.appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.appBarLayout, "field 'appBarLayout'", AppBarLayout.class);
        discoverFragment.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.recognition_img, "field 'recognitionImg' and method 'onViewClicked'");
        discoverFragment.recognitionImg = (ImageView) Utils.castView(findRequiredView, R.id.recognition_img, "field 'recognitionImg'", ImageView.class);
        this.f4535b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.DiscoverFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                discoverFragment.onViewClicked(view2);
            }
        });
        discoverFragment.mTipsView = Utils.findRequiredView(view, R.id.recognition_tips_view, "field 'mTipsView'");
        discoverFragment.textTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.text_title, "field 'textTitle'", TextView.class);
        discoverFragment.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'viewPager'", ViewPager.class);
        discoverFragment.tab_layout = (SimpleViewPagerIndicator) Utils.findRequiredViewAsType(view, R.id.tab_layout, "field 'tab_layout'", SimpleViewPagerIndicator.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.search_img, "method 'onViewClicked'");
        this.f4536c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.DiscoverFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                discoverFragment.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DiscoverFragment discoverFragment = this.f4534a;
        if (discoverFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4534a = null;
        discoverFragment.appBarLayout = null;
        discoverFragment.toolbar = null;
        discoverFragment.recognitionImg = null;
        discoverFragment.mTipsView = null;
        discoverFragment.textTitle = null;
        discoverFragment.viewPager = null;
        discoverFragment.tab_layout = null;
        this.f4535b.setOnClickListener(null);
        this.f4535b = null;
        this.f4536c.setOnClickListener(null);
        this.f4536c = null;
    }
}
