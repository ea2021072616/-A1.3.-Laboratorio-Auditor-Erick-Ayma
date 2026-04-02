package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.zze;
import com.google.android.gms.security.ProviderInstaller;
/* loaded from: classes2.dex */
final class zza extends AsyncTask<Void, Void, Integer> {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ ProviderInstaller.ProviderInstallListener zzjna;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.zzaok = context;
        this.zzjna = providerInstallListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: zzb */
    public final Integer doInBackground(Void... voidArr) {
        try {
            ProviderInstaller.installIfNeeded(this.zzaok);
            return 0;
        } catch (GooglePlayServicesNotAvailableException e) {
            return Integer.valueOf(e.errorCode);
        } catch (GooglePlayServicesRepairableException e2) {
            return Integer.valueOf(e2.getConnectionStatusCode());
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Integer num) {
        zze unused;
        Integer num2 = num;
        if (num2.intValue() == 0) {
            this.zzjna.onProviderInstalled();
            return;
        }
        unused = ProviderInstaller.zzjmy;
        this.zzjna.onProviderInstallFailed(num2.intValue(), zze.zza(this.zzaok, num2.intValue(), "pi"));
    }
}
