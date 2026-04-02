package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class SimpleMusicDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SimpleMusicDialog f4387a;

    @UiThread
    public SimpleMusicDialog_ViewBinding(SimpleMusicDialog simpleMusicDialog, View view) {
        this.f4387a = simpleMusicDialog;
        simpleMusicDialog.contentTv = (TextView) Utils.findRequiredViewAsType(view, R.id.content, "field 'contentTv'", TextView.class);
        simpleMusicDialog.cancelTv = (TextView) Utils.findRequiredViewAsType(view, R.id.cancel, "field 'cancelTv'", TextView.class);
        simpleMusicDialog.clearTv = (TextView) Utils.findRequiredViewAsType(view, R.id.clear, "field 'clearTv'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SimpleMusicDialog simpleMusicDialog = this.f4387a;
        if (simpleMusicDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4387a = null;
        simpleMusicDialog.contentTv = null;
        simpleMusicDialog.cancelTv = null;
        simpleMusicDialog.clearTv = null;
    }
}
