package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class zzch extends Fragment implements zzcg {
    private static WeakHashMap<Activity, WeakReference<zzch>> zzfoj = new WeakHashMap<>();
    private Bundle zzfol;
    private Map<String, LifecycleCallback> zzfok = new ArrayMap();
    private int zzbyx = 0;

    public static zzch zzo(Activity activity) {
        zzch zzchVar;
        WeakReference<zzch> weakReference = zzfoj.get(activity);
        if (weakReference == null || (zzchVar = weakReference.get()) == null) {
            try {
                zzchVar = (zzch) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (zzchVar == null || zzchVar.isRemoving()) {
                    zzchVar = new zzch();
                    activity.getFragmentManager().beginTransaction().add(zzchVar, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                zzfoj.put(activity, new WeakReference<>(zzchVar));
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
            }
        }
        return zzchVar;
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.zzfok.values()) {
            lifecycleCallback.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback lifecycleCallback : this.zzfok.values()) {
            lifecycleCallback.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzbyx = 1;
        this.zzfol = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.zzfok.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.zzbyx = 5;
        for (LifecycleCallback lifecycleCallback : this.zzfok.values()) {
            lifecycleCallback.onDestroy();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.zzbyx = 3;
        for (LifecycleCallback lifecycleCallback : this.zzfok.values()) {
            lifecycleCallback.onResume();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.zzfok.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.zzbyx = 2;
        for (LifecycleCallback lifecycleCallback : this.zzfok.values()) {
            lifecycleCallback.onStart();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.zzbyx = 4;
        for (LifecycleCallback lifecycleCallback : this.zzfok.values()) {
            lifecycleCallback.onStop();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcg
    public final <T extends LifecycleCallback> T zza(String str, Class<T> cls) {
        return cls.cast(this.zzfok.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.zzcg
    public final void zza(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (this.zzfok.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.zzfok.put(str, lifecycleCallback);
        if (this.zzbyx > 0) {
            new Handler(Looper.getMainLooper()).post(new zzci(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcg
    public final Activity zzaij() {
        return getActivity();
    }
}
