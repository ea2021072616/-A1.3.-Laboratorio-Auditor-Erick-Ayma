package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class AboutSubscriptionActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private AboutSubscriptionActivity f3176a;

    /* renamed from: b  reason: collision with root package name */
    private View f3177b;

    @UiThread
    public AboutSubscriptionActivity_ViewBinding(final AboutSubscriptionActivity aboutSubscriptionActivity, View view) {
        this.f3176a = aboutSubscriptionActivity;
        aboutSubscriptionActivity.rl_container = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_container, "field 'rl_container'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_close, "method 'onViewClicked'");
        this.f3177b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.AboutSubscriptionActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                aboutSubscriptionActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AboutSubscriptionActivity aboutSubscriptionActivity = this.f3176a;
        if (aboutSubscriptionActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3176a = null;
        aboutSubscriptionActivity.rl_container = null;
        this.f3177b.setOnClickListener(null);
        this.f3177b = null;
    }
}
