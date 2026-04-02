package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class LockerScreenMenuDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LockerScreenMenuDialog f4196a;

    /* renamed from: b  reason: collision with root package name */
    private View f4197b;

    @UiThread
    public LockerScreenMenuDialog_ViewBinding(final LockerScreenMenuDialog lockerScreenMenuDialog, View view) {
        this.f4196a = lockerScreenMenuDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.turn_off_panel, "method 'onClick'");
        this.f4197b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LockerScreenMenuDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                lockerScreenMenuDialog.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f4196a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4196a = null;
        this.f4197b.setOnClickListener(null);
        this.f4197b = null;
    }
}
