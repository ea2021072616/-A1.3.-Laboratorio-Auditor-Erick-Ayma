package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class QuickToolTipDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private QuickToolTipDialog f4337a;

    @UiThread
    public QuickToolTipDialog_ViewBinding(QuickToolTipDialog quickToolTipDialog, View view) {
        this.f4337a = quickToolTipDialog;
        quickToolTipDialog.enableTv = (TextView) Utils.findRequiredViewAsType(view, R.id.enable, "field 'enableTv'", TextView.class);
        quickToolTipDialog.cancelTv = (TextView) Utils.findRequiredViewAsType(view, R.id.cancel, "field 'cancelTv'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        QuickToolTipDialog quickToolTipDialog = this.f4337a;
        if (quickToolTipDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4337a = null;
        quickToolTipDialog.enableTv = null;
        quickToolTipDialog.cancelTv = null;
    }
}
