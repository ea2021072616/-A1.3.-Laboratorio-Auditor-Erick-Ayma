package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class RadioHistoryFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RadioHistoryFragment f4715a;

    /* renamed from: b  reason: collision with root package name */
    private View f4716b;

    @UiThread
    public RadioHistoryFragment_ViewBinding(final RadioHistoryFragment radioHistoryFragment, View view) {
        this.f4715a = radioHistoryFragment;
        radioHistoryFragment.recycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", RecyclerView.class);
        radioHistoryFragment.noDataView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.no_data_view, "field 'noDataView'", LinearLayout.class);
        radioHistoryFragment.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.show_online_data_view, "field 'showOnlineDataView' and method 'onViewClicked'");
        radioHistoryFragment.showOnlineDataView = (RelativeLayout) Utils.castView(findRequiredView, R.id.show_online_data_view, "field 'showOnlineDataView'", RelativeLayout.class);
        this.f4716b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.RadioHistoryFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radioHistoryFragment.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RadioHistoryFragment radioHistoryFragment = this.f4715a;
        if (radioHistoryFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4715a = null;
        radioHistoryFragment.recycleView = null;
        radioHistoryFragment.noDataView = null;
        radioHistoryFragment.refreshLayout = null;
        radioHistoryFragment.showOnlineDataView = null;
        this.f4716b.setOnClickListener(null);
        this.f4716b = null;
    }
}
