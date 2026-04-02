package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class ChargingTipDialogFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ChargingTipDialogFragment f4049a;

    /* renamed from: b  reason: collision with root package name */
    private View f4050b;

    /* renamed from: c  reason: collision with root package name */
    private View f4051c;

    @UiThread
    public ChargingTipDialogFragment_ViewBinding(final ChargingTipDialogFragment chargingTipDialogFragment, View view) {
        this.f4049a = chargingTipDialogFragment;
        View findViewById = view.findViewById(R.id.iv_charging_lockscreen_activity_back);
        if (findViewById != null) {
            this.f4050b = findViewById;
            findViewById.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.ChargingTipDialogFragment_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    chargingTipDialogFragment.onCancleClick();
                }
            });
        }
        View findViewById2 = view.findViewById(R.id.bt_open_charge_lockscreen);
        if (findViewById2 != null) {
            this.f4051c = findViewById2;
            findViewById2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.ChargingTipDialogFragment_ViewBinding.2
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    chargingTipDialogFragment.onApplyClick();
                }
            });
        }
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f4049a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4049a = null;
        if (this.f4050b != null) {
            this.f4050b.setOnClickListener(null);
            this.f4050b = null;
        }
        if (this.f4051c != null) {
            this.f4051c.setOnClickListener(null);
            this.f4051c = null;
        }
    }
}
