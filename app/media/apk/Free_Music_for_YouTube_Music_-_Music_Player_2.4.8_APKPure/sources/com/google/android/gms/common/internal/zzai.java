package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzai implements ServiceConnection {
    private IBinder zzftk;
    private ComponentName zzfuq;
    private boolean zzfux;
    private final zzag zzfuy;
    private /* synthetic */ zzah zzfuz;
    private final Set<ServiceConnection> zzfuw = new HashSet();
    private int mState = 2;

    public zzai(zzah zzahVar, zzag zzagVar) {
        this.zzfuz = zzahVar;
        this.zzfuy = zzagVar;
    }

    public final IBinder getBinder() {
        return this.zzftk;
    }

    public final ComponentName getComponentName() {
        return this.zzfuq;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean isBound() {
        return this.zzfux;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.zzfuz.zzfus;
        synchronized (hashMap) {
            handler = this.zzfuz.mHandler;
            handler.removeMessages(1, this.zzfuy);
            this.zzftk = iBinder;
            this.zzfuq = componentName;
            for (ServiceConnection serviceConnection : this.zzfuw) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.mState = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.zzfuz.zzfus;
        synchronized (hashMap) {
            handler = this.zzfuz.mHandler;
            handler.removeMessages(1, this.zzfuy);
            this.zzftk = null;
            this.zzfuq = componentName;
            for (ServiceConnection serviceConnection : this.zzfuw) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.mState = 2;
        }
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        com.google.android.gms.common.stats.zza unused;
        Context unused2;
        unused = this.zzfuz.zzfut;
        unused2 = this.zzfuz.mApplicationContext;
        this.zzfuy.zzakh();
        this.zzfuw.add(serviceConnection);
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        return this.zzfuw.contains(serviceConnection);
    }

    public final boolean zzaki() {
        return this.zzfuw.isEmpty();
    }

    public final void zzb(ServiceConnection serviceConnection, String str) {
        com.google.android.gms.common.stats.zza unused;
        Context unused2;
        unused = this.zzfuz.zzfut;
        unused2 = this.zzfuz.mApplicationContext;
        this.zzfuw.remove(serviceConnection);
    }

    public final void zzgb(String str) {
        com.google.android.gms.common.stats.zza zzaVar;
        Context context;
        Context context2;
        Handler handler;
        Handler handler2;
        long j;
        com.google.android.gms.common.stats.zza unused;
        this.mState = 3;
        zzaVar = this.zzfuz.zzfut;
        context = this.zzfuz.mApplicationContext;
        this.zzfux = zzaVar.zza(context, str, this.zzfuy.zzakh(), this, this.zzfuy.zzakg());
        if (this.zzfux) {
            handler = this.zzfuz.mHandler;
            Message obtainMessage = handler.obtainMessage(1, this.zzfuy);
            handler2 = this.zzfuz.mHandler;
            j = this.zzfuz.zzfuv;
            handler2.sendMessageDelayed(obtainMessage, j);
            return;
        }
        this.mState = 2;
        try {
            unused = this.zzfuz.zzfut;
            context2 = this.zzfuz.mApplicationContext;
            context2.unbindService(this);
        } catch (IllegalArgumentException e) {
        }
    }

    public final void zzgc(String str) {
        Handler handler;
        Context context;
        com.google.android.gms.common.stats.zza unused;
        handler = this.zzfuz.mHandler;
        handler.removeMessages(1, this.zzfuy);
        unused = this.zzfuz.zzfut;
        context = this.zzfuz.mApplicationContext;
        context.unbindService(this);
        this.zzfux = false;
        this.mState = 2;
    }
}
