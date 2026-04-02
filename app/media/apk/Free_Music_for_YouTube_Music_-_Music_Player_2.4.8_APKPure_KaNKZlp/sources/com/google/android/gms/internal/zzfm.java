package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzfm implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final Context mApplicationContext;
    private final WeakReference<zzafi> zzavd;
    private final zzgw zzavf;
    protected final zzfk zzavg;
    private final WindowManager zzavh;
    private final PowerManager zzavi;
    private final KeyguardManager zzavj;
    private final DisplayMetrics zzavk;
    @Nullable
    private zzft zzavl;
    private boolean zzavm;
    private boolean zzavp;
    @Nullable
    private BroadcastReceiver zzavr;
    private float zzavw;
    private Object mLock = new Object();
    private boolean zzark = false;
    private boolean zzavn = false;
    private final HashSet<Object> zzavs = new HashSet<>();
    private final HashSet<zzgh> zzavt = new HashSet<>();
    private final Rect zzavu = new Rect();
    private WeakReference<ViewTreeObserver> zzave = new WeakReference<>(null);
    private boolean zzavo = true;
    private boolean zzavq = false;
    private zzaix zzaun = new zzaix(200);
    private final zzfp zzavv = new zzfp(this, new Handler());

    public zzfm(Context context, zzjb zzjbVar, zzafi zzafiVar, zzajk zzajkVar, zzgw zzgwVar) {
        this.zzavd = new WeakReference<>(zzafiVar);
        this.zzavf = zzgwVar;
        this.zzavg = new zzfk(UUID.randomUUID().toString(), zzajkVar, zzjbVar.zzbcq, zzafiVar.zzcyc, zzafiVar.zzfo(), zzjbVar.zzbct);
        this.zzavh = (WindowManager) context.getSystemService("window");
        this.zzavi = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.zzavj = (KeyguardManager) context.getSystemService("keyguard");
        this.mApplicationContext = context;
        this.mApplicationContext.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.zzavv);
        this.zzavk = context.getResources().getDisplayMetrics();
        Display defaultDisplay = this.zzavh.getDefaultDisplay();
        this.zzavu.right = defaultDisplay.getWidth();
        this.zzavu.bottom = defaultDisplay.getHeight();
        zzfq();
    }

    private final boolean isScreenOn() {
        return Build.VERSION.SDK_INT >= 20 ? this.zzavi.isInteractive() : this.zzavi.isScreenOn();
    }

    private static int zza(int i, DisplayMetrics displayMetrics) {
        return (int) (i / displayMetrics.density);
    }

    private final JSONObject zza(@Nullable View view, @Nullable Boolean bool) throws JSONException {
        if (view == null) {
            return zzfv().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
        }
        boolean isAttachedToWindow = com.google.android.gms.ads.internal.zzbv.zzec().isAttachedToWindow(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Exception e) {
            zzafx.zzb("Failure getting view location.", e);
        }
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect2, null);
        Rect rect3 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect3);
        Rect rect4 = new Rect();
        view.getHitRect(rect4);
        JSONObject zzfv = zzfv();
        zzfv.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", isAttachedToWindow).put("viewBox", new JSONObject().put("top", zza(this.zzavu.top, this.zzavk)).put("bottom", zza(this.zzavu.bottom, this.zzavk)).put(TtmlNode.LEFT, zza(this.zzavu.left, this.zzavk)).put(TtmlNode.RIGHT, zza(this.zzavu.right, this.zzavk))).put("adBox", new JSONObject().put("top", zza(rect.top, this.zzavk)).put("bottom", zza(rect.bottom, this.zzavk)).put(TtmlNode.LEFT, zza(rect.left, this.zzavk)).put(TtmlNode.RIGHT, zza(rect.right, this.zzavk))).put("globalVisibleBox", new JSONObject().put("top", zza(rect2.top, this.zzavk)).put("bottom", zza(rect2.bottom, this.zzavk)).put(TtmlNode.LEFT, zza(rect2.left, this.zzavk)).put(TtmlNode.RIGHT, zza(rect2.right, this.zzavk))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", zza(rect3.top, this.zzavk)).put("bottom", zza(rect3.bottom, this.zzavk)).put(TtmlNode.LEFT, zza(rect3.left, this.zzavk)).put(TtmlNode.RIGHT, zza(rect3.right, this.zzavk))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", zza(rect4.top, this.zzavk)).put("bottom", zza(rect4.bottom, this.zzavk)).put(TtmlNode.LEFT, zza(rect4.left, this.zzavk)).put(TtmlNode.RIGHT, zza(rect4.right, this.zzavk))).put("screenDensity", this.zzavk.density);
        if (bool == null) {
            bool = Boolean.valueOf(com.google.android.gms.ads.internal.zzbv.zzea().zza(view, this.zzavi, this.zzavj));
        }
        zzfv.put("isVisible", bool.booleanValue());
        return zzfv;
    }

    private static JSONObject zza(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }

    private final void zza(JSONObject jSONObject, boolean z) {
        try {
            JSONObject zza = zza(jSONObject);
            ArrayList arrayList = new ArrayList(this.zzavt);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((zzgh) obj).zzb(zza, z);
            }
        } catch (Throwable th) {
            zzafx.zzb("Skipping active view message.", th);
        }
    }

    private final void zzfs() {
        if (this.zzavl != null) {
            this.zzavl.zza(this);
        }
    }

    private final void zzfu() {
        ViewTreeObserver viewTreeObserver = this.zzave.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this);
        viewTreeObserver.removeGlobalOnLayoutListener(this);
    }

    private final JSONObject zzfv() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject put = jSONObject.put("afmaVersion", this.zzavg.zzfl()).put("activeViewJSON", this.zzavg.zzfm()).put("timestamp", com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime()).put("adFormat", this.zzavg.zzfk()).put("hashCode", this.zzavg.zzfn()).put("isMraid", this.zzavg.zzfo()).put("isStopped", this.zzavn).put("isPaused", this.zzark).put("isNative", this.zzavg.zzfp()).put("isScreenOn", isScreenOn());
        com.google.android.gms.ads.internal.zzbv.zzea();
        JSONObject put2 = put.put("appMuted", zzahf.zzdg());
        com.google.android.gms.ads.internal.zzbv.zzea();
        put2.put("appVolume", zzahf.zzde()).put("deviceVolume", this.zzavw);
        return jSONObject;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzj(2);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzj(1);
    }

    public final void pause() {
        synchronized (this.mLock) {
            this.zzark = true;
            zzj(3);
        }
    }

    public final void resume() {
        synchronized (this.mLock) {
            this.zzark = false;
            zzj(3);
        }
    }

    public final void stop() {
        synchronized (this.mLock) {
            this.zzavn = true;
            zzj(3);
        }
    }

    public final void zza(zzft zzftVar) {
        synchronized (this.mLock) {
            this.zzavl = zzftVar;
        }
    }

    public final void zza(zzgh zzghVar) {
        if (this.zzavt.isEmpty()) {
            synchronized (this.mLock) {
                if (this.zzavr == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    this.zzavr = new zzfn(this);
                    this.mApplicationContext.registerReceiver(this.zzavr, intentFilter);
                }
            }
            zzj(3);
        }
        this.zzavt.add(zzghVar);
        try {
            zzghVar.zzb(zza(zza(this.zzavf.zzfw(), (Boolean) null)), false);
        } catch (JSONException e) {
            zzafx.zzb("Skipping measurement update for new client.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzgh zzghVar, Map<String, String> map) {
        String valueOf = String.valueOf(this.zzavg.zzfn());
        zzafx.zzcb(valueOf.length() != 0 ? "Received request to untrack: ".concat(valueOf) : new String("Received request to untrack: "));
        zzb(zzghVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzakk zzakkVar, Map<String, String> map) {
        if (zzakkVar == null) {
            throw null;
        }
        zzj(3);
    }

    public final void zzb(zzgh zzghVar) {
        this.zzavt.remove(zzghVar);
        zzghVar.zzga();
        if (this.zzavt.isEmpty()) {
            synchronized (this.mLock) {
                zzfu();
                synchronized (this.mLock) {
                    if (this.zzavr != null) {
                        try {
                            try {
                                this.mApplicationContext.unregisterReceiver(this.zzavr);
                            } catch (IllegalStateException e) {
                                zzafx.zzb("Failed trying to unregister the receiver", e);
                            }
                        } catch (Exception e2) {
                            com.google.android.gms.ads.internal.zzbv.zzee().zza(e2, "ActiveViewUnit.stopScreenStatusMonitoring");
                        }
                        this.zzavr = null;
                    }
                }
                this.mApplicationContext.getContentResolver().unregisterContentObserver(this.zzavv);
                this.zzavo = false;
                zzfs();
                ArrayList arrayList = new ArrayList(this.zzavt);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zzb((zzgh) obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzavg.zzfn());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(Map<String, String> map) {
        if (map.containsKey("isVisible")) {
            if (!AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("isVisible"))) {
                ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(map.get("isVisible"));
            }
            Iterator<Object> it = this.zzavs.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void zzfq() {
        com.google.android.gms.ads.internal.zzbv.zzea();
        this.zzavw = zzahf.zzap(this.mApplicationContext);
    }

    public final void zzfr() {
        synchronized (this.mLock) {
            if (this.zzavo) {
                this.zzavp = true;
                try {
                    JSONObject zzfv = zzfv();
                    zzfv.put("doneReasonCode", "u");
                    zza(zzfv, true);
                } catch (RuntimeException e) {
                    zzafx.zzb("Failure while processing active view data.", e);
                } catch (JSONException e2) {
                    zzafx.zzb("JSON failure while processing active view data.", e2);
                }
                String valueOf = String.valueOf(this.zzavg.zzfn());
                zzafx.zzcb(valueOf.length() != 0 ? "Untracking ad unit: ".concat(valueOf) : new String("Untracking ad unit: "));
            }
        }
    }

    public final boolean zzft() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzavo;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzj(int i) {
        boolean z;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        synchronized (this.mLock) {
            Iterator<zzgh> it = this.zzavt.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().zzfz()) {
                    z = true;
                    break;
                }
            }
            if (z && this.zzavo) {
                View zzfw = this.zzavf.zzfw();
                boolean z2 = zzfw != null && com.google.android.gms.ads.internal.zzbv.zzea().zza(zzfw, this.zzavi, this.zzavj);
                boolean z3 = zzfw != null && z2 && zzfw.getGlobalVisibleRect(new Rect(), null);
                if (this.zzavf.zzfx()) {
                    zzfr();
                } else if (i == 1 && !this.zzaun.tryAcquire() && z3 == this.zzavq) {
                } else {
                    if (z3 || this.zzavq || i != 1) {
                        try {
                            zza(zza(zzfw, Boolean.valueOf(z2)), false);
                            this.zzavq = z3;
                        } catch (RuntimeException | JSONException e) {
                            zzafx.zza("Active view update failed.", e);
                        }
                        View zzfw2 = this.zzavf.zzfy().zzfw();
                        if (zzfw2 != null && (viewTreeObserver2 = zzfw2.getViewTreeObserver()) != (viewTreeObserver = this.zzave.get())) {
                            zzfu();
                            if (!this.zzavm || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                                this.zzavm = true;
                                viewTreeObserver2.addOnScrollChangedListener(this);
                                viewTreeObserver2.addOnGlobalLayoutListener(this);
                            }
                            this.zzave = new WeakReference<>(viewTreeObserver2);
                        }
                        zzfs();
                    }
                }
            }
        }
    }
}
