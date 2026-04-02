package com.bumptech.glide.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
/* compiled from: RequestManagerRetriever.java */
/* loaded from: classes.dex */
public class k implements Handler.Callback {

    /* renamed from: c  reason: collision with root package name */
    private static final k f655c = new k();
    private volatile com.bumptech.glide.l d;

    /* renamed from: a  reason: collision with root package name */
    final Map<FragmentManager, j> f656a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Map<android.support.v4.app.FragmentManager, n> f657b = new HashMap();
    private final Handler e = new Handler(Looper.getMainLooper(), this);

    public static k a() {
        return f655c;
    }

    k() {
    }

    private com.bumptech.glide.l b(Context context) {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = new com.bumptech.glide.l(context.getApplicationContext(), new b(), new f());
                }
            }
        }
        return this.d;
    }

    public com.bumptech.glide.l a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.bumptech.glide.i.h.c() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return a((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return a(((ContextWrapper) context).getBaseContext());
            }
        }
        return b(context);
    }

    public com.bumptech.glide.l a(FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.i.h.d()) {
            return a(fragmentActivity.getApplicationContext());
        }
        b((Activity) fragmentActivity);
        return a(fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    @TargetApi(11)
    public com.bumptech.glide.l a(Activity activity) {
        if (com.bumptech.glide.i.h.d() || Build.VERSION.SDK_INT < 11) {
            return a(activity.getApplicationContext());
        }
        b(activity);
        return a(activity, activity.getFragmentManager());
    }

    @TargetApi(17)
    private static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(17)
    public j a(FragmentManager fragmentManager) {
        j jVar = (j) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (jVar == null) {
            j jVar2 = this.f656a.get(fragmentManager);
            if (jVar2 == null) {
                j jVar3 = new j();
                this.f656a.put(fragmentManager, jVar3);
                fragmentManager.beginTransaction().add(jVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.e.obtainMessage(1, fragmentManager).sendToTarget();
                return jVar3;
            }
            return jVar2;
        }
        return jVar;
    }

    @TargetApi(11)
    com.bumptech.glide.l a(Context context, FragmentManager fragmentManager) {
        j a2 = a(fragmentManager);
        com.bumptech.glide.l b2 = a2.b();
        if (b2 == null) {
            com.bumptech.glide.l lVar = new com.bumptech.glide.l(context, a2.a(), a2.c());
            a2.a(lVar);
            return lVar;
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n a(android.support.v4.app.FragmentManager fragmentManager) {
        n nVar = (n) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (nVar == null) {
            n nVar2 = this.f657b.get(fragmentManager);
            if (nVar2 == null) {
                n nVar3 = new n();
                this.f657b.put(fragmentManager, nVar3);
                fragmentManager.beginTransaction().add(nVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.e.obtainMessage(2, fragmentManager).sendToTarget();
                return nVar3;
            }
            return nVar2;
        }
        return nVar;
    }

    com.bumptech.glide.l a(Context context, android.support.v4.app.FragmentManager fragmentManager) {
        n a2 = a(fragmentManager);
        com.bumptech.glide.l b2 = a2.b();
        if (b2 == null) {
            com.bumptech.glide.l lVar = new com.bumptech.glide.l(context, a2.a(), a2.c());
            a2.a(lVar);
            return lVar;
        }
        return b2;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ComponentCallbacks remove;
        Object obj = null;
        boolean z = true;
        switch (message.what) {
            case 1:
                obj = (FragmentManager) message.obj;
                remove = this.f656a.remove(obj);
                break;
            case 2:
                obj = (android.support.v4.app.FragmentManager) message.obj;
                remove = this.f657b.remove(obj);
                break;
            default:
                z = false;
                remove = null;
                break;
        }
        if (z && remove == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
