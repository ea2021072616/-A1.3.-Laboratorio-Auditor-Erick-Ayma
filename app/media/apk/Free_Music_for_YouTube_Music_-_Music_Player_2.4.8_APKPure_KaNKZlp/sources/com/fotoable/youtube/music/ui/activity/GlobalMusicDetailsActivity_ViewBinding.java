package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.RoundImageView;
/* loaded from: classes.dex */
public class GlobalMusicDetailsActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private GlobalMusicDetailsActivity f3354a;

    /* renamed from: b  reason: collision with root package name */
    private View f3355b;

    /* renamed from: c  reason: collision with root package name */
    private View f3356c;
    private View d;

    @UiThread
    public GlobalMusicDetailsActivity_ViewBinding(final GlobalMusicDetailsActivity globalMusicDetailsActivity, View view) {
        this.f3354a = globalMusicDetailsActivity;
        globalMusicDetailsActivity.recyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_pop, "field 'recyclerView'", IRecyclerView.class);
        globalMusicDetailsActivity.mainBackdrop = (ImageView) Utils.findRequiredViewAsType(view, R.id.main_backdrop, "field 'mainBackdrop'", ImageView.class);
        globalMusicDetailsActivity.ivLoadingPic = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_LoadingPic, "field 'ivLoadingPic'", RoundImageView.class);
        globalMusicDetailsActivity.rlDetails = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_details, "field 'rlDetails'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack' and method 'onClick'");
        globalMusicDetailsActivity.imgBack = (ImageView) Utils.castView(findRequiredView, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3355b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.GlobalMusicDetailsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                globalMusicDetailsActivity.onClick(view2);
            }
        });
        globalMusicDetailsActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        globalMusicDetailsActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        globalMusicDetailsActivity.collapsingToolbarLayout = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.CollapsingToolbarLayout, "field 'collapsingToolbarLayout'", CollapsingToolbarLayout.class);
        globalMusicDetailsActivity.appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.app_barLayout, "field 'appBarLayout'", AppBarLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_play_all, "field 'ivPlayAll' and method 'onClick'");
        globalMusicDetailsActivity.ivPlayAll = (Button) Utils.castView(findRequiredView2, R.id.iv_play_all, "field 'ivPlayAll'", Button.class);
        this.f3356c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.GlobalMusicDetailsActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                globalMusicDetailsActivity.onClick(view2);
            }
        });
        globalMusicDetailsActivity.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.ll_error, "field 'tvError' and method 'onClick'");
        globalMusicDetailsActivity.tvError = (LinearLayout) Utils.castView(findRequiredView3, R.id.ll_error, "field 'tvError'", LinearLayout.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.GlobalMusicDetailsActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                globalMusicDetailsActivity.onClick(view2);
            }
        });
        globalMusicDetailsActivity.txtUpdateTime = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_update_time, "field 'txtUpdateTime'", TextView.class);
        globalMusicDetailsActivity.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GlobalMusicDetailsActivity globalMusicDetailsActivity = this.f3354a;
        if (globalMusicDetailsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3354a = null;
        globalMusicDetailsActivity.recyclerView = null;
        globalMusicDetailsActivity.mainBackdrop = null;
        globalMusicDetailsActivity.ivLoadingPic = null;
        globalMusicDetailsActivity.rlDetails = null;
        globalMusicDetailsActivity.imgBack = null;
        globalMusicDetailsActivity.tvTitle = null;
        globalMusicDetailsActivity.toolbar = null;
        globalMusicDetailsActivity.collapsingToolbarLayout = null;
        globalMusicDetailsActivity.appBarLayout = null;
        globalMusicDetailsActivity.ivPlayAll = null;
        globalMusicDetailsActivity.refreshLayout = null;
        globalMusicDetailsActivity.tvError = null;
        globalMusicDetailsActivity.txtUpdateTime = null;
        globalMusicDetailsActivity.txtTitle = null;
        this.f3355b.setOnClickListener(null);
        this.f3355b = null;
        this.f3356c.setOnClickListener(null);
        this.f3356c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
