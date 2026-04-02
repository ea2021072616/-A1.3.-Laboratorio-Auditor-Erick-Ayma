package com.fotoable.youtube.music.ui.adapter.holder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class MySubscriptionHolder_ViewBinding implements Unbinder {
    private MySubscriptionHolder target;

    @UiThread
    public MySubscriptionHolder_ViewBinding(MySubscriptionHolder mySubscriptionHolder, View view) {
        this.target = mySubscriptionHolder;
        mySubscriptionHolder.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MySubscriptionHolder mySubscriptionHolder = this.target;
        if (mySubscriptionHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mySubscriptionHolder.recyclerView = null;
    }
}
