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
public class LocalAlbumDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalAlbumDetailActivity f3391a;

    /* renamed from: b  reason: collision with root package name */
    private View f3392b;

    /* renamed from: c  reason: collision with root package name */
    private View f3393c;
    private View d;

    @UiThread
    public LocalAlbumDetailActivity_ViewBinding(final LocalAlbumDetailActivity localAlbumDetailActivity, View view) {
        this.f3391a = localAlbumDetailActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack'");
        localAlbumDetailActivity.imgBack = (ImageView) Utils.castView(findRequiredView, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3392b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalAlbumDetailActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localAlbumDetailActivity.onClick(view2);
            }
        });
        localAlbumDetailActivity.tvTitle = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", LaToTextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_img, "field 'ivImg'");
        localAlbumDetailActivity.ivImg = (ImageView) Utils.castView(findRequiredView2, R.id.iv_img, "field 'ivImg'", ImageView.class);
        this.f3393c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalAlbumDetailActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localAlbumDetailActivity.onClick(view2);
            }
        });
        localAlbumDetailActivity.recycleView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", IRecyclerView.class);
        localAlbumDetailActivity.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_playing, "field 'ivPlaying'");
        localAlbumDetailActivity.ivPlaying = (ImageView) Utils.castView(findRequiredView3, R.id.iv_playing, "field 'ivPlaying'", ImageView.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalAlbumDetailActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localAlbumDetailActivity.onClick(view2);
            }
        });
        localAlbumDetailActivity.llError = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_error, "field 'llError'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalAlbumDetailActivity localAlbumDetailActivity = this.f3391a;
        if (localAlbumDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3391a = null;
        localAlbumDetailActivity.imgBack = null;
        localAlbumDetailActivity.tvTitle = null;
        localAlbumDetailActivity.ivImg = null;
        localAlbumDetailActivity.recycleView = null;
        localAlbumDetailActivity.refreshLayout = null;
        localAlbumDetailActivity.ivPlaying = null;
        localAlbumDetailActivity.llError = null;
        this.f3392b.setOnClickListener(null);
        this.f3392b = null;
        this.f3393c.setOnClickListener(null);
        this.f3393c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
