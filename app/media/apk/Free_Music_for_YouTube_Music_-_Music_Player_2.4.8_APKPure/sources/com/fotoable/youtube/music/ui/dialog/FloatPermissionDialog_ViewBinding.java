package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class FloatPermissionDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private FloatPermissionDialog f4110a;

    @UiThread
    public FloatPermissionDialog_ViewBinding(FloatPermissionDialog floatPermissionDialog, View view) {
        this.f4110a = floatPermissionDialog;
        floatPermissionDialog.float_permission_tip_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.float_permission_tip_img, "field 'float_permission_tip_img'", ImageView.class);
        floatPermissionDialog.enableTv = (TextView) Utils.findRequiredViewAsType(view, R.id.enable, "field 'enableTv'", TextView.class);
        floatPermissionDialog.cancelTv = (TextView) Utils.findRequiredViewAsType(view, R.id.cancel, "field 'cancelTv'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FloatPermissionDialog floatPermissionDialog = this.f4110a;
        if (floatPermissionDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4110a = null;
        floatPermissionDialog.float_permission_tip_img = null;
        floatPermissionDialog.enableTv = null;
        floatPermissionDialog.cancelTv = null;
    }
}
