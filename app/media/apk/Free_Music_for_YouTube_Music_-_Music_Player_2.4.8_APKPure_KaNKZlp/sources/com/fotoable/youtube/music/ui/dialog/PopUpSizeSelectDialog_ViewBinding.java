package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class PopUpSizeSelectDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PopUpSizeSelectDialog f4333a;

    @UiThread
    public PopUpSizeSelectDialog_ViewBinding(PopUpSizeSelectDialog popUpSizeSelectDialog, View view) {
        this.f4333a = popUpSizeSelectDialog;
        popUpSizeSelectDialog.cancelTv = (TextView) Utils.findRequiredViewAsType(view, R.id.cancel, "field 'cancelTv'", TextView.class);
        popUpSizeSelectDialog.clearTv = (TextView) Utils.findRequiredViewAsType(view, R.id.clear, "field 'clearTv'", TextView.class);
        popUpSizeSelectDialog.rl_small = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_small, "field 'rl_small'", RelativeLayout.class);
        popUpSizeSelectDialog.ck_small = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_small, "field 'ck_small'", CheckBox.class);
        popUpSizeSelectDialog.rl_medium = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_medium, "field 'rl_medium'", RelativeLayout.class);
        popUpSizeSelectDialog.ck_medium = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_medium, "field 'ck_medium'", CheckBox.class);
        popUpSizeSelectDialog.rl_big = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_big, "field 'rl_big'", RelativeLayout.class);
        popUpSizeSelectDialog.ck_big = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_big, "field 'ck_big'", CheckBox.class);
        popUpSizeSelectDialog.rl_max = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_max, "field 'rl_max'", RelativeLayout.class);
        popUpSizeSelectDialog.ck_max = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_max, "field 'ck_max'", CheckBox.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PopUpSizeSelectDialog popUpSizeSelectDialog = this.f4333a;
        if (popUpSizeSelectDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4333a = null;
        popUpSizeSelectDialog.cancelTv = null;
        popUpSizeSelectDialog.clearTv = null;
        popUpSizeSelectDialog.rl_small = null;
        popUpSizeSelectDialog.ck_small = null;
        popUpSizeSelectDialog.rl_medium = null;
        popUpSizeSelectDialog.ck_medium = null;
        popUpSizeSelectDialog.rl_big = null;
        popUpSizeSelectDialog.ck_big = null;
        popUpSizeSelectDialog.rl_max = null;
        popUpSizeSelectDialog.ck_max = null;
    }
}
