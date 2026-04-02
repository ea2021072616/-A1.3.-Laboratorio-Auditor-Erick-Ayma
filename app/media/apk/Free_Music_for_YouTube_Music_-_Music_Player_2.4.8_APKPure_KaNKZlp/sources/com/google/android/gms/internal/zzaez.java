package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
@zzzt
/* loaded from: classes.dex */
public final class zzaez {
    private final AtomicReference<ThreadPoolExecutor> zzcxq = new AtomicReference<>(null);
    private final Object zzcxr = new Object();
    @Nullable
    private String zzcxs = null;
    private AtomicBoolean zzcxt = new AtomicBoolean(false);
    private final AtomicInteger zzcxu = new AtomicInteger(-1);
    private final AtomicReference<Object> zzcxv = new AtomicReference<>(null);
    private final AtomicReference<Object> zzcxw = new AtomicReference<>(null);
    private ConcurrentMap<String, Method> zzcxx = new ConcurrentHashMap(9);

    private final Object zza(String str, Context context) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzcxv, true)) {
            try {
                return zzl(context, str).invoke(this.zzcxv.get(), new Object[0]);
            } catch (Exception e) {
                zza(e, str, true);
                return null;
            }
        }
        return null;
    }

    private final void zza(Context context, String str, Bundle bundle) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzcxv, true)) {
            try {
                zzaa(context).invoke(this.zzcxv.get(), "am", str, bundle);
            } catch (Exception e) {
                zza(e, "logEventInternal", true);
            }
        }
    }

    private final void zza(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzcxv, true)) {
            try {
                zzk(context, str2).invoke(this.zzcxv.get(), str);
                zzafx.v(new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length()).append("Invoke Firebase method ").append(str2).append(", Ad Unit Id: ").append(str).toString());
            } catch (Exception e) {
                zza(e, str2, false);
            }
        }
    }

    private final void zza(Exception exc, String str, boolean z) {
        if (this.zzcxt.get()) {
            return;
        }
        zzafx.zzc(new StringBuilder(String.valueOf(str).length() + 30).append("Invoke Firebase method ").append(str).append(" error.").toString(), exc);
        if (z) {
            zzafx.zzcs("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firbase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            this.zzcxt.set(true);
        }
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception e) {
                zza(e, "getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final Method zzaa(Context context) {
        Method method = this.zzcxx.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
            this.zzcxx.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, "logEventInternal", true);
            return null;
        }
    }

    private static Bundle zzj(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("_aeid", Long.parseLong(str));
        return bundle;
    }

    private final Method zzk(Context context, String str) {
        Method method = this.zzcxx.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, String.class);
            this.zzcxx.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzl(Context context, String str) {
        Method method = this.zzcxx.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzcxx.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzm(Context context, String str) {
        Method method = this.zzcxx.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, Activity.class, String.class, String.class);
            this.zzcxx.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzab(Context context) throws Exception {
        return (String) zza("getAppInstanceId", context);
    }

    public final void zzc(Context context, String str) {
        if (zzr(context)) {
            zza(context, str, "beginAdUnitExposure");
        }
    }

    public final void zzd(Context context, String str) {
        if (zzr(context)) {
            zza(context, str, "endAdUnitExposure");
        }
    }

    public final void zze(Context context, String str) {
        if (zzr(context) && (context instanceof Activity) && zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzcxw, false)) {
            try {
                zzm(context, "setCurrentScreen").invoke(this.zzcxw.get(), (Activity) context, str, context.getPackageName());
            } catch (Exception e) {
                zza(e, "setCurrentScreen", false);
            }
        }
    }

    public final void zzf(Context context, String str) {
        if (zzr(context)) {
            Bundle zzj = zzj(context, str);
            zzj.putInt("_r", 1);
            zza(context, "_ac", zzj);
        }
    }

    public final void zzg(Context context, String str) {
        if (zzr(context)) {
            zza(context, "_ai", zzj(context, str));
        }
    }

    public final void zzh(Context context, String str) {
        if (zzr(context)) {
            zza(context, "_aq", zzj(context, str));
        }
    }

    public final void zzi(Context context, String str) {
        if (zzr(context)) {
            zza(context, "_aa", zzj(context, str));
        }
    }

    public final boolean zzr(Context context) {
        if (!((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbit)).booleanValue() || this.zzcxt.get()) {
            return false;
        }
        if (this.zzcxu.get() == -1) {
            zzjo.zzhu();
            if (!zzaje.zzba(context)) {
                zzjo.zzhu();
                if (zzaje.zzbb(context)) {
                    zzafx.zzcs("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                    this.zzcxu.set(0);
                }
            }
            this.zzcxu.set(1);
        }
        return this.zzcxu.get() == 1;
    }

    public final boolean zzs(Context context) {
        return ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbiu)).booleanValue() && zzr(context);
    }

    public final boolean zzt(Context context) {
        return ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbiv)).booleanValue() && zzr(context);
    }

    public final boolean zzu(Context context) {
        return ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbiw)).booleanValue() && zzr(context);
    }

    public final boolean zzv(Context context) {
        return ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbix)).booleanValue() && zzr(context);
    }

    public final String zzw(Context context) {
        if (zzr(context) && zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzcxv, true)) {
            try {
                String str = (String) zzl(context, "getCurrentScreenName").invoke(this.zzcxv.get(), new Object[0]);
                if (str == null) {
                    str = (String) zzl(context, "getCurrentScreenClass").invoke(this.zzcxv.get(), new Object[0]);
                }
                return str == null ? "" : str;
            } catch (Exception e) {
                zza(e, "getCurrentScreenName", false);
                return "";
            }
        }
        return "";
    }

    @Nullable
    public final String zzx(Context context) {
        String str;
        if (zzr(context)) {
            synchronized (this.zzcxr) {
                if (this.zzcxs != null) {
                    str = this.zzcxs;
                } else {
                    this.zzcxs = (String) zza("getGmpAppId", context);
                    str = this.zzcxs;
                }
            }
            return str;
        }
        return null;
    }

    @Nullable
    public final String zzy(final Context context) {
        if (zzr(context)) {
            long longValue = ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjd)).longValue();
            if (longValue < 0) {
                return (String) zza("getAppInstanceId", context);
            }
            if (this.zzcxq.get() == null) {
                this.zzcxq.compareAndSet(null, new ThreadPoolExecutor(((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbje)).intValue(), ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbje)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzafb(this)));
            }
            Future submit = this.zzcxq.get().submit(new Callable(this, context) { // from class: com.google.android.gms.internal.zzafa
                private final zzaez zzcxy;
                private final Context zzcxz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcxy = this;
                    this.zzcxz = context;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzcxy.zzab(this.zzcxz);
                }
            });
            try {
                return (String) submit.get(longValue, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                submit.cancel(true);
                if (e instanceof TimeoutException) {
                    return "TIME_OUT";
                }
                return null;
            }
        }
        return null;
    }

    @Nullable
    public final String zzz(Context context) {
        Object zza;
        if (zzr(context) && (zza = zza("generateEventId", context)) != null) {
            return zza.toString();
        }
        return null;
    }
}
