package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzoa extends zzpu implements zzog {
    private final Object mLock = new Object();
    private final zznt zzbry;
    @Nullable
    private zzky zzbrz;
    @Nullable
    private View zzbsa;
    private zzoe zzbsb;
    private final String zzbsg;
    private final SimpleArrayMap<String, zznv> zzbsh;
    private final SimpleArrayMap<String, String> zzbsi;

    public zzoa(String str, SimpleArrayMap<String, zznv> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, zznt zzntVar, zzky zzkyVar, View view) {
        this.zzbsg = str;
        this.zzbsh = simpleArrayMap;
        this.zzbsi = simpleArrayMap2;
        this.zzbry = zzntVar;
        this.zzbrz = zzkyVar;
        this.zzbsa = view;
    }

    @Override // com.google.android.gms.internal.zzpt
    public final void destroy() {
        this.zzbsb = null;
        this.zzbrz = null;
        this.zzbsa = null;
    }

    @Override // com.google.android.gms.internal.zzpt
    public final List<String> getAvailableAssetNames() {
        int i = 0;
        String[] strArr = new String[this.zzbsh.size() + this.zzbsi.size()];
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzbsh.size(); i3++) {
            strArr[i2] = this.zzbsh.keyAt(i3);
            i2++;
        }
        while (i < this.zzbsi.size()) {
            strArr[i2] = this.zzbsi.keyAt(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.zzpt, com.google.android.gms.internal.zzog
    public final String getCustomTemplateId() {
        return this.zzbsg;
    }

    @Override // com.google.android.gms.internal.zzpt
    public final zzky getVideoController() {
        return this.zzbrz;
    }

    @Override // com.google.android.gms.internal.zzpt
    public final void performClick(String str) {
        synchronized (this.mLock) {
            if (this.zzbsb == null) {
                zzaji.e("Attempt to call performClick before ad initialized.");
            } else {
                this.zzbsb.zza(null, str, null, null, null);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzpt
    public final void recordImpression() {
        synchronized (this.mLock) {
            if (this.zzbsb == null) {
                zzaji.e("Attempt to perform recordImpression before ad initialized.");
            } else {
                this.zzbsb.zza((View) null, (Map<String, WeakReference<View>>) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzpt
    public final String zzao(String str) {
        return this.zzbsi.get(str);
    }

    @Override // com.google.android.gms.internal.zzpt
    public final zzpc zzap(String str) {
        return this.zzbsh.get(str);
    }

    @Override // com.google.android.gms.internal.zzog
    public final void zzb(zzoe zzoeVar) {
        synchronized (this.mLock) {
            this.zzbsb = zzoeVar;
        }
    }

    @Override // com.google.android.gms.internal.zzpt
    public final boolean zzj(IObjectWrapper iObjectWrapper) {
        if (this.zzbsb == null) {
            zzaji.e("Attempt to call renderVideoInMediaView before ad initialized.");
            return false;
        } else if (this.zzbsa != null) {
            zzob zzobVar = new zzob(this);
            this.zzbsb.zza((FrameLayout) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper), zzobVar);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzpt
    public final IObjectWrapper zzjj() {
        return com.google.android.gms.dynamic.zzn.zzw(this.zzbsb);
    }

    @Override // com.google.android.gms.internal.zzog
    public final String zzjk() {
        return "3";
    }

    @Override // com.google.android.gms.internal.zzog
    public final zznt zzjl() {
        return this.zzbry;
    }

    @Override // com.google.android.gms.internal.zzog
    public final View zzjm() {
        return this.zzbsa;
    }

    @Override // com.google.android.gms.internal.zzpt
    public final IObjectWrapper zzjp() {
        return com.google.android.gms.dynamic.zzn.zzw(this.zzbsb.getContext().getApplicationContext());
    }
}
