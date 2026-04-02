package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzqu;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class AdOverlayInfoParcel extends com.google.android.gms.common.internal.safeparcel.zza implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzv();
    public final int orientation;
    public final String url;
    public final zzajk zzatj;
    public final zzc zzcgw;
    public final zzis zzcgx;
    public final zzw zzcgy;
    public final zzakk zzcgz;
    public final zzqu zzcha;
    public final String zzchb;
    public final boolean zzchc;
    public final String zzchd;
    public final zzag zzche;
    public final int zzchf;
    public final String zzchg;
    public final com.google.android.gms.ads.internal.zzaq zzchh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdOverlayInfoParcel(zzc zzcVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, zzajk zzajkVar, String str4, com.google.android.gms.ads.internal.zzaq zzaqVar) {
        this.zzcgw = zzcVar;
        this.zzcgx = (zzis) com.google.android.gms.dynamic.zzn.zzab(IObjectWrapper.zza.zzao(iBinder));
        this.zzcgy = (zzw) com.google.android.gms.dynamic.zzn.zzab(IObjectWrapper.zza.zzao(iBinder2));
        this.zzcgz = (zzakk) com.google.android.gms.dynamic.zzn.zzab(IObjectWrapper.zza.zzao(iBinder3));
        this.zzcha = (zzqu) com.google.android.gms.dynamic.zzn.zzab(IObjectWrapper.zza.zzao(iBinder4));
        this.zzchb = str;
        this.zzchc = z;
        this.zzchd = str2;
        this.zzche = (zzag) com.google.android.gms.dynamic.zzn.zzab(IObjectWrapper.zza.zzao(iBinder5));
        this.orientation = i;
        this.zzchf = i2;
        this.url = str3;
        this.zzatj = zzajkVar;
        this.zzchg = str4;
        this.zzchh = zzaqVar;
    }

    public AdOverlayInfoParcel(zzc zzcVar, zzis zzisVar, zzw zzwVar, zzag zzagVar, zzajk zzajkVar) {
        this.zzcgw = zzcVar;
        this.zzcgx = zzisVar;
        this.zzcgy = zzwVar;
        this.zzcgz = null;
        this.zzcha = null;
        this.zzchb = null;
        this.zzchc = false;
        this.zzchd = null;
        this.zzche = zzagVar;
        this.orientation = -1;
        this.zzchf = 4;
        this.url = null;
        this.zzatj = zzajkVar;
        this.zzchg = null;
        this.zzchh = null;
    }

    public AdOverlayInfoParcel(zzis zzisVar, zzw zzwVar, zzag zzagVar, zzakk zzakkVar, int i, zzajk zzajkVar, String str, com.google.android.gms.ads.internal.zzaq zzaqVar) {
        this.zzcgw = null;
        this.zzcgx = zzisVar;
        this.zzcgy = zzwVar;
        this.zzcgz = zzakkVar;
        this.zzcha = null;
        this.zzchb = null;
        this.zzchc = false;
        this.zzchd = null;
        this.zzche = zzagVar;
        this.orientation = i;
        this.zzchf = 1;
        this.url = null;
        this.zzatj = zzajkVar;
        this.zzchg = str;
        this.zzchh = zzaqVar;
    }

    public AdOverlayInfoParcel(zzis zzisVar, zzw zzwVar, zzag zzagVar, zzakk zzakkVar, boolean z, int i, zzajk zzajkVar) {
        this.zzcgw = null;
        this.zzcgx = zzisVar;
        this.zzcgy = zzwVar;
        this.zzcgz = zzakkVar;
        this.zzcha = null;
        this.zzchb = null;
        this.zzchc = z;
        this.zzchd = null;
        this.zzche = zzagVar;
        this.orientation = i;
        this.zzchf = 2;
        this.url = null;
        this.zzatj = zzajkVar;
        this.zzchg = null;
        this.zzchh = null;
    }

    public AdOverlayInfoParcel(zzis zzisVar, zzw zzwVar, zzqu zzquVar, zzag zzagVar, zzakk zzakkVar, boolean z, int i, String str, zzajk zzajkVar) {
        this.zzcgw = null;
        this.zzcgx = zzisVar;
        this.zzcgy = zzwVar;
        this.zzcgz = zzakkVar;
        this.zzcha = zzquVar;
        this.zzchb = null;
        this.zzchc = z;
        this.zzchd = null;
        this.zzche = zzagVar;
        this.orientation = i;
        this.zzchf = 3;
        this.url = str;
        this.zzatj = zzajkVar;
        this.zzchg = null;
        this.zzchh = null;
    }

    public AdOverlayInfoParcel(zzis zzisVar, zzw zzwVar, zzqu zzquVar, zzag zzagVar, zzakk zzakkVar, boolean z, int i, String str, String str2, zzajk zzajkVar) {
        this.zzcgw = null;
        this.zzcgx = zzisVar;
        this.zzcgy = zzwVar;
        this.zzcgz = zzakkVar;
        this.zzcha = zzquVar;
        this.zzchb = str2;
        this.zzchc = z;
        this.zzchd = str;
        this.zzche = zzagVar;
        this.orientation = i;
        this.zzchf = 3;
        this.url = null;
        this.zzatj = zzajkVar;
        this.zzchg = null;
        this.zzchh = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzb(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, (Parcelable) this.zzcgw, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, com.google.android.gms.dynamic.zzn.zzw(this.zzcgx).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, com.google.android.gms.dynamic.zzn.zzw(this.zzcgy).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, com.google.android.gms.dynamic.zzn.zzw(this.zzcgz).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, com.google.android.gms.dynamic.zzn.zzw(this.zzcha).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 7, this.zzchb, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzchc);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 9, this.zzchd, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 10, com.google.android.gms.dynamic.zzn.zzw(this.zzche).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 11, this.orientation);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 12, this.zzchf);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 13, this.url, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 14, (Parcelable) this.zzatj, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 16, this.zzchg, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 17, (Parcelable) this.zzchh, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}
