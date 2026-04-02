package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzalc extends zzkz {
    private boolean zzalf;
    private final zzakk zzbvz;
    private final boolean zzdht;
    private final float zzdhu;
    private int zzdhv;
    private zzlb zzdhw;
    private boolean zzdhx;
    private float zzdhz;
    private float zzdia;
    private final Object mLock = new Object();
    private boolean zzdhy = true;
    private boolean zzale = true;

    public zzalc(zzakk zzakkVar, float f, boolean z) {
        this.zzbvz = zzakkVar;
        this.zzdhu = f;
        this.zzdht = z;
    }

    private final void zzc(String str, @Nullable Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        com.google.android.gms.ads.internal.zzbv.zzea();
        zzahf.runOnUiThread(new zzald(this, hashMap));
    }

    @Override // com.google.android.gms.internal.zzky
    public final float getAspectRatio() {
        float f;
        synchronized (this.mLock) {
            f = this.zzdia;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.zzky
    public final int getPlaybackState() {
        int i;
        synchronized (this.mLock) {
            i = this.zzdhv;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.zzky
    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdht && this.zzalf;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzky
    public final boolean isMuted() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdhy;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzky
    public final void mute(boolean z) {
        zzc(z ? "mute" : "unmute", null);
    }

    @Override // com.google.android.gms.internal.zzky
    public final void pause() {
        zzc("pause", null);
    }

    @Override // com.google.android.gms.internal.zzky
    public final void play() {
        zzc("play", null);
    }

    public final void zza(float f, int i, boolean z, float f2) {
        boolean z2;
        int i2;
        synchronized (this.mLock) {
            this.zzdhz = f;
            z2 = this.zzdhy;
            this.zzdhy = z;
            i2 = this.zzdhv;
            this.zzdhv = i;
            this.zzdia = f2;
        }
        com.google.android.gms.ads.internal.zzbv.zzea();
        zzahf.runOnUiThread(new zzale(this, i2, i, z2, z));
    }

    @Override // com.google.android.gms.internal.zzky
    public final void zza(zzlb zzlbVar) {
        synchronized (this.mLock) {
            this.zzdhw = zzlbVar;
        }
    }

    public final void zzb(zzmd zzmdVar) {
        synchronized (this.mLock) {
            this.zzale = zzmdVar.zzbfh;
            this.zzalf = zzmdVar.zzbfi;
        }
        zzc("initialState", com.google.android.gms.common.util.zze.zza("muteStart", zzmdVar.zzbfh ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO, "customControlsRequested", zzmdVar.zzbfi ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    @Override // com.google.android.gms.internal.zzky
    public final float zzhx() {
        return this.zzdhu;
    }

    @Override // com.google.android.gms.internal.zzky
    public final float zzhy() {
        float f;
        synchronized (this.mLock) {
            f = this.zzdhz;
        }
        return f;
    }
}
