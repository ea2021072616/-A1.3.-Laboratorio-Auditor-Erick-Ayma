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
public class HitSinglesHolder_ViewBinding implements Unbinder {
    private HitSinglesHolder target;

    @UiThread
    public HitSinglesHolder_ViewBinding(HitSinglesHolder hitSinglesHolder, View view) {
        this.target = hitSinglesHolder;
        hitSinglesHolder.tv_all = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_all, "field 'tv_all'", TextView.class);
        hitSinglesHolder.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HitSinglesHolder hitSinglesHolder = this.target;
        if (hitSinglesHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        hitSinglesHolder.tv_all = null;
        hitSinglesHolder.recyclerView = null;
    }
}
