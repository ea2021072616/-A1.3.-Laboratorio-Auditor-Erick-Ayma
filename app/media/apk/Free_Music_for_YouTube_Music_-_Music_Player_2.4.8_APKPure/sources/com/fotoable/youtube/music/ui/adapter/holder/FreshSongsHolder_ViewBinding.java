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
public class FreshSongsHolder_ViewBinding implements Unbinder {
    private FreshSongsHolder target;

    @UiThread
    public FreshSongsHolder_ViewBinding(FreshSongsHolder freshSongsHolder, View view) {
        this.target = freshSongsHolder;
        freshSongsHolder.tv_all = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_all, "field 'tv_all'", TextView.class);
        freshSongsHolder.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FreshSongsHolder freshSongsHolder = this.target;
        if (freshSongsHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        freshSongsHolder.tv_all = null;
        freshSongsHolder.recyclerView = null;
    }
}
