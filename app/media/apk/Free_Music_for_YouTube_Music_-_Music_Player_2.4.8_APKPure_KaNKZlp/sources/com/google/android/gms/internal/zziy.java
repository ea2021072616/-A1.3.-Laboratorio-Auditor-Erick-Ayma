package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zziy {
    private Bundle mExtras;
    private boolean zzalt;
    private long zzbcb;
    private int zzbcc;
    private List<String> zzbcd;
    private boolean zzbce;
    private int zzbcf;
    private String zzbcg;
    private zzlz zzbch;
    private String zzbci;
    private Bundle zzbcj;
    private Bundle zzbck;
    private List<String> zzbcl;
    private String zzbcm;
    private String zzbcn;
    private boolean zzbco;
    private Location zzhe;

    public zziy() {
        this.zzbcb = -1L;
        this.mExtras = new Bundle();
        this.zzbcc = -1;
        this.zzbcd = new ArrayList();
        this.zzbce = false;
        this.zzbcf = -1;
        this.zzalt = false;
        this.zzbcg = null;
        this.zzbch = null;
        this.zzhe = null;
        this.zzbci = null;
        this.zzbcj = new Bundle();
        this.zzbck = new Bundle();
        this.zzbcl = new ArrayList();
        this.zzbcm = null;
        this.zzbcn = null;
        this.zzbco = false;
    }

    public zziy(zzix zzixVar) {
        this.zzbcb = zzixVar.zzbbl;
        this.mExtras = zzixVar.extras;
        this.zzbcc = zzixVar.zzbbm;
        this.zzbcd = zzixVar.zzbbn;
        this.zzbce = zzixVar.zzbbo;
        this.zzbcf = zzixVar.zzbbp;
        this.zzalt = zzixVar.zzbbq;
        this.zzbcg = zzixVar.zzbbr;
        this.zzbch = zzixVar.zzbbs;
        this.zzhe = zzixVar.zzbbt;
        this.zzbci = zzixVar.zzbbu;
        this.zzbcj = zzixVar.zzbbv;
        this.zzbck = zzixVar.zzbbw;
        this.zzbcl = zzixVar.zzbbx;
        this.zzbcm = zzixVar.zzbby;
        this.zzbcn = zzixVar.zzbbz;
    }

    public final zziy zza(@Nullable Location location) {
        this.zzhe = null;
        return this;
    }

    public final zzix zzhl() {
        return new zzix(7, this.zzbcb, this.mExtras, this.zzbcc, this.zzbcd, this.zzbce, this.zzbcf, this.zzalt, this.zzbcg, this.zzbch, this.zzhe, this.zzbci, this.zzbcj, this.zzbck, this.zzbcl, this.zzbcm, this.zzbcn, false);
    }
}
