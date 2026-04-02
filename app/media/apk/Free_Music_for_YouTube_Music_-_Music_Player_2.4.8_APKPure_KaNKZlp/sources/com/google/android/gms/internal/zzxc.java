package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzxc extends zzxd implements zzrn {
    private final Context mContext;
    private final WindowManager zzavh;
    private DisplayMetrics zzawv;
    private final zzakk zzbvz;
    private final zzmf zzcep;
    private float zzceq;
    private int zzcer;
    private int zzces;
    private int zzcet;
    private int zzceu;
    private int zzcev;
    private int zzcew;
    private int zzcex;

    public zzxc(zzakk zzakkVar, Context context, zzmf zzmfVar) {
        super(zzakkVar);
        this.zzcer = -1;
        this.zzces = -1;
        this.zzceu = -1;
        this.zzcev = -1;
        this.zzcew = -1;
        this.zzcex = -1;
        this.zzbvz = zzakkVar;
        this.mContext = context;
        this.zzcep = zzmfVar;
        this.zzavh = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        this.zzawv = new DisplayMetrics();
        Display defaultDisplay = this.zzavh.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzawv);
        this.zzceq = this.zzawv.density;
        this.zzcet = defaultDisplay.getRotation();
        zzjo.zzhu();
        this.zzcer = zzaje.zzb(this.zzawv, this.zzawv.widthPixels);
        zzjo.zzhu();
        this.zzces = zzaje.zzb(this.zzawv, this.zzawv.heightPixels);
        Activity zzrx = this.zzbvz.zzrx();
        if (zzrx == null || zzrx.getWindow() == null) {
            this.zzceu = this.zzcer;
            this.zzcev = this.zzces;
        } else {
            com.google.android.gms.ads.internal.zzbv.zzea();
            int[] zzf = zzahf.zzf(zzrx);
            zzjo.zzhu();
            this.zzceu = zzaje.zzb(this.zzawv, zzf[0]);
            zzjo.zzhu();
            this.zzcev = zzaje.zzb(this.zzawv, zzf[1]);
        }
        if (this.zzbvz.zzbl().zzbcr) {
            this.zzcew = this.zzcer;
            this.zzcex = this.zzces;
        } else {
            this.zzbvz.measure(0, 0);
        }
        zza(this.zzcer, this.zzces, this.zzceu, this.zzcev, this.zzceq, this.zzcet);
        this.zzbvz.zzb("onDeviceFeaturesReceived", new zzwz(new zzxb().zzn(this.zzcep.zzig()).zzm(this.zzcep.zzih()).zzo(this.zzcep.zzij()).zzp(this.zzcep.zzii()).zzq(true)).toJson());
        int[] iArr = new int[2];
        this.zzbvz.getLocationOnScreen(iArr);
        zzjo.zzhu();
        int zzd = zzaje.zzd(this.mContext, iArr[0]);
        zzjo.zzhu();
        zzc(zzd, zzaje.zzd(this.mContext, iArr[1]));
        if (zzafx.zzad(2)) {
            zzafx.zzcr("Dispatching Ready Event.");
        }
        zzbo(this.zzbvz.zzse().zzcp);
    }

    public final void zzc(int i, int i2) {
        int i3 = this.mContext instanceof Activity ? com.google.android.gms.ads.internal.zzbv.zzea().zzh((Activity) this.mContext)[0] : 0;
        if (this.zzbvz.zzbl() == null || !this.zzbvz.zzbl().zzbcr) {
            zzjo.zzhu();
            this.zzcew = zzaje.zzd(this.mContext, this.zzbvz.getWidth());
            zzjo.zzhu();
            this.zzcex = zzaje.zzd(this.mContext, this.zzbvz.getHeight());
        }
        zzc(i, i2 - i3, this.zzcew, this.zzcex);
        this.zzbvz.zzsb().zzb(i, i2);
    }
}
