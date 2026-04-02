package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class PlayListFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PlayListFragment f4682a;

    /* renamed from: b  reason: collision with root package name */
    private View f4683b;

    @UiThread
    public PlayListFragment_ViewBinding(final PlayListFragment playListFragment, View view) {
        this.f4682a = playListFragment;
        playListFragment.recyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", IRecyclerView.class);
        playListFragment.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.ll_error, "field 'tvError' and method 'onClick'");
        playListFragment.tvError = (LinearLayout) Utils.castView(findRequiredView, R.id.ll_error, "field 'tvError'", LinearLayout.class);
        this.f4683b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.PlayListFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playListFragment.onClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PlayListFragment playListFragment = this.f4682a;
        if (playListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4682a = null;
        playListFragment.recyclerView = null;
        playListFragment.refreshLayout = null;
        playListFragment.tvError = null;
        this.f4683b.setOnClickListener(null);
        this.f4683b = null;
    }
}
