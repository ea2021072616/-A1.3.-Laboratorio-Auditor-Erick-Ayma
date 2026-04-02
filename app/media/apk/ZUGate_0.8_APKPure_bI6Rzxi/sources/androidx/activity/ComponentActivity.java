package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.k0;
import androidx.lifecycle.p0;
import androidx.lifecycle.t0;
import androidx.lifecycle.v0;
import androidx.lifecycle.w0;
import com.github.appintro.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import w.e0;
import w.f0;
import w.g0;
/* loaded from: classes.dex */
public abstract class ComponentActivity extends w.o implements w0, androidx.lifecycle.i, b1.f, a0, androidx.activity.result.i, x.c, x.d, e0, f0, h0.m {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final androidx.activity.result.h mActivityResultRegistry;
    private int mContentLayoutId;
    private t0 mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final q mFullyDrawnReporter;
    private final AtomicInteger mNextLocalRequestCode;
    private z mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<g0.a> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<g0.a> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<g0.a> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<g0.a> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<g0.a> mOnTrimMemoryListeners;
    final m mReportFullyDrawnExecutor;
    final b1.e mSavedStateRegistryController;
    private v0 mViewModelStore;
    final a.a mContextAwareHelper = new a.a();
    private final h0.q mMenuHostHelper = new h0.q(new d(0, this));
    private final androidx.lifecycle.v mLifecycleRegistry = new androidx.lifecycle.v(this);

    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.activity.e] */
    public ComponentActivity() {
        b1.e c5 = z0.d.c(this);
        this.mSavedStateRegistryController = c5;
        this.mOnBackPressedDispatcher = null;
        n nVar = new n(this);
        this.mReportFullyDrawnExecutor = nVar;
        this.mFullyDrawnReporter = new q(nVar, new i4.a() { // from class: androidx.activity.e
            @Override // i4.a
            public final Object a() {
                ComponentActivity.this.reportFullyDrawn();
                return null;
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new i(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().a(new androidx.lifecycle.r() { // from class: androidx.activity.ComponentActivity.2
            {
                ComponentActivity.this = this;
            }

            @Override // androidx.lifecycle.r
            public final void b(androidx.lifecycle.t tVar, androidx.lifecycle.m mVar) {
                if (mVar == androidx.lifecycle.m.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        peekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        getLifecycle().a(new androidx.lifecycle.r() { // from class: androidx.activity.ComponentActivity.3
            {
                ComponentActivity.this = this;
            }

            @Override // androidx.lifecycle.r
            public final void b(androidx.lifecycle.t tVar, androidx.lifecycle.m mVar) {
                if (mVar == androidx.lifecycle.m.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.f1b = null;
                    if (!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.getViewModelStore().a();
                    }
                    n nVar2 = (n) ComponentActivity.this.mReportFullyDrawnExecutor;
                    ComponentActivity componentActivity = nVar2.f68e;
                    componentActivity.getWindow().getDecorView().removeCallbacks(nVar2);
                    componentActivity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(nVar2);
                }
            }
        });
        getLifecycle().a(new androidx.lifecycle.r() { // from class: androidx.activity.ComponentActivity.4
            {
                ComponentActivity.this = this;
            }

            @Override // androidx.lifecycle.r
            public final void b(androidx.lifecycle.t tVar, androidx.lifecycle.m mVar) {
                ComponentActivity componentActivity = ComponentActivity.this;
                componentActivity.ensureViewModelStore();
                componentActivity.getLifecycle().b(this);
            }
        });
        c5.a();
        b4.j.o(this);
        getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new f(0, this));
        addOnContextAvailableListener(new g(this, 0));
    }

    public static /* synthetic */ void access$001(ComponentActivity componentActivity) {
        super.onBackPressed();
    }

    public static Bundle b(ComponentActivity componentActivity) {
        componentActivity.getClass();
        Bundle bundle = new Bundle();
        androidx.activity.result.h hVar = componentActivity.mActivityResultRegistry;
        hVar.getClass();
        HashMap hashMap = hVar.f93b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(hashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(hashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(hVar.f95d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) hVar.f98g.clone());
        return bundle;
    }

    public static void c(ComponentActivity componentActivity) {
        Bundle a5 = componentActivity.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (a5 != null) {
            androidx.activity.result.h hVar = componentActivity.mActivityResultRegistry;
            hVar.getClass();
            ArrayList<Integer> integerArrayList = a5.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = a5.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            hVar.f95d = a5.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            Bundle bundle = a5.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            Bundle bundle2 = hVar.f98g;
            bundle2.putAll(bundle);
            for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
                String str = stringArrayList.get(i5);
                HashMap hashMap = hVar.f93b;
                boolean containsKey = hashMap.containsKey(str);
                HashMap hashMap2 = hVar.f92a;
                if (containsKey) {
                    Integer num = (Integer) hashMap.remove(str);
                    if (!bundle2.containsKey(str)) {
                        hashMap2.remove(num);
                    }
                }
                int intValue = integerArrayList.get(i5).intValue();
                String str2 = stringArrayList.get(i5);
                hashMap2.put(Integer.valueOf(intValue), str2);
                hashMap.put(str2, Integer.valueOf(intValue));
            }
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.a(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // h0.m
    public void addMenuProvider(h0.s sVar) {
        h0.q qVar = this.mMenuHostHelper;
        qVar.f3195b.add(sVar);
        qVar.f3194a.run();
    }

    @Override // x.c
    public final void addOnConfigurationChangedListener(g0.a aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(a.b bVar) {
        a.a aVar = this.mContextAwareHelper;
        aVar.getClass();
        e4.e.f(bVar, "listener");
        Context context = aVar.f1b;
        if (context != null) {
            bVar.a(context);
        }
        aVar.f0a.add(bVar);
    }

    @Override // w.e0
    public final void addOnMultiWindowModeChangedListener(g0.a aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(g0.a aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    @Override // w.f0
    public final void addOnPictureInPictureModeChangedListener(g0.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    @Override // x.d
    public final void addOnTrimMemoryListener(g0.a aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            l lVar = (l) getLastNonConfigurationInstance();
            if (lVar != null) {
                this.mViewModelStore = lVar.f64b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new v0();
            }
        }
    }

    @Override // androidx.activity.result.i
    public final androidx.activity.result.h getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.i
    public w0.b getDefaultViewModelCreationExtras() {
        w0.e eVar = new w0.e();
        Application application = getApplication();
        LinkedHashMap linkedHashMap = eVar.f5293a;
        if (application != null) {
            linkedHashMap.put(l2.i.f3855i, getApplication());
        }
        linkedHashMap.put(b4.j.f1662a, this);
        linkedHashMap.put(b4.j.f1663b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(b4.j.f1664c, getIntent().getExtras());
        }
        return eVar;
    }

    @Override // androidx.lifecycle.i
    public t0 getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new p0(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    public q getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        l lVar = (l) getLastNonConfigurationInstance();
        if (lVar != null) {
            return lVar.f63a;
        }
        return null;
    }

    @Override // androidx.lifecycle.t
    public androidx.lifecycle.o getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.a0
    public final z getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new z(new j(0, this));
            getLifecycle().a(new androidx.lifecycle.r() { // from class: androidx.activity.ComponentActivity.6
                {
                    ComponentActivity.this = this;
                }

                @Override // androidx.lifecycle.r
                public final void b(androidx.lifecycle.t tVar, androidx.lifecycle.m mVar) {
                    if (mVar != androidx.lifecycle.m.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                        return;
                    }
                    z zVar = ComponentActivity.this.mOnBackPressedDispatcher;
                    OnBackInvokedDispatcher a5 = k.a((ComponentActivity) tVar);
                    zVar.getClass();
                    e4.e.f(a5, "invoker");
                    zVar.f124e = a5;
                    zVar.c(zVar.f126g);
                }
            });
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // b1.f
    public final b1.d getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f1617b;
    }

    @Override // androidx.lifecycle.w0
    public v0 getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        b4.j.S(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        e4.e.f(decorView, "<this>");
        decorView.setTag(R.id.view_tree_view_model_store_owner, this);
        b4.j.T(getWindow().getDecorView(), this);
        p2.a.S(getWindow().getDecorView(), this);
        View decorView2 = getWindow().getDecorView();
        e4.e.f(decorView2, "<this>");
        decorView2.setTag(R.id.report_drawn, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        if (this.mActivityResultRegistry.a(i5, i6, intent)) {
            return;
        }
        super.onActivityResult(i5, i6, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        getOnBackPressedDispatcher().b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<g0.a> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(configuration);
        }
    }

    @Override // w.o, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.b(bundle);
        a.a aVar = this.mContextAwareHelper;
        aVar.getClass();
        aVar.f1b = this;
        Iterator it = aVar.f0a.iterator();
        while (it.hasNext()) {
            ((a.b) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i5 = k0.f1113h;
        p3.e.m(this);
        int i6 = this.mContentLayoutId;
        if (i6 != 0) {
            setContentView(i6);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i5, Menu menu) {
        if (i5 == 0) {
            super.onCreatePanelMenu(i5, menu);
            h0.q qVar = this.mMenuHostHelper;
            MenuInflater menuInflater = getMenuInflater();
            Iterator it = qVar.f3195b.iterator();
            while (it.hasNext()) {
                ((androidx.fragment.app.p0) ((h0.s) it.next())).f966a.j(menu, menuInflater);
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        if (i5 == 0) {
            return this.mMenuHostHelper.a(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z4) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<g0.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(new w.p(z4));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<g0.a> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().a(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i5, Menu menu) {
        Iterator it = this.mMenuHostHelper.f3195b.iterator();
        while (it.hasNext()) {
            ((androidx.fragment.app.p0) ((h0.s) it.next())).f966a.p(menu);
        }
        super.onPanelClosed(i5, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z4) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<g0.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(new g0(z4));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i5, View view, Menu menu) {
        if (i5 == 0) {
            super.onPreparePanel(i5, view, menu);
            Iterator it = this.mMenuHostHelper.f3195b.iterator();
            while (it.hasNext()) {
                ((androidx.fragment.app.p0) ((h0.s) it.next())).f966a.s(menu);
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.a(i5, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i5, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        l lVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        v0 v0Var = this.mViewModelStore;
        if (v0Var == null && (lVar = (l) getLastNonConfigurationInstance()) != null) {
            v0Var = lVar.f64b;
        }
        if (v0Var == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        l lVar2 = new l();
        lVar2.f63a = onRetainCustomNonConfigurationInstance;
        lVar2.f64b = v0Var;
        return lVar2;
    }

    @Override // w.o, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.o lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.v) {
            ((androidx.lifecycle.v) lifecycle).g();
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.c(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i5) {
        super.onTrimMemory(i5);
        Iterator<g0.a> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().a(Integer.valueOf(i5));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.f1b;
    }

    public final <I, O> androidx.activity.result.d registerForActivityResult(b.a aVar, androidx.activity.result.h hVar, androidx.activity.result.c cVar) {
        return hVar.c("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, cVar);
    }

    @Override // h0.m
    public void removeMenuProvider(h0.s sVar) {
        this.mMenuHostHelper.b(sVar);
    }

    @Override // x.c
    public final void removeOnConfigurationChangedListener(g0.a aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(a.b bVar) {
        a.a aVar = this.mContextAwareHelper;
        aVar.getClass();
        e4.e.f(bVar, "listener");
        aVar.f0a.remove(bVar);
    }

    @Override // w.e0
    public final void removeOnMultiWindowModeChangedListener(g0.a aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(g0.a aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    @Override // w.f0
    public final void removeOnPictureInPictureModeChangedListener(g0.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    @Override // x.d
    public final void removeOnTrimMemoryListener(g0.a aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (b4.j.B()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            q qVar = this.mFullyDrawnReporter;
            synchronized (qVar.f72a) {
                qVar.f73b = true;
                Iterator it = qVar.f74c.iterator();
                while (it.hasNext()) {
                    ((i4.a) it.next()).a();
                }
                qVar.f74c.clear();
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i5) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.a(getWindow().getDecorView());
        super.setContentView(i5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i5) {
        super.startActivityForResult(intent, i5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8) {
        super.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i5, Bundle bundle) {
        super.startActivityForResult(intent, i5, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z4, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z4, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<g0.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                e4.e.f(configuration, "newConfig");
                it.next().a(new w.p(z4));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z4, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z4, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<g0.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                e4.e.f(configuration, "newConfig");
                it.next().a(new g0(z4));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> androidx.activity.result.d registerForActivityResult(b.a aVar, androidx.activity.result.c cVar) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, cVar);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.a(getWindow().getDecorView());
        super.setContentView(view);
    }

    public void addMenuProvider(final h0.s sVar, androidx.lifecycle.t tVar) {
        final h0.q qVar = this.mMenuHostHelper;
        qVar.f3195b.add(sVar);
        qVar.f3194a.run();
        androidx.lifecycle.o lifecycle = tVar.getLifecycle();
        HashMap hashMap = qVar.f3196c;
        h0.p pVar = (h0.p) hashMap.remove(sVar);
        if (pVar != null) {
            pVar.f3190a.b(pVar.f3191b);
            pVar.f3191b = null;
        }
        hashMap.put(sVar, new h0.p(lifecycle, new androidx.lifecycle.r() { // from class: h0.n
            @Override // androidx.lifecycle.r
            public final void b(androidx.lifecycle.t tVar2, androidx.lifecycle.m mVar) {
                androidx.lifecycle.m mVar2 = androidx.lifecycle.m.ON_DESTROY;
                q qVar2 = q.this;
                if (mVar == mVar2) {
                    qVar2.b(sVar);
                } else {
                    qVar2.getClass();
                }
            }
        }));
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.a(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(final h0.s sVar, androidx.lifecycle.t tVar, final androidx.lifecycle.n nVar) {
        final h0.q qVar = this.mMenuHostHelper;
        qVar.getClass();
        androidx.lifecycle.o lifecycle = tVar.getLifecycle();
        HashMap hashMap = qVar.f3196c;
        h0.p pVar = (h0.p) hashMap.remove(sVar);
        if (pVar != null) {
            pVar.f3190a.b(pVar.f3191b);
            pVar.f3191b = null;
        }
        hashMap.put(sVar, new h0.p(lifecycle, new androidx.lifecycle.r() { // from class: h0.o
            @Override // androidx.lifecycle.r
            public final void b(androidx.lifecycle.t tVar2, androidx.lifecycle.m mVar) {
                q qVar2 = q.this;
                qVar2.getClass();
                androidx.lifecycle.m.Companion.getClass();
                androidx.lifecycle.n nVar2 = nVar;
                androidx.lifecycle.m c5 = androidx.lifecycle.k.c(nVar2);
                Runnable runnable = qVar2.f3194a;
                CopyOnWriteArrayList copyOnWriteArrayList = qVar2.f3195b;
                s sVar2 = sVar;
                if (mVar == c5) {
                    copyOnWriteArrayList.add(sVar2);
                    runnable.run();
                } else if (mVar == androidx.lifecycle.m.ON_DESTROY) {
                    qVar2.b(sVar2);
                } else if (mVar == androidx.lifecycle.k.a(nVar2)) {
                    copyOnWriteArrayList.remove(sVar2);
                    runnable.run();
                }
            }
        }));
    }
}
