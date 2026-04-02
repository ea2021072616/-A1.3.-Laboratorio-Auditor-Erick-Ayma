package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAdOptions;
import java.util.Map;
/* loaded from: classes.dex */
public interface NativeMediationAdRequest extends MediationAdRequest {
    NativeAdOptions getNativeAdOptions();

    boolean isAppInstallAdRequested();

    boolean isContentAdRequested();

    boolean zzmc();

    Map<String, Boolean> zzmd();
}
