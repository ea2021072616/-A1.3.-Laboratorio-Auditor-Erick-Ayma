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
public class LocalSongsFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalSongsFragment f4657a;

    @UiThread
    public LocalSongsFragment_ViewBinding(LocalSongsFragment localSongsFragment, View view) {
        this.f4657a = localSongsFragment;
        localSongsFragment.recycleView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", IRecyclerView.class);
        localSongsFragment.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        localSongsFragment.viewBg = Utils.findRequiredView(view, R.id.view_bg, "field 'viewBg'");
        localSongsFragment.indexBar = (NewIndexBar) Utils.findRequiredViewAsType(view, R.id.indexBar, "field 'indexBar'", NewIndexBar.class);
        localSongsFragment.tvSideBarHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSideBarHint, "field 'tvSideBarHint'", TextView.class);
        localSongsFragment.tvError = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_error, "field 'tvError'", LaToTextView.class);
        localSongsFragment.llError = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_error, "field 'llError'", LinearLayout.class);
        localSongsFragment.tvAgain = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_again, "field 'tvAgain'", LaToTextView.class);
        localSongsFragment.rlNoDataRl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_nodata, "field 'rlNoDataRl'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalSongsFragment localSongsFragment = this.f4657a;
        if (localSongsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4657a = null;
        localSongsFragment.recycleView = null;
        localSongsFragment.refreshLayout = null;
        localSongsFragment.viewBg = null;
        localSongsFragment.indexBar = null;
        localSongsFragment.tvSideBarHint = null;
        localSongsFragment.tvError = null;
        localSongsFragment.llError = null;
        localSongsFragment.tvAgain = null;
        localSongsFragment.rlNoDataRl = null;
    }
}
