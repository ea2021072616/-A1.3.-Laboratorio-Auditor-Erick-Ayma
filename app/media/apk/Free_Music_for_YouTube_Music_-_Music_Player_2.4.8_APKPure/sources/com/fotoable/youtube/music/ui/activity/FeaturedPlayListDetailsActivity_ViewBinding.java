package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.RoundImageView;
/* loaded from: classes.dex */
public class FeaturedPlayListDetailsActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private FeaturedPlayListDetailsActivity f3318a;

    /* renamed from: b  reason: collision with root package name */
    private View f3319b;

    /* renamed from: c  reason: collision with root package name */
    private View f3320c;
    private View d;
    private View e;
    private View f;

    @UiThread
    public FeaturedPlayListDetailsActivity_ViewBinding(final FeaturedPlayListDetailsActivity featuredPlayListDetailsActivity, View view) {
        this.f3318a = featuredPlayListDetailsActivity;
        featuredPlayListDetailsActivity.recyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_pop, "field 'recyclerView'", IRecyclerView.class);
        featuredPlayListDetailsActivity.mainBackdrop = (ImageView) Utils.findRequiredViewAsType(view, R.id.main_backdrop, "field 'mainBackdrop'", ImageView.class);
        featuredPlayListDetailsActivity.ivLoadingPic = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_LoadingPic, "field 'ivLoadingPic'", RoundImageView.class);
        featuredPlayListDetailsActivity.textDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.text_details, "field 'textDetails'", TextView.class);
        featuredPlayListDetailsActivity.textPeople = (TextView) Utils.findRequiredViewAsType(view, R.id.text_people, "field 'textPeople'", TextView.class);
        featuredPlayListDetailsActivity.textListen = (TextView) Utils.findRequiredViewAsType(view, R.id.text_listen, "field 'textListen'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.che_subscribed, "field 'che_subscribed' and method 'onCheckedChanged'");
        featuredPlayListDetailsActivity.che_subscribed = (CheckBox) Utils.castView(findRequiredView, R.id.che_subscribed, "field 'che_subscribed'", CheckBox.class);
        this.f3319b = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                featuredPlayListDetailsActivity.onCheckedChanged(compoundButton, z);
            }
        });
        featuredPlayListDetailsActivity.rlDetails = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_details, "field 'rlDetails'", RelativeLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack' and method 'onClick'");
        featuredPlayListDetailsActivity.imgBack = (ImageView) Utils.castView(findRequiredView2, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3320c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                featuredPlayListDetailsActivity.onClick(view2);
            }
        });
        featuredPlayListDetailsActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        featuredPlayListDetailsActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        featuredPlayListDetailsActivity.collapsingToolbarLayout = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.CollapsingToolbarLayout, "field 'collapsingToolbarLayout'", CollapsingToolbarLayout.class);
        featuredPlayListDetailsActivity.appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.app_barLayout, "field 'appBarLayout'", AppBarLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_play_all, "field 'ivPlayAll' and method 'onClick'");
        featuredPlayListDetailsActivity.ivPlayAll = (Button) Utils.castView(findRequiredView3, R.id.iv_play_all, "field 'ivPlayAll'", Button.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                featuredPlayListDetailsActivity.onClick(view2);
            }
        });
        featuredPlayListDetailsActivity.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.ll_error, "field 'tvError' and method 'onClick'");
        featuredPlayListDetailsActivity.tvError = (LinearLayout) Utils.castView(findRequiredView4, R.id.ll_error, "field 'tvError'", LinearLayout.class);
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                featuredPlayListDetailsActivity.onClick();
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.img_del, "field 'delImage' and method 'onClick'");
        featuredPlayListDetailsActivity.delImage = (ImageView) Utils.castView(findRequiredView5, R.id.img_del, "field 'delImage'", ImageView.class);
        this.f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                featuredPlayListDetailsActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeaturedPlayListDetailsActivity featuredPlayListDetailsActivity = this.f3318a;
        if (featuredPlayListDetailsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3318a = null;
        featuredPlayListDetailsActivity.recyclerView = null;
        featuredPlayListDetailsActivity.mainBackdrop = null;
        featuredPlayListDetailsActivity.ivLoadingPic = null;
        featuredPlayListDetailsActivity.textDetails = null;
        featuredPlayListDetailsActivity.textPeople = null;
        featuredPlayListDetailsActivity.textListen = null;
        featuredPlayListDetailsActivity.che_subscribed = null;
        featuredPlayListDetailsActivity.rlDetails = null;
        featuredPlayListDetailsActivity.imgBack = null;
        featuredPlayListDetailsActivity.tvTitle = null;
        featuredPlayListDetailsActivity.toolbar = null;
        featuredPlayListDetailsActivity.collapsingToolbarLayout = null;
        featuredPlayListDetailsActivity.appBarLayout = null;
        featuredPlayListDetailsActivity.ivPlayAll = null;
        featuredPlayListDetailsActivity.refreshLayout = null;
        featuredPlayListDetailsActivity.tvError = null;
        featuredPlayListDetailsActivity.delImage = null;
        ((CompoundButton) this.f3319b).setOnCheckedChangeListener(null);
        this.f3319b = null;
        this.f3320c.setOnClickListener(null);
        this.f3320c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
    }
}
