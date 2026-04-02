package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class RadioActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RadioActivity f3740a;

    /* renamed from: b  reason: collision with root package name */
    private View f3741b;

    @UiThread
    public RadioActivity_ViewBinding(final RadioActivity radioActivity, View view) {
        this.f3740a = radioActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "field 'backView' and method 'onViewClicked'");
        radioActivity.backView = (ImageView) Utils.castView(findRequiredView, R.id.back_view, "field 'backView'", ImageView.class);
        this.f3741b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.RadioActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radioActivity.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RadioActivity radioActivity = this.f3740a;
        if (radioActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3740a = null;
        radioActivity.backView = null;
        this.f3741b.setOnClickListener(null);
        this.f3741b = null;
    }
}
