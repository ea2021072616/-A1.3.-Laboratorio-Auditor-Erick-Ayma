package com.fotoable.youtube.music.newplayer.popup;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.e.b;
import com.fotoable.youtube.music.helper.f;
import com.fotoable.youtube.music.newplayer.d.c;
import com.fotoable.youtube.music.service.MainService;
import com.fotoable.youtube.music.ui.view.YoutubePlayerView;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.j;
import com.fotoable.youtube.music.util.u;
import com.google.android.youtube.player.YouTubeIntents;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class FloatPlayerView extends LinearLayout {
    private static final String j = FloatPlayerView.class.getSimpleName();
    private ImageView A;
    private TextView B;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private ImageView G;
    private ImageView H;
    private ImageView I;
    private ImageView J;
    private ImageView K;
    private TextView L;
    private SeekBar M;
    private TextView N;
    private TextView O;
    private ImageView P;
    private RelativeLayout Q;
    private LinearLayout R;
    private LinearLayout S;
    private LinearLayout T;
    private Handler U;
    private int V;
    private int W;

    /* renamed from: a  reason: collision with root package name */
    public int f3011a;
    private long aa;
    private boolean ab;
    private boolean ac;
    private PlayMusicModel ad;
    private long ae;
    private long af;
    private String ag;
    private boolean ah;
    private boolean ai;
    private float aj;
    private float ak;
    private float al;
    private float am;
    private float an;
    private float ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private WindowManager.LayoutParams as;
    private boolean at;
    private com.fotoable.youtube.music.newplayer.c.a au;
    private boolean av;
    private boolean aw;
    private int ax;
    private boolean ay;

    /* renamed from: b  reason: collision with root package name */
    public int f3012b;

    /* renamed from: c  reason: collision with root package name */
    public int f3013c;
    public int d;
    public float e;
    ObjectAnimator f;
    ValueAnimator g;
    ValueAnimator h;
    Runnable i;
    private RelativeLayout k;
    private YoutubePlayerView l;
    private RelativeLayout m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private RelativeLayout q;
    private RelativeLayout r;
    private LinearLayout s;
    private ImageView t;
    private LinearLayout u;
    private boolean v;
    private boolean w;
    private WindowManager x;
    private ImageView y;
    private ImageView z;

    public FloatPlayerView(Context context) {
        super(context);
        this.U = new Handler() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1001:
                        FloatPlayerView.this.l();
                        return;
                    default:
                        return;
                }
            }
        };
        this.ah = false;
        this.aq = false;
        this.ar = true;
        this.at = false;
        this.aw = false;
        this.ay = false;
        a(context);
    }

    public FloatPlayerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.U = new Handler() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1001:
                        FloatPlayerView.this.l();
                        return;
                    default:
                        return;
                }
            }
        };
        this.ah = false;
        this.aq = false;
        this.ar = true;
        this.at = false;
        this.aw = false;
        this.ay = false;
        a(context);
    }

    public FloatPlayerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.U = new Handler() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1001:
                        FloatPlayerView.this.l();
                        return;
                    default:
                        return;
                }
            }
        };
        this.ah = false;
        this.aq = false;
        this.ar = true;
        this.at = false;
        this.aw = false;
        this.ay = false;
        a(context);
    }

    private void a(final Context context) {
        this.ax = com.fotoable.youtube.music.a.w();
        LayoutInflater.from(context).inflate(R.layout.view_float_player, this);
        this.T = (LinearLayout) findViewById(R.id.find_mp3_resource);
        this.S = (LinearLayout) findViewById(R.id.find_lyric);
        this.R = (LinearLayout) findViewById(R.id.more_options_panel_content);
        this.Q = (RelativeLayout) findViewById(R.id.more_options_panel);
        this.z = (ImageView) findViewById(R.id.mark_youtube);
        this.A = (ImageView) findViewById(R.id.back_view);
        this.B = (TextView) findViewById(R.id.video_title2);
        this.C = (ImageView) findViewById(R.id.close_view);
        this.D = (ImageView) findViewById(R.id.video_share2);
        this.E = (ImageView) findViewById(R.id.more_options);
        this.F = (ImageView) findViewById(R.id.loop_model2);
        this.G = (ImageView) findViewById(R.id.play_back2);
        this.y = (ImageView) findViewById(R.id.to_youtube);
        this.H = (ImageView) findViewById(R.id.change_play_state2);
        this.I = (ImageView) findViewById(R.id.play_loading3);
        this.J = (ImageView) findViewById(R.id.play_next2);
        this.o = (ImageView) findViewById(R.id.bg2);
        this.K = (ImageView) findViewById(R.id.video_favorite_state2);
        this.L = (TextView) findViewById(R.id.video_play_current_time2);
        this.M = (SeekBar) findViewById(R.id.video_seek_bar2);
        this.N = (TextView) findViewById(R.id.video_play_total_time2);
        this.O = (TextView) findViewById(R.id.video_hd);
        this.P = (ImageView) findViewById(R.id.video_screen_state);
        this.l = (YoutubePlayerView) findViewById(R.id.youtube_player);
        this.k = (RelativeLayout) findViewById(R.id.float_player_root);
        this.m = (RelativeLayout) findViewById(R.id.player_control_layer);
        this.n = (ImageView) findViewById(R.id.float_small_power_bt);
        this.p = (ImageView) findViewById(R.id.small_saver_power_red_tip);
        this.q = (RelativeLayout) findViewById(R.id.player_container);
        this.r = (RelativeLayout) findViewById(R.id.play_top_panel);
        this.s = (LinearLayout) findViewById(R.id.play_menu_panel);
        this.t = (ImageView) findViewById(R.id.float_lock_op);
        this.u = (LinearLayout) findViewById(R.id.play_progress_panel);
        m();
        q();
        this.l.initialize(null);
        this.e = context.getResources().getDisplayMetrics().density;
        this.f3011a = context.getResources().getDisplayMetrics().widthPixels;
        this.f3012b = context.getResources().getDisplayMetrics().heightPixels;
        if (this.f3011a > this.f3012b) {
            int i = this.f3011a;
            this.f3011a = this.f3012b;
            this.f3012b = i;
        }
        this.x = (WindowManager) context.getSystemService("window");
        this.d = (int) (150.0f * this.e);
        this.f3013c = (int) (267.0f * this.e);
        this.V = (int) (100.0f * this.e);
        this.W = (int) (178.0f * this.e);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.width = this.f3013c;
        layoutParams.height = this.d;
        this.k.setLayoutParams(layoutParams);
        if (com.fotoable.youtube.music.a.m()) {
            this.p.setVisibility(0);
        }
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatPlayerView.this.au != null) {
                    FloatPlayerView.this.au.c(FloatPlayerView.this.getContext());
                }
                FloatPlayerView.this.b(FloatPlayerView.this.getContext());
                if (com.fotoable.youtube.music.a.m()) {
                    FloatPlayerView.this.p.setVisibility(8);
                    com.fotoable.youtube.music.a.g(false);
                    MainService.a(FloatPlayerView.this.getContext(), "action_syn_small_player_red", new String[0]);
                }
            }
        });
        this.y.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatPlayerView.this.ad != null) {
                    b.a().a(new com.fotoable.youtube.music.e.a(8003));
                    try {
                        if (YouTubeIntents.canResolvePlayVideoIntent(FloatPlayerView.this.getContext())) {
                            Intent createPlayVideoIntentWithOptions = YouTubeIntents.createPlayVideoIntentWithOptions(FloatPlayerView.this.getContext(), FloatPlayerView.this.ad.getVideoId(), true, false);
                            createPlayVideoIntentWithOptions.setFlags(268435456);
                            FloatPlayerView.this.getContext().startActivity(createPlayVideoIntentWithOptions);
                        } else {
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(Uri.parse("https://www.youtube.com/watch?v=" + FloatPlayerView.this.ad.getVideoId()));
                            intent.setFlags(268435456);
                            FloatPlayerView.this.getContext().startActivity(intent);
                        }
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                }
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatPlayerView.this.aw) {
                    if (FloatPlayerView.this.ac) {
                        if (FloatPlayerView.this.t.getVisibility() != 0) {
                            FloatPlayerView.this.t.setVisibility(0);
                        } else {
                            FloatPlayerView.this.t.setVisibility(8);
                        }
                    } else if (FloatPlayerView.this.r.getVisibility() != 0) {
                        FloatPlayerView.this.r.setVisibility(0);
                        FloatPlayerView.this.s.setVisibility(0);
                        FloatPlayerView.this.t.setVisibility(0);
                        FloatPlayerView.this.u.setVisibility(0);
                    } else {
                        FloatPlayerView.this.l();
                    }
                }
            }
        });
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FloatPlayerView.this.l();
                b.a().a(new com.fotoable.youtube.music.e.a(8003));
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatPlayerView.this.au != null) {
                    FloatPlayerView.this.au.e(FloatPlayerView.this.getContext());
                }
                b.a().a(new com.fotoable.youtube.music.e.a(8003));
            }
        });
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FloatPlayerView.this.l();
                b.a().a(new com.fotoable.youtube.music.e.a(8003));
                f.a(FloatPlayerView.this.getContext(), FloatPlayerView.this.ad.getArtists(), FloatPlayerView.this.ad.getTitle(), FloatPlayerView.this.ad.getVideoId());
                com.fotoable.youtube.music.util.b.b("Youtube视频全屏-分享");
            }
        });
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FloatPlayerView.this.o();
                com.fotoable.youtube.music.util.b.b("Youtube视频全屏-更多");
            }
        });
        this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FloatPlayerView.this.p();
                FloatPlayerView.this.U.removeMessages(1001);
                FloatPlayerView.this.U.sendEmptyMessageDelayed(1001, 1500L);
            }
        });
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatPlayerView.this.ax == 0) {
                    FloatPlayerView.this.ax = 1;
                } else if (FloatPlayerView.this.ax == 1) {
                    FloatPlayerView.this.ax = 2;
                } else if (FloatPlayerView.this.ax == 2) {
                    FloatPlayerView.this.ax = 0;
                }
                FloatPlayerView.this.F.setImageLevel(FloatPlayerView.this.ax);
                com.fotoable.youtube.music.a.b(FloatPlayerView.this.ax);
                MainService.a(context, "syn_player_loop_model", "model", FloatPlayerView.this.ax);
                FloatPlayerView.this.U.removeMessages(1001);
                FloatPlayerView.this.U.sendEmptyMessageDelayed(1001, 1500L);
                com.fotoable.youtube.music.util.b.b("Youtube视频全屏-切换循环模式");
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.fotoable.youtube.music.newplayer.f.a().d(false);
                FloatPlayerView.this.U.removeMessages(1001);
                FloatPlayerView.this.U.sendEmptyMessageDelayed(1001, 1500L);
                com.fotoable.youtube.music.util.b.b("Youtube视频全屏-上一首");
            }
        });
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatPlayerView.this.e()) {
                    FloatPlayerView.this.b();
                } else {
                    FloatPlayerView.this.a();
                }
                FloatPlayerView.this.U.removeMessages(1001);
                FloatPlayerView.this.U.sendEmptyMessageDelayed(1001, 1500L);
                com.fotoable.youtube.music.util.b.b("Youtube视频全屏-切换播放状态");
            }
        });
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.fotoable.youtube.music.newplayer.f.a().e(false);
                FloatPlayerView.this.U.removeMessages(1001);
                FloatPlayerView.this.U.sendEmptyMessageDelayed(1001, 1500L);
                com.fotoable.youtube.music.util.b.b("Youtube视频全屏-下一首");
            }
        });
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatPlayerView.this.ad.isFav()) {
                    FloatPlayerView.this.K.setImageLevel(0);
                } else {
                    FloatPlayerView.this.K.setImageLevel(1);
                }
                MainService.a(context, "syn_music_fav", "videoId", FloatPlayerView.this.ad.getVideoId(), "isFav", FloatPlayerView.this.ad.isFav());
                FloatPlayerView.this.U.removeMessages(1001);
                FloatPlayerView.this.U.sendEmptyMessageDelayed(1001, 1500L);
                com.fotoable.youtube.music.util.b.b("Youtube视频全屏-修改收藏状态");
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!FloatPlayerView.this.ac) {
                    FloatPlayerView.this.ac = true;
                    FloatPlayerView.this.l();
                    FloatPlayerView.this.t.setImageLevel(1);
                } else {
                    FloatPlayerView.this.ac = false;
                    FloatPlayerView.this.t.setImageLevel(0);
                }
                FloatPlayerView.this.U.removeMessages(1001);
                FloatPlayerView.this.U.sendEmptyMessageDelayed(1001, 1500L);
                com.fotoable.youtube.music.util.b.b("Youtube视频全屏-切换屏幕旋转锁");
            }
        });
        this.O.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatPlayerView.this.l.isHd()) {
                    FloatPlayerView.this.O.setTextColor(FloatPlayerView.this.getResources().getColor(R.color.white));
                    FloatPlayerView.this.l.setQuality(1, false);
                } else {
                    FloatPlayerView.this.O.setTextColor(FloatPlayerView.this.getResources().getColor(R.color.colorAccent));
                    FloatPlayerView.this.l.setQuality(FloatPlayerView.this.f3012b, true);
                }
                FloatPlayerView.this.U.removeMessages(1001);
                FloatPlayerView.this.U.sendEmptyMessageDelayed(1001, 1500L);
                com.fotoable.youtube.music.util.b.b("Youtube视频全屏-HD");
            }
        });
        this.P.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FloatPlayerView.this.l();
                b.a().a(new com.fotoable.youtube.music.e.a(8003));
            }
        });
        this.S.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FloatPlayerView.this.p();
                FloatPlayerView.this.l();
                b.a().a(new com.fotoable.youtube.music.e.a(8003));
                MainService.a(context, "find_lyric", new String[0]);
                com.fotoable.youtube.music.util.b.b("Youtube视频全屏-搜索歌词");
            }
        });
        this.T.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FloatPlayerView.this.p();
                FloatPlayerView.this.l();
                b.a().a(new com.fotoable.youtube.music.e.a(8003));
                MainService.a(context, "find_mp3", new String[0]);
                com.fotoable.youtube.music.util.b.b("Youtube视频全屏-搜索Mp3");
            }
        });
        this.M.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.13
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (FloatPlayerView.this.ab) {
                    FloatPlayerView.this.L.setText(FloatPlayerView.this.a((i2 / seekBar.getMax()) * ((float) FloatPlayerView.this.aa)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                FloatPlayerView.this.ab = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                FloatPlayerView.this.ab = false;
                if (FloatPlayerView.this.v) {
                    FloatPlayerView.this.l.seekTo(seekBar.getProgress());
                } else {
                    FloatPlayerView.this.M.setProgress(0);
                }
                FloatPlayerView.this.U.removeMessages(1001);
                FloatPlayerView.this.U.sendEmptyMessageDelayed(1001, 1500L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.r.getVisibility() != 8) {
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            this.u.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        h.a(j, "showPlayLoading.....");
        this.H.setVisibility(8);
        this.I.setVisibility(0);
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
        this.f = ObjectAnimator.ofFloat(this.I, "rotation", 0.0f, 360.0f);
        this.f.setDuration(1500L);
        this.f.setRepeatCount(-1);
        this.f.setInterpolator(new LinearInterpolator());
        this.f.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
        this.H.setVisibility(0);
        this.I.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.ad != null && this.ad.isFav()) {
            this.K.setImageLevel(1);
        } else {
            this.K.setImageLevel(0);
        }
        this.Q.setVisibility(0);
        this.R.setPivotX(240.0f * this.e);
        this.R.setPivotY(0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (!FloatPlayerView.this.ai) {
                    FloatPlayerView.this.R.setScaleX(floatValue);
                    FloatPlayerView.this.R.setScaleY(floatValue);
                }
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.Q.getVisibility() == 0) {
            this.R.setPivotX(240.0f * this.e);
            this.R.setPivotY(0.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.15
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (!FloatPlayerView.this.ai) {
                        FloatPlayerView.this.R.setScaleX(floatValue);
                        FloatPlayerView.this.R.setScaleY(floatValue);
                    }
                }
            });
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.16
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (!FloatPlayerView.this.ai) {
                        FloatPlayerView.this.Q.setVisibility(8);
                    }
                }
            });
            ofFloat.setDuration(300L);
            ofFloat.start();
        }
    }

    private void q() {
        this.l.setOnPlayerListener(new YoutubePlayerView.OnPlayerListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.17
            @Override // com.fotoable.youtube.music.ui.view.YoutubePlayerView.OnPlayerListener
            public void onCurrentTimeChanged(long j2, long j3) {
                FloatPlayerView.this.ae = j2;
                FloatPlayerView.this.af = j3;
                if (FloatPlayerView.this.au != null) {
                    FloatPlayerView.this.au.a(FloatPlayerView.this.getContext(), j2, j3);
                }
                FloatPlayerView.this.M.setProgress((int) j2);
                FloatPlayerView.this.L.setText(FloatPlayerView.this.a(j2));
            }

            @Override // com.fotoable.youtube.music.ui.view.YoutubePlayerView.OnPlayerListener
            public void onPlayerReady() {
                FloatPlayerView.this.v = true;
                FloatPlayerView.this.q.setAlpha(1.0f);
                if (FloatPlayerView.this.l != null && FloatPlayerView.this.au != null) {
                    FloatPlayerView.this.au.a();
                }
            }

            @Override // com.fotoable.youtube.music.ui.view.YoutubePlayerView.OnPlayerListener
            public void onPlayerStateChanged(int i) {
                FloatPlayerView.this.w = false;
                if (i == 3) {
                    FloatPlayerView.this.at = true;
                    if (FloatPlayerView.this.au != null) {
                        FloatPlayerView.this.au.b();
                    }
                    if (!FloatPlayerView.this.v && FloatPlayerView.this.m.getVisibility() != 8) {
                        FloatPlayerView.this.m.setVisibility(8);
                    }
                } else if (i == 1) {
                    if (!FloatPlayerView.this.ah) {
                        FloatPlayerView.this.l.pause();
                        return;
                    }
                    FloatPlayerView.this.at = true;
                    if (FloatPlayerView.this.au != null) {
                        FloatPlayerView.this.au.a(FloatPlayerView.this.getContext());
                    }
                    if (FloatPlayerView.this.m.getVisibility() != 0) {
                        FloatPlayerView.this.m.setVisibility(0);
                    }
                    FloatPlayerView.this.H.setImageLevel(1);
                    if (FloatPlayerView.this.z.getVisibility() != 8) {
                        FloatPlayerView.this.z.setVisibility(8);
                    }
                } else if (i == 2) {
                    FloatPlayerView.this.at = false;
                    if (FloatPlayerView.this.au != null) {
                        FloatPlayerView.this.au.b(FloatPlayerView.this.getContext());
                    }
                    FloatPlayerView.this.H.setImageLevel(0);
                } else if (i == -1) {
                    FloatPlayerView.this.at = false;
                    if (FloatPlayerView.this.au != null) {
                        FloatPlayerView.this.au.c();
                    }
                    if (!FloatPlayerView.this.v && FloatPlayerView.this.m.getVisibility() != 8) {
                        FloatPlayerView.this.m.setVisibility(8);
                    }
                } else if (i == 0) {
                    FloatPlayerView.this.at = false;
                    if (FloatPlayerView.this.au != null) {
                        FloatPlayerView.this.au.d();
                    }
                } else if (i == 5) {
                    FloatPlayerView.this.at = false;
                    if (FloatPlayerView.this.au != null) {
                        FloatPlayerView.this.au.e();
                    }
                    if (!FloatPlayerView.this.v && FloatPlayerView.this.m.getVisibility() != 8) {
                        FloatPlayerView.this.m.setVisibility(8);
                    }
                    FloatPlayerView.this.m();
                }
            }

            @Override // com.fotoable.youtube.music.ui.view.YoutubePlayerView.OnPlayerListener
            public void isPreKitKat(boolean z) {
            }

            @Override // com.fotoable.youtube.music.ui.view.YoutubePlayerView.OnPlayerListener
            public void onVideoTotalTime(long j2) {
                FloatPlayerView.this.w = false;
                if (FloatPlayerView.this.au != null) {
                    FloatPlayerView.this.au.a(FloatPlayerView.this.getContext(), j2);
                }
                FloatPlayerView.this.M.setMax((int) j2);
                FloatPlayerView.this.N.setText(FloatPlayerView.this.a(j2));
                FloatPlayerView.this.aa = j2;
                FloatPlayerView.this.n();
            }

            @Override // com.fotoable.youtube.music.ui.view.YoutubePlayerView.OnPlayerListener
            public void onLoadFailed() {
                if (!FloatPlayerView.this.w) {
                    com.fotoable.youtube.music.util.b.b("Dev_播放失败", "失败原因", "播放界面加载失败");
                    com.fotoable.youtube.music.util.b.b("Dev_Youtube播放失败(按国家)", "播放界面加载失败(国家)", "" + com.fotoable.youtube.music.a.b());
                    try {
                        com.fotoable.youtube.music.util.b.b("Dev_播放失败网页加载失败", "网络状态", "" + j.a().toString());
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                    FloatPlayerView.this.w = true;
                }
                FloatPlayerView.this.at = false;
            }

            @Override // com.fotoable.youtube.music.ui.view.YoutubePlayerView.OnPlayerListener
            public void onPlayerError(int i) {
                FloatPlayerView.this.at = false;
            }
        });
    }

    public void a(PlayMusicModel playMusicModel) {
        this.ad = playMusicModel;
        if (playMusicModel != null) {
            this.B.setText(playMusicModel.getTitle() + "");
        }
    }

    public void b(PlayMusicModel playMusicModel) {
        this.ah = true;
        this.ad = playMusicModel;
        if (playMusicModel != null) {
            this.ag = playMusicModel.getVideoId();
            if (this.w) {
                this.l.ytLoad();
            } else {
                this.l.onCueVideo(this.ag);
            }
            if (playMusicModel != null) {
                this.B.setText(playMusicModel.getTitle() + "");
            }
        }
    }

    public void a() {
        this.ah = true;
        if (this.w) {
            this.l.ytLoad();
        } else if (!e()) {
            this.l.play();
        }
    }

    public void a(int i) {
        this.l.seekTo(i);
    }

    public void b() {
        this.ah = false;
        this.l.pause();
    }

    public void c() {
        this.ah = false;
        this.l.stop();
    }

    public void d() {
        this.ah = false;
        this.au = null;
        this.l.onDestroy();
        this.l.destroy();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ai = true;
        if (this.au != null) {
            this.au.b(getContext());
        }
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.ar && !this.aw) {
            this.al = motionEvent.getRawX();
            this.am = motionEvent.getRawY();
            if (motionEvent.getAction() == 0) {
                this.an = motionEvent.getX();
                this.ao = motionEvent.getY();
                this.aj = motionEvent.getRawX();
                this.ak = motionEvent.getRawY();
                this.ap = true;
                this.aq = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (Math.abs(this.aj - this.al) > 3.0f * this.e || Math.abs(this.ak - this.am) > 3.0f * this.e) {
                    this.ap = false;
                    if (!this.aq) {
                        c.a().k(getContext());
                        this.aq = true;
                    }
                }
                if (((int) (this.al - this.an)) < this.e * 10.0f) {
                    this.al = this.an + (this.e * 10.0f);
                }
                if (((int) (this.al - this.an)) > (this.f3011a - this.f3013c) - (this.e * 10.0f)) {
                    this.al = this.an + ((this.f3011a - this.f3013c) - (this.e * 10.0f));
                }
                if (((int) (this.am - this.ao)) < u.b(getContext()) + (this.e * 10.0f)) {
                    this.am = this.ao + u.b(getContext()) + (this.e * 10.0f);
                }
                if (((int) (this.am - this.ao)) > (this.f3012b - this.d) - (this.e * 10.0f)) {
                    this.am = this.ao + ((this.f3012b - this.d) - (this.e * 10.0f));
                }
                r();
                if (this.aq) {
                    c.a().c(this.am - this.ao > ((float) (this.f3012b - this.d)) - (this.e * 30.0f));
                    return true;
                }
                return true;
            } else if (motionEvent.getAction() == 1) {
                if (this.ap) {
                    h.a(j, "点击事件");
                    if (this.ao > this.e * 25.0f || this.an >= this.f3013c - (this.e * 25.0f)) {
                    }
                    if (this.ao <= this.e * 30.0f && this.an < this.e * 30.0f && this.an > 0.0f) {
                        if (this.au != null) {
                            this.au.c(getContext());
                        }
                        b(getContext());
                        if (com.fotoable.youtube.music.a.m()) {
                            this.p.setVisibility(8);
                            com.fotoable.youtube.music.a.g(false);
                            MainService.a(getContext(), "action_syn_small_player_red", new String[0]);
                            return true;
                        }
                        return true;
                    }
                    try {
                        if (this.au != null) {
                            this.au.d(getContext());
                        }
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                }
                this.ap = false;
                if (this.aq) {
                    c.a().h();
                    if (this.am - this.ao < ((getResources().getDisplayMetrics().heightPixels - u.b(getContext())) - (getResources().getDisplayMetrics().density * 25.0f)) - getHeight() || this.au == null) {
                        return true;
                    }
                    this.au.e(getContext());
                    return true;
                }
                return true;
            } else {
                return true;
            }
        } else if (this.ay && motionEvent.getAction() == 1) {
            if (this.au != null) {
                this.au.d(getContext());
                com.fotoable.youtube.music.util.b.b("播放条-点击进入播放界面");
                return true;
            }
            return true;
        } else {
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        this.av = true;
        this.ar = false;
        this.n.setVisibility(8);
        this.p.setVisibility(8);
        final float f = this.as.x;
        final float f2 = this.as.y;
        final float f3 = (this.f3011a - this.f3013c) / 2.0f;
        final float f4 = (this.f3012b - this.d) / 2.0f;
        h.a(j, "cx:" + f + ",cy:" + f2 + ",targetX:" + f3 + ",targetY:" + f4);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f3);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.18
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f5 = (floatValue - f) / (f3 - f);
                FloatPlayerView.this.as.x = (int) floatValue;
                FloatPlayerView.this.as.y = (int) ((f5 * (f4 - f2)) + f2);
                try {
                    FloatPlayerView.this.x.updateViewLayout(FloatPlayerView.this, FloatPlayerView.this.as);
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
        });
        ofFloat.start();
    }

    private void r() {
        if (this.as != null) {
            this.as.x = (int) (this.al - this.an);
            this.as.y = (int) (this.am - this.ao);
            if (this.x != null) {
                try {
                    this.x.updateViewLayout(this, this.as);
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
        }
    }

    public void setParams(WindowManager.LayoutParams layoutParams) {
        this.as = layoutParams;
    }

    public boolean e() {
        return this.at;
    }

    public void setOnYoutubePlayerListener(com.fotoable.youtube.music.newplayer.c.a aVar) {
        this.au = aVar;
    }

    public void f() {
        final float f;
        final float f2;
        if (this.i != null) {
            removeCallbacks(this.i);
        }
        j();
        this.n.setVisibility(0);
        final float f3 = this.as.x;
        final float f4 = this.as.y;
        if (this.al < 0.1f || f3 < 0.1f || f4 < 0.1f) {
            f = (int) ((this.f3011a - this.f3013c) - (15.0f * getResources().getDisplayMetrics().density));
            f2 = (int) (65.0f * getResources().getDisplayMetrics().density);
        } else {
            f = (int) (this.al - this.an);
            f2 = (int) (this.am - this.ao);
        }
        h.a(j, "cx22:" + f3 + ",cy:" + f4 + ",targetX:" + f + ",targetY:" + f2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f3, f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f5 = (floatValue - f3) / (f - f3);
                FloatPlayerView.this.as.x = (int) floatValue;
                FloatPlayerView.this.as.y = (int) ((f5 * (f2 - f4)) + f4);
                try {
                    FloatPlayerView.this.x.updateViewLayout(FloatPlayerView.this, FloatPlayerView.this.as);
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.20
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                FloatPlayerView.this.ar = true;
                h.a(FloatPlayerView.j, "可滑动1");
            }
        });
        ofFloat.start();
        this.av = false;
    }

    public boolean g() {
        return this.av;
    }

    public void b(int i) {
        if (!this.aw && !this.av) {
            if (this.i != null) {
                removeCallbacks(this.i);
            }
            j();
            this.ar = false;
            float f = (this.f3011a - this.f3013c) - (15.0f * this.e);
            float f2 = 65.0f * this.e;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            this.k.setPadding(0, 0, 0, 0);
            layoutParams.width = this.f3013c;
            layoutParams2.width = this.f3013c;
            layoutParams3.width = this.f3013c;
            layoutParams4.width = this.f3013c;
            layoutParams.height = this.d;
            layoutParams2.height = this.d;
            layoutParams3.height = this.d;
            layoutParams4.height = this.d;
            this.k.setLayoutParams(layoutParams);
            this.q.setLayoutParams(layoutParams2);
            this.l.setLayoutParams(layoutParams3);
            this.o.setLayoutParams(layoutParams4);
            this.as.width = this.f3013c;
            this.as.height = this.d;
            this.ar = true;
            h.a(j, "可滑动2");
            this.ay = false;
            this.as.x = (int) f;
            this.as.y = (int) f2;
            this.n.setVisibility(0);
            try {
                this.x.updateViewLayout(this, this.as);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
            if (com.fotoable.youtube.music.a.m()) {
                this.p.setVisibility(0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.aw) {
            b.a().a(new com.fotoable.youtube.music.e.a(8003));
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void c(final int i) {
        if (this.as != null) {
            post(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.21
                @Override // java.lang.Runnable
                public void run() {
                    FloatPlayerView.this.j();
                    if (i == 1) {
                        h.a(FloatPlayerView.j, "开始切换到横屏");
                        FloatPlayerView.this.aw = true;
                        FloatPlayerView.this.as.x = 0;
                        FloatPlayerView.this.as.y = 0;
                        h.a(FloatPlayerView.j, "全屏的尺寸：" + FloatPlayerView.this.f3011a + "," + FloatPlayerView.this.f3012b);
                        h.a(FloatPlayerView.j, "全屏的尺寸：" + FloatPlayerView.this.getResources().getDisplayMetrics().widthPixels + "," + FloatPlayerView.this.getResources().getDisplayMetrics().heightPixels);
                        final int i2 = (int) (FloatPlayerView.this.f3011a + (FloatPlayerView.this.e * 1.0f));
                        final int i3 = (int) (FloatPlayerView.this.f3012b + (FloatPlayerView.this.e * 1.0f));
                        FloatPlayerView.this.as.width = i3;
                        FloatPlayerView.this.as.height = i2;
                        FloatPlayerView.this.as.flags = 1824;
                        if (Build.VERSION.SDK_INT >= 19) {
                            FloatPlayerView.this.as.flags |= 16777216;
                        }
                        FloatPlayerView.this.x.updateViewLayout(FloatPlayerView.this, FloatPlayerView.this.as);
                        h.a(FloatPlayerView.j, "调整视频尺寸+" + FloatPlayerView.this.aw);
                        FloatPlayerView.this.postDelayed(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.21.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) FloatPlayerView.this.k.getLayoutParams();
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) FloatPlayerView.this.q.getLayoutParams();
                                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) FloatPlayerView.this.l.getLayoutParams();
                                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) FloatPlayerView.this.o.getLayoutParams();
                                layoutParams.width = i3;
                                layoutParams4.width = i3;
                                layoutParams2.width = i3;
                                layoutParams3.width = i3;
                                layoutParams.height = i2;
                                layoutParams4.height = i2;
                                layoutParams2.height = i2;
                                layoutParams3.height = i2;
                                FloatPlayerView.this.k.setPadding(0, 0, 0, 0);
                                FloatPlayerView.this.k.setBackgroundResource(R.color.all_alpha);
                                FloatPlayerView.this.k.setLayoutParams(layoutParams);
                                FloatPlayerView.this.q.setLayoutParams(layoutParams2);
                                FloatPlayerView.this.l.setLayoutParams(layoutParams3);
                                FloatPlayerView.this.o.setLayoutParams(layoutParams4);
                                FloatPlayerView.this.n.setVisibility(8);
                                FloatPlayerView.this.p.setVisibility(8);
                            }
                        }, 200L);
                    } else if (i == 3 || i == 4) {
                        if (i != 3 || FloatPlayerView.this.aw) {
                            if (i == 4 && !FloatPlayerView.this.e()) {
                                c.a().e();
                            }
                            FloatPlayerView.this.n.setVisibility(0);
                            if (com.fotoable.youtube.music.a.m()) {
                                FloatPlayerView.this.p.setVisibility(0);
                            }
                            FloatPlayerView.this.aw = false;
                            FloatPlayerView.this.l();
                            FloatPlayerView.this.as.flags = 1832;
                            FloatPlayerView.this.as.gravity = 51;
                            if (Build.VERSION.SDK_INT >= 19) {
                                FloatPlayerView.this.as.flags |= 16777216;
                            }
                            int i4 = (int) (0.5d * FloatPlayerView.this.e);
                            FloatPlayerView.this.k.setPadding(i4, i4, i4, i4);
                            FloatPlayerView.this.k.setBackgroundResource(R.drawable.shape_player_border);
                            if (FloatPlayerView.this.al < 0.1f) {
                                FloatPlayerView.this.as.x = (int) ((FloatPlayerView.this.f3011a - FloatPlayerView.this.f3013c) - (15.0f * FloatPlayerView.this.getResources().getDisplayMetrics().density));
                                FloatPlayerView.this.as.y = (int) (65.0f * FloatPlayerView.this.getResources().getDisplayMetrics().density);
                            } else {
                                FloatPlayerView.this.as.x = (int) (FloatPlayerView.this.al - FloatPlayerView.this.an);
                                FloatPlayerView.this.as.y = (int) (FloatPlayerView.this.am - FloatPlayerView.this.ao);
                            }
                            FloatPlayerView.this.ay = false;
                            FloatPlayerView.this.ar = true;
                            h.a(FloatPlayerView.j, "可滑动3");
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) FloatPlayerView.this.k.getLayoutParams();
                            layoutParams.width = FloatPlayerView.this.f3013c;
                            layoutParams.height = FloatPlayerView.this.d;
                            FloatPlayerView.this.k.setLayoutParams(layoutParams);
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) FloatPlayerView.this.q.getLayoutParams();
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) FloatPlayerView.this.l.getLayoutParams();
                            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) FloatPlayerView.this.o.getLayoutParams();
                            layoutParams4.width = FloatPlayerView.this.f3013c;
                            layoutParams2.width = FloatPlayerView.this.f3013c;
                            layoutParams3.width = FloatPlayerView.this.f3013c;
                            layoutParams4.height = FloatPlayerView.this.d;
                            layoutParams2.height = FloatPlayerView.this.d;
                            layoutParams3.height = FloatPlayerView.this.d;
                            FloatPlayerView.this.as.width = FloatPlayerView.this.f3013c;
                            FloatPlayerView.this.as.height = FloatPlayerView.this.d;
                            try {
                                FloatPlayerView.this.x.updateViewLayout(FloatPlayerView.this, FloatPlayerView.this.as);
                            } catch (Exception e) {
                                ThrowableExtension.printStackTrace(e);
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(long j2) {
        long j3 = (j2 / 60) / 60;
        long j4 = (j2 - ((j3 * 60) * 60)) / 60;
        long j5 = (j2 - ((j3 * 60) * 60)) - (60 * j4);
        StringBuffer stringBuffer = new StringBuffer();
        if (j3 > 0) {
            stringBuffer.append(j3);
            stringBuffer.append(":");
        }
        if (j4 > 0) {
            if (j4 < 10) {
                stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            stringBuffer.append(j4);
            stringBuffer.append(":");
        } else {
            stringBuffer.append("00:");
        }
        if (j5 > 0) {
            if (j5 < 10) {
                stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            stringBuffer.append(j5);
        } else {
            stringBuffer.append("00");
        }
        return stringBuffer.toString();
    }

    public void h() {
        this.U.post(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.22
            @Override // java.lang.Runnable
            public void run() {
                c.a().a(false, FloatPlayerView.this.getContext(), FloatPlayerView.this.ad, FloatPlayerView.this.e(), FloatPlayerView.this.ae, FloatPlayerView.this.af);
            }
        });
    }

    public void i() {
        this.ar = false;
        this.ay = true;
        this.n.setVisibility(8);
        this.p.setVisibility(8);
        this.as.x = 0;
        this.as.y = this.f3012b - this.V;
        float f = 56.0f * this.e;
        final int i = this.W;
        final int i2 = this.V;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
        this.k.setPadding(0, 0, 0, 0);
        layoutParams.width = i;
        layoutParams.height = i2;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.width = i;
        layoutParams2.width = i;
        layoutParams3.width = i;
        layoutParams4.width = i;
        layoutParams.height = i2;
        layoutParams2.height = i2;
        layoutParams3.height = i2;
        layoutParams4.height = i2;
        this.q.setLayoutParams(layoutParams2);
        this.l.setLayoutParams(layoutParams3);
        this.o.setLayoutParams(layoutParams4);
        this.k.setLayoutParams(layoutParams);
        try {
            this.x.updateViewLayout(this, this.as);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        postDelayed(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.popup.FloatPlayerView.24
            @Override // java.lang.Runnable
            public void run() {
                FloatPlayerView.this.as.width = i;
                FloatPlayerView.this.as.height = i2;
                try {
                    FloatPlayerView.this.x.updateViewLayout(FloatPlayerView.this, FloatPlayerView.this.as);
                } catch (Exception e2) {
                    ThrowableExtension.printStackTrace(e2);
                }
            }
        }, 200L);
    }

    public void j() {
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
    }
}
