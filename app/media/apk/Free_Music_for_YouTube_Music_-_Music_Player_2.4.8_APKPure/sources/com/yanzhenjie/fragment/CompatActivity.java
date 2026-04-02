package com.yanzhenjie.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class CompatActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_INVALID = -1;
    private FragmentManager mFManager;
    private AtomicInteger mAtomicInteger = new AtomicInteger();
    private List<com.yanzhenjie.fragment.a> mFragmentStack = new ArrayList();
    private Map<com.yanzhenjie.fragment.a, a> mFragmentEntityMap = new HashMap();

    @IdRes
    protected abstract int fragmentLayoutId();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f5191a;

        /* renamed from: b  reason: collision with root package name */
        Bundle f5192b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5193c;
        private int d;

        private a() {
            this.f5193c = false;
            this.d = -1;
            this.f5191a = 0;
            this.f5192b = null;
        }
    }

    public final <T extends com.yanzhenjie.fragment.a> T fragment(Class<T> cls) {
        return (T) Fragment.instantiate(this, cls.getName());
    }

    public final <T extends com.yanzhenjie.fragment.a> T fragment(Class<T> cls, Bundle bundle) {
        return (T) Fragment.instantiate(this, cls.getName(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mFManager = getSupportFragmentManager();
    }

    public final <T extends com.yanzhenjie.fragment.a> void startFragment(Class<T> cls) {
        try {
            startFragment(null, cls.newInstance(), true, -1);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public final <T extends com.yanzhenjie.fragment.a> void startFragment(Class<T> cls, boolean z) {
        try {
            startFragment(null, cls.newInstance(), z, -1);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public final <T extends com.yanzhenjie.fragment.a> void startFragment(T t) {
        startFragment(null, t, true, -1);
    }

    public final <T extends com.yanzhenjie.fragment.a> void startFragment(T t, boolean z) {
        startFragment(null, t, z, -1);
    }

    @Deprecated
    public final <T extends com.yanzhenjie.fragment.a> void startFragmentForResquest(Class<T> cls, int i) {
        startFragmentForResult(cls, i);
    }

    @Deprecated
    public final <T extends com.yanzhenjie.fragment.a> void startFragmentForResquest(T t, int i) {
        startFragmentForResult((CompatActivity) t, i);
    }

    public final <T extends com.yanzhenjie.fragment.a> void startFragmentForResult(Class<T> cls, int i) {
        if (i == -1) {
            throw new IllegalArgumentException("The requestCode must be positive integer.");
        }
        try {
            startFragment(null, cls.newInstance(), true, i);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public final <T extends com.yanzhenjie.fragment.a> void startFragmentForResult(T t, int i) {
        if (i == -1) {
            throw new IllegalArgumentException("The requestCode must be positive integer.");
        }
        startFragment(null, t, true, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T extends com.yanzhenjie.fragment.a> void startFragment(T t, T t2, boolean z, int i) {
        FragmentTransaction fragmentTransaction;
        a aVar = new a();
        aVar.f5193c = z;
        aVar.d = i;
        t2.setStackEntity(aVar);
        FragmentTransaction beginTransaction = this.mFManager.beginTransaction();
        if (t == null) {
            fragmentTransaction = beginTransaction;
        } else if (this.mFragmentEntityMap.get(t).f5193c) {
            t.onPause();
            t.onStop();
            beginTransaction.hide(t);
            fragmentTransaction = beginTransaction;
        } else {
            beginTransaction.remove(t);
            beginTransaction.commit();
            this.mFragmentStack.remove(t);
            this.mFragmentEntityMap.remove(t);
            fragmentTransaction = this.mFManager.beginTransaction();
        }
        String str = t2.getClass().getSimpleName() + this.mAtomicInteger.incrementAndGet();
        fragmentTransaction.add(fragmentLayoutId(), t2, str);
        fragmentTransaction.addToBackStack(str);
        fragmentTransaction.commitAllowingStateLoss();
        this.mFragmentStack.add(t2);
        this.mFragmentEntityMap.put(t2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean onBackStackFragment() {
        if (this.mFragmentStack.size() > 1) {
            this.mFManager.popBackStack();
            com.yanzhenjie.fragment.a aVar = this.mFragmentStack.get(this.mFragmentStack.size() - 2);
            FragmentTransaction beginTransaction = this.mFManager.beginTransaction();
            beginTransaction.show(aVar);
            beginTransaction.commit();
            com.yanzhenjie.fragment.a aVar2 = this.mFragmentStack.get(this.mFragmentStack.size() - 1);
            aVar.onResume();
            a aVar3 = this.mFragmentEntityMap.get(aVar2);
            this.mFragmentStack.remove(aVar2);
            this.mFragmentEntityMap.remove(aVar2);
            if (aVar3.d != -1) {
                aVar.onFragmentResult(aVar3.d, aVar3.f5191a, aVar3.f5192b);
            }
            return true;
        }
        return false;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (!onBackStackFragment()) {
            finish();
        }
    }
}
