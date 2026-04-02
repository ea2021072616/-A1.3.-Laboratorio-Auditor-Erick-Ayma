package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class LocalArtistsDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalArtistsDetailActivity f3406a;

    /* renamed from: b  reason: collision with root package name */
    private View f3407b;

    /* renamed from: c  reason: collision with root package name */
    private View f3408c;
    private View d;

    @UiThread
    public LocalArtistsDetailActivity_ViewBinding(final LocalArtistsDetailActivity localArtistsDetailActivity, View view) {
        this.f3406a = localArtistsDetailActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack'");
        localArtistsDetailActivity.imgBack = (ImageView) Utils.castView(findRequiredView, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3407b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalArtistsDetailActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localArtistsDetailActivity.onClick(view2);
            }
        });
        localArtistsDetailActivity.tvTitle = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", LaToTextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_img, "field 'ivImg'");
        localArtistsDetailActivity.ivImg = (ImageView) Utils.castView(findRequiredView2, R.id.iv_img, "field 'ivImg'", ImageView.class);
        this.f3408c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalArtistsDetailActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localArtistsDetailActivity.onClick(view2);
            }
        });
        localArtistsDetailActivity.recycleView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", IRecyclerView.class);
        localArtistsDetailActivity.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_playing, "field 'ivPlaying'");
        localArtistsDetailActivity.ivPlaying = (ImageView) Utils.castView(findRequiredView3, R.id.iv_playing, "field 'ivPlaying'", ImageView.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalArtistsDetailActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localArtistsDetailActivity.onClick(view2);
            }
        });
        localArtistsDetailActivity.llError = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_error, "field 'llError'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalArtistsDetailActivity localArtistsDetailActivity = this.f3406a;
        if (localArtistsDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3406a = null;
        localArtistsDetailActivity.imgBack = null;
        localArtistsDetailActivity.tvTitle = null;
        localArtistsDetailActivity.ivImg = null;
        localArtistsDetailActivity.recycleView = null;
        localArtistsDetailActivity.refreshLayout = null;
        localArtistsDetailActivity.ivPlaying = null;
        localArtistsDetailActivity.llError = null;
        this.f3407b.setOnClickListener(null);
        this.f3407b = null;
        this.f3408c.setOnClickListener(null);
        this.f3408c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
