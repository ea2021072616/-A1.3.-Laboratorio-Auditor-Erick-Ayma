package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class CloseFeatureDialogFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CloseFeatureDialogFragment f4059a;

    /* renamed from: b  reason: collision with root package name */
    private View f4060b;

    /* renamed from: c  reason: collision with root package name */
    private View f4061c;

    @UiThread
    public CloseFeatureDialogFragment_ViewBinding(final CloseFeatureDialogFragment closeFeatureDialogFragment, View view) {
        this.f4059a = closeFeatureDialogFragment;
        closeFeatureDialogFragment.tvDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_desc, "field 'tvDesc'", TextView.class);
        View findViewById = view.findViewById(R.id.btn_keep_it);
        if (findViewById != null) {
            this.f4060b = findViewById;
            findViewById.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CloseFeatureDialogFragment_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    closeFeatureDialogFragment.onCancleClick();
                }
            });
        }
        View findViewById2 = view.findViewById(R.id.btn_turn_off);
        if (findViewById2 != null) {
            this.f4061c = findViewById2;
            findViewById2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CloseFeatureDialogFragment_ViewBinding.2
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    closeFeatureDialogFragment.onApplyClick();
                }
            });
        }
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CloseFeatureDialogFragment closeFeatureDialogFragment = this.f4059a;
        if (closeFeatureDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4059a = null;
        closeFeatureDialogFragment.tvDesc = null;
        if (this.f4060b != null) {
            this.f4060b.setOnClickListener(null);
            this.f4060b = null;
        }
        if (this.f4061c != null) {
            this.f4061c.setOnClickListener(null);
            this.f4061c = null;
        }
    }
}
