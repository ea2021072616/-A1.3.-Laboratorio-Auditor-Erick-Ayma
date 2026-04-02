package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.TextureVideoView;
/* loaded from: classes.dex */
public class WidgetTipDialogFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private WidgetTipDialogFragment f4419a;

    /* renamed from: b  reason: collision with root package name */
    private View f4420b;

    @UiThread
    public WidgetTipDialogFragment_ViewBinding(final WidgetTipDialogFragment widgetTipDialogFragment, View view) {
        this.f4419a = widgetTipDialogFragment;
        widgetTipDialogFragment.videoView = (TextureVideoView) Utils.findRequiredViewAsType(view, R.id.widget_video, "field 'videoView'", TextureVideoView.class);
        View findViewById = view.findViewById(R.id.btn_ok);
        if (findViewById != null) {
            this.f4420b = findViewById;
            findViewById.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.WidgetTipDialogFragment_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    widgetTipDialogFragment.onApplyClick();
                }
            });
        }
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WidgetTipDialogFragment widgetTipDialogFragment = this.f4419a;
        if (widgetTipDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4419a = null;
        widgetTipDialogFragment.videoView = null;
        if (this.f4420b != null) {
            this.f4420b.setOnClickListener(null);
            this.f4420b = null;
        }
    }
}
