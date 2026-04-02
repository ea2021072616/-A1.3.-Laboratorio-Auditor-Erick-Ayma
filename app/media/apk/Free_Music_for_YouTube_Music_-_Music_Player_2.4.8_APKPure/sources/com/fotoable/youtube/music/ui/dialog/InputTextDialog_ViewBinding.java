package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class InputTextDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private InputTextDialog f4116a;

    /* renamed from: b  reason: collision with root package name */
    private View f4117b;

    /* renamed from: c  reason: collision with root package name */
    private View f4118c;

    @UiThread
    public InputTextDialog_ViewBinding(final InputTextDialog inputTextDialog, View view) {
        this.f4116a = inputTextDialog;
        inputTextDialog.mTitleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.playlist_title_tx, "field 'mTitleTx'", LaToTextView.class);
        inputTextDialog.mEdit = (EditText) Utils.findRequiredViewAsType(view, R.id.playlist_edit, "field 'mEdit'", EditText.class);
        inputTextDialog.mCountTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.playlist_edit_count_tx, "field 'mCountTx'", LaToTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.cancel_tx, "field 'cancelTx' and method 'onViewClicked'");
        inputTextDialog.cancelTx = (LaToTextView) Utils.castView(findRequiredView, R.id.cancel_tx, "field 'cancelTx'", LaToTextView.class);
        this.f4117b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.InputTextDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                inputTextDialog.onViewClicked(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.ok_tx, "field 'okTx' and method 'onViewClicked'");
        inputTextDialog.okTx = (LaToTextView) Utils.castView(findRequiredView2, R.id.ok_tx, "field 'okTx'", LaToTextView.class);
        this.f4118c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.InputTextDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                inputTextDialog.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        InputTextDialog inputTextDialog = this.f4116a;
        if (inputTextDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4116a = null;
        inputTextDialog.mTitleTx = null;
        inputTextDialog.mEdit = null;
        inputTextDialog.mCountTx = null;
        inputTextDialog.cancelTx = null;
        inputTextDialog.okTx = null;
        this.f4117b.setOnClickListener(null);
        this.f4117b = null;
        this.f4118c.setOnClickListener(null);
        this.f4118c = null;
    }
}
