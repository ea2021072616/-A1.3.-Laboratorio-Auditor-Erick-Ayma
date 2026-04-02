package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzev;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbr implements View.OnTouchListener {
    private /* synthetic */ zzbp zzaru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbr(zzbp zzbpVar) {
        this.zzaru = zzbpVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        zzev zzevVar;
        zzev zzevVar2;
        zzevVar = this.zzaru.zzars;
        if (zzevVar != null) {
            try {
                zzevVar2 = this.zzaru.zzars;
                zzevVar2.zza(motionEvent);
                return false;
            } catch (RemoteException e) {
                zzafx.zzc("Unable to process ad data", e);
                return false;
            }
        }
        return false;
    }
}
