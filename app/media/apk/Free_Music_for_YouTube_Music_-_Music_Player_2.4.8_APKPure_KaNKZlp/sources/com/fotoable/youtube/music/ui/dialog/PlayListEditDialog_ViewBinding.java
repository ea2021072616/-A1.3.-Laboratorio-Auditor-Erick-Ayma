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
public class PlayListEditDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PlayListEditDialog f4284a;

    /* renamed from: b  reason: collision with root package name */
    private View f4285b;

    /* renamed from: c  reason: collision with root package name */
    private View f4286c;

    @UiThread
    public PlayListEditDialog_ViewBinding(final PlayListEditDialog playListEditDialog, View view) {
        this.f4284a = playListEditDialog;
        playListEditDialog.mTitleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.playlist_title_tx, "field 'mTitleTx'", LaToTextView.class);
        playListEditDialog.mEdit = (EditText) Utils.findRequiredViewAsType(view, R.id.playlist_edit, "field 'mEdit'", EditText.class);
        playListEditDialog.mCountTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.playlist_edit_count_tx, "field 'mCountTx'", LaToTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.cancel_tx, "field 'cancelTx' and method 'onViewClicked'");
        playListEditDialog.cancelTx = (LaToTextView) Utils.castView(findRequiredView, R.id.cancel_tx, "field 'cancelTx'", LaToTextView.class);
        this.f4285b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PlayListEditDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playListEditDialog.onViewClicked(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.ok_tx, "field 'okTx' and method 'onViewClicked'");
        playListEditDialog.okTx = (LaToTextView) Utils.castView(findRequiredView2, R.id.ok_tx, "field 'okTx'", LaToTextView.class);
        this.f4286c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PlayListEditDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playListEditDialog.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PlayListEditDialog playListEditDialog = this.f4284a;
        if (playListEditDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4284a = null;
        playListEditDialog.mTitleTx = null;
        playListEditDialog.mEdit = null;
        playListEditDialog.mCountTx = null;
        playListEditDialog.cancelTx = null;
        playListEditDialog.okTx = null;
        this.f4285b.setOnClickListener(null);
        this.f4285b = null;
        this.f4286c.setOnClickListener(null);
        this.f4286c = null;
    }
}
