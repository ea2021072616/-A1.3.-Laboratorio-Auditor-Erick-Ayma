package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class FeaturedFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private FeaturedFragment f4565a;

    /* renamed from: b  reason: collision with root package name */
    private View f4566b;

    @UiThread
    public FeaturedFragment_ViewBinding(final FeaturedFragment featuredFragment, View view) {
        this.f4565a = featuredFragment;
        featuredFragment.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        featuredFragment.carouselPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.carousel_pager, "field 'carouselPager'", ViewPager.class);
        featuredFragment.carouselPointLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.carousel_point_ll, "field 'carouselPointLayout'", LinearLayout.class);
        featuredFragment.carouselPagerPanel = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.carousel_pager_panel, "field 'carouselPagerPanel'", RelativeLayout.class);
        featuredFragment.artistsView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.featured_artists_view, "field 'artistsView'", LinearLayout.class);
        featuredFragment.genresView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.featured_genres_view, "field 'genresView'", LinearLayout.class);
        featuredFragment.recyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
        featuredFragment.tvError = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_error, "field 'tvError'", LaToTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.ll_error, "field 'llError', method 'onClick', and method 'onViewClicked'");
        featuredFragment.llError = (LinearLayout) Utils.castView(findRequiredView, R.id.ll_error, "field 'llError'", LinearLayout.class);
        this.f4566b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                featuredFragment.onClick();
                featuredFragment.onViewClicked(view2);
            }
        });
        featuredFragment.chartsView = Utils.findRequiredView(view, R.id.featured_charts_view, "field 'chartsView'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeaturedFragment featuredFragment = this.f4565a;
        if (featuredFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4565a = null;
        featuredFragment.refreshLayout = null;
        featuredFragment.carouselPager = null;
        featuredFragment.carouselPointLayout = null;
        featuredFragment.carouselPagerPanel = null;
        featuredFragment.artistsView = null;
        featuredFragment.genresView = null;
        featuredFragment.recyclerview = null;
        featuredFragment.tvError = null;
        featuredFragment.llError = null;
        featuredFragment.chartsView = null;
        this.f4566b.setOnClickListener(null);
        this.f4566b = null;
    }
}
