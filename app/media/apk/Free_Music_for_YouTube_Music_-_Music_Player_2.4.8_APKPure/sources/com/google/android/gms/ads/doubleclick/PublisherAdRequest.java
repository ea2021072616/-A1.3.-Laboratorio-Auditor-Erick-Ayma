package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzlh;
import java.util.Date;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final zzlg zzaks;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final zzlh zzakt = new zzlh();

        public final Builder addCategoryExclusion(String str) {
            this.zzakt.zzai(str);
            return this;
        }

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzakt.zzb(cls, bundle);
            return this;
        }

        public final Builder addCustomTargeting(String str, String str2) {
            this.zzakt.zzf(str, str2);
            return this;
        }

        public final Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zzakt.zzf(str, TextUtils.join(",", list));
            }
            return this;
        }

        public final Builder addKeyword(String str) {
            this.zzakt.zzac(str);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzakt.zza(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzakt.zza(cls, bundle);
            return this;
        }

        public final Builder addTestDevice(String str) {
            this.zzakt.zzad(str);
            return this;
        }

        public final PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        public final Builder setBirthday(Date date) {
            this.zzakt.zza(date);
            return this;
        }

        public final Builder setContentUrl(String str) {
            zzbp.zzb(str, "Content URL must be non-null.");
            zzbp.zzh(str, "Content URL must be non-empty.");
            zzbp.zzb(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.zzakt.zzaf(str);
            return this;
        }

        public final Builder setGender(int i) {
            this.zzakt.zzp(i);
            return this;
        }

        public final Builder setIsDesignedForFamilies(boolean z) {
            this.zzakt.zzj(z);
            return this;
        }

        public final Builder setLocation(Location location) {
            this.zzakt.zzb(location);
            return this;
        }

        @Deprecated
        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzakt.setManualImpressionsEnabled(z);
            return this;
        }

        public final Builder setPublisherProvidedId(String str) {
            this.zzakt.zzag(str);
            return this;
        }

        public final Builder setRequestAgent(String str) {
            this.zzakt.zzah(str);
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean z) {
            this.zzakt.zzi(z);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.zzaks = new zzlg(builder.zzakt);
    }

    public static void updateCorrelator() {
    }

    public final Date getBirthday() {
        return this.zzaks.getBirthday();
    }

    public final String getContentUrl() {
        return this.zzaks.getContentUrl();
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzaks.getCustomEventExtrasBundle(cls);
    }

    public final Bundle getCustomTargeting() {
        return this.zzaks.getCustomTargeting();
    }

    public final int getGender() {
        return this.zzaks.getGender();
    }

    public final Set<String> getKeywords() {
        return this.zzaks.getKeywords();
    }

    public final Location getLocation() {
        return this.zzaks.getLocation();
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzaks.getManualImpressionsEnabled();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzaks.getNetworkExtras(cls);
    }

    public final <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzaks.getNetworkExtrasBundle(cls);
    }

    public final String getPublisherProvidedId() {
        return this.zzaks.getPublisherProvidedId();
    }

    public final boolean isTestDevice(Context context) {
        return this.zzaks.isTestDevice(context);
    }

    public final zzlg zzaz() {
        return this.zzaks;
    }
}
