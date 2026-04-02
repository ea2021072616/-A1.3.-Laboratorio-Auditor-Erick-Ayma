package com.fotoable.youtube.music.ui.adapter.holder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class BannersHolder_ViewBinding implements Unbinder {
    private BannersHolder target;

    @UiThread
    public BannersHolder_ViewBinding(BannersHolder bannersHolder, View view) {
        this.target = bannersHolder;
        bannersHolder.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'viewPager'", ViewPager.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BannersHolder bannersHolder = this.target;
        if (bannersHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bannersHolder.viewPager = null;
    }
}
