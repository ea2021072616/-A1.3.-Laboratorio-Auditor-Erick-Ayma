package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class TimerActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private TimerActivity f3852a;

    /* renamed from: b  reason: collision with root package name */
    private View f3853b;

    /* renamed from: c  reason: collision with root package name */
    private View f3854c;

    @UiThread
    public TimerActivity_ViewBinding(final TimerActivity timerActivity, View view) {
        this.f3852a = timerActivity;
        timerActivity.recycle_view = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycle_view'", RecyclerView.class);
        timerActivity.play_end_checkbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.play_end_checkbox, "field 'play_end_checkbox'", CheckBox.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.play_end_panel, "method 'onClick'");
        this.f3853b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.TimerActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                timerActivity.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.back_view, "method 'onClick'");
        this.f3854c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.TimerActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                timerActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TimerActivity timerActivity = this.f3852a;
        if (timerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3852a = null;
        timerActivity.recycle_view = null;
        timerActivity.play_end_checkbox = null;
        this.f3853b.setOnClickListener(null);
        this.f3853b = null;
        this.f3854c.setOnClickListener(null);
        this.f3854c = null;
    }
}
