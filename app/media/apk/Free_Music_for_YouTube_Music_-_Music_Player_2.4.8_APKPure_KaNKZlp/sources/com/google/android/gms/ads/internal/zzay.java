package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahw;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zzay extends zzku {
    private static final Object zzaqm = new Object();
    @Nullable
    private static zzay zzaqn;
    private final Context mContext;
    private boolean zzaqp;
    private zzajk zzaqr;
    private final Object mLock = new Object();
    private float zzaqq = -1.0f;
    private boolean zzaqo = false;

    private zzay(Context context, zzajk zzajkVar) {
        this.mContext = context;
        this.zzaqr = zzajkVar;
    }

    public static zzay zza(Context context, zzajk zzajkVar) {
        zzay zzayVar;
        synchronized (zzaqm) {
            if (zzaqn == null) {
                zzaqn = new zzay(context.getApplicationContext(), zzajkVar);
            }
            zzayVar = zzaqn;
        }
        return zzayVar;
    }

    @Nullable
    public static zzay zzdd() {
        zzay zzayVar;
        synchronized (zzaqm) {
            zzayVar = zzaqn;
        }
        return zzayVar;
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void initialize() {
        synchronized (zzaqm) {
            if (this.zzaqo) {
                zzafx.zzcs("Mobile ads is initialized already.");
                return;
            }
            this.zzaqo = true;
            zzmu.initialize(this.mContext);
            zzbv.zzee().zzd(this.mContext, this.zzaqr);
            zzbv.zzef().initialize(this.mContext);
        }
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void setAppMuted(boolean z) {
        synchronized (this.mLock) {
            this.zzaqp = z;
        }
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void setAppVolume(float f) {
        synchronized (this.mLock) {
            this.zzaqq = f;
        }
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void zzc(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzafx.e("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
        if (context == null) {
            zzafx.e("Context is null. Failed to open debug menu.");
            return;
        }
        zzahw zzahwVar = new zzahw(context);
        zzahwVar.setAdUnitId(str);
        zzahwVar.zzcn(this.zzaqr.zzcp);
        zzahwVar.showDialog();
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void zzc(String str, IObjectWrapper iObjectWrapper) {
        zzaz zzazVar;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzmu.initialize(this.mContext);
        boolean booleanValue = ((Boolean) zzbv.zzen().zzd(zzmu.zzbnq)).booleanValue() | ((Boolean) zzbv.zzen().zzd(zzmu.zzbjj)).booleanValue();
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbjj)).booleanValue()) {
            zzazVar = new zzaz(this, (Runnable) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
            z = true;
        } else {
            zzazVar = null;
            z = booleanValue;
        }
        if (z) {
            zzbv.zzeh().zza(this.mContext, this.zzaqr, str, zzazVar);
        }
    }

    public final float zzde() {
        float f;
        synchronized (this.mLock) {
            f = this.zzaqq;
        }
        return f;
    }

    public final boolean zzdf() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzaqq >= 0.0f;
        }
        return z;
    }

    public final boolean zzdg() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzaqp;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void zzt(String str) {
        zzmu.initialize(this.mContext);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbnq)).booleanValue()) {
            zzbv.zzeh().zza(this.mContext, this.zzaqr, str, null);
        }
    }
}
