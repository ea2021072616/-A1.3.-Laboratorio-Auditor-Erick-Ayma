package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class GenresFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private GenresFragment f4573a;

    /* renamed from: b  reason: collision with root package name */
    private View f4574b;

    @UiThread
    public GenresFragment_ViewBinding(final GenresFragment genresFragment, View view) {
        this.f4573a = genresFragment;
        genresFragment.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.ll_error, "field 'tvError' and method 'onClick'");
        genresFragment.tvError = (LinearLayout) Utils.castView(findRequiredView, R.id.ll_error, "field 'tvError'", LinearLayout.class);
        this.f4574b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.GenresFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                genresFragment.onClick();
            }
        });
        genresFragment.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GenresFragment genresFragment = this.f4573a;
        if (genresFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4573a = null;
        genresFragment.recyclerView = null;
        genresFragment.tvError = null;
        genresFragment.refreshLayout = null;
        this.f4574b.setOnClickListener(null);
        this.f4574b = null;
    }
}
