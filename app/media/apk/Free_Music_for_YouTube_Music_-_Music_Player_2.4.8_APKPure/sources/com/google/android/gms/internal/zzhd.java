package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.exoplayer2.util.MimeTypes;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzhd extends Thread {
    private final zzgy zzayo;
    private final zzzr zzayp;
    private boolean mStarted = false;
    private boolean zzayn = false;
    private boolean zzbk = false;
    private final Object mLock = new Object();
    private final int zzaxm = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhv)).intValue();
    private final int zzayr = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhw)).intValue();
    private final int zzaxo = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhx)).intValue();
    private final int zzays = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhy)).intValue();
    private final int zzayt = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbib)).intValue();
    private final int zzayu = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbid)).intValue();
    private final int zzayv = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbie)).intValue();
    private final int zzayq = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhz)).intValue();
    private final String zzayw = (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbig);
    private final boolean zzayx = ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbii)).booleanValue();

    public zzhd(zzgy zzgyVar, zzzr zzzrVar) {
        this.zzayo = zzgyVar;
        this.zzayp = zzzrVar;
        setName("ContentFetchTask");
    }

    private final zzhh zza(@Nullable View view, zzgx zzgxVar) {
        boolean z;
        int i = 0;
        if (view == null) {
            return new zzhh(this, 0, 0);
        }
        Context context = com.google.android.gms.ads.internal.zzbv.zzed().getContext();
        if (context != null) {
            String str = (String) view.getTag(context.getResources().getIdentifier((String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbif), "id", context.getPackageName()));
            if (!TextUtils.isEmpty(this.zzayw) && str != null && str.equals(this.zzayw)) {
                return new zzhh(this, 0, 0);
            }
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzhh(this, 0, 0);
            }
            zzgxVar.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
            return new zzhh(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzakk)) {
            zzgxVar.zzgj();
            WebView webView = (WebView) view;
            if (com.google.android.gms.common.util.zzp.zzalh()) {
                zzgxVar.zzgj();
                webView.post(new zzhf(this, zzgxVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            return z ? new zzhh(this, 0, 1) : new zzhh(this, 0, 0);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzhh zza = zza(viewGroup.getChildAt(i3), zzgxVar);
                i2 += zza.zzazf;
                i += zza.zzazg;
            }
            return new zzhh(this, i2, i);
        } else {
            return new zzhh(this, 0, 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r0.importance != 100) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r1.inKeyguardRestrictedInputMode() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
        r0 = (android.os.PowerManager) r3.getSystemService("power");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r0 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
        if (r0 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        r0 = r0.isScreenOn();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean zzgo() {
        /*
            r2 = 0
            com.google.android.gms.internal.zzgz r0 = com.google.android.gms.ads.internal.zzbv.zzed()     // Catch: java.lang.Throwable -> L65
            android.content.Context r3 = r0.getContext()     // Catch: java.lang.Throwable -> L65
            if (r3 != 0) goto Ld
            r0 = r2
        Lc:
            return r0
        Ld:
            java.lang.String r0 = "activity"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch: java.lang.Throwable -> L65
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch: java.lang.Throwable -> L65
            java.lang.String r1 = "keyguard"
            java.lang.Object r1 = r3.getSystemService(r1)     // Catch: java.lang.Throwable -> L65
            android.app.KeyguardManager r1 = (android.app.KeyguardManager) r1     // Catch: java.lang.Throwable -> L65
            if (r0 == 0) goto L21
            if (r1 != 0) goto L23
        L21:
            r0 = r2
            goto Lc
        L23:
            java.util.List r0 = r0.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L65
            if (r0 != 0) goto L2b
            r0 = r2
            goto Lc
        L2b:
            java.util.Iterator r4 = r0.iterator()     // Catch: java.lang.Throwable -> L65
        L2f:
            boolean r0 = r4.hasNext()     // Catch: java.lang.Throwable -> L65
            if (r0 == 0) goto L63
            java.lang.Object r0 = r4.next()     // Catch: java.lang.Throwable -> L65
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0     // Catch: java.lang.Throwable -> L65
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L65
            int r6 = r0.pid     // Catch: java.lang.Throwable -> L65
            if (r5 != r6) goto L2f
            int r0 = r0.importance     // Catch: java.lang.Throwable -> L65
            r4 = 100
            if (r0 != r4) goto L63
            boolean r0 = r1.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L65
            if (r0 != 0) goto L63
            java.lang.String r0 = "power"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch: java.lang.Throwable -> L65
            android.os.PowerManager r0 = (android.os.PowerManager) r0     // Catch: java.lang.Throwable -> L65
            if (r0 != 0) goto L5e
            r0 = r2
        L5a:
            if (r0 == 0) goto L63
            r0 = 1
            goto Lc
        L5e:
            boolean r0 = r0.isScreenOn()     // Catch: java.lang.Throwable -> L65
            goto L5a
        L63:
            r0 = r2
            goto Lc
        L65:
            r0 = move-exception
            com.google.android.gms.internal.zzafn r1 = com.google.android.gms.ads.internal.zzbv.zzee()
            java.lang.String r3 = "ContentFetchTask.isInForeground"
            r1.zza(r0, r3)
            r0 = r2
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhd.zzgo():boolean");
    }

    private final void zzgq() {
        synchronized (this.mLock) {
            this.zzayn = true;
            zzafx.zzcb(new StringBuilder(42).append("ContentFetchThread: paused, mPause = ").append(this.zzayn).toString());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                if (zzgo()) {
                    Activity activity = com.google.android.gms.ads.internal.zzbv.zzed().getActivity();
                    if (activity == null) {
                        zzafx.zzcb("ContentFetchThread: no activity. Sleeping.");
                        zzgq();
                    } else if (activity != null) {
                        View view = null;
                        try {
                            if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                                view = activity.getWindow().getDecorView().findViewById(16908290);
                            }
                        } catch (Exception e) {
                            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "ContentFetchTask.extractContent");
                            zzafx.zzcb("Failed getting root view of activity. Content not extracted.");
                        }
                        if (view != null && view != null) {
                            view.post(new zzhe(this, view));
                        }
                    }
                } else {
                    zzafx.zzcb("ContentFetchTask: sleeping");
                    zzgq();
                }
                Thread.sleep(this.zzayq * 1000);
            } catch (InterruptedException e2) {
                zzafx.zzb("Error in ContentFetchTask", e2);
            } catch (Exception e3) {
                zzafx.zzb("Error in ContentFetchTask", e3);
                this.zzayp.zza(e3, "ContentFetchTask.run");
            }
            synchronized (this.mLock) {
                while (this.zzayn) {
                    try {
                        zzafx.zzcb("ContentFetchTask: waiting");
                        this.mLock.wait();
                    } catch (InterruptedException e4) {
                    }
                }
            }
        }
    }

    public final void wakeup() {
        synchronized (this.mLock) {
            this.zzayn = false;
            this.mLock.notifyAll();
            zzafx.zzcb("ContentFetchThread: wakeup");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzgx zzgxVar, WebView webView, String str, boolean z) {
        zzgxVar.zzgi();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(MimeTypes.BASE_TYPE_TEXT);
                if (this.zzayx || TextUtils.isEmpty(webView.getTitle())) {
                    zzgxVar.zza(optString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    zzgxVar.zza(new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length()).append(title).append("\n").append(optString).toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzgxVar.zzgd()) {
                this.zzayo.zzb(zzgxVar);
            }
        } catch (JSONException e) {
            zzafx.zzcb("Json string may be malformed.");
        } catch (Throwable th) {
            zzafx.zza("Failed to get webview content.", th);
            this.zzayp.zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(View view) {
        try {
            zzgx zzgxVar = new zzgx(this.zzaxm, this.zzayr, this.zzaxo, this.zzays, this.zzayt, this.zzayu, this.zzayv);
            zzhh zza = zza(view, zzgxVar);
            zzgxVar.zzgk();
            if (zza.zzazf == 0 && zza.zzazg == 0) {
                return;
            }
            if (zza.zzazg == 0 && zzgxVar.zzgl() == 0) {
                return;
            }
            if (zza.zzazg == 0 && this.zzayo.zza(zzgxVar)) {
                return;
            }
            this.zzayo.zzc(zzgxVar);
        } catch (Exception e) {
            zzafx.zzb("Exception in fetchContentOnUIThread", e);
            this.zzayp.zza(e, "ContentFetchTask.fetchContent");
        }
    }

    public final void zzgn() {
        synchronized (this.mLock) {
            if (this.mStarted) {
                zzafx.zzcb("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    public final zzgx zzgp() {
        return this.zzayo.zzgm();
    }

    public final boolean zzgr() {
        return this.zzayn;
    }
}
