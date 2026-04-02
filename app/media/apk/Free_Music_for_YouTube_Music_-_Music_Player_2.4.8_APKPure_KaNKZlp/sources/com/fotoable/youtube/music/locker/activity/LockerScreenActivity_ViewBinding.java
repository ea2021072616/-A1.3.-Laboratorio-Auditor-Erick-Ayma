package com.fotoable.youtube.music.locker.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.locker.view.VerticalViewPager;
/* loaded from: classes.dex */
public class LockerScreenActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LockerScreenActivity f2764a;

    @UiThread
    public LockerScreenActivity_ViewBinding(LockerScreenActivity lockerScreenActivity, View view) {
        this.f2764a = lockerScreenActivity;
        lockerScreenActivity.verticalViewPager = (VerticalViewPager) Utils.findRequiredViewAsType(view, R.id.locker_vertical_view_pager, "field 'verticalViewPager'", VerticalViewPager.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LockerScreenActivity lockerScreenActivity = this.f2764a;
        if (lockerScreenActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f2764a = null;
        lockerScreenActivity.verticalViewPager = null;
    }
}
