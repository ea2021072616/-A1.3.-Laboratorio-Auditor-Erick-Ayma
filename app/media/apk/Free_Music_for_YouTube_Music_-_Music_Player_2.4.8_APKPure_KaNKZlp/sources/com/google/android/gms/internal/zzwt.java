package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.ads.AdSize;
import java.util.Map;
import java.util.Set;
@zzzt
/* loaded from: classes.dex */
public final class zzwt extends zzxd {
    private static Set<String> zzcdr = com.google.android.gms.common.util.zze.zzb("top-left", "top-right", "top-center", TtmlNode.CENTER, "bottom-left", "bottom-right", "bottom-center");
    private final Object mLock;
    private int zzakv;
    private int zzakw;
    private zzjb zzaro;
    private final zzakk zzbvz;
    private final Activity zzcdi;
    private String zzcds;
    private boolean zzcdt;
    private int zzcdu;
    private int zzcdv;
    private int zzcdw;
    private int zzcdx;
    private ImageView zzcdy;
    private LinearLayout zzcdz;
    private zzxe zzcea;
    private PopupWindow zzceb;
    private RelativeLayout zzcec;
    private ViewGroup zzced;

    public zzwt(zzakk zzakkVar, zzxe zzxeVar) {
        super(zzakkVar, "resize");
        this.zzcds = "top-right";
        this.zzcdt = true;
        this.zzcdu = 0;
        this.zzcdv = 0;
        this.zzakw = -1;
        this.zzcdw = 0;
        this.zzcdx = 0;
        this.zzakv = -1;
        this.mLock = new Object();
        this.zzbvz = zzakkVar;
        this.zzcdi = zzakkVar.zzrx();
        this.zzcea = zzxeVar;
    }

    private final void zza(int i, int i2) {
        zzb(i, i2 - com.google.android.gms.ads.internal.zzbv.zzea().zzh(this.zzcdi)[0], this.zzakv, this.zzakw);
    }

    private final int[] zzme() {
        boolean z;
        int i;
        int i2;
        int[] zzg = com.google.android.gms.ads.internal.zzbv.zzea().zzg(this.zzcdi);
        int[] zzh = com.google.android.gms.ads.internal.zzbv.zzea().zzh(this.zzcdi);
        int i3 = zzg[0];
        int i4 = zzg[1];
        if (this.zzakv < 50 || this.zzakv > i3) {
            zzafx.zzcs("Width is too small or too large.");
            z = false;
        } else if (this.zzakw < 50 || this.zzakw > i4) {
            zzafx.zzcs("Height is too small or too large.");
            z = false;
        } else if (this.zzakw == i4 && this.zzakv == i3) {
            zzafx.zzcs("Cannot resize to a full-screen ad.");
            z = false;
        } else {
            if (this.zzcdt) {
                String str = this.zzcds;
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals(TtmlNode.CENTER)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        i = this.zzcdw + this.zzcdu;
                        i2 = this.zzcdv + this.zzcdx;
                        break;
                    case 1:
                        i = ((this.zzcdu + this.zzcdw) + (this.zzakv / 2)) - 25;
                        i2 = this.zzcdv + this.zzcdx;
                        break;
                    case 2:
                        i = ((this.zzcdu + this.zzcdw) + (this.zzakv / 2)) - 25;
                        i2 = ((this.zzcdv + this.zzcdx) + (this.zzakw / 2)) - 25;
                        break;
                    case 3:
                        i = this.zzcdw + this.zzcdu;
                        i2 = ((this.zzcdv + this.zzcdx) + this.zzakw) - 50;
                        break;
                    case 4:
                        i = ((this.zzcdu + this.zzcdw) + (this.zzakv / 2)) - 25;
                        i2 = ((this.zzcdv + this.zzcdx) + this.zzakw) - 50;
                        break;
                    case 5:
                        i = ((this.zzcdu + this.zzcdw) + this.zzakv) - 50;
                        i2 = ((this.zzcdv + this.zzcdx) + this.zzakw) - 50;
                        break;
                    default:
                        i = ((this.zzcdu + this.zzcdw) + this.zzakv) - 50;
                        i2 = this.zzcdv + this.zzcdx;
                        break;
                }
                if (i < 0 || i + 50 > i3 || i2 < zzh[0] || i2 + 50 > zzh[1]) {
                    z = false;
                }
            }
            z = true;
        }
        if (z) {
            if (this.zzcdt) {
                return new int[]{this.zzcdu + this.zzcdw, this.zzcdv + this.zzcdx};
            }
            int[] zzg2 = com.google.android.gms.ads.internal.zzbv.zzea().zzg(this.zzcdi);
            int[] zzh2 = com.google.android.gms.ads.internal.zzbv.zzea().zzh(this.zzcdi);
            int i5 = zzg2[0];
            int i6 = this.zzcdu + this.zzcdw;
            int i7 = this.zzcdv + this.zzcdx;
            if (i6 < 0) {
                i6 = 0;
            } else if (this.zzakv + i6 > i5) {
                i6 = i5 - this.zzakv;
            }
            if (i7 < zzh2[0]) {
                i7 = zzh2[0];
            } else if (this.zzakw + i7 > zzh2[1]) {
                i7 = zzh2[1] - this.zzakw;
            }
            return new int[]{i6, i7};
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void execute(Map<String, String> map) {
        char c2;
        synchronized (this.mLock) {
            if (this.zzcdi == null) {
                zzbn("Not an activity context. Cannot resize.");
            } else if (this.zzbvz.zzbl() == null) {
                zzbn("Webview is not yet available, size is not set.");
            } else if (this.zzbvz.zzbl().zzbcr) {
                zzbn("Is interstitial. Cannot resize an interstitial.");
            } else if (this.zzbvz.zzsf()) {
                zzbn("Cannot resize an expanded banner.");
            } else {
                if (!TextUtils.isEmpty(map.get("width"))) {
                    com.google.android.gms.ads.internal.zzbv.zzea();
                    this.zzakv = zzahf.zzci(map.get("width"));
                }
                if (!TextUtils.isEmpty(map.get("height"))) {
                    com.google.android.gms.ads.internal.zzbv.zzea();
                    this.zzakw = zzahf.zzci(map.get("height"));
                }
                if (!TextUtils.isEmpty(map.get("offsetX"))) {
                    com.google.android.gms.ads.internal.zzbv.zzea();
                    this.zzcdw = zzahf.zzci(map.get("offsetX"));
                }
                if (!TextUtils.isEmpty(map.get("offsetY"))) {
                    com.google.android.gms.ads.internal.zzbv.zzea();
                    this.zzcdx = zzahf.zzci(map.get("offsetY"));
                }
                if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
                    this.zzcdt = Boolean.parseBoolean(map.get("allowOffscreen"));
                }
                String str = map.get("customClosePosition");
                if (!TextUtils.isEmpty(str)) {
                    this.zzcds = str;
                }
                if (!(this.zzakv >= 0 && this.zzakw >= 0)) {
                    zzbn("Invalid width and height options. Cannot resize.");
                    return;
                }
                Window window = this.zzcdi.getWindow();
                if (window == null || window.getDecorView() == null) {
                    zzbn("Activity context is not ready, cannot get window or decor view.");
                    return;
                }
                int[] zzme = zzme();
                if (zzme == null) {
                    zzbn("Resize location out of screen or close button is not visible.");
                    return;
                }
                zzjo.zzhu();
                int zzc = zzaje.zzc(this.zzcdi, this.zzakv);
                zzjo.zzhu();
                int zzc2 = zzaje.zzc(this.zzcdi, this.zzakw);
                zzakk zzakkVar = this.zzbvz;
                if (zzakkVar == null) {
                    throw null;
                }
                ViewParent parent = ((View) zzakkVar).getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    zzbn("Webview is detached, probably in the middle of a resize or expand.");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                zzakk zzakkVar2 = this.zzbvz;
                if (zzakkVar2 == null) {
                    throw null;
                }
                viewGroup.removeView((View) zzakkVar2);
                if (this.zzceb == null) {
                    this.zzced = (ViewGroup) parent;
                    com.google.android.gms.ads.internal.zzbv.zzea();
                    zzakk zzakkVar3 = this.zzbvz;
                    if (zzakkVar3 == null) {
                        throw null;
                    }
                    Bitmap zzl = zzahf.zzl((View) zzakkVar3);
                    this.zzcdy = new ImageView(this.zzcdi);
                    this.zzcdy.setImageBitmap(zzl);
                    this.zzaro = this.zzbvz.zzbl();
                    this.zzced.addView(this.zzcdy);
                } else {
                    this.zzceb.dismiss();
                }
                this.zzcec = new RelativeLayout(this.zzcdi);
                this.zzcec.setBackgroundColor(0);
                this.zzcec.setLayoutParams(new ViewGroup.LayoutParams(zzc, zzc2));
                com.google.android.gms.ads.internal.zzbv.zzea();
                this.zzceb = zzahf.zza((View) this.zzcec, zzc, zzc2, false);
                this.zzceb.setOutsideTouchable(true);
                this.zzceb.setTouchable(true);
                this.zzceb.setClippingEnabled(!this.zzcdt);
                RelativeLayout relativeLayout = this.zzcec;
                zzakk zzakkVar4 = this.zzbvz;
                if (zzakkVar4 == null) {
                    throw null;
                }
                relativeLayout.addView((View) zzakkVar4, -1, -1);
                this.zzcdz = new LinearLayout(this.zzcdi);
                zzjo.zzhu();
                int zzc3 = zzaje.zzc(this.zzcdi, 50);
                zzjo.zzhu();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(zzc3, zzaje.zzc(this.zzcdi, 50));
                String str2 = this.zzcds;
                switch (str2.hashCode()) {
                    case -1364013995:
                        if (str2.equals(TtmlNode.CENTER)) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1012429441:
                        if (str2.equals("top-left")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -655373719:
                        if (str2.equals("bottom-left")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1163912186:
                        if (str2.equals("bottom-right")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1288627767:
                        if (str2.equals("bottom-center")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1755462605:
                        if (str2.equals("top-center")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                        break;
                    case 1:
                        layoutParams.addRule(10);
                        layoutParams.addRule(14);
                        break;
                    case 2:
                        layoutParams.addRule(13);
                        break;
                    case 3:
                        layoutParams.addRule(12);
                        layoutParams.addRule(9);
                        break;
                    case 4:
                        layoutParams.addRule(12);
                        layoutParams.addRule(14);
                        break;
                    case 5:
                        layoutParams.addRule(12);
                        layoutParams.addRule(11);
                        break;
                    default:
                        layoutParams.addRule(10);
                        layoutParams.addRule(11);
                        break;
                }
                this.zzcdz.setOnClickListener(new zzwu(this));
                this.zzcdz.setContentDescription("Close button");
                this.zzcec.addView(this.zzcdz, layoutParams);
                try {
                    PopupWindow popupWindow = this.zzceb;
                    View decorView = window.getDecorView();
                    zzjo.zzhu();
                    int zzc4 = zzaje.zzc(this.zzcdi, zzme[0]);
                    zzjo.zzhu();
                    popupWindow.showAtLocation(decorView, 0, zzc4, zzaje.zzc(this.zzcdi, zzme[1]));
                    int i = zzme[0];
                    int i2 = zzme[1];
                    if (this.zzcea != null) {
                        this.zzcea.zza(i, i2, this.zzakv, this.zzakw);
                    }
                    this.zzbvz.zza(new zzjb(this.zzcdi, new AdSize(this.zzakv, this.zzakw)));
                    zza(zzme[0], zzme[1]);
                    zzbp("resized");
                } catch (RuntimeException e) {
                    String valueOf = String.valueOf(e.getMessage());
                    zzbn(valueOf.length() != 0 ? "Cannot show popup window: ".concat(valueOf) : new String("Cannot show popup window: "));
                    RelativeLayout relativeLayout2 = this.zzcec;
                    zzakk zzakkVar5 = this.zzbvz;
                    if (zzakkVar5 == null) {
                        throw null;
                    }
                    relativeLayout2.removeView((View) zzakkVar5);
                    if (this.zzced != null) {
                        this.zzced.removeView(this.zzcdy);
                        ViewGroup viewGroup2 = this.zzced;
                        zzakk zzakkVar6 = this.zzbvz;
                        if (zzakkVar6 == null) {
                            throw null;
                        }
                        viewGroup2.addView((View) zzakkVar6);
                        this.zzbvz.zza(this.zzaro);
                    }
                }
            }
        }
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.mLock) {
            this.zzcdu = i;
            this.zzcdv = i2;
            if (this.zzceb != null && z) {
                int[] zzme = zzme();
                if (zzme != null) {
                    PopupWindow popupWindow = this.zzceb;
                    zzjo.zzhu();
                    int zzc = zzaje.zzc(this.zzcdi, zzme[0]);
                    zzjo.zzhu();
                    popupWindow.update(zzc, zzaje.zzc(this.zzcdi, zzme[1]), this.zzceb.getWidth(), this.zzceb.getHeight());
                    zza(zzme[0], zzme[1]);
                } else {
                    zzl(true);
                }
            }
        }
    }

    public final void zzb(int i, int i2) {
        this.zzcdu = i;
        this.zzcdv = i2;
    }

    public final void zzl(boolean z) {
        synchronized (this.mLock) {
            if (this.zzceb != null) {
                this.zzceb.dismiss();
                RelativeLayout relativeLayout = this.zzcec;
                zzakk zzakkVar = this.zzbvz;
                if (zzakkVar == null) {
                    throw null;
                }
                relativeLayout.removeView((View) zzakkVar);
                if (this.zzced != null) {
                    this.zzced.removeView(this.zzcdy);
                    ViewGroup viewGroup = this.zzced;
                    zzakk zzakkVar2 = this.zzbvz;
                    if (zzakkVar2 == null) {
                        throw null;
                    }
                    viewGroup.addView((View) zzakkVar2);
                    this.zzbvz.zza(this.zzaro);
                }
                if (z) {
                    zzbp("default");
                    if (this.zzcea != null) {
                        this.zzcea.zzcm();
                    }
                }
                this.zzceb = null;
                this.zzcec = null;
                this.zzced = null;
                this.zzcdz = null;
            }
        }
    }

    public final boolean zzmf() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzceb != null;
        }
        return z;
    }
}
