package com.fotoable.youtube.music.newplayer.popup;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.FloatLockSlideView;
/* loaded from: classes.dex */
public class PowerSavingModelView_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PowerSavingModelView f3065a;

    /* renamed from: b  reason: collision with root package name */
    private View f3066b;

    @UiThread
    public PowerSavingModelView_ViewBinding(final PowerSavingModelView powerSavingModelView, View view) {
        this.f3065a = powerSavingModelView;
        powerSavingModelView.max_view = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.max_view, "field 'max_view'", RelativeLayout.class);
        powerSavingModelView.float_slide_view = (FloatLockSlideView) Utils.findRequiredViewAsType(view, R.id.float_slide_view, "field 'float_slide_view'", FloatLockSlideView.class);
        powerSavingModelView.youtube_background_tip_panel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.youtube_background_tip_panel, "field 'youtube_background_tip_panel'", LinearLayout.class);
        powerSavingModelView.video_title3 = (TextView) Utils.findRequiredViewAsType(view, R.id.video_title3, "field 'video_title3'", TextView.class);
        powerSavingModelView.video_description2 = (TextView) Utils.findRequiredViewAsType(view, R.id.video_description2, "field 'video_description2'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.got_it_tv, "method 'onClick'");
        this.f3066b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.PowerSavingModelView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                powerSavingModelView.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PowerSavingModelView powerSavingModelView = this.f3065a;
        if (powerSavingModelView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3065a = null;
        powerSavingModelView.max_view = null;
        powerSavingModelView.float_slide_view = null;
        powerSavingModelView.youtube_background_tip_panel = null;
        powerSavingModelView.video_title3 = null;
        powerSavingModelView.video_description2 = null;
        this.f3066b.setOnClickListener(null);
        this.f3066b = null;
    }
}
