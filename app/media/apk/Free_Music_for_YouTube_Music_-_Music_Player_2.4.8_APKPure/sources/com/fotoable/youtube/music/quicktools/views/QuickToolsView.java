package com.fotoable.youtube.music.quicktools.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.flurry.android.FlurryAgent;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.quicktools.views.BottomToolView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import rx.m;
/* loaded from: classes.dex */
public class QuickToolsView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3142a = QuickToolsView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private WindowManager f3143b;

    /* renamed from: c  reason: collision with root package name */
    private FrameLayout f3144c;
    private BottomToolView d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private float k;
    private float l;
    private int m;
    private int n;
    private float o;
    private m p;
    private IntentFilter q;
    private BroadcastReceiver r;

    public QuickToolsView(Context context) {
        this(context, null);
    }

    public QuickToolsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QuickToolsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.o = 0.7f;
        this.q = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.r = new BroadcastReceiver() { // from class: com.fotoable.youtube.music.quicktools.views.QuickToolsView.6

            /* renamed from: a  reason: collision with root package name */
            final String f3151a = "reason";

            /* renamed from: b  reason: collision with root package name */
            final String f3152b = "homekey";

            /* renamed from: c  reason: collision with root package name */
            final String f3153c = "recentapps";

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                try {
                    String action = intent.getAction();
                    String stringExtra = intent.getStringExtra("reason");
                    if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && stringExtra != null) {
                        if (stringExtra.equals("homekey")) {
                            QuickToolsView.this.a(false);
                        }
                        if (stringExtra.equals("recentapps")) {
                            QuickToolsView.this.a(false);
                        }
                    }
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
        };
        e();
    }

    private void e() {
        try {
            f();
            h();
            this.e = true;
        } catch (Exception e) {
            this.e = false;
            ThrowableExtension.printStackTrace(e);
        }
    }

    private void f() {
        this.f3143b = (WindowManager) getContext().getApplicationContext().getSystemService("window");
        this.m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f3144c = new FrameLayout(getContext());
        this.f3144c.setBackgroundColor(Color.parseColor("#99000000"));
        this.f3144c.setAlpha(0.0f);
        this.f3144c.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 23) {
            if (g()) {
                this.n = (int) (getContext().getResources().getDisplayMetrics().density * 329.0f);
            } else {
                this.n = (int) (279.0f * getContext().getResources().getDisplayMetrics().density);
            }
        } else {
            this.n = (int) (getContext().getResources().getDisplayMetrics().density * 329.0f);
        }
        this.d = new BottomToolView(getContext());
        this.d.setVisibility(8);
    }

    private boolean g() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.System.canWrite(getContext());
        }
        return true;
    }

    private void h() {
        this.f3144c.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.quicktools.views.QuickToolsView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    QuickToolsView.this.a(false);
                }
                return false;
            }
        });
        this.d.setOnCloseListener(new BottomToolView.a() { // from class: com.fotoable.youtube.music.quicktools.views.QuickToolsView.2
            @Override // com.fotoable.youtube.music.quicktools.views.BottomToolView.a
            public void a() {
                QuickToolsView.this.a(false);
            }
        });
        this.d.setOnDispatchTouchEventListener(new BottomToolView.b() { // from class: com.fotoable.youtube.music.quicktools.views.QuickToolsView.3
            @Override // com.fotoable.youtube.music.quicktools.views.BottomToolView.b
            public void a(MotionEvent motionEvent, boolean z) {
                if (!z && QuickToolsView.this.g && !QuickToolsView.this.j) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            QuickToolsView.this.i = false;
                            QuickToolsView.this.k = motionEvent.getRawX();
                            QuickToolsView.this.l = motionEvent.getRawY();
                            return;
                        case 1:
                            if (QuickToolsView.this.i) {
                                QuickToolsView.this.a(((float) Math.abs(((WindowManager.LayoutParams) QuickToolsView.this.d.getLayoutParams()).y)) < ((float) QuickToolsView.this.n) * (1.0f - QuickToolsView.this.o));
                                QuickToolsView.this.i = false;
                                return;
                            }
                            return;
                        case 2:
                            float rawX = motionEvent.getRawX();
                            float rawY = motionEvent.getRawY();
                            float f = rawX - QuickToolsView.this.k;
                            float f2 = rawY - QuickToolsView.this.l;
                            if (f2 > f && f2 > QuickToolsView.this.m && QuickToolsView.this.g && !QuickToolsView.this.h) {
                                QuickToolsView.this.i = true;
                                QuickToolsView.this.a(-f2);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.i = false;
                this.l = motionEvent.getRawY();
                break;
            case 1:
                if (this.i) {
                    a(((float) Math.abs(((WindowManager.LayoutParams) this.d.getLayoutParams()).y)) < ((float) this.n) * this.o);
                    this.i = false;
                    break;
                }
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.l;
                if (Math.abs(rawY) > this.m) {
                    this.i = true;
                }
                if (this.i && !this.g && !this.h) {
                    float f = -(this.n + rawY);
                    a(f <= 0.0f ? f : 0.0f);
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if ((keyEvent.getKeyCode() == 4 || keyEvent.getKeyCode() == 3 || keyEvent.getKeyCode() == 82) && keyEvent.getAction() == 1 && this.g) {
            a(false);
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void a() {
        if (!this.f) {
            try {
                if (!this.e) {
                    f();
                    h();
                }
                this.f3143b.addView(this.f3144c, getBgParams());
                WindowManager.LayoutParams toolsParams = getToolsParams();
                toolsParams.y = -this.n;
                this.f3143b.addView(this.d, toolsParams);
                this.f3143b.addView(this, getOverlayParams());
                this.f = true;
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public void b() {
        this.f = false;
        this.e = false;
        try {
            if (this.f3143b != null) {
                if (this.f3144c != null) {
                    this.f3143b.removeView(this.f3144c);
                    this.f3144c = null;
                }
                if (this.d != null) {
                    this.f3143b.removeView(this.d);
                    this.d = null;
                }
                this.f3143b.removeView(this);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private WindowManager.LayoutParams getParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 19) {
            layoutParams.type = 2005;
        } else {
            layoutParams.type = 2003;
        }
        layoutParams.format = 1;
        layoutParams.flags = 1064;
        if (Build.VERSION.SDK_INT >= 19) {
            layoutParams.flags |= 16777216;
        }
        return layoutParams;
    }

    private WindowManager.LayoutParams getBgParams() {
        WindowManager.LayoutParams params = getParams();
        params.flags |= 256;
        params.height = -1;
        params.width = -1;
        params.x = 0;
        params.y = 0;
        return params;
    }

    private WindowManager.LayoutParams getOverlayParams() {
        WindowManager.LayoutParams params = getParams();
        params.gravity = 81;
        params.width = getContext().getResources().getDimensionPixelSize(R.dimen.quick_tools_overlay_width);
        params.height = getContext().getResources().getDimensionPixelSize(R.dimen.quick_tools_overlay_height);
        return params;
    }

    private WindowManager.LayoutParams getToolsParams() {
        WindowManager.LayoutParams params = getParams();
        params.flags |= 512;
        params.gravity = 81;
        params.width = -1;
        params.height = -2;
        return params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        try {
            if (this.f) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.d.getLayoutParams();
                layoutParams.y = (int) f;
                this.f3143b.updateViewLayout(this.d, layoutParams);
                this.d.setVisibility(0);
                float abs = Math.abs(f) / this.n;
                this.f3144c.setVisibility(0);
                this.f3144c.setAlpha(1.0f - abs);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z) {
        try {
            if (!this.h) {
                float[] fArr = new float[2];
                fArr[0] = ((WindowManager.LayoutParams) this.d.getLayoutParams()).y;
                fArr[1] = z ? 0.0f : -this.n;
                ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
                ofFloat.setDuration(300L);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fotoable.youtube.music.quicktools.views.QuickToolsView.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (QuickToolsView.this.d != null) {
                            QuickToolsView.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    }
                });
                ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.fotoable.youtube.music.quicktools.views.QuickToolsView.5
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        QuickToolsView.this.h = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        QuickToolsView.this.h = false;
                        if (QuickToolsView.this.g && !z) {
                            FlurryAgent.endTimedEvent("进入底部工具栏时间");
                        }
                        if (QuickToolsView.this.g || z) {
                        }
                        QuickToolsView.this.g = z;
                        try {
                            if (z) {
                                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) QuickToolsView.this.getLayoutParams();
                                layoutParams.flags = 1056;
                                QuickToolsView.this.f3143b.updateViewLayout(QuickToolsView.this, layoutParams);
                                QuickToolsView.this.f3144c.setAlpha(1.0f);
                                QuickToolsView.this.f3144c.setVisibility(0);
                                QuickToolsView.this.d.setVisibility(0);
                                QuickToolsView.this.d.h();
                            } else {
                                WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) QuickToolsView.this.getLayoutParams();
                                layoutParams2.flags = 1064;
                                QuickToolsView.this.f3143b.updateViewLayout(QuickToolsView.this, layoutParams2);
                                QuickToolsView.this.f3144c.setAlpha(0.0f);
                                QuickToolsView.this.f3144c.setVisibility(8);
                                QuickToolsView.this.d.setVisibility(8);
                            }
                        } catch (Exception e) {
                            ThrowableExtension.printStackTrace(e);
                        }
                    }
                });
                ofFloat.start();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            i();
            getContext().registerReceiver(this.r, this.q);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f = false;
        this.e = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        try {
            if (this.r != null) {
                getContext().unregisterReceiver(this.r);
            }
            j();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        super.onDetachedFromWindow();
    }

    private void i() {
        if (this.p != null && !this.p.isUnsubscribed()) {
            this.p.unsubscribe();
        }
    }

    private void j() {
        if (this.p != null && !this.p.isUnsubscribed()) {
            this.p.unsubscribe();
        }
    }

    public boolean c() {
        return this.f;
    }

    public void d() {
        if (this.g) {
            a(false);
        }
    }

    public void a(PlayerInfo playerInfo) {
        if (this.g) {
            this.d.a(playerInfo, true);
        } else {
            this.d.setMusicData(playerInfo);
        }
    }
}
