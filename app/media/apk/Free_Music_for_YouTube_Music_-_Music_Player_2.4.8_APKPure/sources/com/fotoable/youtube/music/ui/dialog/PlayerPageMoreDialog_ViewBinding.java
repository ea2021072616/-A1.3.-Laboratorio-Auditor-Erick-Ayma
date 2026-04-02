package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class PlayerPageMoreDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PlayerPageMoreDialog f4298a;

    /* renamed from: b  reason: collision with root package name */
    private View f4299b;

    /* renamed from: c  reason: collision with root package name */
    private View f4300c;
    private View d;

    @UiThread
    public PlayerPageMoreDialog_ViewBinding(final PlayerPageMoreDialog playerPageMoreDialog, View view) {
        this.f4298a = playerPageMoreDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.add_to_playlist, "method 'onApplyClick'");
        this.f4299b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PlayerPageMoreDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerPageMoreDialog.onApplyClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.video_search_lyric, "method 'onApplyClick'");
        this.f4300c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PlayerPageMoreDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerPageMoreDialog.onApplyClick(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.video_search_mp3, "method 'onApplyClick'");
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PlayerPageMoreDialog_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerPageMoreDialog.onApplyClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f4298a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4298a = null;
        this.f4299b.setOnClickListener(null);
        this.f4299b = null;
        this.f4300c.setOnClickListener(null);
        this.f4300c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
