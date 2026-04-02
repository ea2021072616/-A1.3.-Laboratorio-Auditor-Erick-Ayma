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
public class LocalPlayListEditDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalPlayListEditDialog f4183a;

    /* renamed from: b  reason: collision with root package name */
    private View f4184b;

    /* renamed from: c  reason: collision with root package name */
    private View f4185c;

    @UiThread
    public LocalPlayListEditDialog_ViewBinding(final LocalPlayListEditDialog localPlayListEditDialog, View view) {
        this.f4183a = localPlayListEditDialog;
        localPlayListEditDialog.mTitleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.playlist_title_tx, "field 'mTitleTx'", LaToTextView.class);
        localPlayListEditDialog.mEdit = (EditText) Utils.findRequiredViewAsType(view, R.id.playlist_edit, "field 'mEdit'", EditText.class);
        localPlayListEditDialog.mCountTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.playlist_edit_count_tx, "field 'mCountTx'", LaToTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.cancel_tx, "field 'cancelTx' and method 'onViewClicked'");
        localPlayListEditDialog.cancelTx = (LaToTextView) Utils.castView(findRequiredView, R.id.cancel_tx, "field 'cancelTx'", LaToTextView.class);
        this.f4184b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalPlayListEditDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localPlayListEditDialog.onViewClicked(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.ok_tx, "field 'okTx' and method 'onViewClicked'");
        localPlayListEditDialog.okTx = (LaToTextView) Utils.castView(findRequiredView2, R.id.ok_tx, "field 'okTx'", LaToTextView.class);
        this.f4185c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalPlayListEditDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localPlayListEditDialog.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalPlayListEditDialog localPlayListEditDialog = this.f4183a;
        if (localPlayListEditDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4183a = null;
        localPlayListEditDialog.mTitleTx = null;
        localPlayListEditDialog.mEdit = null;
        localPlayListEditDialog.mCountTx = null;
        localPlayListEditDialog.cancelTx = null;
        localPlayListEditDialog.okTx = null;
        this.f4184b.setOnClickListener(null);
        this.f4184b = null;
        this.f4185c.setOnClickListener(null);
        this.f4185c = null;
    }
}
