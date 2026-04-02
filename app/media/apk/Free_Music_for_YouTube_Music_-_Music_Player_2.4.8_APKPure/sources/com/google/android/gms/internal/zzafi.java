package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzafi {
    public final int errorCode;
    public final int orientation;
    public final List<String> zzcau;
    public final List<String> zzcav;
    @Nullable
    public final List<String> zzcax;
    public final long zzcba;
    @Nullable
    public final zzuk zzcca;
    @Nullable
    public final zzvd zzccb;
    @Nullable
    public final String zzccc;
    @Nullable
    public final zzun zzccd;
    @Nullable
    public final zzakk zzcgz;
    public final zzix zzcnw;
    public final String zzcnz;
    private long zzcpn;
    public final boolean zzcpo;
    private long zzcpp;
    public final List<String> zzcpq;
    public final String zzcpt;
    @Nullable
    public final zzaek zzcqd;
    @Nullable
    public final List<String> zzcqf;
    public final boolean zzcqg;
    private zzaaq zzcqh;
    public final String zzcqk;
    public final JSONObject zzcyc;
    public boolean zzcyd;
    public final zzul zzcye;
    @Nullable
    public final String zzcyf;
    public final zzjb zzcyg;
    @Nullable
    public final List<String> zzcyh;
    public final long zzcyi;
    public final long zzcyj;
    @Nullable
    public final zzog zzcyk;
    public boolean zzcyl;
    public boolean zzcym;
    public boolean zzcyn;
    private zzil zzcyo;

    public zzafi(zzafj zzafjVar, @Nullable zzakk zzakkVar, @Nullable zzuk zzukVar, @Nullable zzvd zzvdVar, @Nullable String str, @Nullable zzun zzunVar, @Nullable zzog zzogVar, @Nullable String str2) {
        this(zzafjVar.zzcrj.zzcnw, null, zzafjVar.zzcyp.zzcau, zzafjVar.errorCode, zzafjVar.zzcyp.zzcav, zzafjVar.zzcyp.zzcpq, zzafjVar.zzcyp.orientation, zzafjVar.zzcyp.zzcba, zzafjVar.zzcrj.zzcnz, zzafjVar.zzcyp.zzcpo, null, null, null, zzafjVar.zzcye, null, zzafjVar.zzcyp.zzcpp, zzafjVar.zzatn, zzafjVar.zzcyp.zzcpn, zzafjVar.zzcyi, zzafjVar.zzcyj, zzafjVar.zzcyp.zzcpt, zzafjVar.zzcyc, null, zzafjVar.zzcyp.zzcqd, zzafjVar.zzcyp.zzcqe, zzafjVar.zzcyp.zzcqe, zzafjVar.zzcyp.zzcqg, zzafjVar.zzcyp.zzcqh, null, zzafjVar.zzcyp.zzcax, zzafjVar.zzcyp.zzcqk, zzafjVar.zzcyo);
    }

    public zzafi(zzix zzixVar, @Nullable zzakk zzakkVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, @Nullable zzuk zzukVar, @Nullable zzvd zzvdVar, @Nullable String str2, zzul zzulVar, @Nullable zzun zzunVar, long j2, zzjb zzjbVar, long j3, long j4, long j5, String str3, JSONObject jSONObject, @Nullable zzog zzogVar, zzaek zzaekVar, List<String> list4, List<String> list5, boolean z2, zzaaq zzaaqVar, @Nullable String str4, List<String> list6, String str5, zzil zzilVar) {
        this.zzcyl = false;
        this.zzcym = false;
        this.zzcyn = false;
        this.zzcnw = zzixVar;
        this.zzcgz = zzakkVar;
        this.zzcau = zzo(list);
        this.errorCode = i;
        this.zzcav = zzo(list2);
        this.zzcpq = zzo(list3);
        this.orientation = i2;
        this.zzcba = j;
        this.zzcnz = str;
        this.zzcpo = z;
        this.zzcca = zzukVar;
        this.zzccb = zzvdVar;
        this.zzccc = str2;
        this.zzcye = zzulVar;
        this.zzccd = zzunVar;
        this.zzcpp = j2;
        this.zzcyg = zzjbVar;
        this.zzcpn = j3;
        this.zzcyi = j4;
        this.zzcyj = j5;
        this.zzcpt = str3;
        this.zzcyc = jSONObject;
        this.zzcyk = zzogVar;
        this.zzcqd = zzaekVar;
        this.zzcyh = zzo(list4);
        this.zzcqf = zzo(list5);
        this.zzcqg = z2;
        this.zzcqh = zzaaqVar;
        this.zzcyf = str4;
        this.zzcax = zzo(list6);
        this.zzcqk = str5;
        this.zzcyo = zzilVar;
    }

    @Nullable
    private static <T> List<T> zzo(@Nullable List<T> list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public final boolean zzfo() {
        if (this.zzcgz == null || this.zzcgz.zzsb() == null) {
            return false;
        }
        return this.zzcgz.zzsb().zzfo();
    }
}
