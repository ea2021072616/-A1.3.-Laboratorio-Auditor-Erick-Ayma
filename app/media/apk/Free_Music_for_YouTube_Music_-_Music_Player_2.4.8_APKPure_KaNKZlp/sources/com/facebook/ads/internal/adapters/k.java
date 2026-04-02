package com.facebook.ads.internal.adapters;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.j;
import com.facebook.ads.internal.view.d;
import com.facebook.ads.internal.view.d.b.a;
import com.facebook.ads.internal.view.d.b.d;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.MimeTypes;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends i implements View.OnTouchListener, com.facebook.ads.internal.view.d {
    static final /* synthetic */ boolean h;
    @Nullable
    private d.a i;
    @Nullable
    private Activity j;
    private com.facebook.ads.internal.view.c.a n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private a.C0043a r;
    private com.facebook.ads.internal.view.d.b.o s;
    private ViewGroup t;
    private com.facebook.ads.internal.view.d.b.d u;
    private com.facebook.ads.internal.view.d.b.i v;
    final int e = 64;
    final int f = 64;
    final int g = 16;
    private AudienceNetworkActivity.BackButtonInterceptor k = new AudienceNetworkActivity.BackButtonInterceptor() { // from class: com.facebook.ads.internal.adapters.k.1
        @Override // com.facebook.ads.AudienceNetworkActivity.BackButtonInterceptor
        public boolean interceptBackButton() {
            if (k.this.v == null) {
                return false;
            }
            if (k.this.v.a()) {
                if (k.this.v.getSkipSeconds() != 0 && k.this.f1188a != null) {
                    k.this.f1188a.f();
                }
                if (k.this.f1188a != null) {
                    k.this.f1188a.g();
                }
                k.this.j.finish();
                return false;
            }
            return true;
        }
    };
    private final View.OnTouchListener l = new View.OnTouchListener() { // from class: com.facebook.ads.internal.adapters.k.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (k.this.v == null) {
                    k.this.j.finish();
                } else if (k.this.v.a()) {
                    if (k.this.v.getSkipSeconds() != 0 && k.this.f1188a != null) {
                        k.this.f1188a.f();
                    }
                    if (k.this.f1188a != null) {
                        k.this.f1188a.g();
                    }
                    k.this.j.finish();
                }
            }
            return true;
        }
    };
    private j.a m = j.a.UNSPECIFIED;
    private int w = -1;
    private int x = -10525069;
    private int y = -12286980;
    private boolean z = false;

    static {
        h = !k.class.desiredAssertionStatus();
    }

    private void a(int i) {
        float f = this.f1190c.getResources().getDisplayMetrics().density;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (56.0f * f), (int) (56.0f * f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int i2 = (int) (16.0f * f);
        this.v.setPadding(i2, i2, i2, i2);
        this.v.setLayoutParams(layoutParams);
        d.a aVar = f() ? d.a.FADE_OUT_ON_PLAY : d.a.VISIBLE;
        int id = this.f1188a.getId();
        if (i == 1 && (k() || l())) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable.setCornerRadius(0.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(10);
            this.f1188a.setLayoutParams(layoutParams2);
            a(this.f1188a);
            a(this.v);
            a(this.r);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (((this.n != null ? 64 : 0) + 60 + 16 + 16 + 16) * f));
            layoutParams3.addRule(12);
            RelativeLayout relativeLayout = new RelativeLayout(this.f1190c);
            relativeLayout.setBackground(gradientDrawable);
            relativeLayout.setLayoutParams(layoutParams3);
            relativeLayout.setPadding(i2, 0, i2, (int) (((this.n != null ? 64 : 0) + 16 + 16) * f));
            this.t = relativeLayout;
            if (!this.z) {
                this.u.a(relativeLayout, aVar);
            }
            a(relativeLayout);
            if (this.s != null) {
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams4.addRule(12);
                layoutParams4.topMargin = (int) ((-6.0f) * f);
                this.s.setLayoutParams(layoutParams4);
                a(this.s);
            }
            if (this.n != null) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                layoutParams5.bottomMargin = (int) (16.0f * f);
                layoutParams5.leftMargin = (int) (16.0f * f);
                layoutParams5.rightMargin = (int) (16.0f * f);
                layoutParams5.addRule(14);
                layoutParams5.addRule(12);
                this.n.setLayoutParams(layoutParams5);
                a(this.n);
            }
            if (this.q != null) {
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams((int) (60.0f * f), (int) (60.0f * f));
                layoutParams6.addRule(12);
                layoutParams6.addRule(9);
                this.q.setLayoutParams(layoutParams6);
                a(relativeLayout, this.q);
            }
            if (this.o != null) {
                RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams7.bottomMargin = (int) (36.0f * f);
                layoutParams7.addRule(12);
                layoutParams7.addRule(9);
                this.o.setEllipsize(TextUtils.TruncateAt.END);
                this.o.setGravity(GravityCompat.START);
                this.o.setLayoutParams(layoutParams7);
                this.o.setMaxLines(1);
                this.o.setPadding((int) (72.0f * f), 0, 0, 0);
                this.o.setTextColor(-1);
                this.o.setTextSize(18.0f);
                a(relativeLayout, this.o);
            }
            if (this.p != null) {
                RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams8.addRule(12);
                layoutParams8.addRule(9);
                layoutParams8.bottomMargin = (int) (4.0f * f);
                this.p.setEllipsize(TextUtils.TruncateAt.END);
                this.p.setGravity(GravityCompat.START);
                this.p.setLayoutParams(layoutParams8);
                this.p.setMaxLines(1);
                this.p.setPadding((int) (72.0f * f), 0, 0, 0);
                this.p.setTextColor(-1);
                a(relativeLayout, this.p);
            }
            ((ViewGroup) this.f1188a.getParent()).setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams9.addRule(10);
            this.f1188a.setLayoutParams(layoutParams9);
            a(this.f1188a);
            a(this.v);
            a(this.r);
            LinearLayout linearLayout = new LinearLayout(this.f1190c);
            this.t = linearLayout;
            linearLayout.setGravity(112);
            linearLayout.setOrientation(1);
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams10.leftMargin = (int) (33.0f * f);
            layoutParams10.rightMargin = (int) (33.0f * f);
            layoutParams10.topMargin = (int) (8.0f * f);
            if (this.n == null) {
                layoutParams10.bottomMargin = (int) (16.0f * f);
            } else {
                layoutParams10.bottomMargin = (int) (80.0f * f);
            }
            layoutParams10.addRule(3, id);
            linearLayout.setLayoutParams(layoutParams10);
            a(linearLayout);
            if (this.n != null) {
                RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                layoutParams11.bottomMargin = (int) (16.0f * f);
                layoutParams11.leftMargin = (int) (33.0f * f);
                layoutParams11.rightMargin = (int) (33.0f * f);
                layoutParams11.addRule(14);
                layoutParams11.addRule(12);
                this.n.setLayoutParams(layoutParams11);
                a(this.n);
            }
            if (this.o != null) {
                LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams12.weight = 2.0f;
                layoutParams12.gravity = 17;
                this.o.setEllipsize(TextUtils.TruncateAt.END);
                this.o.setGravity(17);
                this.o.setLayoutParams(layoutParams12);
                this.o.setMaxLines(2);
                this.o.setPadding(0, 0, 0, 0);
                this.o.setTextColor(this.x);
                this.o.setTextSize(24.0f);
                a(linearLayout, this.o);
            }
            if (this.q != null) {
                LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                layoutParams13.weight = 0.0f;
                layoutParams13.gravity = 17;
                this.q.setLayoutParams(layoutParams13);
                a(linearLayout, this.q);
            }
            if (this.p != null) {
                LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams14.weight = 2.0f;
                layoutParams14.gravity = 16;
                this.p.setEllipsize(TextUtils.TruncateAt.END);
                this.p.setGravity(16);
                this.p.setLayoutParams(layoutParams14);
                this.p.setMaxLines(2);
                this.p.setPadding(0, 0, 0, 0);
                this.p.setTextColor(this.x);
                a(linearLayout, this.p);
            }
            if (this.s != null) {
                RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams15.addRule(3, id);
                this.s.setLayoutParams(layoutParams15);
                a(this.s);
            }
            ((ViewGroup) this.f1188a.getParent()).setBackgroundColor(this.w);
        } else if (!m() || l()) {
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable2.setCornerRadius(0.0f);
            this.f1188a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            a(this.f1188a);
            a(this.v);
            a(this.r);
            RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-1, (int) (124.0f * f));
            layoutParams16.addRule(12);
            RelativeLayout relativeLayout2 = new RelativeLayout(this.f1190c);
            relativeLayout2.setBackground(gradientDrawable2);
            relativeLayout2.setLayoutParams(layoutParams16);
            relativeLayout2.setPadding(i2, 0, i2, i2);
            this.t = relativeLayout2;
            if (!this.z) {
                this.u.a(relativeLayout2, aVar);
            }
            a(relativeLayout2);
            if (this.n != null) {
                RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams((int) (110.0f * f), (int) (56.0f * f));
                layoutParams17.rightMargin = (int) (16.0f * f);
                layoutParams17.bottomMargin = (int) (16.0f * f);
                layoutParams17.addRule(12);
                layoutParams17.addRule(11);
                this.n.setLayoutParams(layoutParams17);
                a(this.n);
            }
            if (this.q != null) {
                RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                layoutParams18.addRule(12);
                layoutParams18.addRule(9);
                layoutParams18.bottomMargin = (int) (8.0f * f);
                this.q.setLayoutParams(layoutParams18);
                a(relativeLayout2, this.q);
            }
            if (this.o != null) {
                RelativeLayout.LayoutParams layoutParams19 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams19.bottomMargin = (int) (48.0f * f);
                layoutParams19.addRule(12);
                layoutParams19.addRule(9);
                this.o.setEllipsize(TextUtils.TruncateAt.END);
                this.o.setGravity(GravityCompat.START);
                this.o.setLayoutParams(layoutParams19);
                this.o.setMaxLines(1);
                this.o.setPadding((int) (80.0f * f), 0, this.n != null ? (int) (126.0f * f) : 0, 0);
                this.o.setTextColor(-1);
                this.o.setTextSize(24.0f);
                a(relativeLayout2, this.o);
            }
            if (this.p != null) {
                RelativeLayout.LayoutParams layoutParams20 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams20.addRule(12);
                layoutParams20.addRule(9);
                this.p.setEllipsize(TextUtils.TruncateAt.END);
                this.p.setGravity(GravityCompat.START);
                this.p.setLayoutParams(layoutParams20);
                this.p.setMaxLines(2);
                this.p.setTextColor(-1);
                this.p.setPadding((int) (80.0f * f), 0, this.n != null ? (int) (126.0f * f) : 0, 0);
                a(relativeLayout2, this.p);
            }
            if (this.s != null) {
                RelativeLayout.LayoutParams layoutParams21 = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams21.addRule(12);
                this.s.setLayoutParams(layoutParams21);
                a(this.s);
            }
            ((ViewGroup) this.f1188a.getParent()).setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams22.addRule(9);
            this.f1188a.setLayoutParams(layoutParams22);
            a(this.f1188a);
            a(this.v);
            a(this.r);
            LinearLayout linearLayout2 = new LinearLayout(this.f1190c);
            this.t = linearLayout2;
            linearLayout2.setGravity(112);
            linearLayout2.setOrientation(1);
            RelativeLayout.LayoutParams layoutParams23 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams23.leftMargin = (int) (16.0f * f);
            layoutParams23.rightMargin = (int) (16.0f * f);
            layoutParams23.topMargin = (int) (8.0f * f);
            layoutParams23.bottomMargin = (int) (80.0f * f);
            layoutParams23.addRule(1, id);
            linearLayout2.setLayoutParams(layoutParams23);
            a(linearLayout2);
            if (this.s != null) {
                RelativeLayout.LayoutParams layoutParams24 = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams24.addRule(5, id);
                layoutParams24.addRule(7, id);
                layoutParams24.addRule(3, id);
                layoutParams24.topMargin = (int) ((-6.0f) * f);
                this.s.setLayoutParams(layoutParams24);
                a(this.s);
            }
            if (this.o != null) {
                LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams25.weight = 2.0f;
                layoutParams25.gravity = 17;
                this.o.setEllipsize(TextUtils.TruncateAt.END);
                this.o.setGravity(17);
                this.o.setLayoutParams(layoutParams25);
                this.o.setMaxLines(10);
                this.o.setPadding(0, 0, 0, 0);
                this.o.setTextColor(this.x);
                this.o.setTextSize(24.0f);
                a(linearLayout2, this.o);
            }
            if (this.q != null) {
                LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                layoutParams26.weight = 0.0f;
                layoutParams26.gravity = 17;
                this.q.setLayoutParams(layoutParams26);
                a(linearLayout2, this.q);
            }
            if (this.p != null) {
                LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams27.weight = 2.0f;
                layoutParams27.gravity = 16;
                this.p.setEllipsize(TextUtils.TruncateAt.END);
                this.p.setGravity(17);
                this.p.setLayoutParams(layoutParams27);
                this.p.setMaxLines(10);
                this.p.setPadding(0, 0, 0, 0);
                this.p.setTextColor(this.x);
                a(linearLayout2, this.p);
            }
            if (this.n != null) {
                RelativeLayout.LayoutParams layoutParams28 = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                layoutParams28.bottomMargin = (int) (16.0f * f);
                layoutParams28.leftMargin = (int) (16.0f * f);
                layoutParams28.rightMargin = (int) (16.0f * f);
                layoutParams28.addRule(14);
                layoutParams28.addRule(12);
                layoutParams28.addRule(1, id);
                this.n.setLayoutParams(layoutParams28);
                a(this.n);
            }
            ((ViewGroup) this.f1188a.getParent()).setBackgroundColor(this.w);
        }
        View rootView = this.f1188a.getRootView();
        if (rootView != null) {
            rootView.setOnTouchListener(this);
        }
    }

    private void a(View view) {
        if (this.i == null) {
            return;
        }
        this.i.a(view);
    }

    private void a(@Nullable ViewGroup viewGroup, @Nullable View view) {
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
    }

    private void b(View view) {
        ViewGroup viewGroup;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    private boolean k() {
        return ((double) (this.f1188a.getVideoHeight() > 0 ? ((float) this.f1188a.getVideoWidth()) / ((float) this.f1188a.getVideoHeight()) : -1.0f)) <= 0.9d;
    }

    private boolean l() {
        if (this.f1188a.getVideoHeight() <= 0) {
            return false;
        }
        Rect rect = new Rect();
        float f = this.f1190c.getResources().getDisplayMetrics().density;
        this.j.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        if (rect.width() > rect.height()) {
            return ((float) (rect.width() - ((rect.height() * this.f1188a.getVideoWidth()) / this.f1188a.getVideoHeight()))) - (f * 192.0f) < 0.0f;
        }
        return ((((float) (rect.height() - ((rect.width() * this.f1188a.getVideoHeight()) / this.f1188a.getVideoWidth()))) - (64.0f * f)) - (64.0f * f)) - (f * 40.0f) < 0.0f;
    }

    private boolean m() {
        float videoWidth = this.f1188a.getVideoHeight() > 0 ? this.f1188a.getVideoWidth() / this.f1188a.getVideoHeight() : -1.0f;
        return ((double) videoWidth) > 0.9d && ((double) videoWidth) < 1.1d;
    }

    private void n() {
        b(this.f1188a);
        b(this.n);
        b(this.o);
        b(this.p);
        b(this.q);
        b(this.r);
        b(this.s);
        b(this.t);
        b(this.v);
    }

    @Override // com.facebook.ads.internal.adapters.i
    @TargetApi(17)
    protected void a() {
        String optString = this.f1189b.getJSONObject("context").optString("orientation");
        if (!optString.isEmpty()) {
            this.m = j.a.a(Integer.parseInt(optString));
        }
        if (this.f1189b.has(TtmlNode.TAG_LAYOUT) && !this.f1189b.isNull(TtmlNode.TAG_LAYOUT)) {
            JSONObject jSONObject = this.f1189b.getJSONObject(TtmlNode.TAG_LAYOUT);
            this.w = (int) jSONObject.optLong("bgColor", this.w);
            this.x = (int) jSONObject.optLong("textColor", this.x);
            this.y = (int) jSONObject.optLong("accentColor", this.y);
            this.z = jSONObject.optBoolean("persistentAdDetails", this.z);
        }
        JSONObject jSONObject2 = this.f1189b.getJSONObject(MimeTypes.BASE_TYPE_TEXT);
        this.f1188a.setId(View.generateViewId());
        int c2 = c();
        Context context = this.f1190c;
        if (c2 < 0) {
            c2 = 0;
        }
        this.v = new com.facebook.ads.internal.view.d.b.i(context, c2, this.y);
        this.v.setOnTouchListener(this.l);
        this.f1188a.a(this.v);
        if (this.f1189b.has("cta") && !this.f1189b.isNull("cta")) {
            JSONObject jSONObject3 = this.f1189b.getJSONObject("cta");
            this.n = new com.facebook.ads.internal.view.c.a(this.f1190c, jSONObject3.getString("url"), jSONObject3.getString(MimeTypes.BASE_TYPE_TEXT), this.y, this.f1188a);
        }
        if (this.f1189b.has("icon") && !this.f1189b.isNull("icon")) {
            JSONObject jSONObject4 = this.f1189b.getJSONObject("icon");
            this.q = new ImageView(this.f1190c);
            new com.facebook.ads.internal.util.p(this.q).a(jSONObject4.getString("url"));
        }
        if (this.f1189b.has(MessengerShareContentUtility.MEDIA_IMAGE) && !this.f1189b.isNull(MessengerShareContentUtility.MEDIA_IMAGE)) {
            JSONObject jSONObject5 = this.f1189b.getJSONObject(MessengerShareContentUtility.MEDIA_IMAGE);
            com.facebook.ads.internal.view.d.b.f fVar = new com.facebook.ads.internal.view.d.b.f(this.f1190c);
            this.f1188a.a(fVar);
            fVar.setImage(jSONObject5.getString("url"));
        }
        String optString2 = jSONObject2.optString("title");
        if (!optString2.isEmpty()) {
            this.o = new TextView(this.f1190c);
            this.o.setText(optString2);
            this.o.setTypeface(Typeface.defaultFromStyle(1));
        }
        String optString3 = jSONObject2.optString(MessengerShareContentUtility.SUBTITLE);
        if (!optString3.isEmpty()) {
            this.p = new TextView(this.f1190c);
            this.p.setText(optString3);
            this.p.setTextSize(16.0f);
        }
        this.s = new com.facebook.ads.internal.view.d.b.o(this.f1190c);
        this.f1188a.a(this.s);
        this.r = new a.C0043a(this.f1190c, "AdChoices", "http://m.facebook.com/ads/ad_choices", new float[]{0.0f, 0.0f, 8.0f, 0.0f}, this.f1189b.getString(UserDataStore.CITY));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        this.r.setLayoutParams(layoutParams);
        this.f1188a.a(new com.facebook.ads.internal.view.d.b.j(this.f1190c));
        com.facebook.ads.internal.view.d.b.k kVar = new com.facebook.ads.internal.view.d.b.k(this.f1190c);
        this.f1188a.a(kVar);
        d.a aVar = f() ? d.a.FADE_OUT_ON_PLAY : d.a.VISIBLE;
        this.f1188a.a(new com.facebook.ads.internal.view.d.b.d(kVar, aVar));
        this.u = new com.facebook.ads.internal.view.d.b.d(new RelativeLayout(this.f1190c), aVar);
        this.f1188a.a(this.u);
    }

    @Override // com.facebook.ads.internal.view.d
    @TargetApi(17)
    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        this.j = audienceNetworkActivity;
        if (!h && this.i == null) {
            throw new AssertionError();
        }
        audienceNetworkActivity.addBackButtonInterceptor(this.k);
        n();
        a(this.j.getResources().getConfiguration().orientation);
        if (f()) {
            d();
        } else {
            e();
        }
    }

    public void a(Configuration configuration) {
        n();
        a(configuration.orientation);
    }

    @Override // com.facebook.ads.internal.view.d
    public void a(Bundle bundle) {
    }

    @Override // com.facebook.ads.internal.view.d
    public void a(d.a aVar) {
        this.i = aVar;
    }

    protected boolean f() {
        if (h || this.f1189b != null) {
            try {
                return this.f1189b.getJSONObject("video").getBoolean(AudienceNetworkActivity.AUTOPLAY);
            } catch (Exception e) {
                Log.w(String.valueOf(k.class), "Invalid JSON", e);
                return true;
            }
        }
        throw new AssertionError();
    }

    @Override // com.facebook.ads.internal.view.d
    public void g() {
    }

    @Override // com.facebook.ads.internal.view.d
    public void h() {
    }

    public j.a i() {
        return this.m;
    }

    public void j() {
        if (this.j != null) {
            this.j.finish();
        }
    }

    @Override // com.facebook.ads.internal.adapters.i, com.facebook.ads.internal.adapters.AdAdapter
    public void onDestroy() {
        if (this.f1188a != null) {
            this.f1188a.g();
        }
        j.a(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f1188a != null) {
            this.f1188a.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) new com.facebook.ads.internal.view.d.a.s(view, motionEvent));
            return true;
        }
        return true;
    }
}
