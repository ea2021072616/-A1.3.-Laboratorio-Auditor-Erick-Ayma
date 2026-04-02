package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class PlayerMusicListDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PlayerMusicListDialog f4292a;

    /* renamed from: b  reason: collision with root package name */
    private View f4293b;

    @UiThread
    public PlayerMusicListDialog_ViewBinding(final PlayerMusicListDialog playerMusicListDialog, View view) {
        this.f4292a = playerMusicListDialog;
        playerMusicListDialog.play_queue_count = (TextView) Utils.findRequiredViewAsType(view, R.id.play_queue_count, "field 'play_queue_count'", TextView.class);
        playerMusicListDialog.recycle_view = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycle_view'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.clear_all, "method 'onApplyClick'");
        this.f4293b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PlayerMusicListDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerMusicListDialog.onApplyClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PlayerMusicListDialog playerMusicListDialog = this.f4292a;
        if (playerMusicListDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4292a = null;
        playerMusicListDialog.play_queue_count = null;
        playerMusicListDialog.recycle_view = null;
        this.f4293b.setOnClickListener(null);
        this.f4293b = null;
    }
}
