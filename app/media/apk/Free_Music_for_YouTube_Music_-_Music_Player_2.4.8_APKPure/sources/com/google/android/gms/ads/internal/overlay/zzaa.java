package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzzt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzaa extends FrameLayout implements zzx {
    private final zzakk zzbvz;
    private String zzbwe;
    private final FrameLayout zzchk;
    private final zznh zzchl;
    private final zzas zzchm;
    private final long zzchn;
    @Nullable
    private zzy zzcho;
    private boolean zzchp;
    private boolean zzchq;
    private boolean zzchr;
    private boolean zzchs;
    private long zzcht;
    private long zzchu;
    private Bitmap zzchv;
    private ImageView zzchw;
    private boolean zzchx;

    public zzaa(Context context, zzakk zzakkVar, int i, boolean z, zznh zznhVar, zzaq zzaqVar) {
        super(context);
        this.zzbvz = zzakkVar;
        this.zzchl = zznhVar;
        this.zzchk = new FrameLayout(context);
        addView(this.zzchk, new FrameLayout.LayoutParams(-1, -1));
        com.google.android.gms.common.internal.zzc.zzr(zzakkVar.zzbj());
        this.zzcho = zzakkVar.zzbj().zzanq.zza(context, zzakkVar, i, z, zznhVar, zzaqVar);
        if (this.zzcho != null) {
            this.zzchk.addView(this.zzcho, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzbv.zzen().zzd(zzmu.zzbgu)).booleanValue()) {
                zzne();
            }
        }
        this.zzchw = new ImageView(context);
        this.zzchn = ((Long) zzbv.zzen().zzd(zzmu.zzbgy)).longValue();
        this.zzchs = ((Boolean) zzbv.zzen().zzd(zzmu.zzbgw)).booleanValue();
        if (this.zzchl != null) {
            this.zzchl.zzh("spinner_used", this.zzchs ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        this.zzchm = new zzas(this);
        if (this.zzcho != null) {
            this.zzcho.zza(this);
        }
        if (this.zzcho == null) {
            zzj("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void zza(zzakk zzakkVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("error", str);
        zzakkVar.zza("onVideoEvent", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
        int length = strArr.length;
        int i = 0;
        String str2 = null;
        while (i < length) {
            String str3 = strArr[i];
            if (str2 != null) {
                hashMap.put(str2, str3);
                str3 = null;
            }
            i++;
            str2 = str3;
        }
        this.zzbvz.zza("onVideoEvent", hashMap);
    }

    public static void zzc(zzakk zzakkVar, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("mimeTypes", map);
        zzakkVar.zza("onVideoEvent", hashMap);
    }

    public static void zzh(zzakk zzakkVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
        zzakkVar.zza("onVideoEvent", hashMap);
    }

    private final boolean zzng() {
        return this.zzchw.getParent() != null;
    }

    private final void zznh() {
        if (this.zzbvz.zzrx() == null || !this.zzchq || this.zzchr) {
            return;
        }
        this.zzbvz.zzrx().getWindow().clearFlags(128);
        this.zzchq = false;
    }

    public final void destroy() {
        this.zzchm.pause();
        if (this.zzcho != null) {
            this.zzcho.stop();
        }
        zznh();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final void onPaused() {
        zza("pause", new String[0]);
        zznh();
        this.zzchp = false;
    }

    public final void pause() {
        if (this.zzcho == null) {
            return;
        }
        this.zzcho.pause();
    }

    public final void play() {
        if (this.zzcho == null) {
            return;
        }
        this.zzcho.play();
    }

    public final void seekTo(int i) {
        if (this.zzcho == null) {
            return;
        }
        this.zzcho.seekTo(i);
    }

    public final void zza(float f, float f2) {
        if (this.zzcho != null) {
            this.zzcho.zza(f, f2);
        }
    }

    public final void zzb(float f) {
        if (this.zzcho == null) {
            return;
        }
        zzy zzyVar = this.zzcho;
        zzyVar.zzchj.zzb(f);
        zzyVar.zzmk();
    }

    public final void zzbq(String str) {
        this.zzbwe = str;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final void zzd(int i, int i2) {
        if (this.zzchs) {
            int max = Math.max(i / ((Integer) zzbv.zzen().zzd(zzmu.zzbgx)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzbv.zzen().zzd(zzmu.zzbgx)).intValue(), 1);
            if (this.zzchv != null && this.zzchv.getWidth() == max && this.zzchv.getHeight() == max2) {
                return;
            }
            this.zzchv = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
            this.zzchx = false;
        }
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.zzchk.setLayoutParams(layoutParams);
        requestLayout();
    }

    @TargetApi(14)
    public final void zze(MotionEvent motionEvent) {
        if (this.zzcho == null) {
            return;
        }
        this.zzcho.dispatchTouchEvent(motionEvent);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final void zzj(String str, @Nullable String str2) {
        zza("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final void zzmv() {
        this.zzchm.resume();
        zzahf.zzdbo.post(new zzab(this));
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final void zzmw() {
        if (this.zzcho != null && this.zzchu == 0) {
            zza("canplaythrough", "duration", String.valueOf(this.zzcho.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.zzcho.getVideoWidth()), "videoHeight", String.valueOf(this.zzcho.getVideoHeight()));
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final void zzmx() {
        if (this.zzbvz.zzrx() != null && !this.zzchq) {
            this.zzchr = (this.zzbvz.zzrx().getWindow().getAttributes().flags & 128) != 0;
            if (!this.zzchr) {
                this.zzbvz.zzrx().getWindow().addFlags(128);
                this.zzchq = true;
            }
        }
        this.zzchp = true;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final void zzmy() {
        zza("ended", new String[0]);
        zznh();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final void zzmz() {
        if (this.zzchx && this.zzchv != null && !zzng()) {
            this.zzchw.setImageBitmap(this.zzchv);
            this.zzchw.invalidate();
            this.zzchk.addView(this.zzchw, new FrameLayout.LayoutParams(-1, -1));
            this.zzchk.bringChildToFront(this.zzchw);
        }
        this.zzchm.pause();
        this.zzchu = this.zzcht;
        zzahf.zzdbo.post(new zzac(this));
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final void zzna() {
        if (this.zzchp && zzng()) {
            this.zzchk.removeView(this.zzchw);
        }
        if (this.zzchv != null) {
            long elapsedRealtime = zzbv.zzeg().elapsedRealtime();
            if (this.zzcho.getBitmap(this.zzchv) != null) {
                this.zzchx = true;
            }
            long elapsedRealtime2 = zzbv.zzeg().elapsedRealtime() - elapsedRealtime;
            if (zzafx.zzqr()) {
                zzafx.v(new StringBuilder(46).append("Spinner frame grab took ").append(elapsedRealtime2).append("ms").toString());
            }
            if (elapsedRealtime2 > this.zzchn) {
                zzafx.zzcs("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzchs = false;
                this.zzchv = null;
                if (this.zzchl != null) {
                    this.zzchl.zzh("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zznb() {
        if (this.zzcho == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzbwe)) {
            zza("no_src", new String[0]);
        } else {
            this.zzcho.setVideoPath(this.zzbwe);
        }
    }

    public final void zznc() {
        if (this.zzcho == null) {
            return;
        }
        zzy zzyVar = this.zzcho;
        zzyVar.zzchj.setMuted(true);
        zzyVar.zzmk();
    }

    public final void zznd() {
        if (this.zzcho == null) {
            return;
        }
        zzy zzyVar = this.zzcho;
        zzyVar.zzchj.setMuted(false);
        zzyVar.zzmk();
    }

    @TargetApi(14)
    public final void zzne() {
        if (this.zzcho == null) {
            return;
        }
        TextView textView = new TextView(this.zzcho.getContext());
        String valueOf = String.valueOf(this.zzcho.zzmg());
        textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
        this.zzchk.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzchk.bringChildToFront(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zznf() {
        if (this.zzcho == null) {
            return;
        }
        long currentPosition = this.zzcho.getCurrentPosition();
        if (this.zzcht == currentPosition || currentPosition <= 0) {
            return;
        }
        zza("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
        this.zzcht = currentPosition;
    }
}
