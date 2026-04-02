package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.WeakHashMap;
@zzzt
/* loaded from: classes.dex */
public final class zzzo implements zzzr {
    private static final Object zzaqm = new Object();
    private static zzzr zzcnd = null;
    private final Context mContext;
    private final String mPackageName;
    private final zzajk zzaqr;
    private final Object zzcne = new Object();
    private final WeakHashMap<Thread, Boolean> zzcnf = new WeakHashMap<>();

    private zzzo(Context context, String str, zzajk zzajkVar) {
        this.mContext = context;
        this.mPackageName = str;
        this.zzaqr = zzajkVar;
        Thread thread = Looper.getMainLooper().getThread();
        if (thread != null) {
            synchronized (this.zzcne) {
                this.zzcnf.put(thread, true);
            }
            thread.setUncaughtExceptionHandler(new zzzq(this, thread.getUncaughtExceptionHandler()));
        }
        Thread.setDefaultUncaughtExceptionHandler(new zzzp(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private final String zza(Class cls, Throwable th, String str) {
        StringWriter stringWriter = new StringWriter();
        ThrowableExtension.printStackTrace(th, new PrintWriter(stringWriter));
        boolean z = false;
        try {
            z = zzbdp.zzcs(this.mContext).zzalq();
        } catch (Throwable th2) {
            zzafx.zzb("Error fetching instant app info", th2);
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        com.google.android.gms.ads.internal.zzbv.zzea();
        return appendQueryParameter.appendQueryParameter("device", zzahf.zzqv()).appendQueryParameter("js", this.zzaqr.zzcp).appendQueryParameter("appid", this.mPackageName).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", zzmu.zzil())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "164654066").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", com.google.android.gms.ads.internal.zzbv.zzee().getSessionId()).toString();
    }

    private static boolean zzbs(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbgc))) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(zzzt.class);
        } catch (Exception e) {
            String valueOf = String.valueOf(str);
            zzafx.zza(valueOf.length() != 0 ? "Fail to check class type for class ".concat(valueOf) : new String("Fail to check class type for class "), e);
            return false;
        }
    }

    public static zzzr zzc(Context context, zzajk zzajkVar) {
        synchronized (zzaqm) {
            if (zzcnd == null) {
                if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbga)).booleanValue()) {
                    zzcnd = new zzzo(context.getApplicationContext(), context.getApplicationContext().getPackageName(), zzajkVar);
                } else {
                    zzcnd = new zzzs();
                }
            }
        }
        return zzcnd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
        if (r2 == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.Thread r11, java.lang.Throwable r12) {
        /*
            r10 = this;
            r1 = 1
            r3 = 0
            if (r12 == 0) goto L46
            r2 = r3
            r0 = r3
            r5 = r12
        L7:
            if (r5 == 0) goto L3a
            java.lang.StackTraceElement[] r6 = r5.getStackTrace()
            int r7 = r6.length
            r4 = r3
        Lf:
            if (r4 >= r7) goto L34
            r8 = r6[r4]
            java.lang.String r9 = r8.getClassName()
            boolean r9 = zzbs(r9)
            if (r9 == 0) goto L1e
            r0 = r1
        L1e:
            java.lang.Class r9 = r10.getClass()
            java.lang.String r9 = r9.getName()
            java.lang.String r8 = r8.getClassName()
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L31
            r2 = r1
        L31:
            int r4 = r4 + 1
            goto Lf
        L34:
            java.lang.Throwable r4 = r5.getCause()
            r5 = r4
            goto L7
        L3a:
            if (r0 == 0) goto L46
            if (r2 != 0) goto L46
        L3e:
            if (r1 == 0) goto L45
            java.lang.String r0 = ""
            r10.zza(r12, r0)
        L45:
            return
        L46:
            r1 = r3
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzzo.zza(java.lang.Thread, java.lang.Throwable):void");
    }

    @Override // com.google.android.gms.internal.zzzr
    public final void zza(Throwable th, String str) {
        Throwable th2;
        Throwable th3;
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbgb)).booleanValue()) {
            th2 = th;
        } else {
            LinkedList linkedList = new LinkedList();
            for (Throwable th4 = th; th4 != null; th4 = th4.getCause()) {
                linkedList.push(th4);
            }
            th2 = null;
            while (!linkedList.isEmpty()) {
                Throwable th5 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th5.getStackTrace();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th5.getClass().getName(), "<filtered>", "<filtered>", 1));
                boolean z = false;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (zzbs(stackTraceElement.getClassName())) {
                        z = true;
                        arrayList.add(stackTraceElement);
                    } else {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                            arrayList.add(stackTraceElement);
                        } else {
                            arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                        }
                    }
                }
                if (z) {
                    th3 = th2 == null ? new Throwable(th5.getMessage()) : new Throwable(th5.getMessage(), th2);
                    th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                } else {
                    th3 = th2;
                }
                th2 = th3;
            }
        }
        if (th2 == null) {
            return;
        }
        Class<?> cls = th.getClass();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(zza(cls, th2, str));
        com.google.android.gms.ads.internal.zzbv.zzea();
        zzahf.zza(arrayList2, com.google.android.gms.ads.internal.zzbv.zzee().zzpv());
    }
}
