package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class CharLockerMenuDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CharLockerMenuDialog f4044a;

    /* renamed from: b  reason: collision with root package name */
    private View f4045b;

    @UiThread
    public CharLockerMenuDialog_ViewBinding(final CharLockerMenuDialog charLockerMenuDialog, View view) {
        this.f4044a = charLockerMenuDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.turn_off_panel, "method 'onClick'");
        this.f4045b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CharLockerMenuDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                charLockerMenuDialog.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f4044a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4044a = null;
        this.f4045b.setOnClickListener(null);
        this.f4045b = null;
    }
}
