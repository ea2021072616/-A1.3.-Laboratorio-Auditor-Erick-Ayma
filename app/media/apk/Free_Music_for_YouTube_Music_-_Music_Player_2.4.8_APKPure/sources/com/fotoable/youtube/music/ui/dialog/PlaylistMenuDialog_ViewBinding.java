package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class PlaylistMenuDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PlaylistMenuDialog f4313a;

    /* renamed from: b  reason: collision with root package name */
    private View f4314b;

    /* renamed from: c  reason: collision with root package name */
    private View f4315c;

    @UiThread
    public PlaylistMenuDialog_ViewBinding(final PlaylistMenuDialog playlistMenuDialog, View view) {
        this.f4313a = playlistMenuDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.ll_delete, "method 'onClick'");
        this.f4314b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PlaylistMenuDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playlistMenuDialog.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.ll_rename, "method 'onClick'");
        this.f4315c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PlaylistMenuDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playlistMenuDialog.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f4313a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4313a = null;
        this.f4314b.setOnClickListener(null);
        this.f4314b = null;
        this.f4315c.setOnClickListener(null);
        this.f4315c = null;
    }
}
