package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
@zzzt
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzgi implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzawo = ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkt)).longValue();
    private final Context mApplicationContext;
    private final WindowManager zzavh;
    private final PowerManager zzavi;
    private final KeyguardManager zzavj;
    @Nullable
    private BroadcastReceiver zzavr;
    private Application zzawp;
    private WeakReference<ViewTreeObserver> zzawq;
    private WeakReference<View> zzawr;
    private zzgn zzaws;
    private DisplayMetrics zzawv;
    private zzaix zzaun = new zzaix(zzawo);
    private boolean zzavq = false;
    private int zzawt = -1;
    private HashSet<zzgm> zzawu = new HashSet<>();

    public zzgi(Context context, View view) {
        this.mApplicationContext = context.getApplicationContext();
        this.zzavh = (WindowManager) context.getSystemService("window");
        this.zzavi = (PowerManager) this.mApplicationContext.getSystemService("power");
        this.zzavj = (KeyguardManager) context.getSystemService("keyguard");
        if (this.mApplicationContext instanceof Application) {
            this.zzawp = (Application) this.mApplicationContext;
            this.zzaws = new zzgn((Application) this.mApplicationContext, this);
        }
        this.zzawv = context.getResources().getDisplayMetrics();
        View view2 = this.zzawr != null ? this.zzawr.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zze(view2);
        }
        this.zzawr = new WeakReference<>(view);
        if (view != null) {
            if (com.google.android.gms.ads.internal.zzbv.zzec().isAttachedToWindow(view)) {
                zzd(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzl(rect.left), zzl(rect.top), zzl(rect.right), zzl(rect.bottom));
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzawr == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = this.zzawr.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzawt = i;
    }

    private final void zzd(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzawq = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzavr == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzavr = new zzgk(this);
            this.mApplicationContext.registerReceiver(this.zzavr, intentFilter);
        }
        if (this.zzawp != null) {
            try {
                this.zzawp.registerActivityLifecycleCallbacks(this.zzaws);
            } catch (Exception e) {
                zzafx.zzb("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zze(View view) {
        try {
            if (this.zzawq != null) {
                ViewTreeObserver viewTreeObserver = this.zzawq.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzawq = null;
            }
        } catch (Exception e) {
            zzafx.zzb("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzafx.zzb("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zzavr != null) {
            try {
                this.mApplicationContext.unregisterReceiver(this.zzavr);
            } catch (IllegalStateException e3) {
                zzafx.zzb("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                com.google.android.gms.ads.internal.zzbv.zzee().zza(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzavr = null;
        }
        if (this.zzawp != null) {
            try {
                this.zzawp.unregisterActivityLifecycleCallbacks(this.zzaws);
            } catch (Exception e5) {
                zzafx.zzb("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    private final void zzgb() {
        com.google.android.gms.ads.internal.zzbv.zzea();
        zzahf.zzdbo.post(new zzgj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(int i) {
        if (this.zzawu.size() == 0 || this.zzawr == null) {
            return;
        }
        View view = this.zzawr.get();
        boolean z = i == 1;
        boolean z2 = view == null;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        boolean z3 = false;
        Rect rect3 = new Rect();
        boolean z4 = false;
        Rect rect4 = new Rect();
        Rect rect5 = new Rect();
        rect5.right = this.zzavh.getDefaultDisplay().getWidth();
        rect5.bottom = this.zzavh.getDefaultDisplay().getHeight();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view != null) {
            z3 = view.getGlobalVisibleRect(rect2);
            z4 = view.getLocalVisibleRect(rect3);
            view.getHitRect(rect4);
            try {
                view.getLocationOnScreen(iArr);
                view.getLocationInWindow(iArr2);
            } catch (Exception e) {
                zzafx.zzb("Failure getting view location.", e);
            }
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
        }
        int windowVisibility = view != null ? view.getWindowVisibility() : 8;
        if (this.zzawt != -1) {
            windowVisibility = this.zzawt;
        }
        boolean z5 = !z2 && com.google.android.gms.ads.internal.zzbv.zzea().zza(view, this.zzavi, this.zzavj) && z3 && z4 && windowVisibility == 0;
        if (z && !this.zzaun.tryAcquire() && z5 == this.zzavq) {
            return;
        }
        if (z5 || this.zzavq || i != 1) {
            zzgl zzglVar = new zzgl(com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime(), this.zzavi.isScreenOn(), view != null ? com.google.android.gms.ads.internal.zzbv.zzec().isAttachedToWindow(view) : false, view != null ? view.getWindowVisibility() : 8, zza(rect5), zza(rect), zza(rect2), z3, zza(rect3), z4, zza(rect4), this.zzawv.density, z5);
            Iterator<zzgm> it = this.zzawu.iterator();
            while (it.hasNext()) {
                it.next().zza(zzglVar);
            }
            this.zzavq = z5;
        }
    }

    private final int zzl(int i) {
        return (int) (i / this.zzawv.density);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzk(3);
        zzgb();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzk(3);
        zzgb();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzk(3);
        zzgb();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzk(3);
        zzgb();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzk(3);
        zzgb();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzk(3);
        zzgb();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzk(3);
        zzgb();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzk(2);
        zzgb();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzk(1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzawt = -1;
        zzd(view);
        zzk(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzawt = -1;
        zzk(3);
        zzgb();
        zze(view);
    }

    public final void zza(zzgm zzgmVar) {
        this.zzawu.add(zzgmVar);
        zzk(3);
    }

    public final void zzb(zzgm zzgmVar) {
        this.zzawu.remove(zzgmVar);
    }

    public final void zzgc() {
        zzk(4);
    }
}
