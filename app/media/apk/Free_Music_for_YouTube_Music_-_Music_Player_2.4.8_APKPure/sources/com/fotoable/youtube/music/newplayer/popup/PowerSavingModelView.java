package com.fotoable.youtube.music.newplayer.popup;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.newplayer.d.c;
import com.fotoable.youtube.music.newplayer.f;
import com.fotoable.youtube.music.newplayer.popup.PowerSavingModelView;
import com.fotoable.youtube.music.service.MainService;
import com.fotoable.youtube.music.ui.view.FloatLockSlideView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class PowerSavingModelView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3058b = PowerSavingModelView.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public float f3059a;

    /* renamed from: c  reason: collision with root package name */
    private WindowManager.LayoutParams f3060c;
    private WindowManager d;
    private ValueAnimator e;
    private Handler f;
    @BindView(R.id.float_slide_view)
    FloatLockSlideView float_slide_view;
    @BindView(R.id.max_view)
    RelativeLayout max_view;
    @BindView(R.id.video_description2)
    TextView video_description2;
    @BindView(R.id.video_title3)
    TextView video_title3;
    @BindView(R.id.youtube_background_tip_panel)
    LinearLayout youtube_background_tip_panel;

    /* renamed from: com.fotoable.youtube.music.newplayer.popup.PowerSavingModelView$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends Handler {
        AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1001) {
                PowerSavingModelView powerSavingModelView = PowerSavingModelView.this;
                float[] fArr = new float[2];
                fArr[0] = PowerSavingModelView.this.f3059a > 0.5f ? PowerSavingModelView.this.f3059a : 0.5f;
                fArr[1] = 0.01f;
                powerSavingModelView.e = ValueAnimator.ofFloat(fArr);
                PowerSavingModelView.this.e.setInterpolator(new LinearInterpolator());
                PowerSavingModelView.this.e.setDuration(600L);
                PowerSavingModelView.this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.fotoable.youtube.music.newplayer.popup.a

                    /* renamed from: a  reason: collision with root package name */
                    private final PowerSavingModelView.AnonymousClass1 f3077a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f3077a = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f3077a.a(valueAnimator);
                    }
                });
                PowerSavingModelView.this.e.start();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void a(ValueAnimator valueAnimator) {
            try {
                PowerSavingModelView.this.f3060c.screenBrightness = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                PowerSavingModelView.this.d.updateViewLayout(PowerSavingModelView.this, PowerSavingModelView.this.f3060c);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public PowerSavingModelView(Context context) {
        super(context);
        this.f = new AnonymousClass1();
        LayoutInflater.from(context).inflate(R.layout.activity_power_saving_mode, this);
        ButterKnife.bind(this);
        if (com.fotoable.youtube.music.a.q()) {
            this.youtube_background_tip_panel.setVisibility(0);
        }
        this.d = (WindowManager) context.getSystemService("window");
        final int a2 = a(getContext());
        if (a2 == 0) {
            this.f3059a = 0.5f;
        } else {
            this.f3059a = a2 / 255.0f;
        }
        this.float_slide_view.setOnDrawPowerModelListener(new FloatLockSlideView.OnDrawPowerModelListener() { // from class: com.fotoable.youtube.music.newplayer.popup.PowerSavingModelView.2
            @Override // com.fotoable.youtube.music.ui.view.FloatLockSlideView.OnDrawPowerModelListener
            public void onNext() {
                PowerSavingModelView.this.f.removeMessages(1001);
                if (PowerSavingModelView.this.f3059a < 0.5f) {
                    PowerSavingModelView.this.f3060c.screenBrightness = 0.5f;
                    PowerSavingModelView.this.d.updateViewLayout(PowerSavingModelView.this, PowerSavingModelView.this.f3060c);
                } else {
                    PowerSavingModelView.this.f3060c.screenBrightness = a2;
                    PowerSavingModelView.this.d.updateViewLayout(PowerSavingModelView.this, PowerSavingModelView.this.f3060c);
                }
                f.a().e(false);
                PowerSavingModelView.this.f.sendEmptyMessageDelayed(1001, 1000L);
            }

            @Override // com.fotoable.youtube.music.ui.view.FloatLockSlideView.OnDrawPowerModelListener
            public void onExit() {
                PowerSavingModelView.this.f.removeMessages(1001);
                PowerSavingModelView.this.f3060c.screenBrightness = PowerSavingModelView.this.f3059a;
                PowerSavingModelView.this.d.updateViewLayout(PowerSavingModelView.this, PowerSavingModelView.this.f3060c);
                c.a().j(PowerSavingModelView.this.getContext());
            }

            @Override // com.fotoable.youtube.music.ui.view.FloatLockSlideView.OnDrawPowerModelListener
            public void onLight() {
                PowerSavingModelView.this.f.removeMessages(1001);
                if (PowerSavingModelView.this.f3059a < 0.5f) {
                    PowerSavingModelView.this.f3060c.screenBrightness = 0.5f;
                    PowerSavingModelView.this.d.updateViewLayout(PowerSavingModelView.this, PowerSavingModelView.this.f3060c);
                } else {
                    PowerSavingModelView.this.f3060c.screenBrightness = a2;
                    PowerSavingModelView.this.d.updateViewLayout(PowerSavingModelView.this, PowerSavingModelView.this.f3060c);
                }
                PowerSavingModelView.this.f.sendEmptyMessageDelayed(1001, 1000L);
            }

            @Override // com.fotoable.youtube.music.ui.view.FloatLockSlideView.OnDrawPowerModelListener
            public void onDark() {
                PowerSavingModelView.this.f.removeMessages(1001);
                PowerSavingModelView.this.f.sendEmptyMessageDelayed(1001, 1000L);
            }
        });
    }

    public void setParams(WindowManager.LayoutParams layoutParams) {
        this.f3060c = layoutParams;
    }

    @OnClick({R.id.got_it_tv})
    public void onClick(View view) {
        if (view != null) {
            switch (view.getId()) {
                case R.id.got_it_tv /* 2131820889 */:
                    this.youtube_background_tip_panel.setVisibility(8);
                    com.fotoable.youtube.music.a.k(false);
                    MainService.a(getContext(), "syn_youtube_got_it", new String[0]);
                    return;
                default:
                    return;
            }
        }
    }

    public static int a(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            ThrowableExtension.printStackTrace(e);
            return 0;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            b();
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.max_view, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.start();
        this.f.removeMessages(1001);
        this.f.sendEmptyMessageDelayed(1001, 1000L);
    }

    private void b() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.max_view, "alpha", 1.0f, 0.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.fotoable.youtube.music.newplayer.popup.PowerSavingModelView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.a().j(PowerSavingModelView.this.getContext());
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f.removeMessages(1001);
    }

    public void setModel(PlayMusicModel playMusicModel) {
        if (playMusicModel != null) {
            this.video_title3.setText(playMusicModel.getTitle() + "");
            if (!TextUtils.isEmpty(playMusicModel.getArtists())) {
                this.video_description2.setText(playMusicModel.getArtists() + "");
                return;
            } else {
                this.video_description2.setText("");
                return;
            }
        }
        this.video_title3.setText("");
        this.video_description2.setText("");
    }
}
