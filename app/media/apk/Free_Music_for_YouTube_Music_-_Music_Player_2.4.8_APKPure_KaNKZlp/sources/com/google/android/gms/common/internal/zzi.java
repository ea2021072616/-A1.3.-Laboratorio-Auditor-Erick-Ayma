package com.google.android.gms.common.internal;

import android.util.Log;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class zzi<TListener> {
    private TListener mListener;
    private /* synthetic */ zzd zzftf;
    private boolean zzftg = false;

    public zzi(zzd zzdVar, TListener tlistener) {
        this.zzftf = zzdVar;
        this.mListener = tlistener;
    }

    public final void removeListener() {
        synchronized (this) {
            this.mListener = null;
        }
    }

    public final void unregister() {
        ArrayList arrayList;
        ArrayList arrayList2;
        removeListener();
        arrayList = this.zzftf.zzfst;
        synchronized (arrayList) {
            arrayList2 = this.zzftf.zzfst;
            arrayList2.remove(this);
        }
    }

    public final void zzajo() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.mListener;
            if (this.zzftg) {
                String valueOf = String.valueOf(this);
                Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
            }
        }
        if (tlistener != null) {
            try {
                zzs(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.zzftg = true;
        }
        unregister();
    }

    protected abstract void zzs(TListener tlistener);
}
