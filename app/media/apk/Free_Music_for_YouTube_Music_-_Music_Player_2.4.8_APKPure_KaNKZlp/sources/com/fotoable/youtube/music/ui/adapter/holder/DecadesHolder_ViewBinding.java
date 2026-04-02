package com.fotoable.youtube.music.ui.adapter.holder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class DecadesHolder_ViewBinding implements Unbinder {
    private DecadesHolder target;

    @UiThread
    public DecadesHolder_ViewBinding(DecadesHolder decadesHolder, View view) {
        this.target = decadesHolder;
        decadesHolder.decadesTitleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.decades_title_tx, "field 'decadesTitleTx'", LaToTextView.class);
        decadesHolder.decadesRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.decades_recycler_view, "field 'decadesRecyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DecadesHolder decadesHolder = this.target;
        if (decadesHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        decadesHolder.decadesTitleTx = null;
        decadesHolder.decadesRecyclerView = null;
    }
}
