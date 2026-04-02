package com.fotoable.youtube.music.locker.activity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.locker.view.EmptyView;
import com.fotoable.youtube.music.locker.view.MusicLockerView;
import com.fotoable.youtube.music.locker.view.VerticalViewPager;
import com.fotoable.youtube.music.newplayer.e;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
import com.fotoable.youtube.music.ui.activity.MainActivity;
import com.fotoable.youtube.music.ui.dialog.CharLockerMenuDialog;
import com.fotoable.youtube.music.ui.dialog.CloseFeatureDialogFragment;
import com.fotoable.youtube.music.ui.dialog.LockerScreenMenuDialog;
import com.fotoable.youtube.music.util.h;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LockerScreenActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2756a = false;

    /* renamed from: b  reason: collision with root package name */
    private LocalMusicModel f2757b;

    /* renamed from: c  reason: collision with root package name */
    private RadioModel f2758c;
    private String d;
    private int e;
    private MusicLockerView f;
    @BindView(R.id.locker_vertical_view_pager)
    VerticalViewPager verticalViewPager;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_locker_screen;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a() {
        super.a();
        getWindow().addFlags(524288);
        getWindow().addFlags(4194304);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void c() {
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void b() {
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        f2756a = true;
        Intent intent = getIntent();
        String str = "其它";
        if (intent != null && intent.hasExtra("type")) {
            this.d = intent.getStringExtra("type");
            if (TextUtils.equals(this.d, "char")) {
                this.e = 1;
            } else if (TextUtils.equals(this.d, "player")) {
                this.e = 2;
                if (intent.hasExtra("LocalMusicModel")) {
                    this.f2757b = (LocalMusicModel) intent.getParcelableExtra("LocalMusicModel");
                    a(this.f2757b);
                    str = "本地音乐";
                } else if (intent.hasExtra("RadioModel")) {
                    this.f2758c = (RadioModel) intent.getParcelableExtra("RadioModel");
                    a(this.f2758c);
                    str = "电台";
                }
            }
        }
        d();
        v();
        if (this.e == 1) {
            this.f.setType(1);
            com.fotoable.youtube.music.util.b.b("充电锁屏-展示次数");
        } else if (this.e == 2) {
            this.f.setType(2);
            com.fotoable.youtube.music.util.b.b("音乐锁屏-展示次数", "播放类型", str);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
    }

    public static void a(Context context) {
        try {
            Intent intent = new Intent(context, LockerScreenActivity.class);
            intent.putExtra("type", "char");
            intent.addFlags(872415232);
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(com.fotoable.youtube.music.e.a aVar) {
        super.a(aVar);
        if (aVar != null) {
            switch (aVar.f2726a) {
                case 2005:
                    this.e = 2;
                    this.f.setType(2);
                    a((PlayerInfo) aVar.f2727b);
                    return;
                case 2019:
                    if (this.e == 1) {
                        CharLockerMenuDialog.b bVar = new CharLockerMenuDialog.b(getSupportFragmentManager());
                        bVar.a(new CharLockerMenuDialog.a(this) { // from class: com.fotoable.youtube.music.locker.activity.a

                            /* renamed from: a  reason: collision with root package name */
                            private final LockerScreenActivity f2765a;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f2765a = this;
                            }

                            @Override // com.fotoable.youtube.music.ui.dialog.CharLockerMenuDialog.a
                            public void a() {
                                this.f2765a.s();
                            }
                        });
                        bVar.a().a();
                        return;
                    } else if (this.e == 2) {
                        LockerScreenMenuDialog.b bVar2 = new LockerScreenMenuDialog.b(getSupportFragmentManager());
                        bVar2.a(new LockerScreenMenuDialog.a(this) { // from class: com.fotoable.youtube.music.locker.activity.b

                            /* renamed from: a  reason: collision with root package name */
                            private final LockerScreenActivity f2766a;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f2766a = this;
                            }

                            @Override // com.fotoable.youtube.music.ui.dialog.LockerScreenMenuDialog.a
                            public void a() {
                                this.f2766a.r();
                            }
                        });
                        bVar2.a().a();
                        return;
                    } else {
                        return;
                    }
                case 2021:
                    Intent intent = new Intent(this, MainActivity.class);
                    if (this.e == 1) {
                        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "char_locker");
                    } else {
                        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "music_locker");
                    }
                    startActivity(intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void s() {
        if (com.fotoable.youtube.music.a.n()) {
            CloseFeatureDialogFragment.a(getSupportFragmentManager(), getString(R.string.warning_close_charging_protection), new CloseFeatureDialogFragment.a() { // from class: com.fotoable.youtube.music.locker.activity.LockerScreenActivity.1
                @Override // com.fotoable.youtube.music.ui.dialog.CloseFeatureDialogFragment.a
                public void a() {
                    com.fotoable.youtube.music.a.b(false);
                    e.a().i(false);
                    com.fotoable.youtube.music.util.b.b("充电锁屏-充电锁屏开关-关闭");
                    LockerScreenActivity.this.finish();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void r() {
        if (com.fotoable.youtube.music.a.n()) {
            CloseFeatureDialogFragment.a(getSupportFragmentManager(), getString(R.string.turn_off_play_lockscreen_des), new CloseFeatureDialogFragment.a() { // from class: com.fotoable.youtube.music.locker.activity.LockerScreenActivity.2
                @Override // com.fotoable.youtube.music.ui.dialog.CloseFeatureDialogFragment.a
                public void a() {
                    com.fotoable.youtube.music.a.h(false);
                    com.fotoable.youtube.music.util.b.b("音乐锁屏-音乐锁屏开关-关闭");
                    LockerScreenActivity.this.finish();
                }
            });
        }
    }

    private void a(LocalMusicModel localMusicModel) {
        if (localMusicModel != null && this.f != null) {
            this.f.a(localMusicModel);
        }
    }

    private void a(RadioModel radioModel) {
        if (radioModel != null && this.f != null) {
            this.f.a(radioModel);
        }
    }

    private void a(PlayerInfo playerInfo) {
        if (playerInfo == null || playerInfo.isYoutubePlayer() || this.f == null) {
            return;
        }
        if (playerInfo.isLocalPlayer() || playerInfo.isRadioPlayer()) {
            this.f.a(playerInfo);
        }
    }

    private void v() {
        this.verticalViewPager.setOverScrollMode(2);
        ArrayList arrayList = new ArrayList();
        this.f = new MusicLockerView(this);
        arrayList.add(this.f);
        arrayList.add(new EmptyView(this));
        a aVar = new a(arrayList);
        this.verticalViewPager.setAdapter(aVar);
        this.verticalViewPager.setOnPageChangeListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private List<View> f2762b;

        public a(List<View> list) {
            this.f2762b = list;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.f2762b == null) {
                return 0;
            }
            return this.f2762b.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.f2762b.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.f2762b.get(i));
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            switch (i) {
                case 0:
                default:
                    return;
                case 1:
                    if (MusicApplication.c().f() != null) {
                        Intent intent = new Intent();
                        intent.setClassName(LockerScreenActivity.this.getPackageName(), MusicApplication.c().f().getCanonicalName());
                        h.a("MusicApplication++", "" + MusicApplication.c().f().getCanonicalName());
                        intent.addFlags(268435456);
                        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "music_locker");
                        try {
                            PendingIntent.getActivity(LockerScreenActivity.this, 809811, intent, 134217728).send();
                        } catch (PendingIntent.CanceledException e) {
                            ThrowableExtension.printStackTrace(e);
                        }
                    } else {
                        Intent intent2 = new Intent(LockerScreenActivity.this, MainActivity.class);
                        intent2.addFlags(268435456);
                        intent2.addFlags(32768);
                        intent2.putExtra(ShareConstants.FEED_SOURCE_PARAM, "music_locker");
                        LockerScreenActivity.this.startActivity(intent2);
                    }
                    LockerScreenActivity.this.verticalViewPager.postDelayed(new Runnable() { // from class: com.fotoable.youtube.music.locker.activity.LockerScreenActivity.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LockerScreenActivity.this.finish();
                        }
                    }, 500L);
                    return;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        f2756a = false;
        super.onStop();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        f2756a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f2756a = false;
    }
}
