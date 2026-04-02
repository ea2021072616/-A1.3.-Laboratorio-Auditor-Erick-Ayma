package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzod extends zzoi {
    private Object mLock;
    @Nullable
    private zzvm zzbsk;
    @Nullable
    private zzvp zzbsl;
    private final zzof zzbsm;
    @Nullable
    private zzoe zzbsn;
    private boolean zzbso;

    private zzod(Context context, zzof zzofVar, zzcv zzcvVar, zzog zzogVar) {
        super(context, zzofVar, null, zzcvVar, null, zzogVar, null, null);
        this.zzbso = false;
        this.mLock = new Object();
        this.zzbsm = zzofVar;
    }

    public zzod(Context context, zzof zzofVar, zzcv zzcvVar, zzvm zzvmVar, zzog zzogVar) {
        this(context, zzofVar, zzcvVar, zzogVar);
        this.zzbsk = zzvmVar;
    }

    public zzod(Context context, zzof zzofVar, zzcv zzcvVar, zzvp zzvpVar, zzog zzogVar) {
        this(context, zzofVar, zzcvVar, zzogVar);
        this.zzbsl = zzvpVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0038 -> B:12:0x001a). Please submit an issue!!! */
    @Override // com.google.android.gms.internal.zzoi, com.google.android.gms.internal.zzoe
    @Nullable
    public final View zza(View.OnClickListener onClickListener, boolean z) {
        IObjectWrapper iObjectWrapper;
        synchronized (this.mLock) {
            if (this.zzbsn != null) {
                return this.zzbsn.zza(onClickListener, z);
            }
            try {
            } catch (RemoteException e) {
                zzafx.zzc("Failed to call getAdChoicesContent", e);
            }
            if (this.zzbsk != null) {
                iObjectWrapper = this.zzbsk.zzly();
            } else {
                if (this.zzbsl != null) {
                    iObjectWrapper = this.zzbsl.zzly();
                }
                iObjectWrapper = null;
            }
            if (iObjectWrapper != null) {
                return (View) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
            }
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzoi, com.google.android.gms.internal.zzoe
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        zzbp.zzfx("recordImpression must be called on the main UI thread.");
        synchronized (this.mLock) {
            this.zzbss = true;
            if (this.zzbsn != null) {
                this.zzbsn.zza(view, map);
                this.zzbsm.recordImpression();
            } else {
                try {
                    if (this.zzbsk != null && !this.zzbsk.getOverrideImpressionRecording()) {
                        this.zzbsk.recordImpression();
                        this.zzbsm.recordImpression();
                    } else if (this.zzbsl != null && !this.zzbsl.getOverrideImpressionRecording()) {
                        this.zzbsl.recordImpression();
                        this.zzbsm.recordImpression();
                    }
                } catch (RemoteException e) {
                    zzafx.zzc("Failed to call recordImpression", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzoi, com.google.android.gms.internal.zzoe
    public final void zza(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        zzbp.zzfx("performClick must be called on the main UI thread.");
        synchronized (this.mLock) {
            if (this.zzbsn != null) {
                this.zzbsn.zza(view, map, bundle, view2);
                this.zzbsm.onAdClicked();
            } else {
                try {
                    if (this.zzbsk != null && !this.zzbsk.getOverrideClickHandling()) {
                        this.zzbsk.zzl(com.google.android.gms.dynamic.zzn.zzw(view));
                        this.zzbsm.onAdClicked();
                    }
                    if (this.zzbsl != null && !this.zzbsl.getOverrideClickHandling()) {
                        this.zzbsl.zzl(com.google.android.gms.dynamic.zzn.zzw(view));
                        this.zzbsm.onAdClicked();
                    }
                } catch (RemoteException e) {
                    zzafx.zzc("Failed to call performClick", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzoi
    public final void zza(View view, Map<String, WeakReference<View>> map, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        synchronized (this.mLock) {
            this.zzbso = true;
            try {
                if (this.zzbsk != null) {
                    this.zzbsk.zzm(com.google.android.gms.dynamic.zzn.zzw(view));
                } else if (this.zzbsl != null) {
                    this.zzbsl.zzm(com.google.android.gms.dynamic.zzn.zzw(view));
                }
            } catch (RemoteException e) {
                zzafx.zzc("Failed to call prepareAd", e);
            }
            this.zzbso = false;
        }
    }

    @Override // com.google.android.gms.internal.zzoi, com.google.android.gms.internal.zzoe
    public final void zzb(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.mLock) {
            try {
                if (this.zzbsk != null) {
                    this.zzbsk.zzn(com.google.android.gms.dynamic.zzn.zzw(view));
                } else if (this.zzbsl != null) {
                    this.zzbsl.zzn(com.google.android.gms.dynamic.zzn.zzw(view));
                }
            } catch (RemoteException e) {
                zzafx.zzc("Failed to call untrackView", e);
            }
        }
    }

    public final void zzc(@Nullable zzoe zzoeVar) {
        synchronized (this.mLock) {
            this.zzbsn = zzoeVar;
        }
    }

    @Override // com.google.android.gms.internal.zzoi, com.google.android.gms.internal.zzoe
    public final boolean zzjr() {
        boolean zzjr;
        synchronized (this.mLock) {
            zzjr = this.zzbsn != null ? this.zzbsn.zzjr() : this.zzbsm.zzco();
        }
        return zzjr;
    }

    public final boolean zzjs() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzbso;
        }
        return z;
    }

    public final zzoe zzjt() {
        zzoe zzoeVar;
        synchronized (this.mLock) {
            zzoeVar = this.zzbsn;
        }
        return zzoeVar;
    }

    @Override // com.google.android.gms.internal.zzoi
    @Nullable
    public final zzakk zzju() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzoi, com.google.android.gms.internal.zzoe
    public final void zzjv() {
    }
}
