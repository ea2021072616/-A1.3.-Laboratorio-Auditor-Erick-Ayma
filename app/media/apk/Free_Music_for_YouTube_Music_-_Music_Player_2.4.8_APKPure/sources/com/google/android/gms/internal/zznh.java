package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zznh {
    private boolean zzbpw;
    private String zzbqp;
    private zznf zzbqq;
    @Nullable
    private zznh zzbqr;
    private final List<zznf> zzbqn = new LinkedList();
    private final Map<String, String> zzbqo = new LinkedHashMap();
    private final Object mLock = new Object();

    public zznh(boolean z, String str, String str2) {
        this.zzbpw = z;
        this.zzbqo.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        this.zzbqo.put("ad_format", str2);
    }

    public final boolean zza(zznf zznfVar, long j, String... strArr) {
        synchronized (this.mLock) {
            for (String str : strArr) {
                this.zzbqn.add(new zznf(j, str, zznfVar));
            }
        }
        return true;
    }

    public final boolean zza(@Nullable zznf zznfVar, String... strArr) {
        if (!this.zzbpw || zznfVar == null) {
            return false;
        }
        return zza(zznfVar, com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime(), strArr);
    }

    public final void zzan(String str) {
        if (this.zzbpw) {
            synchronized (this.mLock) {
                this.zzbqp = str;
            }
        }
    }

    @Nullable
    public final zznf zzc(long j) {
        if (this.zzbpw) {
            return new zznf(j, null, null);
        }
        return null;
    }

    public final void zzc(@Nullable zznh zznhVar) {
        synchronized (this.mLock) {
            this.zzbqr = zznhVar;
        }
    }

    public final void zzh(String str, String str2) {
        zzmx zzpt;
        if (!this.zzbpw || TextUtils.isEmpty(str2) || (zzpt = com.google.android.gms.ads.internal.zzbv.zzee().zzpt()) == null) {
            return;
        }
        synchronized (this.mLock) {
            zznb zzal = zzpt.zzal(str);
            Map<String, String> map = this.zzbqo;
            map.put(str, zzal.zzg(map.get(str), str2));
        }
    }

    public final zznf zziu() {
        return zzc(com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime());
    }

    public final void zziv() {
        synchronized (this.mLock) {
            this.zzbqq = zziu();
        }
    }

    public final String zziw() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.mLock) {
            for (zznf zznfVar : this.zzbqn) {
                long time = zznfVar.getTime();
                String zzir = zznfVar.zzir();
                zznf zzis = zznfVar.zzis();
                if (zzis != null && time > 0) {
                    sb2.append(zzir).append('.').append(time - zzis.getTime()).append(',');
                }
            }
            this.zzbqn.clear();
            if (!TextUtils.isEmpty(this.zzbqp)) {
                sb2.append(this.zzbqp);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> zzix() {
        Map<String, String> zza;
        synchronized (this.mLock) {
            zzmx zzpt = com.google.android.gms.ads.internal.zzbv.zzee().zzpt();
            zza = (zzpt == null || this.zzbqr == null) ? this.zzbqo : zzpt.zza(this.zzbqo, this.zzbqr.zzix());
        }
        return zza;
    }

    public final zznf zziy() {
        zznf zznfVar;
        synchronized (this.mLock) {
            zznfVar = this.zzbqq;
        }
        return zznfVar;
    }
}
