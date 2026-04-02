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
public class LocalArtistsFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalArtistsFragment f4621a;

    @UiThread
    public LocalArtistsFragment_ViewBinding(LocalArtistsFragment localArtistsFragment, View view) {
        this.f4621a = localArtistsFragment;
        localArtistsFragment.recycleView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", IRecyclerView.class);
        localArtistsFragment.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        localArtistsFragment.viewBg = Utils.findRequiredView(view, R.id.view_bg, "field 'viewBg'");
        localArtistsFragment.indexBar = (NewIndexBar) Utils.findRequiredViewAsType(view, R.id.indexBar, "field 'indexBar'", NewIndexBar.class);
        localArtistsFragment.tvSideBarHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSideBarHint, "field 'tvSideBarHint'", TextView.class);
        localArtistsFragment.tvError = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_error, "field 'tvError'", LaToTextView.class);
        localArtistsFragment.llError = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_error, "field 'llError'", LinearLayout.class);
        localArtistsFragment.rlNodata = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_nodata, "field 'rlNodata'", RelativeLayout.class);
        localArtistsFragment.tvAgain = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_again, "field 'tvAgain'", LaToTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalArtistsFragment localArtistsFragment = this.f4621a;
        if (localArtistsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4621a = null;
        localArtistsFragment.recycleView = null;
        localArtistsFragment.refreshLayout = null;
        localArtistsFragment.viewBg = null;
        localArtistsFragment.indexBar = null;
        localArtistsFragment.tvSideBarHint = null;
        localArtistsFragment.tvError = null;
        localArtistsFragment.llError = null;
        localArtistsFragment.rlNodata = null;
        localArtistsFragment.tvAgain = null;
    }
}
