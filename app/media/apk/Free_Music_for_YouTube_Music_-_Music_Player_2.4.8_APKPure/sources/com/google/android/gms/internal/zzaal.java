package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Future;
@zzzt
/* loaded from: classes.dex */
public final class zzaal {
    public final ApplicationInfo applicationInfo;
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
    public final String zzcon;
    public final float zzcoo;
    public final int zzcop;
    public final int zzcoq;
    public final boolean zzcor;
    public final boolean zzcos;
    public final boolean zzcou;
    public final String zzcov;
    public final int zzcow;
    public final Bundle zzcox;
    public final String zzcoy;
    public final boolean zzcoz;
    @Nullable
    public final Bundle zzcpa;
    public final boolean zzcpe;
    public final String zzcpf;
    public final List<String> zzcpg;
    public final int zzcph;
    public final boolean zzcpi;
    public final boolean zzcpj;
    public final Future<String> zzcpk;
    public final Future<String> zzcpl;

    public zzaal(@Nullable Bundle bundle, zzix zzixVar, zzjb zzjbVar, String str, ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo, String str2, String str3, zzajk zzajkVar, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i, int i2, float f, String str4, long j, String str5, @Nullable List<String> list3, String str6, zzot zzotVar, String str7, float f2, boolean z2, int i3, int i4, boolean z3, boolean z4, Future<String> future, String str8, boolean z5, int i5, Bundle bundle4, String str9, @Nullable zzle zzleVar, boolean z6, Bundle bundle5, boolean z7, Future<String> future2, List<Integer> list4, String str10, List<String> list5, int i6, boolean z8, boolean z9) {
        this.zzcnv = bundle;
        this.zzcnw = zzixVar;
        this.zzatn = zzjbVar;
        this.zzath = str;
        this.applicationInfo = applicationInfo;
        this.zzcnx = packageInfo;
        this.zzcnz = str2;
        this.zzcoa = str3;
        this.zzatj = zzajkVar;
        this.zzcob = bundle2;
        this.zzcoe = z;
        this.zzcof = i;
        this.zzcog = i2;
        this.zzaxh = f;
        if (list == null || list.size() <= 0) {
            this.zzcoc = 0;
            this.zzaug = null;
            this.zzcol = null;
        } else {
            this.zzcoc = 3;
            this.zzaug = list;
            this.zzcol = list2;
        }
        this.zzcod = bundle3;
        this.zzcoh = str4;
        this.zzcoi = j;
        this.zzcoj = str5;
        this.zzcok = list3;
        this.zzatg = str6;
        this.zzatz = zzotVar;
        this.zzcon = str7;
        this.zzcoo = f2;
        this.zzcou = z2;
        this.zzcop = i3;
        this.zzcoq = i4;
        this.zzcor = z3;
        this.zzcos = z4;
        this.zzcpk = future;
        this.zzcov = str8;
        this.zzcay = z5;
        this.zzcow = i5;
        this.zzcox = bundle4;
        this.zzcoy = str9;
        this.zzaub = zzleVar;
        this.zzcoz = z6;
        this.zzcpa = bundle5;
        this.zzcpe = z7;
        this.zzcpl = future2;
        this.zzaud = list4;
        this.zzcpf = str10;
        this.zzcpg = list5;
        this.zzcph = i6;
        this.zzcpi = z8;
        this.zzcpj = z9;
    }
}
