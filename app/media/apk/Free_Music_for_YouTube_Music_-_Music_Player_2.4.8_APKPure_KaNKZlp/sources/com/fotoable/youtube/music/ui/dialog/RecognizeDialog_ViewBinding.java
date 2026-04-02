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
public class RecognizeDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RecognizeDialog f4364a;

    /* renamed from: b  reason: collision with root package name */
    private View f4365b;

    /* renamed from: c  reason: collision with root package name */
    private View f4366c;
    private View d;

    @UiThread
    public RecognizeDialog_ViewBinding(final RecognizeDialog recognizeDialog, View view) {
        this.f4364a = recognizeDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.close_img, "field 'closeImg' and method 'onViewClicked'");
        recognizeDialog.closeImg = (ImageView) Utils.castView(findRequiredView, R.id.close_img, "field 'closeImg'", ImageView.class);
        this.f4365b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.RecognizeDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                recognizeDialog.onViewClicked(view2);
            }
        });
        recognizeDialog.coverImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.cover_img, "field 'coverImg'", ImageView.class);
        recognizeDialog.titleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.title_tx, "field 'titleTx'", LaToTextView.class);
        recognizeDialog.descTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.desc_tx, "field 'descTx'", LaToTextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.ok_tx, "field 'okTx' and method 'onViewClicked'");
        recognizeDialog.okTx = (LaToTextView) Utils.castView(findRequiredView2, R.id.ok_tx, "field 'okTx'", LaToTextView.class);
        this.f4366c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.RecognizeDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                recognizeDialog.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.cancel_tx, "field 'cancelTx' and method 'onViewClicked'");
        recognizeDialog.cancelTx = (LaToTextView) Utils.castView(findRequiredView3, R.id.cancel_tx, "field 'cancelTx'", LaToTextView.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.RecognizeDialog_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                recognizeDialog.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecognizeDialog recognizeDialog = this.f4364a;
        if (recognizeDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4364a = null;
        recognizeDialog.closeImg = null;
        recognizeDialog.coverImg = null;
        recognizeDialog.titleTx = null;
        recognizeDialog.descTx = null;
        recognizeDialog.okTx = null;
        recognizeDialog.cancelTx = null;
        this.f4365b.setOnClickListener(null);
        this.f4365b = null;
        this.f4366c.setOnClickListener(null);
        this.f4366c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
