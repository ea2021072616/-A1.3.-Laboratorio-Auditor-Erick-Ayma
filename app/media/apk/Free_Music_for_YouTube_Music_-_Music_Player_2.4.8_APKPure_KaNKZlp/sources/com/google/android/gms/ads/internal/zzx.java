package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzaey;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzakt;
import com.google.android.gms.internal.zzakw;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzvp;
import com.google.android.gms.internal.zzzt;
import java.lang.ref.WeakReference;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzx extends zzi implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private boolean zzalt;
    private WeakReference<Object> zzanw;

    public zzx(Context context, zzjb zzjbVar, String str, zzva zzvaVar, zzajk zzajkVar, zzv zzvVar) {
        super(context, zzjbVar, str, zzvaVar, zzajkVar, zzvVar);
        this.zzanw = new WeakReference<>(null);
    }

    private final boolean zzd(@Nullable zzafi zzafiVar, zzafi zzafiVar2) {
        if (zzafiVar2.zzcpo) {
            View zzd = zzas.zzd(zzafiVar2);
            if (zzd == null) {
                zzafx.zzcs("Could not get mediation view");
                return false;
            }
            View nextView = this.zzams.zzatk.getNextView();
            if (nextView != null) {
                if (nextView instanceof zzakk) {
                    ((zzakk) nextView).destroy();
                }
                this.zzams.zzatk.removeView(nextView);
            }
            if (!zzas.zze(zzafiVar2)) {
                try {
                    if (zzbv.zzez().zzs(this.zzams.zzaie)) {
                        new zzgi(this.zzams.zzaie, zzd).zza(new zzaey(this.zzams.zzaie, this.zzams.zzath));
                    }
                    zzb(zzd);
                } catch (Exception e) {
                    zzbv.zzee().zza(e, "BannerAdManager.swapViews");
                    zzafx.zzc("Could not add mediation view to view hierarchy.", e);
                    return false;
                }
            }
        } else if (zzafiVar2.zzcyg != null && zzafiVar2.zzcgz != null) {
            zzafiVar2.zzcgz.zza(zzafiVar2.zzcyg);
            this.zzams.zzatk.removeAllViews();
            this.zzams.zzatk.setMinimumWidth(zzafiVar2.zzcyg.widthPixels);
            this.zzams.zzatk.setMinimumHeight(zzafiVar2.zzcyg.heightPixels);
            zzakk zzakkVar = zzafiVar2.zzcgz;
            if (zzakkVar == null) {
                throw null;
            }
            zzb((View) zzakkVar);
        }
        if (this.zzams.zzatk.getChildCount() > 1) {
            this.zzams.zzatk.showNext();
        }
        if (zzafiVar != null) {
            View nextView2 = this.zzams.zzatk.getNextView();
            if (nextView2 instanceof zzakk) {
                ((zzakk) nextView2).zza(this.zzams.zzaie, this.zzams.zzatn, this.zzamn);
            } else if (nextView2 != null) {
                this.zzams.zzatk.removeView(nextView2);
            }
            this.zzams.zzfc();
        }
        this.zzams.zzatk.setVisibility(0);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    @Nullable
    public final zzky getVideoController() {
        com.google.android.gms.common.internal.zzbp.zzfx("getVideoController must be called from the main thread.");
        if (this.zzams.zzato == null || this.zzams.zzato.zzcgz == null) {
            return null;
        }
        return this.zzams.zzato.zzcgz.zzsm();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzc(this.zzams.zzato);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzc(this.zzams.zzato);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void setManualImpressionsEnabled(boolean z) {
        com.google.android.gms.common.internal.zzbp.zzfx("setManualImpressionsEnabled must be called from the main thread.");
        this.zzalt = z;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzkf
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzi
    public final zzakk zza(zzafj zzafjVar, @Nullable zzw zzwVar, @Nullable zzaev zzaevVar) throws zzakw {
        AdSize zzhn;
        zzjb zzjbVar;
        if (this.zzams.zzatn.zzbcs == null && this.zzams.zzatn.zzbcu) {
            zzbw zzbwVar = this.zzams;
            if (zzafjVar.zzcyp.zzbcu) {
                zzjbVar = this.zzams.zzatn;
            } else {
                String str = zzafjVar.zzcyp.zzcpr;
                if (str != null) {
                    String[] split = str.split("[xX]");
                    split[0] = split[0].trim();
                    split[1] = split[1].trim();
                    zzhn = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                } else {
                    zzhn = this.zzams.zzatn.zzhn();
                }
                zzjbVar = new zzjb(this.zzams.zzaie, zzhn);
            }
            zzbwVar.zzatn = zzjbVar;
        }
        return super.zza(zzafjVar, zzwVar, zzaevVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzd
    public final void zza(@Nullable zzafi zzafiVar, boolean z) {
        View view;
        super.zza(zzafiVar, z);
        if (zzas.zze(zzafiVar)) {
            zzab zzabVar = new zzab(this);
            if (zzafiVar == null || !zzas.zze(zzafiVar)) {
                return;
            }
            zzakk zzakkVar = zzafiVar.zzcgz;
            if (zzakkVar == null) {
                view = null;
            } else if (zzakkVar == null) {
                throw null;
            } else {
                view = (View) zzakkVar;
            }
            if (view == null) {
                zzafx.zzcs("AdWebView is null");
                return;
            }
            try {
                List<String> list = zzafiVar.zzcca != null ? zzafiVar.zzcca.zzcap : null;
                if (list == null || list.isEmpty()) {
                    zzafx.zzcs("No template ids present in mediation response");
                    return;
                }
                zzvm zzls = zzafiVar.zzccb != null ? zzafiVar.zzccb.zzls() : null;
                zzvp zzlt = zzafiVar.zzccb != null ? zzafiVar.zzccb.zzlt() : null;
                if (list.contains("2") && zzls != null) {
                    zzls.zzm(com.google.android.gms.dynamic.zzn.zzw(view));
                    if (!zzls.getOverrideImpressionRecording()) {
                        zzls.recordImpression();
                    }
                    zzakkVar.zzsb().zza("/nativeExpressViewClicked", zzas.zza(zzls, (zzvp) null, zzabVar));
                } else if (!list.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES) || zzlt == null) {
                    zzafx.zzcs("No matching template id and mapper");
                } else {
                    zzlt.zzm(com.google.android.gms.dynamic.zzn.zzw(view));
                    if (!zzlt.getOverrideImpressionRecording()) {
                        zzlt.recordImpression();
                    }
                    zzakkVar.zzsb().zza("/nativeExpressViewClicked", zzas.zza((zzvm) null, zzlt, zzabVar));
                }
            } catch (RemoteException e) {
                zzafx.zzc("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b7, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(com.google.android.gms.internal.zzmu.zzbmp)).booleanValue() != false) goto L62;
     */
    @Override // com.google.android.gms.ads.internal.zzi, com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(@android.support.annotation.Nullable com.google.android.gms.internal.zzafi r5, com.google.android.gms.internal.zzafi r6) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzx.zza(com.google.android.gms.internal.zzafi, com.google.android.gms.internal.zzafi):boolean");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final boolean zzb(zzix zzixVar) {
        if (zzixVar.zzbbq != this.zzalt) {
            zzixVar = new zzix(zzixVar.versionCode, zzixVar.zzbbl, zzixVar.extras, zzixVar.zzbbm, zzixVar.zzbbn, zzixVar.zzbbo, zzixVar.zzbbp, zzixVar.zzbbq || this.zzalt, zzixVar.zzbbr, zzixVar.zzbbs, zzixVar.zzbbt, zzixVar.zzbbu, zzixVar.zzbbv, zzixVar.zzbbw, zzixVar.zzbbx, zzixVar.zzbby, zzixVar.zzbbz, zzixVar.zzbca);
        }
        return super.zzb(zzixVar);
    }

    @Override // com.google.android.gms.ads.internal.zzd
    protected final boolean zzby() {
        boolean z = true;
        zzbv.zzea();
        if (!zzahf.zzc(this.zzams.zzaie, this.zzams.zzaie.getPackageName(), "android.permission.INTERNET")) {
            zzjo.zzhu().zza(this.zzams.zzatk, this.zzams.zzatn, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        zzbv.zzea();
        if (!zzahf.zzag(this.zzams.zzaie)) {
            zzjo.zzhu().zza(this.zzams.zzatk, this.zzams.zzatn, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzams.zzatk != null) {
            this.zzams.zzatk.setVisibility(0);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(@Nullable zzafi zzafiVar) {
        if (zzafiVar == null || zzafiVar.zzcyd || this.zzams.zzatk == null || !zzbv.zzea().zza(this.zzams.zzatk, this.zzams.zzaie) || !this.zzams.zzatk.getGlobalVisibleRect(new Rect(), null)) {
            return;
        }
        if (zzafiVar != null && zzafiVar.zzcgz != null && zzafiVar.zzcgz.zzsb() != null) {
            zzafiVar.zzcgz.zzsb().zza((zzakt) null);
        }
        zza(zzafiVar, false);
        zzafiVar.zzcyd = true;
    }
}
