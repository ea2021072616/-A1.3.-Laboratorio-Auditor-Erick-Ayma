package com.fotoable.youtube.music.ui.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.quicktools.service.QuickToolsService;
import com.fotoable.youtube.music.ui.activity.SettingsActivity;
import com.fotoable.youtube.music.ui.dialog.CloseFeatureDialogFragment;
import com.fotoable.youtube.music.ui.dialog.ScanLocalMusicDialog;
import com.fotoable.youtube.music.ui.dialog.n;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.l;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
import rx.f;
import rx.schedulers.Schedulers;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class SettingsActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3778a = SettingsActivity.class.getSimpleName();
    @BindView(R.id.cache_size)
    LaToTextView cache_size;
    @BindView(R.id.char_checkbox)
    CheckBox char_checkbox;
    @BindView(R.id.ck_auto_play)
    CheckBox ckAutoPlay;
    @BindView(R.id.ck_download_artists)
    CheckBox ckDownloadArtists;
    @BindView(R.id.ck_music_reminder)
    CheckBox ckMusicReminder;
    @BindView(R.id.ck_toolbar)
    CheckBox ckToolbar;
    @BindView(R.id.ck_wifi_only)
    CheckBox ckWifiOnly;
    private com.fotoable.youtube.music.ui.dialog.n d;
    @BindView(R.id.rl_set_country_code)
    RelativeLayout mCountryCodeView;
    @BindView(R.id.music_locker_checkbox)
    CheckBox music_locker_checkbox;
    @BindView(R.id.rl_toolbar)
    RelativeLayout rl_toolbar;
    @BindView(R.id.tool_checkbox)
    CheckBox toolCheckbox;
    @BindView(R.id.tool_switch_view)
    RelativeLayout tool_switch_view;

    /* renamed from: b  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f3779b = new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            switch (compoundButton.getId()) {
                case R.id.ck_auto_play /* 2131820848 */:
                    com.fotoable.youtube.music.a.q(z);
                    com.fotoable.youtube.music.newplayer.e.a().f(z);
                    return;
                case R.id.ck_wifi_only /* 2131820852 */:
                    com.fotoable.youtube.music.a.o(z);
                    return;
                case R.id.ck_music_reminder /* 2131820916 */:
                    com.fotoable.youtube.music.a.r(z);
                    return;
                case R.id.ck_download_artists /* 2131820918 */:
                    com.fotoable.youtube.music.a.s(z);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private boolean f3780c = false;
    private Map<String, String> e = new TreeMap();

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_settins;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        w();
        if (com.fotoable.youtube.music.quicktools.a.a.a(this)) {
            this.rl_toolbar.setVisibility(8);
        } else {
            this.ckToolbar.setChecked(com.fotoable.youtube.music.a.o());
            this.ckToolbar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.fotoable.youtube.music.ui.activity.bg

                /* renamed from: a  reason: collision with root package name */
                private final SettingsActivity f3976a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3976a = this;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f3976a.a(compoundButton, z);
                }
            });
        }
        if (com.fotoable.youtube.music.util.a.a()) {
            this.mCountryCodeView.setVisibility(0);
            z();
        } else {
            this.mCountryCodeView.setVisibility(8);
        }
        if (com.fotoable.youtube.music.quicktools.a.a.a(this)) {
            this.tool_switch_view.setVisibility(8);
        }
        this.ckWifiOnly.setChecked(com.fotoable.youtube.music.a.t());
        this.ckAutoPlay.setChecked(com.fotoable.youtube.music.a.v());
        this.ckMusicReminder.setChecked(com.fotoable.youtube.music.a.y());
        this.ckDownloadArtists.setChecked(com.fotoable.youtube.music.a.z());
        this.ckWifiOnly.setOnCheckedChangeListener(this.f3779b);
        this.ckAutoPlay.setOnCheckedChangeListener(this.f3779b);
        this.ckMusicReminder.setOnCheckedChangeListener(this.f3779b);
        this.ckDownloadArtists.setOnCheckedChangeListener(this.f3779b);
        s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        if (z) {
            if (m()) {
                com.fotoable.youtube.music.a.i(z);
                QuickToolsService.a(this, "action_show_quick");
                com.fotoable.youtube.music.util.b.b("Dev_底部工具栏开关-打开");
                return;
            }
            l();
            com.fotoable.youtube.music.util.b.b("Dev_底部工具栏开关-跳转到授权界面");
            return;
        }
        com.fotoable.youtube.music.a.i(z);
        QuickToolsService.a(this);
        com.fotoable.youtube.music.util.b.b("Dev_底部工具栏开关-关闭");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.toolCheckbox != null) {
            this.toolCheckbox.setChecked(com.fotoable.youtube.music.a.o());
        }
        if (this.music_locker_checkbox != null) {
            this.music_locker_checkbox.setChecked(com.fotoable.youtube.music.a.n());
        }
    }

    private void s() {
        this.music_locker_checkbox.setChecked(com.fotoable.youtube.music.a.n());
        this.toolCheckbox.setChecked(com.fotoable.youtube.music.a.o());
        this.toolCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!z) {
                    SettingsActivity.this.v();
                } else if (SettingsActivity.this.m()) {
                    com.fotoable.youtube.music.a.i(z);
                    com.fotoable.youtube.music.util.h.a(SettingsActivity.f3778a, "打开开关");
                    QuickToolsService.a(SettingsActivity.this, "action_show_quick");
                    com.fotoable.youtube.music.util.b.b("Dev_底部工具栏开关-打开");
                } else {
                    SettingsActivity.this.l();
                    com.fotoable.youtube.music.util.b.b("Dev_底部工具栏开关-跳转到授权界面");
                }
            }
        });
        this.toolCheckbox.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (com.fotoable.youtube.music.a.o()) {
                    switch (motionEvent.getAction()) {
                        case 1:
                            SettingsActivity.this.v();
                            break;
                    }
                    return true;
                }
                return false;
            }
        });
        this.music_locker_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!z) {
                    SettingsActivity.this.t();
                    return;
                }
                com.fotoable.youtube.music.a.h(z);
                com.fotoable.youtube.music.util.b.b("侧边栏-音乐锁屏开关-打开");
            }
        });
        this.music_locker_checkbox.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (com.fotoable.youtube.music.a.n()) {
                    switch (motionEvent.getAction()) {
                        case 1:
                            SettingsActivity.this.t();
                            break;
                    }
                    return true;
                }
                return false;
            }
        });
        this.char_checkbox.setChecked(com.fotoable.youtube.music.a.i());
        this.char_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.12
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!z) {
                    SettingsActivity.this.u();
                    return;
                }
                com.fotoable.youtube.music.a.b(true);
                com.fotoable.youtube.music.newplayer.e.a().i(true);
                com.fotoable.youtube.music.util.b.b("侧边栏-充电锁屏开关", "状态", "打开");
            }
        });
        this.char_checkbox.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (com.fotoable.youtube.music.a.i()) {
                    switch (motionEvent.getAction()) {
                        case 1:
                            SettingsActivity.this.u();
                            break;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (com.fotoable.youtube.music.a.n()) {
            CloseFeatureDialogFragment.a(getSupportFragmentManager(), getString(R.string.turn_off_play_lockscreen_des), new CloseFeatureDialogFragment.a() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.14
                @Override // com.fotoable.youtube.music.ui.dialog.CloseFeatureDialogFragment.a
                public void a() {
                    com.fotoable.youtube.music.a.h(false);
                    SettingsActivity.this.music_locker_checkbox.setChecked(false);
                    com.fotoable.youtube.music.util.b.b("侧边栏-音乐锁屏开关-关闭");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (com.fotoable.youtube.music.a.i()) {
            CloseFeatureDialogFragment.a(getSupportFragmentManager(), getString(R.string.warning_close_charging_protection), new CloseFeatureDialogFragment.a() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.15
                @Override // com.fotoable.youtube.music.ui.dialog.CloseFeatureDialogFragment.a
                public void a() {
                    com.fotoable.youtube.music.a.b(false);
                    SettingsActivity.this.char_checkbox.setChecked(false);
                    com.fotoable.youtube.music.util.b.b("侧边栏-充电锁屏开关", "状态", "关闭");
                    com.fotoable.youtube.music.newplayer.e.a().i(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (com.fotoable.youtube.music.a.o()) {
            CloseFeatureDialogFragment.a(getSupportFragmentManager(), getString(R.string.warning_close_tools_bar), new CloseFeatureDialogFragment.a() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.2
                @Override // com.fotoable.youtube.music.ui.dialog.CloseFeatureDialogFragment.a
                public void a() {
                    com.fotoable.youtube.music.a.i(false);
                    SettingsActivity.this.toolCheckbox.setChecked(false);
                    com.fotoable.youtube.music.util.h.a(SettingsActivity.f3778a, "关闭开关");
                    QuickToolsService.a(SettingsActivity.this);
                    com.fotoable.youtube.music.util.b.b("Dev_底部工具栏开关-关闭");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.fotoable.youtube.music.util.l.a().a(i, i2, intent);
        if (m()) {
            com.fotoable.youtube.music.a.i(true);
        } else {
            com.fotoable.youtube.music.a.i(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        try {
            long a2 = a(com.bumptech.glide.i.a((Context) this));
            long a3 = a(new File(getCacheDir(), "http"));
            if (a2 + a3 > 0) {
                this.cache_size.setText("" + a(a2 + a3));
            } else {
                this.cache_size.setText("");
            }
            com.fotoable.youtube.music.util.h.a(f3778a, "缓存大小：" + a(a2 + a3));
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @OnClick({R.id.back_view, R.id.rl_rate_us, R.id.rl_privacy_policy, R.id.rl_clear_cache, R.id.rl_share_app, R.id.rl_join_our_community, R.id.rl_set_country_code, R.id.rl_toolbar, R.id.rl_auto_play, R.id.rl_wifi_only, R.id.rl_music_reminder, R.id.rl_download_artists, R.id.rl_reload_music, R.id.iv_reload_music, R.id.tool_switch_view, R.id.music_locker_panel, R.id.char_switch_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                return;
            case R.id.rl_join_our_community /* 2131820739 */:
                startActivity(new Intent(this, JoinOurCommunityActivity.class));
                com.fotoable.youtube.music.util.b.b("Settings-Community");
                return;
            case R.id.rl_privacy_policy /* 2131820741 */:
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://cdn-freemusic.fotoable.net/privacy.html")));
                    return;
                } catch (ActivityNotFoundException e) {
                    ThrowableExtension.printStackTrace(e);
                    return;
                }
            case R.id.rl_auto_play /* 2131820847 */:
                this.ckAutoPlay.setChecked(com.fotoable.youtube.music.a.v() ? false : true);
                return;
            case R.id.rl_wifi_only /* 2131820851 */:
                this.ckWifiOnly.setChecked(com.fotoable.youtube.music.a.t() ? false : true);
                return;
            case R.id.music_locker_panel /* 2131820909 */:
                if (!com.fotoable.youtube.music.a.n()) {
                    this.music_locker_checkbox.setChecked(com.fotoable.youtube.music.a.n() ? false : true);
                    return;
                } else {
                    t();
                    return;
                }
            case R.id.char_switch_view /* 2131820911 */:
                if (!com.fotoable.youtube.music.a.i()) {
                    this.char_checkbox.setChecked(com.fotoable.youtube.music.a.i() ? false : true);
                    return;
                } else {
                    u();
                    return;
                }
            case R.id.tool_switch_view /* 2131820913 */:
                if (!com.fotoable.youtube.music.a.o()) {
                    this.toolCheckbox.setChecked(com.fotoable.youtube.music.a.o() ? false : true);
                    return;
                } else {
                    v();
                    return;
                }
            case R.id.rl_music_reminder /* 2131820915 */:
                this.ckMusicReminder.setChecked(com.fotoable.youtube.music.a.y() ? false : true);
                return;
            case R.id.rl_download_artists /* 2131820917 */:
                this.ckDownloadArtists.setChecked(com.fotoable.youtube.music.a.z() ? false : true);
                return;
            case R.id.rl_reload_music /* 2131820919 */:
            case R.id.iv_reload_music /* 2131820920 */:
                com.fotoable.youtube.music.util.b.b("设置页面--重新扫描本地音乐");
                if (com.fotoable.youtube.music.util.l.a().a("android.permission.READ_EXTERNAL_STORAGE")) {
                    ScanLocalMusicDialog.a(getSupportFragmentManager());
                    return;
                } else {
                    x();
                    return;
                }
            case R.id.rl_toolbar /* 2131820921 */:
                this.ckToolbar.setChecked(com.fotoable.youtube.music.a.o() ? false : true);
                return;
            case R.id.rl_clear_cache /* 2131820924 */:
                if (!this.f3780c) {
                    this.f3780c = true;
                    this.d = com.fotoable.youtube.music.ui.dialog.n.a(getSupportFragmentManager(), 0, new n.a() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.3
                        @Override // com.fotoable.youtube.music.ui.dialog.n.a
                        public void a() {
                        }
                    });
                    a(rx.f.a((f.a) new f.a<Object>() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.5
                        @Override // rx.c.b
                        /* renamed from: a */
                        public void call(rx.l<? super Object> lVar) {
                            com.bumptech.glide.i.b(SettingsActivity.this).i();
                            SettingsActivity.this.a(new File(SettingsActivity.this.getCacheDir(), "http").getAbsolutePath(), false);
                            if (lVar != null && !lVar.isUnsubscribed()) {
                                lVar.onNext(null);
                                lVar.onCompleted();
                            }
                        }
                    }).b(Schedulers.io()).a(rx.a.b.a.a()).b(new rx.l<Object>() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.4
                        @Override // rx.l
                        public void onStart() {
                            super.onStart();
                        }

                        @Override // rx.g
                        public void onCompleted() {
                            if (SettingsActivity.this.d != null) {
                                SettingsActivity.this.d.dismiss();
                                SettingsActivity.this.d = null;
                            }
                            Toast.makeText(SettingsActivity.this, (int) R.string.clear_success_msg, 0).show();
                        }

                        @Override // rx.g
                        public void onError(Throwable th) {
                            SettingsActivity.this.f3780c = false;
                            ThrowableExtension.printStackTrace(th);
                            if (SettingsActivity.this.d != null) {
                                SettingsActivity.this.d.dismiss();
                                SettingsActivity.this.d = null;
                            }
                        }

                        @Override // rx.g
                        public void onNext(Object obj) {
                            SettingsActivity.this.f3780c = false;
                            SettingsActivity.this.w();
                        }
                    }));
                    return;
                }
                return;
            case R.id.rl_share_app /* 2131820928 */:
                com.fotoable.youtube.music.util.b.b("设置-分享App");
                com.fotoable.youtube.music.helper.f.a(this, getString(R.string.share_app_content), true);
                return;
            case R.id.rl_rate_us /* 2131820930 */:
                com.fotoable.youtube.music.util.w.a(getPackageName(), this);
                return;
            case R.id.rl_set_country_code /* 2131820933 */:
                A();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fotoable.youtube.music.ui.activity.SettingsActivity$6  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass6 implements l.a {
        AnonymousClass6() {
        }

        @Override // com.fotoable.youtube.music.util.l.a
        public void a() {
            ScanLocalMusicDialog.a(SettingsActivity.this.getSupportFragmentManager());
        }

        @Override // com.fotoable.youtube.music.util.l.a
        public void b() {
            AlertDialog.Builder positiveButton = new AlertDialog.Builder(SettingsActivity.this).setTitle(SettingsActivity.this.getString(R.string.read_local_permission)).setMessage(SettingsActivity.this.getString(R.string.request_external_storage)).setPositiveButton(SettingsActivity.this.getString(R.string.ok), new DialogInterface.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.activity.bh

                /* renamed from: a  reason: collision with root package name */
                private final SettingsActivity.AnonymousClass6 f3977a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3977a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f3977a.b(dialogInterface, i);
                }
            });
            positiveButton.setCancelable(false);
            positiveButton.show();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void b(DialogInterface dialogInterface, int i) {
            SettingsActivity.this.x();
            dialogInterface.dismiss();
        }

        @Override // com.fotoable.youtube.music.util.l.a
        public void c() {
            AlertDialog.Builder positiveButton = new AlertDialog.Builder(SettingsActivity.this).setTitle(SettingsActivity.this.getString(R.string.read_local_permission)).setMessage(SettingsActivity.this.getString(R.string.request_in_settings)).setPositiveButton(SettingsActivity.this.getString(R.string.ok), new DialogInterface.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.activity.bi

                /* renamed from: a  reason: collision with root package name */
                private final SettingsActivity.AnonymousClass6 f3978a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3978a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f3978a.a(dialogInterface, i);
                }
            });
            positiveButton.setCancelable(false);
            positiveButton.show();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void a(DialogInterface dialogInterface, int i) {
            SettingsActivity.this.y();
            dialogInterface.dismiss();
        }

        @Override // com.fotoable.youtube.music.util.l.a
        public void d() {
            SettingsActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.fotoable.youtube.music.util.l.a().a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0, new AnonymousClass6());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        com.fotoable.youtube.music.util.l.a().a(this, i, strArr, iArr);
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + MusicApplication.c().getPackageName()));
        intent.addCategory("android.intent.category.DEFAULT");
        startActivityForResult(intent, 1);
    }

    public long a(File file) throws Exception {
        long length;
        long j = 0;
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory()) {
                length = a(listFiles[i]);
            } else {
                length = listFiles[i].length();
            }
            j += length;
        }
        return j;
    }

    public String a(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        }
        if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return decimalFormat.format(j / 1024.0d) + "K";
        }
        if (j < IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return decimalFormat.format(j / 1048576.0d) + "M";
        }
        return decimalFormat.format(j / 1.073741824E9d) + "G";
    }

    public void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        a(file2.getAbsolutePath(), true);
                    }
                }
                if (z) {
                    if (!file.isDirectory()) {
                        file.delete();
                    } else if (file.listFiles().length == 0) {
                        file.delete();
                    }
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    private void z() {
        this.e.put("印度", "IN");
        this.e.put("巴西", "BR");
        this.e.put("墨西哥", "MX");
        this.e.put("日本", "JP");
        this.e.put("通用", "US");
        this.e.put("新加坡", "SG");
        this.e.put("全球", "WORLD");
        this.e.put("中国", "CN");
        this.e.put("丹麦", "DK");
        this.e.put("乌克兰", "UA");
        this.e.put("乌拉圭", "UY");
        this.e.put("以色列", "IL");
        this.e.put("俄罗斯", "RU");
        this.e.put("保加利亚", "BG");
        this.e.put("克罗地亚", "HR");
        this.e.put("加拿大", "CA");
        this.e.put("匈牙利", "HU");
        this.e.put("南非", "ZA");
        this.e.put("印度尼西亚", "ID");
        this.e.put("厄瓜多尔", "EC");
        this.e.put("台湾", "TW");
        this.e.put("哈萨克斯坦", "KZ");
        this.e.put("哥伦比亚", "CO");
        this.e.put("哥斯达黎加", "CR");
        this.e.put("土耳其", "TR");
        this.e.put("奥地利", "AT");
        this.e.put("委内瑞拉", "VE");
        this.e.put("希腊", "GR");
        this.e.put("德国", "DE");
        this.e.put("意大利", "IT");
        this.e.put("挪威", "NO");
        this.e.put("捷克共和国", "CZ");
        this.e.put("新西兰", "NZ");
        this.e.put("智利", "CL");
        this.e.put("比利时", "BE");
        this.e.put("沙特阿拉伯", "SA");
        this.e.put("法国", "FR");
        this.e.put("波兰", "PL");
        this.e.put("泰国", "TH");
        this.e.put("澳大利亚", "AU");
        this.e.put("爱尔兰", "IE");
        this.e.put("瑞典", "SE");
        this.e.put("瑞士", "CH");
        this.e.put("秘鲁", "PE");
        this.e.put("罗马尼亚", "RO");
        this.e.put("美国", "US");
        this.e.put("芬兰", "FI");
        this.e.put("英国", "GB");
        this.e.put("荷兰", "NL");
        this.e.put("葡萄牙", "PT");
        this.e.put("西班牙", "ES");
        this.e.put("阿根廷", "AR");
        this.e.put("韩国", "KR");
        this.e.put("马来西亚", "MY");
    }

    private void A() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] strArr = (String[]) this.e.keySet().toArray(new String[this.e.size()]);
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.fotoable.youtube.music.util.v.b(MusicApplication.c(), "country_code", (String) SettingsActivity.this.e.get(strArr[i]));
            }
        });
        builder.create();
        builder.show();
    }
}
