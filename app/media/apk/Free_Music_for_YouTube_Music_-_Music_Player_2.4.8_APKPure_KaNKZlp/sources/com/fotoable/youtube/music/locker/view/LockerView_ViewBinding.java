package com.fotoable.youtube.music.locker.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class LockerView_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LockerView f2780a;

    @UiThread
    public LockerView_ViewBinding(LockerView lockerView, View view) {
        this.f2780a = lockerView;
        lockerView.verticalViewPager = (VerticalViewPager) Utils.findRequiredViewAsType(view, R.id.locker_vertical_view_pager, "field 'verticalViewPager'", VerticalViewPager.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LockerView lockerView = this.f2780a;
        if (lockerView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f2780a = null;
        lockerView.verticalViewPager = null;
    }
}
