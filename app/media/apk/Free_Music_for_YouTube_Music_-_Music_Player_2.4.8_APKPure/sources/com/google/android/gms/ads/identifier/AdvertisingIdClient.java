package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.zzo;
import com.google.android.gms.internal.zzfh;
import com.google.android.gms.internal.zzfi;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class AdvertisingIdClient {
    private final Context mContext;
    @Nullable
    private com.google.android.gms.common.zza zzalw;
    @Nullable
    private zzfh zzalx;
    private boolean zzaly;
    private Object zzalz;
    @Nullable
    private zza zzama;
    private long zzamb;

    /* loaded from: classes.dex */
    public static final class Info {
        private final String zzamh;
        private final boolean zzami;

        public Info(String str, boolean z) {
            this.zzamh = str;
            this.zzami = z;
        }

        public final String getId() {
            return this.zzamh;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzami;
        }

        public final String toString() {
            String str = this.zzamh;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.zzami).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzamd;
        private long zzame;
        CountDownLatch zzamf = new CountDownLatch(1);
        boolean zzamg = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzamd = new WeakReference<>(advertisingIdClient);
            this.zzame = j;
            start();
        }

        private final void disconnect() {
            AdvertisingIdClient advertisingIdClient = this.zzamd.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzamg = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.zzamf.await(this.zzame, TimeUnit.MILLISECONDS)) {
                    return;
                }
                disconnect();
            } catch (InterruptedException e) {
                disconnect();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z) {
        this.zzalz = new Object();
        zzbp.zzu(context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext != null ? applicationContext : context;
        } else {
            this.mContext = context;
        }
        this.zzaly = false;
        this.zzamb = j;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Info info;
        zzd zzdVar = new zzd(context);
        boolean z = zzdVar.getBoolean("gads:ad_id_app_context:enabled", false);
        float f = zzdVar.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        if (!zzdVar.getBoolean("gads:ad_id_use_shared_preference:enabled", false) || (info = zzb.zze(context).getInfo()) == null) {
            AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, z);
            try {
                advertisingIdClient.start(false);
                info = advertisingIdClient.getInfo();
                advertisingIdClient.zza(info, z, f, null);
            } finally {
            }
        }
        return info;
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private final void start(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzbp.zzgg("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzaly) {
                finish();
            }
            this.zzalw = zzd(this.mContext);
            this.zzalx = zza(this.mContext, this.zzalw);
            this.zzaly = true;
            if (z) {
                zzbi();
            }
        }
    }

    private static zzfh zza(Context context, com.google.android.gms.common.zza zzaVar) throws IOException {
        try {
            return zzfi.zzd(zzaVar.zza(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private final boolean zza(Info info, boolean z, float f, Throwable th) {
        if (Math.random() > f) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (info != null && info.getId() != null) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        new com.google.android.gms.ads.identifier.zza(this, hashMap).start();
        return true;
    }

    private final void zzbi() {
        synchronized (this.zzalz) {
            if (this.zzama != null) {
                this.zzama.zzamf.countDown();
                try {
                    this.zzama.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzamb > 0) {
                this.zzama = new zza(this, this.zzamb);
            }
        }
    }

    private static com.google.android.gms.common.zza zzd(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(zzo.GOOGLE_PLAY_STORE_PACKAGE, 0);
            switch (com.google.android.gms.common.zze.zzaew().isGooglePlayServicesAvailable(context)) {
                case 0:
                case 2:
                    com.google.android.gms.common.zza zzaVar = new com.google.android.gms.common.zza();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (com.google.android.gms.common.stats.zza.zzaky().zza(context, intent, zzaVar, 1)) {
                            return zzaVar;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        throw new IOException(th);
                    }
                case 1:
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public void finish() {
        zzbp.zzgg("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.zzalw == null) {
                return;
            }
            if (this.zzaly) {
                com.google.android.gms.common.stats.zza.zzaky();
                this.mContext.unbindService(this.zzalw);
            }
            this.zzaly = false;
            this.zzalx = null;
            this.zzalw = null;
        }
    }

    public Info getInfo() throws IOException {
        Info info;
        zzbp.zzgg("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzaly) {
                synchronized (this.zzalz) {
                    if (this.zzama == null || !this.zzama.zzamg) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzaly) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            zzbp.zzu(this.zzalw);
            zzbp.zzu(this.zzalx);
            try {
                info = new Info(this.zzalx.getId(), this.zzalx.zzb(true));
            } catch (RemoteException e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        zzbi();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        start(true);
    }
}
