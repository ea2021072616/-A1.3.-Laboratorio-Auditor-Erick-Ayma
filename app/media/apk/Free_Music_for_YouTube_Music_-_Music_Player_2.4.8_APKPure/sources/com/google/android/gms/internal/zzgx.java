package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.ArrayList;
@zzzt
/* loaded from: classes.dex */
public final class zzgx {
    private final int zzaxm;
    private final int zzaxn;
    private final int zzaxo;
    private final zzhk zzaxp;
    private final zzht zzaxq;
    private int zzaxx;
    private final Object mLock = new Object();
    private ArrayList<String> zzaxr = new ArrayList<>();
    private ArrayList<String> zzaxs = new ArrayList<>();
    private ArrayList<zzhi> zzaxt = new ArrayList<>();
    private int zzaxu = 0;
    private int zzaxv = 0;
    private int zzaxw = 0;
    private String zzaxy = "";
    private String zzaxz = "";
    private String zzaya = "";

    public zzgx(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zzaxm = i;
        this.zzaxn = i2;
        this.zzaxo = i3;
        this.zzaxp = new zzhk(i4);
        this.zzaxq = new zzht(i5, i6, i7);
    }

    private static String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList2.get(i2);
            i2++;
            stringBuffer.append(str);
            stringBuffer.append(' ');
            if (stringBuffer.length() > 100) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= 100 ? stringBuffer2.substring(0, 100) : stringBuffer2;
    }

    private final void zzc(@Nullable String str, boolean z, float f, float f2, float f3, float f4) {
        if (str == null || str.length() < this.zzaxo) {
            return;
        }
        synchronized (this.mLock) {
            this.zzaxr.add(str);
            this.zzaxu += str.length();
            if (z) {
                this.zzaxs.add(str);
                this.zzaxt.add(new zzhi(f, f2, f3, f4, this.zzaxs.size() - 1));
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgx) {
            if (obj == this) {
                return true;
            }
            zzgx zzgxVar = (zzgx) obj;
            return zzgxVar.zzaxy != null && zzgxVar.zzaxy.equals(this.zzaxy);
        }
        return false;
    }

    public final int getScore() {
        return this.zzaxx;
    }

    public final int hashCode() {
        return this.zzaxy.hashCode();
    }

    public final String toString() {
        int i = this.zzaxv;
        int i2 = this.zzaxx;
        int i3 = this.zzaxu;
        String zza = zza(this.zzaxr, 100);
        String zza2 = zza(this.zzaxs, 100);
        String str = this.zzaxy;
        String str2 = this.zzaxz;
        String str3 = this.zzaya;
        return new StringBuilder(String.valueOf(zza).length() + 165 + String.valueOf(zza2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length()).append("ActivityContent fetchId: ").append(i).append(" score:").append(i2).append(" total_length:").append(i3).append("\n text: ").append(zza).append("\n viewableText").append(zza2).append("\n signture: ").append(str).append("\n viewableSignture: ").append(str2).append("\n viewableSignatureForVertical: ").append(str3).toString();
    }

    public final void zza(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
        synchronized (this.mLock) {
            if (this.zzaxw < 0) {
                zzafx.zzcb("ActivityContent: negative number of WebViews.");
            }
            zzgk();
        }
    }

    public final void zzb(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
    }

    public final boolean zzgd() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzaxw == 0;
        }
        return z;
    }

    public final String zzge() {
        return this.zzaxy;
    }

    public final String zzgf() {
        return this.zzaxz;
    }

    public final String zzgg() {
        return this.zzaya;
    }

    public final void zzgh() {
        synchronized (this.mLock) {
            this.zzaxx -= 100;
        }
    }

    public final void zzgi() {
        synchronized (this.mLock) {
            this.zzaxw--;
        }
    }

    public final void zzgj() {
        synchronized (this.mLock) {
            this.zzaxw++;
        }
    }

    public final void zzgk() {
        synchronized (this.mLock) {
            int i = (this.zzaxu * this.zzaxm) + (this.zzaxv * this.zzaxn);
            if (i > this.zzaxx) {
                this.zzaxx = i;
                if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbia)).booleanValue() && !com.google.android.gms.ads.internal.zzbv.zzee().zzpp()) {
                    this.zzaxy = this.zzaxp.zza(this.zzaxr);
                    this.zzaxz = this.zzaxp.zza(this.zzaxs);
                }
                if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbic)).booleanValue() && !com.google.android.gms.ads.internal.zzbv.zzee().zzpq()) {
                    this.zzaya = this.zzaxq.zza(this.zzaxs, this.zzaxt);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzgl() {
        return this.zzaxu;
    }

    public final void zzm(int i) {
        this.zzaxv = i;
    }
}
