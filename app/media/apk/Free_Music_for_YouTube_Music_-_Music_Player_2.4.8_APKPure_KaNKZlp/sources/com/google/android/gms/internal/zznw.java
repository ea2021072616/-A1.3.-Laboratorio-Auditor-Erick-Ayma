package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zznw extends zzpm implements zzoh {
    private Bundle mExtras;
    private Object mLock = new Object();
    private String zzbrq;
    private List<zznv> zzbrr;
    private String zzbrs;
    private zzpc zzbrt;
    private String zzbru;
    private double zzbrv;
    private String zzbrw;
    private String zzbrx;
    @Nullable
    private zznt zzbry;
    @Nullable
    private zzky zzbrz;
    @Nullable
    private View zzbsa;
    private zzoe zzbsb;

    public zznw(String str, List<zznv> list, String str2, zzpc zzpcVar, String str3, double d, String str4, String str5, @Nullable zznt zzntVar, Bundle bundle, zzky zzkyVar, View view) {
        this.zzbrq = str;
        this.zzbrr = list;
        this.zzbrs = str2;
        this.zzbrt = zzpcVar;
        this.zzbru = str3;
        this.zzbrv = d;
        this.zzbrw = str4;
        this.zzbrx = str5;
        this.zzbry = zzntVar;
        this.mExtras = bundle;
        this.zzbrz = zzkyVar;
        this.zzbsa = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzoe zza(zznw zznwVar, zzoe zzoeVar) {
        zznwVar.zzbsb = null;
        return null;
    }

    @Override // com.google.android.gms.internal.zzpl
    public final void destroy() {
        zzahf.zzdbo.post(new zznx(this));
        this.zzbrq = null;
        this.zzbrr = null;
        this.zzbrs = null;
        this.zzbrt = null;
        this.zzbru = null;
        this.zzbrv = 0.0d;
        this.zzbrw = null;
        this.zzbrx = null;
        this.zzbry = null;
        this.mExtras = null;
        this.mLock = null;
        this.zzbrz = null;
        this.zzbsa = null;
    }

    @Override // com.google.android.gms.internal.zzpl
    public final String getBody() {
        return this.zzbrs;
    }

    @Override // com.google.android.gms.internal.zzpl
    public final String getCallToAction() {
        return this.zzbru;
    }

    @Override // com.google.android.gms.internal.zzog
    public final String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.zzpl
    public final Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.internal.zzpl
    public final String getHeadline() {
        return this.zzbrq;
    }

    @Override // com.google.android.gms.internal.zzpl, com.google.android.gms.internal.zzoh
    public final List getImages() {
        return this.zzbrr;
    }

    @Override // com.google.android.gms.internal.zzpl
    public final String getPrice() {
        return this.zzbrx;
    }

    @Override // com.google.android.gms.internal.zzpl
    public final double getStarRating() {
        return this.zzbrv;
    }

    @Override // com.google.android.gms.internal.zzpl
    public final String getStore() {
        return this.zzbrw;
    }

    @Override // com.google.android.gms.internal.zzpl
    public final zzky getVideoController() {
        return this.zzbrz;
    }

    @Override // com.google.android.gms.internal.zzpl
    public final void performClick(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzbsb == null) {
                zzafx.e("Attempt to perform click before app install ad initialized.");
            } else {
                this.zzbsb.performClick(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzpl
    public final boolean recordImpression(Bundle bundle) {
        boolean recordImpression;
        synchronized (this.mLock) {
            if (this.zzbsb == null) {
                zzafx.e("Attempt to record impression before app install ad initialized.");
                recordImpression = false;
            } else {
                recordImpression = this.zzbsb.recordImpression(bundle);
            }
        }
        return recordImpression;
    }

    @Override // com.google.android.gms.internal.zzpl
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

    @Override // com.google.android.gms.internal.zzpl
    public final zzpc zzji() {
        return this.zzbrt;
    }

    @Override // com.google.android.gms.internal.zzpl
    public final IObjectWrapper zzjj() {
        return com.google.android.gms.dynamic.zzn.zzw(this.zzbsb);
    }

    @Override // com.google.android.gms.internal.zzog
    public final String zzjk() {
        return "2";
    }

    @Override // com.google.android.gms.internal.zzog
    public final zznt zzjl() {
        return this.zzbry;
    }

    @Override // com.google.android.gms.internal.zzog
    public final View zzjm() {
        return this.zzbsa;
    }

    @Override // com.google.android.gms.internal.zzpl
    public final zzoy zzjn() {
        return this.zzbry;
    }
}
