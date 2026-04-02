package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
@zzzt
/* loaded from: classes.dex */
public final class zzaak extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzaak> CREATOR = new zzaam();
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final String zzatg;
    public final String zzath;
    public final zzajk zzatj;
    public final zzjb zzatn;
    public final zzot zzatz;
    @Nullable
    public final zzle zzaub;
    public final List<Integer> zzaud;
    public final List<String> zzaug;
    public final float zzaxh;
    public final boolean zzcay;
    @Nullable
    public final Bundle zzcnv;
    public final zzix zzcnw;
    @Nullable
    public final PackageInfo zzcnx;
    public final String zzcny;
    public final String zzcnz;
    public final String zzcoa;
    public final Bundle zzcob;
    public final int zzcoc;
    public final Bundle zzcod;
    public final boolean zzcoe;
    public final int zzcof;
    public final int zzcog;
    public final String zzcoh;
    public final long zzcoi;
    public final String zzcoj;
    @Nullable
    public final List<String> zzcok;
    public final List<String> zzcol;
    public final long zzcom;
    public final String zzcon;
    public final float zzcoo;
    public final int zzcop;
    public final int zzcoq;
    public final boolean zzcor;
    public final boolean zzcos;
    public final String zzcot;
    public final boolean zzcou;
    public final String zzcov;
    public final int zzcow;
    public final Bundle zzcox;
    public final String zzcoy;
    public final boolean zzcoz;
    public final Bundle zzcpa;
    @Nullable
    public final String zzcpb;
    @Nullable
    public final String zzcpc;
    @Nullable
    public final String zzcpd;
    public final boolean zzcpe;
    public final String zzcpf;
    public final List<String> zzcpg;
    public final int zzcph;
    public final boolean zzcpi;
    public final boolean zzcpj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaak(int i, Bundle bundle, zzix zzixVar, zzjb zzjbVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzajk zzajkVar, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, zzot zzotVar, List<String> list3, long j2, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4, String str11, zzle zzleVar, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i8, boolean z8, boolean z9) {
        this.versionCode = i;
        this.zzcnv = bundle;
        this.zzcnw = zzixVar;
        this.zzatn = zzjbVar;
        this.zzath = str;
        this.applicationInfo = applicationInfo;
        this.zzcnx = packageInfo;
        this.zzcny = str2;
        this.zzcnz = str3;
        this.zzcoa = str4;
        this.zzatj = zzajkVar;
        this.zzcob = bundle2;
        this.zzcoc = i2;
        this.zzaug = list;
        this.zzcol = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzcod = bundle3;
        this.zzcoe = z;
        this.zzcof = i3;
        this.zzcog = i4;
        this.zzaxh = f;
        this.zzcoh = str5;
        this.zzcoi = j;
        this.zzcoj = str6;
        this.zzcok = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzatg = str7;
        this.zzatz = zzotVar;
        this.zzcom = j2;
        this.zzcon = str8;
        this.zzcoo = f2;
        this.zzcou = z2;
        this.zzcop = i5;
        this.zzcoq = i6;
        this.zzcor = z3;
        this.zzcos = z4;
        this.zzcot = str9;
        this.zzcov = str10;
        this.zzcay = z5;
        this.zzcow = i7;
        this.zzcox = bundle4;
        this.zzcoy = str11;
        this.zzaub = zzleVar;
        this.zzcoz = z6;
        this.zzcpa = bundle5;
        this.zzcpb = str12;
        this.zzcpc = str13;
        this.zzcpd = str14;
        this.zzcpe = z7;
        this.zzaud = list4;
        this.zzcpf = str15;
        this.zzcpg = list5;
        this.zzcph = i8;
        this.zzcpi = z8;
        this.zzcpj = z9;
    }

    private zzaak(@Nullable Bundle bundle, zzix zzixVar, zzjb zzjbVar, String str, ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo, String str2, String str3, String str4, zzajk zzajkVar, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i2, int i3, float f, String str5, long j, String str6, @Nullable List<String> list3, String str7, zzot zzotVar, long j2, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11, @Nullable zzle zzleVar, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i7, boolean z8, boolean z9) {
        this(24, bundle, zzixVar, zzjbVar, str, applicationInfo, packageInfo, str2, str3, str4, zzajkVar, bundle2, i, list, bundle3, z, i2, i3, f, str5, j, str6, list3, str7, zzotVar, list2, j2, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11, zzleVar, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i7, z8, z9);
    }

    public zzaak(zzaal zzaalVar, long j, String str, String str2, String str3) {
        this(zzaalVar.zzcnv, zzaalVar.zzcnw, zzaalVar.zzatn, zzaalVar.zzath, zzaalVar.applicationInfo, zzaalVar.zzcnx, (String) zzajn.zza(zzaalVar.zzcpl, ""), zzaalVar.zzcnz, zzaalVar.zzcoa, zzaalVar.zzatj, zzaalVar.zzcob, zzaalVar.zzcoc, zzaalVar.zzaug, zzaalVar.zzcol, zzaalVar.zzcod, zzaalVar.zzcoe, zzaalVar.zzcof, zzaalVar.zzcog, zzaalVar.zzaxh, zzaalVar.zzcoh, zzaalVar.zzcoi, zzaalVar.zzcoj, zzaalVar.zzcok, zzaalVar.zzatg, zzaalVar.zzatz, j, zzaalVar.zzcon, zzaalVar.zzcoo, zzaalVar.zzcou, zzaalVar.zzcop, zzaalVar.zzcoq, zzaalVar.zzcor, zzaalVar.zzcos, (String) zzajn.zza(zzaalVar.zzcpk, "", 1L, TimeUnit.SECONDS), zzaalVar.zzcov, zzaalVar.zzcay, zzaalVar.zzcow, zzaalVar.zzcox, zzaalVar.zzcoy, zzaalVar.zzaub, zzaalVar.zzcoz, zzaalVar.zzcpa, str, str2, str3, zzaalVar.zzcpe, zzaalVar.zzaud, zzaalVar.zzcpf, zzaalVar.zzcpg, zzaalVar.zzcph, zzaalVar.zzcpi, zzaalVar.zzcpj);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzcnv, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, (Parcelable) this.zzcnw, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, (Parcelable) this.zzatn, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, this.zzath, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, (Parcelable) this.applicationInfo, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 7, (Parcelable) this.zzcnx, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzcny, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 9, this.zzcnz, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 10, this.zzcoa, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 11, (Parcelable) this.zzatj, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 12, this.zzcob, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 13, this.zzcoc);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 14, this.zzaug, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 15, this.zzcod, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 16, this.zzcoe);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 18, this.zzcof);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 19, this.zzcog);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 20, this.zzaxh);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 21, this.zzcoh, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 25, this.zzcoi);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 26, this.zzcoj, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 27, this.zzcok, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 28, this.zzatg, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 29, (Parcelable) this.zzatz, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 30, this.zzcol, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 31, this.zzcom);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 33, this.zzcon, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 34, this.zzcoo);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 35, this.zzcop);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 36, this.zzcoq);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 37, this.zzcor);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 38, this.zzcos);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 39, this.zzcot, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 40, this.zzcou);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 41, this.zzcov, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 42, this.zzcay);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 43, this.zzcow);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 44, this.zzcox, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 45, this.zzcoy, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 46, (Parcelable) this.zzaub, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 47, this.zzcoz);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 48, this.zzcpa, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 49, this.zzcpb, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 50, this.zzcpc, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 51, this.zzcpd, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 52, this.zzcpe);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 53, this.zzaud, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 54, this.zzcpf, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 55, this.zzcpg, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 56, this.zzcph);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 57, this.zzcpi);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 58, this.zzcpj);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}
