package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class LocalCreatedPlayListDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalCreatedPlayListDialog f4130a;

    /* renamed from: b  reason: collision with root package name */
    private View f4131b;

    @UiThread
    public LocalCreatedPlayListDialog_ViewBinding(final LocalCreatedPlayListDialog localCreatedPlayListDialog, View view) {
        this.f4130a = localCreatedPlayListDialog;
        localCreatedPlayListDialog.mPlayList = (ListView) Utils.findRequiredViewAsType(view, R.id.dialog_play_list, "field 'mPlayList'", ListView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.dialog_play_list_root, "method 'onViewClicked'");
        this.f4131b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalCreatedPlayListDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localCreatedPlayListDialog.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalCreatedPlayListDialog localCreatedPlayListDialog = this.f4130a;
        if (localCreatedPlayListDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4130a = null;
        localCreatedPlayListDialog.mPlayList = null;
        this.f4131b.setOnClickListener(null);
        this.f4131b = null;
    }
}
