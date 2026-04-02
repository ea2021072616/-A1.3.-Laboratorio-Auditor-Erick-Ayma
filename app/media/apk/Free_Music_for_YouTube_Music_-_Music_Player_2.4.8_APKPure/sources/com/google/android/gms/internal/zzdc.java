package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes2.dex */
public class zzdc {
    private static final String TAG = zzdc.class.getSimpleName();
    private static Object zzaiq = new Object();
    private static com.google.android.gms.common.zze zzais = null;
    protected Context zzaie;
    private Context zzaif;
    private ExecutorService zzaig;
    private DexClassLoader zzaih;
    private zzcx zzaii;
    private byte[] zzaij;
    private zzco zzaio;
    private volatile AdvertisingIdClient zzaik = null;
    private volatile boolean zzahl = false;
    private Future zzail = null;
    private volatile zzax zzaim = null;
    private Future zzain = null;
    protected boolean zzaip = false;
    private boolean zzair = false;
    private boolean zzaiu = false;
    private Map<Pair<String, String>, zzeb> zzait = new HashMap();

    private zzdc(Context context) {
        this.zzaie = context;
        this.zzaif = context.getApplicationContext();
    }

    public static zzdc zza(Context context, String str, String str2, boolean z) {
        zzdc zzdcVar = new zzdc(context);
        try {
            zzdcVar.zzaig = Executors.newCachedThreadPool();
            zzdcVar.zzahl = z;
            if (z) {
                zzdcVar.zzail = zzdcVar.zzaig.submit(new zzdd(zzdcVar));
            }
            zzdcVar.zzaig.execute(new zzdf(zzdcVar));
            try {
                zzais = com.google.android.gms.common.zze.zzaew();
                zzdcVar.zzaip = com.google.android.gms.common.zze.zzbx(zzdcVar.zzaie) > 0;
                zzdcVar.zzair = zzais.isGooglePlayServicesAvailable(zzdcVar.zzaie) == 0;
            } catch (Throwable th) {
            }
            zzdcVar.zza(0, true);
        } catch (zzcz e) {
        }
        if (zzdh.zzaq() && ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmb)).booleanValue()) {
            throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
        }
        zzdcVar.zzaii = new zzcx(null);
        try {
            zzdcVar.zzaij = zzdcVar.zzaii.zzl(str);
            try {
                try {
                    File cacheDir = zzdcVar.zzaie.getCacheDir();
                    if (cacheDir == null && (cacheDir = zzdcVar.zzaie.getDir("dex", 0)) == null) {
                        throw new zzcz();
                    }
                    File file = cacheDir;
                    File file2 = new File(String.format("%s/%s.jar", file, "1493867303508"));
                    if (!file2.exists()) {
                        byte[] zzb = zzdcVar.zzaii.zzb(zzdcVar.zzaij, str2);
                        file2.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        fileOutputStream.write(zzb, 0, zzb.length);
                        fileOutputStream.close();
                    }
                    zzdcVar.zzb(file, "1493867303508");
                    try {
                        zzdcVar.zzaih = new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, zzdcVar.zzaie.getClassLoader());
                        zza(file2);
                        zzdcVar.zza(file, "1493867303508");
                        zzm(String.format("%s/%s.dex", file, "1493867303508"));
                        zzdcVar.zzaio = new zzco(zzdcVar);
                        zzdcVar.zzaiu = true;
                        return zzdcVar;
                    } catch (Throwable th2) {
                        zza(file2);
                        zzdcVar.zza(file, "1493867303508");
                        zzm(String.format("%s/%s.dex", file, "1493867303508"));
                        throw th2;
                    }
                } catch (zzcy e2) {
                    throw new zzcz(e2);
                } catch (NullPointerException e3) {
                    throw new zzcz(e3);
                }
            } catch (FileNotFoundException e4) {
                throw new zzcz(e4);
            } catch (IOException e5) {
                throw new zzcz(e5);
            }
        } catch (zzcy e6) {
            throw new zzcz(e6);
        }
    }

    private static void zza(File file) {
        if (file.exists()) {
            file.delete();
        } else {
            Log.d(TAG, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zza(java.io.File r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdc.zza(java.io.File, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zza(int i, zzax zzaxVar) {
        if (i < 4) {
            if (zzaxVar == null) {
                return true;
            }
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbme)).booleanValue() && (zzaxVar.zzct == null || zzaxVar.zzct.equals("0000000000000000000000000000000000000000000000000000000000000000"))) {
                return true;
            }
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmf)).booleanValue() && (zzaxVar.zzez == null || zzaxVar.zzez.zzfx == null || zzaxVar.zzez.zzfx.longValue() == -2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzam() {
        try {
            if (this.zzaik != null || this.zzaif == null) {
                return;
            }
            AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzaif);
            advertisingIdClient.start();
            this.zzaik = advertisingIdClient;
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
            this.zzaik = null;
        }
    }

    @VisibleForTesting
    private final zzax zzan() {
        try {
            return zzbvp.zzn(this.zzaie, this.zzaie.getPackageName(), Integer.toString(this.zzaie.getPackageManager().getPackageInfo(this.zzaie.getPackageName(), 0).versionCode));
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzb(java.io.File r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdc.zzb(java.io.File, java.lang.String):boolean");
    }

    private static void zzm(String str) {
        zza(new File(str));
    }

    public final Context getApplicationContext() {
        return this.zzaif;
    }

    public final Context getContext() {
        return this.zzaie;
    }

    public final boolean isInitialized() {
        return this.zzaiu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(int i, boolean z) {
        if (this.zzair) {
            Future<?> submit = this.zzaig.submit(new zzde(this, i, z));
            if (i == 0) {
                this.zzain = submit;
            }
        }
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzait.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzait.put(new Pair<>(str, str2), new zzeb(this, str, str2, clsArr));
        return true;
    }

    public final ExecutorService zzad() {
        return this.zzaig;
    }

    public final DexClassLoader zzae() {
        return this.zzaih;
    }

    public final zzcx zzaf() {
        return this.zzaii;
    }

    public final byte[] zzag() {
        return this.zzaij;
    }

    public final boolean zzah() {
        return this.zzaip;
    }

    public final zzco zzai() {
        return this.zzaio;
    }

    public final boolean zzaj() {
        return this.zzair;
    }

    public final zzax zzak() {
        return this.zzaim;
    }

    public final Future zzal() {
        return this.zzain;
    }

    public final AdvertisingIdClient zzao() {
        if (this.zzahl) {
            if (this.zzaik != null) {
                return this.zzaik;
            }
            if (this.zzail != null) {
                try {
                    this.zzail.get(2000L, TimeUnit.MILLISECONDS);
                    this.zzail = null;
                } catch (InterruptedException e) {
                } catch (ExecutionException e2) {
                } catch (TimeoutException e3) {
                    this.zzail.cancel(true);
                }
            }
            return this.zzaik;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzax zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException e) {
            }
        }
        return zzan();
    }

    public final Method zzc(String str, String str2) {
        zzeb zzebVar = this.zzait.get(new Pair(str, str2));
        if (zzebVar == null) {
            return null;
        }
        return zzebVar.zzaw();
    }

    public final int zzz() {
        if (this.zzaio != null) {
            return zzco.zzz();
        }
        return Integer.MIN_VALUE;
    }
}
