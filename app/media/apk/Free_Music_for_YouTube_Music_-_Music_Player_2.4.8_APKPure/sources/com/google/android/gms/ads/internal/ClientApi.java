package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzacx;
import com.google.android.gms.internal.zzade;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkf;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzxg;
import com.google.android.gms.internal.zzxq;
import com.google.android.gms.internal.zzzt;
@zzzt
@Keep
@DynamiteApi
@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class ClientApi extends zzko {
    @Override // com.google.android.gms.internal.zzkn
    public zzka createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzva zzvaVar, int i) {
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
        zzbv.zzea();
        return new zzal(context, str, zzvaVar, new zzajk(11200000, i, true, zzahf.zzar(context)), zzv.zzf(context));
    }

    @Override // com.google.android.gms.internal.zzkn
    public zzxg createAdOverlay(IObjectWrapper iObjectWrapper) {
        return new com.google.android.gms.ads.internal.overlay.zzm((Activity) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzkn
    public zzkf createBannerAdManager(IObjectWrapper iObjectWrapper, zzjb zzjbVar, String str, zzva zzvaVar, int i) throws RemoteException {
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
        zzbv.zzea();
        return new zzx(context, zzjbVar, str, zzvaVar, new zzajk(11200000, i, true, zzahf.zzar(context)), zzv.zzf(context));
    }

    @Override // com.google.android.gms.internal.zzkn
    public zzxq createInAppPurchaseManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0035, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(com.google.android.gms.internal.zzmu.zzbka)).booleanValue() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0049, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(com.google.android.gms.internal.zzmu.zzbkb)).booleanValue() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004b, code lost:
        r1 = true;
     */
    @Override // com.google.android.gms.internal.zzkn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.zzkf createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper r14, com.google.android.gms.internal.zzjb r15, java.lang.String r16, com.google.android.gms.internal.zzva r17, int r18) throws android.os.RemoteException {
        /*
            r13 = this;
            java.lang.Object r2 = com.google.android.gms.dynamic.zzn.zzab(r14)
            android.content.Context r2 = (android.content.Context) r2
            com.google.android.gms.internal.zzmu.initialize(r2)
            com.google.android.gms.internal.zzajk r5 = new com.google.android.gms.internal.zzajk
            r1 = 11200000(0xaae600, float:1.5694543E-38)
            r3 = 1
            com.google.android.gms.ads.internal.zzbv.zzea()
            boolean r4 = com.google.android.gms.internal.zzahf.zzar(r2)
            r0 = r18
            r5.<init>(r1, r0, r3, r4)
            java.lang.String r1 = "reward_mb"
            java.lang.String r3 = r15.zzbcq
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L37
            com.google.android.gms.internal.zzmk<java.lang.Boolean> r1 = com.google.android.gms.internal.zzmu.zzbka
            com.google.android.gms.internal.zzms r4 = com.google.android.gms.ads.internal.zzbv.zzen()
            java.lang.Object r1 = r4.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L4b
        L37:
            if (r3 == 0) goto L5c
            com.google.android.gms.internal.zzmk<java.lang.Boolean> r1 = com.google.android.gms.internal.zzmu.zzbkb
            com.google.android.gms.internal.zzms r3 = com.google.android.gms.ads.internal.zzbv.zzen()
            java.lang.Object r1 = r3.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L5c
        L4b:
            r1 = 1
        L4c:
            if (r1 == 0) goto L5e
            com.google.android.gms.internal.zzua r1 = new com.google.android.gms.internal.zzua
            com.google.android.gms.ads.internal.zzv r6 = com.google.android.gms.ads.internal.zzv.zzf(r2)
            r3 = r16
            r4 = r17
            r1.<init>(r2, r3, r4, r5, r6)
        L5b:
            return r1
        L5c:
            r1 = 0
            goto L4c
        L5e:
            com.google.android.gms.ads.internal.zzam r6 = new com.google.android.gms.ads.internal.zzam
            com.google.android.gms.ads.internal.zzv r12 = com.google.android.gms.ads.internal.zzv.zzf(r2)
            r7 = r2
            r8 = r15
            r9 = r16
            r10 = r17
            r11 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r1 = r6
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ClientApi.createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.zzjb, java.lang.String, com.google.android.gms.internal.zzva, int):com.google.android.gms.internal.zzkf");
    }

    @Override // com.google.android.gms.internal.zzkn
    public zzpg createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzov((FrameLayout) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper), (FrameLayout) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper2));
    }

    @Override // com.google.android.gms.internal.zzkn
    public zzade createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzva zzvaVar, int i) {
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
        zzbv.zzea();
        return new zzacx(context, zzv.zzf(context), zzvaVar, new zzajk(11200000, i, true, zzahf.zzar(context)));
    }

    @Override // com.google.android.gms.internal.zzkn
    public zzkf createSearchAdManager(IObjectWrapper iObjectWrapper, zzjb zzjbVar, String str, int i) throws RemoteException {
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
        zzbv.zzea();
        return new zzbp(context, zzjbVar, str, new zzajk(11200000, i, true, zzahf.zzar(context)));
    }

    @Override // com.google.android.gms.internal.zzkn
    @Nullable
    public zzkt getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.zzkn
    public zzkt getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) {
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
        zzbv.zzea();
        return zzay.zza(context, new zzajk(11200000, i, true, zzahf.zzar(context)));
    }
}
