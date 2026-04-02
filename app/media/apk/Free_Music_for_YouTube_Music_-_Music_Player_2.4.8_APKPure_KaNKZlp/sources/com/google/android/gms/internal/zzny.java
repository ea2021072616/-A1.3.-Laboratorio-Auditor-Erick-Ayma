package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzny extends zzpq implements zzoh {
    private Bundle mExtras;
    private Object mLock = new Object();
    private String zzbrq;
    private List<zznv> zzbrr;
    private String zzbrs;
    private String zzbru;
    @Nullable
    private zznt zzbry;
    @Nullable
    private zzky zzbrz;
    @Nullable
    private View zzbsa;
    private zzoe zzbsb;
    private zzpc zzbsd;
    private String zzbse;

    public zzny(String str, List<zznv> list, String str2, zzpc zzpcVar, String str3, String str4, @Nullable zznt zzntVar, Bundle bundle, zzky zzkyVar, View view) {
        this.zzbrq = str;
        this.zzbrr = list;
        this.zzbrs = str2;
        this.zzbsd = zzpcVar;
        this.zzbru = str3;
        this.zzbse = str4;
        this.zzbry = zzntVar;
        this.mExtras = bundle;
        this.zzbrz = zzkyVar;
        this.zzbsa = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzoe zza(zzny zznyVar, zzoe zzoeVar) {
        zznyVar.zzbsb = null;
        return null;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final void destroy() {
        zzahf.zzdbo.post(new zznz(this));
        this.zzbrq = null;
        this.zzbrr = null;
        this.zzbrs = null;
        this.zzbsd = null;
        this.zzbru = null;
        this.zzbse = null;
        this.zzbry = null;
        this.mExtras = null;
        this.mLock = null;
        this.zzbrz = null;
        this.zzbsa = null;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final String getAdvertiser() {
        return this.zzbse;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final String getBody() {
        return this.zzbrs;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final String getCallToAction() {
        return this.zzbru;
    }

    @Override // com.google.android.gms.internal.zzog
    public final String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.zzpp
    public final Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final String getHeadline() {
        return this.zzbrq;
    }

    @Override // com.google.android.gms.internal.zzpp, com.google.android.gms.internal.zzoh
    public final List getImages() {
        return this.zzbrr;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final zzky getVideoController() {
        return this.zzbrz;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final void performClick(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzbsb == null) {
                zzafx.e("Attempt to perform click before content ad initialized.");
            } else {
                this.zzbsb.performClick(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzpp
    public final boolean recordImpression(Bundle bundle) {
        boolean recordImpression;
        synchronized (this.mLock) {
            if (this.zzbsb == null) {
                zzafx.e("Attempt to record impression before content ad initialized.");
                recordImpression = false;
            } else {
                recordImpression = this.zzbsb.recordImpression(bundle);
            }
        }
        return recordImpression;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final void reportTouchEvent(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzbsb == null) {
                zzafx.e("Attempt to perform click before app install ad initialized.");
            } else {
                this.zzbsb.reportTouchEvent(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzog
    public final void zzb(zzoe zzoeVar) {
        synchronized (this.mLock) {
            this.zzbsb = zzoeVar;
        }
    }

    @Override // com.google.android.gms.internal.zzpp
    public final IObjectWrapper zzjj() {
        return com.google.android.gms.dynamic.zzn.zzw(this.zzbsb);
    }

    @Override // com.google.android.gms.internal.zzog
    public final String zzjk() {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    @Override // com.google.android.gms.internal.zzog
    public final zznt zzjl() {
        return this.zzbry;
    }

    @Override // com.google.android.gms.internal.zzog
    public final View zzjm() {
        return this.zzbsa;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final zzoy zzjn() {
        return this.zzbry;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final zzpc zzjo() {
        return this.zzbsd;
    }
}
