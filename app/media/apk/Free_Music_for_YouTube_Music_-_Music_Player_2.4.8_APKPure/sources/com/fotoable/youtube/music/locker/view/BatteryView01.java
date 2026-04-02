package com.fotoable.youtube.music.locker.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.v;
import com.fotoable.youtube.music.util.w;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import rx.m;
/* loaded from: classes.dex */
public class BatteryView01 extends FrameLayout {
    private LinearLayout A;
    private LinearLayout B;
    private ObjectAnimator C;
    private m D;

    /* renamed from: a  reason: collision with root package name */
    int f2767a;

    /* renamed from: b  reason: collision with root package name */
    int f2768b;

    /* renamed from: c  reason: collision with root package name */
    RelativeLayout f2769c;
    private LinearLayout d;
    private a e;
    private RelativeLayout f;
    private RelativeLayout g;
    private TextView h;
    private FrameLayout i;
    private float j;
    private float k;
    private boolean l;
    private boolean m;
    private LayoutInflater n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private ImageView t;
    private ImageView u;
    private ImageView v;
    private View w;
    private View x;
    private Animation y;
    private ImageView z;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    public BatteryView01(Context context) {
        super(context);
        this.e = null;
        this.f2767a = 118;
        this.f2768b = 17;
        this.j = 0.0f;
        this.k = 0.0f;
        this.m = false;
        e();
    }

    public BatteryView01(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = null;
        this.f2767a = 118;
        this.f2768b = 17;
        this.j = 0.0f;
        this.k = 0.0f;
        this.m = false;
        e();
    }

    public void setBatteryListener(a aVar) {
        this.e = aVar;
    }

    private void e() {
        this.n = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.n.inflate(R.layout.view_batteryview01, (ViewGroup) this, true);
        this.z = (ImageView) findViewById(R.id.charging);
        this.f = (RelativeLayout) findViewById(R.id.rl_noad_batteryview);
        this.g = (RelativeLayout) findViewById(R.id.rl_ad_batteryview);
        this.h = (TextView) findViewById(R.id.lblCurrentPower);
        this.o = (TextView) findViewById(R.id.tv_continuous_dis);
        this.p = (TextView) findViewById(R.id.tv_trickle_dis);
        this.i = (FrameLayout) findViewById(R.id.batteryProcessView);
        this.d = (LinearLayout) findViewById(R.id.ll_battery_blank);
        this.A = (LinearLayout) findViewById(R.id.ll_battery_charge_icons);
        this.B = (LinearLayout) findViewById(R.id.ll_battery_charge_text_panel);
        this.q = (ImageView) findViewById(R.id.iv_battery_stutas_01_loading);
        this.r = (ImageView) findViewById(R.id.iv_battery_stutas_02_loading);
        this.s = (ImageView) findViewById(R.id.iv_battery_stutas_03_loading);
        this.t = (ImageView) findViewById(R.id.iv_battery_stutas_03);
        this.u = (ImageView) findViewById(R.id.iv_battery_stutas_02);
        this.v = (ImageView) findViewById(R.id.iv_battery_stutas_01);
        this.w = findViewById(R.id.v_battery_status_line_01);
        this.x = findViewById(R.id.v_battery_status_line_02);
        a(v.a(getContext(), com.fotoable.youtube.music.b.p, false), v.a(getContext(), com.fotoable.youtube.music.b.o, 0), v.a(getContext(), com.fotoable.youtube.music.b.q, false));
        this.f2769c = (RelativeLayout) findViewById(R.id.ad_container);
        this.j = w.a(getContext(), this.f2767a);
        this.f2769c = (RelativeLayout) findViewById(R.id.ad_container);
        this.j = w.a(getContext(), this.f2767a);
    }

    public void a() {
        if (this.C != null) {
            this.C.cancel();
            this.C = null;
        }
        if (this.z.getVisibility() != 8) {
            this.z.setVisibility(8);
        }
    }

    public void b() {
        if (this.C == null || !this.C.isRunning()) {
            a();
            if (this.z.getVisibility() != 0) {
                this.z.setVisibility(0);
            }
            this.C = ObjectAnimator.ofFloat(this.z, "translationX", -this.z.getWidth(), (this.i.getWidth() * 1.0f) + this.z.getWidth());
            this.C.setInterpolator(new LinearInterpolator());
            this.C.setDuration(3500.0f * (this.i.getWidth() / this.j));
            this.C.setStartDelay(300L);
            this.C.setRepeatCount(0);
            this.C.addListener(new AnimatorListenerAdapter() { // from class: com.fotoable.youtube.music.locker.view.BatteryView01.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    try {
                        if (BatteryView01.this.C != null) {
                            BatteryView01.this.C.setFloatValues(-20.0f, (BatteryView01.this.i.getWidth() * 1.0f) + BatteryView01.this.z.getWidth());
                            BatteryView01.this.C.setDuration(3500.0f * (BatteryView01.this.i.getWidth() / BatteryView01.this.j));
                            BatteryView01.this.C.setStartDelay(300L);
                            BatteryView01.this.C.start();
                        }
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                }
            });
            this.C.start();
        }
    }

    public void c() {
    }

    public void a(boolean z, int i, boolean z2) {
        this.l = z;
        d();
        if (this.e != null && z && !this.m) {
            this.e.a();
            h.a("startAdTimer", "startAdTimer");
        }
        if (this.e != null && !z) {
            this.e.b();
            h.a("startAdTimer", "stopAdTimer");
        }
        this.j = w.a(getContext(), this.f2767a);
        this.k = w.a(getContext(), this.f2768b);
        b(z, i, z2);
        a(z, i);
    }

    public void d() {
    }

    private void a(boolean z, int i) {
        int[] iArr = {R.drawable.speed_charging, R.drawable.speed_full_charge, R.drawable.continuous_uncharge, R.drawable.continuous_charging, R.drawable.continuous_full_charge, R.drawable.trickle_uncharge, R.drawable.trickle_charging, R.drawable.trickle_full_charge, R.drawable.continuous_grey, R.drawable.trickle_grey};
        if (z) {
            if (i < 30) {
                this.w.setBackgroundColor(Color.argb(90, 255, 255, 255));
                this.x.setBackgroundColor(Color.argb(90, 255, 255, 255));
                this.o.setTextColor(Color.argb(90, 255, 255, 255));
                this.p.setTextColor(Color.argb(90, 255, 255, 255));
                this.v.setImageResource(iArr[0]);
                this.u.setImageResource(iArr[8]);
                this.t.setImageResource(iArr[9]);
                a(this.q);
                this.q.setVisibility(0);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                this.r.clearAnimation();
                this.s.clearAnimation();
            } else if (i >= 30 && i < 70) {
                this.w.setBackgroundColor(Color.argb(255, 255, 255, 255));
                this.x.setBackgroundColor(Color.argb(90, 255, 255, 255));
                this.o.setTextColor(-1);
                this.p.setTextColor(Color.argb(90, 255, 255, 255));
                this.v.setImageResource(iArr[1]);
                this.u.setImageResource(iArr[3]);
                this.t.setImageResource(iArr[9]);
                a(this.r);
                this.q.setVisibility(8);
                this.r.setVisibility(0);
                this.s.setVisibility(8);
                this.q.clearAnimation();
                this.s.clearAnimation();
            } else if (i >= 70 && i < 100) {
                this.w.setBackgroundColor(Color.argb(255, 255, 255, 255));
                this.x.setBackgroundColor(Color.argb(255, 255, 255, 255));
                this.o.setTextColor(-1);
                this.p.setTextColor(-1);
                this.v.setImageResource(iArr[1]);
                this.u.setImageResource(iArr[4]);
                this.t.setImageResource(iArr[6]);
                a(this.s);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(0);
                this.q.clearAnimation();
                this.r.clearAnimation();
            } else {
                this.w.setBackgroundColor(Color.argb(255, 255, 255, 255));
                this.x.setBackgroundColor(Color.argb(255, 255, 255, 255));
                this.o.setTextColor(-1);
                this.p.setTextColor(-1);
                this.v.setImageResource(iArr[1]);
                this.u.setImageResource(iArr[4]);
                this.t.setImageResource(iArr[7]);
                f();
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(0);
                this.q.clearAnimation();
                this.r.clearAnimation();
            }
        }
    }

    private void a(View view) {
        if (this.y == null) {
            this.y = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_battery_loading);
            this.y.setInterpolator(new LinearInterpolator());
        }
        view.clearAnimation();
        view.startAnimation(this.y);
    }

    private void f() {
        if (this.y != null) {
            this.y.cancel();
        }
    }

    private int a(int i) {
        int argb = Color.argb(255, 83, 194, 229);
        if (this.l) {
            return Color.argb(255, 68, 162, 42);
        }
        return argb;
    }

    private void b(boolean z, int i, boolean z2) {
        float f = (this.j * i) / 100.0f;
        float f2 = (this.k * i) / 100.0f;
        if (z2) {
            this.i.setVisibility(0);
            b bVar = new b(0, (int) f);
            bVar.setDuration(500L);
            this.i.startAnimation(bVar);
            new c(0, (int) f2);
            bVar.setDuration(500L);
            v.b(getContext(), com.fotoable.youtube.music.b.q, false);
        } else {
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            layoutParams.width = (int) f;
            this.i.setLayoutParams(layoutParams);
        }
        this.i.setBackgroundColor(a(i));
        this.h.setText(String.format("%d", Integer.valueOf(i)) + "");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        h.a("BatteryView01", "batteryview01 : onAttachedToWindow");
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        h.a("BatteryView01", "batteryview01 hasWindowFocus.............." + z);
        if (z) {
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            c();
            if (this.D != null && !this.D.isUnsubscribed()) {
                this.D.unsubscribe();
            }
            h.a("BatteryView01", "batteryview01 : onDetachedFromWindow");
            this.e = null;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Animation {

        /* renamed from: b  reason: collision with root package name */
        private final int f2772b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2773c;

        public b(int i, int i2) {
            this.f2772b = i;
            this.f2773c = i2 - i;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            ViewGroup.LayoutParams layoutParams = BatteryView01.this.i.getLayoutParams();
            layoutParams.width = (int) (this.f2772b + (this.f2773c * f));
            BatteryView01.this.i.setLayoutParams(layoutParams);
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends Animation {

        /* renamed from: b  reason: collision with root package name */
        private final int f2775b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2776c;

        public c(int i, int i2) {
            this.f2775b = i;
            this.f2776c = i2 - i;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h.a("onInterceptTouchEvent", motionEvent.getY() + "...last_y......");
        return super.onTouchEvent(motionEvent);
    }

    private void g() {
    }
}
