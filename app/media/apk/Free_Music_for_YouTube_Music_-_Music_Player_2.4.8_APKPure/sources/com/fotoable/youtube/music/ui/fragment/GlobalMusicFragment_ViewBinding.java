package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
/* loaded from: classes.dex */
public class GlobalMusicFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private GlobalMusicFragment f4581a;

    /* renamed from: b  reason: collision with root package name */
    private View f4582b;

    @UiThread
    public GlobalMusicFragment_ViewBinding(final GlobalMusicFragment globalMusicFragment, View view) {
        this.f4581a = globalMusicFragment;
        globalMusicFragment.recyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", IRecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.ll_error, "field 'tvError' and method 'onClick'");
        globalMusicFragment.tvError = (LinearLayout) Utils.castView(findRequiredView, R.id.ll_error, "field 'tvError'", LinearLayout.class);
        this.f4582b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.GlobalMusicFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                globalMusicFragment.onClick();
            }
        });
        globalMusicFragment.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GlobalMusicFragment globalMusicFragment = this.f4581a;
        if (globalMusicFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4581a = null;
        globalMusicFragment.recyclerView = null;
        globalMusicFragment.tvError = null;
        globalMusicFragment.refreshLayout = null;
        this.f4582b.setOnClickListener(null);
        this.f4582b = null;
    }
}
