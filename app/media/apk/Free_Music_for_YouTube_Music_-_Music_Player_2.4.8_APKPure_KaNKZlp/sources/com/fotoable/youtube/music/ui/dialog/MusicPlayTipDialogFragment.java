package com.fotoable.youtube.music.ui.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.dialog.b;
/* loaded from: classes.dex */
public class MusicPlayTipDialogFragment extends b {
    @BindView(R.id.adview_parent)
    FrameLayout adview_parent;

    /* renamed from: c  reason: collision with root package name */
    public String f4244c;
    private a d;
    @BindView(R.id.video_title)
    TextView video_title;

    /* loaded from: classes.dex */
    public static abstract class a implements b.a {
        public abstract void c();

        public abstract void d();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        return layoutInflater.inflate(R.layout.dialog_widget_music_play_tip, viewGroup, false);
    }

    @Override // com.fotoable.youtube.music.ui.dialog.b, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setCancelable(false);
        if (!TextUtils.isEmpty(this.f4244c)) {
            this.video_title.setText(this.f4244c + "");
        } else {
            this.video_title.setText("");
        }
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        a(new b.a() { // from class: com.fotoable.youtube.music.ui.dialog.MusicPlayTipDialogFragment.1
            @Override // com.fotoable.youtube.music.ui.dialog.b.a
            public void b() {
            }

            @Override // com.fotoable.youtube.music.ui.dialog.b.a
            public void a() {
                if (MusicPlayTipDialogFragment.this.d != null) {
                    MusicPlayTipDialogFragment.this.d.a();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.ad_close, R.id.video_play, R.id.search_mp3})
    @Optional
    public void onApplyClick(View view) {
        switch (view.getId()) {
            case R.id.ad_close /* 2131821120 */:
                if (this.d != null) {
                    this.d.a();
                }
                dismissAllowingStateLoss();
                return;
            case R.id.video_play /* 2131821121 */:
                if (this.d != null) {
                    this.d.c();
                }
                dismissAllowingStateLoss();
                return;
            case R.id.search_mp3 /* 2131821122 */:
                if (this.d != null) {
                    this.d.d();
                }
                dismissAllowingStateLoss();
                return;
            default:
                return;
        }
    }

    @Override // com.fotoable.youtube.music.ui.dialog.b, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
