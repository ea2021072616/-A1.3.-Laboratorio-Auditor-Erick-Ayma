package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzaao extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzaao> CREATOR = new zzaap();
    public String body;
    public final int errorCode;
    public final int orientation;
    private int versionCode;
    public final boolean zzbct;
    public final boolean zzbcu;
    public final boolean zzbcv;
    public final List<String> zzcau;
    public final List<String> zzcav;
    public final List<String> zzcax;
    public final boolean zzcay;
    public final long zzcba;
    private zzaak zzccg;
    public final String zzchb;
    public final boolean zzcoe;
    public final boolean zzcos;
    @Nullable
    public String zzcot;
    public final boolean zzcpe;
    public final long zzcpn;
    public final boolean zzcpo;
    public final long zzcpp;
    public final List<String> zzcpq;
    public final String zzcpr;
    public final long zzcps;
    public final String zzcpt;
    public final boolean zzcpu;
    public final String zzcpv;
    public final String zzcpw;
    public final boolean zzcpx;
    public final boolean zzcpy;
    public final boolean zzcpz;
    private zzaba zzcqa;
    public String zzcqb;
    public final String zzcqc;
    @Nullable
    public final zzaek zzcqd;
    @Nullable
    public final List<String> zzcqe;
    @Nullable
    public final List<String> zzcqf;
    public final boolean zzcqg;
    @Nullable
    public final zzaaq zzcqh;
    @Nullable
    public final String zzcqi;
    @Nullable
    public final zzaes zzcqj;
    @Nullable
    public final String zzcqk;
    public final boolean zzcql;
    private Bundle zzcqm;

    public zzaao(int i) {
        this(19, null, null, null, i, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null);
    }

    public zzaao(int i, long j) {
        this(19, null, null, null, i, null, -1L, false, -1L, null, j, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaao(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, zzaba zzabaVar, String str7, String str8, boolean z8, boolean z9, zzaek zzaekVar, List<String> list4, List<String> list5, boolean z10, zzaaq zzaaqVar, boolean z11, String str9, List<String> list6, boolean z12, String str10, zzaes zzaesVar, String str11, boolean z13, boolean z14, Bundle bundle) {
        zzabo zzaboVar;
        this.versionCode = i;
        this.zzchb = str;
        this.body = str2;
        this.zzcau = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzcav = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzcpn = j;
        this.zzcpo = z;
        this.zzcpp = j2;
        this.zzcpq = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzcba = j3;
        this.orientation = i3;
        this.zzcpr = str3;
        this.zzcps = j4;
        this.zzcpt = str4;
        this.zzcpu = z2;
        this.zzcpv = str5;
        this.zzcpw = str6;
        this.zzcpx = z3;
        this.zzbct = z4;
        this.zzcoe = z5;
        this.zzcpy = z6;
        this.zzcql = z13;
        this.zzcpz = z7;
        this.zzcqa = zzabaVar;
        this.zzcqb = str7;
        this.zzcqc = str8;
        if (this.body == null && this.zzcqa != null && (zzaboVar = (zzabo) this.zzcqa.zza(zzabo.CREATOR)) != null && !TextUtils.isEmpty(zzaboVar.zzbqu)) {
            this.body = zzaboVar.zzbqu;
        }
        this.zzbcu = z8;
        this.zzbcv = z9;
        this.zzcqd = zzaekVar;
        this.zzcqe = list4;
        this.zzcqf = list5;
        this.zzcqg = z10;
        this.zzcqh = zzaaqVar;
        this.zzcos = z11;
        this.zzcot = str9;
        this.zzcax = list6;
        this.zzcay = z12;
        this.zzcqi = str10;
        this.zzcqj = zzaesVar;
        this.zzcqk = str11;
        this.zzcpe = z14;
        this.zzcqm = bundle;
    }

    public zzaao(zzaak zzaakVar, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, zzaek zzaekVar, List<String> list4, List<String> list5, boolean z9, zzaaq zzaaqVar, boolean z10, String str7, List<String> list6, boolean z11, String str8, zzaes zzaesVar, String str9, boolean z12, boolean z13) {
        this(19, str, str2, list, -2, list2, j, z, -1L, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, false, null, null, str6, z7, z8, zzaekVar, list4, list5, z9, zzaaqVar, z10, str7, list6, z11, str8, zzaesVar, str9, z12, z13, null);
        this.zzccg = zzaakVar;
    }

    public zzaao(zzaak zzaakVar, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, zzaek zzaekVar, List<String> list4, List<String> list5, boolean z10, zzaaq zzaaqVar, boolean z11, String str8, List<String> list6, boolean z12, String str9, zzaes zzaesVar, String str10, boolean z13, boolean z14) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, zzaekVar, list4, list5, z10, zzaaqVar, z11, str8, list6, z12, str9, zzaesVar, str10, z13, z14, null);
        this.zzccg = zzaakVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (this.zzccg != null && this.zzccg.versionCode >= 9 && !TextUtils.isEmpty(this.body)) {
            this.zzcqa = new zzaba(new zzabo(this.body));
            this.body = null;
        }
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzchb, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, this.body, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 4, this.zzcau, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 5, this.errorCode);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 6, this.zzcav, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 7, this.zzcpn);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzcpo);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 9, this.zzcpp);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 10, this.zzcpq, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 11, this.zzcba);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 12, this.orientation);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 13, this.zzcpr, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 14, this.zzcps);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 15, this.zzcpt, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 18, this.zzcpu);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 19, this.zzcpv, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 21, this.zzcpw, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 22, this.zzcpx);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 23, this.zzbct);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 24, this.zzcoe);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 25, this.zzcpy);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 26, this.zzcpz);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 28, (Parcelable) this.zzcqa, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 29, this.zzcqb, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 30, this.zzcqc, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 31, this.zzbcu);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 32, this.zzbcv);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 33, (Parcelable) this.zzcqd, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 34, this.zzcqe, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 35, this.zzcqf, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 36, this.zzcqg);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 37, (Parcelable) this.zzcqh, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 38, this.zzcos);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 39, this.zzcot, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 40, this.zzcax, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 42, this.zzcay);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 43, this.zzcqi, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 44, (Parcelable) this.zzcqj, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 45, this.zzcqk, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 46, this.zzcql);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 47, this.zzcpe);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 48, this.zzcqm, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}
