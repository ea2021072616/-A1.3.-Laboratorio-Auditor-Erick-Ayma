package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.github.appintro.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.t, androidx.lifecycle.w0, androidx.lifecycle.i, b1.f {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    x mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    androidx.lifecycle.t0 mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    w0 mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    i0 mHost;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.v mLifecycleRegistry;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    b1.e mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    View mView;
    p1 mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    w0 mChildFragmentManager = new x0();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new s(this, 0);
    androidx.lifecycle.n mMaxState = androidx.lifecycle.n.RESUMED;
    androidx.lifecycle.a0 mViewLifecycleOwnerLiveData = new androidx.lifecycle.a0();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<z> mOnPreAttachedListeners = new ArrayList<>();
    private final z mSavedStateAttachListener = new t(this);

    public Fragment() {
        e();
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public final x b() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new x();
        }
        return this.mAnimationInfo;
    }

    public final int c() {
        androidx.lifecycle.n nVar = this.mMaxState;
        return (nVar == androidx.lifecycle.n.INITIALIZED || this.mParentFragment == null) ? nVar.ordinal() : Math.min(nVar.ordinal(), this.mParentFragment.c());
    }

    public void callStartTransitionListener(boolean z4) {
        ViewGroup viewGroup;
        w0 w0Var;
        x xVar = this.mAnimationInfo;
        if (xVar != null) {
            xVar.f1067s = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (w0Var = this.mFragmentManager) == null) {
            return;
        }
        t1 g5 = t1.g(viewGroup, w0Var);
        g5.h();
        if (z4) {
            this.mHost.f920i.post(new j(this, 1, g5));
        } else {
            g5.c();
        }
    }

    public g0 createFragmentContainer() {
        return new u(this);
    }

    public final Fragment d(boolean z4) {
        String str;
        if (z4) {
            u0.b bVar = u0.c.f5128a;
            u0.f fVar = new u0.f(this, 1);
            u0.c.c(fVar);
            u0.b a5 = u0.c.a(this);
            if (a5.f5126a.contains(u0.a.DETECT_TARGET_FRAGMENT_USAGE) && u0.c.e(a5, getClass(), u0.f.class)) {
                u0.c.b(a5, fVar);
            }
        }
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        w0 w0Var = this.mFragmentManager;
        if (w0Var == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return w0Var.A(str);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment d5 = d(false);
        if (d5 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(d5);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            x0.a.a(this).b(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.u(androidx.appcompat.widget.b0.h(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final void e() {
        this.mLifecycleRegistry = new androidx.lifecycle.v(this);
        this.mSavedStateRegistryController = z0.d.c(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        z zVar = this.mSavedStateAttachListener;
        if (this.mState >= 0) {
            zVar.a();
        } else {
            this.mOnPreAttachedListeners.add(zVar);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final androidx.activity.result.e f(b.a aVar, k.a aVar2, androidx.activity.result.c cVar) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            w wVar = new w(this, aVar2, atomicReference, aVar, cVar);
            if (this.mState >= 0) {
                wVar.a();
            } else {
                this.mOnPreAttachedListeners.add(wVar);
            }
            return new androidx.activity.result.e(this, atomicReference, aVar, 2);
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
    }

    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.f1027c.c(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    /* renamed from: getActivity */
    public final d0 a() {
        i0 i0Var = this.mHost;
        if (i0Var == null) {
            return null;
        }
        return (d0) i0Var.f918g;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        x xVar = this.mAnimationInfo;
        if (xVar == null || (bool = xVar.f1064p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        x xVar = this.mAnimationInfo;
        if (xVar == null || (bool = xVar.o) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return null;
        }
        xVar.getClass();
        return null;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final w0 getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        i0 i0Var = this.mHost;
        if (i0Var == null) {
            return null;
        }
        return i0Var.f919h;
    }

    @Override // androidx.lifecycle.i
    public w0.b getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        if (application == null && w0.I(AWAITING_EXIT_EFFECTS)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        w0.e eVar = new w0.e();
        LinkedHashMap linkedHashMap = eVar.f5293a;
        if (application != null) {
            linkedHashMap.put(l2.i.f3855i, application);
        }
        linkedHashMap.put(b4.j.f1662a, this);
        linkedHashMap.put(b4.j.f1663b, this);
        if (getArguments() != null) {
            linkedHashMap.put(b4.j.f1664c, getArguments());
        }
        return eVar;
    }

    @Override // androidx.lifecycle.i
    public androidx.lifecycle.t0 getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager != null) {
            if (this.mDefaultFactory == null) {
                Context applicationContext = requireContext().getApplicationContext();
                while (true) {
                    if (!(applicationContext instanceof ContextWrapper)) {
                        application = null;
                        break;
                    } else if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    } else {
                        applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                    }
                }
                if (application == null && w0.I(AWAITING_EXIT_EFFECTS)) {
                    Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
                }
                this.mDefaultFactory = new androidx.lifecycle.p0(application, this, getArguments());
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public int getEnterAnim() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return 0;
        }
        return xVar.f1051b;
    }

    public Object getEnterTransition() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return null;
        }
        return xVar.f1058i;
    }

    public w.h0 getEnterTransitionCallback() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return null;
        }
        xVar.getClass();
        return null;
    }

    public int getExitAnim() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return 0;
        }
        return xVar.f1052c;
    }

    public Object getExitTransition() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return null;
        }
        return xVar.f1060k;
    }

    public w.h0 getExitTransitionCallback() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return null;
        }
        xVar.getClass();
        return null;
    }

    public View getFocusedView() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return null;
        }
        return xVar.f1066r;
    }

    @Deprecated
    public final w0 getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        i0 i0Var = this.mHost;
        if (i0Var == null) {
            return null;
        }
        return ((c0) i0Var).f839k;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.t
    public androidx.lifecycle.o getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public x0.a getLoaderManager() {
        return x0.a.a(this);
    }

    public int getNextTransition() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return 0;
        }
        return xVar.f1055f;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final w0 getParentFragmentManager() {
        w0 w0Var = this.mFragmentManager;
        if (w0Var != null) {
            return w0Var;
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return false;
        }
        return xVar.f1050a;
    }

    public int getPopEnterAnim() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return 0;
        }
        return xVar.f1053d;
    }

    public int getPopExitAnim() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return 0;
        }
        return xVar.f1054e;
    }

    public float getPostOnViewCreatedAlpha() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return 1.0f;
        }
        return xVar.f1065q;
    }

    public Object getReenterTransition() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return null;
        }
        Object obj = xVar.f1061l;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        u0.b bVar = u0.c.f5128a;
        u0.e eVar = new u0.e(this, 0);
        u0.c.c(eVar);
        u0.b a5 = u0.c.a(this);
        if (a5.f5126a.contains(u0.a.DETECT_RETAIN_INSTANCE_USAGE) && u0.c.e(a5, getClass(), u0.e.class)) {
            u0.c.b(a5, eVar);
        }
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return null;
        }
        Object obj = xVar.f1059j;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // b1.f
    public final b1.d getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f1617b;
    }

    public Object getSharedElementEnterTransition() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return null;
        }
        return xVar.f1062m;
    }

    public Object getSharedElementReturnTransition() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return null;
        }
        Object obj = xVar.f1063n;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        x xVar = this.mAnimationInfo;
        return (xVar == null || (arrayList = xVar.f1056g) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        x xVar = this.mAnimationInfo;
        return (xVar == null || (arrayList = xVar.f1057h) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i5) {
        return getResources().getString(i5);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        return d(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        u0.b bVar = u0.c.f5128a;
        u0.f fVar = new u0.f(this, 0);
        u0.c.c(fVar);
        u0.b a5 = u0.c.a(this);
        if (a5.f5126a.contains(u0.a.DETECT_TARGET_FRAGMENT_USAGE) && u0.c.e(a5, getClass(), u0.f.class)) {
            u0.c.b(a5, fVar);
        }
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i5) {
        return getResources().getText(i5);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public androidx.lifecycle.t getViewLifecycleOwner() {
        p1 p1Var = this.mViewLifecycleOwner;
        if (p1Var != null) {
            return p1Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public androidx.lifecycle.z getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.w0
    public androidx.lifecycle.v0 getViewModelStore() {
        if (this.mFragmentManager != null) {
            if (c() != 1) {
                HashMap hashMap = this.mFragmentManager.L.f1079f;
                androidx.lifecycle.v0 v0Var = (androidx.lifecycle.v0) hashMap.get(this.mWho);
                if (v0Var == null) {
                    androidx.lifecycle.v0 v0Var2 = new androidx.lifecycle.v0();
                    hashMap.put(this.mWho, v0Var2);
                    return v0Var2;
                }
                return v0Var;
            }
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        e();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new x0();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (!this.mHidden) {
            w0 w0Var = this.mFragmentManager;
            if (w0Var == null) {
                return false;
            }
            Fragment fragment = this.mParentFragment;
            w0Var.getClass();
            if (!(fragment == null ? false : fragment.isHidden())) {
                return false;
            }
        }
        return true;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (this.mMenuVisible) {
            if (this.mFragmentManager == null) {
                return true;
            }
            Fragment fragment = this.mParentFragment;
            if (fragment == null ? true : fragment.isMenuVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isPostponed() {
        x xVar = this.mAnimationInfo;
        if (xVar == null) {
            return false;
        }
        return xVar.f1067s;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= RESUMED;
    }

    public final boolean isStateSaved() {
        w0 w0Var = this.mFragmentManager;
        if (w0Var == null) {
            return false;
        }
        return w0Var.M();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.O();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i5, int i6, Intent intent) {
        if (w0.I(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i5 + " resultCode: " + i6 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        i0 i0Var = this.mHost;
        Activity activity = i0Var == null ? null : i0Var.f918g;
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        w0 w0Var = this.mChildFragmentManager;
        if (w0Var.f1042s >= 1) {
            return;
        }
        w0Var.E = false;
        w0Var.F = false;
        w0Var.L.f1082i = false;
        w0Var.t(1);
    }

    public Animation onCreateAnimation(int i5, boolean z4, int i6) {
        return null;
    }

    public Animator onCreateAnimator(int i5, boolean z4, int i6) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i5 = this.mContentLayoutId;
        if (i5 != 0) {
            return layoutInflater.inflate(i5, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z4) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        i0 i0Var = this.mHost;
        Activity activity = i0Var == null ? null : i0Var.f918g;
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z4) {
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z4) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z4) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.O();
        this.mState = AWAITING_EXIT_EFFECTS;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new u1(androidx.appcompat.widget.b0.g("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (w0.I(AWAITING_EXIT_EFFECTS)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
        w0 w0Var = this.mChildFragmentManager;
        w0Var.E = false;
        w0Var.F = false;
        w0Var.L.f1082i = false;
        w0Var.t(ACTIVITY_CREATED);
    }

    public void performAttach() {
        Iterator<z> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f919h);
        if (!this.mCalled) {
            throw new u1(androidx.appcompat.widget.b0.g("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it2 = this.mFragmentManager.f1037m.iterator();
        while (it2.hasNext()) {
            ((a1) it2.next()).a(this);
        }
        w0 w0Var = this.mChildFragmentManager;
        w0Var.E = false;
        w0Var.F = false;
        w0Var.L.f1082i = false;
        w0Var.t(0);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.i(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.O();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new androidx.lifecycle.r() { // from class: androidx.fragment.app.Fragment.6
            @Override // androidx.lifecycle.r
            public final void b(androidx.lifecycle.t tVar, androidx.lifecycle.m mVar) {
                View view;
                if (mVar != androidx.lifecycle.m.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        this.mSavedStateRegistryController.b(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new u1(androidx.appcompat.widget.b0.g("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.e(androidx.lifecycle.m.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z4 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z4 = true;
        }
        return z4 | this.mChildFragmentManager.j(menu, menuInflater);
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.O();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new p1(this, getViewModelStore());
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView == null) {
            if (this.mViewLifecycleOwner.f970j != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
            return;
        }
        this.mViewLifecycleOwner.b();
        b4.j.S(this.mView, this.mViewLifecycleOwner);
        View view = this.mView;
        p1 p1Var = this.mViewLifecycleOwner;
        e4.e.f(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, p1Var);
        b4.j.T(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.f(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.k();
        this.mLifecycleRegistry.e(androidx.lifecycle.m.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new u1(androidx.appcompat.widget.b0.g("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.t(1);
        if (this.mView != null) {
            p1 p1Var = this.mViewLifecycleOwner;
            p1Var.b();
            if (p1Var.f970j.f1151c.compareTo(androidx.lifecycle.n.CREATED) >= 0) {
                this.mViewLifecycleOwner.a(androidx.lifecycle.m.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new u1(androidx.appcompat.widget.b0.g("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        l.k kVar = x0.a.a(this).f5434b.f5432d;
        if (kVar.f3709d <= 0) {
            this.mPerformedCreateView = false;
        } else {
            androidx.appcompat.widget.b0.n(kVar.f3708c[0]);
            throw null;
        }
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new u1(androidx.appcompat.widget.b0.g("Fragment ", this, " did not call through to super.onDetach()"));
        }
        w0 w0Var = this.mChildFragmentManager;
        if (w0Var.G) {
            return;
        }
        w0Var.k();
        this.mChildFragmentManager = new x0();
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z4) {
        onMultiWindowModeChanged(z4);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.o(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.p(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.t(STARTED);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.m.ON_PAUSE);
        }
        this.mLifecycleRegistry.e(androidx.lifecycle.m.ON_PAUSE);
        this.mState = AWAITING_ENTER_EFFECTS;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new u1(androidx.appcompat.widget.b0.g("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z4) {
        onPictureInPictureModeChanged(z4);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z4 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z4 = true;
        }
        return z4 | this.mChildFragmentManager.s(menu);
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean L = w0.L(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != L) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(L);
            onPrimaryNavigationFragmentChanged(L);
            w0 w0Var = this.mChildFragmentManager;
            w0Var.e0();
            w0Var.q(w0Var.f1046w);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.O();
        this.mChildFragmentManager.x(true);
        this.mState = RESUMED;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new u1(androidx.appcompat.widget.b0.g("Fragment ", this, " did not call through to super.onResume()"));
        }
        androidx.lifecycle.v vVar = this.mLifecycleRegistry;
        androidx.lifecycle.m mVar = androidx.lifecycle.m.ON_RESUME;
        vVar.e(mVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.f970j.e(mVar);
        }
        w0 w0Var = this.mChildFragmentManager;
        w0Var.E = false;
        w0Var.F = false;
        w0Var.L.f1082i = false;
        w0Var.t(RESUMED);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.c(bundle);
        bundle.putParcelable("android:support:fragments", this.mChildFragmentManager.V());
    }

    public void performStart() {
        this.mChildFragmentManager.O();
        this.mChildFragmentManager.x(true);
        this.mState = STARTED;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new u1(androidx.appcompat.widget.b0.g("Fragment ", this, " did not call through to super.onStart()"));
        }
        androidx.lifecycle.v vVar = this.mLifecycleRegistry;
        androidx.lifecycle.m mVar = androidx.lifecycle.m.ON_START;
        vVar.e(mVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.f970j.e(mVar);
        }
        w0 w0Var = this.mChildFragmentManager;
        w0Var.E = false;
        w0Var.F = false;
        w0Var.L.f1082i = false;
        w0Var.t(STARTED);
    }

    public void performStop() {
        w0 w0Var = this.mChildFragmentManager;
        w0Var.F = true;
        w0Var.L.f1082i = true;
        w0Var.t(ACTIVITY_CREATED);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.m.ON_STOP);
        }
        this.mLifecycleRegistry.e(androidx.lifecycle.m.ON_STOP);
        this.mState = ACTIVITY_CREATED;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new u1(androidx.appcompat.widget.b0.g("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.t(2);
    }

    public void postponeEnterTransition() {
        b().f1067s = true;
    }

    public final <I, O> androidx.activity.result.d registerForActivityResult(b.a aVar, androidx.activity.result.c cVar) {
        return f(aVar, new v(this), cVar);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i5) {
        if (this.mHost == null) {
            throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " not attached to Activity"));
        }
        w0 parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.B == null) {
            parentFragmentManager.f1043t.getClass();
            return;
        }
        parentFragmentManager.C.addLast(new t0(this.mWho, i5));
        parentFragmentManager.B.a(strArr);
    }

    public final d0 requireActivity() {
        d0 a5 = a();
        if (a5 != null) {
            return a5;
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final w0 requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " not attached to a host."));
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            if (getContext() == null) {
                throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " is not attached to any Fragment or host"));
            }
            throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
        }
        return parentFragment;
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.U(parcelable);
        w0 w0Var = this.mChildFragmentManager;
        w0Var.E = false;
        w0Var.F = false;
        w0Var.L.f1082i = false;
        w0Var.t(1);
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            p1 p1Var = this.mViewLifecycleOwner;
            p1Var.f971k.b(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new u1(androidx.appcompat.widget.b0.g("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.m.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z4) {
        b().f1064p = Boolean.valueOf(z4);
    }

    public void setAllowReturnTransitionOverlap(boolean z4) {
        b().o = Boolean.valueOf(z4);
    }

    public void setAnimations(int i5, int i6, int i7, int i8) {
        if (this.mAnimationInfo == null && i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) {
            return;
        }
        b().f1051b = i5;
        b().f1052c = i6;
        b().f1053d = i7;
        b().f1054e = i8;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(w.h0 h0Var) {
        b().getClass();
    }

    public void setEnterTransition(Object obj) {
        b().f1058i = obj;
    }

    public void setExitSharedElementCallback(w.h0 h0Var) {
        b().getClass();
    }

    public void setExitTransition(Object obj) {
        b().f1060k = obj;
    }

    public void setFocusedView(View view) {
        b().f1066r = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z4) {
        if (this.mHasMenu != z4) {
            this.mHasMenu = z4;
            if (!isAdded() || isHidden()) {
                return;
            }
            ((c0) this.mHost).f839k.invalidateOptionsMenu();
        }
    }

    public void setInitialSavedState(a0 a0Var) {
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        this.mSavedFragmentState = (a0Var == null || (r2 = a0Var.f821b) == null) ? null : null;
    }

    public void setMenuVisibility(boolean z4) {
        if (this.mMenuVisible != z4) {
            this.mMenuVisible = z4;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((c0) this.mHost).f839k.invalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int i5) {
        if (this.mAnimationInfo == null && i5 == 0) {
            return;
        }
        b();
        this.mAnimationInfo.f1055f = i5;
    }

    public void setPopDirection(boolean z4) {
        if (this.mAnimationInfo == null) {
            return;
        }
        b().f1050a = z4;
    }

    public void setPostOnViewCreatedAlpha(float f5) {
        b().f1065q = f5;
    }

    public void setReenterTransition(Object obj) {
        b().f1061l = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z4) {
        u0.b bVar = u0.c.f5128a;
        u0.e eVar = new u0.e(this, 1);
        u0.c.c(eVar);
        u0.b a5 = u0.c.a(this);
        if (a5.f5126a.contains(u0.a.DETECT_RETAIN_INSTANCE_USAGE) && u0.c.e(a5, getClass(), u0.e.class)) {
            u0.c.b(a5, eVar);
        }
        this.mRetainInstance = z4;
        w0 w0Var = this.mFragmentManager;
        if (w0Var == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z4) {
            w0Var.L.c(this);
        } else {
            w0Var.L.f(this);
        }
    }

    public void setReturnTransition(Object obj) {
        b().f1059j = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        b().f1062m = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        b();
        x xVar = this.mAnimationInfo;
        xVar.f1056g = arrayList;
        xVar.f1057h = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        b().f1063n = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i5) {
        if (fragment != null) {
            u0.b bVar = u0.c.f5128a;
            u0.h hVar = new u0.h(this, fragment, i5);
            u0.c.c(hVar);
            u0.b a5 = u0.c.a(this);
            if (a5.f5126a.contains(u0.a.DETECT_TARGET_FRAGMENT_USAGE) && u0.c.e(a5, getClass(), u0.h.class)) {
                u0.c.b(a5, hVar);
            }
        }
        w0 w0Var = this.mFragmentManager;
        w0 w0Var2 = fragment != null ? fragment.mFragmentManager : null;
        if (w0Var != null && w0Var2 != null && w0Var != w0Var2) {
            throw new IllegalArgumentException(androidx.appcompat.widget.b0.g("Fragment ", fragment, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.d(false)) {
            if (fragment2.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i5;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z4) {
        u0.b bVar = u0.c.f5128a;
        u0.i iVar = new u0.i(this, z4);
        u0.c.c(iVar);
        u0.b a5 = u0.c.a(this);
        if (a5.f5126a.contains(u0.a.DETECT_SET_USER_VISIBLE_HINT) && u0.c.e(a5, getClass(), u0.i.class)) {
            u0.c.b(a5, iVar);
        }
        boolean z5 = true;
        if (!this.mUserVisibleHint && z4 && this.mState < STARTED && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            w0 w0Var = this.mFragmentManager;
            d1 f5 = w0Var.f(this);
            Fragment fragment = f5.f860c;
            if (fragment.mDeferStart) {
                if (w0Var.f1026b) {
                    w0Var.H = true;
                } else {
                    fragment.mDeferStart = false;
                    f5.j();
                }
            }
        }
        this.mUserVisibleHint = z4;
        if (this.mState >= STARTED || z4) {
            z5 = false;
        }
        this.mDeferStart = z5;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z4);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        i0 i0Var = this.mHost;
        if (i0Var != null) {
            return w.h.d0(((c0) i0Var).f839k, str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i5) {
        startActivityForResult(intent, i5, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        Intent intent2 = intent;
        if (this.mHost == null) {
            throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " not attached to Activity"));
        }
        if (w0.I(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i5 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        w0 parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.A == null) {
            i0 i0Var = parentFragmentManager.f1043t;
            if (i5 == -1) {
                i0Var.f918g.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
                return;
            } else {
                i0Var.getClass();
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
        }
        if (bundle != null) {
            if (intent2 == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (w0.I(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + this);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        e4.e.f(intentSender, "intentSender");
        androidx.activity.result.k kVar = new androidx.activity.result.k(intentSender, intent2, i6, i7);
        parentFragmentManager.C.addLast(new t0(this.mWho, i5));
        if (w0.I(2)) {
            Log.v("FragmentManager", "Fragment " + this + "is launching an IntentSender for result ");
        }
        parentFragmentManager.A.a(kVar);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !b().f1067s) {
            return;
        }
        if (this.mHost == null) {
            b().f1067s = false;
        } else if (Looper.myLooper() != this.mHost.f920i.getLooper()) {
            this.mHost.f920i.postAtFrontOfQueue(new s(this, 1));
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) q0.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (IllegalAccessException e5) {
            throw new y("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e5);
        } catch (InstantiationException e6) {
            throw new y("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e6);
        } catch (NoSuchMethodException e7) {
            throw new y("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e7);
        } catch (InvocationTargetException e8) {
            throw new y("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e8);
        }
    }

    public final String getString(int i5, Object... objArr) {
        return getResources().getString(i5, objArr);
    }

    public final void postponeEnterTransition(long j5, TimeUnit timeUnit) {
        Handler handler;
        b().f1067s = true;
        w0 w0Var = this.mFragmentManager;
        if (w0Var != null) {
            handler = w0Var.f1043t.f920i;
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j5));
    }

    public final <I, O> androidx.activity.result.d registerForActivityResult(b.a aVar, androidx.activity.result.h hVar, androidx.activity.result.c cVar) {
        return f(aVar, new l0(this, hVar), cVar);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        i0 i0Var = this.mHost;
        if (i0Var != null) {
            i0Var.f919h.startActivity(intent, bundle);
            return;
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i5, Bundle bundle) {
        if (this.mHost != null) {
            w0 parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.f1049z != null) {
                parentFragmentManager.C.addLast(new t0(this.mWho, i5));
                if (intent != null && bundle != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                }
                parentFragmentManager.f1049z.a(intent);
                return;
            }
            i0 i0Var = parentFragmentManager.f1043t;
            if (i5 == -1) {
                i0Var.f919h.startActivity(intent, bundle);
                return;
            } else {
                i0Var.getClass();
                throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            }
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        i0 i0Var = this.mHost;
        if (i0Var != null) {
            d0 d0Var = ((c0) i0Var).f839k;
            LayoutInflater cloneInContext = d0Var.getLayoutInflater().cloneInContext(d0Var);
            cloneInContext.setFactory2(this.mChildFragmentManager.f1030f);
            return cloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
