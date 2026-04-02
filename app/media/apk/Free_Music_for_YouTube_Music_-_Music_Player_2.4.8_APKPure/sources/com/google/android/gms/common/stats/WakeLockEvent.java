package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzd();
    private final long mTimeout;
    private int zzdxt;
    private final long zzfxr;
    private int zzfxs;
    private final String zzfxt;
    private final String zzfxu;
    private final String zzfxv;
    private final int zzfxw;
    private final List<String> zzfxx;
    private final String zzfxy;
    private final long zzfxz;
    private int zzfya;
    private final String zzfyb;
    private final float zzfyc;
    private long zzfyd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.zzdxt = i;
        this.zzfxr = j;
        this.zzfxs = i2;
        this.zzfxt = str;
        this.zzfxu = str3;
        this.zzfxv = str5;
        this.zzfxw = i3;
        this.zzfyd = -1L;
        this.zzfxx = list;
        this.zzfxy = str2;
        this.zzfxz = j2;
        this.zzfya = i4;
        this.zzfyb = str4;
        this.zzfyc = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int getEventType() {
        return this.zzfxs;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long getTimeMillis() {
        return this.zzfxr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 1, this.zzdxt);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, getTimeMillis());
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.zzfxt, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 5, this.zzfxw);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 6, this.zzfxx, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzfxz);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 10, this.zzfxu, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 11, getEventType());
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 12, this.zzfxy, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 13, this.zzfyb, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 14, this.zzfya);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 15, this.zzfyc);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 16, this.mTimeout);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 17, this.zzfxv, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzakz() {
        return this.zzfyd;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzala() {
        String str = this.zzfxt;
        int i = this.zzfxw;
        String join = this.zzfxx == null ? "" : TextUtils.join(",", this.zzfxx);
        int i2 = this.zzfya;
        String str2 = this.zzfxu == null ? "" : this.zzfxu;
        String str3 = this.zzfyb == null ? "" : this.zzfyb;
        float f = this.zzfyc;
        String str4 = this.zzfxv == null ? "" : this.zzfxv;
        return new StringBuilder(String.valueOf("\t").length() + 37 + String.valueOf(str).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(join).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(str2).length() + String.valueOf("\t").length() + String.valueOf(str3).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(str4).length()).append("\t").append(str).append("\t").append(i).append("\t").append(join).append("\t").append(i2).append("\t").append(str2).append("\t").append(str3).append("\t").append(f).append("\t").append(str4).toString();
    }
}
