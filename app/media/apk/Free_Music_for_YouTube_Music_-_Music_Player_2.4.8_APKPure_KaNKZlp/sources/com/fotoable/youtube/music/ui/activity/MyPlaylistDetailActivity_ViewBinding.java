package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.makeramen.roundedimageview.RoundedImageView;
/* loaded from: classes.dex */
public class MyPlaylistDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MyPlaylistDetailActivity f3596a;

    /* renamed from: b  reason: collision with root package name */
    private View f3597b;

    /* renamed from: c  reason: collision with root package name */
    private View f3598c;
    private View d;

    @UiThread
    public MyPlaylistDetailActivity_ViewBinding(final MyPlaylistDetailActivity myPlaylistDetailActivity, View view) {
        this.f3596a = myPlaylistDetailActivity;
        myPlaylistDetailActivity.mBgImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.my_playlist_bg_img, "field 'mBgImg'", ImageView.class);
        myPlaylistDetailActivity.mCoverImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.my_playlist_detail_cover_img, "field 'mCoverImg'", RoundedImageView.class);
        myPlaylistDetailActivity.mBigTitleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.my_playlist_detail_big_title_tx, "field 'mBigTitleTx'", LaToTextView.class);
        myPlaylistDetailActivity.mCountTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.my_playlist_detail_count_tx, "field 'mCountTx'", LaToTextView.class);
        myPlaylistDetailActivity.mDescLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.my_playlist_desc_layout, "field 'mDescLayout'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack' and method 'onViewClicked'");
        myPlaylistDetailActivity.imgBack = (ImageView) Utils.castView(findRequiredView, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3597b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myPlaylistDetailActivity.onViewClicked(view2);
            }
        });
        myPlaylistDetailActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        myPlaylistDetailActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        myPlaylistDetailActivity.CollapsingToolbarLayout = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.CollapsingToolbarLayout, "field 'CollapsingToolbarLayout'", CollapsingToolbarLayout.class);
        myPlaylistDetailActivity.appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.app_barLayout, "field 'appBarLayout'", AppBarLayout.class);
        myPlaylistDetailActivity.recycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", RecyclerView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.my_playlist_play_all_btn, "field 'mPlayAllBtn' and method 'onViewClicked'");
        myPlaylistDetailActivity.mPlayAllBtn = (Button) Utils.castView(findRequiredView2, R.id.my_playlist_play_all_btn, "field 'mPlayAllBtn'", Button.class);
        this.f3598c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myPlaylistDetailActivity.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.more_img, "field 'moreImg' and method 'onViewClicked'");
        myPlaylistDetailActivity.moreImg = (ImageView) Utils.castView(findRequiredView3, R.id.more_img, "field 'moreImg'", ImageView.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myPlaylistDetailActivity.onViewClicked(view2);
            }
        });
        myPlaylistDetailActivity.relNoData = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.rel_no_data, "field 'relNoData'", NestedScrollView.class);
        myPlaylistDetailActivity.empty_bottom_bar = Utils.findRequiredView(view, R.id.empty_bottom_bar, "field 'empty_bottom_bar'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MyPlaylistDetailActivity myPlaylistDetailActivity = this.f3596a;
        if (myPlaylistDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3596a = null;
        myPlaylistDetailActivity.mBgImg = null;
        myPlaylistDetailActivity.mCoverImg = null;
        myPlaylistDetailActivity.mBigTitleTx = null;
        myPlaylistDetailActivity.mCountTx = null;
        myPlaylistDetailActivity.mDescLayout = null;
        myPlaylistDetailActivity.imgBack = null;
        myPlaylistDetailActivity.tvTitle = null;
        myPlaylistDetailActivity.toolbar = null;
        myPlaylistDetailActivity.CollapsingToolbarLayout = null;
        myPlaylistDetailActivity.appBarLayout = null;
        myPlaylistDetailActivity.recycleView = null;
        myPlaylistDetailActivity.mPlayAllBtn = null;
        myPlaylistDetailActivity.moreImg = null;
        myPlaylistDetailActivity.relNoData = null;
        myPlaylistDetailActivity.empty_bottom_bar = null;
        this.f3597b.setOnClickListener(null);
        this.f3597b = null;
        this.f3598c.setOnClickListener(null);
        this.f3598c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
