package com.fotoable.youtube.music.ui.adapter.holder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class HotChartsHolder_ViewBinding implements Unbinder {
    private HotChartsHolder target;

    @UiThread
    public HotChartsHolder_ViewBinding(HotChartsHolder hotChartsHolder, View view) {
        this.target = hotChartsHolder;
        hotChartsHolder.tv_all = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_all, "field 'tv_all'", TextView.class);
        hotChartsHolder.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HotChartsHolder hotChartsHolder = this.target;
        if (hotChartsHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        hotChartsHolder.tv_all = null;
        hotChartsHolder.recyclerView = null;
    }
}
