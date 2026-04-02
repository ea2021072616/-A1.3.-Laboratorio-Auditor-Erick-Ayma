package com.github.appintro;

import a4.a;
import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.q3;
import androidx.appcompat.widget.s3;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w0;
import androidx.viewpager.widget.g;
import com.github.appintro.indicator.DotIndicatorController;
import com.github.appintro.indicator.IndicatorController;
import com.github.appintro.indicator.ProgressIndicatorController;
import com.github.appintro.internal.AppIntroViewPager;
import com.github.appintro.internal.LayoutUtil;
import com.github.appintro.internal.LogHelper;
import com.github.appintro.internal.PermissionWrapper;
import com.github.appintro.internal.viewpager.PagerAdapter;
import d.q;
import d.w;
import d.y;
import e4.e;
import j4.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import w.h;
import x.b;
/* loaded from: classes.dex */
public abstract class AppIntroBase extends q implements AppIntroViewPagerListener {
    private static final String ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED = "colorTransitionEnabled";
    private static final String ARG_BUNDLE_CURRENT_ITEM = "currentItem";
    private static final String ARG_BUNDLE_IS_BUTTONS_ENABLED = "isButtonsEnabled";
    private static final String ARG_BUNDLE_IS_FULL_PAGING_ENABLED = "isFullPagingEnabled";
    private static final String ARG_BUNDLE_IS_INDICATOR_ENABLED = "isIndicatorEnabled";
    private static final String ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED = "isSkipButtonsEnabled";
    private static final String ARG_BUNDLE_PERMISSION_MAP = "permissionMap";
    private static final String ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED = "retainIsButtonsEnabled";
    private static final String ARG_BUNDLE_SLIDES_NUMBER = "slidesNumber";
    private static final int DEFAULT_SCROLL_DURATION_FACTOR = 1;
    private static final long DEFAULT_VIBRATE_DURATION = 20;
    private static final int PERMISSIONS_REQUEST_ALL_PERMISSIONS = 1;
    private View backButton;
    private View doneButton;
    private ViewGroup indicatorContainer;
    private IndicatorController indicatorController;
    private boolean isColorTransitionsEnabled;
    private boolean isSystemBackButtonLocked;
    private boolean isVibrate;
    private boolean isWizardMode;
    private View nextButton;
    private AppIntroViewPager pager;
    private PagerAdapter pagerAdapter;
    private int savedCurrentItem;
    private View skipButton;
    private int slidesNumber;
    private Vibrator vibrator;
    private static final Companion Companion = new Companion(null);
    private static final String TAG = LogHelper.makeLogTag(AppIntroBase.class);
    private boolean isButtonsEnabled = true;
    private boolean isSkipButtonEnabled = true;
    private boolean isIndicatorEnabled = true;
    private long vibrateDuration = DEFAULT_VIBRATE_DURATION;
    private int currentlySelectedItem = -1;
    private final List<Fragment> fragments = new ArrayList();
    private HashMap<Integer, PermissionWrapper> permissionsMap = new HashMap<>();
    private boolean retainIsButtonsEnabled = true;
    private final ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(d dVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public final class NextSlideOnClickListener implements View.OnClickListener {
        private boolean isLastSlide;

        public NextSlideOnClickListener(boolean z4) {
            this.isLastSlide = z4;
        }

        public final boolean isLastSlide() {
            return this.isLastSlide;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.f(view, "view");
            AppIntroBase.this.dispatchVibration();
            if (!AppIntroBase.this.onCanRequestNextPage()) {
                AppIntroBase.this.onIllegallyRequestedNextPage();
            } else if (AppIntroBase.this.shouldRequestPermission()) {
                AppIntroBase.this.requestPermissions();
            } else {
                Fragment item = AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem());
                if (this.isLastSlide) {
                    AppIntroBase.this.onDonePressed(item);
                } else {
                    AppIntroBase.this.onNextPressed(item);
                }
                AppIntroBase.this.goToNextSlide(this.isLastSlide);
            }
        }

        public final void setLastSlide(boolean z4) {
            this.isLastSlide = z4;
        }
    }

    /* loaded from: classes.dex */
    public final class OnPageChangeListener implements g {
        public OnPageChangeListener() {
        }

        @Override // androidx.viewpager.widget.g
        public void onPageScrollStateChanged(int i5) {
        }

        @Override // androidx.viewpager.widget.g
        public void onPageScrolled(int i5, float f5, int i6) {
            if (!AppIntroBase.this.isColorTransitionsEnabled() || i5 >= AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getCount() - 1) {
                return;
            }
            AppIntroBase.this.performColorTransition(AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(i5), AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(i5 + 1), f5);
        }

        @Override // androidx.viewpager.widget.g
        public void onPageSelected(int i5) {
            IndicatorController indicatorController;
            if (AppIntroBase.this.slidesNumber >= 1 && (indicatorController = AppIntroBase.this.getIndicatorController()) != null) {
                indicatorController.selectPosition(i5);
            }
            AppIntroBase.this.updateButtonsVisibility();
            AppIntroBase.access$getPager$p(AppIntroBase.this).setPermissionSlide(AppIntroBase.this.isPermissionSlide());
            AppIntroBase.this.onPageSelected(i5);
            if (AppIntroBase.this.slidesNumber > 0) {
                if (AppIntroBase.this.currentlySelectedItem == -1) {
                    AppIntroBase appIntroBase = AppIntroBase.this;
                    appIntroBase.dispatchSlideChangedCallbacks(null, AppIntroBase.access$getPagerAdapter$p(appIntroBase).getItem(i5));
                } else {
                    AppIntroBase appIntroBase2 = AppIntroBase.this;
                    appIntroBase2.dispatchSlideChangedCallbacks(AppIntroBase.access$getPagerAdapter$p(appIntroBase2).getItem(AppIntroBase.this.currentlySelectedItem), AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem()));
                }
            }
            AppIntroBase.this.currentlySelectedItem = i5;
        }
    }

    public static final /* synthetic */ AppIntroViewPager access$getPager$p(AppIntroBase appIntroBase) {
        AppIntroViewPager appIntroViewPager = appIntroBase.pager;
        if (appIntroViewPager != null) {
            return appIntroViewPager;
        }
        e.a0("pager");
        throw null;
    }

    public static final /* synthetic */ PagerAdapter access$getPagerAdapter$p(AppIntroBase appIntroBase) {
        PagerAdapter pagerAdapter = appIntroBase.pagerAdapter;
        if (pagerAdapter != null) {
            return pagerAdapter;
        }
        e.a0("pagerAdapter");
        throw null;
    }

    public static /* synthetic */ void askForPermissions$default(AppIntroBase appIntroBase, String[] strArr, int i5, boolean z4, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: askForPermissions");
        }
        if ((i6 & 4) != 0) {
            z4 = true;
        }
        appIntroBase.askForPermissions(strArr, i5, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchSlideChangedCallbacks(Fragment fragment, Fragment fragment2) {
        if (fragment instanceof SlideSelectionListener) {
            ((SlideSelectionListener) fragment).onSlideDeselected();
        }
        if (fragment2 instanceof SlideSelectionListener) {
            ((SlideSelectionListener) fragment2).onSlideSelected();
        }
        onSlideChanged(fragment, fragment2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public final void dispatchVibration() {
        if (this.isVibrate) {
            Vibrator vibrator = this.vibrator;
            if (vibrator != null) {
                vibrator.vibrate(this.vibrateDuration);
            } else {
                e.a0("vibrator");
                throw null;
            }
        }
    }

    private final int getCurrentSlideNumber() {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            return appIntroViewPager.getCurrentSlideNumber(this.fragments.size());
        }
        e.a0("pager");
        throw null;
    }

    public static /* synthetic */ void goToNextSlide$default(AppIntroBase appIntroBase, boolean z4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goToNextSlide");
        }
        if ((i5 & 1) != 0) {
            AppIntroViewPager appIntroViewPager = appIntroBase.pager;
            if (appIntroViewPager == null) {
                e.a0("pager");
                throw null;
            }
            z4 = appIntroViewPager.isLastSlide(appIntroBase.fragments.size());
        }
        appIntroBase.goToNextSlide(z4);
    }

    private final void handleDeniedPermission(String str) {
        if (!h.d0(this, str)) {
            onUserDisabledPermission(str);
            return;
        }
        onUserDeniedPermission(str);
        PermissionWrapper permissionWrapper = this.permissionsMap.get(Integer.valueOf(getCurrentSlideNumber()));
        if (permissionWrapper == null || permissionWrapper.getRequired()) {
            return;
        }
        this.permissionsMap.remove(Integer.valueOf(permissionWrapper.getPosition()));
        goToNextSlide$default(this, false, 1, null);
    }

    private final void initializeIndicator() {
        ViewGroup viewGroup = this.indicatorContainer;
        if (viewGroup == null) {
            e.a0("indicatorContainer");
            throw null;
        }
        IndicatorController indicatorController = this.indicatorController;
        viewGroup.addView(indicatorController != null ? indicatorController.newInstance(this) : null);
        IndicatorController indicatorController2 = this.indicatorController;
        if (indicatorController2 != null) {
            indicatorController2.initialize(this.slidesNumber);
        }
        IndicatorController indicatorController3 = this.indicatorController;
        if (indicatorController3 != null) {
            indicatorController3.selectPosition(this.currentlySelectedItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPermissionSlide() {
        HashMap<Integer, PermissionWrapper> hashMap = this.permissionsMap;
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            return hashMap.containsKey(Integer.valueOf(appIntroViewPager.getCurrentSlideNumber(this.fragments.size())));
        }
        e.a0("pager");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performColorTransition(Fragment fragment, Fragment fragment2, float f5) {
        if (!(fragment instanceof SlideBackgroundColorHolder) || !(fragment2 instanceof SlideBackgroundColorHolder)) {
            throw new IllegalStateException("Color transitions are only available if all slides implement SlideBackgroundColorHolder.".toString());
        }
        if (fragment.isAdded() && fragment2.isAdded()) {
            SlideBackgroundColorHolder slideBackgroundColorHolder = (SlideBackgroundColorHolder) fragment;
            SlideBackgroundColorHolder slideBackgroundColorHolder2 = (SlideBackgroundColorHolder) fragment2;
            Object evaluate = this.argbEvaluator.evaluate(f5, Integer.valueOf(slideBackgroundColorHolder.getDefaultBackgroundColor()), Integer.valueOf(slideBackgroundColorHolder2.getDefaultBackgroundColor()));
            if (evaluate == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            int intValue = ((Integer) evaluate).intValue();
            slideBackgroundColorHolder.setBackgroundColor(intValue);
            slideBackgroundColorHolder2.setBackgroundColor(intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestPermissions() {
        setSwipeLock(true);
        PermissionWrapper permissionWrapper = this.permissionsMap.get(Integer.valueOf(getCurrentSlideNumber()));
        if (permissionWrapper != null) {
            h.c0(this, permissionWrapper.getPermissions(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldRequestPermission() {
        return this.permissionsMap.containsKey(Integer.valueOf(getCurrentSlideNumber()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateButtonsVisibility() {
        boolean z4 = false;
        if (!this.isButtonsEnabled) {
            View view = this.nextButton;
            if (view == null) {
                e.a0("nextButton");
                throw null;
            }
            AppIntroBaseKt.setVisible(view, false);
            View view2 = this.doneButton;
            if (view2 == null) {
                e.a0("doneButton");
                throw null;
            }
            AppIntroBaseKt.setVisible(view2, false);
            View view3 = this.backButton;
            if (view3 == null) {
                e.a0("backButton");
                throw null;
            }
            AppIntroBaseKt.setVisible(view3, false);
            View view4 = this.skipButton;
            if (view4 != null) {
                AppIntroBaseKt.setVisible(view4, false);
                return;
            } else {
                e.a0("skipButton");
                throw null;
            }
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            e.a0("pager");
            throw null;
        }
        boolean isLastSlide = appIntroViewPager.isLastSlide(this.fragments.size());
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            e.a0("pager");
            throw null;
        }
        boolean isFirstSlide = appIntroViewPager2.isFirstSlide(this.fragments.size());
        View view5 = this.nextButton;
        if (view5 == null) {
            e.a0("nextButton");
            throw null;
        }
        AppIntroBaseKt.setVisible(view5, !isLastSlide);
        View view6 = this.doneButton;
        if (view6 == null) {
            e.a0("doneButton");
            throw null;
        }
        AppIntroBaseKt.setVisible(view6, isLastSlide);
        View view7 = this.skipButton;
        if (view7 == null) {
            e.a0("skipButton");
            throw null;
        }
        AppIntroBaseKt.setVisible(view7, this.isSkipButtonEnabled && !isLastSlide);
        View view8 = this.backButton;
        if (view8 == null) {
            e.a0("backButton");
            throw null;
        }
        if (this.isWizardMode && !isFirstSlide) {
            z4 = true;
        }
        AppIntroBaseKt.setVisible(view8, z4);
    }

    public final void addSlide(Fragment fragment) {
        e.f(fragment, "fragment");
        if (isRtl$appintro_release()) {
            this.fragments.add(0, fragment);
        } else {
            this.fragments.add(fragment);
        }
        if (this.isWizardMode) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                e.a0("pager");
                throw null;
            }
            appIntroViewPager.setOffscreenPageLimit(this.fragments.size());
        }
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.notifyDataSetChanged();
        } else {
            e.a0("pagerAdapter");
            throw null;
        }
    }

    public final void askForPermissions(String[] strArr, int i5) {
        askForPermissions$default(this, strArr, i5, false, 4, null);
    }

    public final IndicatorController getIndicatorController() {
        return this.indicatorController;
    }

    public abstract int getLayoutId();

    public final long getVibrateDuration() {
        return this.vibrateDuration;
    }

    public final void goToNextSlide(boolean z4) {
        if (z4) {
            onIntroFinished();
            return;
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            e.a0("pager");
            throw null;
        }
        appIntroViewPager.goToNextSlide();
        onNextSlide();
    }

    public final void goToPreviousSlide() {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.goToPreviousSlide();
        } else {
            e.a0("pager");
            throw null;
        }
    }

    public final boolean isButtonsEnabled() {
        return this.isButtonsEnabled;
    }

    public final boolean isColorTransitionsEnabled() {
        return this.isColorTransitionsEnabled;
    }

    public final boolean isIndicatorEnabled() {
        return this.isIndicatorEnabled;
    }

    public final boolean isRtl$appintro_release() {
        Context applicationContext = getApplicationContext();
        e.e(applicationContext, "applicationContext");
        return LayoutUtil.isRtl(applicationContext);
    }

    public final boolean isSkipButtonEnabled() {
        return this.isSkipButtonEnabled;
    }

    public final boolean isSystemBackButtonLocked() {
        return this.isSystemBackButtonLocked;
    }

    public final boolean isVibrate() {
        return this.isVibrate;
    }

    public final boolean isWizardMode() {
        return this.isWizardMode;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.isSystemBackButtonLocked) {
            return;
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            e.a0("pager");
            throw null;
        } else if (appIntroViewPager.isFirstSlide(this.fragments.size())) {
            super.onBackPressed();
        } else {
            AppIntroViewPager appIntroViewPager2 = this.pager;
            if (appIntroViewPager2 != null) {
                appIntroViewPager2.goToPreviousSlide();
            } else {
                e.a0("pager");
                throw null;
            }
        }
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public boolean onCanRequestNextPage() {
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter == null) {
            e.a0("pagerAdapter");
            throw null;
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            e.a0("pager");
            throw null;
        }
        Fragment item = pagerAdapter.getItem(appIntroViewPager.getCurrentItem());
        if (!(item instanceof SlidePolicy) || ((SlidePolicy) item).isPolicyRespected()) {
            LogHelper.d(TAG, "Change request will be allowed.");
            return true;
        }
        LogHelper.d(TAG, "Slide policy not respected, denying change request.");
        return false;
    }

    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, w.o, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        w wVar = y.f2482g;
        int i5 = s3.f528a;
        super.onCreate(bundle);
        this.indicatorController = new DotIndicatorController(this);
        showStatusBar(false);
        setContentView(getLayoutId());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.indicator_container);
        if (viewGroup == null) {
            throw new IllegalStateException("Missing Indicator Container: R.id.indicator_container".toString());
        }
        this.indicatorContainer = viewGroup;
        View findViewById = findViewById(R.id.next);
        if (findViewById == null) {
            throw new IllegalStateException("Missing Next button: R.id.next".toString());
        }
        this.nextButton = findViewById;
        View findViewById2 = findViewById(R.id.done);
        if (findViewById2 == null) {
            throw new IllegalStateException("Missing Done button: R.id.done".toString());
        }
        this.doneButton = findViewById2;
        View findViewById3 = findViewById(R.id.skip);
        if (findViewById3 == null) {
            throw new IllegalStateException("Missing Skip button: R.id.skip".toString());
        }
        this.skipButton = findViewById3;
        View findViewById4 = findViewById(R.id.back);
        if (findViewById4 == null) {
            throw new IllegalStateException("Missing Back button: R.id.back".toString());
        }
        this.backButton = findViewById4;
        View view = this.nextButton;
        if (view == null) {
            e.a0("nextButton");
            throw null;
        }
        q3.a(view, getString(R.string.app_intro_next_button));
        View view2 = this.skipButton;
        if (view2 == null) {
            e.a0("skipButton");
            throw null;
        }
        if (view2 instanceof ImageButton) {
            q3.a(view2, getString(R.string.app_intro_skip_button));
        }
        View view3 = this.doneButton;
        if (view3 == null) {
            e.a0("doneButton");
            throw null;
        }
        if (view3 instanceof ImageButton) {
            q3.a(view3, getString(R.string.app_intro_done_button));
        }
        View view4 = this.backButton;
        if (view4 == null) {
            e.a0("backButton");
            throw null;
        }
        if (view4 instanceof ImageButton) {
            q3.a(view4, getString(R.string.app_intro_back_button));
        }
        if (isRtl$appintro_release()) {
            View view5 = this.nextButton;
            if (view5 == null) {
                e.a0("nextButton");
                throw null;
            }
            view5.setScaleX(-1.0f);
            View view6 = this.backButton;
            if (view6 == null) {
                e.a0("backButton");
                throw null;
            }
            view6.setScaleX(-1.0f);
        }
        Object systemService = getSystemService("vibrator");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
        }
        this.vibrator = (Vibrator) systemService;
        w0 supportFragmentManager = getSupportFragmentManager();
        e.e(supportFragmentManager, "supportFragmentManager");
        this.pagerAdapter = new PagerAdapter(supportFragmentManager, this.fragments);
        View findViewById5 = findViewById(R.id.view_pager);
        e.e(findViewById5, "findViewById(R.id.view_pager)");
        this.pager = (AppIntroViewPager) findViewById5;
        View view7 = this.doneButton;
        if (view7 == null) {
            e.a0("doneButton");
            throw null;
        }
        view7.setOnClickListener(new NextSlideOnClickListener(true));
        View view8 = this.nextButton;
        if (view8 == null) {
            e.a0("nextButton");
            throw null;
        }
        view8.setOnClickListener(new NextSlideOnClickListener(false));
        View view9 = this.backButton;
        if (view9 == null) {
            e.a0("backButton");
            throw null;
        }
        view9.setOnClickListener(new View.OnClickListener() { // from class: com.github.appintro.AppIntroBase$onCreate$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view10) {
                AppIntroBase.access$getPager$p(AppIntroBase.this).goToPreviousSlide();
            }
        });
        View view10 = this.skipButton;
        if (view10 == null) {
            e.a0("skipButton");
            throw null;
        }
        view10.setOnClickListener(new View.OnClickListener() { // from class: com.github.appintro.AppIntroBase$onCreate$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view11) {
                AppIntroBase.this.dispatchVibration();
                AppIntroBase appIntroBase = AppIntroBase.this;
                appIntroBase.onSkipPressed(AppIntroBase.access$getPagerAdapter$p(appIntroBase).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem()));
            }
        });
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            e.a0("pager");
            throw null;
        }
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter == null) {
            e.a0("pagerAdapter");
            throw null;
        }
        appIntroViewPager.setAdapter(pagerAdapter);
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            e.a0("pager");
            throw null;
        }
        appIntroViewPager2.addOnPageChangeListener$appintro_release(new OnPageChangeListener());
        AppIntroViewPager appIntroViewPager3 = this.pager;
        if (appIntroViewPager3 == null) {
            e.a0("pager");
            throw null;
        }
        appIntroViewPager3.setOnNextPageRequestedListener(this);
        setScrollDurationFactor(1);
    }

    public void onDonePressed(Fragment fragment) {
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public void onIllegallyRequestedNextPage() {
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter == null) {
            e.a0("pagerAdapter");
            throw null;
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            e.a0("pager");
            throw null;
        }
        Fragment item = pagerAdapter.getItem(appIntroViewPager.getCurrentItem());
        if (item instanceof SlidePolicy) {
            SlidePolicy slidePolicy = (SlidePolicy) item;
            if (slidePolicy.isPolicyRespected()) {
                return;
            }
            slidePolicy.onUserIllegallyRequestedNextPage();
        }
    }

    public void onIntroFinished() {
    }

    @Override // d.q, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        e.f(keyEvent, "event");
        if (i5 == 66 || i5 == 96 || i5 == 23) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                e.a0("pager");
                throw null;
            }
            boolean isLastSlide = appIntroViewPager.isLastSlide(this.fragments.size());
            goToNextSlide(isLastSlide);
            if (isLastSlide) {
                PagerAdapter pagerAdapter = this.pagerAdapter;
                if (pagerAdapter == null) {
                    e.a0("pagerAdapter");
                    throw null;
                }
                AppIntroViewPager appIntroViewPager2 = this.pager;
                if (appIntroViewPager2 != null) {
                    onDonePressed(pagerAdapter.getItem(appIntroViewPager2.getCurrentItem()));
                    return false;
                }
                e.a0("pager");
                throw null;
            }
            return false;
        }
        return super.onKeyDown(i5, keyEvent);
    }

    public void onNextPressed(Fragment fragment) {
    }

    public void onNextSlide() {
    }

    public void onPageSelected(int i5) {
    }

    @Override // d.q, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.slidesNumber = this.fragments.size();
        initializeIndicator();
        this.retainIsButtonsEnabled = this.isButtonsEnabled;
        if (isRtl$appintro_release()) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                e.a0("pager");
                throw null;
            }
            appIntroViewPager.setCurrentItem(this.fragments.size() - this.savedCurrentItem);
        } else {
            AppIntroViewPager appIntroViewPager2 = this.pager;
            if (appIntroViewPager2 == null) {
                e.a0("pager");
                throw null;
            }
            appIntroViewPager2.setCurrentItem(this.savedCurrentItem);
        }
        AppIntroViewPager appIntroViewPager3 = this.pager;
        if (appIntroViewPager3 != null) {
            appIntroViewPager3.post(new Runnable() { // from class: com.github.appintro.AppIntroBase$onPostCreate$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem()) == null) {
                        AppIntroBase.this.finish();
                        return;
                    }
                    AppIntroBase appIntroBase = AppIntroBase.this;
                    appIntroBase.dispatchSlideChangedCallbacks(null, AppIntroBase.access$getPagerAdapter$p(appIntroBase).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem()));
                }
            });
        } else {
            e.a0("pager");
            throw null;
        }
    }

    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        e.f(strArr, "permissions");
        e.f(iArr, "grantResults");
        super.onRequestPermissionsResult(i5, strArr, iArr);
        setSwipeLock(false);
        if (i5 != 1) {
            return;
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            arrayList.add(new a(strArr[i7], Integer.valueOf(iArr[i6])));
            i6++;
            i7++;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((Number) ((a) next).f29c).intValue() == -1) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add((String) ((a) it2.next()).f28b);
        }
        if (arrayList3.isEmpty()) {
            this.permissionsMap.remove(Integer.valueOf(getCurrentSlideNumber()));
            goToNextSlide$default(this, false, 1, null);
            return;
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            handleDeniedPermission((String) it3.next());
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.reCenterCurrentSlide$appintro_release();
        } else {
            e.a0("pager");
            throw null;
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        e.f(bundle, "savedInstanceState");
        super.onRestoreInstanceState(bundle);
        this.slidesNumber = bundle.getInt(ARG_BUNDLE_SLIDES_NUMBER);
        this.retainIsButtonsEnabled = bundle.getBoolean(ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED);
        setButtonsEnabled(bundle.getBoolean(ARG_BUNDLE_IS_BUTTONS_ENABLED));
        setSkipButtonEnabled(bundle.getBoolean(ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED));
        setIndicatorEnabled(bundle.getBoolean(ARG_BUNDLE_IS_INDICATOR_ENABLED));
        this.savedCurrentItem = bundle.getInt(ARG_BUNDLE_CURRENT_ITEM);
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            e.a0("pager");
            throw null;
        }
        appIntroViewPager.setFullPagingEnabled(bundle.getBoolean(ARG_BUNDLE_IS_FULL_PAGING_ENABLED));
        HashMap<Integer, PermissionWrapper> hashMap = (HashMap) bundle.getSerializable(ARG_BUNDLE_PERMISSION_MAP);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        this.permissionsMap = hashMap;
        this.isColorTransitionsEnabled = bundle.getBoolean(ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED);
    }

    @Override // androidx.activity.ComponentActivity, w.o, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        e.f(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putInt(ARG_BUNDLE_SLIDES_NUMBER, this.slidesNumber);
        bundle.putBoolean(ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED, this.retainIsButtonsEnabled);
        bundle.putBoolean(ARG_BUNDLE_IS_BUTTONS_ENABLED, this.isButtonsEnabled);
        bundle.putBoolean(ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED, this.isSkipButtonEnabled);
        bundle.putBoolean(ARG_BUNDLE_IS_INDICATOR_ENABLED, this.isIndicatorEnabled);
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            e.a0("pager");
            throw null;
        }
        bundle.putInt(ARG_BUNDLE_CURRENT_ITEM, appIntroViewPager.getCurrentItem());
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            e.a0("pager");
            throw null;
        }
        bundle.putBoolean(ARG_BUNDLE_IS_FULL_PAGING_ENABLED, appIntroViewPager2.isFullPagingEnabled());
        bundle.putSerializable(ARG_BUNDLE_PERMISSION_MAP, this.permissionsMap);
        bundle.putBoolean(ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED, this.isColorTransitionsEnabled);
    }

    public void onSkipPressed(Fragment fragment) {
    }

    public void onSlideChanged(Fragment fragment, Fragment fragment2) {
    }

    public void onUserDeniedPermission(String str) {
        e.f(str, "permissionName");
    }

    public void onUserDisabledPermission(String str) {
        e.f(str, "permissionName");
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public void onUserRequestedPermissionsDialog() {
        String str = TAG;
        LogHelper.d(str, "Requesting Permissions on " + getCurrentSlideNumber());
        requestPermissions();
    }

    public final void setButtonsEnabled(boolean z4) {
        this.isButtonsEnabled = z4;
        updateButtonsVisibility();
    }

    public final void setColorTransitionsEnabled(boolean z4) {
        this.isColorTransitionsEnabled = z4;
    }

    public final void setCustomTransformer(androidx.viewpager.widget.h hVar) {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.setPageTransformer(true, hVar);
        } else {
            e.a0("pager");
            throw null;
        }
    }

    public final void setImmersiveMode() {
        Window window = getWindow();
        e.e(window, "window");
        View decorView = window.getDecorView();
        e.e(decorView, "window.decorView");
        decorView.setSystemUiVisibility(5894);
    }

    public final void setIndicatorColor(int i5, int i6) {
        IndicatorController indicatorController = this.indicatorController;
        if (indicatorController != null) {
            indicatorController.setSelectedIndicatorColor(i5);
        }
        IndicatorController indicatorController2 = this.indicatorController;
        if (indicatorController2 != null) {
            indicatorController2.setUnselectedIndicatorColor(i6);
        }
    }

    public final void setIndicatorController(IndicatorController indicatorController) {
        this.indicatorController = indicatorController;
    }

    public final void setIndicatorEnabled(boolean z4) {
        this.isIndicatorEnabled = z4;
        ViewGroup viewGroup = this.indicatorContainer;
        if (viewGroup != null) {
            AppIntroBaseKt.setVisible(viewGroup, z4);
        } else {
            e.a0("indicatorContainer");
            throw null;
        }
    }

    public final void setNavBarColor(int i5) {
        Window window = getWindow();
        e.e(window, "window");
        window.setNavigationBarColor(i5);
    }

    public final void setNavBarColorRes(int i5) {
        Window window = getWindow();
        e.e(window, "window");
        window.setNavigationBarColor(b.a(this, i5));
    }

    public final void setNextPageSwipeLock(boolean z4) {
        LogHelper.w$default(TAG, "Calling setNextPageSwipeLock has not effect here. Please switch to setSwipeLock or SlidePolicy", null, 4, null);
    }

    public final void setProgressIndicator() {
        this.indicatorController = new ProgressIndicatorController(this, null, 0, 6, null);
    }

    public final void setScrollDurationFactor(int i5) {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.setScrollDurationFactor(i5);
        } else {
            e.a0("pager");
            throw null;
        }
    }

    public final void setSkipButtonEnabled(boolean z4) {
        this.isSkipButtonEnabled = z4;
        updateButtonsVisibility();
    }

    public final void setStatusBarColor(int i5) {
        getWindow().clearFlags(67108864);
        getWindow().addFlags(Integer.MIN_VALUE);
        Window window = getWindow();
        e.e(window, "window");
        window.setStatusBarColor(i5);
    }

    public final void setStatusBarColorRes(int i5) {
        setStatusBarColor(b.a(this, i5));
    }

    public final void setSwipeLock(boolean z4) {
        if (z4) {
            this.retainIsButtonsEnabled = this.isButtonsEnabled;
            setButtonsEnabled(true);
        } else {
            setButtonsEnabled(this.retainIsButtonsEnabled);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.setFullPagingEnabled(!z4);
        } else {
            e.a0("pager");
            throw null;
        }
    }

    public final void setSystemBackButtonLocked(boolean z4) {
        this.isSystemBackButtonLocked = z4;
    }

    public final void setTransformer(AppIntroPageTransformerType appIntroPageTransformerType) {
        e.f(appIntroPageTransformerType, "appIntroTransformer");
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.setAppIntroPageTransformer(appIntroPageTransformerType);
        } else {
            e.a0("pager");
            throw null;
        }
    }

    public final void setVibrate(boolean z4) {
        this.isVibrate = z4;
    }

    public final void setVibrateDuration(long j5) {
        this.vibrateDuration = j5;
    }

    public final void setWizardMode(boolean z4) {
        this.isWizardMode = z4;
        setSkipButtonEnabled(!z4);
        updateButtonsVisibility();
    }

    public final void showStatusBar(boolean z4) {
        if (z4) {
            getWindow().clearFlags(1024);
        } else {
            getWindow().setFlags(1024, 1024);
        }
    }

    public final void askForPermissions(String[] strArr, int i5, boolean z4) {
        e.f(strArr, "permissions");
        if (i5 > 0) {
            this.permissionsMap.put(Integer.valueOf(i5), new PermissionWrapper(strArr, i5, z4));
            return;
        }
        throw new IllegalStateException(b0.f("Invalid Slide Number: ", i5).toString());
    }
}
