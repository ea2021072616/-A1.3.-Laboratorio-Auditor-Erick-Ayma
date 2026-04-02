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
public class AddPlayListDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private AddPlayListDialog f4034a;

    /* renamed from: b  reason: collision with root package name */
    private View f4035b;

    @UiThread
    public AddPlayListDialog_ViewBinding(final AddPlayListDialog addPlayListDialog, View view) {
        this.f4034a = addPlayListDialog;
        addPlayListDialog.mPlayList = (ListView) Utils.findRequiredViewAsType(view, R.id.dialog_play_list, "field 'mPlayList'", ListView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.dialog_play_list_root, "method 'onViewClicked'");
        this.f4035b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.AddPlayListDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                addPlayListDialog.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddPlayListDialog addPlayListDialog = this.f4034a;
        if (addPlayListDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4034a = null;
        addPlayListDialog.mPlayList = null;
        this.f4035b.setOnClickListener(null);
        this.f4035b = null;
    }
}
