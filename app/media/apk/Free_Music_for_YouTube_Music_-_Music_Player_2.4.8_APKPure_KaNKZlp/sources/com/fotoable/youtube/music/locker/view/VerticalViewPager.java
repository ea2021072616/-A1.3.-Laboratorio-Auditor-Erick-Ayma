package com.fotoable.youtube.music.locker.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes.dex */
public class VerticalViewPager extends ViewGroup {
    private boolean A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    private float F;
    private float G;
    private float H;
    private float I;
    private int J;
    private VelocityTracker K;
    private int L;
    private int M;
    private int N;
    private int O;
    private boolean P;
    private EdgeEffectCompat Q;
    private EdgeEffectCompat R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private ViewPager.OnPageChangeListener W;
    private ViewPager.OnPageChangeListener aa;
    private e ab;
    private ViewPager.PageTransformer ac;
    private Method ad;
    private int ae;
    private ArrayList<View> af;
    private final Runnable ah;
    private int ai;

    /* renamed from: b  reason: collision with root package name */
    private int f2808b;
    private final ArrayList<b> e;
    private final b f;
    private final Rect g;
    private PagerAdapter h;
    private int i;
    private int j;
    private Parcelable k;
    private ClassLoader l;
    private Scroller m;
    private f n;
    private int o;
    private Drawable p;
    private int q;
    private int r;
    private float s;
    private float t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2806a = {16842931};

    /* renamed from: c  reason: collision with root package name */
    private static final Comparator<b> f2807c = new Comparator<b>() { // from class: com.fotoable.youtube.music.locker.view.VerticalViewPager.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.f2811b - bVar2.f2811b;
        }
    };
    private static final Interpolator d = new Interpolator() { // from class: com.fotoable.youtube.music.locker.view.VerticalViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final g ag = new g();

    /* loaded from: classes.dex */
    interface a {
    }

    /* loaded from: classes.dex */
    interface e {
        void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        Object f2810a;

        /* renamed from: b  reason: collision with root package name */
        int f2811b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2812c;
        float d;
        float e;

        b() {
        }
    }

    public VerticalViewPager(Context context) {
        super(context);
        this.e = new ArrayList<>();
        this.f = new b();
        this.g = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.s = -3.4028235E38f;
        this.t = Float.MAX_VALUE;
        this.z = 1;
        this.J = -1;
        this.S = true;
        this.T = false;
        this.ah = new Runnable() { // from class: com.fotoable.youtube.music.locker.view.VerticalViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                VerticalViewPager.this.setScrollState(0);
                VerticalViewPager.this.c();
            }
        };
        this.ai = 0;
        a();
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ArrayList<>();
        this.f = new b();
        this.g = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.s = -3.4028235E38f;
        this.t = Float.MAX_VALUE;
        this.z = 1;
        this.J = -1;
        this.S = true;
        this.T = false;
        this.ah = new Runnable() { // from class: com.fotoable.youtube.music.locker.view.VerticalViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                VerticalViewPager.this.setScrollState(0);
                VerticalViewPager.this.c();
            }
        };
        this.ai = 0;
        a();
    }

    void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.E = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.L = (int) (400.0f * f2);
        this.M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Q = new EdgeEffectCompat(context);
        this.R = new EdgeEffectCompat(context);
        this.N = (int) (120.0f * f2);
        this.O = (int) (2.0f * f2);
        this.C = (int) (16.0f * f2);
        ViewCompat.setAccessibilityDelegate(this, new d());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.ah);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.ai != i) {
            this.ai = i;
            if (this.ac != null) {
                b(i != 0);
            }
            if (this.W != null) {
                this.W.onPageScrollStateChanged(i);
            }
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.h != null) {
            this.h.unregisterDataSetObserver(this.n);
            this.h.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.e.size(); i++) {
                b bVar = this.e.get(i);
                this.h.destroyItem((ViewGroup) this, bVar.f2811b, bVar.f2810a);
            }
            this.h.finishUpdate((ViewGroup) this);
            this.e.clear();
            g();
            this.i = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.h;
        this.h = pagerAdapter;
        this.f2808b = 0;
        if (this.h != null) {
            if (this.n == null) {
                this.n = new f();
            }
            this.h.registerDataSetObserver(this.n);
            this.y = false;
            boolean z = this.S;
            this.S = true;
            this.f2808b = this.h.getCount();
            if (this.j >= 0) {
                this.h.restoreState(this.k, this.l);
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (!z) {
                c();
            } else {
                requestLayout();
            }
        }
        if (this.ab != null && pagerAdapter2 != pagerAdapter) {
            this.ab.a(pagerAdapter2, pagerAdapter);
        }
    }

    private void g() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (!((c) getChildAt(i2).getLayoutParams()).f2813a) {
                    removeViewAt(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public PagerAdapter getAdapter() {
        return this.h;
    }

    void setOnAdapterChangeListener(e eVar) {
        this.ab = eVar;
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public void setCurrentItem(int i) {
        this.y = false;
        a(i, !this.S, false);
    }

    public void a(int i, boolean z) {
        this.y = false;
        a(i, z, false);
    }

    public int getCurrentItem() {
        return this.i;
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        if (this.h == null || this.h.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (!z2 && this.i == i && this.e.size() != 0) {
            setScrollingCacheEnabled(false);
        } else {
            if (i < 0) {
                i = 0;
            } else if (i >= this.h.getCount()) {
                i = this.h.getCount() - 1;
            }
            int i3 = this.z;
            if (i > this.i + i3 || i < this.i - i3) {
                for (int i4 = 0; i4 < this.e.size(); i4++) {
                    this.e.get(i4).f2812c = true;
                }
            }
            boolean z3 = this.i != i;
            if (this.S) {
                this.i = i;
                if (z3 && this.W != null) {
                    this.W.onPageSelected(i);
                }
                if (z3 && this.aa != null) {
                    this.aa.onPageSelected(i);
                }
                requestLayout();
                return;
            }
            a(i);
            a(i, z, i2, z3);
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int i3;
        b b2 = b(i);
        if (b2 != null) {
            i3 = (int) (Math.max(this.s, Math.min(b2.e, this.t)) * getClientHeight());
        } else {
            i3 = 0;
        }
        if (z) {
            a(0, i3, i2);
            if (z2 && this.W != null) {
                this.W.onPageSelected(i);
            }
            if (z2 && this.aa != null) {
                this.aa.onPageSelected(i);
                return;
            }
            return;
        }
        if (z2 && this.W != null) {
            this.W.onPageSelected(i);
        }
        if (z2 && this.aa != null) {
            this.aa.onPageSelected(i);
        }
        a(false);
        scrollTo(0, i3);
        e(i3);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.W = onPageChangeListener;
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.ad == null) {
                try {
                    this.ad = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e2) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e2);
                }
            }
            try {
                this.ad.invoke(this, Boolean.valueOf(z));
            } catch (Exception e3) {
                Log.e("ViewPager", "Error changing children drawing order", e3);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ae == 2) {
            i2 = (i - 1) - i2;
        }
        return ((c) this.af.get(i2).getLayoutParams()).f;
    }

    public int getOffscreenPageLimit() {
        return this.z;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.z) {
            this.z = i;
            c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.o;
        this.o = i;
        int height = getHeight();
        a(height, height, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.o;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float a(float f2) {
        return (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d));
    }

    void a(int i, int i2, int i3) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            a(false);
            c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i6 = clientHeight / 2;
        float a2 = (i6 * a(Math.min(1.0f, (Math.abs(i4) * 1.0f) / clientHeight))) + i6;
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(1000.0f * Math.abs(a2 / abs2)) * 4;
        } else {
            abs = (int) (((Math.abs(i4) / ((clientHeight * this.h.getPageWidth(this.i)) + this.o)) + 1.0f) * 100.0f);
        }
        this.m.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, (int) IjkMediaCodecInfo.RANK_LAST_CHANCE));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    b a(int i, int i2) {
        b bVar = new b();
        bVar.f2811b = i;
        bVar.f2810a = this.h.instantiateItem((ViewGroup) this, i);
        bVar.d = this.h.getPageWidth(i);
        if (i2 < 0 || i2 >= this.e.size()) {
            this.e.add(bVar);
        } else {
            this.e.add(i2, bVar);
        }
        return bVar;
    }

    void b() {
        int i;
        boolean z;
        int i2;
        boolean z2;
        int count = this.h.getCount();
        this.f2808b = count;
        boolean z3 = this.e.size() < (this.z * 2) + 1 && this.e.size() < count;
        boolean z4 = false;
        int i3 = this.i;
        boolean z5 = z3;
        int i4 = 0;
        while (i4 < this.e.size()) {
            b bVar = this.e.get(i4);
            int itemPosition = this.h.getItemPosition(bVar.f2810a);
            if (itemPosition == -1) {
                i = i4;
                z = z4;
                i2 = i3;
                z2 = z5;
            } else if (itemPosition == -2) {
                this.e.remove(i4);
                int i5 = i4 - 1;
                if (!z4) {
                    this.h.startUpdate((ViewGroup) this);
                    z4 = true;
                }
                this.h.destroyItem((ViewGroup) this, bVar.f2811b, bVar.f2810a);
                if (this.i == bVar.f2811b) {
                    i = i5;
                    z = z4;
                    i2 = Math.max(0, Math.min(this.i, count - 1));
                    z2 = true;
                } else {
                    i = i5;
                    z = z4;
                    i2 = i3;
                    z2 = true;
                }
            } else if (bVar.f2811b != itemPosition) {
                if (bVar.f2811b == this.i) {
                    i3 = itemPosition;
                }
                bVar.f2811b = itemPosition;
                i = i4;
                z = z4;
                i2 = i3;
                z2 = true;
            } else {
                i = i4;
                z = z4;
                i2 = i3;
                z2 = z5;
            }
            z5 = z2;
            i3 = i2;
            z4 = z;
            i4 = i + 1;
        }
        if (z4) {
            this.h.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.e, f2807c);
        if (z5) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                c cVar = (c) getChildAt(i6).getLayoutParams();
                if (!cVar.f2813a) {
                    cVar.f2815c = 0.0f;
                }
            }
            a(i3, false, true);
            requestLayout();
        }
    }

    void c() {
        a(this.i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ff, code lost:
        if (r2.f2811b == r18.i) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(int r19) {
        /*
            Method dump skipped, instructions count: 835
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fotoable.youtube.music.locker.view.VerticalViewPager.a(int):void");
    }

    private void h() {
        if (this.ae != 0) {
            if (this.af == null) {
                this.af = new ArrayList<>();
            } else {
                this.af.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.af.add(getChildAt(i));
            }
            Collections.sort(this.af, ag);
        }
    }

    private void a(b bVar, int i, b bVar2) {
        b bVar3;
        b bVar4;
        int count = this.h.getCount();
        int clientHeight = getClientHeight();
        float f2 = clientHeight > 0 ? this.o / clientHeight : 0.0f;
        if (bVar2 != null) {
            int i2 = bVar2.f2811b;
            if (i2 < bVar.f2811b) {
                float f3 = bVar2.e + bVar2.d + f2;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= bVar.f2811b && i4 < this.e.size()) {
                    b bVar5 = this.e.get(i4);
                    while (true) {
                        bVar4 = bVar5;
                        if (i3 <= bVar4.f2811b || i4 >= this.e.size() - 1) {
                            break;
                        }
                        i4++;
                        bVar5 = this.e.get(i4);
                    }
                    while (i3 < bVar4.f2811b) {
                        f3 += this.h.getPageWidth(i3) + f2;
                        i3++;
                    }
                    bVar4.e = f3;
                    f3 += bVar4.d + f2;
                    i3++;
                }
            } else if (i2 > bVar.f2811b) {
                int size = this.e.size() - 1;
                float f4 = bVar2.e;
                int i5 = i2 - 1;
                while (i5 >= bVar.f2811b && size >= 0) {
                    b bVar6 = this.e.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i5 >= bVar3.f2811b || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.e.get(size);
                    }
                    while (i5 > bVar3.f2811b) {
                        f4 -= this.h.getPageWidth(i5) + f2;
                        i5--;
                    }
                    f4 -= bVar3.d + f2;
                    bVar3.e = f4;
                    i5--;
                }
            }
        }
        int size2 = this.e.size();
        float f5 = bVar.e;
        int i6 = bVar.f2811b - 1;
        this.s = bVar.f2811b == 0 ? bVar.e : -3.4028235E38f;
        this.t = bVar.f2811b == count + (-1) ? (bVar.e + bVar.d) - 1.0f : Float.MAX_VALUE;
        for (int i7 = i - 1; i7 >= 0; i7--) {
            b bVar7 = this.e.get(i7);
            float f6 = f5;
            while (i6 > bVar7.f2811b) {
                f6 -= this.h.getPageWidth(i6) + f2;
                i6--;
            }
            f5 = f6 - (bVar7.d + f2);
            bVar7.e = f5;
            if (bVar7.f2811b == 0) {
                this.s = f5;
            }
            i6--;
        }
        float f7 = bVar.e + bVar.d + f2;
        int i8 = bVar.f2811b + 1;
        for (int i9 = i + 1; i9 < size2; i9++) {
            b bVar8 = this.e.get(i9);
            float f8 = f7;
            while (i8 < bVar8.f2811b) {
                f8 = this.h.getPageWidth(i8) + f2 + f8;
                i8++;
            }
            if (bVar8.f2811b == count - 1) {
                this.t = (bVar8.d + f8) - 1.0f;
            }
            bVar8.e = f8;
            f7 = f8 + bVar8.d + f2;
            i8++;
        }
        this.T = false;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: com.fotoable.youtube.music.locker.view.VerticalViewPager.SavedState.1
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.i;
        if (this.h != null) {
            savedState.adapterState = this.h.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.h != null) {
            this.h.restoreState(savedState.adapterState, savedState.loader);
            a(savedState.position, false, true);
            return;
        }
        this.j = savedState.position;
        this.k = savedState.adapterState;
        this.l = savedState.loader;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        c cVar = (c) generateLayoutParams;
        cVar.f2813a |= view instanceof a;
        if (this.w) {
            if (cVar != null && cVar.f2813a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            cVar.d = true;
            addViewInLayout(view, i, generateLayoutParams);
            return;
        }
        super.addView(view, i, generateLayoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    b a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                b bVar = this.e.get(i2);
                if (!this.h.isViewFromObject(view, bVar.f2810a)) {
                    i = i2 + 1;
                } else {
                    return bVar;
                }
            } else {
                return null;
            }
        }
    }

    b b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return a(view);
            }
        }
        return null;
    }

    b b(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.e.size()) {
                b bVar = this.e.get(i3);
                if (bVar.f2811b != i) {
                    i2 = i3 + 1;
                } else {
                    return bVar;
                }
            } else {
                return null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.S = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fotoable.youtube.music.locker.view.VerticalViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            a(i2, i4, this.o, this.o);
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.e.isEmpty()) {
            int paddingTop = (int) ((((i - getPaddingTop()) - getPaddingBottom()) + i3) * (getScrollY() / (((i2 - getPaddingTop()) - getPaddingBottom()) + i4)));
            scrollTo(getScrollX(), paddingTop);
            if (!this.m.isFinished()) {
                this.m.startScroll(0, paddingTop, 0, (int) (b(this.i).e * i), this.m.getDuration() - this.m.timePassed());
                return;
            }
            return;
        }
        b b2 = b(this.i);
        int min = (int) ((b2 != null ? Math.min(b2.e, this.t) : 0.0f) * ((i - getPaddingTop()) - getPaddingBottom()));
        if (min != getScrollY()) {
            a(false);
            scrollTo(getScrollX(), min);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b a2;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int i8;
        int i9;
        int childCount = getChildCount();
        int i10 = i3 - i;
        int i11 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i12 = 0;
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2813a) {
                    int i14 = cVar.f2814b & 7;
                    int i15 = cVar.f2814b & 112;
                    switch (i14) {
                        case 1:
                            i7 = Math.max((i10 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            i7 = paddingLeft;
                            break;
                        case 3:
                            i7 = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            int measuredWidth = (i10 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            i7 = measuredWidth;
                            break;
                    }
                    switch (i15) {
                        case 16:
                            measuredHeight = Math.max((i11 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            int i16 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i16;
                            break;
                        case 48:
                            int measuredHeight2 = childAt.getMeasuredHeight() + paddingTop;
                            int i17 = paddingTop;
                            i9 = paddingBottom;
                            i8 = measuredHeight2;
                            measuredHeight = i17;
                            break;
                        case 80:
                            measuredHeight = (i11 - paddingBottom) - childAt.getMeasuredHeight();
                            int measuredHeight3 = paddingBottom + childAt.getMeasuredHeight();
                            i8 = paddingTop;
                            i9 = measuredHeight3;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            int i18 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i18;
                            break;
                    }
                    int i19 = measuredHeight + scrollY;
                    childAt.layout(i7, i19, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + i19);
                    i5 = i12 + 1;
                    i6 = i8;
                    paddingBottom = i9;
                    i13++;
                    paddingLeft = paddingLeft;
                    paddingRight = paddingRight;
                    paddingTop = i6;
                    i12 = i5;
                }
            }
            i5 = i12;
            i6 = paddingTop;
            i13++;
            paddingLeft = paddingLeft;
            paddingRight = paddingRight;
            paddingTop = i6;
            i12 = i5;
        }
        int i20 = (i11 - paddingTop) - paddingBottom;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f2813a && (a2 = a(childAt2)) != null) {
                    int i22 = ((int) (a2.e * i20)) + paddingTop;
                    if (cVar2.d) {
                        cVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i10 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (cVar2.f2815c * i20), 1073741824));
                    }
                    childAt2.layout(paddingLeft, i22, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i22);
                }
            }
        }
        this.q = paddingLeft;
        this.r = i10 - paddingRight;
        this.V = i12;
        if (this.S) {
            a(this.i, false, 0, false);
        }
        this.S = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.m.isFinished() && this.m.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.m.getCurrX();
            int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!e(currY)) {
                    this.m.abortAnimation();
                    scrollTo(currX, 0);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        a(true);
    }

    private boolean e(int i) {
        if (this.e.size() == 0) {
            this.U = false;
            a(0, 0.0f, 0);
            if (this.U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b i2 = i();
        int clientHeight = getClientHeight();
        int i3 = this.o + clientHeight;
        float f2 = this.o / clientHeight;
        int i4 = i2.f2811b;
        float f3 = ((i / clientHeight) - i2.e) / (i2.d + f2);
        this.U = false;
        a(i4, f3, (int) (i3 * f3));
        if (!this.U) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return true;
    }

    protected void a(int i, float f2, int i2) {
        int measuredHeight;
        int i3;
        int i4;
        if (this.V > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2813a) {
                    switch (cVar.f2814b & 112) {
                        case 16:
                            measuredHeight = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                            int i6 = paddingBottom;
                            i3 = paddingTop;
                            i4 = i6;
                            break;
                        case 48:
                            int height2 = childAt.getHeight() + paddingTop;
                            int i7 = paddingTop;
                            i4 = paddingBottom;
                            i3 = height2;
                            measuredHeight = i7;
                            break;
                        case 80:
                            measuredHeight = (height - paddingBottom) - childAt.getMeasuredHeight();
                            int measuredHeight2 = paddingBottom + childAt.getMeasuredHeight();
                            i3 = paddingTop;
                            i4 = measuredHeight2;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            int i8 = paddingBottom;
                            i3 = paddingTop;
                            i4 = i8;
                            break;
                    }
                    int top = (measuredHeight + scrollY) - childAt.getTop();
                    if (top != 0) {
                        childAt.offsetTopAndBottom(top);
                    }
                } else {
                    int i9 = paddingBottom;
                    i3 = paddingTop;
                    i4 = i9;
                }
                i5++;
                int i10 = i4;
                paddingTop = i3;
                paddingBottom = i10;
            }
        }
        if (this.W != null) {
            this.W.onPageScrolled(i, f2, i2);
        }
        if (this.aa != null) {
            this.aa.onPageScrolled(i, f2, i2);
        }
        if (this.ac != null) {
            int scrollY2 = getScrollY();
            int childCount2 = getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = getChildAt(i11);
                if (!((c) childAt2.getLayoutParams()).f2813a) {
                    this.ac.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                }
            }
        }
        this.U = true;
    }

    private void a(boolean z) {
        boolean z2 = this.ai == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.m.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.m.getCurrX();
            int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.y = false;
        boolean z3 = z2;
        for (int i = 0; i < this.e.size(); i++) {
            b bVar = this.e.get(i);
            if (bVar.f2812c) {
                bVar.f2812c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.ah);
            } else {
                this.ah.run();
            }
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.D) && f3 > 0.0f) || (f2 > ((float) (getHeight() - this.D)) && f3 < 0.0f);
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.setLayerType(getChildAt(i), z ? 2 : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.A = false;
            this.B = false;
            this.J = -1;
            if (this.K != null) {
                this.K.recycle();
                this.K = null;
                return false;
            }
            return false;
        }
        if (action != 0) {
            if (this.A) {
                return true;
            }
            if (this.B) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.H = x;
                this.F = x;
                float y = motionEvent.getY();
                this.I = y;
                this.G = y;
                this.J = MotionEventCompat.getPointerId(motionEvent, 0);
                this.B = false;
                this.m.computeScrollOffset();
                if (this.ai == 2 && Math.abs(this.m.getFinalY() - this.m.getCurrY()) > this.O) {
                    this.m.abortAnimation();
                    this.y = false;
                    c();
                    this.A = true;
                    c(true);
                    setScrollState(1);
                    break;
                } else {
                    a(false);
                    this.A = false;
                    break;
                }
                break;
            case 2:
                int i = this.J;
                if (i != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    float f2 = y2 - this.G;
                    float abs = Math.abs(f2);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(x2 - this.H);
                    if (f2 != 0.0f && !a(this.G, f2) && a(this, false, (int) f2, (int) x2, (int) y2)) {
                        this.F = x2;
                        this.G = y2;
                        this.B = true;
                        return false;
                    }
                    if (abs > this.E && 0.5f * abs > abs2) {
                        this.A = true;
                        c(true);
                        setScrollState(1);
                        this.G = f2 > 0.0f ? this.I + this.E : this.I - this.E;
                        this.F = x2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.E) {
                        this.B = true;
                    }
                    if (this.A && b(y2)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                        break;
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        return this.A;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f2;
        boolean z = false;
        if (this.P) {
            return true;
        }
        if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
            if (this.h == null || this.h.getCount() == 0) {
                return false;
            }
            if (this.K == null) {
                this.K = VelocityTracker.obtain();
            }
            this.K.addMovement(motionEvent);
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.m.abortAnimation();
                    this.y = false;
                    c();
                    float x = motionEvent.getX();
                    this.H = x;
                    this.F = x;
                    float y = motionEvent.getY();
                    this.I = y;
                    this.G = y;
                    this.J = MotionEventCompat.getPointerId(motionEvent, 0);
                    break;
                case 1:
                    if (this.A) {
                        VelocityTracker velocityTracker = this.K;
                        velocityTracker.computeCurrentVelocity(1000, this.M);
                        int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.J);
                        this.y = true;
                        int clientHeight = getClientHeight();
                        int scrollY = getScrollY();
                        b i = i();
                        a(a(i.f2811b, ((scrollY / clientHeight) - i.e) / i.d, yVelocity, (int) (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.J)) - this.I)), true, true, yVelocity);
                        this.J = -1;
                        j();
                        z = this.Q.onRelease() | this.R.onRelease();
                        break;
                    }
                    break;
                case 2:
                    if (!this.A) {
                        try {
                            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.J);
                            float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                            float abs = Math.abs(y2 - this.G);
                            float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                            float abs2 = Math.abs(x2 - this.F);
                            if (abs > this.E && abs > abs2) {
                                this.A = true;
                                c(true);
                                if (y2 - this.I > 0.0f) {
                                    f2 = this.I + this.E;
                                } else {
                                    f2 = this.I - this.E;
                                }
                                this.G = f2;
                                this.F = x2;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        } catch (Exception e2) {
                            ThrowableExtension.printStackTrace(e2);
                        }
                    }
                    if (this.A) {
                        z = false | b(MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.J)));
                        break;
                    }
                    break;
                case 3:
                    if (this.A) {
                        a(this.i, true, 0, false);
                        this.J = -1;
                        j();
                        z = this.Q.onRelease() | this.R.onRelease();
                        break;
                    }
                    break;
                case 5:
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.G = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.J = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    break;
                case 6:
                    a(motionEvent);
                    this.G = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.J));
                    break;
            }
            if (z) {
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
            return true;
        }
        return false;
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean b(float f2) {
        boolean z;
        float f3;
        boolean z2 = true;
        this.G = f2;
        float scrollY = getScrollY() + (this.G - f2);
        int clientHeight = getClientHeight();
        float f4 = clientHeight * this.s;
        float f5 = clientHeight * this.t;
        b bVar = this.e.get(0);
        b bVar2 = this.e.get(this.e.size() - 1);
        if (bVar.f2811b != 0) {
            f4 = bVar.e * clientHeight;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f2811b != this.h.getCount() - 1) {
            f3 = bVar2.e * clientHeight;
            z2 = false;
        } else {
            f3 = f5;
        }
        if (scrollY < f4) {
            if (z) {
                r2 = this.Q.onPull(Math.abs(f4 - scrollY) / clientHeight);
            }
        } else if (scrollY > f3) {
            r2 = z2 ? this.R.onPull(Math.abs(scrollY - f3) / clientHeight) : false;
            f4 = f3;
        } else {
            f4 = scrollY;
        }
        this.F += f4 - ((int) f4);
        scrollTo(getScrollX(), (int) f4);
        e((int) f4);
        return r2;
    }

    private b i() {
        int i;
        b bVar;
        int clientHeight = getClientHeight();
        float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
        float f2 = clientHeight > 0 ? this.o / clientHeight : 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        b bVar2 = null;
        while (i3 < this.e.size()) {
            b bVar3 = this.e.get(i3);
            if (z || bVar3.f2811b == i2 + 1) {
                i = i3;
                bVar = bVar3;
            } else {
                b bVar4 = this.f;
                bVar4.e = f3 + f4 + f2;
                bVar4.f2811b = i2 + 1;
                bVar4.d = this.h.getPageWidth(bVar4.f2811b);
                i = i3 - 1;
                bVar = bVar4;
            }
            float f5 = bVar.e;
            float f6 = bVar.d + f5 + f2;
            if (z || scrollY >= f5) {
                if (scrollY < f6 || i == this.e.size() - 1) {
                    return bVar;
                }
                f4 = f5;
                i2 = bVar.f2811b;
                z = false;
                f3 = bVar.d;
                bVar2 = bVar;
                i3 = i + 1;
            } else {
                return bVar2;
            }
        }
        return bVar2;
    }

    private int a(int i, float f2, int i2, int i3) {
        if (Math.abs(i3) > this.N && Math.abs(i2) > this.L) {
            if (i2 <= 0) {
                i++;
            }
        } else {
            i = (int) ((i >= this.i ? 0.4f : 0.6f) + i + f2);
        }
        if (this.e.size() > 0) {
            return Math.max(this.e.get(0).f2811b, Math.min(i, this.e.get(this.e.size() - 1).f2811b));
        }
        return i;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == 0 || (overScrollMode == 1 && this.h != null && this.h.getCount() > 1)) {
            if (!this.Q.isFinished()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), this.s * height);
                this.Q.setSize(width, height);
                z = false | this.Q.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.R.isFinished()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((-width2) - getPaddingLeft(), (-(this.t + 1.0f)) * height2);
                this.R.setSize(width2, height2);
                z |= this.R.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.Q.finish();
            this.R.finish();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        super.onDraw(canvas);
        if (this.o > 0 && this.p != null && this.e.size() > 0 && this.h != null) {
            int scrollY = getScrollY();
            int height = getHeight();
            float f3 = this.o / height;
            b bVar = this.e.get(0);
            float f4 = bVar.e;
            int size = this.e.size();
            int i = bVar.f2811b;
            int i2 = this.e.get(size - 1).f2811b;
            int i3 = 0;
            for (int i4 = i; i4 < i2; i4++) {
                while (i4 > bVar.f2811b && i3 < size) {
                    i3++;
                    bVar = this.e.get(i3);
                }
                if (i4 == bVar.f2811b) {
                    f2 = (bVar.e + bVar.d) * height;
                    f4 = bVar.e + bVar.d + f3;
                } else {
                    float pageWidth = this.h.getPageWidth(i4);
                    f2 = (f4 + pageWidth) * height;
                    f4 += pageWidth + f3;
                }
                if (this.o + f2 > scrollY) {
                    this.p.setBounds(this.q, (int) f2, this.r, (int) (this.o + f2 + 0.5f));
                    this.p.draw(canvas);
                }
                if (f2 > scrollY + height) {
                    return;
                }
            }
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.J) {
            int i = actionIndex == 0 ? 1 : 0;
            this.G = MotionEventCompat.getY(motionEvent, i);
            this.J = MotionEventCompat.getPointerId(motionEvent, i);
            if (this.K != null) {
                this.K.clear();
            }
        }
    }

    private void j() {
        this.A = false;
        this.B = false;
        if (this.K != null) {
            this.K.recycle();
            this.K = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.x != z) {
            this.x = z;
        }
    }

    public boolean c(int i) {
        if (this.h == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        if (i < 0) {
            return scrollY > ((int) (((float) clientHeight) * this.s));
        } else if (i > 0) {
            return scrollY < ((int) (((float) clientHeight) * this.t));
        } else {
            return false;
        }
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollVertically(view, -i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return d(17);
            case 22:
                return d(66);
            case 61:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (keyEvent.hasNoModifiers()) {
                    return d(2);
                }
                if (!keyEvent.hasModifiers(1)) {
                    return false;
                }
                return d(1);
            default:
                return false;
        }
    }

    public boolean d(int i) {
        View view;
        boolean z;
        boolean d2;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 33) {
                int i2 = a(this.g, findNextFocus).top;
                int i3 = a(this.g, view).top;
                if (view != null && i2 >= i3) {
                    d2 = d();
                } else {
                    d2 = findNextFocus.requestFocus();
                }
            } else {
                if (i == 130) {
                    int i4 = a(this.g, findNextFocus).bottom;
                    int i5 = a(this.g, view).bottom;
                    if (view != null && i4 <= i5) {
                        d2 = e();
                    } else {
                        d2 = findNextFocus.requestFocus();
                    }
                }
                d2 = false;
            }
        } else if (i == 33 || i == 1) {
            d2 = d();
        } else {
            if (i == 130 || i == 2) {
                d2 = e();
            }
            d2 = false;
        }
        if (d2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d2;
    }

    private Rect a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean d() {
        if (this.i > 0) {
            a(this.i - 1, true);
            return true;
        }
        return false;
    }

    boolean e() {
        if (this.h == null || this.i >= this.h.getCount() - 1) {
            return false;
        }
        a(this.i + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        b a2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f2811b == this.i) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
                arrayList.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        b a2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f2811b == this.i) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        b a2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f2811b == this.i && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b a2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f2811b == this.i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AccessibilityDelegateCompat {
        d() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(a());
            if (accessibilityEvent.getEventType() == 4096 && VerticalViewPager.this.h != null) {
                obtain.setItemCount(VerticalViewPager.this.h.getCount());
                obtain.setFromIndex(VerticalViewPager.this.i);
                obtain.setToIndex(VerticalViewPager.this.i);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(a());
            if (VerticalViewPager.this.c(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (VerticalViewPager.this.c(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (VerticalViewPager.this.c(1)) {
                        VerticalViewPager.this.setCurrentItem(VerticalViewPager.this.i + 1);
                        return true;
                    }
                    return false;
                case 8192:
                    if (VerticalViewPager.this.c(-1)) {
                        VerticalViewPager.this.setCurrentItem(VerticalViewPager.this.i - 1);
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }

        private boolean a() {
            return VerticalViewPager.this.h != null && VerticalViewPager.this.h.getCount() > 1;
        }
    }

    /* loaded from: classes.dex */
    private class f extends DataSetObserver {
        private f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            VerticalViewPager.this.b();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            VerticalViewPager.this.b();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2813a;

        /* renamed from: b  reason: collision with root package name */
        public int f2814b;

        /* renamed from: c  reason: collision with root package name */
        float f2815c;
        boolean d;
        int e;
        int f;

        public c() {
            super(-1, -1);
            this.f2815c = 0.0f;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2815c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.f2806a);
            this.f2814b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g implements Comparator<View> {
        g() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            if (cVar.f2813a != cVar2.f2813a) {
                return cVar.f2813a ? 1 : -1;
            }
            return cVar.e - cVar2.e;
        }
    }
}
