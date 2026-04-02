package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public abstract class zzcr implements zzcq {
    protected MotionEvent zzagq;
    protected double zzagz;
    private double zzaha;
    private double zzahb;
    protected float zzahc;
    protected float zzahd;
    protected float zzahe;
    protected float zzahf;
    protected DisplayMetrics zzahi;
    protected LinkedList<MotionEvent> zzagr = new LinkedList<>();
    protected long zzags = 0;
    protected long zzagt = 0;
    protected long zzagu = 0;
    protected long zzagv = 0;
    protected long zzagw = 0;
    protected long zzagx = 0;
    protected long zzagy = 0;
    private boolean zzahg = false;
    protected boolean zzahh = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzcr(Context context) {
        try {
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbma)).booleanValue()) {
                zzbv.zzw();
            } else {
                zzby.zzy();
            }
            this.zzahi = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e A[Catch: UnsupportedEncodingException -> 0x0055, Throwable -> 0x005c, GeneralSecurityException -> 0x0063, TryCatch #3 {UnsupportedEncodingException -> 0x0055, GeneralSecurityException -> 0x0063, Throwable -> 0x005c, blocks: (B:8:0x0015, B:10:0x001f, B:17:0x0034, B:23:0x004c, B:12:0x0025, B:16:0x002e), top: B:35:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015 A[Catch: UnsupportedEncodingException -> 0x0055, Throwable -> 0x005c, GeneralSecurityException -> 0x0063, TRY_ENTER, TryCatch #3 {UnsupportedEncodingException -> 0x0055, GeneralSecurityException -> 0x0063, Throwable -> 0x005c, blocks: (B:8:0x0015, B:10:0x001f, B:17:0x0034, B:23:0x004c, B:12:0x0025, B:16:0x002e), top: B:35:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String zza(android.content.Context r6, java.lang.String r7, boolean r8, android.view.View r9, byte[] r10) {
        /*
            r5 = this;
            r2 = 0
            r1 = 1
            r3 = 0
            if (r10 == 0) goto L2c
            int r0 = r10.length
            if (r0 <= 0) goto L2c
            com.google.android.gms.internal.zzau r0 = new com.google.android.gms.internal.zzau     // Catch: com.google.android.gms.internal.zzegn -> L2b
            r0.<init>()     // Catch: com.google.android.gms.internal.zzegn -> L2b
            com.google.android.gms.internal.zzego r0 = com.google.android.gms.internal.zzego.zza(r0, r10)     // Catch: com.google.android.gms.internal.zzegn -> L2b
            com.google.android.gms.internal.zzau r0 = (com.google.android.gms.internal.zzau) r0     // Catch: com.google.android.gms.internal.zzegn -> L2b
        L13:
            if (r8 == 0) goto L2e
            com.google.android.gms.internal.zzax r0 = r5.zza(r6, r9)     // Catch: java.io.UnsupportedEncodingException -> L55 java.lang.Throwable -> L5c java.security.GeneralSecurityException -> L63
            r3 = 1
            r5.zzahg = r3     // Catch: java.io.UnsupportedEncodingException -> L55 java.lang.Throwable -> L5c java.security.GeneralSecurityException -> L63
            r3 = r0
        L1d:
            if (r3 == 0) goto L25
            int r0 = r3.zzbjo()     // Catch: java.io.UnsupportedEncodingException -> L55 java.lang.Throwable -> L5c java.security.GeneralSecurityException -> L63
            if (r0 != 0) goto L34
        L25:
            r0 = 5
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch: java.io.UnsupportedEncodingException -> L55 java.lang.Throwable -> L5c java.security.GeneralSecurityException -> L63
        L2a:
            return r0
        L2b:
            r0 = move-exception
        L2c:
            r0 = r3
            goto L13
        L2e:
            com.google.android.gms.internal.zzax r0 = r5.zza(r6, r0)     // Catch: java.io.UnsupportedEncodingException -> L55 java.lang.Throwable -> L5c java.security.GeneralSecurityException -> L63
            r3 = r0
            goto L1d
        L34:
            com.google.android.gms.internal.zzmk<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmu.zzblq     // Catch: java.io.UnsupportedEncodingException -> L55 java.lang.Throwable -> L5c java.security.GeneralSecurityException -> L63
            com.google.android.gms.internal.zzms r4 = com.google.android.gms.ads.internal.zzbv.zzen()     // Catch: java.io.UnsupportedEncodingException -> L55 java.lang.Throwable -> L5c java.security.GeneralSecurityException -> L63
            java.lang.Object r0 = r4.zzd(r0)     // Catch: java.io.UnsupportedEncodingException -> L55 java.lang.Throwable -> L5c java.security.GeneralSecurityException -> L63
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.io.UnsupportedEncodingException -> L55 java.lang.Throwable -> L5c java.security.GeneralSecurityException -> L63
            boolean r0 = r0.booleanValue()     // Catch: java.io.UnsupportedEncodingException -> L55 java.lang.Throwable -> L5c java.security.GeneralSecurityException -> L63
            if (r0 == 0) goto L48
            if (r8 == 0) goto L51
        L48:
            r0 = r1
        L49:
            if (r0 != 0) goto L53
            r0 = r1
        L4c:
            java.lang.String r0 = com.google.android.gms.internal.zzbv.zza(r3, r7, r0)     // Catch: java.io.UnsupportedEncodingException -> L55 java.lang.Throwable -> L5c java.security.GeneralSecurityException -> L63
            goto L2a
        L51:
            r0 = r2
            goto L49
        L53:
            r0 = r2
            goto L4c
        L55:
            r0 = move-exception
        L56:
            r0 = 7
            java.lang.String r0 = java.lang.Integer.toString(r0)
            goto L2a
        L5c:
            r0 = move-exception
            r0 = 3
            java.lang.String r0 = java.lang.Integer.toString(r0)
            goto L2a
        L63:
            r0 = move-exception
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcr.zza(android.content.Context, java.lang.String, boolean, android.view.View, byte[]):java.lang.String");
    }

    protected abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzcz;

    protected abstract zzax zza(Context context, View view);

    protected abstract zzax zza(Context context, zzau zzauVar);

    @Override // com.google.android.gms.internal.zzcq
    public final String zza(Context context) {
        if (zzdh.zzaq()) {
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmc)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, null, false, null, null);
    }

    public final String zza(Context context, String str) {
        return zza(context, str, (View) null);
    }

    @Override // com.google.android.gms.internal.zzcq
    public final String zza(Context context, String str, View view) {
        return zza(context, str, true, view, null);
    }

    public final String zza(Context context, byte[] bArr) {
        if (zzdh.zzaq()) {
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmc)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, null, false, null, bArr);
    }

    @Override // com.google.android.gms.internal.zzcq
    public final void zza(int i, int i2, int i3) {
        if (this.zzagq != null) {
            this.zzagq.recycle();
        }
        if (this.zzahi != null) {
            this.zzagq = MotionEvent.obtain(0L, i3, 1, i * this.zzahi.density, i2 * this.zzahi.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzagq = null;
        }
        this.zzahh = false;
    }

    @Override // com.google.android.gms.internal.zzcq
    public final void zza(MotionEvent motionEvent) {
        if (this.zzahg) {
            this.zzagv = 0L;
            this.zzagu = 0L;
            this.zzagt = 0L;
            this.zzags = 0L;
            this.zzagw = 0L;
            this.zzagy = 0L;
            this.zzagx = 0L;
            Iterator<MotionEvent> it = this.zzagr.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.zzagr.clear();
            this.zzagq = null;
            this.zzahg = false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzblu)).booleanValue()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.zzagz = 0.0d;
                    this.zzaha = motionEvent.getRawX();
                    this.zzahb = motionEvent.getRawY();
                    break;
                case 1:
                case 2:
                    double rawX = motionEvent.getRawX();
                    double rawY = motionEvent.getRawY();
                    double d = rawX - this.zzaha;
                    double d2 = rawY - this.zzahb;
                    this.zzagz = Math.sqrt((d * d) + (d2 * d2)) + this.zzagz;
                    this.zzaha = rawX;
                    this.zzahb = rawY;
                    break;
            }
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzblv)).booleanValue()) {
                    this.zzahc = motionEvent.getX();
                    this.zzahd = motionEvent.getY();
                    this.zzahe = motionEvent.getRawX();
                    this.zzahf = motionEvent.getRawY();
                }
                this.zzags++;
                break;
            case 1:
                this.zzagq = MotionEvent.obtain(motionEvent);
                this.zzagr.add(this.zzagq);
                if (this.zzagr.size() > 6) {
                    this.zzagr.remove().recycle();
                }
                this.zzagu++;
                try {
                    this.zzagw = zza(new Throwable().getStackTrace());
                    break;
                } catch (zzcz e) {
                    break;
                }
            case 2:
                this.zzagt += motionEvent.getHistorySize() + 1;
                try {
                    zzdg zzb = zzb(motionEvent);
                    if ((zzb == null || zzb.zzfd == null || zzb.zzajc == null) ? false : true) {
                        this.zzagx += zzb.zzfd.longValue() + zzb.zzajc.longValue();
                    }
                    if ((this.zzahi == null || zzb == null || zzb.zzfb == null || zzb.zzajd == null) ? false : true) {
                        this.zzagy = zzb.zzajd.longValue() + zzb.zzfb.longValue() + this.zzagy;
                        break;
                    }
                } catch (zzcz e2) {
                    break;
                }
                break;
            case 3:
                this.zzagv++;
                break;
        }
        this.zzahh = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzdg zzb(MotionEvent motionEvent) throws zzcz;
}
