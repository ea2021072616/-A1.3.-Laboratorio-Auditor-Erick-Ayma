package com.google.android.gms.internal;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzale implements Runnable {
    private /* synthetic */ zzalc zzdib;
    private /* synthetic */ int zzdic;
    private /* synthetic */ int zzdid;
    private /* synthetic */ boolean zzdie;
    private /* synthetic */ boolean zzdif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzale(zzalc zzalcVar, int i, int i2, boolean z, boolean z2) {
        this.zzdib = zzalcVar;
        this.zzdic = i;
        this.zzdid = i2;
        this.zzdie = z;
        this.zzdif = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        zzlb zzlbVar;
        zzlb zzlbVar2;
        zzlb zzlbVar3;
        zzlb zzlbVar4;
        zzlb zzlbVar5;
        zzlb zzlbVar6;
        boolean z3 = false;
        obj = this.zzdib.mLock;
        synchronized (obj) {
            boolean z4 = this.zzdic != this.zzdid;
            z = this.zzdib.zzdhx;
            boolean z5 = !z && this.zzdid == 1;
            boolean z6 = z4 && this.zzdid == 1;
            boolean z7 = z4 && this.zzdid == 2;
            boolean z8 = z4 && this.zzdid == 3;
            boolean z9 = this.zzdie != this.zzdif;
            zzalc zzalcVar = this.zzdib;
            z2 = this.zzdib.zzdhx;
            if (z2 || z5) {
                z3 = true;
            }
            zzalcVar.zzdhx = z3;
            zzlbVar = this.zzdib.zzdhw;
            if (zzlbVar == null) {
                return;
            }
            if (z5) {
                try {
                    zzlbVar2 = this.zzdib.zzdhw;
                    zzlbVar2.onVideoStart();
                } catch (RemoteException e) {
                    zzafx.zzc("Unable to call onVideoStart()", e);
                }
            }
            if (z6) {
                try {
                    zzlbVar3 = this.zzdib.zzdhw;
                    zzlbVar3.onVideoPlay();
                } catch (RemoteException e2) {
                    zzafx.zzc("Unable to call onVideoPlay()", e2);
                }
            }
            if (z7) {
                try {
                    zzlbVar4 = this.zzdib.zzdhw;
                    zzlbVar4.onVideoPause();
                } catch (RemoteException e3) {
                    zzafx.zzc("Unable to call onVideoPause()", e3);
                }
            }
            if (z8) {
                try {
                    zzlbVar5 = this.zzdib.zzdhw;
                    zzlbVar5.onVideoEnd();
                } catch (RemoteException e4) {
                    zzafx.zzc("Unable to call onVideoEnd()", e4);
                }
            }
            if (z9) {
                try {
                    zzlbVar6 = this.zzdib.zzdhw;
                    zzlbVar6.onVideoMute(this.zzdif);
                } catch (RemoteException e5) {
                    zzafx.zzc("Unable to call onVideoMute()", e5);
                }
            }
        }
    }
}
