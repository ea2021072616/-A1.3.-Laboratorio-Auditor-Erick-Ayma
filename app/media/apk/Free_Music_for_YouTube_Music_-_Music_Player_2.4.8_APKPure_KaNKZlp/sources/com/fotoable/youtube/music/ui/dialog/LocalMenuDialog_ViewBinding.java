package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class LocalMenuDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalMenuDialog f4138a;

    /* renamed from: b  reason: collision with root package name */
    private View f4139b;

    /* renamed from: c  reason: collision with root package name */
    private View f4140c;

    @UiThread
    public LocalMenuDialog_ViewBinding(final LocalMenuDialog localMenuDialog, View view) {
        this.f4138a = localMenuDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.ll_scan, "method 'onClick'");
        this.f4139b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMenuDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMenuDialog.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.ll_sort, "method 'onClick'");
        this.f4140c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMenuDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMenuDialog.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f4138a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4138a = null;
        this.f4139b.setOnClickListener(null);
        this.f4139b = null;
        this.f4140c.setOnClickListener(null);
        this.f4140c = null;
    }
}
