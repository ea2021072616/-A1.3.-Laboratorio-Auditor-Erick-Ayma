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
public class LocalFavoriteFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalFavoriteFragment f4627a;

    @UiThread
    public LocalFavoriteFragment_ViewBinding(LocalFavoriteFragment localFavoriteFragment, View view) {
        this.f4627a = localFavoriteFragment;
        localFavoriteFragment.recycleView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", IRecyclerView.class);
        localFavoriteFragment.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        localFavoriteFragment.viewBg = Utils.findRequiredView(view, R.id.view_bg, "field 'viewBg'");
        localFavoriteFragment.indexBar = (NewIndexBar) Utils.findRequiredViewAsType(view, R.id.indexBar, "field 'indexBar'", NewIndexBar.class);
        localFavoriteFragment.tvSideBarHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSideBarHint, "field 'tvSideBarHint'", TextView.class);
        localFavoriteFragment.tvError = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_error, "field 'tvError'", LaToTextView.class);
        localFavoriteFragment.llError = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_error, "field 'llError'", LinearLayout.class);
        localFavoriteFragment.rlNodata = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_nodata, "field 'rlNodata'", RelativeLayout.class);
        localFavoriteFragment.tvAgain = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_again, "field 'tvAgain'", LaToTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalFavoriteFragment localFavoriteFragment = this.f4627a;
        if (localFavoriteFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4627a = null;
        localFavoriteFragment.recycleView = null;
        localFavoriteFragment.refreshLayout = null;
        localFavoriteFragment.viewBg = null;
        localFavoriteFragment.indexBar = null;
        localFavoriteFragment.tvSideBarHint = null;
        localFavoriteFragment.tvError = null;
        localFavoriteFragment.llError = null;
        localFavoriteFragment.rlNodata = null;
        localFavoriteFragment.tvAgain = null;
    }
}
