package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzaig;
import com.google.android.gms.internal.zzaii;
import com.google.android.gms.internal.zzaij;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzna;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzzt;
import java.util.concurrent.TimeUnit;
@zzzt
/* loaded from: classes.dex */
public final class zzar {
    private final Context mContext;
    private final zzajk zzaqr;
    @Nullable
    private final zznh zzchl;
    private boolean zzchp;
    private final String zzcjq;
    @Nullable
    private final zznf zzcjr;
    private final long[] zzcjt;
    private final String[] zzcju;
    private zzy zzcjz;
    private boolean zzcka;
    private boolean zzckb;
    private final zzaig zzcjs = new zzaij().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzri();
    private boolean zzcjv = false;
    private boolean zzcjw = false;
    private boolean zzcjx = false;
    private boolean zzcjy = false;
    private long zzckc = -1;

    public zzar(Context context, zzajk zzajkVar, String str, @Nullable zznh zznhVar, @Nullable zznf zznfVar) {
        this.mContext = context;
        this.zzaqr = zzajkVar;
        this.zzcjq = str;
        this.zzchl = zznhVar;
        this.zzcjr = zznfVar;
        String str2 = (String) zzbv.zzen().zzd(zzmu.zzbgs);
        if (str2 == null) {
            this.zzcju = new String[0];
            this.zzcjt = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzcju = new String[split.length];
        this.zzcjt = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzcjt[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzafx.zzc("Unable to parse frame hash target time number.", e);
                this.zzcjt[i] = -1;
            }
        }
    }

    public final void onStop() {
        if (!((Boolean) zzbv.zzen().zzd(zzmu.zzbgr)).booleanValue() || this.zzcka) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, this.zzcjq);
        bundle.putString("player", this.zzcjz.zzmg());
        for (zzaii zzaiiVar : this.zzcjs.getBuckets()) {
            String valueOf = String.valueOf("fps_c_");
            String valueOf2 = String.valueOf(zzaiiVar.name);
            bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(zzaiiVar.count));
            String valueOf3 = String.valueOf("fps_p_");
            String valueOf4 = String.valueOf(zzaiiVar.name);
            bundle.putString(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), Double.toString(zzaiiVar.zzdcw));
        }
        for (int i = 0; i < this.zzcjt.length; i++) {
            String str = this.zzcju[i];
            if (str != null) {
                String valueOf5 = String.valueOf(Long.valueOf(this.zzcjt[i]));
                bundle.putString(new StringBuilder(String.valueOf("fh_").length() + String.valueOf(valueOf5).length()).append("fh_").append(valueOf5).toString(), str);
            }
        }
        zzbv.zzea().zza(this.mContext, this.zzaqr.zzcp, "gmob-apps", bundle, true);
        this.zzcka = true;
    }

    public final void zza(zzy zzyVar) {
        zzna.zza(this.zzchl, this.zzcjr, "vpc2");
        this.zzcjv = true;
        if (this.zzchl != null) {
            this.zzchl.zzh("vpn", zzyVar.zzmg());
        }
        this.zzcjz = zzyVar;
    }

    public final void zzb(zzy zzyVar) {
        long j;
        if (this.zzcjx && !this.zzcjy) {
            zzna.zza(this.zzchl, this.zzcjr, "vff2");
            this.zzcjy = true;
        }
        long nanoTime = zzbv.zzeg().nanoTime();
        if (this.zzchp && this.zzckb && this.zzckc != -1) {
            this.zzcjs.zza(TimeUnit.SECONDS.toNanos(1L) / (nanoTime - this.zzckc));
        }
        this.zzckb = this.zzchp;
        this.zzckc = nanoTime;
        long longValue = ((Long) zzbv.zzen().zzd(zzmu.zzbgt)).longValue();
        long currentPosition = zzyVar.getCurrentPosition();
        for (int i = 0; i < this.zzcju.length; i++) {
            if (this.zzcju[i] == null && longValue > Math.abs(currentPosition - this.zzcjt[i])) {
                String[] strArr = this.zzcju;
                Bitmap bitmap = zzyVar.getBitmap(8, 8);
                long j2 = 0;
                long j3 = 63;
                int i2 = 0;
                while (i2 < 8) {
                    int i3 = 0;
                    long j4 = j2;
                    while (true) {
                        j = j3;
                        if (i3 < 8) {
                            int pixel = bitmap.getPixel(i3, i2);
                            j4 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > 128 ? 1L : 0L) << ((int) j);
                            i3++;
                            j3 = j - 1;
                        }
                    }
                    i2++;
                    j3 = j;
                    j2 = j4;
                }
                strArr[i] = String.format("%016X", Long.valueOf(j2));
                return;
            }
        }
    }

    public final void zzmw() {
        if (!this.zzcjv || this.zzcjw) {
            return;
        }
        zzna.zza(this.zzchl, this.zzcjr, "vfr2");
        this.zzcjw = true;
    }

    public final void zznm() {
        this.zzchp = true;
        if (!this.zzcjw || this.zzcjx) {
            return;
        }
        zzna.zza(this.zzchl, this.zzcjr, "vfp2");
        this.zzcjx = true;
    }

    public final void zznn() {
        this.zzchp = false;
    }
}
