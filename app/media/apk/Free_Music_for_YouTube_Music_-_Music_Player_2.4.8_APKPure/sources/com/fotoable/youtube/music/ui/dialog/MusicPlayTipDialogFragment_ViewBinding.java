package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class MusicPlayTipDialogFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MusicPlayTipDialogFragment f4246a;

    /* renamed from: b  reason: collision with root package name */
    private View f4247b;

    /* renamed from: c  reason: collision with root package name */
    private View f4248c;
    private View d;

    @UiThread
    public MusicPlayTipDialogFragment_ViewBinding(final MusicPlayTipDialogFragment musicPlayTipDialogFragment, View view) {
        this.f4246a = musicPlayTipDialogFragment;
        musicPlayTipDialogFragment.video_title = (TextView) Utils.findRequiredViewAsType(view, R.id.video_title, "field 'video_title'", TextView.class);
        musicPlayTipDialogFragment.adview_parent = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.adview_parent, "field 'adview_parent'", FrameLayout.class);
        View findViewById = view.findViewById(R.id.ad_close);
        if (findViewById != null) {
            this.f4247b = findViewById;
            findViewById.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicPlayTipDialogFragment_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    musicPlayTipDialogFragment.onApplyClick(view2);
                }
            });
        }
        View findViewById2 = view.findViewById(R.id.video_play);
        if (findViewById2 != null) {
            this.f4248c = findViewById2;
            findViewById2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicPlayTipDialogFragment_ViewBinding.2
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    musicPlayTipDialogFragment.onApplyClick(view2);
                }
            });
        }
        View findViewById3 = view.findViewById(R.id.search_mp3);
        if (findViewById3 != null) {
            this.d = findViewById3;
            findViewById3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicPlayTipDialogFragment_ViewBinding.3
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    musicPlayTipDialogFragment.onApplyClick(view2);
                }
            });
        }
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicPlayTipDialogFragment musicPlayTipDialogFragment = this.f4246a;
        if (musicPlayTipDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4246a = null;
        musicPlayTipDialogFragment.video_title = null;
        musicPlayTipDialogFragment.adview_parent = null;
        if (this.f4247b != null) {
            this.f4247b.setOnClickListener(null);
            this.f4247b = null;
        }
        if (this.f4248c != null) {
            this.f4248c.setOnClickListener(null);
            this.f4248c = null;
        }
        if (this.d != null) {
            this.d.setOnClickListener(null);
            this.d = null;
        }
    }
}
