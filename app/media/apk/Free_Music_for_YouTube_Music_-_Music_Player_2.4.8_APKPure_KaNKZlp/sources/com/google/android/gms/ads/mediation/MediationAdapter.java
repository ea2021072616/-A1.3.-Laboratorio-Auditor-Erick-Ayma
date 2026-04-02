package com.google.android.gms.ads.mediation;

import android.os.Bundle;
/* loaded from: classes.dex */
public interface MediationAdapter {

    /* loaded from: classes.dex */
    public static class zza {
        private int zzdik;

        public final zza zzaf(int i) {
            this.zzdik = 1;
            return this;
        }

        public final Bundle zztm() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzdik);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
