package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class Top100Fragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private Top100Fragment f4760a;

    @UiThread
    public Top100Fragment_ViewBinding(Top100Fragment top100Fragment, View view) {
        this.f4760a = top100Fragment;
        top100Fragment.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        top100Fragment.recyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", IRecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Top100Fragment top100Fragment = this.f4760a;
        if (top100Fragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4760a = null;
        top100Fragment.refreshLayout = null;
        top100Fragment.recyclerView = null;
    }
}
