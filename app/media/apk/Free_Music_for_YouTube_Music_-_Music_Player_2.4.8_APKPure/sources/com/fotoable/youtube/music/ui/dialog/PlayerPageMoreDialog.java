package com.fotoable.youtube.music.ui.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.dialog.b;
/* loaded from: classes.dex */
public class PlayerPageMoreDialog extends b {
    private static final String d = PlayerPageMoreDialog.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public boolean f4296c;
    private a e;

    /* loaded from: classes.dex */
    public static abstract class a implements b.a {
        public abstract void c();

        public abstract void d();

        public abstract void e();
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_player_page_more, viewGroup, false);
    }

    @Override // com.fotoable.youtube.music.ui.dialog.b, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        getDialog().requestWindowFeature(1);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        getDialog().getWindow().setGravity(80);
        Window window = getDialog().getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        getDialog().setCancelable(true);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.down_fragment_alpha)));
        getDialog().getWindow().setWindowAnimations(R.style.download_popup_animation);
        if (!this.f4296c) {
            view.findViewById(R.id.add_to_playlist).setVisibility(8);
        }
        a(new b.a() { // from class: com.fotoable.youtube.music.ui.dialog.PlayerPageMoreDialog.1
            @Override // com.fotoable.youtube.music.ui.dialog.b.a
            public void b() {
            }

            @Override // com.fotoable.youtube.music.ui.dialog.b.a
            public void a() {
                if (PlayerPageMoreDialog.this.e != null) {
                    PlayerPageMoreDialog.this.e.a();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.add_to_playlist, R.id.video_search_lyric, R.id.video_search_mp3})
    public void onApplyClick(View view) {
        switch (view.getId()) {
            case R.id.add_to_playlist /* 2131821046 */:
                if (this.e != null) {
                    this.e.c();
                }
                dismissAllowingStateLoss();
                return;
            case R.id.video_search_lyric /* 2131821075 */:
                if (this.e != null) {
                    this.e.d();
                }
                dismissAllowingStateLoss();
                return;
            case R.id.video_search_mp3 /* 2131821076 */:
                if (this.e != null) {
                    this.e.e();
                }
                dismissAllowingStateLoss();
                return;
            default:
                return;
        }
    }
}
