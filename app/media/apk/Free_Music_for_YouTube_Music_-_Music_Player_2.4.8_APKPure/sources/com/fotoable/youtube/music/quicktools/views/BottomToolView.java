package com.fotoable.youtube.music.quicktools.views;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.i;
import com.bumptech.glide.load.resource.bitmap.e;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.service.PlayerService;
import com.fotoable.youtube.music.quicktools.settings.PhoneStateHelper;
import com.fotoable.youtube.music.ui.activity.MainActivity;
import com.fotoable.youtube.music.ui.view.GlideRoundTransform;
import com.fotoable.youtube.music.ui.view.MarqueeTextView;
import com.fotoable.youtube.music.ui.view.QuickToolProgressView;
import com.fotoable.youtube.music.util.h;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class BottomToolView extends FrameLayout implements View.OnClickListener, com.fotoable.youtube.music.quicktools.settings.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3135a = BottomToolView.class.getSimpleName();
    private static com.fotoable.youtube.music.quicktools.settings.a y;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private FrameLayout E;
    private LinearLayout F;
    private RelativeLayout G;
    private Handler H;
    private QuickToolProgressView I;
    private boolean J;
    private boolean K;
    private int L;
    private b M;
    private boolean N;
    private PlayerInfo O;
    private a P;

    /* renamed from: b  reason: collision with root package name */
    private ImageButton f3136b;

    /* renamed from: c  reason: collision with root package name */
    private ImageButton f3137c;
    private ImageButton d;
    private ImageButton e;
    private ImageButton f;
    private RelativeLayout g;
    private RelativeLayout h;
    private SeekBar i;
    private SeekBar j;
    private ImageView k;
    private MarqueeTextView l;
    private TextView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private TextView q;
    private View r;
    private View s;
    private View t;
    private View u;
    private ImageView v;
    private TextView w;
    private PhoneStateHelper x;
    private boolean z;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(MotionEvent motionEvent, boolean z);
    }

    public BottomToolView(Context context) {
        this(context, null);
    }

    public BottomToolView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomToolView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.H = new Handler();
        this.J = false;
        this.K = false;
        this.L = 0;
        this.N = false;
        k();
    }

    private boolean j() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.System.canWrite(getContext());
        }
        return true;
    }

    private void k() {
        try {
            ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.l_cover_toolbox, (ViewGroup) this, true);
            this.E = (FrameLayout) findViewById(R.id.root_view);
            this.F = (LinearLayout) findViewById(R.id.main_container);
            this.I = (QuickToolProgressView) findViewById(R.id.quick_progress);
            this.G = (RelativeLayout) findViewById(R.id.light_screen_panel);
            ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.F.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 23) {
                if (j()) {
                    layoutParams.height = (int) (getContext().getResources().getDisplayMetrics().density * 329.0f);
                    layoutParams2.height = (int) (getContext().getResources().getDisplayMetrics().density * 320.0f);
                } else {
                    layoutParams.height = (int) (279.0f * getContext().getResources().getDisplayMetrics().density);
                    layoutParams2.height = (int) (270.0f * getContext().getResources().getDisplayMetrics().density);
                    this.G.setVisibility(8);
                }
            } else {
                layoutParams.height = (int) (getContext().getResources().getDisplayMetrics().density * 329.0f);
                layoutParams2.height = (int) (getContext().getResources().getDisplayMetrics().density * 320.0f);
            }
            this.E.setLayoutParams(layoutParams);
            this.F.setLayoutParams(layoutParams2);
            this.f3136b = (ImageButton) findViewById(R.id.wifi);
            this.s = findViewById(R.id.btn_flashlight);
            this.p = (ImageView) findViewById(R.id.icon_flashlight);
            this.q = (TextView) findViewById(R.id.text_flashlight);
            this.g = (RelativeLayout) findViewById(R.id.view_sound_min);
            this.h = (RelativeLayout) findViewById(R.id.view_sound_max);
            this.i = (SeekBar) findViewById(R.id.mySoundSeekBar);
            this.j = (SeekBar) findViewById(R.id.mySeekBar);
            this.f3137c = (ImageButton) findViewById(R.id.dataFlow);
            this.d = (ImageButton) findViewById(R.id.phonesound);
            this.r = findViewById(R.id.btn_calculator);
            this.e = (ImageButton) findViewById(R.id.bluetooth);
            this.f = (ImageButton) findViewById(R.id.location);
            this.t = findViewById(R.id.btn_camera);
            this.u = findViewById(R.id.weather_container);
            this.v = (ImageView) findViewById(R.id.ic_weather);
            this.w = (TextView) findViewById(R.id.tv_weather_desc);
            this.k = (ImageView) findViewById(R.id.quick_music_cover);
            this.l = (MarqueeTextView) findViewById(R.id.quick_music_name);
            this.m = (TextView) findViewById(R.id.quick_time);
            this.n = (ImageView) findViewById(R.id.quick_play_state);
            this.o = (ImageView) findViewById(R.id.quick_search);
            this.k.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.f3136b.setOnClickListener(this);
            this.f3137c.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.u.setOnClickListener(this);
            if (Build.VERSION.SDK_INT >= 23) {
                this.t.setVisibility(8);
                this.s.setVisibility(0);
                this.s.setOnClickListener(this);
            } else {
                this.s.setVisibility(8);
                this.t.setVisibility(0);
                this.t.setOnClickListener(this);
            }
            this.x = new PhoneStateHelper(this);
            this.x.a(getContext());
            y = new com.fotoable.youtube.music.quicktools.settings.a(this.x);
            y.a(getContext());
            l();
            m();
            h();
            this.D = true;
        } catch (Exception e) {
            this.D = false;
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void h() {
        if (this.x != null && y != null) {
            try {
                a(y.c(getContext()));
                b(y.g(getContext()));
                a(y.i(getContext()));
                c(y.c());
                d(y.e(getContext()));
                e(y.l(getContext()));
                b(y.r(getContext()));
                c(y.n(getContext()));
                if (this.N) {
                    a(this.O, false);
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public void a(boolean z) {
        try {
            this.f3136b.setImageDrawable(getResources().getDrawable(z ? R.drawable.btn_setup_wifi : R.drawable.btn_setup_wifioff));
            if (this.A) {
                com.fotoable.youtube.music.util.b.b("底部工具栏-Wifi" + (z ? "打开" : "关闭"));
                this.A = false;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void b(boolean z) {
        try {
            this.f3137c.setImageDrawable(getResources().getDrawable(z ? R.drawable.btn_setup_data : R.drawable.btn_setup_dataoff));
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void a(int i) {
        try {
            switch (i) {
                case 0:
                    this.d.setImageDrawable(getResources().getDrawable(R.drawable.btn_setup_phonemute));
                    break;
                case 1:
                    this.d.setImageDrawable(getResources().getDrawable(R.drawable.btn_setup_phonevibrate));
                    break;
                case 2:
                    this.d.setImageDrawable(getResources().getDrawable(R.drawable.btn_setup_phonesound));
                    break;
                default:
                    return;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void c(boolean z) {
        try {
            this.e.setImageDrawable(getResources().getDrawable(z ? R.drawable.btn_setup_blue : R.drawable.btn_setup_blueoff));
            if (this.A) {
                com.fotoable.youtube.music.util.b.b("底部工具栏-蓝牙" + (z ? "打开" : "关闭"));
                this.A = false;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void d(boolean z) {
        try {
            this.f.setImageDrawable(getResources().getDrawable(z ? R.drawable.btn_setup_location : R.drawable.btn_setup_locationoff));
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void e(boolean z) {
        try {
            this.p.setImageDrawable(getResources().getDrawable(z ? R.drawable.btn_setup_flashon : R.drawable.btn_setup_flashoff));
            this.q.setTextColor(z ? -1 : ViewCompat.MEASURED_STATE_MASK);
            if (this.A) {
                com.fotoable.youtube.music.util.b.b("底部工具栏-手电筒" + (z ? "打开" : "关闭"));
                this.A = false;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void b(int i) {
        this.i.setProgress(i);
    }

    public void c(int i) {
        this.j.setProgress(i);
    }

    @Override // com.fotoable.youtube.music.quicktools.settings.b
    public void a(String str) {
        Toast.makeText(getContext(), str, 0).show();
    }

    @Override // com.fotoable.youtube.music.quicktools.settings.b
    public void a() {
        try {
            this.B = y.c(getContext());
            a(this.B);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.quicktools.settings.b
    public void b() {
        try {
            d(y.e(getContext()));
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.quicktools.settings.b
    public void c() {
        try {
            b(y.g(getContext()));
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.quicktools.settings.b
    public void d() {
        try {
            this.C = y.c();
            c(this.C);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.quicktools.settings.b
    public void e() {
        try {
            a(y.i(getContext()));
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.quicktools.settings.b
    public void f() {
        try {
            if (!this.K) {
                b(y.r(getContext()));
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.quicktools.settings.b
    public void g() {
        try {
            if (!this.J) {
                c(y.n(getContext()));
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private void l() {
        try {
            this.i.setMax(y.s(getContext()));
            this.i.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.fotoable.youtube.music.quicktools.views.BottomToolView.1
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    try {
                        if (BottomToolView.this.x != null) {
                            BottomToolView.y.c(BottomToolView.this.getContext(), i);
                        }
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                    BottomToolView.this.z = true;
                    BottomToolView.this.K = true;
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                    BottomToolView.this.z = false;
                    BottomToolView.this.K = false;
                    com.fotoable.youtube.music.util.b.b("底部工具栏-声音调整次数");
                }
            });
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.quicktools.views.BottomToolView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (BottomToolView.this.x != null) {
                            BottomToolView.y.t(BottomToolView.this.getContext());
                        }
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                }
            });
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.quicktools.views.BottomToolView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (BottomToolView.this.x != null) {
                            BottomToolView.y.u(BottomToolView.this.getContext());
                        }
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                }
            });
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private void m() {
        try {
            this.j.setMax(y.d());
            this.j.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.fotoable.youtube.music.quicktools.views.BottomToolView.4
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    try {
                        if (BottomToolView.this.x != null) {
                            BottomToolView.y.a(BottomToolView.this.getContext(), i);
                        }
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                    BottomToolView.this.z = true;
                    if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(BottomToolView.this.getContext())) {
                        BottomToolView.this.J = true;
                        try {
                            if (BottomToolView.this.x != null) {
                                BottomToolView.this.L = BottomToolView.y.o(BottomToolView.this.getContext());
                                if (BottomToolView.y.p(BottomToolView.this.getContext())) {
                                    BottomToolView.y.q(BottomToolView.this.getContext());
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            ThrowableExtension.printStackTrace(e);
                            return;
                        }
                    }
                    Toast.makeText(BottomToolView.this.getContext(), (int) R.string.msg_not_granted_write_settings, 0).show();
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                    BottomToolView.this.z = false;
                    BottomToolView.this.J = false;
                    try {
                        if (BottomToolView.this.x != null) {
                            BottomToolView.y.b(BottomToolView.this.getContext(), BottomToolView.this.L);
                        }
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                    com.fotoable.youtube.music.util.b.b("底部工具栏-屏幕亮度调整次数");
                }
            });
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.wifi /* 2131821243 */:
                    if (this.x != null) {
                        this.B = y.c(getContext());
                    }
                    if (!this.B && this.P != null) {
                        this.P.a();
                    }
                    if (this.x != null) {
                        y.b(getContext());
                    }
                    this.A = true;
                    return;
                case R.id.dataFlow /* 2131821244 */:
                    if (this.P != null) {
                        this.P.a();
                    }
                    if (this.x != null) {
                        y.f(getContext());
                    }
                    com.fotoable.youtube.music.util.b.b("底部工具栏-移动数据调整");
                    return;
                case R.id.phonesound /* 2131821245 */:
                    if (this.x != null) {
                        y.h(getContext());
                    }
                    com.fotoable.youtube.music.util.b.b("底部工具栏-铃声模式调整");
                    return;
                case R.id.bluetooth /* 2131821246 */:
                    if (this.x != null) {
                        this.C = y.c();
                    }
                    if (!this.C && this.P != null) {
                        this.P.a();
                    }
                    if (this.x != null) {
                        y.b();
                    }
                    this.A = true;
                    return;
                case R.id.location /* 2131821247 */:
                    if (this.P != null) {
                        this.P.a();
                    }
                    if (this.x != null) {
                        y.d(getContext());
                    }
                    com.fotoable.youtube.music.util.b.b("底部工具栏-GPS设置");
                    return;
                case R.id.quick_music_cover /* 2131821260 */:
                    Intent intent = new Intent(getContext(), PlayerService.class);
                    intent.setAction("action_change_player_size");
                    intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "bottom_tool");
                    getContext().startService(intent);
                    if (this.P != null) {
                        this.P.a();
                    }
                    com.fotoable.youtube.music.util.b.b("底部工具栏-点击音乐封面次数");
                    return;
                case R.id.quick_play_state /* 2131821264 */:
                    Intent intent2 = new Intent(getContext(), PlayerService.class);
                    intent2.setAction("action_change_play_state");
                    intent2.putExtra(ShareConstants.FEED_SOURCE_PARAM, "bottom_tool");
                    if (this.O != null && this.O.isPlaying()) {
                        intent2.putExtra("isPlaying", false);
                    } else {
                        intent2.putExtra("isPlaying", true);
                    }
                    getContext().startService(intent2);
                    com.fotoable.youtube.music.util.b.b("底部工具栏-点击播放按钮次数");
                    return;
                case R.id.quick_search /* 2131821265 */:
                    Intent intent3 = new Intent(getContext(), MainActivity.class);
                    intent3.addFlags(268435456);
                    intent3.putExtra("toPage", "search");
                    intent3.putExtra(ShareConstants.FEED_SOURCE_PARAM, "bottom_tool");
                    getContext().startActivity(intent3);
                    if (this.P != null) {
                        this.P.a();
                    }
                    com.fotoable.youtube.music.util.b.b("底部工具栏-点击搜索按钮次数");
                    return;
                case R.id.weather_container /* 2131821266 */:
                    if (this.P != null) {
                        this.P.a();
                    }
                    n();
                    return;
                case R.id.btn_flashlight /* 2131821270 */:
                    if (Build.VERSION.SDK_INT >= 23) {
                        this.A = true;
                        if (this.x != null) {
                            y.j(getContext());
                            e(y.l(getContext()));
                            return;
                        }
                        return;
                    }
                    return;
                case R.id.btn_camera /* 2131821273 */:
                    if (this.P != null) {
                        this.P.a();
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        return;
                    }
                    return;
                case R.id.btn_calculator /* 2131821274 */:
                    if (this.P != null) {
                        this.P.a();
                    }
                    if (this.x != null) {
                        y.m(getContext());
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private void n() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.e(f3135a, "===========onAttachedToWindow===========");
        try {
            if (!this.D) {
                k();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Log.e(f3135a, "===========onDetachedFromWindow===========");
        try {
            if (this.x != null) {
                Log.e(f3135a, "===========tryToReleaseCamera===========");
                y.a();
                this.x.a();
                y = null;
                this.x = null;
            }
            this.D = false;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.M != null) {
            this.M.a(motionEvent, this.z);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnDispatchTouchEventListener(b bVar) {
        this.M = bVar;
    }

    public void a(PlayerInfo playerInfo, boolean z) {
        if (playerInfo != null) {
            this.N = false;
            if (z && this.O != null && playerInfo != null && ((this.O.isYoutubePlayer() && playerInfo.isYoutubePlayer() && TextUtils.equals(this.O.getVideoId(), playerInfo.getVideoId())) || ((this.O.isLocalPlayer() && playerInfo.isLocalPlayer() && this.O.getSongId() == playerInfo.getSongId()) || (this.O.isRadioPlayer() && playerInfo.isRadioPlayer() && this.O.getRadioId() == playerInfo.getRadioId())))) {
                this.O = playerInfo;
                if (playerInfo.isPlaying()) {
                    this.n.setImageLevel(1);
                } else {
                    this.n.setImageLevel(0);
                }
                this.m.setText("" + playerInfo.getDuration());
                this.I.setCurrentProgress((float) playerInfo.getCurrentTime());
                this.I.setTotalProgress((float) playerInfo.getTotalTime());
                return;
            }
            if (z) {
                this.O = playerInfo;
            }
            h.a(f3135a, "PlayMusicModel:" + playerInfo.toString());
            d.a(getContext(), playerInfo.getCoverImg(), this.k);
            i.c(getContext()).a(playerInfo.getCoverImg()).d((int) R.mipmap.widget_default_cover).c((int) R.mipmap.widget_default_cover).a(new e(getContext()), new GlideRoundTransform(getContext())).b(com.bumptech.glide.load.b.b.ALL).c().a(this.k);
            this.l.setText("" + playerInfo.getMusicName());
            this.m.setText("" + playerInfo.getDuration());
            return;
        }
        i.c(getContext()).a(Integer.valueOf((int) R.mipmap.widget_default_cover)).d((int) R.mipmap.widget_default_cover).c((int) R.mipmap.widget_default_cover).a(new e(getContext()), new GlideRoundTransform(getContext())).b(com.bumptech.glide.load.b.b.ALL).c().a(this.k);
        this.l.setText(R.string.welcome_to_freemusic_tube_enjoy_your_music);
        this.m.setText("       ");
        this.n.setImageLevel(0);
        this.I.setCurrentProgress(0.0f);
    }

    public void setMusicData(PlayerInfo playerInfo) {
        this.O = playerInfo;
        this.N = true;
    }

    public void setOnCloseListener(a aVar) {
        this.P = aVar;
    }
}
