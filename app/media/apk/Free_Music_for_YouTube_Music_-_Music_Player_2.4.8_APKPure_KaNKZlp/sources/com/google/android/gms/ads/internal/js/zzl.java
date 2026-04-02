package com.google.android.gms.ads.internal.js;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzaif;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zzl {
    private final Context mContext;
    private final Object mLock;
    private final zzajk zzapc;
    private final String zzbyt;
    private zzaif<zza> zzbyu;
    private zzaif<zza> zzbyv;
    @Nullable
    private zzac zzbyw;
    private int zzbyx;

    public zzl(Context context, zzajk zzajkVar, String str) {
        this.mLock = new Object();
        this.zzbyx = 1;
        this.zzbyt = str;
        this.mContext = context.getApplicationContext();
        this.zzapc = zzajkVar;
        this.zzbyu = new zzx();
        this.zzbyv = new zzx();
    }

    public zzl(Context context, zzajk zzajkVar, String str, zzaif<zza> zzaifVar, zzaif<zza> zzaifVar2) {
        this(context, zzajkVar, str);
        this.zzbyu = zzaifVar;
        this.zzbyv = zzaifVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzac zza(@Nullable zzcv zzcvVar) {
        zzac zzacVar = new zzac(this.zzbyv);
        zzbv.zzea();
        zzahf.runOnUiThread(new zzm(this, zzcvVar, zzacVar));
        zzacVar.zza(new zzu(this, zzacVar), new zzv(this, zzacVar));
        return zzacVar;
    }

    public final zzy zzb(@Nullable zzcv zzcvVar) {
        zzy zzlc;
        synchronized (this.mLock) {
            if (this.zzbyw == null || this.zzbyw.getStatus() == -1) {
                this.zzbyx = 2;
                this.zzbyw = zza(zzcvVar);
                zzlc = this.zzbyw.zzlc();
            } else if (this.zzbyx == 0) {
                zzlc = this.zzbyw.zzlc();
            } else if (this.zzbyx == 1) {
                this.zzbyx = 2;
                zza(zzcvVar);
                zzlc = this.zzbyw.zzlc();
            } else {
                zzlc = this.zzbyx == 2 ? this.zzbyw.zzlc() : this.zzbyw.zzlc();
            }
        }
        return zzlc;
    }
}
