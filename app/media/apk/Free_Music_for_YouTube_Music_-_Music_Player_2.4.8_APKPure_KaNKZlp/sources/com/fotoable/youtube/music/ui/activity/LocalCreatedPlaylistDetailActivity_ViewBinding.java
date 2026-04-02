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
public class LocalCreatedPlaylistDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalCreatedPlaylistDetailActivity f3432a;

    /* renamed from: b  reason: collision with root package name */
    private View f3433b;

    /* renamed from: c  reason: collision with root package name */
    private View f3434c;
    private View d;

    @UiThread
    public LocalCreatedPlaylistDetailActivity_ViewBinding(final LocalCreatedPlaylistDetailActivity localCreatedPlaylistDetailActivity, View view) {
        this.f3432a = localCreatedPlaylistDetailActivity;
        localCreatedPlaylistDetailActivity.mBgImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.my_playlist_bg_img, "field 'mBgImg'", ImageView.class);
        localCreatedPlaylistDetailActivity.mCoverImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.my_playlist_detail_cover_img, "field 'mCoverImg'", RoundedImageView.class);
        localCreatedPlaylistDetailActivity.my_playlist_detail_cover_hint = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.my_playlist_detail_cover_hint, "field 'my_playlist_detail_cover_hint'", RoundedImageView.class);
        localCreatedPlaylistDetailActivity.mBigTitleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.my_playlist_detail_big_title_tx, "field 'mBigTitleTx'", LaToTextView.class);
        localCreatedPlaylistDetailActivity.mCountTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.my_playlist_detail_count_tx, "field 'mCountTx'", LaToTextView.class);
        localCreatedPlaylistDetailActivity.mDescLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.my_playlist_desc_layout, "field 'mDescLayout'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack' and method 'onViewClicked'");
        localCreatedPlaylistDetailActivity.imgBack = (ImageView) Utils.castView(findRequiredView, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3433b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localCreatedPlaylistDetailActivity.onViewClicked(view2);
            }
        });
        localCreatedPlaylistDetailActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        localCreatedPlaylistDetailActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        localCreatedPlaylistDetailActivity.CollapsingToolbarLayout = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.CollapsingToolbarLayout, "field 'CollapsingToolbarLayout'", CollapsingToolbarLayout.class);
        localCreatedPlaylistDetailActivity.appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.app_barLayout, "field 'appBarLayout'", AppBarLayout.class);
        localCreatedPlaylistDetailActivity.recycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", RecyclerView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.my_playlist_play_all_btn, "field 'mPlayAllBtn' and method 'onViewClicked'");
        localCreatedPlaylistDetailActivity.mPlayAllBtn = (Button) Utils.castView(findRequiredView2, R.id.my_playlist_play_all_btn, "field 'mPlayAllBtn'", Button.class);
        this.f3434c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localCreatedPlaylistDetailActivity.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.more_img, "field 'moreImg' and method 'onViewClicked'");
        localCreatedPlaylistDetailActivity.moreImg = (ImageView) Utils.castView(findRequiredView3, R.id.more_img, "field 'moreImg'", ImageView.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localCreatedPlaylistDetailActivity.onViewClicked(view2);
            }
        });
        localCreatedPlaylistDetailActivity.relNoData = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.rel_no_data, "field 'relNoData'", NestedScrollView.class);
        localCreatedPlaylistDetailActivity.empty_bottom_bar = Utils.findRequiredView(view, R.id.empty_bottom_bar, "field 'empty_bottom_bar'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalCreatedPlaylistDetailActivity localCreatedPlaylistDetailActivity = this.f3432a;
        if (localCreatedPlaylistDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3432a = null;
        localCreatedPlaylistDetailActivity.mBgImg = null;
        localCreatedPlaylistDetailActivity.mCoverImg = null;
        localCreatedPlaylistDetailActivity.my_playlist_detail_cover_hint = null;
        localCreatedPlaylistDetailActivity.mBigTitleTx = null;
        localCreatedPlaylistDetailActivity.mCountTx = null;
        localCreatedPlaylistDetailActivity.mDescLayout = null;
        localCreatedPlaylistDetailActivity.imgBack = null;
        localCreatedPlaylistDetailActivity.tvTitle = null;
        localCreatedPlaylistDetailActivity.toolbar = null;
        localCreatedPlaylistDetailActivity.CollapsingToolbarLayout = null;
        localCreatedPlaylistDetailActivity.appBarLayout = null;
        localCreatedPlaylistDetailActivity.recycleView = null;
        localCreatedPlaylistDetailActivity.mPlayAllBtn = null;
        localCreatedPlaylistDetailActivity.moreImg = null;
        localCreatedPlaylistDetailActivity.relNoData = null;
        localCreatedPlaylistDetailActivity.empty_bottom_bar = null;
        this.f3433b.setOnClickListener(null);
        this.f3433b = null;
        this.f3434c.setOnClickListener(null);
        this.f3434c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
