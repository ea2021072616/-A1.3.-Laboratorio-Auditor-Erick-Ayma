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
public class PlayListDetailsActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PlayListDetailsActivity f3642a;

    /* renamed from: b  reason: collision with root package name */
    private View f3643b;

    /* renamed from: c  reason: collision with root package name */
    private View f3644c;
    private View d;
    private View e;
    private View f;

    @UiThread
    public PlayListDetailsActivity_ViewBinding(final PlayListDetailsActivity playListDetailsActivity, View view) {
        this.f3642a = playListDetailsActivity;
        playListDetailsActivity.recyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_pop, "field 'recyclerView'", IRecyclerView.class);
        playListDetailsActivity.mainBackdrop = (ImageView) Utils.findRequiredViewAsType(view, R.id.main_backdrop, "field 'mainBackdrop'", ImageView.class);
        playListDetailsActivity.ivLoadingPic = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_LoadingPic, "field 'ivLoadingPic'", RoundImageView.class);
        playListDetailsActivity.textDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.text_details, "field 'textDetails'", TextView.class);
        playListDetailsActivity.textPeople = (TextView) Utils.findRequiredViewAsType(view, R.id.text_people, "field 'textPeople'", TextView.class);
        playListDetailsActivity.textListen = (TextView) Utils.findRequiredViewAsType(view, R.id.text_listen, "field 'textListen'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.che_subscribed, "field 'che_subscribed' and method 'onCheckedChanged'");
        playListDetailsActivity.che_subscribed = (CheckBox) Utils.castView(findRequiredView, R.id.che_subscribed, "field 'che_subscribed'", CheckBox.class);
        this.f3643b = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                playListDetailsActivity.onCheckedChanged(compoundButton, z);
            }
        });
        playListDetailsActivity.rlDetails = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_details, "field 'rlDetails'", RelativeLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack' and method 'onClick'");
        playListDetailsActivity.imgBack = (ImageView) Utils.castView(findRequiredView2, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3644c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playListDetailsActivity.onClick(view2);
            }
        });
        playListDetailsActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        playListDetailsActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        playListDetailsActivity.collapsingToolbarLayout = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.CollapsingToolbarLayout, "field 'collapsingToolbarLayout'", CollapsingToolbarLayout.class);
        playListDetailsActivity.appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.app_barLayout, "field 'appBarLayout'", AppBarLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_play_all, "field 'ivPlayAll' and method 'onClick'");
        playListDetailsActivity.ivPlayAll = (Button) Utils.castView(findRequiredView3, R.id.iv_play_all, "field 'ivPlayAll'", Button.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playListDetailsActivity.onClick(view2);
            }
        });
        playListDetailsActivity.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.ll_error, "field 'tvError' and method 'onClick'");
        playListDetailsActivity.tvError = (LinearLayout) Utils.castView(findRequiredView4, R.id.ll_error, "field 'tvError'", LinearLayout.class);
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playListDetailsActivity.onClick();
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.img_del, "field 'delImage' and method 'onClick'");
        playListDetailsActivity.delImage = (ImageView) Utils.castView(findRequiredView5, R.id.img_del, "field 'delImage'", ImageView.class);
        this.f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playListDetailsActivity.onClick(view2);
            }
        });
        playListDetailsActivity.empty_bottom_bar = Utils.findRequiredView(view, R.id.empty_bottom_bar, "field 'empty_bottom_bar'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PlayListDetailsActivity playListDetailsActivity = this.f3642a;
        if (playListDetailsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3642a = null;
        playListDetailsActivity.recyclerView = null;
        playListDetailsActivity.mainBackdrop = null;
        playListDetailsActivity.ivLoadingPic = null;
        playListDetailsActivity.textDetails = null;
        playListDetailsActivity.textPeople = null;
        playListDetailsActivity.textListen = null;
        playListDetailsActivity.che_subscribed = null;
        playListDetailsActivity.rlDetails = null;
        playListDetailsActivity.imgBack = null;
        playListDetailsActivity.tvTitle = null;
        playListDetailsActivity.toolbar = null;
        playListDetailsActivity.collapsingToolbarLayout = null;
        playListDetailsActivity.appBarLayout = null;
        playListDetailsActivity.ivPlayAll = null;
        playListDetailsActivity.refreshLayout = null;
        playListDetailsActivity.tvError = null;
        playListDetailsActivity.delImage = null;
        playListDetailsActivity.empty_bottom_bar = null;
        ((CompoundButton) this.f3643b).setOnCheckedChangeListener(null);
        this.f3643b = null;
        this.f3644c.setOnClickListener(null);
        this.f3644c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
    }
}
