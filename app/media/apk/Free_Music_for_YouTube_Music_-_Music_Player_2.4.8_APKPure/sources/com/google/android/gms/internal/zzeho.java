package com.google.android.gms.internal;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public final class zzeho extends CustomTabsServiceConnection {
    private WeakReference<zzehp> zznhi;

    public zzeho(zzehp zzehpVar) {
        this.zznhi = new WeakReference<>(zzehpVar);
    }

    @Override // android.support.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzehp zzehpVar = this.zznhi.get();
        if (zzehpVar != null) {
            zzehpVar.zza(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzehp zzehpVar = this.zznhi.get();
        if (zzehpVar != null) {
            zzehpVar.zzja();
        }
    }
}
