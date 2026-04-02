package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class SubscriptionDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SubscriptionDialog f4398a;

    /* renamed from: b  reason: collision with root package name */
    private View f4399b;

    /* renamed from: c  reason: collision with root package name */
    private View f4400c;
    private View d;

    @UiThread
    public SubscriptionDialog_ViewBinding(final SubscriptionDialog subscriptionDialog, View view) {
        this.f4398a = subscriptionDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_about_subscription, "field 'tv_about_subscription' and method 'onViewClicked'");
        subscriptionDialog.tv_about_subscription = (TextView) Utils.castView(findRequiredView, R.id.tv_about_subscription, "field 'tv_about_subscription'", TextView.class);
        this.f4399b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.SubscriptionDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                subscriptionDialog.onViewClicked(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_close, "method 'onViewClicked'");
        this.f4400c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.SubscriptionDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                subscriptionDialog.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_subscription_submit, "method 'onViewClicked'");
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.SubscriptionDialog_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                subscriptionDialog.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SubscriptionDialog subscriptionDialog = this.f4398a;
        if (subscriptionDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4398a = null;
        subscriptionDialog.tv_about_subscription = null;
        this.f4399b.setOnClickListener(null);
        this.f4399b = null;
        this.f4400c.setOnClickListener(null);
        this.f4400c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
