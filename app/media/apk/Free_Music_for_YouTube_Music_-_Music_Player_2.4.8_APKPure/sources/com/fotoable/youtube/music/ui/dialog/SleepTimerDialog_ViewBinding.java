package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.NumberPickerView;
/* loaded from: classes.dex */
public class SleepTimerDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SleepTimerDialog f4393a;

    @UiThread
    public SleepTimerDialog_ViewBinding(SleepTimerDialog sleepTimerDialog, View view) {
        this.f4393a = sleepTimerDialog;
        sleepTimerDialog.picker_hour = (NumberPickerView) Utils.findRequiredViewAsType(view, R.id.picker_hour, "field 'picker_hour'", NumberPickerView.class);
        sleepTimerDialog.picker_minute = (NumberPickerView) Utils.findRequiredViewAsType(view, R.id.picker_minute, "field 'picker_minute'", NumberPickerView.class);
        sleepTimerDialog.cancelTv = (TextView) Utils.findRequiredViewAsType(view, R.id.cancel, "field 'cancelTv'", TextView.class);
        sleepTimerDialog.clearTv = (TextView) Utils.findRequiredViewAsType(view, R.id.clear, "field 'clearTv'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SleepTimerDialog sleepTimerDialog = this.f4393a;
        if (sleepTimerDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4393a = null;
        sleepTimerDialog.picker_hour = null;
        sleepTimerDialog.picker_minute = null;
        sleepTimerDialog.cancelTv = null;
        sleepTimerDialog.clearTv = null;
    }
}
