package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.js.JavascriptEngineFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@zzzt
/* loaded from: classes.dex */
public final class zzym {
    private final Context mContext;
    private final Object mLock;
    private final zzajk zzaqr;
    private final zzcv zzbsr;
    private final com.google.android.gms.ads.internal.zzbc zzclf;
    private JavascriptEngineFactory zzclg;
    private com.google.android.gms.ads.internal.js.zzah zzclh;
    private zzajr<com.google.android.gms.ads.internal.js.zza> zzcli;
    private boolean zzclj;
    private boolean zzclk;
    private static final long zzclc = TimeUnit.SECONDS.toMillis(60);
    private static final Object zzaqm = new Object();
    private static boolean zzcld = false;
    private static com.google.android.gms.ads.internal.js.zzl zzcle = null;

    public zzym(Context context, com.google.android.gms.ads.internal.zzbc zzbcVar, zzcv zzcvVar, zzajk zzajkVar) {
        this.mLock = new Object();
        this.zzclj = false;
        this.zzclk = false;
        this.mContext = context;
        this.zzclf = zzbcVar;
        this.zzbsr = zzcvVar;
        this.zzaqr = zzajkVar;
        this.zzclj = ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmu)).booleanValue();
    }

    public zzym(Context context, zzafj zzafjVar, com.google.android.gms.ads.internal.zzbc zzbcVar, zzcv zzcvVar) {
        this(context, zzbcVar, zzcvVar, (zzafjVar == null || zzafjVar.zzcrj == null) ? null : zzafjVar.zzcrj.zzatj);
    }

    @Nullable
    private final com.google.android.gms.ads.internal.js.zza zznx() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        com.google.android.gms.ads.internal.js.zza zzaVar = null;
        if (this.zzcli != null) {
            zzaVar = this.zzcli.get(zzclc, TimeUnit.MILLISECONDS);
            synchronized (this.mLock) {
                if (!this.zzclk) {
                    zzaVar.zza(this.zzclf, this.zzclf, this.zzclf, this.zzclf, false, null, null, null);
                    this.zzclk = true;
                }
            }
        }
        return zzaVar;
    }

    public final void zza(zzyr zzyrVar) {
        if (this.zzclj) {
            com.google.android.gms.ads.internal.js.zzah zzahVar = this.zzclh;
            if (zzahVar == null) {
                zzafx.zzcs("SharedJavascriptEngine not initialized");
                return;
            } else {
                zzahVar.zza(new zzyn(this, zzyrVar), new zzyo(this, zzyrVar));
                return;
            }
        }
        try {
            com.google.android.gms.ads.internal.js.zza zznx = zznx();
            if (zznx == null) {
                zzafx.zzcs("JavascriptEngine not initialized");
            } else {
                zzyrVar.zzd(zznx);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            zzafx.zzc("Exception occurred during execution", e);
        } catch (CancellationException e2) {
            e = e2;
            zzafx.zzc("Exception occurred during execution", e);
        } catch (ExecutionException e3) {
            e = e3;
            zzafx.zzc("Exception occurred during execution", e);
        } catch (TimeoutException e4) {
            e = e4;
            zzafx.zzc("Exception occurred during execution", e);
        }
    }

    public final void zzlf() {
        if (this.zzclj) {
            return;
        }
        try {
            com.google.android.gms.ads.internal.js.zza zznx = zznx();
            if (zznx != null) {
                com.google.android.gms.ads.internal.zzbv.zzea();
                zzahf.runOnUiThread(new zzyq(this, zznx));
            }
        } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e) {
            zzafx.zzc("Exception occurred while destroying engine", e);
        }
    }

    public final void zznv() {
        if (!this.zzclj) {
            this.zzclg = new JavascriptEngineFactory();
            return;
        }
        synchronized (zzaqm) {
            if (!zzcld) {
                zzcle = new com.google.android.gms.ads.internal.js.zzl(this.mContext.getApplicationContext() != null ? this.mContext.getApplicationContext() : this.mContext, this.zzaqr, (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmr), new zzyp(this), new com.google.android.gms.ads.internal.js.zzx());
                zzcld = true;
            }
        }
    }

    public final void zznw() throws zzakw {
        if (this.zzclj) {
            this.zzclh = new com.google.android.gms.ads.internal.js.zzah(zzcle.zzb(this.zzbsr));
            return;
        }
        this.zzcli = this.zzclg.zza(this.mContext, this.zzaqr, (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmr), this.zzbsr, this.zzclf.zzbj());
    }
}
