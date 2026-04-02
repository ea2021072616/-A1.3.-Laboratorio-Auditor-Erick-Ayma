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
public class RankFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RankFragment f4725a;

    /* renamed from: b  reason: collision with root package name */
    private View f4726b;

    @UiThread
    public RankFragment_ViewBinding(final RankFragment rankFragment, View view) {
        this.f4725a = rankFragment;
        rankFragment.recyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", IRecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.ll_error, "field 'tvError' and method 'onClick'");
        rankFragment.tvError = (LinearLayout) Utils.castView(findRequiredView, R.id.ll_error, "field 'tvError'", LinearLayout.class);
        this.f4726b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.RankFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                rankFragment.onClick();
            }
        });
        rankFragment.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RankFragment rankFragment = this.f4725a;
        if (rankFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4725a = null;
        rankFragment.recyclerView = null;
        rankFragment.tvError = null;
        rankFragment.refreshLayout = null;
        this.f4726b.setOnClickListener(null);
        this.f4726b = null;
    }
}
