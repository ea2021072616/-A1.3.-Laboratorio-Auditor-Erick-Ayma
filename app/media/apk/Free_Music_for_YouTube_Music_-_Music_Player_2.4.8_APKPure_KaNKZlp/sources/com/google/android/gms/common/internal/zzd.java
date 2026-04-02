package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class zzd<T extends IInterface> {
    private static String[] zzftd = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Object mLock;
    private final Looper zzakl;
    private final com.google.android.gms.common.zze zzfki;
    private int zzfsi;
    private long zzfsj;
    private long zzfsk;
    private int zzfsl;
    private long zzfsm;
    private zzal zzfsn;
    private final zzaf zzfso;
    private final Object zzfsp;
    private zzax zzfsq;
    protected zzj zzfsr;
    private T zzfss;
    private final ArrayList<zzi<?>> zzfst;
    private zzl zzfsu;
    private int zzfsv;
    private final zzf zzfsw;
    private final zzg zzfsx;
    private final int zzfsy;
    private final String zzfsz;
    private ConnectionResult zzfta;
    private boolean zzftb;
    protected AtomicInteger zzftc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzd(Context context, Looper looper, int i, zzf zzfVar, zzg zzgVar, String str) {
        this(context, looper, zzaf.zzcf(context), com.google.android.gms.common.zze.zzaew(), i, (zzf) zzbp.zzu(zzfVar), (zzg) zzbp.zzu(zzgVar), null);
    }

    protected zzd(Context context, Looper looper, zzaf zzafVar, com.google.android.gms.common.zze zzeVar, int i, zzf zzfVar, zzg zzgVar, String str) {
        this.mLock = new Object();
        this.zzfsp = new Object();
        this.zzfst = new ArrayList<>();
        this.zzfsv = 1;
        this.zzfta = null;
        this.zzftb = false;
        this.zzftc = new AtomicInteger(0);
        this.mContext = (Context) zzbp.zzb(context, "Context must not be null");
        this.zzakl = (Looper) zzbp.zzb(looper, "Looper must not be null");
        this.zzfso = (zzaf) zzbp.zzb(zzafVar, "Supervisor must not be null");
        this.zzfki = (com.google.android.gms.common.zze) zzbp.zzb(zzeVar, "API availability must not be null");
        this.mHandler = new zzh(this, looper);
        this.zzfsy = i;
        this.zzfsw = zzfVar;
        this.zzfsx = zzgVar;
        this.zzfsz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i, T t) {
        zzbp.zzbh((i == 4) == (t != null));
        synchronized (this.mLock) {
            this.zzfsv = i;
            this.zzfss = t;
            switch (i) {
                case 1:
                    if (this.zzfsu != null) {
                        this.zzfso.zza(zzhc(), zzajd(), TsExtractor.TS_STREAM_TYPE_AC3, this.zzfsu, zzaje());
                        this.zzfsu = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    if (this.zzfsu != null && this.zzfsn != null) {
                        String zzakk = this.zzfsn.zzakk();
                        String packageName = this.zzfsn.getPackageName();
                        Log.e("GmsClient", new StringBuilder(String.valueOf(zzakk).length() + 70 + String.valueOf(packageName).length()).append("Calling connect() while still connected, missing disconnect() for ").append(zzakk).append(" on ").append(packageName).toString());
                        this.zzfso.zza(this.zzfsn.zzakk(), this.zzfsn.getPackageName(), this.zzfsn.zzakg(), this.zzfsu, zzaje());
                        this.zzftc.incrementAndGet();
                    }
                    this.zzfsu = new zzl(this, this.zzftc.get());
                    this.zzfsn = new zzal(zzajd(), zzhc(), false, TsExtractor.TS_STREAM_TYPE_AC3);
                    if (!this.zzfso.zza(new zzag(this.zzfsn.zzakk(), this.zzfsn.getPackageName(), this.zzfsn.zzakg()), this.zzfsu, zzaje())) {
                        String zzakk2 = this.zzfsn.zzakk();
                        String packageName2 = this.zzfsn.getPackageName();
                        Log.e("GmsClient", new StringBuilder(String.valueOf(zzakk2).length() + 34 + String.valueOf(packageName2).length()).append("unable to connect to service: ").append(zzakk2).append(" on ").append(packageName2).toString());
                        zza(16, (Bundle) null, this.zzftc.get());
                        break;
                    }
                    break;
                case 4:
                    zza((zzd<T>) t);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.mLock) {
            if (this.zzfsv != i) {
                z = false;
            } else {
                zza(i2, (int) t);
                z = true;
            }
        }
        return z;
    }

    @Nullable
    private final String zzaje() {
        return this.zzfsz == null ? this.mContext.getClass().getName() : this.zzfsz;
    }

    private final boolean zzajg() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfsv == 3;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzajm() {
        if (this.zzftb || TextUtils.isEmpty(zzhd()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(zzhd());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzcc(int i) {
        int i2;
        if (zzajg()) {
            i2 = 5;
            this.zzftb = true;
        } else {
            i2 = 4;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(i2, this.zzftc.get(), 16));
    }

    public void disconnect() {
        this.zzftc.incrementAndGet();
        synchronized (this.zzfst) {
            int size = this.zzfst.size();
            for (int i = 0; i < size; i++) {
                this.zzfst.get(i).removeListener();
            }
            this.zzfst.clear();
        }
        synchronized (this.zzfsp) {
            this.zzfsq = null;
        }
        zza(1, (int) null);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        zzax zzaxVar;
        synchronized (this.mLock) {
            i = this.zzfsv;
            t = this.zzfss;
        }
        synchronized (this.zzfsp) {
            zzaxVar = this.zzfsq;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("REMOTE_CONNECTING");
                break;
            case 3:
                printWriter.print("LOCAL_CONNECTING");
                break;
            case 4:
                printWriter.print("CONNECTED");
                break;
            case 5:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) zzhd()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (zzaxVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(zzaxVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzfsk > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.zzfsk;
            String format = simpleDateFormat.format(new Date(this.zzfsk));
            append.println(new StringBuilder(String.valueOf(format).length() + 21).append(j).append(" ").append(format).toString());
        }
        if (this.zzfsj > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            switch (this.zzfsi) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append((CharSequence) String.valueOf(this.zzfsi));
                    break;
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzfsj;
            String format2 = simpleDateFormat.format(new Date(this.zzfsj));
            append2.println(new StringBuilder(String.valueOf(format2).length() + 21).append(j2).append(" ").append(format2).toString());
        }
        if (this.zzfsm > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzfsl));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzfsm;
            String format3 = simpleDateFormat.format(new Date(this.zzfsm));
            append3.println(new StringBuilder(String.valueOf(format3).length() + 21).append(j3).append(" ").append(format3).toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzakl;
    }

    public final boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfsv == 4;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfsv == 2 || this.zzfsv == 3;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzfsl = connectionResult.getErrorCode();
        this.zzfsm = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public final void onConnectionSuspended(int i) {
        this.zzfsi = i;
        this.zzfsj = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(int i, @Nullable Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, i2, -1, new zzo(this, i, null)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzn(this, i, iBinder, bundle)));
    }

    @CallSuper
    protected void zza(@NonNull T t) {
        this.zzfsk = System.currentTimeMillis();
    }

    @WorkerThread
    public final void zza(zzam zzamVar, Set<Scope> set) {
        Bundle zzzs = zzzs();
        zzy zzyVar = new zzy(this.zzfsy);
        zzyVar.zzfty = this.mContext.getPackageName();
        zzyVar.zzfub = zzzs;
        if (set != null) {
            zzyVar.zzfua = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (zzaaa()) {
            zzyVar.zzfuc = getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
            if (zzamVar != null) {
                zzyVar.zzftz = zzamVar.asBinder();
            }
        } else if (zzajk()) {
            zzyVar.zzfuc = getAccount();
        }
        zzyVar.zzfud = zzajh();
        try {
            synchronized (this.zzfsp) {
                if (this.zzfsq != null) {
                    this.zzfsq.zza(new zzk(this, this.zzftc.get()), zzyVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            zzcb(1);
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            zza(8, (IBinder) null, (Bundle) null, this.zzftc.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            zza(8, (IBinder) null, (Bundle) null, this.zzftc.get());
        }
    }

    public void zza(@NonNull zzj zzjVar) {
        this.zzfsr = (zzj) zzbp.zzb(zzjVar, "Connection progress callbacks cannot be null.");
        zza(2, (int) null);
    }

    protected final void zza(@NonNull zzj zzjVar, int i, @Nullable PendingIntent pendingIntent) {
        this.zzfsr = (zzj) zzbp.zzb(zzjVar, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzftc.get(), i, pendingIntent));
    }

    public boolean zzaaa() {
        return false;
    }

    public boolean zzaak() {
        return false;
    }

    public Intent zzaal() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public Bundle zzaeg() {
        return null;
    }

    public boolean zzafe() {
        return true;
    }

    @Nullable
    public final IBinder zzaff() {
        IBinder asBinder;
        synchronized (this.zzfsp) {
            asBinder = this.zzfsq == null ? null : this.zzfsq.asBinder();
        }
        return asBinder;
    }

    protected String zzajd() {
        return "com.google.android.gms";
    }

    public final void zzajf() {
        int isGooglePlayServicesAvailable = this.zzfki.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable == 0) {
            zza(new zzm(this));
            return;
        }
        zza(1, (int) null);
        zza(new zzm(this), isGooglePlayServicesAvailable, (PendingIntent) null);
    }

    public com.google.android.gms.common.zzc[] zzajh() {
        return new com.google.android.gms.common.zzc[0];
    }

    protected final void zzaji() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzajj() throws DeadObjectException {
        T t;
        synchronized (this.mLock) {
            if (this.zzfsv == 5) {
                throw new DeadObjectException();
            }
            zzaji();
            zzbp.zza(this.zzfss != null, "Client is connected but service is null");
            t = this.zzfss;
        }
        return t;
    }

    public boolean zzajk() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<Scope> zzajl() {
        return Collections.EMPTY_SET;
    }

    public final void zzcb(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.zzftc.get(), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public abstract T zze(IBinder iBinder);

    @NonNull
    protected abstract String zzhc();

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public abstract String zzhd();

    protected Bundle zzzs() {
        return new Bundle();
    }
}
