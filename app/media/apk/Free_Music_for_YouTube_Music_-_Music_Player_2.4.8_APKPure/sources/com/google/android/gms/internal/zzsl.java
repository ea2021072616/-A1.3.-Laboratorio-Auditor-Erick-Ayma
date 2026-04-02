package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public abstract class zzsl implements Releasable {
    protected Context mContext;
    private String zzbwh;
    private WeakReference<zzakk> zzbwi;

    public zzsl(zzakk zzakkVar) {
        this.mContext = zzakkVar.getContext();
        this.zzbwh = com.google.android.gms.ads.internal.zzbv.zzea().zzs(this.mContext, zzakkVar.zzse().zzcp);
        this.zzbwi = new WeakReference<>(zzakkVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, Map<String, String> map) {
        zzakk zzakkVar = this.zzbwi.get();
        if (zzakkVar != null) {
            zzakkVar.zza(str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzav(String str) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1396664534:
                if (str.equals("badUrl")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c2 = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c2 = 7;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c2 = 3;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c2 = 1;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c2 = 0;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c2 = 5;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "internal";
            case 4:
            case 5:
                return "io";
            case 6:
            case 7:
                return "network";
            case '\b':
            case '\t':
                return "policy";
            default:
                return "internal";
        }
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(String str, String str2, int i) {
        zzaje.zzdee.post(new zzsn(this, str, str2, i));
    }

    public final void zza(String str, String str2, String str3, @Nullable String str4) {
        zzaje.zzdee.post(new zzso(this, str, str2, str3, str4));
    }

    public abstract boolean zzau(String str);
}
