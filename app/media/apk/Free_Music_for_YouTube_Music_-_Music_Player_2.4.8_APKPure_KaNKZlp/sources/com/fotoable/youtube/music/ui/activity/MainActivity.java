package com.fotoable.youtube.music.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.anjlab.android.iab.v3.c;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.a.a;
import com.fotoable.youtube.music.a.d;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.UpdateInfo;
import com.fotoable.youtube.music.bean.UserInfoModel;
import com.fotoable.youtube.music.bean.YouTubekeyBean;
import com.fotoable.youtube.music.newplayer.service.PlayerService;
import com.fotoable.youtube.music.quicktools.service.QuickToolsService;
import com.fotoable.youtube.music.service.NotificationService;
import com.fotoable.youtube.music.ui.adapter.MainAdapter;
import com.fotoable.youtube.music.ui.dialog.ChargingTipDialogFragment;
import com.fotoable.youtube.music.ui.dialog.SubscriptionDialog;
import com.fotoable.youtube.music.ui.dialog.UpdateAndRateDialog;
import com.fotoable.youtube.music.ui.dialog.b;
import com.fotoable.youtube.music.ui.fragment.HomeFragment;
import com.fotoable.youtube.music.ui.fragment.LocalMusicFragment;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.common.zzo;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;
import org.phprpc.util.PHPSerializer;
import rx.f;
/* loaded from: classes.dex */
public class MainActivity extends BaseActivity {

    /* renamed from: c  reason: collision with root package name */
    private static final String f3468c = MainActivity.class.getSimpleName();
    private static Boolean d = false;
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3469a;
    @BindView(R.id.remove_ad_view)
    View adView;
    @BindView(R.id.rb_community)
    RadioButton communityRb;
    private List<com.fotoable.youtube.music.base.i> e;
    private com.anjlab.android.iab.v3.c g;
    private boolean h;
    @BindView(R.id.rb_home)
    RadioButton homeRb;
    private AnimationDrawable i;
    @BindView(R.id.iv_music_recognition_lock)
    ImageView iv_music_recognition_lock;
    @BindView(R.id.iv_pur_success)
    ImageView iv_pur_success;
    @BindView(R.id.iv_vip_mark_icon)
    ImageView iv_vip_mark_icon;
    private ImageView j;
    private RelativeLayout k;
    @BindView(R.id.main_drawer)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.main_radio_group)
    RadioGroup mainRadioGroup;
    @BindView(R.id.rb_my_music)
    RadioButton myMusicRb;
    @BindView(R.id.ad_price_tx)
    LaToTextView priceTextView;
    @BindView(R.id.push_checkbox)
    CheckBox pushCheckbox;
    @BindView(R.id.sleep_timer_real_time)
    TextView sleep_timer_real_time;
    @BindView(R.id.slide_menu_view)
    View slideMenuView;
    @BindView(R.id.user_avatar)
    ImageView user_avatar;
    @BindView(R.id.user_nick)
    TextView user_nick;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private int f = -1;
    private int l = 1;
    private int m = 12;
    private Handler n = new Handler() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    try {
                        if (com.fotoable.youtube.music.a.b.a(MainActivity.this).e()) {
                            com.fotoable.youtube.music.a.b.a(MainActivity.this).d();
                            removeMessages(2);
                            removeMessages(3);
                        } else {
                            MainActivity.a(MainActivity.this);
                            if (MainActivity.this.l > MainActivity.this.m) {
                                removeMessages(1);
                                MainActivity.this.s();
                                com.fotoable.youtube.music.a.b.a(MainActivity.this).a(false);
                            } else {
                                sendEmptyMessageDelayed(1, 1000L);
                            }
                        }
                        return;
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                        return;
                    }
                case 2:
                    try {
                        MainActivity.e(MainActivity.this);
                        if (MainActivity.this.o < MainActivity.this.m) {
                            sendEmptyMessage(3);
                        } else {
                            removeMessages(2);
                            removeMessages(1);
                            MainActivity.this.s();
                            com.fotoable.youtube.music.a.b.a(MainActivity.this).a(false);
                        }
                        return;
                    } catch (Exception e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                case 3:
                    try {
                        if (MainActivity.this.o >= MainActivity.this.m) {
                            removeMessages(3);
                        }
                        sendEmptyMessageDelayed(2, 1000L);
                        return;
                    } catch (Exception e3) {
                        ThrowableExtension.printStackTrace(e3);
                        return;
                    }
                default:
                    return;
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    boolean f3470b = false;
    private int o = 1;
    private boolean p = true;
    private ViewPager.OnPageChangeListener q = new ViewPager.OnPageChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            switch (i) {
                case 0:
                    MainActivity.this.myMusicRb.setChecked(true);
                    com.fotoable.youtube.music.util.v.b((Context) MainActivity.this, "last_position", i);
                    com.fotoable.youtube.music.util.b.b("本地音乐-展示");
                    return;
                case 1:
                    MainActivity.this.homeRb.setChecked(true);
                    com.fotoable.youtube.music.util.v.b((Context) MainActivity.this, "last_position", i);
                    com.fotoable.youtube.music.util.b.b("在线音乐-展示");
                    return;
                case 2:
                    MainActivity.this.communityRb.setChecked(true);
                    com.fotoable.youtube.music.util.v.b((Context) MainActivity.this, "last_position", i);
                    com.fotoable.youtube.music.util.b.b("社区界面-展示");
                    return;
                default:
                    return;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private RadioGroup.OnCheckedChangeListener r = new RadioGroup.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.6
        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            switch (i) {
                case R.id.rb_my_music /* 2131821194 */:
                    MainActivity.this.viewPager.setCurrentItem(0, true);
                    return;
                case R.id.rb_home /* 2131821195 */:
                    MainActivity.this.viewPager.setCurrentItem(1, true);
                    return;
                case R.id.rb_community /* 2131821196 */:
                    MainActivity.this.viewPager.setCurrentItem(2, true);
                    return;
                default:
                    return;
            }
        }
    };
    private boolean s = false;
    private boolean t = false;
    private c.b u = new c.b() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.7
        @Override // com.anjlab.android.iab.v3.c.b
        public void a(String str, TransactionDetails transactionDetails) {
            MainActivity.this.s = false;
            try {
                com.fotoable.youtube.music.a.a(true);
                com.fotoable.youtube.music.util.b.b("支付成功");
                com.fotoable.youtube.music.util.b.b("订阅成功");
                try {
                    if (MainActivity.this.adView != null) {
                        MainActivity.this.iv_vip_mark_icon.setVisibility(0);
                        MainActivity.this.iv_music_recognition_lock.setVisibility(8);
                        MainActivity.this.priceTextView.setVisibility(8);
                        MainActivity.this.iv_pur_success.setVisibility(0);
                    }
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
                com.bumptech.glide.i.b(MusicApplication.c()).h();
                Toast.makeText(MainActivity.this, (int) R.string.msg_ad_removed, 0).show();
                MainActivity.this.K();
            } catch (Exception e2) {
                ThrowableExtension.printStackTrace(e2);
            }
        }

        @Override // com.anjlab.android.iab.v3.c.b
        public void a() {
            MainActivity.this.s = false;
            MainActivity.this.I();
            com.fotoable.youtube.music.util.h.a(MainActivity.f3468c, "onPurchaseHistoryRestored");
            MainActivity.this.K();
        }

        @Override // com.anjlab.android.iab.v3.c.b
        public void a(int i, Throwable th) {
            MainActivity.this.s = false;
            if (MainActivity.this.t) {
                MainActivity.this.t = false;
                switch (i) {
                    case 1:
                        Toast.makeText(MainActivity.this, (int) R.string.msg_cancel, 0).show();
                        return;
                    case 2:
                        Toast.makeText(MainActivity.this, (int) R.string.msg_network_error, 0).show();
                        return;
                    case 3:
                    case 101:
                        Toast.makeText(MainActivity.this, (int) R.string.msg_initialize_purchase_error, 0).show();
                        return;
                    case 4:
                        Toast.makeText(MainActivity.this, (int) R.string.msg_product_not_available, 0).show();
                        return;
                    case 7:
                        Toast.makeText(MainActivity.this, (int) R.string.msg_item_already_owned, 0).show();
                        return;
                    case 8:
                    case 111:
                        Toast.makeText(MainActivity.this, (int) R.string.msg_item_not_owned, 0).show();
                        return;
                    case 100:
                    case 112:
                        Toast.makeText(MainActivity.this, (int) R.string.msg_load_error, 0).show();
                        return;
                    default:
                        Toast.makeText(MainActivity.this, (int) R.string.msg_other_error, 0).show();
                        return;
                }
            }
            com.fotoable.youtube.music.util.h.a(MainActivity.f3468c, "onBillingError：" + i);
            if (th != null) {
                ThrowableExtension.printStackTrace(th);
            }
        }

        @Override // com.anjlab.android.iab.v3.c.b
        public void b() {
            MainActivity.this.s = false;
            MainActivity.this.h = true;
            MainActivity.this.H();
            com.fotoable.youtube.music.util.h.a(MainActivity.f3468c, "onBillingInitialized");
        }
    };

    static /* synthetic */ int a(MainActivity mainActivity) {
        int i = mainActivity.l;
        mainActivity.l = i + 1;
        return i;
    }

    static /* synthetic */ int e(MainActivity mainActivity) {
        int i = mainActivity.o;
        mainActivity.o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        try {
            if (!this.f3470b) {
                if (com.fotoable.youtube.music.util.v.a((Context) this, "app_update_" + com.fotoable.youtube.music.util.w.e(this), true)) {
                    E();
                } else {
                    A();
                }
                this.f3470b = true;
            }
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            this.i = (AnimationDrawable) this.j.getDrawable();
            this.i.stop();
            com.fotoable.youtube.music.newplayer.e.a().a(this, 2401);
            com.fotoable.youtube.music.util.h.a(f3468c, "关闭广告，恢复播放窗口位置");
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_main;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        b(intent);
        v();
        u();
        d();
        F();
        PlayerService.a(this, "action_prepare_player_html", new String[0]);
        if (com.fotoable.youtube.music.a.o() && super.m()) {
            QuickToolsService.a(this, "action_show_quick");
        }
        D();
        com.fotoable.youtube.music.util.b.b("Dev_version_" + com.fotoable.youtube.music.util.w.d(this));
        C();
        a(intent);
        this.k = (RelativeLayout) findViewById(R.id.rl_loading_ad);
        this.j = (ImageView) findViewById(R.id.animationIV);
        this.j.setImageResource(R.drawable.adloading);
        this.i = (AnimationDrawable) this.j.getDrawable();
        this.i.start();
        com.fotoable.youtube.music.a.b.a(this).b().a(new a.InterfaceC0055a() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.9
            @Override // com.fotoable.youtube.music.a.a.InterfaceC0055a
            public void a() {
                com.fotoable.youtube.music.util.h.a("TestLoading", "..............onclickAdmob");
                MainActivity.this.s();
            }
        }, 1);
        com.fotoable.youtube.music.a.b.a(this).a().a(new d.a() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.10
            @Override // com.fotoable.youtube.music.a.d.a
            public void a() {
                com.fotoable.youtube.music.util.h.a("TestLoading", "..............onclickFB");
                MainActivity.this.s();
            }
        }, 1);
        this.n.sendEmptyMessageDelayed(1, 3000L);
        this.n.sendEmptyMessageDelayed(2, 1000L);
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2404);
        try {
            if (com.fotoable.youtube.music.util.w.f(this)) {
                com.fotoable.youtube.music.a.b.a(this).a(true);
                MobileAds.initialize(getApplicationContext(), "ca-app-pub-6568668249868621~6806580196");
                com.fotoable.youtube.music.a.b.a(this).f();
            } else {
                this.n.removeMessages(2);
                this.n.removeMessages(1);
                s();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        if (TextUtils.isEmpty(com.fotoable.youtube.music.util.v.a(MusicApplication.c(), "country_code", (String) null))) {
            com.fotoable.youtube.music.util.v.b(MusicApplication.c(), "country_code", Locale.getDefault().getCountry());
            com.fotoable.youtube.music.util.v.b((Context) MusicApplication.c(), "country_code_is_local", true);
            com.fotoable.youtube.music.util.h.a(f3468c, "使用本地国际码初始化");
        }
        this.f3469a.f();
        this.f3469a.q();
        t();
        if (com.fotoable.youtube.music.a.h()) {
            this.iv_vip_mark_icon.setVisibility(0);
            this.iv_music_recognition_lock.setVisibility(8);
            this.priceTextView.setVisibility(8);
            this.iv_pur_success.setVisibility(0);
        } else {
            this.iv_vip_mark_icon.setVisibility(8);
            this.iv_music_recognition_lock.setVisibility(0);
            this.priceTextView.setVisibility(0);
            this.iv_pur_success.setVisibility(8);
        }
        K();
    }

    private void t() {
        try {
            Intent intent = new Intent(this, NotificationService.class);
            intent.setAction("action_open_app");
            startService(intent);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void c() {
        if (this.p) {
            this.p = false;
            com.fotoable.youtube.music.newplayer.e.a().a(this, 2404);
            com.fotoable.youtube.music.newplayer.e.a().b(false);
            return;
        }
        super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.fotoable.youtube.music.newplayer.e.a().i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!MusicApplication.c().g()) {
        }
        if (!MusicApplication.c().d()) {
            com.fotoable.youtube.music.newplayer.e.a().d(1002);
            if (MusicApplication.c().f() != null && TextUtils.equals(MusicApplication.c().f().getSimpleName(), MainActivity.class.getSimpleName())) {
                com.fotoable.youtube.music.newplayer.e.a().a(this, 2402);
            }
        }
        com.fotoable.youtube.music.util.h.a(f3468c, "Main onStop");
    }

    private void u() {
        this.mainRadioGroup.setOnCheckedChangeListener(this.r);
        this.viewPager.addOnPageChangeListener(this.q);
        this.mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.11

            /* renamed from: a  reason: collision with root package name */
            boolean f3473a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f3474b = false;

            @Override // android.support.v4.widget.DrawerLayout.DrawerListener
            public void onDrawerSlide(View view, float f) {
                if (!this.f3473a && f > 0.0f && !this.f3474b) {
                    this.f3474b = true;
                    com.fotoable.youtube.music.util.h.a(MainActivity.f3468c, "隐藏播放器");
                    com.fotoable.youtube.music.newplayer.e.a().a(0);
                }
                if (f == 0.0f) {
                    this.f3474b = false;
                    com.fotoable.youtube.music.newplayer.e.a().a(1);
                }
            }

            @Override // android.support.v4.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(View view) {
                com.fotoable.youtube.music.util.h.a(MainActivity.f3468c, "打开");
                this.f3473a = true;
                this.f3474b = true;
            }

            @Override // android.support.v4.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(View view) {
                com.fotoable.youtube.music.util.h.a(MainActivity.f3468c, "关闭");
                this.f3473a = false;
                this.f3474b = false;
                MainActivity.this.w();
            }

            @Override // android.support.v4.widget.DrawerLayout.DrawerListener
            public void onDrawerStateChanged(int i) {
            }
        });
    }

    private void v() {
        this.e = new ArrayList();
        this.e.add(new LocalMusicFragment());
        this.e.add(new HomeFragment());
        this.viewPager.setAdapter(new MainAdapter(getSupportFragmentManager(), this.e));
        this.viewPager.setOffscreenPageLimit(2);
        int a2 = com.fotoable.youtube.music.util.v.a((Context) this, "last_position", 1);
        if (a2 >= this.e.size()) {
            a2 = this.e.size() - 1;
        }
        this.viewPager.setCurrentItem(a2);
        if (a2 == 0) {
            this.myMusicRb.setChecked(true);
        } else if (a2 == 1) {
            this.homeRb.setChecked(true);
        } else {
            this.communityRb.setChecked(true);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        super.i().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.g == null || !this.g.a(i, i2, intent)) {
        }
        super.onActivityResult(i, i2, intent);
    }

    @OnClick({R.id.main_menu_img, R.id.main_search_img, R.id.bottom_player_panel, R.id.play_state, R.id.music_recognition_view, R.id.push_switch_view, R.id.rate_us_view, R.id.about_us_view, R.id.share_app_view, R.id.set_view, R.id.sleep_timer, R.id.remove_ad_view, R.id.play_list, R.id.user_panel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_menu_img /* 2131821192 */:
                try {
                    if (this.mDrawerLayout.isDrawerOpen(this.slideMenuView)) {
                        this.mDrawerLayout.closeDrawer(this.slideMenuView);
                    } else {
                        this.mDrawerLayout.openDrawer(this.slideMenuView);
                    }
                    return;
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                    return;
                }
            case R.id.main_search_img /* 2131821197 */:
                if (this.viewPager.getCurrentItem() == 0) {
                    startActivity(new Intent(this, LocalSearchMusicActivity.class));
                    com.fotoable.youtube.music.util.b.b("搜索", "类型", "本地");
                    return;
                }
                startActivity(new Intent(this, SearchActivity.class));
                com.fotoable.youtube.music.util.b.b("搜索", "类型", "在线");
                return;
            case R.id.user_panel /* 2131821218 */:
            case R.id.music_recognition_view /* 2131821221 */:
            case R.id.sleep_timer /* 2131821223 */:
            case R.id.remove_ad_view /* 2131821226 */:
            case R.id.rate_us_view /* 2131821229 */:
            case R.id.share_app_view /* 2131821230 */:
            case R.id.about_us_view /* 2131821231 */:
            case R.id.set_view /* 2131821232 */:
                try {
                    this.mDrawerLayout.closeDrawer(this.slideMenuView);
                    this.f = view.getId();
                    return;
                } catch (Exception e2) {
                    ThrowableExtension.printStackTrace(e2);
                    return;
                }
            case R.id.push_switch_view /* 2131821224 */:
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.f != -1) {
            switch (this.f) {
                case R.id.music_recognition_view /* 2131821221 */:
                    if (com.fotoable.youtube.music.a.h() || com.fotoable.youtube.music.util.a.a()) {
                        startActivity(new Intent(this, MusicRecognitionActivity.class));
                        com.fotoable.youtube.music.util.b.b("侧边栏-音乐识别");
                        break;
                    } else {
                        x();
                        break;
                    }
                    break;
                case R.id.sleep_timer /* 2131821223 */:
                    startActivity(new Intent(this, TimerActivity.class));
                    break;
                case R.id.remove_ad_view /* 2131821226 */:
                    x();
                    break;
                case R.id.rate_us_view /* 2131821229 */:
                    com.fotoable.youtube.music.util.w.a(getPackageName(), this);
                    com.fotoable.youtube.music.util.b.b("侧边栏-给个好评");
                    break;
                case R.id.share_app_view /* 2131821230 */:
                    com.fotoable.youtube.music.util.b.b("Settings-ShareApp");
                    com.fotoable.youtube.music.helper.f.a(this, getString(R.string.share_app_content), true);
                    com.fotoable.youtube.music.util.b.b("侧边栏-分享APP");
                    break;
                case R.id.about_us_view /* 2131821231 */:
                    startActivity(new Intent(this, AboutActivity.class));
                    com.fotoable.youtube.music.util.b.b("侧边栏-关于我们");
                    break;
                case R.id.set_view /* 2131821232 */:
                    startActivity(new Intent(this, SettingsActivity.class));
                    com.fotoable.youtube.music.util.b.b("侧边栏-设置");
                    break;
            }
            this.f = -1;
        }
    }

    private void x() {
        SubscriptionDialog.a(getSupportFragmentManager());
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(com.fotoable.youtube.music.e.a aVar) {
        switch (aVar.f2726a) {
            case PointerIconCompat.TYPE_TEXT /* 1008 */:
                this.viewPager.setCurrentItem(1, false);
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
            case 1038:
            case 1044:
            default:
                return;
            case 1036:
                this.mainRadioGroup.check(R.id.rb_home);
                return;
            case 2014:
                J();
                return;
            case 2020:
                if (MusicApplication.c().h() != null) {
                    com.fotoable.youtube.music.util.h.a(f3468c, "avatar:" + MusicApplication.c().h().getAvatar());
                    com.fotoable.youtube.music.util.h.a(f3468c, "name:" + MusicApplication.c().h().getName());
                    com.bumptech.glide.i.a((FragmentActivity) this).a(MusicApplication.c().h().getAvatar()).d((int) R.drawable.user_avatar_def).c((int) R.drawable.user_avatar_def).b(com.bumptech.glide.load.b.b.ALL).i().a(this.user_avatar);
                    this.user_nick.setText(MusicApplication.c().h().getName() + "");
                    return;
                }
                return;
            case 2022:
                J();
                return;
            case 8004:
                if (aVar.d > 0) {
                    StringBuilder sb = new StringBuilder();
                    int i = aVar.d / 216000;
                    int i2 = (aVar.d % 216000) / 60;
                    int i3 = (aVar.d % 216000) % 60;
                    if (i > 0) {
                        sb.append(i + ":");
                    }
                    if (i2 > 0) {
                        if (i2 < 10) {
                            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        sb.append(i2 + ":");
                    } else {
                        sb.append("00:");
                    }
                    if (i3 > 0) {
                        if (i3 < 10) {
                            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        sb.append(i3 + "");
                    } else {
                        sb.append("00");
                    }
                    this.sleep_timer_real_time.setText(sb.toString() + "");
                    this.sleep_timer_real_time.setVisibility(0);
                    return;
                }
                this.sleep_timer_real_time.setVisibility(8);
                return;
        }
    }

    private void a(Intent intent) {
        if (intent != null && intent.hasExtra(ShareConstants.FEED_SOURCE_PARAM)) {
            String stringExtra = intent.getStringExtra(ShareConstants.FEED_SOURCE_PARAM);
            if (TextUtils.equals(stringExtra, "splash")) {
                com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "闪屏界面");
                return;
            } else if (TextUtils.equals(stringExtra, "bottom_tool")) {
                com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "底部工具栏");
                return;
            } else if (TextUtils.equals(stringExtra, "widget")) {
                com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "Widget");
                return;
            } else if (TextUtils.equals(stringExtra, "notification")) {
                com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "播放通知栏");
                return;
            } else if (TextUtils.equals(stringExtra, "small_to_vertical")) {
                com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "小播放窗口切换竖屏");
                return;
            } else if (TextUtils.equals(stringExtra, "local_push_message")) {
                com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "本地推送");
                return;
            } else if (TextUtils.equals(stringExtra, "ad_back_message")) {
                com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "广告跳走返回");
                return;
            } else if (TextUtils.equals(stringExtra, "music_update_widget")) {
                com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "音乐更新通知栏");
                y();
                return;
            } else if (TextUtils.equals(stringExtra, "float_player")) {
                com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "悬浮窗口");
                return;
            } else if (TextUtils.equals(stringExtra, "music_locker")) {
                com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "音乐锁屏");
                return;
            } else {
                com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "其它," + stringExtra);
                return;
            }
        }
        com.fotoable.youtube.music.util.b.b("进入主App入口", "入口名称", "其它,intent is null");
    }

    private void y() {
        com.fotoable.youtube.music.util.v.b((Context) this, "last_position", 0);
        com.fotoable.youtube.music.util.v.b((Context) MusicApplication.c(), com.fotoable.youtube.music.b.g, 0);
        com.fotoable.youtube.music.newplayer.b.a();
        if (this.viewPager != null) {
            this.viewPager.setCurrentItem(com.fotoable.youtube.music.util.v.a((Context) this, "last_position", 0));
        }
    }

    private void b(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("toPage");
            String stringExtra2 = intent.getStringExtra(ShareConstants.FEED_SOURCE_PARAM);
            if (TextUtils.equals(stringExtra, "search")) {
                startActivity(new Intent(this, SearchActivity.class));
                com.fotoable.youtube.music.util.h.a(f3468c, "onCreated跳转");
            }
            if (TextUtils.equals(stringExtra2, "music_update_widget")) {
                y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        com.fotoable.youtube.music.util.h.a(f3468c, "onNewIntent跳转");
        b(intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        com.fotoable.youtube.music.util.l.a().a(this, i, strArr, iArr);
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (com.fotoable.youtube.music.util.w.a(this, zzo.GOOGLE_PLAY_STORE_PACKAGE)) {
            com.fotoable.youtube.music.util.b.b("升级引导-展示次数");
            UpdateAndRateDialog.a(getSupportFragmentManager(), R.string.update_now, R.string.later, R.mipmap.icon_app_update, new UpdateAndRateDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.12
                @Override // com.fotoable.youtube.music.ui.dialog.UpdateAndRateDialog.a
                public void a() {
                    com.fotoable.youtube.music.util.b.b("升级引导-点击升级次数");
                    com.fotoable.youtube.music.util.w.a(MainActivity.this.getPackageName(), MainActivity.this);
                }

                @Override // com.fotoable.youtube.music.ui.dialog.UpdateAndRateDialog.a
                public void b() {
                    com.fotoable.youtube.music.util.v.b((Context) MainActivity.this, "app_update_" + com.fotoable.youtube.music.util.w.e(MainActivity.this), false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        String str = "USE_APP_COUNT" + com.fotoable.youtube.music.util.w.e(this);
        int a2 = com.fotoable.youtube.music.util.v.a((Context) this, str, 0);
        int a3 = com.fotoable.youtube.music.util.v.a((Context) this, "USE_APP_COUNT", 1);
        if (a3 == 1) {
            x();
            com.fotoable.youtube.music.util.v.b((Context) this, "USE_APP_COUNT", a3 + 1);
        } else if (a3 == 2) {
            com.fotoable.youtube.music.util.v.b((Context) this, "USE_APP_COUNT", a3 + 1);
            if (a2 == 0 && com.fotoable.youtube.music.util.w.a(this, zzo.GOOGLE_PLAY_STORE_PACKAGE)) {
                com.fotoable.youtube.music.util.v.a((Context) this, str, a2 + 1);
                UpdateAndRateDialog.a(getSupportFragmentManager(), R.string.give_us_five_stars, R.string.later, R.mipmap.icon_app_rate, new UpdateAndRateDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.13
                    @Override // com.fotoable.youtube.music.ui.dialog.UpdateAndRateDialog.a
                    public void a() {
                        com.fotoable.youtube.music.util.w.a(MainActivity.this.getPackageName(), MainActivity.this);
                        com.fotoable.youtube.music.util.b.b("Dev_五星好评-点击确定");
                    }

                    @Override // com.fotoable.youtube.music.ui.dialog.UpdateAndRateDialog.a
                    public void b() {
                        com.fotoable.youtube.music.util.b.b("Dev_五星好评-点击取消");
                    }
                });
                com.fotoable.youtube.music.util.b.b("Dev_五星好评展示次数");
            }
        } else if (a3 == 3) {
            if (!com.fotoable.youtube.music.a.i()) {
                ChargingTipDialogFragment.a(getSupportFragmentManager(), new b.a() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.14
                    @Override // com.fotoable.youtube.music.ui.dialog.b.a
                    public void b() {
                        com.fotoable.youtube.music.a.b(true);
                        com.fotoable.youtube.music.newplayer.e.a().i(true);
                    }

                    @Override // com.fotoable.youtube.music.ui.dialog.b.a
                    public void a() {
                    }
                }, (ChargingTipDialogFragment.a) null);
            }
            com.fotoable.youtube.music.util.v.b((Context) this, "USE_APP_COUNT", a3 + 1);
        }
    }

    private void B() {
        if (!d.booleanValue()) {
            d = true;
            Toast.makeText(this, (int) R.string.press_again_exit_application, 0).show();
            new Timer().schedule(new TimerTask() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Boolean unused = MainActivity.d = false;
                }
            }, 2000L);
            return;
        }
        finish();
        com.fotoable.youtube.music.newplayer.e.a().d(10012);
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2405);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            B();
            return true;
        } else if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        } else {
            return true;
        }
    }

    private void C() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < strArr.length; i++) {
                if (i == strArr.length - 1) {
                    stringBuffer.append(strArr[i] + "");
                } else {
                    stringBuffer.append(strArr[i] + ",");
                }
            }
            com.fotoable.youtube.music.util.b.b("Dev_Cpu类型", "类型", "" + stringBuffer.toString());
            return;
        }
        com.fotoable.youtube.music.util.b.b("Dev_Cpu类型", "类型", Build.CPU_ABI + "" + (TextUtils.isEmpty(Build.CPU_ABI2) ? "" : "," + Build.CPU_ABI2));
    }

    private void D() {
        a(this.f3469a.c().a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(new rx.l<YouTubekeyBean>() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.3
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(YouTubekeyBean youTubekeyBean) {
                try {
                    String a2 = com.fotoable.youtube.music.util.decode.b.a(youTubekeyBean.getServer());
                    com.fotoable.youtube.music.util.v.b(MainActivity.this, "YOU_TUBE_KEY", (String) new PHPSerializer().unserialize(a2.getBytes(), String.class));
                    com.fotoable.youtube.music.util.v.b((Context) MainActivity.this, "IS_OPEN_RECOGNIZE", youTubekeyBean.getIsOpen());
                    com.fotoable.youtube.music.util.v.b(MusicApplication.c(), "music_share_url", youTubekeyBean.getShareUrl() + "");
                    com.fotoable.youtube.music.util.v.b(MainActivity.this, com.fotoable.youtube.music.b.f2235c, youTubekeyBean.isShowPlaylist());
                    com.fotoable.youtube.music.util.v.b(MainActivity.this, com.fotoable.youtube.music.b.e, youTubekeyBean.isShowChoice());
                    com.fotoable.youtube.music.util.v.b(MainActivity.this, com.fotoable.youtube.music.b.d, youTubekeyBean.isShowFeatured());
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1033, youTubekeyBean.getIsOpen()));
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
        }));
    }

    private void E() {
        a(this.f3469a.g().a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<MyHttpResponse<UpdateInfo>>() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.4
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                MainActivity.this.A();
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<UpdateInfo> myHttpResponse) {
                if (!myHttpResponse.isSuccess() || myHttpResponse.getData() == null) {
                    MainActivity.this.A();
                    return;
                }
                com.fotoable.youtube.music.util.h.a(MainActivity.f3468c, "线上版本号:" + myHttpResponse.getData().getVersionCode() + "\n本地版本号:" + Integer.valueOf(com.fotoable.youtube.music.util.w.e(MainActivity.this)));
                if (myHttpResponse.getData().getVersionCode() <= Integer.valueOf(com.fotoable.youtube.music.util.w.e(MainActivity.this)).intValue() || !com.fotoable.youtube.music.util.w.a(MainActivity.this, zzo.GOOGLE_PLAY_STORE_PACKAGE)) {
                    MainActivity.this.A();
                } else {
                    MainActivity.this.z();
                    com.fotoable.youtube.music.util.h.a(MainActivity.f3468c, "显示升级引导.......");
                }
                com.fotoable.youtube.music.a.d(myHttpResponse.getData().isShowVideo());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.fotoable.youtube.music.util.h.a(f3468c, "onDestroy");
        try {
            com.bumptech.glide.i.b(MusicApplication.c()).h();
            System.gc();
            if (this.e != null) {
                this.e.clear();
            }
            try {
                if (this.g != null) {
                    this.g.c();
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
            com.fotoable.youtube.music.a.a.f2222b = false;
            com.fotoable.youtube.music.a.d.f2229b = false;
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
        }
    }

    private void F() {
        try {
            if (!this.s && com.anjlab.android.iab.v3.c.a(this)) {
                this.s = true;
                this.g = new com.anjlab.android.iab.v3.c(this, com.fotoable.youtube.music.b.f, this.u);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private boolean G() {
        if (com.anjlab.android.iab.v3.c.a(this)) {
            if (this.g != null && this.g.d()) {
                this.h = true;
            } else {
                this.h = false;
                Toast.makeText(this, (int) R.string.msg_billing_service_not_initialized, 0).show();
                F();
            }
            return this.h;
        }
        Toast.makeText(this, (int) R.string.msg_billing_service_unavailable, 0).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (G()) {
            try {
                if (this.g != null) {
                    this.g.e();
                    com.fotoable.youtube.music.util.h.a(f3468c, "第一次获取用户订单信息.");
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        boolean z = false;
        try {
            if (this.g != null) {
                z = this.g.a("remove_ads");
                if (!z) {
                    z = this.g.b("vip_subscription");
                }
                if (!z) {
                    z = this.g.b("vip_membership");
                    com.fotoable.youtube.music.util.h.a(f3468c, "内购订阅去广告");
                } else {
                    com.fotoable.youtube.music.util.h.a(f3468c, "内购终身去广告");
                }
            }
            com.fotoable.youtube.music.a.a(z);
            com.fotoable.youtube.music.util.h.a(f3468c, "商品购买状态:" + z);
            if (this.iv_vip_mark_icon != null) {
                if (z) {
                    this.iv_vip_mark_icon.setVisibility(0);
                    this.iv_music_recognition_lock.setVisibility(8);
                    this.priceTextView.setVisibility(8);
                    this.iv_pur_success.setVisibility(0);
                    return;
                }
                this.iv_vip_mark_icon.setVisibility(8);
                this.iv_music_recognition_lock.setVisibility(0);
                this.priceTextView.setVisibility(0);
                this.iv_pur_success.setVisibility(8);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private void J() {
        try {
            com.fotoable.youtube.music.util.b.b("支付点击");
            this.t = true;
            if (G()) {
                this.g.e();
                boolean a2 = this.g.a("remove_ads");
                if (!a2) {
                    a2 = this.g.b("vip_subscription");
                }
                if (!a2) {
                    a2 = this.g.b("vip_membership");
                }
                if (!a2) {
                    this.g.a(this, "vip_membership");
                    return;
                }
                Toast.makeText(this, (int) R.string.msg_ad_removed, 0).show();
                I();
                return;
            }
            com.fotoable.youtube.music.util.h.a(f3468c, "支付失败-->未安装GooglePlay");
            com.fotoable.youtube.music.util.b.b("支付失败-->未安装GooglePlay");
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        a(this.f3469a.r().a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(new rx.l<UserInfoModel>() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity.8
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                if (th != null) {
                    ThrowableExtension.printStackTrace(th);
                }
                com.fotoable.youtube.music.util.h.a(MainActivity.f3468c, "同步会员状态失败");
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(UserInfoModel userInfoModel) {
                com.fotoable.youtube.music.util.h.a(MainActivity.f3468c, "同步会员状态成功");
            }
        }));
    }
}
