package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.foto.indexlib.IndexBar.widget.NewIndexBar;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class LocalAlbumFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalAlbumFragment f4603a;

    @UiThread
    public LocalAlbumFragment_ViewBinding(LocalAlbumFragment localAlbumFragment, View view) {
        this.f4603a = localAlbumFragment;
        localAlbumFragment.recycleView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", IRecyclerView.class);
        localAlbumFragment.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        localAlbumFragment.viewBg = Utils.findRequiredView(view, R.id.view_bg, "field 'viewBg'");
        localAlbumFragment.indexBar = (NewIndexBar) Utils.findRequiredViewAsType(view, R.id.indexBar, "field 'indexBar'", NewIndexBar.class);
        localAlbumFragment.tvSideBarHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSideBarHint, "field 'tvSideBarHint'", TextView.class);
        localAlbumFragment.tvError = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_error, "field 'tvError'", LaToTextView.class);
        localAlbumFragment.llError = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_error, "field 'llError'", LinearLayout.class);
        localAlbumFragment.rlNoDataRl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_nodata, "field 'rlNoDataRl'", RelativeLayout.class);
        localAlbumFragment.tvAgain = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_again, "field 'tvAgain'", LaToTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalAlbumFragment localAlbumFragment = this.f4603a;
        if (localAlbumFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4603a = null;
        localAlbumFragment.recycleView = null;
        localAlbumFragment.refreshLayout = null;
        localAlbumFragment.viewBg = null;
        localAlbumFragment.indexBar = null;
        localAlbumFragment.tvSideBarHint = null;
        localAlbumFragment.tvError = null;
        localAlbumFragment.llError = null;
        localAlbumFragment.rlNoDataRl = null;
        localAlbumFragment.tvAgain = null;
    }
}
