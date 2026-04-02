package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzbp;
/* loaded from: classes2.dex */
public final class zzcqb {
    private final Context mContext;
    private final String zzfxt;
    private final String zzfxv;
    private final PowerManager.WakeLock zzjnp;
    private WorkSource zzjnq;
    private final int zzjnr;
    private final String zzjns;
    private boolean zzjnt;
    private int zzjnu;
    private int zzjnv;
    private static String TAG = "WakeLock";
    private static String zzjno = "*gcore*:";
    private static boolean DEBUG = false;

    public zzcqb(Context context, int i, String str) {
        this(context, 1, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private zzcqb(Context context, int i, String str, String str2, String str3) {
        this(context, 1, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private zzcqb(Context context, int i, String str, String str2, String str3, String str4) {
        this.zzjnt = true;
        zzbp.zzh(str, "Wake lock name can NOT be empty");
        this.zzjnr = i;
        this.zzjns = null;
        this.zzfxv = null;
        this.mContext = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.zzfxt = str;
        } else {
            String valueOf = String.valueOf(zzjno);
            String valueOf2 = String.valueOf(str);
            this.zzfxt = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.zzjnp = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (com.google.android.gms.common.util.zzw.zzcp(this.mContext)) {
            this.zzjnq = com.google.android.gms.common.util.zzw.zzad(context, com.google.android.gms.common.util.zzs.zzgl(str3) ? context.getPackageName() : str3);
            WorkSource workSource = this.zzjnq;
            if (workSource == null || !com.google.android.gms.common.util.zzw.zzcp(this.mContext)) {
                return;
            }
            if (this.zzjnq != null) {
                this.zzjnq.add(workSource);
            } else {
                this.zzjnq = workSource;
            }
            try {
                this.zzjnp.setWorkSource(this.zzjnq);
            } catch (IllegalArgumentException e) {
                Log.wtf(TAG, e.toString());
            }
        }
    }

    private final String zzh(String str, boolean z) {
        if (this.zzjnt && z) {
            return null;
        }
        return this.zzjns;
    }

    private final boolean zzlb(String str) {
        String str2 = null;
        return (TextUtils.isEmpty(null) || str2.equals(this.zzjns)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r0 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
        if (r12.zzjnv == 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void acquire(long r13) {
        /*
            r12 = this;
            r10 = 1000(0x3e8, double:4.94E-321)
            r1 = 0
            boolean r0 = r12.zzlb(r1)
            java.lang.String r4 = r12.zzh(r1, r0)
            monitor-enter(r12)
            int r1 = r12.zzjnu     // Catch: java.lang.Throwable -> L61
            if (r1 > 0) goto L14
            int r1 = r12.zzjnv     // Catch: java.lang.Throwable -> L61
            if (r1 <= 0) goto L22
        L14:
            android.os.PowerManager$WakeLock r1 = r12.zzjnp     // Catch: java.lang.Throwable -> L61
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L61
            if (r1 != 0) goto L22
            r1 = 0
            r12.zzjnu = r1     // Catch: java.lang.Throwable -> L61
            r1 = 0
            r12.zzjnv = r1     // Catch: java.lang.Throwable -> L61
        L22:
            boolean r1 = r12.zzjnt     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L30
            int r1 = r12.zzjnu     // Catch: java.lang.Throwable -> L61
            int r2 = r1 + 1
            r12.zzjnu = r2     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L38
            if (r0 != 0) goto L38
        L30:
            boolean r0 = r12.zzjnt     // Catch: java.lang.Throwable -> L61
            if (r0 != 0) goto L5a
            int r0 = r12.zzjnv     // Catch: java.lang.Throwable -> L61
            if (r0 != 0) goto L5a
        L38:
            com.google.android.gms.common.stats.zze.zzalb()     // Catch: java.lang.Throwable -> L61
            android.content.Context r0 = r12.mContext     // Catch: java.lang.Throwable -> L61
            android.os.PowerManager$WakeLock r1 = r12.zzjnp     // Catch: java.lang.Throwable -> L61
            java.lang.String r1 = com.google.android.gms.common.stats.zzc.zza(r1, r4)     // Catch: java.lang.Throwable -> L61
            r2 = 7
            java.lang.String r3 = r12.zzfxt     // Catch: java.lang.Throwable -> L61
            r5 = 0
            int r6 = r12.zzjnr     // Catch: java.lang.Throwable -> L61
            android.os.WorkSource r7 = r12.zzjnq     // Catch: java.lang.Throwable -> L61
            java.util.List r7 = com.google.android.gms.common.util.zzw.zzb(r7)     // Catch: java.lang.Throwable -> L61
            r8 = 1000(0x3e8, double:4.94E-321)
            com.google.android.gms.common.stats.zze.zza(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L61
            int r0 = r12.zzjnv     // Catch: java.lang.Throwable -> L61
            int r0 = r0 + 1
            r12.zzjnv = r0     // Catch: java.lang.Throwable -> L61
        L5a:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L61
            android.os.PowerManager$WakeLock r0 = r12.zzjnp
            r0.acquire(r10)
            return
        L61:
            r0 = move-exception
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L61
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcqb.acquire(long):void");
    }

    public final boolean isHeld() {
        return this.zzjnp.isHeld();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r8.zzjnv == 1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r0 == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void release() {
        /*
            r8 = this;
            r1 = 0
            boolean r0 = r8.zzlb(r1)
            java.lang.String r4 = r8.zzh(r1, r0)
            monitor-enter(r8)
            boolean r1 = r8.zzjnt     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L18
            int r1 = r8.zzjnu     // Catch: java.lang.Throwable -> L49
            int r1 = r1 + (-1)
            r8.zzjnu = r1     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L21
            if (r0 != 0) goto L21
        L18:
            boolean r0 = r8.zzjnt     // Catch: java.lang.Throwable -> L49
            if (r0 != 0) goto L42
            int r0 = r8.zzjnv     // Catch: java.lang.Throwable -> L49
            r1 = 1
            if (r0 != r1) goto L42
        L21:
            com.google.android.gms.common.stats.zze.zzalb()     // Catch: java.lang.Throwable -> L49
            android.content.Context r0 = r8.mContext     // Catch: java.lang.Throwable -> L49
            android.os.PowerManager$WakeLock r1 = r8.zzjnp     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = com.google.android.gms.common.stats.zzc.zza(r1, r4)     // Catch: java.lang.Throwable -> L49
            r2 = 8
            java.lang.String r3 = r8.zzfxt     // Catch: java.lang.Throwable -> L49
            r5 = 0
            int r6 = r8.zzjnr     // Catch: java.lang.Throwable -> L49
            android.os.WorkSource r7 = r8.zzjnq     // Catch: java.lang.Throwable -> L49
            java.util.List r7 = com.google.android.gms.common.util.zzw.zzb(r7)     // Catch: java.lang.Throwable -> L49
            com.google.android.gms.common.stats.zze.zza(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L49
            int r0 = r8.zzjnv     // Catch: java.lang.Throwable -> L49
            int r0 = r0 + (-1)
            r8.zzjnv = r0     // Catch: java.lang.Throwable -> L49
        L42:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L49
            android.os.PowerManager$WakeLock r0 = r8.zzjnp
            r0.release()
            return
        L49:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L49
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcqb.release():void");
    }

    public final void setReferenceCounted(boolean z) {
        this.zzjnp.setReferenceCounted(false);
        this.zzjnt = false;
    }
}
