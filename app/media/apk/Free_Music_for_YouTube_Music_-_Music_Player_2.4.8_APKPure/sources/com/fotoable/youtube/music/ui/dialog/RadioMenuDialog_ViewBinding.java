package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class RadioMenuDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RadioMenuDialog f4344a;

    /* renamed from: b  reason: collision with root package name */
    private View f4345b;

    /* renamed from: c  reason: collision with root package name */
    private View f4346c;
    private View d;

    @UiThread
    public RadioMenuDialog_ViewBinding(final RadioMenuDialog radioMenuDialog, View view) {
        this.f4344a = radioMenuDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.add_to_favorite, "field 'addToFavorite' and method 'onViewClicked'");
        radioMenuDialog.addToFavorite = (LinearLayout) Utils.castView(findRequiredView, R.id.add_to_favorite, "field 'addToFavorite'", LinearLayout.class);
        this.f4345b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.RadioMenuDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radioMenuDialog.onViewClicked(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.error_report, "field 'errorReport' and method 'onViewClicked'");
        radioMenuDialog.errorReport = (LinearLayout) Utils.castView(findRequiredView2, R.id.error_report, "field 'errorReport'", LinearLayout.class);
        this.f4346c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.RadioMenuDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radioMenuDialog.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.ll_sleep_timer, "field 'll_sleep_timer' and method 'onViewClicked'");
        radioMenuDialog.ll_sleep_timer = (LinearLayout) Utils.castView(findRequiredView3, R.id.ll_sleep_timer, "field 'll_sleep_timer'", LinearLayout.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.RadioMenuDialog_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radioMenuDialog.onViewClicked(view2);
            }
        });
        radioMenuDialog.sleep_timer_real_time = (TextView) Utils.findRequiredViewAsType(view, R.id.sleep_timer_real_time, "field 'sleep_timer_real_time'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RadioMenuDialog radioMenuDialog = this.f4344a;
        if (radioMenuDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4344a = null;
        radioMenuDialog.addToFavorite = null;
        radioMenuDialog.errorReport = null;
        radioMenuDialog.ll_sleep_timer = null;
        radioMenuDialog.sleep_timer_real_time = null;
        this.f4345b.setOnClickListener(null);
        this.f4345b = null;
        this.f4346c.setOnClickListener(null);
        this.f4346c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
