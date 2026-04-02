package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.appintro.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: a  reason: collision with root package name */
    public final l0 f858a;

    /* renamed from: b  reason: collision with root package name */
    public final e1 f859b;

    /* renamed from: c  reason: collision with root package name */
    public final Fragment f860c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f861d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f862e = -1;

    public d1(l0 l0Var, e1 e1Var, Fragment fragment) {
        this.f858a = l0Var;
        this.f859b = e1Var;
        this.f860c = fragment;
    }

    public final void a() {
        View view;
        View view2;
        e1 e1Var = this.f859b;
        e1Var.getClass();
        Fragment fragment = this.f860c;
        ViewGroup viewGroup = fragment.mContainer;
        int i5 = -1;
        if (viewGroup != null) {
            ArrayList arrayList = e1Var.f867a;
            int indexOf = arrayList.indexOf(fragment);
            int i6 = indexOf - 1;
            while (true) {
                if (i6 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        Fragment fragment2 = (Fragment) arrayList.get(indexOf);
                        if (fragment2.mContainer == viewGroup && (view = fragment2.mView) != null) {
                            i5 = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    Fragment fragment3 = (Fragment) arrayList.get(i6);
                    if (fragment3.mContainer == viewGroup && (view2 = fragment3.mView) != null) {
                        i5 = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i6--;
                }
            }
        }
        fragment.mContainer.addView(fragment.mView, i5);
    }

    public final void b() {
        boolean I = w0.I(3);
        Fragment fragment = this.f860c;
        if (I) {
            Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        d1 d1Var = null;
        e1 e1Var = this.f859b;
        if (fragment2 != null) {
            d1 d1Var2 = (d1) e1Var.f868b.get(fragment2.mWho);
            if (d1Var2 == null) {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
            }
            fragment.mTargetWho = fragment.mTarget.mWho;
            fragment.mTarget = null;
            d1Var = d1Var2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (d1Var = (d1) e1Var.f868b.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(androidx.appcompat.widget.b0.i(sb, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (d1Var != null) {
            d1Var.j();
        }
        w0 w0Var = fragment.mFragmentManager;
        fragment.mHost = w0Var.f1043t;
        fragment.mParentFragment = w0Var.f1045v;
        l0 l0Var = this.f858a;
        l0Var.h(false);
        fragment.performAttach();
        l0Var.c(false);
    }

    public final int c() {
        s1 s1Var;
        Fragment fragment = this.f860c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i5 = this.f862e;
        int ordinal = fragment.mMaxState.ordinal();
        if (ordinal == 1) {
            i5 = Math.min(i5, 0);
        } else if (ordinal == 2) {
            i5 = Math.min(i5, 1);
        } else if (ordinal == 3) {
            i5 = Math.min(i5, 5);
        } else if (ordinal != 4) {
            i5 = Math.min(i5, -1);
        }
        if (fragment.mFromLayout) {
            if (fragment.mInLayout) {
                i5 = Math.max(this.f862e, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    i5 = Math.min(i5, 2);
                }
            } else {
                i5 = this.f862e < 4 ? Math.min(i5, fragment.mState) : Math.min(i5, 1);
            }
        }
        if (!fragment.mAdded) {
            i5 = Math.min(i5, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            t1 g5 = t1.g(viewGroup, fragment.getParentFragmentManager());
            g5.getClass();
            s1 d5 = g5.d(fragment);
            r6 = d5 != null ? d5.f1000b : 0;
            Iterator it = g5.f1012c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    s1Var = null;
                    break;
                }
                s1Var = (s1) it.next();
                if (s1Var.f1001c.equals(fragment) && !s1Var.f1004f) {
                    break;
                }
            }
            if (s1Var != null && (r6 == 0 || r6 == 1)) {
                r6 = s1Var.f1000b;
            }
        }
        if (r6 == 2) {
            i5 = Math.min(i5, 6);
        } else if (r6 == 3) {
            i5 = Math.max(i5, 3);
        } else if (fragment.mRemoving) {
            i5 = fragment.isInBackStack() ? Math.min(i5, 1) : Math.min(i5, -1);
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            i5 = Math.min(i5, 4);
        }
        if (w0.I(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i5 + " for " + fragment);
        }
        return i5;
    }

    public final void d() {
        boolean I = w0.I(3);
        Fragment fragment = this.f860c;
        if (I) {
            Log.d("FragmentManager", "moveto CREATED: " + fragment);
        }
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            fragment.mState = 1;
            return;
        }
        l0 l0Var = this.f858a;
        l0Var.i(false);
        fragment.performCreate(fragment.mSavedFragmentState);
        l0Var.d(false);
    }

    public final void e() {
        String str;
        Fragment fragment = this.f860c;
        if (fragment.mFromLayout) {
            return;
        }
        if (w0.I(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
        }
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            int i5 = fragment.mContainerId;
            if (i5 == 0) {
                viewGroup = null;
            } else if (i5 == -1) {
                throw new IllegalArgumentException(androidx.appcompat.widget.b0.g("Cannot create fragment ", fragment, " for a container view with no id"));
            } else {
                viewGroup = (ViewGroup) fragment.mFragmentManager.f1044u.b(i5);
                if (viewGroup == null) {
                    if (!fragment.mRestored) {
                        try {
                            str = fragment.getResources().getResourceName(fragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + str + ") for fragment " + fragment);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    u0.b bVar = u0.c.f5128a;
                    u0.d dVar = new u0.d(fragment, viewGroup, 1);
                    u0.c.c(dVar);
                    u0.b a5 = u0.c.a(fragment);
                    if (a5.f5126a.contains(u0.a.DETECT_WRONG_FRAGMENT_CONTAINER) && u0.c.e(a5, fragment.getClass(), u0.d.class)) {
                        u0.c.b(a5, dVar);
                    }
                }
            }
        }
        fragment.mContainer = viewGroup;
        fragment.performCreateView(performGetLayoutInflater, viewGroup, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
            if (viewGroup != null) {
                a();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view2 = fragment.mView;
            WeakHashMap weakHashMap = h0.z0.f3233a;
            if (view2.isAttachedToWindow()) {
                h0.m0.c(fragment.mView);
            } else {
                View view3 = fragment.mView;
                view3.addOnAttachStateChangeListener(new j0(this, view3));
            }
            fragment.performViewCreated();
            this.f858a.n(false);
            int visibility = fragment.mView.getVisibility();
            fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
            if (fragment.mContainer != null && visibility == 0) {
                View findFocus = fragment.mView.findFocus();
                if (findFocus != null) {
                    fragment.setFocusedView(findFocus);
                    if (w0.I(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment);
                    }
                }
                fragment.mView.setAlpha(0.0f);
            }
        }
        fragment.mState = 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r9 = this;
            r0 = 3
            boolean r0 = androidx.fragment.app.w0.I(r0)
            androidx.fragment.app.Fragment r1 = r9.f860c
            if (r0 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "movefrom CREATED: "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "FragmentManager"
            android.util.Log.d(r2, r0)
        L1c:
            boolean r0 = r1.mRemoving
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L2a
            boolean r0 = r1.isInBackStack()
            if (r0 != 0) goto L2a
            r0 = r2
            goto L2b
        L2a:
            r0 = r3
        L2b:
            r4 = 0
            androidx.fragment.app.e1 r5 = r9.f859b
            if (r0 == 0) goto L39
            boolean r6 = r1.mBeingSaved
            if (r6 != 0) goto L39
            java.lang.String r6 = r1.mWho
            r5.i(r6, r4)
        L39:
            if (r0 != 0) goto L54
            androidx.fragment.app.z0 r6 = r5.f870d
            java.util.HashMap r7 = r6.f1077d
            java.lang.String r8 = r1.mWho
            boolean r7 = r7.containsKey(r8)
            if (r7 != 0) goto L49
        L47:
            r6 = r2
            goto L4f
        L49:
            boolean r7 = r6.f1080g
            if (r7 == 0) goto L47
            boolean r6 = r6.f1081h
        L4f:
            if (r6 == 0) goto L52
            goto L54
        L52:
            r6 = r3
            goto L55
        L54:
            r6 = r2
        L55:
            if (r6 == 0) goto Lb9
            androidx.fragment.app.i0 r6 = r1.mHost
            boolean r7 = r6 instanceof androidx.lifecycle.w0
            if (r7 == 0) goto L62
            androidx.fragment.app.z0 r2 = r5.f870d
            boolean r2 = r2.f1081h
            goto L6f
        L62:
            android.content.Context r6 = r6.f919h
            boolean r7 = r6 instanceof android.app.Activity
            if (r7 == 0) goto L6f
            android.app.Activity r6 = (android.app.Activity) r6
            boolean r6 = r6.isChangingConfigurations()
            r2 = r2 ^ r6
        L6f:
            if (r0 == 0) goto L75
            boolean r0 = r1.mBeingSaved
            if (r0 == 0) goto L77
        L75:
            if (r2 == 0) goto L7c
        L77:
            androidx.fragment.app.z0 r0 = r5.f870d
            r0.d(r1)
        L7c:
            r1.performDestroy()
            androidx.fragment.app.l0 r0 = r9.f858a
            r0.e(r3)
            java.util.ArrayList r0 = r5.d()
            java.util.Iterator r0 = r0.iterator()
        L8c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Lab
            java.lang.Object r2 = r0.next()
            androidx.fragment.app.d1 r2 = (androidx.fragment.app.d1) r2
            if (r2 == 0) goto L8c
            java.lang.String r3 = r1.mWho
            androidx.fragment.app.Fragment r2 = r2.f860c
            java.lang.String r6 = r2.mTargetWho
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L8c
            r2.mTarget = r1
            r2.mTargetWho = r4
            goto L8c
        Lab:
            java.lang.String r0 = r1.mTargetWho
            if (r0 == 0) goto Lb5
            androidx.fragment.app.Fragment r0 = r5.b(r0)
            r1.mTarget = r0
        Lb5:
            r5.h(r9)
            goto Lcb
        Lb9:
            java.lang.String r0 = r1.mTargetWho
            if (r0 == 0) goto Lc9
            androidx.fragment.app.Fragment r0 = r5.b(r0)
            if (r0 == 0) goto Lc9
            boolean r2 = r0.mRetainInstance
            if (r2 == 0) goto Lc9
            r1.mTarget = r0
        Lc9:
            r1.mState = r3
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.d1.f():void");
    }

    public final void g() {
        View view;
        boolean I = w0.I(3);
        Fragment fragment = this.f860c;
        if (I) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        fragment.performDestroyView();
        this.f858a.o(false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.f(null);
        fragment.mInLayout = false;
    }

    public final void h() {
        boolean I = w0.I(3);
        Fragment fragment = this.f860c;
        if (I) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + fragment);
        }
        fragment.performDetach();
        boolean z4 = false;
        this.f858a.f(false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        boolean z5 = true;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z4 = true;
        }
        if (!z4) {
            z0 z0Var = this.f859b.f870d;
            if (z0Var.f1077d.containsKey(fragment.mWho) && z0Var.f1080g) {
                z5 = z0Var.f1081h;
            }
            if (!z5) {
                return;
            }
        }
        if (w0.I(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + fragment);
        }
        fragment.initState();
    }

    public final void i() {
        Fragment fragment = this.f860c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (w0.I(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
            }
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.performViewCreated();
                this.f858a.n(false);
                fragment.mState = 2;
            }
        }
    }

    public final void j() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z4 = this.f861d;
        Fragment fragment = this.f860c;
        if (z4) {
            if (w0.I(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + fragment);
                return;
            }
            return;
        }
        try {
            this.f861d = true;
            boolean z5 = false;
            while (true) {
                int c5 = c();
                int i5 = fragment.mState;
                e1 e1Var = this.f859b;
                if (c5 == i5) {
                    if (!z5 && i5 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !fragment.mBeingSaved) {
                        if (w0.I(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + fragment);
                        }
                        e1Var.f870d.d(fragment);
                        e1Var.h(this);
                        if (w0.I(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + fragment);
                        }
                        fragment.initState();
                    }
                    if (fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            t1 g5 = t1.g(viewGroup, fragment.getParentFragmentManager());
                            if (fragment.mHidden) {
                                g5.getClass();
                                if (w0.I(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragment);
                                }
                                g5.a(3, 1, this);
                            } else {
                                g5.getClass();
                                if (w0.I(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragment);
                                }
                                g5.a(2, 1, this);
                            }
                        }
                        w0 w0Var = fragment.mFragmentManager;
                        if (w0Var != null && fragment.mAdded && w0.J(fragment)) {
                            w0Var.D = true;
                        }
                        fragment.mHiddenChanged = false;
                        fragment.onHiddenChanged(fragment.mHidden);
                        fragment.mChildFragmentManager.n();
                    }
                    return;
                }
                l0 l0Var = this.f858a;
                if (c5 > i5) {
                    switch (i5 + 1) {
                        case 0:
                            b();
                            continue;
                        case 1:
                            d();
                            continue;
                        case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                            i();
                            e();
                            continue;
                        case 3:
                            if (w0.I(3)) {
                                Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
                            }
                            fragment.performActivityCreated(fragment.mSavedFragmentState);
                            l0Var.b(false);
                            continue;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                t1 g6 = t1.g(viewGroup3, fragment.getParentFragmentManager());
                                int b5 = androidx.appcompat.widget.b0.b(fragment.mView.getVisibility());
                                g6.getClass();
                                if (w0.I(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragment);
                                }
                                g6.a(b5, 2, this);
                            }
                            fragment.mState = 4;
                            continue;
                        case 5:
                            if (w0.I(3)) {
                                Log.d("FragmentManager", "moveto STARTED: " + fragment);
                            }
                            fragment.performStart();
                            l0Var.l(false);
                            continue;
                        case 6:
                            fragment.mState = 6;
                            continue;
                        case 7:
                            l();
                            continue;
                    }
                } else {
                    switch (i5 - 1) {
                        case androidx.viewpager.widget.a.POSITION_UNCHANGED /* -1 */:
                            h();
                            continue;
                        case 0:
                            if (fragment.mBeingSaved) {
                                if (((c1) e1Var.f869c.get(fragment.mWho)) == null) {
                                    m();
                                }
                            }
                            f();
                            continue;
                        case 1:
                            g();
                            fragment.mState = 1;
                            continue;
                        case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            continue;
                        case 3:
                            if (w0.I(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mBeingSaved) {
                                m();
                            } else if (fragment.mView != null && fragment.mSavedViewState == null) {
                                n();
                            }
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                t1 g7 = t1.g(viewGroup2, fragment.getParentFragmentManager());
                                g7.getClass();
                                if (w0.I(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragment);
                                }
                                g7.a(1, 3, this);
                            }
                            fragment.mState = 3;
                            continue;
                        case 4:
                            if (w0.I(3)) {
                                Log.d("FragmentManager", "movefrom STARTED: " + fragment);
                            }
                            fragment.performStop();
                            l0Var.m(false);
                            continue;
                        case 5:
                            fragment.mState = 5;
                            continue;
                        case 6:
                            if (w0.I(3)) {
                                Log.d("FragmentManager", "movefrom RESUMED: " + fragment);
                            }
                            fragment.performPause();
                            l0Var.g(false);
                            continue;
                        default:
                            continue;
                    }
                }
                z5 = true;
            }
        } finally {
            this.f861d = false;
        }
    }

    public final void k(ClassLoader classLoader) {
        Fragment fragment = this.f860c;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("android:view_registry_state");
        fragment.mTargetWho = fragment.mSavedFragmentState.getString("android:target_state");
        if (fragment.mTargetWho != null) {
            fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Boolean bool = fragment.mSavedUserVisibleHint;
        if (bool != null) {
            fragment.mUserVisibleHint = bool.booleanValue();
            fragment.mSavedUserVisibleHint = null;
        } else {
            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (fragment.mUserVisibleHint) {
            return;
        }
        fragment.mDeferStart = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            r7 = this;
            r0 = 3
            boolean r0 = androidx.fragment.app.w0.I(r0)
            java.lang.String r1 = "FragmentManager"
            androidx.fragment.app.Fragment r2 = r7.f860c
            if (r0 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "moveto RESUMED: "
            r0.<init>(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L1c:
            android.view.View r0 = r2.getFocusedView()
            r3 = 0
            if (r0 == 0) goto L7d
            android.view.View r4 = r2.mView
            if (r0 != r4) goto L28
            goto L32
        L28:
            android.view.ViewParent r4 = r0.getParent()
        L2c:
            if (r4 == 0) goto L39
            android.view.View r5 = r2.mView
            if (r4 != r5) goto L34
        L32:
            r4 = 1
            goto L3a
        L34:
            android.view.ViewParent r4 = r4.getParent()
            goto L2c
        L39:
            r4 = r3
        L3a:
            if (r4 == 0) goto L7d
            boolean r4 = r0.requestFocus()
            r5 = 2
            boolean r5 = androidx.fragment.app.w0.I(r5)
            if (r5 == 0) goto L7d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "requestFocus: Restoring focused view "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r0 = " "
            r5.append(r0)
            if (r4 == 0) goto L5b
            java.lang.String r0 = "succeeded"
            goto L5d
        L5b:
            java.lang.String r0 = "failed"
        L5d:
            r5.append(r0)
            java.lang.String r0 = " on Fragment "
            r5.append(r0)
            r5.append(r2)
            java.lang.String r0 = " resulting in focused view "
            r5.append(r0)
            android.view.View r0 = r2.mView
            android.view.View r0 = r0.findFocus()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            android.util.Log.v(r1, r0)
        L7d:
            r0 = 0
            r2.setFocusedView(r0)
            r2.performResume()
            androidx.fragment.app.l0 r1 = r7.f858a
            r1.j(r3)
            r2.mSavedFragmentState = r0
            r2.mSavedViewState = r0
            r2.mSavedViewRegistryState = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.d1.l():void");
    }

    public final void m() {
        Fragment fragment = this.f860c;
        c1 c1Var = new c1(fragment);
        if (fragment.mState <= -1 || c1Var.f852n != null) {
            c1Var.f852n = fragment.mSavedFragmentState;
        } else {
            Bundle bundle = new Bundle();
            fragment.performSaveInstanceState(bundle);
            this.f858a.k(false);
            if (bundle.isEmpty()) {
                bundle = null;
            }
            if (fragment.mView != null) {
                n();
            }
            if (fragment.mSavedViewState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
            }
            if (fragment.mSavedViewRegistryState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBundle("android:view_registry_state", fragment.mSavedViewRegistryState);
            }
            if (!fragment.mUserVisibleHint) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
            }
            c1Var.f852n = bundle;
            if (fragment.mTargetWho != null) {
                if (bundle == null) {
                    c1Var.f852n = new Bundle();
                }
                c1Var.f852n.putString("android:target_state", fragment.mTargetWho);
                int i5 = fragment.mTargetRequestCode;
                if (i5 != 0) {
                    c1Var.f852n.putInt("android:target_req_state", i5);
                }
            }
        }
        this.f859b.i(fragment.mWho, c1Var);
    }

    public final void n() {
        Fragment fragment = this.f860c;
        if (fragment.mView == null) {
            return;
        }
        if (w0.I(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + fragment + " with view " + fragment.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.mViewLifecycleOwner.f971k.c(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        fragment.mSavedViewRegistryState = bundle;
    }

    public d1(l0 l0Var, e1 e1Var, ClassLoader classLoader, q0 q0Var, c1 c1Var) {
        this.f858a = l0Var;
        this.f859b = e1Var;
        Fragment a5 = q0Var.a(c1Var.f840b);
        Bundle bundle = c1Var.f849k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a5.setArguments(bundle);
        a5.mWho = c1Var.f841c;
        a5.mFromLayout = c1Var.f842d;
        a5.mRestored = true;
        a5.mFragmentId = c1Var.f843e;
        a5.mContainerId = c1Var.f844f;
        a5.mTag = c1Var.f845g;
        a5.mRetainInstance = c1Var.f846h;
        a5.mRemoving = c1Var.f847i;
        a5.mDetached = c1Var.f848j;
        a5.mHidden = c1Var.f850l;
        a5.mMaxState = androidx.lifecycle.n.values()[c1Var.f851m];
        Bundle bundle2 = c1Var.f852n;
        if (bundle2 != null) {
            a5.mSavedFragmentState = bundle2;
        } else {
            a5.mSavedFragmentState = new Bundle();
        }
        this.f860c = a5;
        if (w0.I(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a5);
        }
    }

    public d1(l0 l0Var, e1 e1Var, Fragment fragment, c1 c1Var) {
        this.f858a = l0Var;
        this.f859b = e1Var;
        this.f860c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = c1Var.f852n;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
