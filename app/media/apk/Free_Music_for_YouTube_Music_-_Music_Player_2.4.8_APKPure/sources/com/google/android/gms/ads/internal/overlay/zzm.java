package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzahk;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzxh;
import com.google.android.gms.internal.zzzt;
import java.util.Collections;
@zzzt
/* loaded from: classes.dex */
public final class zzm extends zzxh implements zzaj {
    private static int zzcfy = Color.argb(0, 0, 0, 0);
    private final Activity mActivity;
    private zzakk zzbvz;
    AdOverlayInfoParcel zzcfz;
    private zzr zzcga;
    private zzae zzcgb;
    private FrameLayout zzcgd;
    private WebChromeClient.CustomViewCallback zzcge;
    private zzq zzcgh;
    private Runnable zzcgl;
    private boolean zzcgm;
    private boolean zzcgn;
    private boolean zzcgc = false;
    private boolean zzcgf = false;
    private boolean zzcgg = false;
    private boolean zzcgi = false;
    private int zzcgj = 0;
    private final Object zzcgk = new Object();
    private boolean zzcgo = false;
    private boolean zzcgp = false;
    private boolean zzcgq = true;

    public zzm(Activity activity) {
        this.mActivity = activity;
    }

    private final void zzmp() {
        if (!this.mActivity.isFinishing() || this.zzcgo) {
            return;
        }
        this.zzcgo = true;
        if (this.zzbvz != null) {
            this.zzbvz.zzae(this.zzcgj);
            synchronized (this.zzcgk) {
                if (!this.zzcgm && this.zzbvz.zzsn()) {
                    this.zzcgl = new zzo(this);
                    zzahf.zzdbo.postDelayed(this.zzcgl, ((Long) zzbv.zzen().zzd(zzmu.zzbju)).longValue());
                    return;
                }
            }
        }
        zzmq();
    }

    private final void zzms() {
        this.zzbvz.zzms();
    }

    private final void zzs(boolean z) {
        int intValue = ((Integer) zzbv.zzen().zzd(zzmu.zzbpg)).intValue();
        zzaf zzafVar = new zzaf();
        zzafVar.size = 50;
        zzafVar.paddingLeft = z ? intValue : 0;
        zzafVar.paddingRight = z ? 0 : intValue;
        zzafVar.paddingTop = 0;
        zzafVar.paddingBottom = intValue;
        this.zzcgb = new zzae(this.mActivity, zzafVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.zzcgb.zza(z, this.zzcfz.zzchc);
        this.zzcgh.addView(this.zzcgb, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0220  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzt(boolean r16) throws com.google.android.gms.ads.internal.overlay.zzp {
        /*
            Method dump skipped, instructions count: 579
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzt(boolean):void");
    }

    public final void close() {
        this.zzcgj = 2;
        this.mActivity.finish();
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onBackPressed() {
        this.zzcgj = 0;
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onCreate(Bundle bundle) {
        this.mActivity.requestWindowFeature(1);
        this.zzcgf = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.zzcfz = AdOverlayInfoParcel.zzb(this.mActivity.getIntent());
            if (this.zzcfz == null) {
                throw new zzp("Could not get info for ad overlay.");
            }
            if (this.zzcfz.zzatj.zzdem > 7500000) {
                this.zzcgj = 3;
            }
            if (this.mActivity.getIntent() != null) {
                this.zzcgq = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zzcfz.zzchh != null) {
                this.zzcgg = this.zzcfz.zzchh.zzapy;
            } else {
                this.zzcgg = false;
            }
            if (((Boolean) zzbv.zzen().zzd(zzmu.zzbmi)).booleanValue() && this.zzcgg && this.zzcfz.zzchh.zzaqd != -1) {
                new zzs(this, null).zzqq();
            }
            if (bundle == null) {
                if (this.zzcfz.zzcgy != null && this.zzcgq) {
                    this.zzcfz.zzcgy.zzca();
                }
                if (this.zzcfz.zzchf != 1 && this.zzcfz.zzcgx != null) {
                    this.zzcfz.zzcgx.onAdClicked();
                }
            }
            this.zzcgh = new zzq(this.mActivity, this.zzcfz.zzchg, this.zzcfz.zzatj.zzcp);
            this.zzcgh.setId(1000);
            switch (this.zzcfz.zzchf) {
                case 1:
                    zzt(false);
                    return;
                case 2:
                    this.zzcga = new zzr(this.zzcfz.zzcgz);
                    zzt(false);
                    return;
                case 3:
                    zzt(true);
                    return;
                case 4:
                    if (this.zzcgf) {
                        this.zzcgj = 3;
                        this.mActivity.finish();
                        return;
                    }
                    zzbv.zzdx();
                    if (zza.zza(this.mActivity, this.zzcfz.zzcgw, this.zzcfz.zzche)) {
                        return;
                    }
                    this.zzcgj = 3;
                    this.mActivity.finish();
                    return;
                default:
                    throw new zzp("Could not determine ad overlay type.");
            }
        } catch (zzp e) {
            zzafx.zzcs(e.getMessage());
            this.zzcgj = 3;
            this.mActivity.finish();
        }
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onDestroy() {
        if (this.zzbvz != null) {
            zzq zzqVar = this.zzcgh;
            zzakk zzakkVar = this.zzbvz;
            if (zzakkVar == null) {
                throw null;
            }
            zzqVar.removeView((View) zzakkVar);
        }
        zzmp();
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onPause() {
        zzml();
        if (this.zzcfz.zzcgy != null) {
            this.zzcfz.zzcgy.onPause();
        }
        if (!((Boolean) zzbv.zzen().zzd(zzmu.zzbpf)).booleanValue() && this.zzbvz != null && (!this.mActivity.isFinishing() || this.zzcga == null)) {
            zzbv.zzec();
            zzahk.zzk(this.zzbvz);
        }
        zzmp();
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onRestart() {
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onResume() {
        if (this.zzcfz != null && this.zzcfz.zzchf == 4) {
            if (this.zzcgf) {
                this.zzcgj = 3;
                this.mActivity.finish();
            } else {
                this.zzcgf = true;
            }
        }
        if (this.zzcfz.zzcgy != null) {
            this.zzcfz.zzcgy.onResume();
        }
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbpf)).booleanValue()) {
            return;
        }
        if (this.zzbvz == null || this.zzbvz.isDestroyed()) {
            zzafx.zzcs("The webview does not exist. Ignoring action.");
            return;
        }
        zzbv.zzec();
        zzahk.zzl(this.zzbvz);
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzcgf);
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onStart() {
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbpf)).booleanValue()) {
            if (this.zzbvz == null || this.zzbvz.isDestroyed()) {
                zzafx.zzcs("The webview does not exist. Ignoring action.");
                return;
            }
            zzbv.zzec();
            zzahk.zzl(this.zzbvz);
        }
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onStop() {
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbpf)).booleanValue() && this.zzbvz != null && (!this.mActivity.isFinishing() || this.zzcga == null)) {
            zzbv.zzec();
            zzahk.zzk(this.zzbvz);
        }
        zzmp();
    }

    public final void setRequestedOrientation(int i) {
        this.mActivity.setRequestedOrientation(i);
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzcgd = new FrameLayout(this.mActivity);
        this.zzcgd.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzcgd.addView(view, -1, -1);
        this.mActivity.setContentView(this.zzcgd);
        this.zzcgn = true;
        this.zzcge = customViewCallback;
        this.zzcgc = true;
    }

    public final void zza(boolean z, boolean z2) {
        if (this.zzcgb != null) {
            this.zzcgb.zza(z, z2);
        }
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void zzay() {
        this.zzcgn = true;
    }

    public final void zzml() {
        if (this.zzcfz != null && this.zzcgc) {
            setRequestedOrientation(this.zzcfz.orientation);
        }
        if (this.zzcgd != null) {
            this.mActivity.setContentView(this.zzcgh);
            this.zzcgn = true;
            this.zzcgd.removeAllViews();
            this.zzcgd = null;
        }
        if (this.zzcge != null) {
            this.zzcge.onCustomViewHidden();
            this.zzcge = null;
        }
        this.zzcgc = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzaj
    public final void zzmm() {
        this.zzcgj = 1;
        this.mActivity.finish();
    }

    @Override // com.google.android.gms.internal.zzxg
    public final boolean zzmn() {
        this.zzcgj = 0;
        if (this.zzbvz == null) {
            return true;
        }
        boolean zzsh = this.zzbvz.zzsh();
        if (zzsh) {
            return zzsh;
        }
        this.zzbvz.zza("onbackblocked", Collections.emptyMap());
        return zzsh;
    }

    public final void zzmo() {
        this.zzcgh.removeView(this.zzcgb);
        zzs(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzmq() {
        if (this.zzcgp) {
            return;
        }
        this.zzcgp = true;
        if (this.zzbvz != null) {
            zzq zzqVar = this.zzcgh;
            zzakk zzakkVar = this.zzbvz;
            if (zzakkVar == null) {
                throw null;
            }
            zzqVar.removeView((View) zzakkVar);
            if (this.zzcga != null) {
                this.zzbvz.setContext(this.zzcga.zzaie);
                this.zzbvz.zzab(false);
                ViewGroup viewGroup = this.zzcga.parent;
                zzakk zzakkVar2 = this.zzbvz;
                if (zzakkVar2 == null) {
                    throw null;
                }
                viewGroup.addView((View) zzakkVar2, this.zzcga.index, this.zzcga.zzcgt);
                this.zzcga = null;
            } else if (this.mActivity.getApplicationContext() != null) {
                this.zzbvz.setContext(this.mActivity.getApplicationContext());
            }
            this.zzbvz = null;
        }
        if (this.zzcfz == null || this.zzcfz.zzcgy == null) {
            return;
        }
        this.zzcfz.zzcgy.zzbz();
    }

    public final void zzmr() {
        if (this.zzcgi) {
            this.zzcgi = false;
            zzms();
        }
    }

    public final void zzmt() {
        this.zzcgh.zzcgs = true;
    }

    public final void zzmu() {
        synchronized (this.zzcgk) {
            this.zzcgm = true;
            if (this.zzcgl != null) {
                zzahf.zzdbo.removeCallbacks(this.zzcgl);
                zzahf.zzdbo.post(this.zzcgl);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbpe)).booleanValue() && com.google.android.gms.common.util.zzp.isAtLeastN()) {
            zzbv.zzea();
            if (zzahf.zza(this.mActivity, (Configuration) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper))) {
                this.mActivity.getWindow().addFlags(1024);
                this.mActivity.getWindow().clearFlags(2048);
                return;
            }
            this.mActivity.getWindow().addFlags(2048);
            this.mActivity.getWindow().clearFlags(1024);
        }
    }
}
