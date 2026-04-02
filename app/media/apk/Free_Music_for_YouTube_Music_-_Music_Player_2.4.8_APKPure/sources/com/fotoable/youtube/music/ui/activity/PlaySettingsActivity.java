package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog;
/* loaded from: classes.dex */
public class PlaySettingsActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f3655a = new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.PlaySettingsActivity.2
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            switch (compoundButton.getId()) {
                case R.id.ck_auto_rotate /* 2131820845 */:
                    com.fotoable.youtube.music.a.j(z);
                    return;
                case R.id.rl_pop_up_size /* 2131820846 */:
                case R.id.rl_auto_play /* 2131820847 */:
                case R.id.rl_action_bar /* 2131820849 */:
                case R.id.rl_wifi_only /* 2131820851 */:
                default:
                    return;
                case R.id.ck_auto_play /* 2131820848 */:
                    com.fotoable.youtube.music.a.q(z);
                    com.fotoable.youtube.music.newplayer.e.a().f(z);
                    return;
                case R.id.ck_action_bar /* 2131820850 */:
                    com.fotoable.youtube.music.a.p(z);
                    return;
                case R.id.ck_wifi_only /* 2131820852 */:
                    com.fotoable.youtube.music.a.o(z);
                    return;
            }
        }
    };
    @BindView(R.id.back_view)
    ImageView backView;
    @BindView(R.id.ck_action_bar)
    CheckBox ckActionBar;
    @BindView(R.id.ck_auto_play)
    CheckBox ckAutoPlay;
    @BindView(R.id.ck_auto_rotate)
    CheckBox ckAutoRotate;
    @BindView(R.id.ck_wifi_only)
    CheckBox ckWifiOnly;
    @BindView(R.id.rl_action_bar)
    RelativeLayout rlActionBar;
    @BindView(R.id.rl_auto_play)
    RelativeLayout rlAutoPlay;
    @BindView(R.id.rl_auto_rotate_screen)
    RelativeLayout rlAutoRotateScreen;
    @BindView(R.id.rl_pop_up_size)
    RelativeLayout rlPopUpSize;
    @BindView(R.id.rl_wifi_only)
    RelativeLayout rlWifiOnly;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_play_settings;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        r();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    private void r() {
        this.ckWifiOnly.setChecked(com.fotoable.youtube.music.a.t());
        this.ckActionBar.setChecked(com.fotoable.youtube.music.a.u());
        this.ckAutoPlay.setChecked(com.fotoable.youtube.music.a.v());
        this.ckAutoRotate.setChecked(com.fotoable.youtube.music.a.p());
        this.ckWifiOnly.setOnCheckedChangeListener(this.f3655a);
        this.ckActionBar.setOnCheckedChangeListener(this.f3655a);
        this.ckAutoPlay.setOnCheckedChangeListener(this.f3655a);
        this.ckAutoRotate.setOnCheckedChangeListener(this.f3655a);
    }

    @OnClick({R.id.rl_auto_rotate_screen, R.id.rl_pop_up_size, R.id.rl_auto_play, R.id.rl_action_bar, R.id.rl_wifi_only, R.id.back_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                return;
            case R.id.rl_auto_rotate_screen /* 2131820844 */:
                this.ckAutoRotate.setChecked(com.fotoable.youtube.music.a.p() ? false : true);
                return;
            case R.id.rl_pop_up_size /* 2131820846 */:
                PopUpSizeSelectDialog.a(getSupportFragmentManager(), new PopUpSizeSelectDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.PlaySettingsActivity.1
                    @Override // com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.a
                    public void a() {
                    }

                    @Override // com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.a
                    public void b() {
                    }

                    @Override // com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.a
                    public void c() {
                    }
                });
                return;
            case R.id.rl_auto_play /* 2131820847 */:
                this.ckAutoPlay.setChecked(com.fotoable.youtube.music.a.v() ? false : true);
                return;
            case R.id.rl_action_bar /* 2131820849 */:
                this.ckActionBar.setChecked(com.fotoable.youtube.music.a.u() ? false : true);
                return;
            case R.id.rl_wifi_only /* 2131820851 */:
                this.ckWifiOnly.setChecked(com.fotoable.youtube.music.a.t() ? false : true);
                return;
            default:
                return;
        }
    }
}
