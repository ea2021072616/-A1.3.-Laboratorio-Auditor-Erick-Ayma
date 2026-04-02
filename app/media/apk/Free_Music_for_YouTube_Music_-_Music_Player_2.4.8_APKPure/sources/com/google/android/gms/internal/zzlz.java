package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
@zzzt
/* loaded from: classes.dex */
public final class zzlz extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzlz> CREATOR = new zzma();
    private int backgroundColor;
    private int zzbeu;
    private int zzbev;
    private int zzbew;
    private int zzbex;
    private int zzbey;
    private int zzbez;
    private int zzbfa;
    private String zzbfb;
    private int zzbfc;
    private String zzbfd;
    private int zzbfe;
    private int zzbff;
    public final String zzbfg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlz(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, int i9, String str2, int i10, int i11, String str3) {
        this.zzbeu = i;
        this.backgroundColor = i2;
        this.zzbev = i3;
        this.zzbew = i4;
        this.zzbex = i5;
        this.zzbey = i6;
        this.zzbez = i7;
        this.zzbfa = i8;
        this.zzbfb = str;
        this.zzbfc = i9;
        this.zzbfd = str2;
        this.zzbfe = i10;
        this.zzbff = i11;
        this.zzbfg = str3;
    }

    public zzlz(SearchAdRequest searchAdRequest) {
        this.zzbeu = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.zzbev = searchAdRequest.getBackgroundGradientBottom();
        this.zzbew = searchAdRequest.getBackgroundGradientTop();
        this.zzbex = searchAdRequest.getBorderColor();
        this.zzbey = searchAdRequest.getBorderThickness();
        this.zzbez = searchAdRequest.getBorderType();
        this.zzbfa = searchAdRequest.getCallButtonColor();
        this.zzbfb = searchAdRequest.getCustomChannels();
        this.zzbfc = searchAdRequest.getDescriptionTextColor();
        this.zzbfd = searchAdRequest.getFontFace();
        this.zzbfe = searchAdRequest.getHeaderTextColor();
        this.zzbff = searchAdRequest.getHeaderTextSize();
        this.zzbfg = searchAdRequest.getQuery();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 2, this.zzbeu);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 3, this.backgroundColor);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 4, this.zzbev);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 5, this.zzbew);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 6, this.zzbex);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 7, this.zzbey);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 8, this.zzbez);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 9, this.zzbfa);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 10, this.zzbfb, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 11, this.zzbfc);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 12, this.zzbfd, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 13, this.zzbfe);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 14, this.zzbff);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 15, this.zzbfg, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}
