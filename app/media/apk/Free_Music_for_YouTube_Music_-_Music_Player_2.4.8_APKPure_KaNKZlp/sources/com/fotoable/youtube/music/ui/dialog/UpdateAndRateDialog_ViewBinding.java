package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class UpdateAndRateDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private UpdateAndRateDialog f4410a;

    /* renamed from: b  reason: collision with root package name */
    private View f4411b;

    /* renamed from: c  reason: collision with root package name */
    private View f4412c;
    private View d;

    @UiThread
    public UpdateAndRateDialog_ViewBinding(final UpdateAndRateDialog updateAndRateDialog, View view) {
        this.f4410a = updateAndRateDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.close_img, "field 'closeImg' and method 'onViewClicked'");
        updateAndRateDialog.closeImg = (ImageView) Utils.castView(findRequiredView, R.id.close_img, "field 'closeImg'", ImageView.class);
        this.f4411b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.UpdateAndRateDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                updateAndRateDialog.onViewClicked(view2);
            }
        });
        updateAndRateDialog.coverImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.cover_img, "field 'coverImg'", ImageView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.ok_tx, "field 'okTx' and method 'onViewClicked'");
        updateAndRateDialog.okTx = (LaToTextView) Utils.castView(findRequiredView2, R.id.ok_tx, "field 'okTx'", LaToTextView.class);
        this.f4412c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.UpdateAndRateDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                updateAndRateDialog.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.cancel_tx, "field 'cancelTx' and method 'onViewClicked'");
        updateAndRateDialog.cancelTx = (LaToTextView) Utils.castView(findRequiredView3, R.id.cancel_tx, "field 'cancelTx'", LaToTextView.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.UpdateAndRateDialog_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                updateAndRateDialog.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UpdateAndRateDialog updateAndRateDialog = this.f4410a;
        if (updateAndRateDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4410a = null;
        updateAndRateDialog.closeImg = null;
        updateAndRateDialog.coverImg = null;
        updateAndRateDialog.okTx = null;
        updateAndRateDialog.cancelTx = null;
        this.f4411b.setOnClickListener(null);
        this.f4411b = null;
        this.f4412c.setOnClickListener(null);
        this.f4412c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
