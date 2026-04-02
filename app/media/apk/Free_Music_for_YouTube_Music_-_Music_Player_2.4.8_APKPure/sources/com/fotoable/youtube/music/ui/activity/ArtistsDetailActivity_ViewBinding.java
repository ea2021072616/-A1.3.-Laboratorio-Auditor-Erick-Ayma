package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.RoundImageView;
/* loaded from: classes.dex */
public class ArtistsDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ArtistsDetailActivity f3188a;

    /* renamed from: b  reason: collision with root package name */
    private View f3189b;

    @UiThread
    public ArtistsDetailActivity_ViewBinding(final ArtistsDetailActivity artistsDetailActivity, View view) {
        this.f3188a = artistsDetailActivity;
        artistsDetailActivity.searchTabLayout = (SlidingTabLayout) Utils.findRequiredViewAsType(view, R.id.search_tab_layout, "field 'searchTabLayout'", SlidingTabLayout.class);
        artistsDetailActivity.searchViewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.search_view_pager, "field 'searchViewPager'", ViewPager.class);
        artistsDetailActivity.appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.app_barLayout, "field 'appBarLayout'", AppBarLayout.class);
        artistsDetailActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        artistsDetailActivity.rlDetails = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_details, "field 'rlDetails'", RelativeLayout.class);
        artistsDetailActivity.mainBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.main_backdrop, "field 'mainBg'", ImageView.class);
        artistsDetailActivity.imgIcon = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_LoadingPic, "field 'imgIcon'", RoundImageView.class);
        artistsDetailActivity.txtTitle = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", LaToTextView.class);
        artistsDetailActivity.txtDesc = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.txt_desc, "field 'txtDesc'", LaToTextView.class);
        artistsDetailActivity.imgMask = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_mask, "field 'imgMask'", ImageView.class);
        artistsDetailActivity.empty_bottom_bar = Utils.findRequiredView(view, R.id.empty_bottom_bar, "field 'empty_bottom_bar'");
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "method 'onViewClicked'");
        this.f3189b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.ArtistsDetailActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                artistsDetailActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ArtistsDetailActivity artistsDetailActivity = this.f3188a;
        if (artistsDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3188a = null;
        artistsDetailActivity.searchTabLayout = null;
        artistsDetailActivity.searchViewPager = null;
        artistsDetailActivity.appBarLayout = null;
        artistsDetailActivity.tvTitle = null;
        artistsDetailActivity.rlDetails = null;
        artistsDetailActivity.mainBg = null;
        artistsDetailActivity.imgIcon = null;
        artistsDetailActivity.txtTitle = null;
        artistsDetailActivity.txtDesc = null;
        artistsDetailActivity.imgMask = null;
        artistsDetailActivity.empty_bottom_bar = null;
        this.f3189b.setOnClickListener(null);
        this.f3189b = null;
    }
}
