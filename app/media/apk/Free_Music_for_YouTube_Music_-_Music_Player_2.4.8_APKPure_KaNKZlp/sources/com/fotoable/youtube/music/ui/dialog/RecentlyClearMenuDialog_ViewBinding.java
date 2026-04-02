package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class RecentlyClearMenuDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RecentlyClearMenuDialog f4357a;

    /* renamed from: b  reason: collision with root package name */
    private View f4358b;

    @UiThread
    public RecentlyClearMenuDialog_ViewBinding(final RecentlyClearMenuDialog recentlyClearMenuDialog, View view) {
        this.f4357a = recentlyClearMenuDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.ll_clear, "method 'onClick'");
        this.f4358b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.RecentlyClearMenuDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                recentlyClearMenuDialog.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f4357a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4357a = null;
        this.f4358b.setOnClickListener(null);
        this.f4358b = null;
    }
}
