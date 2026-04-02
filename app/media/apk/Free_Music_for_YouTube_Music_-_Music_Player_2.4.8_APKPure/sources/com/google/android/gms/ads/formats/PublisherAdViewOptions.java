package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.internal.zzjd;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class PublisherAdViewOptions extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();
    private final boolean zzalt;
    @Nullable
    private final zzkk zzalu;
    @Nullable
    private AppEventListener zzalv;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean zzalt = false;
        private AppEventListener zzalv;

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzalv = appEventListener;
            return this;
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzalt = z;
            return this;
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzalt = builder.zzalt;
        this.zzalv = builder.zzalv;
        this.zzalu = this.zzalv != null ? new zzjd(this.zzalv) : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublisherAdViewOptions(boolean z, @Nullable IBinder iBinder) {
        this.zzalt = z;
        this.zzalu = iBinder != null ? zzkl.zzg(iBinder) : null;
    }

    @Nullable
    public final AppEventListener getAppEventListener() {
        return this.zzalv;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzalt;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 1, getManualImpressionsEnabled());
        zzd.zza(parcel, 2, this.zzalu == null ? null : this.zzalu.asBinder(), false);
        zzd.zzai(parcel, zze);
    }

    @Nullable
    public final zzkk zzbh() {
        return this.zzalu;
    }
}
