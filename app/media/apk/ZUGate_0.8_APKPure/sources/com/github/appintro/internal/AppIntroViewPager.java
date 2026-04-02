package com.github.appintro.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.viewpager.widget.g;
import androidx.viewpager.widget.l;
import com.github.appintro.AppIntroBase;
import com.github.appintro.AppIntroPageTransformerType;
import com.github.appintro.AppIntroViewPagerListener;
import com.github.appintro.internal.viewpager.ViewPagerTransformer;
import e4.e;
import j4.d;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class AppIntroViewPager extends l {
    private static final Companion Companion = new Companion(null);
    private static final int ON_ILLEGALLY_REQUESTED_NEXT_PAGE_MAX_INTERVAL = 1000;
    private float currentTouchDownX;
    private float currentTouchDownY;
    private ScrollerCustomDuration customScroller;
    private long illegallyRequestedNextPageLastCalled;
    private boolean isFullPagingEnabled;
    private boolean isPermissionSlide;
    private AppIntroViewPagerListener onNextPageRequestedListener;
    private g pageChangeListener;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(d dVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppIntroViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e.f(context, "context");
        e.f(attributeSet, "attrs");
        this.isFullPagingEnabled = true;
        try {
            Field declaredField = l.class.getDeclaredField("mScroller");
            e.e(declaredField, "scroller");
            declaredField.setAccessible(true);
            Field declaredField2 = l.class.getDeclaredField("sInterpolator");
            e.e(declaredField2, "interpolator");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(null);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.animation.Interpolator");
            }
            ScrollerCustomDuration scrollerCustomDuration = new ScrollerCustomDuration(context, (Interpolator) obj);
            this.customScroller = scrollerCustomDuration;
            declaredField.set(this, scrollerCustomDuration);
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        }
    }

    private final boolean handleTouchEvent(MotionEvent motionEvent) {
        AppIntroViewPagerListener appIntroViewPagerListener;
        AppIntroViewPagerListener appIntroViewPagerListener2;
        if (this.isFullPagingEnabled) {
            if (motionEvent.getAction() != 0) {
                if (motionEvent.getAction() == 1) {
                    performClick();
                }
                AppIntroViewPagerListener appIntroViewPagerListener3 = this.onNextPageRequestedListener;
                if (!(appIntroViewPagerListener3 != null ? appIntroViewPagerListener3.onCanRequestNextPage() : true) && isSwipeForward(this.currentTouchDownX, motionEvent.getX())) {
                    if (userIllegallyRequestNextPage() && (appIntroViewPagerListener2 = this.onNextPageRequestedListener) != null) {
                        appIntroViewPagerListener2.onIllegallyRequestedNextPage();
                    }
                    return false;
                } else if (this.isPermissionSlide && isSwipeForward(this.currentTouchDownX, motionEvent.getX()) && (appIntroViewPagerListener = this.onNextPageRequestedListener) != null) {
                    appIntroViewPagerListener.onUserRequestedPermissionsDialog();
                }
            } else {
                this.currentTouchDownX = motionEvent.getX();
                this.currentTouchDownY = motionEvent.getY();
            }
            return this.isFullPagingEnabled;
        }
        return false;
    }

    private final boolean isSwipeForward(float f5, float f6) {
        Context context = getContext();
        e.e(context, "context");
        if (LayoutUtil.isRtl(context)) {
            if (f6 > f5) {
                return true;
            }
        } else if (f5 > f6) {
            return true;
        }
        return false;
    }

    private final boolean userIllegallyRequestNextPage() {
        if (System.currentTimeMillis() - this.illegallyRequestedNextPageLastCalled >= ((long) ON_ILLEGALLY_REQUESTED_NEXT_PAGE_MAX_INTERVAL)) {
            this.illegallyRequestedNextPageLastCalled = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public final void addOnPageChangeListener$appintro_release(AppIntroBase.OnPageChangeListener onPageChangeListener) {
        e.f(onPageChangeListener, "listener");
        super.addOnPageChangeListener(onPageChangeListener);
        this.pageChangeListener = onPageChangeListener;
    }

    public final int getCurrentSlideNumber(int i5) {
        Context context = getContext();
        e.e(context, "context");
        return LayoutUtil.isRtl(context) ? i5 - getCurrentItem() : getCurrentItem() + 1;
    }

    public final AppIntroViewPagerListener getOnNextPageRequestedListener() {
        return this.onNextPageRequestedListener;
    }

    public final void goToNextSlide() {
        int currentItem = getCurrentItem();
        Context context = getContext();
        e.e(context, "context");
        setCurrentItem(currentItem + (!LayoutUtil.isRtl(context) ? 1 : -1));
    }

    public final void goToPreviousSlide() {
        int currentItem = getCurrentItem();
        Context context = getContext();
        e.e(context, "context");
        setCurrentItem(currentItem + (!LayoutUtil.isRtl(context) ? -1 : 1));
    }

    public final boolean isFirstSlide(int i5) {
        Context context = getContext();
        e.e(context, "context");
        if (LayoutUtil.isRtl(context)) {
            if ((getCurrentItem() - i5) + 1 != 0) {
                return false;
            }
        } else if (getCurrentItem() != 0) {
            return false;
        }
        return true;
    }

    public final boolean isFullPagingEnabled() {
        return this.isFullPagingEnabled;
    }

    public final boolean isLastSlide(int i5) {
        Context context = getContext();
        e.e(context, "context");
        if (LayoutUtil.isRtl(context)) {
            if (getCurrentItem() != 0) {
                return false;
            }
        } else if ((getCurrentItem() - i5) + 1 != 0) {
            return false;
        }
        return true;
    }

    public final boolean isPermissionSlide() {
        return this.isPermissionSlide;
    }

    @Override // androidx.viewpager.widget.l, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        e.f(motionEvent, "event");
        if (handleTouchEvent(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.l, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e.f(motionEvent, "event");
        if (handleTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public final void reCenterCurrentSlide$appintro_release() {
        int currentItem = getCurrentItem();
        setCurrentItem(Math.max(currentItem - 1, 0), false);
        setCurrentItem(currentItem, false);
    }

    public final void setAppIntroPageTransformer(AppIntroPageTransformerType appIntroPageTransformerType) {
        e.f(appIntroPageTransformerType, "appIntroTransformer");
        setPageTransformer(true, new ViewPagerTransformer(appIntroPageTransformerType));
    }

    @Override // androidx.viewpager.widget.l
    public void setCurrentItem(int i5) {
        g gVar;
        int currentItem = super.getCurrentItem();
        super.setCurrentItem(i5);
        if (currentItem == 0 && i5 == 0 && (gVar = this.pageChangeListener) != null) {
            gVar.onPageSelected(0);
        }
    }

    public final void setFullPagingEnabled(boolean z4) {
        this.isFullPagingEnabled = z4;
    }

    public final void setOnNextPageRequestedListener(AppIntroViewPagerListener appIntroViewPagerListener) {
        this.onNextPageRequestedListener = appIntroViewPagerListener;
    }

    public final void setPermissionSlide(boolean z4) {
        this.isPermissionSlide = z4;
    }

    public final void setScrollDurationFactor(double d5) {
        ScrollerCustomDuration scrollerCustomDuration = this.customScroller;
        if (scrollerCustomDuration != null) {
            scrollerCustomDuration.setScrollDurationFactor(d5);
        }
    }
}
