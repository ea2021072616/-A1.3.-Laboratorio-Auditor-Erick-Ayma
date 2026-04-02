package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.foto.indexlib.IndexBar.widget.NewIndexBar;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
/* loaded from: classes.dex */
public class ArtistsFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ArtistsFragment f4486a;

    /* renamed from: b  reason: collision with root package name */
    private View f4487b;

    @UiThread
    public ArtistsFragment_ViewBinding(final ArtistsFragment artistsFragment, View view) {
        this.f4486a = artistsFragment;
        artistsFragment.recyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", IRecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.ll_error, "field 'tvError' and method 'onClick'");
        artistsFragment.tvError = (LinearLayout) Utils.castView(findRequiredView, R.id.ll_error, "field 'tvError'", LinearLayout.class);
        this.f4487b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.ArtistsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                artistsFragment.onClick();
            }
        });
        artistsFragment.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        artistsFragment.indexBar = (NewIndexBar) Utils.findRequiredViewAsType(view, R.id.indexBar, "field 'indexBar'", NewIndexBar.class);
        artistsFragment.tvSideBarHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSideBarHint, "field 'tvSideBarHint'", TextView.class);
        artistsFragment.viewBg = Utils.findRequiredView(view, R.id.view_bg, "field 'viewBg'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ArtistsFragment artistsFragment = this.f4486a;
        if (artistsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4486a = null;
        artistsFragment.recyclerView = null;
        artistsFragment.tvError = null;
        artistsFragment.refreshLayout = null;
        artistsFragment.indexBar = null;
        artistsFragment.tvSideBarHint = null;
        artistsFragment.viewBg = null;
        this.f4487b.setOnClickListener(null);
        this.f4487b = null;
    }
}
