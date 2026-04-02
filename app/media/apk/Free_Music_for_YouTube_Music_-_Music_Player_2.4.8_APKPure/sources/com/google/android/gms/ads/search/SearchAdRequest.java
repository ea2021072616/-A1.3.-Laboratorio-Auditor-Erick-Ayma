package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzlh;
/* loaded from: classes.dex */
public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final zzlg zzaks;
    private final String zzarx;
    private final int zzbrh;
    private final int zzdiw;
    private final int zzdix;
    private final int zzdiy;
    private final int zzdiz;
    private final int zzdja;
    private final int zzdjb;
    private final int zzdjc;
    private final String zzdjd;
    private final int zzdje;
    private final String zzdjf;
    private final int zzdjg;
    private final int zzdjh;

    /* loaded from: classes.dex */
    public static final class Builder {
        private String zzarx;
        private int zzbrh;
        private int zzdiw;
        private int zzdix;
        private int zzdiy;
        private int zzdiz;
        private int zzdja;
        private int zzdjc;
        private String zzdjd;
        private int zzdje;
        private String zzdjf;
        private int zzdjg;
        private int zzdjh;
        private final zzlh zzakt = new zzlh();
        private int zzdjb = 0;

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzakt.zzb(cls, bundle);
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

        public final SearchAdRequest build() {
            return new SearchAdRequest(this);
        }

        public final Builder setAnchorTextColor(int i) {
            this.zzdiw = i;
            return this;
        }

        public final Builder setBackgroundColor(int i) {
            this.zzbrh = i;
            this.zzdix = Color.argb(0, 0, 0, 0);
            this.zzdiy = Color.argb(0, 0, 0, 0);
            return this;
        }

        public final Builder setBackgroundGradient(int i, int i2) {
            this.zzbrh = Color.argb(0, 0, 0, 0);
            this.zzdix = i2;
            this.zzdiy = i;
            return this;
        }

        public final Builder setBorderColor(int i) {
            this.zzdiz = i;
            return this;
        }

        public final Builder setBorderThickness(int i) {
            this.zzdja = i;
            return this;
        }

        public final Builder setBorderType(int i) {
            this.zzdjb = i;
            return this;
        }

        public final Builder setCallButtonColor(int i) {
            this.zzdjc = i;
            return this;
        }

        public final Builder setCustomChannels(String str) {
            this.zzdjd = str;
            return this;
        }

        public final Builder setDescriptionTextColor(int i) {
            this.zzdje = i;
            return this;
        }

        public final Builder setFontFace(String str) {
            this.zzdjf = str;
            return this;
        }

        public final Builder setHeaderTextColor(int i) {
            this.zzdjg = i;
            return this;
        }

        public final Builder setHeaderTextSize(int i) {
            this.zzdjh = i;
            return this;
        }

        public final Builder setLocation(Location location) {
            this.zzakt.zzb(location);
            return this;
        }

        public final Builder setQuery(String str) {
            this.zzarx = str;
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

    private SearchAdRequest(Builder builder) {
        this.zzdiw = builder.zzdiw;
        this.zzbrh = builder.zzbrh;
        this.zzdix = builder.zzdix;
        this.zzdiy = builder.zzdiy;
        this.zzdiz = builder.zzdiz;
        this.zzdja = builder.zzdja;
        this.zzdjb = builder.zzdjb;
        this.zzdjc = builder.zzdjc;
        this.zzdjd = builder.zzdjd;
        this.zzdje = builder.zzdje;
        this.zzdjf = builder.zzdjf;
        this.zzdjg = builder.zzdjg;
        this.zzdjh = builder.zzdjh;
        this.zzarx = builder.zzarx;
        this.zzaks = new zzlg(builder.zzakt, this);
    }

    public final int getAnchorTextColor() {
        return this.zzdiw;
    }

    public final int getBackgroundColor() {
        return this.zzbrh;
    }

    public final int getBackgroundGradientBottom() {
        return this.zzdix;
    }

    public final int getBackgroundGradientTop() {
        return this.zzdiy;
    }

    public final int getBorderColor() {
        return this.zzdiz;
    }

    public final int getBorderThickness() {
        return this.zzdja;
    }

    public final int getBorderType() {
        return this.zzdjb;
    }

    public final int getCallButtonColor() {
        return this.zzdjc;
    }

    public final String getCustomChannels() {
        return this.zzdjd;
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzaks.getCustomEventExtrasBundle(cls);
    }

    public final int getDescriptionTextColor() {
        return this.zzdje;
    }

    public final String getFontFace() {
        return this.zzdjf;
    }

    public final int getHeaderTextColor() {
        return this.zzdjg;
    }

    public final int getHeaderTextSize() {
        return this.zzdjh;
    }

    public final Location getLocation() {
        return this.zzaks.getLocation();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzaks.getNetworkExtras(cls);
    }

    public final <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzaks.getNetworkExtrasBundle(cls);
    }

    public final String getQuery() {
        return this.zzarx;
    }

    public final boolean isTestDevice(Context context) {
        return this.zzaks.isTestDevice(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzlg zzaz() {
        return this.zzaks;
    }
}
