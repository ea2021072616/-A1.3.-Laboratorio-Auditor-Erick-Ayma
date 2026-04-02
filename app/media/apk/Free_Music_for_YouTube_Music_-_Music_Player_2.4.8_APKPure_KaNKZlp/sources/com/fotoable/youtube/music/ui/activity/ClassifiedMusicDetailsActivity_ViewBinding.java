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
public class ClassifiedMusicDetailsActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ClassifiedMusicDetailsActivity f3201a;

    /* renamed from: b  reason: collision with root package name */
    private View f3202b;

    /* renamed from: c  reason: collision with root package name */
    private View f3203c;
    private View d;

    @UiThread
    public ClassifiedMusicDetailsActivity_ViewBinding(final ClassifiedMusicDetailsActivity classifiedMusicDetailsActivity, View view) {
        this.f3201a = classifiedMusicDetailsActivity;
        classifiedMusicDetailsActivity.recyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_pop, "field 'recyclerView'", IRecyclerView.class);
        classifiedMusicDetailsActivity.mainBackdrop = (ImageView) Utils.findRequiredViewAsType(view, R.id.main_backdrop, "field 'mainBackdrop'", ImageView.class);
        classifiedMusicDetailsActivity.ivLoadingPic = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_LoadingPic, "field 'ivLoadingPic'", RoundImageView.class);
        classifiedMusicDetailsActivity.rlDetails = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_details, "field 'rlDetails'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack' and method 'onClick'");
        classifiedMusicDetailsActivity.imgBack = (ImageView) Utils.castView(findRequiredView, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3202b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.ClassifiedMusicDetailsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classifiedMusicDetailsActivity.onClick(view2);
            }
        });
        classifiedMusicDetailsActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        classifiedMusicDetailsActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        classifiedMusicDetailsActivity.collapsingToolbarLayout = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.CollapsingToolbarLayout, "field 'collapsingToolbarLayout'", CollapsingToolbarLayout.class);
        classifiedMusicDetailsActivity.appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.app_barLayout, "field 'appBarLayout'", AppBarLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_play_all, "field 'ivPlayAll' and method 'onClick'");
        classifiedMusicDetailsActivity.ivPlayAll = (Button) Utils.castView(findRequiredView2, R.id.iv_play_all, "field 'ivPlayAll'", Button.class);
        this.f3203c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.ClassifiedMusicDetailsActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classifiedMusicDetailsActivity.onClick(view2);
            }
        });
        classifiedMusicDetailsActivity.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.ll_error, "field 'tvError' and method 'onClick'");
        classifiedMusicDetailsActivity.tvError = (LinearLayout) Utils.castView(findRequiredView3, R.id.ll_error, "field 'tvError'", LinearLayout.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.ClassifiedMusicDetailsActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classifiedMusicDetailsActivity.onClick(view2);
            }
        });
        classifiedMusicDetailsActivity.txtUpdateTime = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_update_time, "field 'txtUpdateTime'", TextView.class);
        classifiedMusicDetailsActivity.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ClassifiedMusicDetailsActivity classifiedMusicDetailsActivity = this.f3201a;
        if (classifiedMusicDetailsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3201a = null;
        classifiedMusicDetailsActivity.recyclerView = null;
        classifiedMusicDetailsActivity.mainBackdrop = null;
        classifiedMusicDetailsActivity.ivLoadingPic = null;
        classifiedMusicDetailsActivity.rlDetails = null;
        classifiedMusicDetailsActivity.imgBack = null;
        classifiedMusicDetailsActivity.tvTitle = null;
        classifiedMusicDetailsActivity.toolbar = null;
        classifiedMusicDetailsActivity.collapsingToolbarLayout = null;
        classifiedMusicDetailsActivity.appBarLayout = null;
        classifiedMusicDetailsActivity.ivPlayAll = null;
        classifiedMusicDetailsActivity.refreshLayout = null;
        classifiedMusicDetailsActivity.tvError = null;
        classifiedMusicDetailsActivity.txtUpdateTime = null;
        classifiedMusicDetailsActivity.txtTitle = null;
        this.f3202b.setOnClickListener(null);
        this.f3202b = null;
        this.f3203c.setOnClickListener(null);
        this.f3203c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
